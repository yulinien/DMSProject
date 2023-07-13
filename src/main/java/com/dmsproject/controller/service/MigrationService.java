package com.dmsproject.controller.service;

import com.dmsproject.controller.pojo.MigrationDTO;
import com.dmsproject.dao.entity.db1.TimeSheet1DO;
import com.dmsproject.dao.entity.db2.TimeSheet2DO;
import com.dmsproject.dao.repo.db1.TimeSheetRepo1;
import com.dmsproject.dao.repo.db2.TimeSheetRepo2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MigrationService {

    private final TimeSheetRepo1 timeSheetRepo1;

    private final TimeSheetRepo2 timeSheetRepo2;

    public MigrationService(TimeSheetRepo1 timeSheetRepo1, TimeSheetRepo2 timeSheetRepo2) {
        this.timeSheetRepo1 = timeSheetRepo1;
        this.timeSheetRepo2 = timeSheetRepo2;
    }

    public MigrationDTO timeSheetMigration() {
        List<TimeSheet1DO> timeSheet1DOList = timeSheetRepo1.findAll();
        if (timeSheet1DOList.isEmpty()) {
            return new MigrationDTO(-1, "dev_db1尚無資料");
        } else {
            for (TimeSheet1DO timeSheet1DO : timeSheet1DOList) {
                TimeSheet2DO timeSheet2DO = new TimeSheet2DO();
                timeSheet2DO.setTimeDiff(timeSheet1DO.getTimeDiff());
                timeSheet2DO.setWorkDate(timeSheet1DO.getWorkDate());
                timeSheet2DO.setAccountId(timeSheet1DO.getAccount1DO().getId());
                timeSheetRepo2.save(timeSheet2DO);
            }
            return new MigrationDTO(1, "資料轉移成功");
        }
    }
}
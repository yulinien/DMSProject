package com.dmsproject.dao.repo.db2;

import com.dmsproject.dao.entity.db2.TimeSheet2DO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSheetRepo2 extends JpaRepository<TimeSheet2DO, Integer> {
}

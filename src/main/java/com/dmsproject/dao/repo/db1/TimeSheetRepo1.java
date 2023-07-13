package com.dmsproject.dao.repo.db1;

import com.dmsproject.dao.entity.db1.TimeSheet1DO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSheetRepo1 extends JpaRepository<TimeSheet1DO, Integer> {
}

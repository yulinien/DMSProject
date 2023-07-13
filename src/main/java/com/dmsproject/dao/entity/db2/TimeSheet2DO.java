package com.dmsproject.dao.entity.db2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "time_sheet")
public class TimeSheet2DO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "work_date")
    private LocalDate workDate;

    @Column(name = "time_diff")
    private Time timeDiff;

    @Column(name = "account_id")
    private Integer accountId;

}

package com.example.umc_workbook.domain.member.entitiy;

import com.example.umc_workbook.domain.member.enums.AlarmType;
import jakarta.persistence.*;

@Entity
public class MemberAlarmSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alarmType")
    private AlarmType alarmType;

    @Column(name = "is_active")
    private boolean isActive;
}

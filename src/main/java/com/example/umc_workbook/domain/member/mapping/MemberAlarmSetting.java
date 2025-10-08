package com.example.umc_workbook.domain.member.mapping;

import com.example.umc_workbook.domain.alarm.Alarm;
import com.example.umc_workbook.domain.member.entitiy.Member;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 주인
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarm_id") // 주인
    private Alarm alarm;
}

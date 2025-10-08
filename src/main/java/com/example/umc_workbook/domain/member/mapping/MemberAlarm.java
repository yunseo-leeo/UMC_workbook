package com.example.umc_workbook.domain.member.mapping;

import com.example.umc_workbook.domain.alarm.Alarm;
import com.example.umc_workbook.domain.member.entitiy.Member;
import jakarta.persistence.*;

@Entity
public class MemberAlarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 주인
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarm_id") // 주인
    private Alarm alarm;
}


}

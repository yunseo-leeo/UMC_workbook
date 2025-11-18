package com.example.umc_workbook.domain.mission.entity;

import com.example.umc_workbook.domain.member.entity.Member;
import com.example.umc_workbook.domain.mission.enums.MissionStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class MemberMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="missionStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 주인
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id") // 주인
    private Mission mission;

}

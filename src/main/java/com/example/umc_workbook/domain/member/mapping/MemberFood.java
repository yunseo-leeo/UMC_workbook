package com.example.umc_workbook.domain.member.mapping;

import com.example.umc_workbook.domain.member.entity.Food;
import com.example.umc_workbook.domain.member.entity.Member;
import jakarta.persistence.*;

@Entity
public class MemberFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 주인
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id") // 주인
    private Food food;
}

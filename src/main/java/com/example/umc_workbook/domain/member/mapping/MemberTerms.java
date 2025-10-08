package com.example.umc_workbook.domain.member.mapping;

import com.example.umc_workbook.domain.member.entitiy.Member;
import com.example.umc_workbook.domain.member.entitiy.Terms;
import jakarta.persistence.*;

@Entity
public class MemberTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 주인
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_id") // 주인
    private Terms terms;
}

package com.example.umc_workbook.domain.member.entitiy;

import com.example.umc_workbook.domain.member.enums.Gender;
import com.example.umc_workbook.domain.member.enums.MemberStatus;
import com.example.umc_workbook.domain.member.enums.SocialType;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @Column(name = "gender",nullable = false)
    private Gender gender;

    @Column(name = "birth", nullable =false)
    private LocalDate birth;

    @Column(name = "address", length = 20, nullable = false)
    private String address;

    @Column(name = "email", length = 30, nullable = false)
    private String email;

    @Column(name = "point")
    private int point;

    @Column(name = "detailAddress", length = 30, nullable = false)
    private String detailAddress;

    @Column(name = "phoneNumber", length = 13)
    private String phoneNumber;

    @Column(name = "MemberStatus", nullable = false)
    private MemberStatus memberStatus;

    @Column(name = "socailType", nullable = false)
    private SocialType socailType;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @CreatedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;



}

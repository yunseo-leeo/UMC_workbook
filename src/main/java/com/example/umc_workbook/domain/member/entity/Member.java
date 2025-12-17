package com.example.umc_workbook.domain.member.entity;

import com.example.umc_workbook.domain.common.AddressType;
import com.example.umc_workbook.domain.member.enums.Gender;
import com.example.umc_workbook.domain.member.enums.MemberStatus;
import com.example.umc_workbook.domain.member.enums.SocialType;
import com.example.umc_workbook.domain.member.mapping.*;
import com.example.umc_workbook.domain.mission.entity.MemberMission;
import com.example.umc_workbook.global.entity.BaseEntity;
import com.example.umc_workbook.global.security.auth.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @Column(name = "gender",nullable = false)
    private Gender gender;

    @Column(name = "birth", nullable =false)
    private LocalDate birth;

    @Column(name = "address", nullable = false)
    private AddressType address;

    @Column(name = "email", length = 30, nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

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

    @OneToMany(mappedBy = "member")
    private List<MemberAlarm> memberAlarm = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberAlarmSetting> memberAlarmSetting = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberFood> memberFood = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberMission> memberMission = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberTerms> memberTerms = new ArrayList<>();

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PhoneVerification phoneVerification;

    @Builder(access = AccessLevel.PRIVATE)
    private Member(
            String name,
            Gender gender,
            LocalDate birth,
            AddressType address,
            String email,
            String password,
            Role role,
            int point,
            String detailAddress,
            String phoneNumber,
            MemberStatus memberStatus,
            SocialType socialType
    ) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
        this.email = email;
        this.password = password;
        this.role = role;
        this.point = point;
        this.detailAddress = detailAddress;
        this.phoneNumber = phoneNumber;
        this.memberStatus = memberStatus;
        this.socailType = socialType;
    }

    public static Member create(
            String name,
            Gender gender,
            LocalDate birth,
            AddressType address,
            String email,
            Role role,
            String encodedPassword,
            String detailAddress,
            String phoneNumber,
            SocialType socialType
    ) {
        return Member.builder()
                .name(name)
                .gender(gender)
                .birth(birth)
                .address(address)
                .email(email)
                .password(encodedPassword)
                .role(role)
                .point(0)
                .detailAddress(detailAddress)
                .phoneNumber(phoneNumber)
                .memberStatus(MemberStatus.ACTIVE)
                .socialType(socialType)
                .build();
    }
}




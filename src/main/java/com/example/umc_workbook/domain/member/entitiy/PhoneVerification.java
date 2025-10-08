package com.example.umc_workbook.domain.member.entitiy;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class PhoneVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_verified", nullable = false)
    private boolean isverified;

    @Column(name = "verified_at", nullable = false)
    private LocalDateTime verifiedAt;
}

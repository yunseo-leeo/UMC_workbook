package com.example.umc_workbook.domain.member.repository;

import com.example.umc_workbook.domain.member.dto.MemberMypageResponseDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository {

    @Query("""
    SELECT new com.example.umc_workbook.domain.member.dto.MemberMypageResponseDto(
        m.name, m.email, m.phoneNumber, m.point
            )
    FROM Member m
    WHERE m.id = :memberId
    """)
    Optional<MemberMypageResponseDto> findMemberMypage(@Param("id") Long id);
}


package com.example.umc_workbook.domain.member.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {

    @Query("""
    SELECT m.name, m.email, m.phoneNumber, m.point
    FROM Member m
    WHERE m.id = :id
    """)
    List<Object[]> findMemberMypageById(@Param("id") Long id);
}


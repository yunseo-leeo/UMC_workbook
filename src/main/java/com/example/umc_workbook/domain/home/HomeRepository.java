package com.example.umc_workbook.domain.home;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface HomeRepository {


    @Query("""
        SELECT 
            m.id,
            m.content,
            m.point,
            s.name,
            s.address
        FROM Mission m
        JOIN m.store s
        LEFT JOIN MemberMission um
            ON um.mission = m AND um.member.id = :memberId
        WHERE s.address = :address
        AND um.id IS NULL
        AND (
            :cursorPoint IS NULL
            OR (m.point < :cursorPoint)
            OR (m.point = :cursorPoint AND m.createdAt < :cursorCreatedAt)
            OR (m.point = :cursorPoint AND m.createdAt = :cursorCreatedAt AND m.id < :cursorId)
        )
    ORDER BY m.point DESC, m.createdAt DESC, m.id DESC
    """)
    List<Object[]> findHomePage(
            @Param("memberId") Long memberId,
            @Param("address") String address,
            @Param("cursorPoint") Integer cursorPoint,
            @Param("cursorCreatedAt") LocalDateTime cursorCreatedAt,
            @Param("cursorId") Long cursorId,
            Pageable pageable
    );
}

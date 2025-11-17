package com.example.umc_workbook.domain.home;

import com.example.umc_workbook.domain.home.dto.HomeRequestDto;
import com.example.umc_workbook.domain.home.dto.HomeResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HomeRepository{


    @Query("""
        SELECT new com.example.umc_workbook.domain.home.dto.HomeResponseDto(
            m.id,
            m.content,
            m.point,
            s.name,
            s.address
                )
        FROM Mission m
        JOIN m.store s
        LEFT JOIN MemberMission um
            ON um.mission = m AND um.member.id = :memberId
        WHERE s.address = :#{#req.address}
        AND um.id IS NULL
        AND (
            :#{#req.cursorPoint} IS NULL
            OR (m.point < :#{#req.cursorPoint})
            OR (m.point = :#{#req.cursorPoint} AND m.createdAt < :#{#req.cursorCreatedAt})
            OR (m.point = :#{#req.cursorPoint} AND m.createdAt = :#{#req.cursorCreatedAt} AND m.id < :#{#req.cursorId})
        )
    ORDER BY m.point DESC, m.createdAt DESC, m.id DESC
    """)
    List<HomeResponseDto> findHomePage(
            @Param("memberId") Long memberId,
            @Param("req") HomeRequestDto req,
            Pageable pageable
    );
}

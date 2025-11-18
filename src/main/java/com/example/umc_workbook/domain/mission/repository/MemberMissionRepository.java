package com.example.umc_workbook.domain.mission.repository;

import com.example.umc_workbook.domain.mission.dto.MemberMissionRequestDto;
import com.example.umc_workbook.domain.mission.dto.MemberMissionResponseDto;
import com.example.umc_workbook.domain.mission.entity.MemberMission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    @Query("""
    SELECT new com.example.umc_workbook.domain.member.dto.MemberMissionResponseDto(
        m.id,m.content,m.point, s.name, s.address, um.missionStatus, um.createdAt
        )
    FROM MemberMission um
    JOIN FETCH um.mission m
    JOIN FETCH m.store s
    WHERE um.member.id = :userId
      AND um.missionStatus IN (
          com.example.umc_workbook.domain.member.enums.MissionStatus.IN_PROGRESS,
          com.example.umc_workbook.domain.member.enums.MissionStatus.COMPLETED
      )
      AND (
            :#{#req.cursorPoint} IS NULL
            OR (m.point < :#{#req.cursorPoint})
            OR (m.point = :#{#req.cursorPoint} AND um.createdAt < :#{#req.cursorCreatedAt})
            OR (m.point = :#{#req.cursorPoint} AND um.createdAt = :#{#req.cursorCreatedAt} AND um.id < :#{#req.cursorId})
    )
    ORDER BY m.point DESC, um.createdAt DESC, um.id DESC
    """)
    List<MemberMissionResponseDto> findMemberMissions(
            @Param("memberId") Long memberId,
            @Param("req") MemberMissionRequestDto req,
            Pageable pageable
    );
}

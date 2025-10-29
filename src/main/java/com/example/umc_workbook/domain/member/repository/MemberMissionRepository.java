package com.example.umc_workbook.domain.member.repository;

import com.example.umc_workbook.domain.member.enums.MissionStatus;
import com.example.umc_workbook.domain.member.mapping.MemberMission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import static com.example.umc_workbook.domain.member.enums.MissionStatus.*;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    @Query("""
    SELECT um
    FROM MemberMission um
    JOIN FETCH um.mission m
    JOIN FETCH m.store s
    WHERE um.member.id = :userId
      AND um.missionStatus IN (
          com.example.umc_workbook.domain.member.enums.MissionStatus.IN_PROGRESS,
          com.example.umc_workbook.domain.member.enums.MissionStatus.COMPLETED
      )
      AND (
            :cursorPoint IS NULL
            OR (m.point < :cursorPoint)
            OR (m.point = :cursorPoint AND um.createdAt < :cursorCreatedAt)
            OR (m.point = :cursorPoint AND um.createdAt = :cursorCreatedAt AND um.id < :cursorId)
    )
    ORDER BY m.point DESC, um.createdAt DESC, um.id DESC
    """)
    List<MemberMission> findUserMissionsWithCursor(
            @Param("userId") Long userId,
            @Param("cursorPoint") Integer cursorPoint,
            @Param("cursorCreatedAt") LocalDateTime cursorCreatedAt,
            @Param("cursorId") Long cursorId,
            Pageable pageable
    );
}

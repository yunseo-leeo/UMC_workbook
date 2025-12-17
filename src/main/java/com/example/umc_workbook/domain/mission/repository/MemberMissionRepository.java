package com.example.umc_workbook.domain.mission.repository;

import com.example.umc_workbook.domain.mission.dto.MemberMissionRequestDto;
import com.example.umc_workbook.domain.mission.dto.MemberMissionResponseDto;
import com.example.umc_workbook.domain.mission.entity.MemberMission;
import com.example.umc_workbook.domain.mission.entity.Mission;
import com.example.umc_workbook.domain.mission.enums.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Page<MemberMission> findByMemberIdAndMissionStatus(Long memberId, MissionStatus status, Pageable pageable);

    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}

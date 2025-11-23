package com.example.umc_workbook.domain.mission.service;

import com.example.umc_workbook.domain.mission.dto.MemberMissionRequestDto;
import com.example.umc_workbook.domain.mission.dto.MemberMissionResponseDto;
import com.example.umc_workbook.domain.mission.exception.MemberMissionException;
import com.example.umc_workbook.domain.mission.repository.MemberMissionRepository;
import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    public List<MemberMissionResponseDto> findMemberMissions(Long memberId, MemberMissionRequestDto req) {

        if (memberId == null) {
            throw new MemberMissionException(GeneralErrorCode.UNAUTHORIZED);
        }

        List<MemberMissionResponseDto> missions = memberMissionRepository.findMemberMissions(memberId, req, req.toPageable());

        if (missions.isEmpty()) {
            throw new MemberMissionException(GeneralErrorCode.NOT_FOUND);
        }

        return missions;
    }
}

package com.example.umc_workbook.domain.mission.service;

import com.example.umc_workbook.domain.member.exception.MemberErrorCode;
import com.example.umc_workbook.domain.member.exception.MemberException;
import com.example.umc_workbook.domain.member.repository.MemberRepository;
import com.example.umc_workbook.domain.mission.converter.MemberMissionConverter;
import com.example.umc_workbook.domain.mission.dto.MissionResDto;
import com.example.umc_workbook.domain.mission.entity.MemberMission;
import com.example.umc_workbook.domain.mission.enums.MissionStatus;
import com.example.umc_workbook.domain.mission.exception.MemberMissionErrorCode;
import com.example.umc_workbook.domain.mission.exception.MemberMissionException;
import com.example.umc_workbook.domain.mission.repository.MemberMissionRepository;
import com.example.umc_workbook.global.config.PaginationConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    public MissionResDto.MemberMissionListDto findMemberMissions(Long memberId, Integer page) {

        if(!memberRepository.existsById(memberId)) {
            throw new MemberException(MemberErrorCode.MEMBER_NOT_FOUND);
        }

        PageRequest pageRequest = PageRequest.of(page-1, PaginationConstants.DEFAULT_PAGE_SIZE);
        Page<MemberMission> result = memberMissionRepository.findByMemberIdAndMissionStatus(memberId, MissionStatus.IN_PROGRESS, pageRequest);

        if (result.isEmpty()) {
            throw new MemberMissionException(MemberMissionErrorCode.MEMBER_MISSION_NOT_FOUND);
        }
        return MemberMissionConverter.toMemberMissionListDto(result);
    }
}

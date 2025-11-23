package com.example.umc_workbook.domain.mission.service;

import com.example.umc_workbook.domain.member.entity.Member;
import com.example.umc_workbook.domain.member.exception.MemberException;
import com.example.umc_workbook.domain.member.repository.MemberRepository;
import com.example.umc_workbook.domain.mission.entity.MemberMission;
import com.example.umc_workbook.domain.mission.entity.Mission;
import com.example.umc_workbook.domain.mission.exception.MissionException;
import com.example.umc_workbook.domain.mission.repository.MemberMissionRepository;
import com.example.umc_workbook.domain.mission.repository.MissionRepository;
import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionService {

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;

    public void startMission(Long memberId, Long missionId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(GeneralErrorCode.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionException(GeneralErrorCode.MISSION_NOT_FOUND));

        if(memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId)) {
            throw new MissionException(GeneralErrorCode.MISSION_ALREADY_CHALLENGING);
        }

        MemberMission mm = MemberMission.create(member, mission);
        memberMissionRepository.save(mm);
    }
}

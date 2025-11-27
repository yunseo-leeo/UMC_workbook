package com.example.umc_workbook.domain.mission.controller;

import com.example.umc_workbook.domain.mission.dto.MissionResDto;
import com.example.umc_workbook.domain.mission.service.MemberMissionQueryService;
import com.example.umc_workbook.global.annotation.ValidPage;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import com.example.umc_workbook.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
public class MemberMissionQueryController implements MemberMissionQueryControllerDocs {

    private final MemberMissionQueryService memberMissionQueryService;

    @Override
    public ApiResponse<MissionResDto.MemberMissionListDto> findMemberMissions(
            @PathVariable Long memberId,
            @RequestParam(value = "page", defaultValue = "1") @ValidPage Integer page
            ) {
        MissionResDto.MemberMissionListDto myMissionList = memberMissionQueryService.findMemberMissions(memberId, page);
        return ApiResponse.onSuccess(
                GeneralSuccessCode.FETCHED,
                myMissionList
        );
    }
}

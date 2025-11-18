package com.example.umc_workbook.domain.member.controller;

import com.example.umc_workbook.domain.mission.dto.MemberMissionRequestDto;
import com.example.umc_workbook.domain.mission.dto.MemberMissionResponseDto;
import com.example.umc_workbook.domain.mission.service.MemberMissionQueryService;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import com.example.umc_workbook.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MemberMissionQueryController {

    private final MemberMissionQueryService memberMissionQueryService;

    @GetMapping("/my")
    public ApiResponse<List<MemberMissionResponseDto>> findMemberMissions(
            @AuthenticationPrincipal(expression = "id") Long MemberId,
            @ModelAttribute MemberMissionRequestDto req
            ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.FETCHED,
                memberMissionQueryService.findMemberMissions(MemberId, req)
        );
    }
}

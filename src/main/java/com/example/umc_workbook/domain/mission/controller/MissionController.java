package com.example.umc_workbook.domain.mission.controller;

import com.example.umc_workbook.domain.member.exception.MemberException;
import com.example.umc_workbook.domain.mission.exception.MissionException;
import com.example.umc_workbook.domain.mission.service.MissionService;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import com.example.umc_workbook.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;
//
//    @PostMapping("/{missionId}/start")
//    public ApiResponse<Void> startMission(
//            @AuthenticationPrincipal(expression = "id") Long memberId,
//            @PathVariable Long missionId
//    ){
//        missionService.startMission(memberId, missionId);
//        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, null);
//    }
}

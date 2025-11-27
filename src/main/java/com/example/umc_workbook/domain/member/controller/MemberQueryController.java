package com.example.umc_workbook.domain.member.controller;

import com.example.umc_workbook.domain.member.dto.MemberMypageResponseDto;
import com.example.umc_workbook.domain.member.service.MemberQueryService;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import com.example.umc_workbook.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberQueryController {

    private final MemberQueryService memberQueryService;

    @GetMapping("{memberId}/mypage")
    public ApiResponse<MemberMypageResponseDto> findMemberMypage(
            @PathVariable Long memberId
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.FETCHED,
                memberQueryService.getMemberMypage(memberId)
        );
    }
}

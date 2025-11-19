package com.example.umc_workbook.domain.home.controller;

import com.example.umc_workbook.domain.home.dto.HomeRequestDto;
import com.example.umc_workbook.domain.home.dto.HomeResponseDto;
import com.example.umc_workbook.domain.home.service.HomeQueryService;
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
@RequestMapping("/api/home")
public class HomeQueryController {

    private final HomeQueryService homeQueryService;

    @GetMapping
    public ApiResponse<List<HomeResponseDto>> findHomePage(
            @AuthenticationPrincipal(expression = "id") Long memberId,
            @ModelAttribute HomeRequestDto requestDto
            ){
        return ApiResponse.onSuccess(
                GeneralSuccessCode.FETCHED,
                homeQueryService.findHomePage(memberId, requestDto)
        );
    }

}

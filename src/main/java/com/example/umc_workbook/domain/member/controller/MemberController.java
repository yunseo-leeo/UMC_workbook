package com.example.umc_workbook.domain.member.controller;

import com.example.umc_workbook.domain.member.dto.MemberReqDto;
import com.example.umc_workbook.domain.member.dto.MemberResDto;
import com.example.umc_workbook.domain.member.service.MemberService;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import com.example.umc_workbook.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ApiResponse<MemberResDto.JoinDto> signUp(
            @RequestBody MemberReqDto.JoinDto dto
    ){
       MemberResDto.JoinDto resDto = memberService.signUp(dto);
       return ApiResponse.onSuccess(
               GeneralSuccessCode.CREATED,
               resDto
       );
    }

    @PostMapping("/login")
    public ApiResponse<MemberResDto.LoginDto> login(
            @RequestBody @Valid MemberReqDto.LoginDto dto
    ){
        MemberResDto.LoginDto resDto = memberService.logIn(dto);
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                resDto
        );
    }
}

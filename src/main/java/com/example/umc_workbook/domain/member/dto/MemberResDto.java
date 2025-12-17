package com.example.umc_workbook.domain.member.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class MemberResDto {

    @Builder
    public record JoinDto(
            Long memberId,
            LocalDateTime createAt
    ){}

    @Builder
    public record LoginDto(
            Long memberId,
            String accessToken
    ){}
}

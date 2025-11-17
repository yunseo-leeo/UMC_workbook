package com.example.umc_workbook.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberMypageResponseDto {

    private String memberName;
    private String memberEmail;
    private String memberPhoneNumber;
    private Integer point;
}

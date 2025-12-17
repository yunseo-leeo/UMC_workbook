package com.example.umc_workbook.domain.member.dto;

import com.example.umc_workbook.domain.common.AddressType;
import com.example.umc_workbook.domain.member.enums.Gender;
import com.example.umc_workbook.domain.member.enums.SocialType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDate;

public class MemberReqDto {

    @Builder
    public record JoinDto(
            String name,
            Gender gender,
            LocalDate birth,
            AddressType addressType,
            String detailAddress,
            String phoneNumber,
            @Email
            String email,
            String password,
            SocialType socialType
    ){}

    public record LoginDto(
            @NotBlank
            String email,
            @NotBlank
            String password
    ){}
}

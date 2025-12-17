package com.example.umc_workbook.domain.member.converter;

import com.example.umc_workbook.domain.member.dto.MemberReqDto;
import com.example.umc_workbook.domain.member.dto.MemberResDto;
import com.example.umc_workbook.domain.member.entity.Member;
import com.example.umc_workbook.global.security.auth.Role;

public class MemberConverter {

    public static MemberResDto.JoinDto toJoinDTO(
            Member member
    ){
        return MemberResDto.JoinDto.builder()
                .memberId(member.getId())
                .createAt(member.getCreatedAt())
                .build();
    }

    // DTO -> Entity
    public static Member toMember(
            MemberReqDto.JoinDto dto,
            String encodedPassword,
            Role role
    ){
        return Member.create(
                dto.name(),
                dto.gender(),
                dto.birth(),
                dto.addressType(),
                dto.email(),
                role,
                encodedPassword,
                dto.detailAddress(),
                dto.phoneNumber(),
                dto.socialType()
        );
    }

    public static MemberResDto.LoginDto toLoginDTO(
            Member member,
            String accessToken){
        return MemberResDto.LoginDto.builder()
                .memberId(member.getId())
                .accessToken(accessToken)
                .build();
    }
}

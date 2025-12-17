package com.example.umc_workbook.domain.member.service;

import com.example.umc_workbook.domain.member.converter.MemberConverter;
import com.example.umc_workbook.domain.member.dto.MemberReqDto;
import com.example.umc_workbook.domain.member.dto.MemberResDto;
import com.example.umc_workbook.domain.member.entity.Member;
import com.example.umc_workbook.domain.member.exception.MemberErrorCode;
import com.example.umc_workbook.domain.member.exception.MemberException;
import com.example.umc_workbook.domain.member.repository.MemberRepository;
import com.example.umc_workbook.global.security.CustomUserDetails;
import com.example.umc_workbook.global.security.JwtUtil;
import com.example.umc_workbook.global.security.auth.Role;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public MemberResDto.JoinDto signUp(
            MemberReqDto.JoinDto reqDto
    ){
        String salt = passwordEncoder.encode(reqDto.password());
        Member member = MemberConverter.toMember(reqDto, salt, Role.ROLE_USER);
        memberRepository.save(member);

        return MemberConverter.toJoinDTO(member);
    }

    public MemberResDto.LoginDto logIn(MemberReqDto.@Valid LoginDto dto) {
        Member member = memberRepository.findByEmail(dto.email())
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));
        if (!passwordEncoder.matches(dto.password(), member.getPassword())){
            throw new MemberException(MemberErrorCode.INVALID);
        }

        CustomUserDetails userDetails = new CustomUserDetails(member);

        String accessToken = jwtUtil.createAccessToken(userDetails);

        return MemberConverter.toLoginDTO(member, accessToken);
    }
}

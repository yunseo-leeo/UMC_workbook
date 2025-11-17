package com.example.umc_workbook.domain.member.service;

import com.example.umc_workbook.domain.member.dto.MemberMypageResponseDto;
import com.example.umc_workbook.domain.member.exception.MemberException;
import com.example.umc_workbook.domain.member.repository.MemberRepository;
import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import com.example.umc_workbook.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryService {

    private final MemberRepository memberRepository;

    public MemberMypageResponseDto getMemberMypage(Long memberId) {
        if (memberId == null) {
            throw new MemberException(GeneralErrorCode.UNAUTHORIZED);
        }

        return memberRepository.findMemberMypage(memberId)
                .orElseThrow(() ->new MemberException(GeneralErrorCode.NOT_FOUND));
    }
}

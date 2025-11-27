package com.example.umc_workbook.domain.member.exception;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {

    //회원 에러
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_4041", "해당 회원을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

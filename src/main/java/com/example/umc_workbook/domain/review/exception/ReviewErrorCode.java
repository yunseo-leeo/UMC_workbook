package com.example.umc_workbook.domain.review.exception;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST,"G001", "해당 회원을 찾을 수 없습니다."),
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND,"G002", "리뷰를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

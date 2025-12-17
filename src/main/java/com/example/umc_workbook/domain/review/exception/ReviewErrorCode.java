package com.example.umc_workbook.domain.review.exception;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {

    //리뷰 에러
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW_4041", "해당 리뷰를 찾을 수 없습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;


}

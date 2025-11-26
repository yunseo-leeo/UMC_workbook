package com.example.umc_workbook.domain.common;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AddressErrorCode implements BaseErrorCode {

    //주소 에러
    INVALID_ADDRESS(HttpStatus.BAD_REQUEST, "ADDRESS_4001", "잘못된 지역 코드입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;


}

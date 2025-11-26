package com.example.umc_workbook.domain.store.exception;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StoreErrorCode implements BaseErrorCode {

    //가게 에러
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE_4041", "해당 가게를 찾을 수 없습니다."),
    EMPTY_DETAIL_ADDRESS(HttpStatus.BAD_REQUEST, "STORE_4001", "상세 주소가 비어 있습니다."),
    EMPTY_STORE_NAME(HttpStatus.BAD_REQUEST, "STORE_4002", "가게 이름이 비어 있습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

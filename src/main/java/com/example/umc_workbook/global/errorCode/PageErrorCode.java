package com.example.umc_workbook.global.errorCode;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum PageErrorCode implements BaseErrorCode {

    INVALID_PAGE(HttpStatus.BAD_REQUEST, "PAGE_4001", "페이지는 1 이상이어야 합니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}

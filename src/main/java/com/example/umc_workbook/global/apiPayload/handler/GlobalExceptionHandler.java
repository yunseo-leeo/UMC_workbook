package com.example.umc_workbook.global.apiPayload.handler;

import com.example.umc_workbook.global.apiPayload.ApiResponse;
import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import com.example.umc_workbook.global.apiPayload.exception.GeneralException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneralException(GeneralException ex) {
        BaseErrorCode code = ex.getCode();
        return ResponseEntity
                .status(code.getStatus())
                .body(ApiResponse.onFailure(code, null));
    }

    // 정의되지 않은 예외
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleUnexpectedException(Exception ex) {
        BaseErrorCode code = GeneralErrorCode.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(code.getStatus())
                .body(ApiResponse.onFailure(code, ex.getMessage()));
    }
}

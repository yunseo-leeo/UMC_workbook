package com.example.umc_workbook.domain.home.exception;


import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import com.example.umc_workbook.global.apiPayload.exception.GeneralException;

public class HomeException extends GeneralException {

    public HomeException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

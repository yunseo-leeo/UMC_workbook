package com.example.umc_workbook.domain.common;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import com.example.umc_workbook.global.apiPayload.exception.GeneralException;

public class AddressException extends GeneralException {
    public AddressException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

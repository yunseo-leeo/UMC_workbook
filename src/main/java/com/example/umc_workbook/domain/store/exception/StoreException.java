package com.example.umc_workbook.domain.store.exception;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import com.example.umc_workbook.global.apiPayload.exception.GeneralException;
import lombok.AllArgsConstructor;
import lombok.Getter;


public class StoreException extends GeneralException {

    public StoreException(BaseErrorCode code) {
        super(code);
    }
}

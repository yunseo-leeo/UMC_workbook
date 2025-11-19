package com.example.umc_workbook.domain.review.exception;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import com.example.umc_workbook.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {

    public ReviewException(BaseErrorCode errorCode) {
        super(errorCode);
    }

}

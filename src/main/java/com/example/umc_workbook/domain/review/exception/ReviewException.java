package com.example.umc_workbook.domain.review.exception;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import com.example.umc_workbook.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {

    public ReviewException(BaseErrorCode code) {
        super(code);
    }

    public static ReviewException memberNotFound() {
        return new ReviewException(GeneralErrorCode.MEMBER_NOT_FOUND);
    }

    public static ReviewException reviewNotFound() {
        return new ReviewException(GeneralErrorCode.REVIEW_NOT_FOUND);
    }
}

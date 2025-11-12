package com.example.umc_workbook.domain.member.exception;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import com.example.umc_workbook.global.apiPayload.exception.GeneralException;

public class MemberException extends GeneralException {
    public MemberException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

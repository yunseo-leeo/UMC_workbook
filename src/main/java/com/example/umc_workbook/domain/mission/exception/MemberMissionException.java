package com.example.umc_workbook.domain.mission.exception;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import com.example.umc_workbook.global.apiPayload.exception.GeneralException;

public class MemberMissionException extends GeneralException {

    public MemberMissionException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

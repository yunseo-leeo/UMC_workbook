package com.example.umc_workbook.domain.mission.exception;

import com.example.umc_workbook.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {

    //미션 에러
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION_4041", "해당 미션을 찾을 수 없습니다."),
    INVALID_POINT(HttpStatus.BAD_REQUEST, "MISSION_4002", "유효하지 않은 포인트 값입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

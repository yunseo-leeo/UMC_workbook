package com.example.umc_workbook.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralErrorCode implements BaseErrorCode {

    BAD_REQUEST(HttpStatus.BAD_REQUEST,
            "COMMON400_1",
            "잘못된 요청입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED,
            "AUTH401_1",
            "인증이 필요합니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN,
            "AUTH403_1",
            "요청이 거부되었습니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND,
            "COMMON404_1",
            "요청한 리소스를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,
            "COMMON500_1",
            "예기치 않은 서버 에러가 발생했습니다."),
    VALID_FAIL(HttpStatus.BAD_REQUEST,
            "COMMON400_2",
            "검증에 실패하였습니다."),

    //회원 에러
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_4041", "해당 회원을 찾을 수 없습니다."),

    //가게 에러
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE_4041", "해당 가게를 찾을 수 없습니다."),
    EMPTY_DETAIL_ADDRESS(HttpStatus.BAD_REQUEST, "STORE_4001", "상세 주소가 비어 있습니다."),
    EMPTY_STORE_NAME(HttpStatus.BAD_REQUEST, "STORE_4002", "가게 이름이 비어 있습니다."),

    //미션 에러
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION_4041", "해당 미션을 찾을 수 없습니다."),
    MISSION_ALREADY_CHALLENGING(HttpStatus.BAD_REQUEST, "MISSION_4001", "이미 도전 중인 미션입니다."),
    INVALID_POINT(HttpStatus.BAD_REQUEST, "MISSION_4002", "유효하지 않은 포인트 값입니다."),

    //주소 에러
    INVALID_ADDRESS(HttpStatus.BAD_REQUEST, "ADDRESS_4001", "잘못된 지역 코드입니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}

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
    //회원 에러
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_4041", "해당 회원을 찾을 수 없습니다."),

    //리뷰 에러
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW_4041", "해당 리뷰를 찾을 수 없습니다."),

    //가게 에러
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE_4041", "해당 가게를 찾을 수 없습니다."),

    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}

package com.example.umc_workbook.domain.common;

import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum AddressType {

    //예시로 서울 특정 구만 추가
    GANGNAM("GN", "서울 강남구"),
    GANGDONG("GD", "서울 강동구"),
    SONGPA("SP", "서울 송파구"),
    MAPO("MP", "서울 마포구"),
    YONGSAN("YS", "서울 용산구")
    ;

    private final String code;
    private final String description;

    //받은 코드와 일치하면 findFirst로 반환, 없다면 예외 처리
    public static AddressType fromCode(String code) {
        return Arrays.stream(values())
                .filter(r -> r.getCode().equals(code))
                .findFirst()
                .orElseThrow(()-> new AddressException(GeneralErrorCode.INVALID_ADDRESS));
    }


}

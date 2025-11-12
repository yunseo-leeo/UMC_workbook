package com.example.umc_workbook.domain.home.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class HomeResponseDto {

    private Long missionId;
    private String content;
    private int point;
    private String storeName;
    private String address;

}

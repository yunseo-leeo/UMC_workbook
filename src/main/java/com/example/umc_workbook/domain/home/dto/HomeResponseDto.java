package com.example.umc_workbook.domain.home.dto;

import com.example.umc_workbook.domain.common.AddressType;
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
    private AddressType address;

}

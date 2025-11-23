package com.example.umc_workbook.domain.store.dto;

import com.example.umc_workbook.domain.common.AddressType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StoreCreateRequestDto {

    private String name;

    private String category;

    private AddressType address;

    private String detailAddress;
}

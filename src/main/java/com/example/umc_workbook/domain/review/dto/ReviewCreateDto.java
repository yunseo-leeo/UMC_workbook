package com.example.umc_workbook.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewCreateDto {

    private Long storeId;
    private Double score;
    private String content;
}

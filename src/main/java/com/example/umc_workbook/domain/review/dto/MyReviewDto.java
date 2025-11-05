package com.example.umc_workbook.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MyReviewDto {

    private final Long reviewId;
    private final String storeName;
    private final String content;
    private final BigDecimal score;
    private final LocalDateTime createdAt;
}

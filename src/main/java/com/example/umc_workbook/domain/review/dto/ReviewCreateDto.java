package com.example.umc_workbook.domain.review.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import jakarta.validation.constraints.NotNull;


@Getter
@AllArgsConstructor
public class ReviewCreateDto {

    @NotNull
    private Long storeId;

    @NotNull
    @Min(0)
    @Max(5)
    private Double score;

    private String content;
}

package com.example.umc_workbook.domain.review.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewResDTO {

    @Builder
    public record MyReviewListDto(
            List<MyReviewDto> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record MyReviewDto(
            String storeName,
            String content,
            BigDecimal score,
            LocalDateTime createdAt
    ){}
}

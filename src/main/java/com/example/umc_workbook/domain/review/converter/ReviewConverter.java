package com.example.umc_workbook.domain.review.converter;

import com.example.umc_workbook.domain.review.dto.ReviewResDTO;
import com.example.umc_workbook.domain.review.entity.Review;
import org.springframework.data.domain.Page;

public class ReviewConverter {

    public static ReviewResDTO.MyReviewListDto toMyReviewListDto(Page<Review> result){
        return ReviewResDTO.MyReviewListDto.builder()
                .reviewList(result.map(ReviewConverter::toMyReviewDto).toList())
                .listSize(result.getNumberOfElements())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static ReviewResDTO.MyReviewDto toMyReviewDto(Review review){
        return ReviewResDTO.MyReviewDto.builder()
                .storeName(review.getStore().getName())
                .content(review.getContent())
                .score(review.getScore())
                .createdAt(review.getCreatedAt())
                .build();
    }
}

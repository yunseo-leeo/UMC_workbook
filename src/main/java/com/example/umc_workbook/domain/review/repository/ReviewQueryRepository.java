package com.example.umc_workbook.domain.review.repository;

import com.example.umc_workbook.domain.review.dto.MyReviewDto;
import com.example.umc_workbook.domain.review.enums.ReviewSort;

import java.util.List;

public interface ReviewQueryRepository {

    List<MyReviewDto> findMyReviews(Long memberId, ReviewSort sort);
}

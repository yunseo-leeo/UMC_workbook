package com.example.umc_workbook.domain.review.service;

import com.example.umc_workbook.domain.review.dto.MyReviewDto;
import com.example.umc_workbook.domain.review.enums.ReviewSort;
import com.example.umc_workbook.domain.review.repository.ReviewQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewQueryRepository reviewQueryRepository;

    public List<MyReviewDto> findMyReviews(Long memberId, ReviewSort sort) {
        return reviewQueryRepository.findMyReviews(memberId, sort);
    }
}

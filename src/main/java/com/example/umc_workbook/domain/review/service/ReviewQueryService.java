package com.example.umc_workbook.domain.review.service;

import com.example.umc_workbook.domain.review.converter.ReviewConverter;
import com.example.umc_workbook.domain.review.dto.ReviewResDTO;
import com.example.umc_workbook.domain.review.entity.Review;
import com.example.umc_workbook.domain.review.exception.ReviewErrorCode;
import com.example.umc_workbook.domain.review.exception.ReviewException;
import com.example.umc_workbook.domain.review.repository.ReviewQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewQueryService {

    private final ReviewQueryRepository reviewQueryRepository;

    @Transactional(readOnly = true)
    public ReviewResDTO.MyReviewListDto findMyReviews(Long memberId, Integer page) {


        PageRequest pageRequest = PageRequest.of(page-1, 10);
        Page<Review> result = reviewQueryRepository.findAllByMember_Id(memberId, pageRequest);

        if(result.isEmpty()) {
            throw new ReviewException(ReviewErrorCode.REVIEW_NOT_FOUND);
        }

        return ReviewConverter.toMyReviewListDto(result);
    }
}

package com.example.umc_workbook.domain.review.service;

import com.example.umc_workbook.domain.review.dto.ReviewCreateDto;
import com.example.umc_workbook.domain.review.entity.Review;
import com.example.umc_workbook.domain.review.exception.ReviewErrorCode;
import com.example.umc_workbook.domain.review.exception.ReviewException;
import com.example.umc_workbook.domain.review.repository.ReviewRepository;
import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public void insertReview(Long memberId, ReviewCreateDto req) {

        if (memberId == null) {
            throw new ReviewException(ReviewErrorCode.MEMBER_NOT_FOUND);
        }

        if(req.getScore() < 0 || req.getScore() >5){
            throw new ReviewException(GeneralErrorCode.BAD_REQUEST);
        }

        reviewRepository.insertReview(memberId, req);
    }
}

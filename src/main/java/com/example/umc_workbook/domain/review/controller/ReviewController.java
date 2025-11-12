package com.example.umc_workbook.domain.review.controller;

import com.example.umc_workbook.domain.review.dto.ReviewCreateDto;
import com.example.umc_workbook.domain.review.repository.ReviewRepository;
import com.example.umc_workbook.domain.review.service.ReviewService;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import com.example.umc_workbook.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<Void> insertReview(
            @AuthenticationPrincipal(expression = "id") Long memberId,
            @RequestBody ReviewCreateDto req
            ){
        reviewService.insertReview(memberId, req);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, null);
    }
}

package com.example.umc_workbook.domain.review.controller;

import com.example.umc_workbook.domain.member.exception.MemberException;
import com.example.umc_workbook.domain.review.dto.ReviewCreateDto;
import com.example.umc_workbook.domain.review.repository.ReviewRepository;
import com.example.umc_workbook.domain.review.service.ReviewService;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import com.example.umc_workbook.global.apiPayload.code.GeneralSuccessCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<Void> insertReview(
            @AuthenticationPrincipal(expression = "id") Long memberId,
            @RequestBody @Valid ReviewCreateDto req
            ){
        if (memberId == null) {
            throw new MemberException(GeneralErrorCode.MEMBER_NOT_FOUND);
        }

        reviewService.insertReview(memberId, req);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, null);
    }
}

package com.example.umc_workbook.domain.review.controller;

import com.example.umc_workbook.domain.review.dto.ReviewResDto;
import com.example.umc_workbook.domain.review.service.ReviewQueryService;
import com.example.umc_workbook.global.annotation.ValidPage;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import com.example.umc_workbook.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewQueryController implements ReviewQueryControllerDocs {

    private final ReviewQueryService reviewQueryService;

    @Override
    public ApiResponse<ReviewResDto.MyReviewListDto> getMyReviews(
            @PathVariable Long memberId,
            @RequestParam("page") @ValidPage Integer page
    ) {
        ReviewResDto.MyReviewListDto myReviewList = reviewQueryService.findMyReviews(memberId, page);
        return ApiResponse.onSuccess(
                GeneralSuccessCode.FETCHED,
                myReviewList
        );
    }
}

package com.example.umc_workbook.domain.review.controller;

import com.example.umc_workbook.domain.review.dto.MyReviewDto;
import com.example.umc_workbook.domain.review.enums.ReviewSort;
import com.example.umc_workbook.domain.review.service.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/reviews")
public class ReviewQueryController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/my")
    public List<MyReviewDto> getMyReviews(
            @AuthenticationPrincipal(expression = "id") Long memberId,
            @RequestParam(defaultValue = "SCORE")ReviewSort sort
    ) {
        return reviewQueryService.findMyReviews(memberId, sort);
    }
}

package com.example.umc_workbook.domain.review.controller;

import com.example.umc_workbook.domain.review.dto.ReviewResDto;
import com.example.umc_workbook.global.annotation.ValidPage;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewQueryControllerDocs {

    @Operation(
            summary = "내가 쓴 리뷰 목록 조회 API",
            description = "로그인된 회원이 쓴 리뷰를 모두 조회합니다. 페이지네이션 방식으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "대상이 존재하지 않음")

    })
    ApiResponse<ReviewResDto.MyReviewListDto> getMyReviews(
            @PathVariable Long memberId,
            @RequestParam(value = "page", defaultValue = "1") @ValidPage Integer page
    );
}

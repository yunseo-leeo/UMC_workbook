package com.example.umc_workbook.domain.review.service;

import com.example.umc_workbook.domain.member.exception.MemberErrorCode;
import com.example.umc_workbook.domain.member.exception.MemberException;
import com.example.umc_workbook.domain.member.repository.MemberRepository;
import com.example.umc_workbook.domain.review.converter.ReviewConverter;
import com.example.umc_workbook.domain.review.dto.ReviewResDto;
import com.example.umc_workbook.domain.review.entity.Review;
import com.example.umc_workbook.domain.review.exception.ReviewErrorCode;
import com.example.umc_workbook.domain.review.exception.ReviewException;
import com.example.umc_workbook.domain.review.repository.ReviewQueryRepository;
import com.example.umc_workbook.global.config.PaginationConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryService {

    private final ReviewQueryRepository reviewQueryRepository;
    private final MemberRepository memberRepository;

    public ReviewResDto.MyReviewListDto findMyReviews(Long memberId, Integer page) {

        if(!memberRepository.existsById(memberId)) {
            throw new MemberException(MemberErrorCode.MEMBER_NOT_FOUND);
        }

        PageRequest pageRequest = PageRequest.of(page-1, PaginationConstants.DEFAULT_PAGE_SIZE);
        Page<Review> result = reviewQueryRepository.findAllByMember_Id(memberId, pageRequest);

        if(result.isEmpty()) {
            throw new ReviewException(ReviewErrorCode.REVIEW_NOT_FOUND);
        }

        return ReviewConverter.toMyReviewListDto(result);
    }
}

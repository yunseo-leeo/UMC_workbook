package com.example.umc_workbook.domain.review.service;

import com.example.umc_workbook.domain.member.entity.Member;
import com.example.umc_workbook.domain.member.exception.MemberException;
import com.example.umc_workbook.domain.member.repository.MemberRepository;
import com.example.umc_workbook.domain.review.dto.ReviewCreateDto;
import com.example.umc_workbook.domain.review.entity.Review;
import com.example.umc_workbook.domain.review.repository.ReviewRepository;
import com.example.umc_workbook.domain.store.entity.Store;
import com.example.umc_workbook.domain.store.exception.StoreException;
import com.example.umc_workbook.domain.store.repository.StoreRepository;
import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public void insertReview(Long memberId, ReviewCreateDto req) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(GeneralErrorCode.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(req.getStoreId())
                .orElseThrow(() -> new StoreException((GeneralErrorCode.STORE_NOT_FOUND)));

        Review review = Review.create(member, store, req.getScore(), req.getContent());
        reviewRepository.save(review);
    }
}

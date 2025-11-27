package com.example.umc_workbook.domain.review.repository;

import com.example.umc_workbook.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewQueryRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByMember_Id(Long memberId, PageRequest pageRequest);
}

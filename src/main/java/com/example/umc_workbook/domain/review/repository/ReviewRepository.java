package com.example.umc_workbook.domain.review.repository;

import com.example.umc_workbook.domain.review.dto.ReviewCreateDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository {

    @Modifying
    @Query(value = """
        INSERT INTO review (member_id, store_id, point, content, created_at)
        VALUES (:memberId, :#{#req.storeId}, :#{#req.point}, :#{#req.content}, NOW())
        """, nativeQuery = true)
    void insertReview(
            @Param("memberId") Long memberId,
            @Param("req")ReviewCreateDto req
            );
}

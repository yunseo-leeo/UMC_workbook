package com.example.umc_workbook.domain.review.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository {

    @Modifying
    @Query(value = """
        INSERT INTO review (member_id, store_id, point, body, created_at)
        VALUES (:memberId, :storeId, :point, :body, NOW())
        """, nativeQuery = true)
    void insertReview(
            @Param("userId") Long userId,
            @Param("storeId") Long storeId,
            @Param("point") Double point,
            @Param("body") String body
    );
}

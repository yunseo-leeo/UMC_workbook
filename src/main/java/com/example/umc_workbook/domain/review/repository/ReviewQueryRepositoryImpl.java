package com.example.umc_workbook.domain.review.repository;

import com.example.umc_workbook.domain.review.dto.MyReviewDto;
import com.example.umc_workbook.domain.review.entity.QReview;
import com.example.umc_workbook.domain.review.enums.ReviewSort;
import com.example.umc_workbook.domain.store.entity.QStore;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryRepositoryImpl implements ReviewQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<MyReviewDto> findMyReviews(Long memberId, ReviewSort sort) {
        QReview r = QReview.review;
        QStore s = QStore.store;

        JPAQuery<MyReviewDto> base = query
                .select(Projections.constructor(MyReviewDto.class,
                        r.id,
                        s.name,
                        r.score,
                        r.content,
                        r.createdAt
                ))
                .from(r)
                .join(r.store, s)
                .where(r.member.id.eq(memberId));

        if (sort == ReviewSort.STORE) {
            base.orderBy(
                    s.name.asc(),
                    r.createdAt.desc()
            );
        } else if (sort == ReviewSort.SCORE) {
            base.orderBy(
                    r.score.desc(),
                    r.createdAt.desc()
            );
        }
        return base.fetch();
    }
}

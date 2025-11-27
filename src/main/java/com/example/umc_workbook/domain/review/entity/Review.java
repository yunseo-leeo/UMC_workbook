package com.example.umc_workbook.domain.review.entity;

import com.example.umc_workbook.domain.member.entity.Member;
import com.example.umc_workbook.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "score", precision = 2, scale = 1, nullable = false)
    private BigDecimal score;

    @Column(name = "content", length = 100)
    private String content;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @CreatedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public static Review create(Member member, Store store, BigDecimal score, String content) {
        return Review.builder()
                .member(member)
                .store(store)
                .score(score)
                .content(content)
                .createdAt(LocalDateTime.now())
                .build();
    }
}

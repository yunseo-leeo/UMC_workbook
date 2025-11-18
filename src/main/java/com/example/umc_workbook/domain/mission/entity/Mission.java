package com.example.umc_workbook.domain.mission.entity;

import com.example.umc_workbook.domain.store.Store;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", length = 15, nullable = false)
    private String content;

    @Column(name = "point", length = 3, nullable = false)
    private int point;

    @Column(name = "deadline")
    private Long deadline;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id") // 외래 키는 Mission 테이블에 존재
    private Store store;


}

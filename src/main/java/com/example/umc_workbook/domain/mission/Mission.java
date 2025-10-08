package com.example.umc_workbook.domain.mission;

import jakarta.persistence.*;

@Entity
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", length = 15, nullable = false)
    private String content;

    @Column(name = "deadline")
    private Long deadline;


}

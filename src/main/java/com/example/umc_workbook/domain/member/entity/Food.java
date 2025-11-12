package com.example.umc_workbook.domain.member.entity;

import com.example.umc_workbook.domain.member.enums.FoodCategory;
import jakarta.persistence.*;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "foodCategory", nullable = false)
    private FoodCategory foodCategory;
}

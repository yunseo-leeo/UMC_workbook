package com.example.umc_workbook.domain.store;

import jakarta.persistence.*;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @Column(name = "category", length = 5, nullable = false)
    private String category;

    @Column(name = "address", length = 20, nullable = false)
    private String address;

    @Column(name = "detailAddress", length = 30, nullable = false)
    private String detailAddress;
}


package com.example.umc_workbook.domain.store.entity;

import com.example.umc_workbook.domain.common.AddressType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @Column(name = "category", length = 5, nullable = false)
    private String category;

    @Column(name = "address", nullable = false)
    private AddressType address;

    @Column(name = "detailAddress", length = 30, nullable = false)
    private String detailAddress;

    public static Store create(String name, String category, AddressType address, String detailAddress) {
        return Store.builder()
                .name(name)
                .category(category)
                .address(address)
                .detailAddress(detailAddress)
                .build();
    }
}


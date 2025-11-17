package com.example.umc_workbook.domain.home.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class HomeRequestDto {

    private String address;
    private Integer cursorpoint;
    private LocalDateTime cursorCreatedAt;
    private Long cursorId;

    private int size =10;

    public Pageable toPageable(){
        return PageRequest.of(0, size);
    }
}

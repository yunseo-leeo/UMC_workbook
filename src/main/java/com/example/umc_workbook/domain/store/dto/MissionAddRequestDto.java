package com.example.umc_workbook.domain.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class MissionAddRequestDto {

    private String content;

    private Integer point;

    private LocalDateTime deadline;


}

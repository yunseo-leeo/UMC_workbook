package com.example.umc_workbook.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MemberMissionRequestDto {

    private Long cursorId;
    private Integer cursorPoint;
    private LocalDateTime cursorCreatedAt;

    private int size =10;

    public Pageable toPageable() {
        if (size <= 0) size = 10;
        return PageRequest.of(0,size);
    }
}

package com.example.umc_workbook.domain.mission.dto;

import com.example.umc_workbook.domain.mission.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class MemberMissionResponseDto {

    private Long missionId;
    private String content;
    private Integer missionPoint;
    private String storeName;
    private String storeAddress;
    private MissionStatus missionStatus;
    private LocalDateTime createdAt;
}

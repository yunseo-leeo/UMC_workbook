package com.example.umc_workbook.domain.mission.dto;

import com.example.umc_workbook.domain.common.AddressType;
import com.example.umc_workbook.domain.mission.enums.MissionStatus;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResDto {

    @Builder
    public record MissionListResDto(
            List<MissionResDto.MissionDto> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record MissionDto(
            String content,
            Integer point,
            LocalDateTime deadline,
            LocalDateTime createdAt
    ){}

    @Builder
    public record MemberMissionListDto(
            List<MissionResDto.MemberMissionDto> memberMissionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record MemberMissionDto(
            String content,
            Integer missionPoint,
            String storeName,
            AddressType storeAddress,
            MissionStatus missionStatus,
            LocalDateTime createdAt
    ){}
}

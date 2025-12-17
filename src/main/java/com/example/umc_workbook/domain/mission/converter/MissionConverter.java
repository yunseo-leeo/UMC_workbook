package com.example.umc_workbook.domain.mission.converter;

import com.example.umc_workbook.domain.mission.dto.MissionResDto;
import com.example.umc_workbook.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

public class MissionConverter {

    public static MissionResDto.MissionListResDto toMissionListDto(Page<Mission> result){
        return MissionResDto.MissionListResDto.builder()
                .missionList(result.map(MissionConverter::toMissionResDto).toList())
                .listSize(result.getNumberOfElements())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static MissionResDto.MissionDto toMissionResDto(Mission mission){
        return MissionResDto.MissionDto.builder()
                .content(mission.getContent())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .build();
    }
}
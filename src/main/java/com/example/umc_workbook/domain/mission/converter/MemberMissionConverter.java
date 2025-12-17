package com.example.umc_workbook.domain.mission.converter;


import com.example.umc_workbook.domain.mission.dto.MissionResDto;
import com.example.umc_workbook.domain.mission.entity.MemberMission;
import org.springframework.data.domain.Page;


public class MemberMissionConverter {

    public static MissionResDto.MemberMissionListDto toMemberMissionListDto(Page<MemberMission> result) {
        return MissionResDto.MemberMissionListDto.builder()
                .memberMissionList(result.map(MemberMissionConverter::toMemberMissionResDto).toList())
                .listSize(result.getNumberOfElements())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static MissionResDto.MemberMissionDto toMemberMissionResDto(MemberMission memberMission) {
        return MissionResDto.MemberMissionDto.builder()
                .content(memberMission.getMission().getContent())
                .missionPoint(memberMission.getMission().getPoint())
                .storeName(memberMission.getMission().getStore().getName())
                .storeAddress(memberMission.getMission().getStore().getAddress())
                .missionStatus(memberMission.getMissionStatus())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
}

package com.example.umc_workbook.domain.mission.controller;

import com.example.umc_workbook.domain.mission.dto.MissionResDto;
import com.example.umc_workbook.domain.mission.service.StoreMissionQueryService;
import com.example.umc_workbook.global.annotation.ValidPage;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import com.example.umc_workbook.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreMissionQueryController implements StoreMissionQueryControllerDocs{

    private final StoreMissionQueryService storeMissionQueryService;

    @Override
    public ApiResponse<MissionResDto.MissionListResDto> findStoreMissions(
            @PathVariable Long storeId,
            @RequestParam(value = "page", defaultValue = "1") @ValidPage Integer page
    ) {
        MissionResDto.MissionListResDto storeMissionList = storeMissionQueryService.findStoreMissions(storeId, page);
        return ApiResponse.onSuccess(
                GeneralSuccessCode.FETCHED,
                storeMissionList
        );
    }

}

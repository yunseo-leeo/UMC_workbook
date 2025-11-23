package com.example.umc_workbook.domain.store.controller;

import com.example.umc_workbook.domain.store.dto.MissionAddRequestDto;
import com.example.umc_workbook.domain.store.service.StoreService;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import com.example.umc_workbook.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreMissionController {

    private final StoreService storeService;

    @PostMapping("/{storeId}/missions")
    public ApiResponse<Void> addMission(
            @PathVariable Long storeId,
            @RequestBody MissionAddRequestDto req
    ){
        storeService.addMissionToStore(storeId, req);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, null);
    }
}

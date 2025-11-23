package com.example.umc_workbook.domain.store.controller;

import com.example.umc_workbook.domain.store.dto.StoreCreateRequestDto;
import com.example.umc_workbook.domain.store.service.StoreService;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import com.example.umc_workbook.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class storeController {

    private final StoreService storeService;

    @PostMapping
    public ApiResponse<Void> addStore(@RequestBody StoreCreateRequestDto req) {
        storeService.addStore(req);
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, null);
    }
}

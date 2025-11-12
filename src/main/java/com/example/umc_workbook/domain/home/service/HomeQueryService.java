package com.example.umc_workbook.domain.home.service;

import com.example.umc_workbook.domain.home.HomeRepository;
import com.example.umc_workbook.domain.home.dto.HomeRequestDto;
import com.example.umc_workbook.domain.home.dto.HomeResponseDto;
import com.example.umc_workbook.domain.home.exception.HomeException;
import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import com.example.umc_workbook.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HomeQueryService {

    private final HomeRepository homeRepository;

    public List<HomeResponseDto> findHomePage(Long memberId, HomeRequestDto req) {

        if(req.getAddress() == null || req.getAddress().isEmpty()) {
            throw new HomeException(GeneralErrorCode.BAD_REQUEST);
        }
        return homeRepository.findHomePage(memberId,req,req.toPageable());
    }
}

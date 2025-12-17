package com.example.umc_workbook.domain.mission.service;

import com.example.umc_workbook.domain.mission.converter.MissionConverter;
import com.example.umc_workbook.domain.mission.dto.MissionResDto;
import com.example.umc_workbook.domain.mission.entity.Mission;
import com.example.umc_workbook.domain.mission.exception.MissionErrorCode;
import com.example.umc_workbook.domain.mission.exception.MissionException;
import com.example.umc_workbook.domain.mission.repository.StoreMissionQueryRepository;
import com.example.umc_workbook.domain.store.exception.StoreErrorCode;
import com.example.umc_workbook.domain.store.exception.StoreException;
import com.example.umc_workbook.domain.store.repository.StoreRepository;
import com.example.umc_workbook.global.config.PaginationConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreMissionQueryService {

    private final StoreMissionQueryRepository storeMissionQueryRepository;
    private final StoreRepository storeRepository;

    public MissionResDto.MissionListResDto findStoreMissions(Long storeId, Integer page) {

        if(!storeRepository.existsById(storeId)) {
            throw new StoreException(StoreErrorCode.STORE_NOT_FOUND);
        }

        PageRequest pageRequest = PageRequest.of(page-1, PaginationConstants.DEFAULT_PAGE_SIZE);
        Page<Mission> result = storeMissionQueryRepository.findAllByStoreId(storeId, pageRequest);

        if (result.isEmpty()) {
            throw new MissionException(MissionErrorCode.MISSION_NOT_FOUND);
        }

        return MissionConverter.toMissionListDto(result);
    }
}
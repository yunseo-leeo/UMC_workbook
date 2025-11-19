package com.example.umc_workbook.domain.store.service;

import com.example.umc_workbook.domain.store.dto.StoreCreateRequestDto;
import com.example.umc_workbook.domain.store.entity.Store;
import com.example.umc_workbook.domain.store.exception.StoreException;
import com.example.umc_workbook.domain.store.repository.StoreRepository;
import com.example.umc_workbook.global.apiPayload.code.GeneralErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public void addStore(StoreCreateRequestDto req){

        if (req.getAddress() == null){
            throw new StoreException(GeneralErrorCode.INVALID_ADDRESS);
        }

        if(req.getDetailAddress() == null || req.getDetailAddress().isEmpty()){
            throw new StoreException(GeneralErrorCode.EMPTY_DETAIL_ADDRESS);
        }
        if(req.getName() == null || req.getName().isEmpty()){
            throw new StoreException(GeneralErrorCode.EMPTY_STORE_NAME);
        }

        Store store = Store.create(
                req.getName(),
                req.getCategory(),
                req.getAddress(),
                req.getDetailAddress()
        );

        storeRepository.save(store);
    }
}

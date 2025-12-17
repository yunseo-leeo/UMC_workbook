package com.example.umc_workbook.domain.mission.repository;

import com.example.umc_workbook.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreMissionQueryRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByStoreId(Long storeId, PageRequest pageRequest);


}

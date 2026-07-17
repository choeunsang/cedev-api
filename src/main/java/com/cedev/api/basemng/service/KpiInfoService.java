package com.cedev.api.basemng.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cedev.api.basemng.dto.KpiInfoDto;
import com.cedev.api.basemng.dto.KpiSearchDto;
import com.cedev.api.basemng.dto.PuInfoDto;
import com.cedev.api.basemng.dto.PuSearchDto;
import com.cedev.api.basemng.dto.SectInfoDto;
import com.cedev.api.basemng.dto.SectSearchDto;
import com.cedev.api.basemng.dto.TargetInfoDto;
import com.cedev.api.basemng.dto.TargetSaveDto;
import com.cedev.api.basemng.dto.TargetSearchDto;
import com.cedev.api.basemng.dto.WaveInfoDto;
import com.cedev.api.basemng.dto.WaveSearchDto;
import com.cedev.api.basemng.mapper.KpiInfoMapper;
import com.cedev.api.realestate.dto.EntireMonthlyTradeVolumeDto;
import com.cedev.api.realestate.dto.HousingTradeInfoDto;
import com.cedev.api.realestate.dto.HousingTradePriceInfoDto;
import com.cedev.api.realestate.dto.HousingTradeVolumeDto;
import com.cedev.api.realestate.dto.HousingTradeVolumeMonthlyDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;
import com.cedev.api.realestate.dto.RecentTransactionDto;
import com.cedev.api.realestate.dto.RealEstateDetailDto;
import com.cedev.api.realestate.dto.SigunguMonthlyTradeVolumeDto;
import com.cedev.api.realestate.mapper.RealInfoMapper;

@Service
public class KpiInfoService {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final KpiInfoMapper kpiInfoMapper;

    public KpiInfoService(KpiInfoMapper kpiInfoMapper) {
        this.kpiInfoMapper = kpiInfoMapper;
    }
    
    //-------------------------------------------------------------------------------------------
    //  wave
    //-------------------------------------------------------------------------------------------
    public List<WaveInfoDto> getWaveInfoList(WaveSearchDto searchDto) {

        return kpiInfoMapper.getWaveInfoList(searchDto);
    }    
    
    //-------------------------------------------------------------------------------------------
    // pu
    //-------------------------------------------------------------------------------------------
    public List<PuInfoDto> getPuInfoList(PuSearchDto searchDto) {

        return kpiInfoMapper.getPuInfoList(searchDto);
    }
    
    //-------------------------------------------------------------------------------------------
    // Section
    //-------------------------------------------------------------------------------------------
    public List<SectInfoDto> getSectInfoList(SectSearchDto searchDto) {

        return kpiInfoMapper.getSectInfoList(searchDto);
    }        

    //-------------------------------------------------------------------------------------------
    // target
    //-------------------------------------------------------------------------------------------
    public List<TargetInfoDto> getTargetInfoList(TargetSearchDto searchDto) {

        return kpiInfoMapper.getTargetInfoList(searchDto);
    }  

    //-------------------------------------------------------------------------------------------
    // Kpi
    //-------------------------------------------------------------------------------------------
    public List<KpiInfoDto> getKpiInfoList(KpiSearchDto searchDto) {

        return kpiInfoMapper.getKpiInfoList(searchDto);
    }      
    
    
    //-------------------------------------------------------------------------------------------
    // Kpi
    //-------------------------------------------------------------------------------------------    
    @Transactional // ⚠️ 원자성 보장 (하나라도 실패 시 전부 롤백)
    public Long saveTargetSnapshot(TargetSaveDto saveDto) {
        
        // 1. 타임스탬프 기반 14자리 BIGINT HIST_ID 생성을 자바 단에서 완벽 매핑
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        Long histId = Long.parseLong(timestamp);

        // 2. TB_KPI_TARGET 마스터 테이블 존재유무에 따른 분기 저장 (그리드 행 Loop 처리)
        if (saveDto.getGridData() != null) {
            for (TargetInfoDto row : saveDto.getGridData()) {
                Map<String, Object> targetParam = new HashMap<>();
                targetParam.put("year", saveDto.getYear());
                targetParam.put("userId", saveDto.getUserId());
                targetParam.put("row", row);
                kpiInfoMapper.upsertKpiTarget(targetParam);
            }
        }

//        // 3. 이력 마스터 정보 등록 (TB_KPI_TARGET_HIST)
//        Map<String, Object> histMasterParam = new HashMap<>();
//        histMasterParam.put("histId", histId);
//        histMasterParam.put("year", saveDto.getYear());
//        histMasterParam.put("reason", saveDto.getReason());
//        histMasterParam.put("userId", saveDto.getUserId() == null ? "SYSTEM" : saveDto.getUserId());
//        kpiInfoMapper.insertKpiHistMaster(histMasterParam);
//
//        // 4. 이력 상세 정보 고속 스냅샷 복사 등록 (TB_KPI_TARGET_HIST_DETAIL)
//        Map<String, Object> histDetailParam = new HashMap<>();
//        histDetailParam.put("histId", histId);
//        histDetailParam.put("year", saveDto.getYear());
//        kpiInfoMapper.insertKpiHistDetailSnapshot(histDetailParam);

        // 바깥 컨트롤러 단에 최종 발급된 이력 ID 반환
        return histId;
    }    
}
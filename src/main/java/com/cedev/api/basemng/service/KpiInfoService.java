package com.cedev.api.basemng.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cedev.api.basemng.dto.KpiInfoDto;
import com.cedev.api.basemng.dto.KpiSearchDto;
import com.cedev.api.basemng.dto.PuInfoDto;
import com.cedev.api.basemng.dto.PuSearchDto;
import com.cedev.api.basemng.dto.TargetInfoDto;
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
}
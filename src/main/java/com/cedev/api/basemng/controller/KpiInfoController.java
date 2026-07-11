package com.cedev.api.basemng.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cedev.api.basemng.dto.KpiInfoDto;
import com.cedev.api.basemng.dto.KpiSearchDto;
import com.cedev.api.basemng.dto.PuInfoDto;
import com.cedev.api.basemng.dto.PuSearchDto;
import com.cedev.api.basemng.dto.TargetInfoDto;
import com.cedev.api.basemng.dto.TargetSearchDto;
import com.cedev.api.basemng.dto.WaveInfoDto;
import com.cedev.api.basemng.dto.WaveSearchDto;
import com.cedev.api.basemng.service.KpiInfoService;
import com.cedev.api.realestate.dto.EntireMonthlyTradeVolumeDto;
import com.cedev.api.realestate.dto.HousingTradeInfoDto;
import com.cedev.api.realestate.dto.HousingTradePriceInfoDto;
import com.cedev.api.realestate.dto.HousingTradeVolumeDto;
import com.cedev.api.realestate.dto.HousingTradeVolumeMonthlyDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;
import com.cedev.api.realestate.dto.RecentTransactionDto;
import com.cedev.api.realestate.dto.RealEstateDetailDto;
import com.cedev.api.realestate.dto.SigunguMonthlyTradeVolumeDto;
import com.cedev.api.realestate.service.RealInfoService;

@RestController
public class KpiInfoController {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final KpiInfoService kpiInfoService;

    public KpiInfoController(KpiInfoService kpiInfoService) {
        this.kpiInfoService = kpiInfoService;
    }
    
    //-------------------------------------------------------------------------------------------
    // wave
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/basemng-wave-info")
    public List<WaveInfoDto> getWaveInfoList(WaveSearchDto searchDto) {

        return kpiInfoService.getWaveInfoList(searchDto);
    }    
    
    //-------------------------------------------------------------------------------------------
    // pu
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/basemng-pu-info")
    public List<PuInfoDto> getPuInfoList(PuSearchDto searchDto) {

        return kpiInfoService.getPuInfoList(searchDto);
    }        


    //-------------------------------------------------------------------------------------------
    // targer
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/basemng-target-info")
    public List<TargetInfoDto> getTargetInfoList(TargetSearchDto searchDto) {

        return kpiInfoService.getTargetInfoList(searchDto);
    }        
    
    //-------------------------------------------------------------------------------------------
    // kpi
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/basemng-kpi-info")
    public List<KpiInfoDto> getKpiInfoList(KpiSearchDto searchDto) {

        return kpiInfoService.getKpiInfoList(searchDto);
    }            
    
}
package com.cedev.api.coin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cedev.api.basemng.dto.KpiInfoDto;
import com.cedev.api.basemng.dto.KpiSaveDto;
import com.cedev.api.basemng.dto.KpiSearchDto;
import com.cedev.api.basemng.dto.LotInfoDto;
import com.cedev.api.basemng.dto.LotSearchDto;
import com.cedev.api.basemng.dto.PuInfoDto;
import com.cedev.api.basemng.dto.PuSaveDto;
import com.cedev.api.basemng.dto.PuSearchDto;
import com.cedev.api.basemng.dto.SectInfoDto;
import com.cedev.api.basemng.dto.SectSearchDto;
import com.cedev.api.basemng.dto.TargetDetailDto;
import com.cedev.api.basemng.dto.TargetInfoDto;
import com.cedev.api.basemng.dto.TargetMasterDto;
import com.cedev.api.basemng.dto.TargetSaveDto;
import com.cedev.api.basemng.dto.TargetSearchDto;
import com.cedev.api.basemng.dto.WaveInfoDto;
import com.cedev.api.basemng.dto.WaveSaveDto;
import com.cedev.api.basemng.dto.WaveSearchDto;
import com.cedev.api.basemng.service.KpiInfoService;
import com.cedev.api.coin.dto.CoinChkDto;
import com.cedev.api.coin.dto.CoinDetailDto;
import com.cedev.api.coin.dto.CoinInfoDto;
import com.cedev.api.coin.dto.CoinSearchDto;
import com.cedev.api.coin.service.CoinInfoService;
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

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class CoinInfoController {

	
    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------	
    private final CoinInfoService coinInfoService;

    public CoinInfoController(CoinInfoService coinInfoService) {
        this.coinInfoService = coinInfoService;
    }
    
    //-------------------------------------------------------------------------------------------
    // coin
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/basemng-coin-info")
    public List<CoinInfoDto> getCoinInfoList(CoinSearchDto searchDto) {

        return coinInfoService.getCoinInfoList(searchDto);
    }
    
    @GetMapping("/api/basemng-coin-detail-info")
    public List<CoinDetailDto> getCoinDetailList(CoinSearchDto searchDto) {

        return coinInfoService.getCoinDetailList(searchDto);
    }    
    
    @GetMapping("/api/basemng-coin-chk-info")
    public List<CoinChkDto> getCoinChkList(CoinSearchDto searchDto) {

        return coinInfoService.getCoinChkList(searchDto);
    }        
    
}
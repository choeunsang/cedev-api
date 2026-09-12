package com.cedev.api.coin.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.cedev.api.basemng.mapper.KpiInfoMapper;
import com.cedev.api.coin.dto.CoinChkDto;
import com.cedev.api.coin.dto.CoinDetailDto;
import com.cedev.api.coin.dto.CoinInfoDto;
import com.cedev.api.coin.dto.CoinSearchDto;
import com.cedev.api.coin.mapper.CoinInfoMapper;
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
public class CoinInfoService {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final CoinInfoMapper coinInfoMapper;

    public CoinInfoService(CoinInfoMapper coinInfoMapper) {
        this.coinInfoMapper = coinInfoMapper;
    }
    
    //-------------------------------------------------------------------------------------------
    //  wave
    //-------------------------------------------------------------------------------------------
    public List<CoinInfoDto> getCoinInfoList(CoinSearchDto searchDto) {

        return coinInfoMapper.getCoinInfoList(searchDto);
    }
    
    public List<CoinDetailDto> getCoinDetailList(CoinSearchDto searchDto) {

        return coinInfoMapper.getCoinDetailList(searchDto);
                              
    }        
    
    public List<CoinChkDto> getCoinChkList(CoinSearchDto searchDto) {

        return coinInfoMapper.getCoinChkList(searchDto);
                              
    }    
    
    
}
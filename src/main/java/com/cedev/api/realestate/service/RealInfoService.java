package com.cedev.api.realestate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cedev.api.realestate.dto.EntireMonthlyTradeVolumeDto;
import com.cedev.api.realestate.dto.HousingTradeInfoDto;
import com.cedev.api.realestate.dto.HousingTradeVolumeDto;
import com.cedev.api.realestate.dto.HousingTradeVolumeMonthlyDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;
import com.cedev.api.realestate.dto.RecentTransactionDto;
import com.cedev.api.realestate.dto.RealEstateDetailDto;
import com.cedev.api.realestate.dto.SigunguMonthlyTradeVolumeDto;
import com.cedev.api.realestate.mapper.RealInfoMapper;

@Service
public class RealInfoService {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final RealInfoMapper realInfoMapper;

    public RealInfoService(RealInfoMapper realInfoMapper) {
        this.realInfoMapper = realInfoMapper;
    }
    
    //-------------------------------------------------------------------------------------------
    // 주택 매매 정보 API
    //-------------------------------------------------------------------------------------------
    public List<HousingTradeInfoDto> getHousingTradeInfo(RealInfoSearchDto searchDto) {

        return realInfoMapper.getHousingTradeInfo(searchDto);
    }    


    //-------------------------------------------------------------------------------------------
    // 주택 거래량 API
    //-------------------------------------------------------------------------------------------
    public List<HousingTradeVolumeDto> getHousingTradeVolume(RealInfoSearchDto searchDto) {

        return realInfoMapper.getHousingTradeVolume(searchDto);
    }


    //-------------------------------------------------------------------------------------------
    // 주택 거래량 월별 합계 API
    //-------------------------------------------------------------------------------------------
    public List<HousingTradeVolumeMonthlyDto> getHousingTradeVolumeMonthly(RealInfoSearchDto searchDto) {

        return realInfoMapper.getHousingTradeVolumeMonthly(searchDto);
    }


    //-------------------------------------------------------------------------------------------
    // 최근 거래건 API
    //-------------------------------------------------------------------------------------------
    public List<RecentTransactionDto> getRecentTransactions(RealInfoSearchDto searchDto) {

        return realInfoMapper.getRecentTransactions(searchDto);
    }


    //-------------------------------------------------------------------------------------------
    // 부동산 상세 평균 거래금액 API
    //-------------------------------------------------------------------------------------------
    public List<RealEstateDetailDto> getRealEstateDetail(RealInfoSearchDto searchDto) {

        return realInfoMapper.getRealEstateDetail(searchDto);
    }


    //-------------------------------------------------------------------------------------------
    // 시군구별 월별 거래량 API
    //-------------------------------------------------------------------------------------------
    public List<SigunguMonthlyTradeVolumeDto> getSigunguMonthlyTradeVolume(RealInfoSearchDto searchDto) {

        return realInfoMapper.getSigunguMonthlyTradeVolume(searchDto);
    }
    
    
    //-------------------------------------------------------------------------------------------
    // 전국 월별 거래량 API
    //-------------------------------------------------------------------------------------------
    public List<EntireMonthlyTradeVolumeDto> getEntireMonthlyTradeVolume(RealInfoSearchDto searchDto) {

        return realInfoMapper.getEntireMonthlyTradeVolume(searchDto);
    }    
}
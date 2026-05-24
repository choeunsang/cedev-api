package com.cedev.api.realestate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cedev.api.realestate.dto.HousingTradeVolumeDto;
import com.cedev.api.realestate.dto.HousingTradeVolumeMonthlyDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;
import com.cedev.api.realestate.dto.RecentTransactionDto;
import com.cedev.api.realestate.dto.RealEstateDetailDto;
import com.cedev.api.realestate.dto.SigunguMonthlyTradeVolumeDto;
import com.cedev.api.realestate.service.RealInfoService;

@RestController
public class RealInfoController {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final RealInfoService realInfoService;

    public RealInfoController(RealInfoService realInfoService) {
        this.realInfoService = realInfoService;
    }


    //-------------------------------------------------------------------------------------------
    // 주택 매매 거래량 API
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/housing-trade-volume")
    public List<HousingTradeVolumeDto> getHousingTradeVolume(RealInfoSearchDto searchDto) {

        return realInfoService.getHousingTradeVolume(searchDto);
    }


    //-------------------------------------------------------------------------------------------
    // 주택 거래량 월별 합계 API
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/housing-trade-volume/monthly")
    public List<HousingTradeVolumeMonthlyDto> getHousingTradeVolumeMonthly(RealInfoSearchDto searchDto) {

        return realInfoService.getHousingTradeVolumeMonthly(searchDto);
    }


    //-------------------------------------------------------------------------------------------
    // 최근 거래건 API
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/recent-transactions")
    public List<RecentTransactionDto> getRecentTransactions(RealInfoSearchDto searchDto) {

        return realInfoService.getRecentTransactions(searchDto);
    }


    //-------------------------------------------------------------------------------------------
    // 부동산 상세 평균 거래금액 API
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/real-estate-detail")
    public List<RealEstateDetailDto> getRealEstateDetail(RealInfoSearchDto searchDto) {

        return realInfoService.getRealEstateDetail(searchDto);
    }


    //-------------------------------------------------------------------------------------------
    // 시군구별 월별 거래량 API
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/housing-trade-volume/sigungu-monthly")
    public List<SigunguMonthlyTradeVolumeDto> getSigunguMonthlyTradeVolume(RealInfoSearchDto searchDto) {

        return realInfoService.getSigunguMonthlyTradeVolume(searchDto);
    }
}
package com.cedev.api.common.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cedev.api.common.dto.DangiInfoDto;
import com.cedev.api.common.service.BaseInfoService;
import com.cedev.api.common.service.RegionCodeService;
import com.cedev.api.realestate.dto.HousingTradeInfoDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;

@RestController
public class BaseInfoController {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final BaseInfoService baseInfoService;

    public BaseInfoController(BaseInfoService baseInfoService) {
        this.baseInfoService = baseInfoService;
    }

    //-------------------------------------------------------------------------------------------
    // 시도 조회 API
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/common/dangi-info")
    public List<DangiInfoDto> getDangiInfo(RealInfoSearchDto searchDto) {
        return baseInfoService.getDangiInfo(searchDto);
    }
    
    @GetMapping("/api/common/dangi-detail-info")
    public List<HousingTradeInfoDto> getDangiDetailInfo(RealInfoSearchDto searchDto) {
        return baseInfoService.getDangiDetailInfo(searchDto);
    }    


}
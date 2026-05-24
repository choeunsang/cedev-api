package com.cedev.api.realestate.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cedev.api.realestate.dto.HousRentVolumeDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;
import com.cedev.api.realestate.dto.RentGbunDto;
import com.cedev.api.realestate.dto.RentInfoDto;
import com.cedev.api.realestate.dto.RentInfoSearchDto;
import com.cedev.api.realestate.service.RentInfoService;

@RestController
public class RentInfoController {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------	
    private final RentInfoService rentInfoService;

    public RentInfoController(RentInfoService rentInfoService) {
        this.rentInfoService = rentInfoService;
    }
    
    //-------------------------------------------------------------------------------------------
    // 주택 전월세 조회
    //-------------------------------------------------------------------------------------------    
    @GetMapping("/api/rent-info")
    public List<RentInfoDto> getRentInfoList(RentInfoSearchDto searchDto) {

        //return rentInfoService.getRentInfoList(searchDto);
    	
    	var list = rentInfoService.getRentInfoList(searchDto);
    	return list;
    }    
    
    //-------------------------------------------------------------------------------------------
    // 주택 전월세 거래량
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/housing-rent-volume/monthly")
    public List<HousRentVolumeDto> getHousingTradeVolume(RealInfoSearchDto searchDto) {

        return rentInfoService.getHousRentVolume(searchDto);
    }    
    
    
    //-------------------------------------------------------------------------------------------
    // 주택 전월세 갱신/신규 현황
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/housing-rentGbun-status")
    public List<RentGbunDto> getRentGbunStatus(RentInfoSearchDto searchDto) {

    	List<RentGbunDto> list = rentInfoService.getRentGbunStatus(searchDto);
    	
        //return rentInfoService.getRentGbunStatus(searchDto);
    	return list;
    }        

    

}
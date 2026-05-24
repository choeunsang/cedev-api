package com.cedev.api.realestate.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cedev.api.realestate.dto.HousRentVolumeDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;
import com.cedev.api.realestate.dto.RentGbunDto;
import com.cedev.api.realestate.dto.RentInfoDto;
import com.cedev.api.realestate.dto.RentInfoSearchDto;
import com.cedev.api.realestate.mapper.RentInfoMapper;

@Service
public class RentInfoService {

	
    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------	
    private final RentInfoMapper rentInfoMapper;

    public RentInfoService(RentInfoMapper rentInfoMapper) {
        this.rentInfoMapper = rentInfoMapper;
    }
    
    //-------------------------------------------------------------------------------------------
    // 주택 전월세 조회
    //-------------------------------------------------------------------------------------------    
    public List<RentInfoDto> getRentInfoList(RentInfoSearchDto searchDto) {

        return rentInfoMapper.getRentInfoList(searchDto);
    }    
    
    //-------------------------------------------------------------------------------------------
    // 주택 전월세 거래량
    //-------------------------------------------------------------------------------------------
    public List<HousRentVolumeDto> getHousRentVolume(RealInfoSearchDto searchDto) {

        return rentInfoMapper.getHousRentVolume(searchDto);
    }    
    
    //-------------------------------------------------------------------------------------------
    //  주택 전월세 갱신/신규 현황 
    //-------------------------------------------------------------------------------------------
    public List<RentGbunDto> getRentGbunStatus(RentInfoSearchDto searchDto) {

        return rentInfoMapper.getRentGbunStatus(searchDto);
    }        


}
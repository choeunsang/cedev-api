package com.cedev.api.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cedev.api.common.dto.DangiInfoDto;
import com.cedev.api.common.mapper.BaseInfoMapper;
import com.cedev.api.common.mapper.RegionCodeMapper;
import com.cedev.api.realestate.dto.HousingTradeInfoDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;

@Service
public class BaseInfoService {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final BaseInfoMapper baseInfoMapper;

    public BaseInfoService(BaseInfoMapper baseInfoMapper) {
        this.baseInfoMapper = baseInfoMapper;
    }


    //-------------------------------------------------------------------------------------------
    // 동 조회
    //-------------------------------------------------------------------------------------------
    public List<DangiInfoDto> getDangiInfo(RealInfoSearchDto searchDto) {
        return baseInfoMapper.getDangiInfo(searchDto);
    }

    public List<HousingTradeInfoDto> getDangiDetailInfo(RealInfoSearchDto searchDto) {
        return baseInfoMapper.getDangiDetailInfo(searchDto);
    }    
}
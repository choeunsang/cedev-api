package com.cedev.api.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cedev.api.common.mapper.RegionCodeMapper;

@Service
public class RegionCodeService {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final RegionCodeMapper regionCodeMapper;

    public RegionCodeService(RegionCodeMapper regionCodeMapper) {
        this.regionCodeMapper = regionCodeMapper;
    }

    //-------------------------------------------------------------------------------------------
    // 시도 조회
    //-------------------------------------------------------------------------------------------
    public List<String> getSido() {
        return regionCodeMapper.getSido();
    }

    //-------------------------------------------------------------------------------------------
    // 시군구 조회
    //-------------------------------------------------------------------------------------------
    public List<String> getSigungu(String sido) {
        return regionCodeMapper.getSigungu(sido);
    }

    //-------------------------------------------------------------------------------------------
    // 동 조회
    //-------------------------------------------------------------------------------------------
    public List<String> getDong(String sido, String sigungu) {
        return regionCodeMapper.getDong(sido, sigungu);
    }
}
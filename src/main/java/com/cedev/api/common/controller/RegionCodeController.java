package com.cedev.api.common.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cedev.api.common.service.RegionCodeService;

@RestController
public class RegionCodeController {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final RegionCodeService regionCodeService;

    public RegionCodeController(RegionCodeService regionCodeService) {
        this.regionCodeService = regionCodeService;
    }

    //-------------------------------------------------------------------------------------------
    // 시도 조회 API
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/region/sido")
    public List<String> getSido() {
        return regionCodeService.getSido();
    }

    //-------------------------------------------------------------------------------------------
    // 시군구 조회 API
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/region/sigungu")
    public List<String> getSigungu(@RequestParam("sido") String sido) {
        return regionCodeService.getSigungu(sido);
    }

    //-------------------------------------------------------------------------------------------
    // 동 조회 API
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/region/dong")
    public List<String> getDong(
            @RequestParam("sido") String sido,
            @RequestParam("sigungu") String sigungu) {

        return regionCodeService.getDong(sido, sigungu);
    }
}
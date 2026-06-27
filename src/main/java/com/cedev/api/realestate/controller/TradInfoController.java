package com.cedev.api.realestate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cedev.api.realestate.dto.TradInfoSearchDto;
import com.cedev.api.realestate.dto.TradVolumeDto;
import com.cedev.api.realestate.service.TradInfoService;


@RestController
public class TradInfoController {


    private final TradInfoService tradInfoService;

    public TradInfoController(TradInfoService tradInfoService) {
        this.tradInfoService = tradInfoService;
    }
    

    @GetMapping("/api/housTrad/VolInfo-sido")
    public List<TradVolumeDto> getTradeVolumeSido(TradInfoSearchDto searchDto) {

        return tradInfoService.getTradeVolumeSido(searchDto);
    }    
    
    @GetMapping("/api/housTrad/VolInfo-sido-mon")
    public List<TradVolumeDto> getTradeVolumeSido_Mon(TradInfoSearchDto searchDto) {

        return tradInfoService.getTradeVolumeSido_Mon(searchDto);
    }        
    
    @GetMapping("/api/housTrad/VolInfo-sigungu")
    public List<TradVolumeDto> getTradeVolumeSigungu(TradInfoSearchDto searchDto) {

        return tradInfoService.getTradeVolumeSigungu(searchDto);
    }    
    
    @GetMapping("/api/housTrad/VolInfo-sigungu-mon")
    public List<TradVolumeDto> getTradeVolumeSigungu_Mon(TradInfoSearchDto searchDto) {

        return tradInfoService.getTradeVolumeSigungu_Mon(searchDto);
    }        
    
    @GetMapping("/api/housTrad/VolInfo-dong")
    public List<TradVolumeDto> getTradeVolumeDong(TradInfoSearchDto searchDto) {

        return tradInfoService.getTradeVolumeDong(searchDto);
    }        
    

}
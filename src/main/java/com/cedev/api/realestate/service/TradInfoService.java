package com.cedev.api.realestate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cedev.api.realestate.dto.TradInfoSearchDto;
import com.cedev.api.realestate.dto.TradVolumeDto;
import com.cedev.api.realestate.mapper.TradInfoMapper;

@Service
public class TradInfoService {


    private final TradInfoMapper tradInfoMapper;

    public TradInfoService(TradInfoMapper tradInfoMapper) {
        this.tradInfoMapper = tradInfoMapper;
    }
    

    public List<TradVolumeDto> getTradeVolumeSido(TradInfoSearchDto searchDto) {

        return tradInfoMapper.getTradeVolumeSido(searchDto);
    }
    
    public List<TradVolumeDto> getTradeVolumeSido_Mon(TradInfoSearchDto searchDto) {

        return tradInfoMapper.getTradeVolumeSido_Mon(searchDto);
    }      
    
    
    public List<TradVolumeDto> getTradeVolumeSigungu(TradInfoSearchDto searchDto) {

        return tradInfoMapper.getTradeVolumeSigungu(searchDto);
    }     
    
    public List<TradVolumeDto> getTradeVolumeSigungu_Mon(TradInfoSearchDto searchDto) {

        return tradInfoMapper.getTradeVolumeSigungu_Mon(searchDto);
    }          
    
    public List<TradVolumeDto> getTradeVolumeDong(TradInfoSearchDto searchDto) {

        return tradInfoMapper.getTradeVolumeDong(searchDto);
    }        
    

}
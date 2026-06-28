package com.cedev.api.realestate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cedev.api.realestate.dto.TradInfoSearchDto;
import com.cedev.api.realestate.dto.TradVolumeDto;


@Mapper
public interface TradInfoMapper {
	
	List<TradVolumeDto> getTradeVolumeSido(TradInfoSearchDto searchDto);
	
	List<TradVolumeDto> getTradeVolumeSido_Mon(TradInfoSearchDto searchDto);
	
	List<TradVolumeDto> getTradeVolumeSigungu(TradInfoSearchDto searchDto);
	
	List<TradVolumeDto> getTradeVolumeSigungu_Mon(TradInfoSearchDto searchDto);
	
	List<TradVolumeDto> getTradeVolumeDong(TradInfoSearchDto searchDto);
	
	List<TradVolumeDto> getTradeVolumeDong_Mon(TradInfoSearchDto searchDto);


}
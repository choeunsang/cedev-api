package com.cedev.api.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cedev.api.common.dto.DangiInfoDto;
import com.cedev.api.realestate.dto.HousingTradeInfoDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;

@Mapper
public interface BaseInfoMapper {

	List<DangiInfoDto> getDangiInfo(RealInfoSearchDto searchDto);
	
	List<HousingTradeInfoDto> getDangiDetailInfo(RealInfoSearchDto searchDto);
}
package com.cedev.api.realestate.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cedev.api.realestate.dto.HousRentVolumeDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;
import com.cedev.api.realestate.dto.RentGbunDto;
import com.cedev.api.realestate.dto.RentInfoDto;
import com.cedev.api.realestate.dto.RentInfoSearchDto;

@Mapper
public interface RentInfoMapper {
	
	//주택 전월세 조회
	List<RentInfoDto> getRentInfoList(RentInfoSearchDto searchDto);
	
	//주택 전월세 거래량
	List<HousRentVolumeDto> getHousRentVolume(RealInfoSearchDto searchDto);
	
	//주택 전월세 갱신/신규 현황
	List<RentGbunDto> getRentGbunStatus(RentInfoSearchDto searchDto);

}
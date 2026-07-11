package com.cedev.api.basemng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cedev.api.basemng.dto.KpiInfoDto;
import com.cedev.api.basemng.dto.KpiSearchDto;
import com.cedev.api.basemng.dto.PuInfoDto;
import com.cedev.api.basemng.dto.PuSearchDto;
import com.cedev.api.basemng.dto.TargetInfoDto;
import com.cedev.api.basemng.dto.TargetSearchDto;
import com.cedev.api.basemng.dto.WaveInfoDto;
import com.cedev.api.basemng.dto.WaveSearchDto;
import com.cedev.api.realestate.dto.EntireMonthlyTradeVolumeDto;
import com.cedev.api.realestate.dto.HousingTradeInfoDto;
import com.cedev.api.realestate.dto.HousingTradePriceInfoDto;
import com.cedev.api.realestate.dto.HousingTradeVolumeDto;
import com.cedev.api.realestate.dto.HousingTradeVolumeMonthlyDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;
import com.cedev.api.realestate.dto.RecentTransactionDto;
import com.cedev.api.realestate.dto.RealEstateDetailDto;
import com.cedev.api.realestate.dto.SigunguMonthlyTradeVolumeDto;

@Mapper
public interface KpiInfoMapper {
	
	List<WaveInfoDto> getWaveInfoList(WaveSearchDto searchDto);
	
	List<PuInfoDto> getPuInfoList(PuSearchDto searchDto);
	
	List<TargetInfoDto> getTargetInfoList(TargetSearchDto searchDto);
	
	List<KpiInfoDto> getKpiInfoList(KpiSearchDto searchDto);


}
package com.cedev.api.basemng.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cedev.api.basemng.dto.KpiInfoDto;
import com.cedev.api.basemng.dto.KpiSearchDto;
import com.cedev.api.basemng.dto.LotInfoDto;
import com.cedev.api.basemng.dto.LotSearchDto;
import com.cedev.api.basemng.dto.PuInfoDto;
import com.cedev.api.basemng.dto.PuSearchDto;
import com.cedev.api.basemng.dto.SectInfoDto;
import com.cedev.api.basemng.dto.SectSearchDto;
import com.cedev.api.basemng.dto.TargetDetailDto;
import com.cedev.api.basemng.dto.TargetInfoDto;
import com.cedev.api.basemng.dto.TargetMasterDto;
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
	
    //-------------------------------------------------------------------------------------------
    // wave
    //-------------------------------------------------------------------------------------------	
	List<WaveInfoDto> getWaveInfoList(WaveSearchDto searchDto);
	
	int saveWaveInfo(Map<String, Object> param);
	
    //-------------------------------------------------------------------------------------------
    // pu
    //-------------------------------------------------------------------------------------------	
	List<PuInfoDto> getPuInfoList(PuSearchDto searchDto);
	
	int savePuInfo(Map<String, Object> param);
	
    //-------------------------------------------------------------------------------------------
    // Sect
    //-------------------------------------------------------------------------------------------	
	List<SectInfoDto> getSectInfoList(SectSearchDto searchDto);
	
	
    //-------------------------------------------------------------------------------------------
    // Lot
    //-------------------------------------------------------------------------------------------	
	List<LotInfoDto> getLotInfoList(LotSearchDto searchDto);

    //-------------------------------------------------------------------------------------------
    // Kpi
    //-------------------------------------------------------------------------------------------	
	List<KpiInfoDto> getKpiInfoList(KpiSearchDto searchDto);

    int upsertKpi(Map<String, Object> param);	
	
    //-------------------------------------------------------------------------------------------
    // Target
    //-------------------------------------------------------------------------------------------	
	List<TargetInfoDto> getTargetInfoList(TargetSearchDto searchDto);
	
	List<TargetMasterDto> getTargetHisMaster(TargetSearchDto searchDto);
		
	List<TargetDetailDto> getTargetHisDetail(TargetSearchDto searchDto);
	
	
    int upsertTarget(Map<String, Object> param);
    
    int insertHistMaster(Map<String, Object> param);
    
    int insertHistDetail(Map<String, Object> param);		
	


}
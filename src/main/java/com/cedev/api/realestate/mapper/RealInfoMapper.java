package com.cedev.api.realestate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cedev.api.realestate.dto.HousingTradeVolumeDto;
import com.cedev.api.realestate.dto.HousingTradeVolumeMonthlyDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;
import com.cedev.api.realestate.dto.RecentTransactionDto;
import com.cedev.api.realestate.dto.RealEstateDetailDto;
import com.cedev.api.realestate.dto.SigunguMonthlyTradeVolumeDto;

@Mapper
public interface RealInfoMapper {

    List<HousingTradeVolumeDto> getHousingTradeVolume(RealInfoSearchDto searchDto);

    List<HousingTradeVolumeMonthlyDto> getHousingTradeVolumeMonthly(RealInfoSearchDto searchDto);

    List<RecentTransactionDto> getRecentTransactions(RealInfoSearchDto searchDto);

    List<RealEstateDetailDto> getRealEstateDetail(RealInfoSearchDto searchDto);

    List<SigunguMonthlyTradeVolumeDto> getSigunguMonthlyTradeVolume(RealInfoSearchDto searchDto);
}
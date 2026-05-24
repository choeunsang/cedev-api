package com.cedev.api.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegionCodeMapper {

    List<String> getSido();

    List<String> getSigungu(@Param("sido") String sido);

    List<String> getDong(
            @Param("sido") String sido,
            @Param("sigungu") String sigungu);
}
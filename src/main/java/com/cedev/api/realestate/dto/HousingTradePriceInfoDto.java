package com.cedev.api.realestate.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class HousingTradePriceInfoDto {

	private String sido;
	private String sigungu;
	private String dong;
	private String areaPyeong;
	private String tradCnt;
	
	private String avgPrice;
	private String minPrice;
	private String maxPrice;

	
}
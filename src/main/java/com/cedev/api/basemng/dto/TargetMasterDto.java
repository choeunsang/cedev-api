package com.cedev.api.basemng.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TargetMasterDto {
    
	private String histId; 
	private String kpiYear;  
	private String chgReason;  
	private String histRegDt;  
	private String modUser;   

    
}


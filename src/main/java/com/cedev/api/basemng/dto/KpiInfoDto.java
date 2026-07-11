package com.cedev.api.basemng.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KpiInfoDto {
    
	private String year;        
    private String kpiCd;            
    private String kpiNm;        
    private String gubun;        
    private String kpiVal;        
        
    private String v1stSign;        
    private String v1stVal;        
    private String v1stMon;        
    private String v1stUseYn;                
    
    private String v2stSign;        
    private String v2stVal;        
    private String v2stMon;        
    private String v2stUseYn;   
    
    private String v3stSign;        
    private String v3stVal;        
    private String v3stMon;        
    private String v3stUseYn;   
    
    private String v4stSign;        
    private String v4stVal;        
    private String v4stMon;        
    private String v4stUseYn;       
    
    private String regId;       
    private String regDt;       
    private String modId;       
    private String modDt;       
    
        

}

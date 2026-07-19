package com.cedev.api.basemng.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LotSearchDto {
        
    private String year;      
    private String site;
    private String wave;        
    private String tech;
    private String equip;    
    private String oper;            
    private String fromDt;
    private String toDt;

}

package com.cedev.api.coin.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoinInfoDto {
    
	private String cd;        
    private String krNm;            
    private String enNm;        
    private String description;        
    
    private String issueCntryNm;        
    private String price;        
    private String priceDt;        
    private String marketCap;        
    private String useYn;        

            
}

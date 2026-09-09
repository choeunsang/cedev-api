package com.cedev.api.coin.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoinDetailDto {
    
	private String cd;        
    private String price;            
    private String priceDt;        
    private String marketCap;            
    private String etc;                        
}

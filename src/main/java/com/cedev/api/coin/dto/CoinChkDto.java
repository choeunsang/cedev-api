package com.cedev.api.coin.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoinChkDto {
    
	private String cd;        
	private String priceDt;        
    private String price;                
    private String openingPrice;          
    private String highPrice;          
    private String lowPrice;          
    private String volume;              
    private String dailyRange;                                  
}

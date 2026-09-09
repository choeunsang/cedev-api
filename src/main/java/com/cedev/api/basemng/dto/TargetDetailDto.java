package com.cedev.api.basemng.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TargetDetailDto {
    
	private String histId; 	
	private String waveCd;  
	private String waveNm;  
	private String fabIn;   
	private String b1st;
	private String b2st;
	private String b3st;
	private String b4st;
	private String b5st;
	private String pgin;
	private String a1st;
	private String a2st;
	private String a3st;
	private String a4st;
	private String a5st;
	private String fabOut;
    
}


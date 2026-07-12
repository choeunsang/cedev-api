package com.cedev.api.basemng.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TargetInfoDto {
    // 💡 C#의 첫 글자 대문자 프로퍼티명(WaveCd)과 자바 변수명을 완벽 연결합니다.
    @JsonProperty("WaveCd")  private String waveCd;  
    @JsonProperty("FabIn")   private String fabIn;   
    @JsonProperty("B1st")    private String b1st;
    @JsonProperty("B2st")    private String b2st; // C#이 b2st로 보냈다면 b2st 기입
    @JsonProperty("B3st")    private String b3st; // C#이 b3st로 보냈다면 b3st 기입
    @JsonProperty("B4st")    private String b4st;
    @JsonProperty("B5st")    private String b5st;
    @JsonProperty("Pgin")    private String pgin;
    @JsonProperty("A1st")    private String a1st;
    @JsonProperty("A2st")    private String a2st;
    @JsonProperty("A3st")    private String a3st;
    @JsonProperty("A4st")    private String a4st;
    @JsonProperty("A5st")    private String a5st;
    @JsonProperty("FabOut")  private String fabOut; // C#의 FabOut과 대소문자 일치
}

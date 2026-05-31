package com.cedev.api.realestate.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RentGbunDto {
    //private String sigungu;         // 시군구명 or 시도
    private String regionName;        
    private int newContractCnt;     // 신규 계약 건수
    private int renewContractCnt;   // 갱신 계약 건수
    private int usedRightCnt;       // 갱신요구권 사용 건수
    private double usePercent;       // 갱신요구권 사용률
}

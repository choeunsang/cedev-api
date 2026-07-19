package com.cedev.api.basemng.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LotInfoDto {
    
    // 이미지 내 SQL 컬럼 기반 추가 필드
    private String lotId;
    private String stdDt;
    private String oper;

    // 공정별 시각 (T_...)
    private String tPgIn;
    private String tNoGwang;
    private String t1stA;
    private String t1stA2;
    private String t1stB;
    private String t1stB2;
    private String t2nd;
    private String tAdd;
    private String end;

    // 공정별 시간 계산 값 (V_...)
    private Double vPgIn;
    private Double vNoGwang;
    private Double v1stA;
    private Double v1stA2;
    private Double v1stB;
    private Double v1stB2;
    private Double v2nd;
    private Double vAdd;

    // 생성 및 반출 시각
    private String lotCreateTm;
    private String lotOutTm;

}

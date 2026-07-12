package com.cedev.api.basemng.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;  // ⭐ 추가
import lombok.AllArgsConstructor; // ⭐ 추가

@Getter
@Setter
@ToString
@NoArgsConstructor  // ⭐ 중요: Jackson 파싱을 위한 기본 생성자 자동 생성
@AllArgsConstructor // ⭐ 선택: 모든 필드를 인자로 받는 생성자 생성
public class TargetSaveDto {
    
    private String year;               
    private String reason;             
    private String userId;             
    
    @JsonProperty("gridData") 
    private List<TargetInfoDto> gridData;
            

}

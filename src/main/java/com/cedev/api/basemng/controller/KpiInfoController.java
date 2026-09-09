package com.cedev.api.basemng.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cedev.api.basemng.dto.KpiInfoDto;
import com.cedev.api.basemng.dto.KpiSaveDto;
import com.cedev.api.basemng.dto.KpiSearchDto;
import com.cedev.api.basemng.dto.LotInfoDto;
import com.cedev.api.basemng.dto.LotSearchDto;
import com.cedev.api.basemng.dto.PuInfoDto;
import com.cedev.api.basemng.dto.PuSaveDto;
import com.cedev.api.basemng.dto.PuSearchDto;
import com.cedev.api.basemng.dto.SectInfoDto;
import com.cedev.api.basemng.dto.SectSearchDto;
import com.cedev.api.basemng.dto.TargetDetailDto;
import com.cedev.api.basemng.dto.TargetInfoDto;
import com.cedev.api.basemng.dto.TargetMasterDto;
import com.cedev.api.basemng.dto.TargetSaveDto;
import com.cedev.api.basemng.dto.TargetSearchDto;
import com.cedev.api.basemng.dto.WaveInfoDto;
import com.cedev.api.basemng.dto.WaveSaveDto;
import com.cedev.api.basemng.dto.WaveSearchDto;
import com.cedev.api.basemng.service.KpiInfoService;
import com.cedev.api.realestate.dto.EntireMonthlyTradeVolumeDto;
import com.cedev.api.realestate.dto.HousingTradeInfoDto;
import com.cedev.api.realestate.dto.HousingTradePriceInfoDto;
import com.cedev.api.realestate.dto.HousingTradeVolumeDto;
import com.cedev.api.realestate.dto.HousingTradeVolumeMonthlyDto;
import com.cedev.api.realestate.dto.RealInfoSearchDto;
import com.cedev.api.realestate.dto.RecentTransactionDto;
import com.cedev.api.realestate.dto.RealEstateDetailDto;
import com.cedev.api.realestate.dto.SigunguMonthlyTradeVolumeDto;
import com.cedev.api.realestate.service.RealInfoService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class KpiInfoController {

	
    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------	
    private final KpiInfoService kpiInfoService;

    public KpiInfoController(KpiInfoService kpiInfoService) {
        this.kpiInfoService = kpiInfoService;
    }
    
    //-------------------------------------------------------------------------------------------
    // wave
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/basemng-wave-info")
    public List<WaveInfoDto> getWaveInfoList(WaveSearchDto searchDto) {

        return kpiInfoService.getWaveInfoList(searchDto);
    }
    
    @PostMapping("/api/basemng-wave-info/save")
    public Map<String, Object> saveWaveInfo(@RequestBody WaveSaveDto saveDto) {

        Map<String, Object> result = new HashMap<>();
        
        try {
            // 💡 서비스 단 비즈니스 로직 호출 및 생성된 14자리 이력 번호(BIGINT) 리턴
            Long generatedHistId = kpiInfoService.saveWaveInfo(saveDto);
            
            result.put("status", "SUCCESS");
            result.put("message", "성공");
            //result.put("histId", generatedHistId); // 생성된 실시간 이력 아이디 전달
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "FAIL");
            result.put("message", "저장 실패: " + e.getMessage());
            //result.put("histId", null);
        }
        
        return result;    	
    }       
    
    //-------------------------------------------------------------------------------------------
    // pu
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/basemng-pu-info")
    public List<PuInfoDto> getPuInfoList(PuSearchDto searchDto) {

        return kpiInfoService.getPuInfoList(searchDto);
    }        
    
    @PostMapping("/api/basemng-pu-info/save")
    public Map<String, Object> savePuInfo(@RequestBody PuSaveDto saveDto) {

        Map<String, Object> result = new HashMap<>();
        
        try {
            // 💡 서비스 단 비즈니스 로직 호출 및 생성된 14자리 이력 번호(BIGINT) 리턴
            Long generatedHistId = kpiInfoService.savePuInfo(saveDto);
            
            result.put("status", "SUCCESS");
            result.put("message", "성공");
            //result.put("histId", generatedHistId); // 생성된 실시간 이력 아이디 전달
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "FAIL");
            result.put("message", "저장 실패: " + e.getMessage());
            //result.put("histId", null);
        }
        
        return result;    	
    }       
    
    //-------------------------------------------------------------------------------------------
    // Section
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/basemng-section-info")
    public List<SectInfoDto> getSectInfoList(SectSearchDto searchDto) {

        return kpiInfoService.getSectInfoList(searchDto);
    }      
    
     
    
    //-------------------------------------------------------------------------------------------
    // Lot
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/basemng-lot-info")
    public List<LotInfoDto> getLotInfoList(LotSearchDto searchDto) {

        return kpiInfoService.getLotInfoList(searchDto);
    }          


    //-------------------------------------------------------------------------------------------
    // target
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/basemng-target-info")
    public List<TargetInfoDto> getTargetInfoList(TargetSearchDto searchDto) {

        return kpiInfoService.getTargetInfoList(searchDto);
    }        
    
    @GetMapping("/api/basemng-target-his-master")
    public List<TargetMasterDto> getTargetMaster(TargetSearchDto searchDto) {

        return kpiInfoService.getTargetHisMaster(searchDto);
    }          
    
    @GetMapping("/api/basemng-target-his-detail")
    public List<TargetDetailDto> getTargetDetail(TargetSearchDto searchDto) {

        return kpiInfoService.getTargetHisDetail(searchDto);
    }              
    
    //-------------------------------------------------------------------------------------------
    // kpi
    //-------------------------------------------------------------------------------------------
    @GetMapping("/api/basemng-kpi-info")
    public List<KpiInfoDto> getKpiInfoList(KpiSearchDto searchDto) {

        return kpiInfoService.getKpiInfoList(searchDto);
    }            
    
    @PostMapping("/api/basemng-kpi-info/save")
    public Map<String, Object> saveKpiInfo(@RequestBody KpiSaveDto saveDto) {

        Map<String, Object> result = new HashMap<>();
        
        try {
            // 💡 서비스 단 비즈니스 로직 호출 및 생성된 14자리 이력 번호(BIGINT) 리턴
            Long generatedHistId = kpiInfoService.saveKpiInfo(saveDto);
            
            result.put("status", "SUCCESS");
            result.put("message", "성공");
            result.put("histId", generatedHistId); // 생성된 실시간 이력 아이디 전달
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "FAIL");
            result.put("message", "저장 실패: " + e.getMessage());
            result.put("histId", null);
        }
        
        return result;    	
    }        
    
    
    //-------------------------------------------------------------------------------------------
    // Target(목표)
    //-------------------------------------------------------------------------------------------    
    @PostMapping("/api/basemng-target-info/save")
    public Map<String, Object> saveTargetInfo(@RequestBody TargetSaveDto saveDto) {

        Map<String, Object> result = new HashMap<>();
        
        try {
            // 💡 서비스 단 비즈니스 로직 호출 및 생성된 14자리 이력 번호(BIGINT) 리턴
            Long generatedHistId = kpiInfoService.saveTargetSnapshot(saveDto);
            
            result.put("status", "SUCCESS");
            result.put("message", "성공");
            result.put("histId", generatedHistId); // 생성된 실시간 이력 아이디 전달
            
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", "FAIL");
            result.put("message", "저장 실패: " + e.getMessage());
            result.put("histId", null);
        }
        
        return result;    	
    }        
}
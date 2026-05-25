package com.cedev.api.data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cedev.api.data.dto.EstateItem;
import com.cedev.api.data.dto.EstateRentItem;
import com.cedev.api.data.service.DataService;

@RestController
@RequestMapping("/api/data")
public class DataController {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    //-------------------------------------------------------------------------------------------
    // 부동산 매매 데이터 저장 API
    //-------------------------------------------------------------------------------------------
    @PostMapping("/estate/insert-housTrad")
    public String insertHousTardData(
            @RequestParam("tableNm") String tableNm,
            @RequestParam("dt") String dt,
            @RequestBody List<EstateItem> list) {

        dataService.insertHousTradData(list, tableNm, dt);

        return "OK";
    }
    
    //-------------------------------------------------------------------------------------------
    // 부동산 매매 데이터 저장 API
    //-------------------------------------------------------------------------------------------
    @PostMapping("/estate/insert-housRent")
    public String insertHousRentData(
            @RequestParam("tableNm") String tableNm,
            @RequestParam("dt") String dt,
            @RequestBody List<EstateRentItem> list) {

        dataService.insertHousRentData(list, tableNm, dt);

        return "OK";
    }    
}
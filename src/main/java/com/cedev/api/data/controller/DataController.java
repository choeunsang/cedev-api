package com.cedev.api.data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cedev.api.data.dto.EstateItem;
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
    // 부동산 데이터 저장 API
    //-------------------------------------------------------------------------------------------
    @PostMapping("/estate")
    public String insertEstateData(
            @RequestParam("tableNm") String tableNm,
            @RequestParam("dt") String dt,
            @RequestBody List<EstateItem> list) {

        dataService.insertEstateDataToDB(list, tableNm, dt);

        return "OK";
    }
}
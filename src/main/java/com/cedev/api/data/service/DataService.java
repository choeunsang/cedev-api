package com.cedev.api.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cedev.api.data.repository.DataRepository;
import com.cedev.api.data.dto.EstateItem;
import com.cedev.api.data.dto.EstateRentItem;

@Service
public class DataService {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    //-------------------------------------------------------------------------------------------
    // 부동산 매매 데이터 저장
    //-------------------------------------------------------------------------------------------
    @Transactional    
    public void insertHousTradData(List<EstateItem> list, String tableNm, String dt) {

        //-------------------------------------------------------------------------------------------
        // Declare and initialize variables
        //-------------------------------------------------------------------------------------------
        String contYear = dt.substring(0, 6);

        //-------------------------------------------------------------------------------------------
        // Processing
        //-------------------------------------------------------------------------------------------
        dataRepository.deleteHousTradData(tableNm, contYear);
        dataRepository.insertHousTradData(tableNm, list);
    }
    
    //-------------------------------------------------------------------------------------------
    // 부동산 전월세 데이터 저장
    //-------------------------------------------------------------------------------------------
    @Transactional    
    public void insertHousRentData(List<EstateRentItem> list, String tableNm, String dt) {

        //-------------------------------------------------------------------------------------------
        // Declare and initialize variables
        //-------------------------------------------------------------------------------------------
        String contYear = dt.substring(0, 6);

        //-------------------------------------------------------------------------------------------
        // Processing
        //-------------------------------------------------------------------------------------------
        dataRepository.deleteHousRentData(tableNm, contYear);
        dataRepository.insertHousRentData(tableNm, list);
    }    
}
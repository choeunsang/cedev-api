package com.cedev.api.data.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cedev.api.data.repository.DataRepository;
import com.cedev.api.data.dto.EstateItem;

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
    // 부동산 데이터 저장
    //-------------------------------------------------------------------------------------------
    @Transactional    
    public void insertEstateDataToDB(List<EstateItem> list, String tableNm, String dt) {

        //-------------------------------------------------------------------------------------------
        // Declare and initialize variables
        //-------------------------------------------------------------------------------------------
        String contYear = dt.substring(0, 6);

        //-------------------------------------------------------------------------------------------
        // Processing
        //-------------------------------------------------------------------------------------------
        //dataRepository.deleteBackupData(tableNm);
        //dataRepository.insertBackupData(tableNm, contYear);
        dataRepository.deleteRealData(tableNm, contYear);
        dataRepository.insertEstateData(tableNm, list);
    }
}
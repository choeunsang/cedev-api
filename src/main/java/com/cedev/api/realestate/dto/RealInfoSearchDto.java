package com.cedev.api.realestate.dto;

public class RealInfoSearchDto {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private String sido;
    private String sigungu = "";
    private String dong = "";
    private String dangi = "";
    private String dediArea = "";
    private String startYearMonth;
    private String endYearMonth;


    //-------------------------------------------------------------------------------------------
    // Getter and Setter
    //-------------------------------------------------------------------------------------------
    public String getSido() {
        return sido;
    }

    public void setSido(String sido) {
        this.sido = sido;
    }

    public String getSigungu() {
        return sigungu;
    }

    public void setSigungu(String sigungu) {
        this.sigungu = sigungu;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getDangi() {
        return dangi;
    }

    public void setDangi(String dangi) {
        this.dangi = dangi;
    }

    public String getDediArea() {
        return dediArea;
    }

    public void setDediArea(String dediArea) {
        this.dediArea = dediArea;
    }

    public String getStartYearMonth() {
        return startYearMonth;
    }

    public void setStartYearMonth(String startYearMonth) {
        this.startYearMonth = startYearMonth;
    }

    public String getEndYearMonth() {
        return endYearMonth;
    }

    public void setEndYearMonth(String endYearMonth) {
        this.endYearMonth = endYearMonth;
    }
}
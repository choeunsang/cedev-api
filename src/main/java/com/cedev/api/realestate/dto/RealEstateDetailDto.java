package com.cedev.api.realestate.dto;

public class RealEstateDetailDto {

    private String city;
    private String sido;
    private String sigungu;
    private String dong;
    private String dangi;
    private String dediArea;
    private int avgAmount;
    private int cnt;
    private String contYear;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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

    public int getAvgAmount() {
        return avgAmount;
    }

    public void setAvgAmount(int avgAmount) {
        this.avgAmount = avgAmount;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getContYear() {
        return contYear;
    }

    public void setContYear(String contYear) {
        this.contYear = contYear;
    }
}
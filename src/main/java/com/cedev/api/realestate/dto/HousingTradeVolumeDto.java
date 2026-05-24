package com.cedev.api.realestate.dto;

public class HousingTradeVolumeDto {

    private String sido;
    private String sigungu;
    private String dong;
    private String contYear;
    private int cnt;

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

    public String getContYear() {
        return contYear;
    }

    public void setContYear(String contYear) {
        this.contYear = contYear;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
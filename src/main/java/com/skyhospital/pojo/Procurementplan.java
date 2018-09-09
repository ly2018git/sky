package com.skyhospital.pojo;

public class Procurementplan {
    private Integer PPId;

    private Integer medicineId;

    private Integer lower;

    private Integer PPNumber;

    private String PPOrganization;

    private Integer isdel;

    public Integer getPPId() {
        return PPId;
    }

    public void setPPId(Integer PPId) {
        this.PPId = PPId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getLower() {
        return lower;
    }

    public void setLower(Integer lower) {
        this.lower = lower;
    }

    public Integer getPPNumber() {
        return PPNumber;
    }

    public void setPPNumber(Integer PPNumber) {
        this.PPNumber = PPNumber;
    }

    public String getPPOrganization() {
        return PPOrganization;
    }

    public void setPPOrganization(String PPOrganization) {
        this.PPOrganization = PPOrganization == null ? null : PPOrganization.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
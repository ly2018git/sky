package com.skyhospital.pojo;

public class Dosageforms {
    private Integer dosageFormsId;

    private String dosageFormsName;

    private Integer isdel;

    public Integer getDosageFormsId() {
        return dosageFormsId;
    }

    public void setDosageFormsId(Integer dosageFormsId) {
        this.dosageFormsId = dosageFormsId;
    }

    public String getDosageFormsName() {
        return dosageFormsName;
    }

    public void setDosageFormsName(String dosageFormsName) {
        this.dosageFormsName = dosageFormsName == null ? null : dosageFormsName.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
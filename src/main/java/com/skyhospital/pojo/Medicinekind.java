package com.skyhospital.pojo;

public class Medicinekind {
    private Integer medicineKindId;

    private String medicineKindName;

    private Integer isdel;

    public Integer getMedicineKindId() {
        return medicineKindId;
    }

    public void setMedicineKindId(Integer medicineKindId) {
        this.medicineKindId = medicineKindId;
    }

    public String getMedicineKindName() {
        return medicineKindName;
    }

    public void setMedicineKindName(String medicineKindName) {
        this.medicineKindName = medicineKindName == null ? null : medicineKindName.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
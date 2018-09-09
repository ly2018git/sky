package com.skyhospital.pojo;

public class Sellitem {
    private Integer sellItem;

    private String sellAccountId;

    private Integer medicineId;

    private Integer number;

    private Integer isdel;

    public Integer getSellItem() {
        return sellItem;
    }

    public void setSellItem(Integer sellItem) {
        this.sellItem = sellItem;
    }

    public String getSellAccountId() {
        return sellAccountId;
    }

    public void setSellAccountId(String sellAccountId) {
        this.sellAccountId = sellAccountId == null ? null : sellAccountId.trim();
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
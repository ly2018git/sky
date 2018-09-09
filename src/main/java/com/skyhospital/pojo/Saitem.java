package com.skyhospital.pojo;

import java.util.Date;

public class Saitem {
    private Integer SAItemId;

    private String storageAccountId;

    private Integer medicineId;

    private Integer manufacturerId;

    private Integer buyerId;

    private String batchNumber;

    private Integer number;

    private Date validity;

    private Integer audit;

    private Integer isdel;

    public Integer getSAItemId() {
        return SAItemId;
    }

    public void setSAItemId(Integer SAItemId) {
        this.SAItemId = SAItemId;
    }

    public String getStorageAccountId() {
        return storageAccountId;
    }

    public void setStorageAccountId(String storageAccountId) {
        this.storageAccountId = storageAccountId == null ? null : storageAccountId.trim();
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer supplierId) {
        this.manufacturerId = supplierId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
package com.skyhospital.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Warehouse {
    private Integer warehouseId;

    private Integer SAItemId;

    private Integer GAID;

    private Integer medicineId;

    private String handling;

    private Integer inventoryFloor;

    private String MedicineName;

    private Integer number;

    private Integer isdel;

    //郑少秋
    //begin------------------>添加字段
    private String commonName;//通用名

    private String specificationName;//规格名

    private String manufacturerName;//工厂名

    private String unitName;//单位名

    private String comment;//g.comment 货位名

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date validity;//有效期

    private String batchNumber;//批号

    private BigDecimal salePrice;//出售价

    private BigDecimal purchasePrice;//采购价

    private BigDecimal profit;//利润

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date ioDate;//入出库日期

    private Integer dosageFormsId;//剂型id

    private String dosageFormsName;//剂型名

    private String mComment;//备注
    //end-------------------->


    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public Date getIoDate() {
        return ioDate;
    }

    public void setIoDate(Date ioDate) {
        this.ioDate = ioDate;
    }

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
        this.dosageFormsName = dosageFormsName;
    }

    public String getmComment() {
        return mComment;
    }

    public void setmComment(String mComment) {
        this.mComment = mComment;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return MedicineName;
    }

    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getSAItemId() {
        return SAItemId;
    }

    public void setSAItemId(Integer SAItemId) {
        this.SAItemId = SAItemId;
    }

    public Integer getGAID() {
        return GAID;
    }

    public void setGAID(Integer GAID) {
        this.GAID = GAID;
    }

    public Integer getInventoryFloor() {
        return inventoryFloor;
    }

    public void setInventoryFloor(Integer inventoryFloor) {
        this.inventoryFloor = inventoryFloor;
    }

    public String getHandling() {
        return handling;
    }

    public void setHandling(String handling) {
        this.handling = handling == null ? null : handling.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId=" + warehouseId +
                ", SAItemId=" + SAItemId +
                ", GAID=" + GAID +
                ", medicineId=" + medicineId +
                ", handling='" + handling + '\'' +
                ", inventoryFloor=" + inventoryFloor +
                ", MedicineName='" + MedicineName + '\'' +
                ", number=" + number +
                ", isdel=" + isdel +
                ", commonName='" + commonName + '\'' +
                ", specificationName='" + specificationName + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", unitName='" + unitName + '\'' +
                ", comment='" + comment + '\'' +
                ", validity=" + validity +
                ", batchNumber='" + batchNumber + '\'' +
                ", salePrice=" + salePrice +
                ", purchasePrice=" + purchasePrice +
                ", profit=" + profit +
                ", ioDate=" + ioDate +
                ", dosageFormsId=" + dosageFormsId +
                ", dosageFormsName='" + dosageFormsName + '\'' +
                ", handling='" + handling + '\'' +
                ", mComment='" + mComment + '\'' +
                '}';
    }
}
package com.skyhospital.pojo;

import java.math.BigDecimal;

public class Counter {
    private Integer counterId;//柜台id

    private Integer MedicineId;//药品id

    private Integer GAID;//货位表id

    private Integer number;//数量

    private Integer upper;//柜台上限

    private Integer lower;//柜台下限



    private Integer isdel;

    //额外的参数
    private String medicineName;//药品名称
    private String commonName;//通用名
    private String specificationName;//规格名称
    private String manufacturerName;//厂家
    private Integer isPrescription;//是否为处方药
    private BigDecimal salePrice;//销售价
    private String ganame;//货位名称

    public String getGaname() {
        return ganame;
    }

    public void setGaname(String ganame) {
        this.ganame = ganame;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getIsPrescription() {
        return isPrescription;
    }

    public void setIsPrescription(Integer isPrescription) {
        this.isPrescription = isPrescription;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getCounterId() {
        return counterId;
    }

    public void setCounterId(Integer counterId) {
        this.counterId = counterId;
    }

    public Integer getMedicineId() {
        return MedicineId;
    }

    public void setMedicineId(Integer medicineId) {
        MedicineId = medicineId;
    }

    public Integer getGAID() {
        return GAID;
    }

    public void setGAID(Integer GAID) {
        this.GAID = GAID;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getUpper() {
        return upper;
    }

    public void setUpper(Integer upper) {
        this.upper = upper;
    }

    public Integer getLower() {
        return lower;
    }

    public void setLower(Integer lower) {
        this.lower = lower;
    }

    public Integer getIsdel() {
        return isdel;
    }



    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
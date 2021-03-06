package com.skyhospital.pojo;

import java.math.BigDecimal;

public class Medicine {
    private Integer medicineId;//药品编号

    private String medicineName;//药品商用名

    private String commonName;//通用名

    private String specificationId;

    private Integer manufacturerId;

    private Integer unitId;

    private Integer dosageFormsId;

    private Integer goodsKindId;

    private Integer MCKId;

    private Integer tinyUnitId;

    private String modifierId;

    private Integer medicineKindId;

    private String tinySpecification;

    private String barCode;

    private BigDecimal retailStdPrice;//国家零售价

    private BigDecimal purchasePrice;//采购价

    private Integer isPrescription;//是否为处方药

    private BigDecimal salePrice;//销售价

    private String comment;//备注

    private String standardCode;//本位码（标准）

    private Integer isHealthCare;

    private Integer isdel;

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName == null ? null : commonName.trim();
    }

    public String getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(String specificationId) {
        this.specificationId = specificationId == null ? null : specificationId.trim();
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getDosageFormsId() {
        return dosageFormsId;
    }

    public void setDosageFormsId(Integer dosageFormsId) {
        this.dosageFormsId = dosageFormsId;
    }

    public Integer getGoodsKindId() {
        return goodsKindId;
    }

    public void setGoodsKindId(Integer goodsKindId) {
        this.goodsKindId = goodsKindId;
    }

    public Integer getMCKId() {
        return MCKId;
    }

    public void setMCKId(Integer MCKId) {
        this.MCKId = MCKId;
    }

    public Integer getTinyUnitId() {
        return tinyUnitId;
    }

    public void setTinyUnitId(Integer tinyUnitId) {
        this.tinyUnitId = tinyUnitId;
    }

    public String getModifierId() {
        return modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId == null ? null : modifierId.trim();
    }

    public Integer getMedicineKindId() {
        return medicineKindId;
    }

    public void setMedicineKindId(Integer medicineKindId) {
        this.medicineKindId = medicineKindId;
    }

    public String getTinySpecification() {
        return tinySpecification;
    }

    public void setTinySpecification(String tinySpecification) {
        this.tinySpecification = tinySpecification == null ? null : tinySpecification.trim();
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public BigDecimal getRetailStdPrice() {
        return retailStdPrice;
    }

    public void setRetailStdPrice(BigDecimal retailStdPrice) {
        this.retailStdPrice = retailStdPrice;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getIsPrescription() {
        return isPrescription;
    }

    public void setIsPrescription(Integer isPrescription) {
        this.isPrescription = isPrescription;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode == null ? null : standardCode.trim();
    }

    public Integer getIsHealthCare() {
        return isHealthCare;
    }

    public void setIsHealthCare(Integer isHealthCare) {
        this.isHealthCare = isHealthCare;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
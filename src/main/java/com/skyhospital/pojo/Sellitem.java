package com.skyhospital.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

public class Sellitem {
    private Integer sellItem;

    private String sellAccountId;

    private Integer medicineId;//药品id

    private Integer number;//销售数量

    private Integer isdel;
    //额外的参数
    private Date sellDate1;//销售日期1

    private  Date sellDate2;//销售日期2

    public Date getSellDate1() {
        return sellDate1;
    }

    public void setSellDate1(Date sellDate1) {
        this.sellDate1 = sellDate1;
    }

    public Date getSellDate2() {
        return sellDate2;
    }

    public void setSellDate2(Date sellDate2) {
        this.sellDate2 = sellDate2;
    }

    private String medicineName;//药品名称
    private String commonName;//通用名
    private String specificationName;//规格名称
    private String standardCode;//本位码（标准）
    private Integer isPrescription;//是否为处方药
    private BigDecimal purchasePrice;//采购价
    private BigDecimal retailStdPrice;//国家零售价
    private String comment;//备注
    @JSONField(format="yyyy-MM-dd")
    private Date sellDate;//销售日期
    private String manufacturerName;//厂家
//销售明细额外参数
    private String dosageFormsName;//剂型名称
    private String unitName;//药品单位名称
    private String payWay;//支付方式
    private BigDecimal actuallyPaid;//实付金额
    private String salesman;//销售员
    private BigDecimal amount;//总价

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public BigDecimal getActuallyPaid() {
        return actuallyPaid;
    }

    public void setActuallyPaid(BigDecimal actuallyPaid) {
        this.actuallyPaid = actuallyPaid;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getDosageFormsName() {
        return dosageFormsName;
    }

    public void setDosageFormsName(String dosageFormsName) {
        this.dosageFormsName = dosageFormsName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getRetailStdPrice() {
        return retailStdPrice;
    }

    public void setRetailStdPrice(BigDecimal retailStdPrice) {
        this.retailStdPrice = retailStdPrice;
    }

    public Integer getIsPrescription() {
        return isPrescription;
    }

    public void setIsPrescription(Integer isPrescription) {
        this.isPrescription = isPrescription;
    }

    public String getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
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
package com.skyhospital.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

public class Saitem {
    private Integer SAItemId;

    private String storageAccountId;//账单编号

    private Integer medicineId;//药品id

    private Integer supplierId;//厂家id

    private Integer buyerId;//买家id

    private String batchNumber;//批号

    private Integer number;//数量

    private Date validity;//有效期

    private Integer audit;//审核状态

    private Integer isdel;//是否删除

    //额外的参数
    private String medicineName;//药品商用名
    private String commonName;//通用名
    private String invoice;//发票号
    private String specificationName;//规格名称
    private String unitName;//药品单位名称
    private String manufacturerName;//厂家
    private Integer surplus;//剩余天数
    @JSONField(format="yyyy-MM-dd")
    private Date IODate;//入/出库时间
    private BigDecimal actuallyPaid;//实付金额
    private BigDecimal purchasePrice;//采购价
    private BigDecimal due;//应付金额
    private String dosageFormsName;//剂型名称
    private String comment;//备注
    private BigDecimal amount;//总价

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDosageFormsName() {
        return dosageFormsName;
    }

    public void setDosageFormsName(String dosageFormsName) {
        this.dosageFormsName = dosageFormsName;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getActuallyPaid() {
        return actuallyPaid;
    }

    public void setActuallyPaid(BigDecimal actuallyPaid) {
        this.actuallyPaid = actuallyPaid;
    }

    public BigDecimal getDue() {
        return due;
    }

    public void setDue(BigDecimal due) {
        this.due = due;
    }

    public Date getIODate() {
        return IODate;
    }

    public void setIODate(Date IODate) {
        this.IODate = IODate;
    }

    public Integer getSurplus() {
        return surplus;
    }

    public void setSurplus(Integer surplus) {
        this.surplus = surplus;
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

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

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

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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
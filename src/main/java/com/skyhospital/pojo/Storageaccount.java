package com.skyhospital.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Storageaccount {
    private String storageAccountId;

    private Date IODate;

    private String IOUnit;

    private BigDecimal amount;

    private BigDecimal actuallyPaid;

    private BigDecimal due;

    private String invoice;

    private String comment;

    private Date closingDate;

    private Integer isdel;

    public String getStorageAccountId() {
        return storageAccountId;
    }

    public void setStorageAccountId(String storageAccountId) {
        this.storageAccountId = storageAccountId == null ? null : storageAccountId.trim();
    }

    public Date getIODate() {
        return IODate;
    }

    public void setIODate(Date IODate) {
        this.IODate = IODate;
    }

    public String getIOUnit() {
        return IOUnit;
    }

    public void setIOUnit(String IOUnit) {
        this.IOUnit = IOUnit == null ? null : IOUnit.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice == null ? null : invoice.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
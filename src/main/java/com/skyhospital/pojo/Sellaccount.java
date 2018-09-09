package com.skyhospital.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Sellaccount {
    private String sellAccountId;

    private Integer UID;

    private Date sellDate;

    private String vipId;

    private BigDecimal amount;

    private BigDecimal actuallyPaid;

    private BigDecimal due;

    private BigDecimal cutAmount;

    private String cutComment;

    private String payWay;

    private String comment;

    private Date closingDate;

    private String salesman;

    private Integer isdel;

    public String getSellAccountId() {
        return sellAccountId;
    }

    public void setSellAccountId(String sellAccountId) {
        this.sellAccountId = sellAccountId == null ? null : sellAccountId.trim();
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID == null ? null : UID;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public String getVipId() {
        return vipId;
    }

    public void setVipId(String vipId) {
        this.vipId = vipId == null ? null : vipId.trim();
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

    public BigDecimal getCutAmount() {
        return cutAmount;
    }

    public void setCutAmount(BigDecimal cutAmount) {
        this.cutAmount = cutAmount;
    }

    public String getCutComment() {
        return cutComment;
    }

    public void setCutComment(String cutComment) {
        this.cutComment = cutComment == null ? null : cutComment.trim();
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
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

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman == null ? null : salesman.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
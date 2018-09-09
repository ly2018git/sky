package com.skyhospital.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

public class Sellaccount {
    private String sellAccountId;//销售账单号

    private Integer UID;//用户表id
    @JSONField(format="yyyy-MM-dd")
    private Date sellDate;//销售日期

    private  Integer counterId;//柜台id

    private Integer vipId;//会员表id  主键

    private BigDecimal amount;//销售总额

    private BigDecimal actuallyPaid;//实付金额

    private BigDecimal due;//应付金额

    private BigDecimal cutAmount;//减免金额

    private String cutComment;//减免说明

    private String payWay;//支付方式

    private String comment;//账单备注
    @JSONField(format="yyyy-MM-dd")
    private Date closingDate;//结算日期

    private String salesman;//销售员

    private Integer isdel;//是否删除

    //额外的参数
    private Date sellDate1;
    private Date sellDate2;

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

    public Integer getCounterId() {
        return counterId;
    }

    public void setCounterId(Integer counterId) {
        this.counterId = counterId;
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
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
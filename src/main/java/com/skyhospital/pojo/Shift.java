package com.skyhospital.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Shift {
    private Integer shiftId;

    private Integer UID;//交班人id

    private Date shiftTime;//交班时间

    private BigDecimal money;//钱箱金额

    private String comment;//钱箱说明

    private Integer isdel;

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID == null ? null : UID;
    }

    public Date getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(Date shiftTime) {
        this.shiftTime = shiftTime;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
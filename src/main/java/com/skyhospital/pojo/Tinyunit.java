package com.skyhospital.pojo;

public class Tinyunit {
    private Integer tinyUnitId;

    private String tinyUnitName;

    private Integer isdel;

    public Integer getTinyUnitId() {
        return tinyUnitId;
    }

    public void setTinyUnitId(Integer tinyUnitId) {
        this.tinyUnitId = tinyUnitId;
    }

    public String getTinyUnitName() {
        return tinyUnitName;
    }

    public void setTinyUnitName(String tinyUnitName) {
        this.tinyUnitName = tinyUnitName == null ? null : tinyUnitName.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
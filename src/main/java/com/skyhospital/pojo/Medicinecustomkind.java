package com.skyhospital.pojo;

public class Medicinecustomkind {
    private Integer MCKId;

    private String MCKName;

    private Integer isdel;

    public Integer getMCKId() {
        return MCKId;
    }

    public void setMCKId(Integer MCKId) {
        this.MCKId = MCKId;
    }

    public String getMCKName() {
        return MCKName;
    }

    public void setMCKName(String MCKName) {
        this.MCKName = MCKName == null ? null : MCKName.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
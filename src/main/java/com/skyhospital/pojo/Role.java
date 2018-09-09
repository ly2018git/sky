package com.skyhospital.pojo;

public class Role {
    private String RID;

    private String RName;

    private Integer isdel;

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID == null ? null : RID.trim();
    }

    public String getRName() {
        return RName;
    }

    public void setRName(String RName) {
        this.RName = RName == null ? null : RName.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
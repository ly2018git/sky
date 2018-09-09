package com.skyhospital.pojo;

public class Menu {
    private Integer MID;

    private String MName;

    private Integer isdel;

    public Integer getMID() {
        return MID;
    }

    public void setMID(Integer MID) {
        this.MID = MID;
    }

    public String getMName() {
        return MName;
    }

    public void setMName(String MName) {
        this.MName = MName == null ? null : MName.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
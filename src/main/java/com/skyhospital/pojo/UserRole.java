package com.skyhospital.pojo;

/**
 * 项目名：skyhospital
 * 类名：UserRole
 * 描述：
 * 创建时间：2018.08.17 下午 04:48
 * 创建者: Amy
 */
public class UserRole {
    private Integer URID;
    private Integer UID;
    private String RID;
    private Integer isDel;

    public UserRole() {
    }

    public UserRole(Integer URID, Integer UID, String RID, Integer isDel) {
        this.URID = URID;
        this.UID = UID;
        this.RID = RID;
        this.isDel = isDel;
    }

    public Integer getURID() {
        return URID;
    }

    public void setURID(Integer URID) {
        this.URID = URID;
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}

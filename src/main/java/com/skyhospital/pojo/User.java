package com.skyhospital.pojo;

import java.util.Date;

public class User {
    private Integer UID;

    private String UName;

    private String loginPwd;

    private Integer sex;

    private String RID;

    private String phone;

    private String address;

    private String photo;

    private String email;

    private Date bortDate;

    private Integer isdel;

    /**
     * 根据需求添加字段：Role
     */
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID == null ? null : UID;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName == null ? null : UName.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID == null ? null : RID.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Date getBortDate() {
        return bortDate;
    }

    public void setBortDate(Date bortDate) {
        this.bortDate = bortDate;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }


    @Override
    public String toString() {
        return  "UID=" + UID +
                "&UName=" + UName +
                "&loginPwd=" + loginPwd +
                "&sex=" + sex +
                "&RID=" + RID +
                "&phone=" + phone +
                "&address=" + address +
                "&photo=" + photo +
                "&email=" + email +
                "&bortDate=" + bortDate +
                "&isdel=" + isdel +
                "&role=" + getRole().getRName() + "\n";
    }
}

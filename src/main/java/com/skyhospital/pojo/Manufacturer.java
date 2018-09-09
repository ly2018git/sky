package com.skyhospital.pojo;

public class Manufacturer {
    private Integer manufacturerId;

    private String manufacturerName;

    private String shor;

    private Integer isdel;

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName == null ? null : manufacturerName.trim();
    }

    public String getShor() {
        return shor;
    }

    public void setShor(String shor) {
        this.shor = shor == null ? null : shor.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
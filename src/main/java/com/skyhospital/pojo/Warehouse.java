package com.skyhospital.pojo;

public class Warehouse {
    private Integer warehouseId;//仓库id

    private Integer SAItemId;

    private Integer GAID;

    private Integer medicineId;//药品id

    private String medicineName;//药品商用名

    private Integer number; //库存数量

    private Integer inventoryFloor;

    private String handling;

    private Integer isdel;

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getSAItemId() {
        return SAItemId;
    }

    public void setSAItemId(Integer SAItemId) {
        this.SAItemId = SAItemId;
    }

    public Integer getGAID() {
        return GAID;
    }

    public void setGAID(Integer GAID) {
        this.GAID = GAID;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getInventoryFloor() {
        return inventoryFloor;
    }

    public void setInventoryFloor(Integer inventoryFloor) {
        this.inventoryFloor = inventoryFloor;
    }

    public String getHandling() {
        return handling;
    }

    public void setHandling(String handling) {
        this.handling = handling == null ? null : handling.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
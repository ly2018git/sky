package com.skyhospital.pojo;

public class Goodskind {
    private Integer goodsKindId;

    private String goodsKindName;

    private Integer isdel;

    public Integer getGoodsKindId() {
        return goodsKindId;
    }

    public void setGoodsKindId(Integer goodsKindId) {
        this.goodsKindId = goodsKindId;
    }

    public String getGoodsKindName() {
        return goodsKindName;
    }

    public void setGoodsKindName(String goodsKindName) {
        this.goodsKindName = goodsKindName == null ? null : goodsKindName.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
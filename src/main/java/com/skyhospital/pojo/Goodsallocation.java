package com.skyhospital.pojo;

public class Goodsallocation {
    private Integer GAID;

    private String GAName;

    private String comment;

    private Integer isdel;

    public Integer getGAID() {
        return GAID;
    }

    public void setGAID(Integer GAID) {
        this.GAID = GAID;
    }

    public String getGAName() {
        return GAName;
    }

    public void setGAName(String GAName) {
        this.GAName = GAName == null ? null : GAName.trim();
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
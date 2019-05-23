package com.ken.wms.domain;

public class Shop {
    private Integer shopId;

    private String shopName;

    private String shopAddress;

    private String picName;

    private String picTel;

    private String shopTel;

    private String remark0;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress == null ? null : shopAddress.trim();
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    public String getPicTel() {
        return picTel;
    }

    public void setPicTel(String picTel) {
        this.picTel = picTel == null ? null : picTel.trim();
    }

    public String getShopTel() {
        return shopTel;
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel == null ? null : shopTel.trim();
    }

    public String getRemark0() {
        return remark0;
    }

    public void setRemark0(String remark0) {
        this.remark0 = remark0 == null ? null : remark0.trim();
    }
}
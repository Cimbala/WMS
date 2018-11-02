package com.ken.wms.domain;

import java.io.Serializable;
import java.util.Date;

public class OrderIn  implements Serializable {
    private Integer orderInId;

    private Integer orderInSupplierid;

    private Integer orderInGoodid;

    private Integer orderInNumber;

    private Date orderInTime;

    private String orderInPersion;

    private Integer systemFlag;

    private String remark0;

    private String remakr1;

    public Integer getOrderInId() {
        return orderInId;
    }

    public void setOrderInId(Integer orderInId) {
        this.orderInId = orderInId;
    }

    public Integer getOrderInSupplierid() {
        return orderInSupplierid;
    }

    public void setOrderInSupplierid(Integer orderInSupplierid) {
        this.orderInSupplierid = orderInSupplierid;
    }

    public Integer getOrderInGoodid() {
        return orderInGoodid;
    }

    public void setOrderInGoodid(Integer orderInGoodid) {
        this.orderInGoodid = orderInGoodid;
    }

    public Integer getOrderInNumber() {
        return orderInNumber;
    }

    public void setOrderInNumber(Integer orderInNumber) {
        this.orderInNumber = orderInNumber;
    }

    public Date getOrderInTime() {
        return orderInTime;
    }

    public void setOrderInTime(Date orderInTime) {
        this.orderInTime = orderInTime;
    }

    public String getOrderInPersion() {
        return orderInPersion;
    }

    public void setOrderInPersion(String orderInPersion) {
        this.orderInPersion = orderInPersion == null ? null : orderInPersion.trim();
    }

    public Integer getSystemFlag() {
        return systemFlag;
    }

    public void setSystemFlag(Integer systemFlag) {
        this.systemFlag = systemFlag;
    }

    public String getRemark0() {
        return remark0;
    }

    public void setRemark0(String remark0) {
        this.remark0 = remark0 == null ? null : remark0.trim();
    }

    public String getRemakr1() {
        return remakr1;
    }

    public void setRemakr1(String remakr1) {
        this.remakr1 = remakr1 == null ? null : remakr1.trim();
    }
}
package com.ken.wms.domain;

import java.io.Serializable;
import java.util.Date;

public class OrderOut  implements Serializable {
    private Integer orderOutId;

    private Integer orderOutCustomerid;

    private Integer orderOutGoodid;

    private Integer orderOutNumber;

    private Date orderOutTime;

    private String orderOutPersion;

    private Integer systemFlag;

    private String remark0;

    private String remakr1;

    public Integer getOrderOutId() {
        return orderOutId;
    }

    public void setOrderOutId(Integer orderOutId) {
        this.orderOutId = orderOutId;
    }

    public Integer getOrderOutCustomerid() {
        return orderOutCustomerid;
    }

    public void setOrderOutCustomerid(Integer orderOutCustomerid) {
        this.orderOutCustomerid = orderOutCustomerid;
    }

    public Integer getOrderOutGoodid() {
        return orderOutGoodid;
    }

    public void setOrderOutGoodid(Integer orderOutGoodid) {
        this.orderOutGoodid = orderOutGoodid;
    }

    public Integer getOrderOutNumber() {
        return orderOutNumber;
    }

    public void setOrderOutNumber(Integer orderOutNumber) {
        this.orderOutNumber = orderOutNumber;
    }

    public Date getOrderOutTime() {
        return orderOutTime;
    }

    public void setOrderOutTime(Date orderOutTime) {
        this.orderOutTime = orderOutTime;
    }

    public String getOrderOutPersion() {
        return orderOutPersion;
    }

    public void setOrderOutPersion(String orderOutPersion) {
        this.orderOutPersion = orderOutPersion == null ? null : orderOutPersion.trim();
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
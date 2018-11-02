package com.ken.wms.domain.vo;

import java.util.Date;

/**
 * Class: OrderOutVo
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/31
 */
public class OrderOutVo {

    private Integer orderOutId;

    private Integer orderOutCustomerid;

    private Integer orderOutGoodid;

    private Integer orderOutNumber;

    private Date orderOutTime;

    private String orderOutPersion;

    private Integer systemFlag;

    private String remark0;

    private String remakr1;

    private String customerName;

    private String goodName;

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
        this.orderOutPersion = orderOutPersion;
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
        this.remark0 = remark0;
    }

    public String getRemakr1() {
        return remakr1;
    }

    public void setRemakr1(String remakr1) {
        this.remakr1 = remakr1;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
}

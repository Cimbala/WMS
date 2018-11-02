package com.ken.wms.domain.vo;

import java.util.Date;

/**
 * Class: OrderInVo
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
public class OrderInVo {

    private Integer orderInId;

    private Integer orderInSupplierid;

    private Integer orderInGoodid;

    private Integer orderInNumber;

    private Date orderInTime;

    private String orderInPersion;

    private Integer systemFlag;

    private String remark0;

    private String remakr1;

    private String supplierName;//供应商名称

    private String goodName;//货物名称

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
        this.orderInPersion = orderInPersion;
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
}

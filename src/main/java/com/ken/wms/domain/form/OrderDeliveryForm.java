package com.ken.wms.domain.form;

import java.util.Date;

/**
 * Class: OrderDeliveryForm
 * Description:
 * Author: Alan Min
 * Createtime: 2018/11/2
 */
public class OrderDeliveryForm {

    private Integer deliveryId;

    private Integer customerId;

    private Integer goodId;

    private Integer num;

    private String customerAddr;

    private Date deliveryTime;

    private String remark0;

    private String remark1;

    private String dTimeStr_start;

    private String dTimeStr_end;

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCustomerAddr() {
        return customerAddr;
    }

    public void setCustomerAddr(String customerAddr) {
        this.customerAddr = customerAddr;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getRemark0() {
        return remark0;
    }

    public void setRemark0(String remark0) {
        this.remark0 = remark0;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getdTimeStr_start() {
        return dTimeStr_start;
    }

    public void setdTimeStr_start(String dTimeStr_start) {
        this.dTimeStr_start = dTimeStr_start;
    }

    public String getdTimeStr_end() {
        return dTimeStr_end;
    }

    public void setdTimeStr_end(String dTimeStr_end) {
        this.dTimeStr_end = dTimeStr_end;
    }
}

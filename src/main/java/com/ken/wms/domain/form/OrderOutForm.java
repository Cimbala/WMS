package com.ken.wms.domain.form;

/**
 * Class: OrderOutForm
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/31
 */
public class OrderOutForm {

    private Integer orderOutId;

    private Integer orderOutCustomerid;

    private Integer orderOutGoodid;

    private Integer orderOutNumber;

    private String orderOutPersion;

    private Integer systemFlag;

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
}

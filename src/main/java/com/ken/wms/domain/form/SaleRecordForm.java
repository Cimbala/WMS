package com.ken.wms.domain.form;

import java.util.Date;

/**
 * Class: SaleRecordForm
 * Description:
 * Author: Alan Min
 * Createtime: 2018/11/2
 */
public class SaleRecordForm {

    private Integer saleId;

    private Integer goodId;

    private Integer saleNum;

    private Integer price;

    private String unit;

    private Integer saleAmount;

    private Date saleDate;

    private String remark0;

    private String remark1;

    private String goodName;

    private String saleDateStr_start;

    private String saleDateStr_end;

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
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

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getSaleDateStr_start() {
        return saleDateStr_start;
    }

    public void setSaleDateStr_start(String saleDateStr_start) {
        this.saleDateStr_start = saleDateStr_start;
    }

    public String getSaleDateStr_end() {
        return saleDateStr_end;
    }

    public void setSaleDateStr_end(String saleDateStr_end) {
        this.saleDateStr_end = saleDateStr_end;
    }
}

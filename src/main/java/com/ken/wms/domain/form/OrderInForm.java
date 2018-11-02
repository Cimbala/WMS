package com.ken.wms.domain.form;

/**
 * Class: OrderInForm
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
public class OrderInForm {

    private Integer oid;//进货单号
    private Integer sid;//供应商ID
    private Integer gid;//货物ID
    private String name;//负责人名称
    private Integer gnum;//进货数量

    private Integer sysflag;//系统区分

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSysflag() {
        return sysflag;
    }

    public void setSysflag(Integer sysflag) {
        this.sysflag = sysflag;
    }
}

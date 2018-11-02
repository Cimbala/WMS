package com.ken.wms.common.service.Interface;

import com.ken.wms.domain.form.OrderInForm;

import java.util.Map;

/**
 * Interface: OrderInService
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
public interface OrderInService {

    //查询
    Map<String, Object> selectAll(int offset, int limit,Integer sysflag);

    Map<String, Object> selectAll(Integer sysflag);

    Map<String, Object> selectByOID(int oid,Integer sysflag);//通过进货单号查询

    Map<String, Object> selectBySID(int sid,int offset,int limit,Integer sysflag);//通过供应商ID查询

    Map<String, Object> selectByGID(int gid,int offset,int limit,Integer sysflag);//通过货物ID查询

    Map<String, Object> selectName(String name,int offset,int limit,Integer sysflag);//通过负责人名称模糊查询

    //------------------------------------------------------------------------------
    //添加
    boolean addOrderIn(OrderInForm form);
    //修改
    boolean updateOrderIn(OrderInForm form);
    //删除
    boolean deleteOrderIn(int oid);

}

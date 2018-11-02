package com.ken.wms.common.service.Interface;

import com.ken.wms.domain.form.OrderOutForm;

import java.util.Map;

/**
 * Interface: OrderInService
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
public interface OrderOutService {

    //查询
    Map<String, Object> selectAll(int offset, int limit, Integer sysflag);

    Map<String, Object> selectAll(Integer sysflag);

    Map<String, Object> selectByOID(int oid, Integer sysflag);

    Map<String, Object> selectByCID(int cid, int offset, int limit, Integer sysflag);

    Map<String, Object> selectByGID(int gid, int offset, int limit, Integer sysflag);

    Map<String, Object> selectName(String name, int offset, int limit, Integer sysflag);

    //------------------------------------------------------------------------------
    //添加
    boolean addOrderOut(OrderOutForm form);
    //修改
    boolean updateOrderOut(OrderOutForm form);
    //删除
    boolean deleteOrderOut(int oid);

}

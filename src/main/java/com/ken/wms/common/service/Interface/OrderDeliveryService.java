package com.ken.wms.common.service.Interface;



import com.ken.wms.domain.form.OrderDeliveryForm;

import java.util.Map;

/**
 * Interface: OrderInService
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
public interface OrderDeliveryService {

    //查询
    Map<String, Object> selectAll(int offset, int limit);

    Map<String, Object> selectAll();

    Map<String, Object> selectByForm(OrderDeliveryForm form, int offset, int limit);

    //------------------------------------------------------------------------------
    //添加
    boolean addOrderDelivery(OrderDeliveryForm form);
    //修改
    boolean updateOrderDelivery(OrderDeliveryForm form);
    //删除
    boolean deleteOrderDelivery(int od_id);

}

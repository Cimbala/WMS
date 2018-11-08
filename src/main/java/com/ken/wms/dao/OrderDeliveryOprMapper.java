package com.ken.wms.dao;

import com.ken.wms.domain.form.OrderDeliveryForm;
import com.ken.wms.domain.vo.OrderDeliveryVo;

import java.util.List;

/**
 * Interface: OrderInOprMapper
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
public interface OrderDeliveryOprMapper {

    List<OrderDeliveryVo> selectByAll();

    List<OrderDeliveryVo> selectByForm(OrderDeliveryForm form);

}

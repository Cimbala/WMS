package com.ken.wms.dao;

import com.ken.wms.domain.form.OrderOutForm;
import com.ken.wms.domain.vo.OrderOutVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Interface: OrderInOprMapper
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
public interface OrderOutOprMapper {

    List<OrderOutVo> selectByAll(@Param("systemFlag") Integer sysflag);

    List<OrderOutVo> selectByIdName(OrderOutForm form);

}

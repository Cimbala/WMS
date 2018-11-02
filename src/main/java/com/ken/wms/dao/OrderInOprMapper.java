package com.ken.wms.dao;

import com.ken.wms.domain.form.OrderInForm;
import com.ken.wms.domain.vo.OrderInVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Interface: OrderInOprMapper
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
public interface OrderInOprMapper {

    List<OrderInVo> selectByAll(@Param("sysflag") Integer sysflag);

    List<OrderInVo> selectByIdName(OrderInForm form);

}

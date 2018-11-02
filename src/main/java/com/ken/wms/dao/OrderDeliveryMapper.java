package com.ken.wms.dao;

import com.ken.wms.domain.OrderDelivery;
import com.ken.wms.domain.OrderDeliveryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDeliveryMapper {
    int countByExample(OrderDeliveryExample example);

    int deleteByExample(OrderDeliveryExample example);

    int deleteByPrimaryKey(Integer deliveryId);

    int insert(OrderDelivery record);

    int insertSelective(OrderDelivery record);

    List<OrderDelivery> selectByExample(OrderDeliveryExample example);

    OrderDelivery selectByPrimaryKey(Integer deliveryId);

    int updateByExampleSelective(@Param("record") OrderDelivery record, @Param("example") OrderDeliveryExample example);

    int updateByExample(@Param("record") OrderDelivery record, @Param("example") OrderDeliveryExample example);

    int updateByPrimaryKeySelective(OrderDelivery record);

    int updateByPrimaryKey(OrderDelivery record);
}
package com.ken.wms.dao;

import com.ken.wms.domain.OrderOut;
import com.ken.wms.domain.OrderOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderOutMapper {
    int countByExample(OrderOutExample example);

    int deleteByExample(OrderOutExample example);

    int deleteByPrimaryKey(Integer orderOutId);

    int insert(OrderOut record);

    int insertSelective(OrderOut record);

    List<OrderOut> selectByExample(OrderOutExample example);

    OrderOut selectByPrimaryKey(Integer orderOutId);

    int updateByExampleSelective(@Param("record") OrderOut record, @Param("example") OrderOutExample example);

    int updateByExample(@Param("record") OrderOut record, @Param("example") OrderOutExample example);

    int updateByPrimaryKeySelective(OrderOut record);

    int updateByPrimaryKey(OrderOut record);
}
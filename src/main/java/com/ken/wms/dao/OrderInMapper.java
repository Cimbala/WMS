package com.ken.wms.dao;

import com.ken.wms.domain.OrderIn;
import com.ken.wms.domain.OrderInExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderInMapper {
    int countByExample(OrderInExample example);

    int deleteByExample(OrderInExample example);

    int deleteByPrimaryKey(Integer orderInId);

    int insert(OrderIn record);

    int insertSelective(OrderIn record);

    List<OrderIn> selectByExample(OrderInExample example);

    OrderIn selectByPrimaryKey(Integer orderInId);

    int updateByExampleSelective(@Param("record") OrderIn record, @Param("example") OrderInExample example);

    int updateByExample(@Param("record") OrderIn record, @Param("example") OrderInExample example);

    int updateByPrimaryKeySelective(OrderIn record);

    int updateByPrimaryKey(OrderIn record);
}
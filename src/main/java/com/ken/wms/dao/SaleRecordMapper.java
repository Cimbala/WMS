package com.ken.wms.dao;

import com.ken.wms.domain.SaleRecord;
import com.ken.wms.domain.SaleRecordExample;
import com.ken.wms.domain.SaleRecordKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleRecordMapper {
    int countByExample(SaleRecordExample example);

    int deleteByExample(SaleRecordExample example);

    int deleteByPrimaryKey(SaleRecordKey key);

    int insert(SaleRecord record);

    int insertSelective(SaleRecord record);

    List<SaleRecord> selectByExample(SaleRecordExample example);

    SaleRecord selectByPrimaryKey(SaleRecordKey key);

    int updateByExampleSelective(@Param("record") SaleRecord record, @Param("example") SaleRecordExample example);

    int updateByExample(@Param("record") SaleRecord record, @Param("example") SaleRecordExample example);

    int updateByPrimaryKeySelective(SaleRecord record);

    int updateByPrimaryKey(SaleRecord record);
}
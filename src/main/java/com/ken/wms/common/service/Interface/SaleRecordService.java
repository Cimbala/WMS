package com.ken.wms.common.service.Interface;

import com.ken.wms.domain.form.SaleRecordForm;

import java.util.Map;

/**
 * Interface: OrderInService
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
public interface SaleRecordService {

    //查询
    Map<String, Object> selectAll(int offset, int limit);

    Map<String, Object> selectAll();

    Map<String, Object> selectByForm(SaleRecordForm form, int offset, int limit);

    //------------------------------------------------------------------------------
    //添加
    boolean addSaleRecord(SaleRecordForm form);
    //修改
    boolean updateSaleRecord(SaleRecordForm form);
    //删除
    boolean deleteSaleRecord(int srid,int gid);

}

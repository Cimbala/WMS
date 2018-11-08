package com.ken.wms.dao;

import com.ken.wms.domain.form.SaleRecordForm;
import com.ken.wms.domain.vo.SaleRecordVo;

import java.util.List;

/**
 * Interface: OrderInOprMapper
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
public interface SaleRecordOprMapper {

    List<SaleRecordVo> selectByAll();

    List<SaleRecordVo> selectByForm(SaleRecordForm form);

}

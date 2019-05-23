package com.ken.wms.common.service.Interface;

import com.ken.wms.domain.Shop;

import java.util.Map;

/**
 * Interface: ShopManageService
 * Description:
 * Author: Alan Min
 * Createtime: 2019/1/9
 */
public interface ShopManageService {

    //查询
    Map<String, Object> selectAll(int offset, int limit);

    Map<String, Object> selectAll();

    Map<String, Object> selectBySID(int sid);

    Map<String, Object> selectByPIC(String job, int offset, int limit);

    Map<String, Object> selectShopName(String name, int offset, int limit);

    //------------------------------------------------------------------------------
    //添加
    boolean addShop(Shop form);
    //修改
    boolean updateShop(Shop form);
    //删除
    boolean deleteShop(int sid);

}

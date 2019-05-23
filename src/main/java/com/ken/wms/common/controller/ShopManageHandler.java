package com.ken.wms.common.controller;

import com.ken.wms.common.service.Interface.ShopManageService;
import com.ken.wms.common.util.Response;
import com.ken.wms.common.util.ResponseFactory;
import com.ken.wms.domain.Shop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Class: ShopManageHandler
 * Description:
 * Author: Alan Min
 * Createtime: 2019/1/9
 */
@RequestMapping(value = "/**/shopManage")
@Controller
public class ShopManageHandler {

    private Logger logger= LoggerFactory.getLogger(ShopManageHandler.class);
    @Autowired
    ShopManageService shopManageService;

    private static final String SEARCH_BY_SID = "searchBySID";//通过门店编号查询
    private static final String SEARCH_BY_NAME = "searchByNAME";//通过门店名称查询
    private static final String SEARCH_BY_PIC = "searchByPIC";//通过负责人姓名查询
    private static final String SEARCH_ALL = "searchAll";

    /**
     * 通用的记录查询
     *
     * @param searchType 查询类型
     * @param keyWord    查询关键字
     * @param offset     分页偏移值
     * @param limit      分页大小
     * @return 返回所有符合条件的记录
     */
    private Map<String, Object> query(String searchType, String keyWord, int offset, int limit)
    {
        Map<String, Object> queryResult = null;
        switch (searchType) {
            case SEARCH_BY_SID://通过门店编号查询
                queryResult=shopManageService.selectBySID(Integer.valueOf(keyWord));
                break;
            case SEARCH_BY_NAME://通过门店名称查询
                queryResult=shopManageService.selectShopName(keyWord,offset,limit);
                break;
            case SEARCH_BY_PIC://通过负责人姓名查询
                queryResult=shopManageService.selectByPIC(keyWord,offset,limit);
                break;
            case SEARCH_ALL:
                queryResult = shopManageService.selectAll(offset, limit);
                break;
            default:
        }
        return queryResult;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "getShopList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPersonList(@RequestParam("searchType") String searchType,
                                               @RequestParam("offset") int offset, @RequestParam("limit") int limit,
                                               @RequestParam("keyWord") String keyWord)
    {
        Response responseContent = ResponseFactory.newInstance();
        try {
            List<Shop> rows=null;
            long total=0;

            Map<String, Object> queryResult = query(searchType, keyWord, offset, limit);
            if (queryResult != null)
            {
                rows = (List<Shop>) queryResult.get("data");
                total = (long) queryResult.get("total");
            }
            responseContent.setCustomerInfo("rows", rows);
            responseContent.setResponseTotal(total);

        }catch (Exception e){
            e.printStackTrace();
            logger.error("["+e.getClass()+"]:"+e.getMessage());
            return null;
        }
        return responseContent.generateResponse();
    }

    /**
     * 添加
     */
    @RequestMapping(value = "addShop", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> addShop(@RequestBody Shop form) {
        Response responseContent = ResponseFactory.newInstance();
        String result = shopManageService.addShop(form) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "updateShop", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> updateShop(@RequestBody Shop form) {
        Response responseContent = ResponseFactory.newInstance();
        String result = shopManageService.updateShop(form) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "deleteShop", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> deleteShop(@RequestParam("shopId") String sid) {
        Response responseContent = ResponseFactory.newInstance();
        String result = shopManageService.deleteShop(Integer.valueOf(sid)) ?
                Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

}

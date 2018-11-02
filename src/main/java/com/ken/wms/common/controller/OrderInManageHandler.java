package com.ken.wms.common.controller;

import com.ken.wms.common.service.Interface.OrderInService;
import com.ken.wms.common.util.Response;
import com.ken.wms.common.util.ResponseFactory;
import com.ken.wms.domain.form.OrderInForm;
import com.ken.wms.domain.vo.OrderInVo;
import com.ken.wms.util.GlobalConst;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Class: OrderInManageHandler
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
@RequestMapping(value = "/**/orderInManage")
@Controller
public class OrderInManageHandler {

    private Logger logger= LoggerFactory.getLogger(OrderInManageHandler.class);
    @Autowired
    private OrderInService orderInService;

    private static final String SEARCH_BY_OID = "searchByOID";//通过进货单号查询
    private static final String SEARCH_BY_SID = "searchBySID";//通过供应商ID查询
    private static final String SEARCH_BY_GID = "searchByGID";//通过货物ID查询
    private static final String SEARCH_BY_NAME = "searchByName";//通过负责人名称
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
            case SEARCH_BY_OID://通过进货单号查询
                if (StringUtils.isNumeric(keyWord))
                    queryResult = orderInService.selectByOID(Integer.valueOf(keyWord), GlobalConst.SYSFLAG_ALL);
                else
                    logger.error("Param type is not numeric");
                break;
            case SEARCH_BY_GID://通过货物ID查询
                if (StringUtils.isNumeric(keyWord))
                    queryResult = orderInService.selectByGID(Integer.valueOf(keyWord),offset,limit, GlobalConst.SYSFLAG_ALL);
                else
                    logger.error("Param type is not numeric");
                break;
            case SEARCH_BY_SID://通过供应商ID查询
                if (StringUtils.isNumeric(keyWord))
                    queryResult = orderInService.selectBySID(Integer.valueOf(keyWord),offset,limit, GlobalConst.SYSFLAG_ALL);
                else
                    logger.error("Param type is not numeric");
                break;
            case SEARCH_BY_NAME://通过负责人名称查询
                queryResult = orderInService.selectName(keyWord,offset, limit, GlobalConst.SYSFLAG_ALL);
                break;
            case SEARCH_ALL:
                queryResult = orderInService.selectAll(offset, limit, GlobalConst.SYSFLAG_ALL);
                break;
            default:
        }
        return queryResult;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "getOrderInList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getOrderInList(@RequestParam("searchType") String searchType,
                                               @RequestParam("offset") int offset, @RequestParam("limit") int limit,
                                               @RequestParam("keyWord") String keyWord)
    {
        Response responseContent = ResponseFactory.newInstance();
        try {
            List<OrderInVo> rows=null;
            long total=0;

            Map<String, Object> queryResult = query(searchType, keyWord, offset, limit);
            if (queryResult != null)
            {
                rows = (List<OrderInVo>) queryResult.get("data");
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
     * 添加一条进货单信息
     * @return 返回一个map，其中：key 为 result表示操作的结果，包括：success 与 error
     */
    @RequestMapping(value = "addOrderIn", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> addOrderIn(@RequestBody OrderInForm form) {
        Response responseContent = ResponseFactory.newInstance();
        String result = orderInService.addOrderIn(form) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 修改一条进货单信息
     */
    @RequestMapping(value = "updateOrderIn", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> updateOrderIn(@RequestBody OrderInForm form) {
        Response responseContent = ResponseFactory.newInstance();
        String result = orderInService.updateOrderIn(form) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 删除供应商记录
     */
    @RequestMapping(value = "deleteOrderIn", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> deleteOrderIn(@RequestParam("orderin_Id") String orderin_Id) {
        Response responseContent = ResponseFactory.newInstance();
        String result = orderInService.deleteOrderIn(Integer.valueOf(orderin_Id)) ?
                Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

}

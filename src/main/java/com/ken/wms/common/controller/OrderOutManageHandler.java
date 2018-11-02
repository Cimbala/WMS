package com.ken.wms.common.controller;

import com.ken.wms.common.service.Interface.OrderOutService;
import com.ken.wms.common.util.Response;
import com.ken.wms.common.util.ResponseFactory;
import com.ken.wms.domain.form.OrderOutForm;
import com.ken.wms.domain.vo.OrderOutVo;
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
@RequestMapping(value = "/**/orderOutManage")
@Controller
public class OrderOutManageHandler {

    private Logger logger= LoggerFactory.getLogger(OrderOutManageHandler.class);
    @Autowired
    private OrderOutService orderOutService;

    private static final String SEARCH_BY_OID = "searchByOID";//通过客户订单号查询
    private static final String SEARCH_BY_CID = "searchByCID";//通过客户ID查询
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
            case SEARCH_BY_OID://通过客户订单号查询
                if (StringUtils.isNumeric(keyWord))
                    queryResult = orderOutService.selectByOID(Integer.valueOf(keyWord), GlobalConst.SYSFLAG_ALL);
                else
                    logger.error("Param type is not numeric");
                break;
            case SEARCH_BY_GID://通过货物ID查询
                if (StringUtils.isNumeric(keyWord))
                    queryResult = orderOutService.selectByGID(Integer.valueOf(keyWord),offset,limit, GlobalConst.SYSFLAG_ALL);
                else
                    logger.error("Param type is not numeric");
                break;
            case SEARCH_BY_CID://通过客户ID查询
                if (StringUtils.isNumeric(keyWord))
                    queryResult = orderOutService.selectByCID(Integer.valueOf(keyWord),offset,limit, GlobalConst.SYSFLAG_ALL);
                else
                    logger.error("Param type is not numeric");
                break;
            case SEARCH_BY_NAME://通过负责人名称查询
                queryResult = orderOutService.selectName(keyWord,offset, limit, GlobalConst.SYSFLAG_ALL);
                break;
            case SEARCH_ALL:
                queryResult = orderOutService.selectAll(offset, limit, GlobalConst.SYSFLAG_ALL);
                break;
            default:
        }
        return queryResult;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "getOrderOutList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getOrderOutList(@RequestParam("searchType") String searchType,
                                               @RequestParam("offset") int offset, @RequestParam("limit") int limit,
                                               @RequestParam("keyWord") String keyWord)
    {
        Response responseContent = ResponseFactory.newInstance();
        try {
            List<OrderOutVo> rows=null;
            long total=0;

            Map<String, Object> queryResult = query(searchType, keyWord, offset, limit);
            if (queryResult != null)
            {
                rows = (List<OrderOutVo>) queryResult.get("data");
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
    @RequestMapping(value = "addOrderOut", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> addOrderOut(@RequestBody OrderOutForm form) {
        Response responseContent = ResponseFactory.newInstance();
        String result = orderOutService.addOrderOut(form) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 修改一条进货单信息
     */
    @RequestMapping(value = "updateOrderOut", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> updateOrderOut(@RequestBody OrderOutForm form) {
        Response responseContent = ResponseFactory.newInstance();
        String result = orderOutService.updateOrderOut(form) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 删除供应商记录
     */
    @RequestMapping(value = "deleteOrderOut", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> deleteOrderOut(@RequestParam("orderout_Id") String orderout_Id) {
        Response responseContent = ResponseFactory.newInstance();
        String result = orderOutService.deleteOrderOut(Integer.valueOf(orderout_Id)) ?
                Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

}

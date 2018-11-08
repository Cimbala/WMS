package com.ken.wms.common.controller;

import com.ken.wms.common.service.Interface.OrderDeliveryService;
import com.ken.wms.common.util.AppUtil;
import com.ken.wms.common.util.Response;
import com.ken.wms.common.util.ResponseFactory;
import com.ken.wms.domain.form.OrderDeliveryForm;
import com.ken.wms.domain.vo.OrderDeliveryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Class: OrderDeliveryManageHandler
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
@RequestMapping(value = "/**/orderDeliveryManage")
@Controller
public class OrderDeliveryManageHandler {

    private Logger logger= LoggerFactory.getLogger(OrderDeliveryManageHandler.class);
    @Autowired
    OrderDeliveryService orderDeliveryService;

    private static final String SEARCH_BY_ODID = "searchByODID";//通过配送订单号查询
    private static final String SEARCH_BY_CID = "searchByCID";//通过客户ID查询
    private static final String SEARCH_BY_GID = "searchByGID";//通过货物ID查询
    private static final String SEARCH_ALL = "searchAll";

    /**
     * 通用的记录查询
     *
     * @param searchType 查询类型
     * @param offset     分页偏移值
     * @param limit      分页大小
     * @return 返回所有符合条件的记录
     */
    private Map<String, Object> query(String searchType, int offset, int limit,
                                      String keyWord,String startDate,String endDate)
    {
        Map<String, Object> queryResult = null;
        OrderDeliveryForm form;
        switch (searchType) {
            case SEARCH_BY_ODID:
                if(AppUtil.isNumeric(keyWord))
                {
                    form=setSearchTimeForm(startDate,endDate);
                    form.setDeliveryId(Integer.valueOf(keyWord));
                    queryResult = orderDeliveryService.selectByForm(form,offset,limit);
                }
                else
                    logger.error("The query param:deliveryId is not a numeric");
                break;
            case SEARCH_BY_CID:
                if(AppUtil.isNumeric(keyWord))
                {
                    form=setSearchTimeForm(startDate,endDate);
                    form.setCustomerId(Integer.valueOf(keyWord));
                    queryResult = orderDeliveryService.selectByForm(form,offset,limit);
                }
                else
                    logger.error("The query param:customerId is not a numeric");
                break;
            case SEARCH_BY_GID:
                if(AppUtil.isNumeric(keyWord))
                {
                    form=setSearchTimeForm(startDate,endDate);
                    form.setGoodId(Integer.valueOf(keyWord));
                    queryResult = orderDeliveryService.selectByForm(form,offset,limit);
                }
                else
                    logger.error("The query param:goodId is not a numeric");
                break;
            case SEARCH_ALL:
                queryResult = orderDeliveryService.selectAll(offset,limit);
                break;
            default:
        }
        return queryResult;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "getODList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getODList(@RequestParam("searchType") String searchType,
                                               @RequestParam("offset") int offset, @RequestParam("limit") int limit,
                                               @RequestParam("keyWord") String keyWord,
                                               @RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate)
    {
        Response responseContent = ResponseFactory.newInstance();
        try {
            List<OrderDeliveryVo> rows=null;
            long total=0;

            Map<String, Object> queryResult = query(searchType, offset, limit,keyWord,startDate,endDate);
            if (queryResult != null)
            {
                rows = (List<OrderDeliveryVo>) queryResult.get("data");
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
     * @return 返回一个map，其中：key 为 result表示操作的结果，包括：success 与 error
     */
    @RequestMapping(value = "addOrderDelivery", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> addOrderDelivery(@RequestBody OrderDeliveryForm form) {
        Response responseContent = ResponseFactory.newInstance();
        String result = orderDeliveryService.addOrderDelivery(form)
                ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "updateOrderDelivery", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> updateOrderDelivery(@RequestBody OrderDeliveryForm form) {
        Response responseContent = ResponseFactory.newInstance();
        String result = orderDeliveryService.updateOrderDelivery(form)
                ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "deleteOrderDelivery", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> deleteOrderDelivery(@RequestParam("od_id") String od_id) {
        Response responseContent = ResponseFactory.newInstance();
        String result = orderDeliveryService.deleteOrderDelivery(Integer.valueOf(od_id)) ?
                Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    //=================================================================================
    //设置查询参数
    private OrderDeliveryForm setSearchTimeForm(String startDateStr, String endDateStr)
    {
        OrderDeliveryForm form=new OrderDeliveryForm();
        String regex = "([0-9]{4})-([0-9]{2})-([0-9]{2})";

        if(AppUtil.isNotNull(startDateStr))
        {
            if(startDateStr.matches(regex))
            {
                form.setdTimeStr_start(startDateStr+" 00:00:00");
            }
            else
                logger.error("OrderDelivery query param:[startDate] is illegal");
        }
        if(AppUtil.isNotNull(endDateStr))
        {
            if(endDateStr.matches(regex))
            {
                form.setdTimeStr_end(endDateStr+" 23:59:59");
            }
            else
                logger.error("OrderDelivery query param:[endDate] is illegal");
        }
        return form;
    }

}

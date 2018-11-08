package com.ken.wms.common.controller;

import com.ken.wms.common.service.Interface.SaleRecordService;
import com.ken.wms.common.util.AppUtil;
import com.ken.wms.common.util.Response;
import com.ken.wms.common.util.ResponseFactory;
import com.ken.wms.domain.form.SaleRecordForm;
import com.ken.wms.domain.vo.SaleRecordVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Class: SaleRecordManageHandler
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
@RequestMapping(value = "/**/saleRecordManage")
@Controller
public class SaleRecordManageHandler {

    private Logger logger= LoggerFactory.getLogger(SaleRecordManageHandler.class);
    @Autowired
    private SaleRecordService saleRecordService;

    private static final String SEARCH_BY_PARMAS = "searchByParams";//手动输入参数
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
                                      String keyWord,String keyWord2,String startDate,String endDate)
    {
        Map<String, Object> queryResult = null;
        switch (searchType) {
            case SEARCH_BY_PARMAS:
                SaleRecordForm form=setSearchForm(keyWord,keyWord2,startDate,endDate);
                queryResult = saleRecordService.selectByForm(form,offset,limit);
                break;
            case SEARCH_ALL:
                queryResult = saleRecordService.selectAll(offset,limit);
                break;
            default:
        }
        return queryResult;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "getSaleRecordList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getOrderOutList(@RequestParam("searchType") String searchType,
                                               @RequestParam("offset") int offset, @RequestParam("limit") int limit,
                                               @RequestParam("keyWord") String keyWord,@RequestParam("keyWord2") String keyWord2,
                                               @RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate)
    {
        Response responseContent = ResponseFactory.newInstance();
        try {
            List<SaleRecordVo> rows=null;
            long total=0;

            Map<String, Object> queryResult = query(searchType, offset, limit,keyWord,keyWord2,startDate,endDate);
            if (queryResult != null)
            {
                rows = (List<SaleRecordVo>) queryResult.get("data");
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
    @RequestMapping(value = "addSaleRecord", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> addSaleRecord(@RequestBody SaleRecordForm form) {
        Response responseContent = ResponseFactory.newInstance();
        String result = saleRecordService.addSaleRecord(form) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "updateSaleRecord", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> updateSaleRecord(@RequestBody SaleRecordForm form) {
        Response responseContent = ResponseFactory.newInstance();
        String result = saleRecordService.updateSaleRecord(form) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "deleteSaleRecord", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> deleteSaleRecord(@RequestParam("sale_id") String srid,@RequestParam("good_id") String gid) {
        Response responseContent = ResponseFactory.newInstance();
        String result = saleRecordService.deleteSaleRecord(Integer.valueOf(srid),Integer.valueOf(gid)) ?
                Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    //=================================================================================
    //设置查询参数
    private SaleRecordForm setSearchForm(String keyWord, String keyWord2, String startDateStr, String endDateStr)
    {
        boolean isNotBlank=false;
        boolean startDateCheck=false;
        boolean endDateCheck=false;
        SaleRecordForm form=new SaleRecordForm();
        String regex = "([0-9]{4})-([0-9]{2})-([0-9]{2})";
        if(AppUtil.isNotNull(keyWord))
        {
            if(AppUtil.isNumeric(keyWord))
            {
                form.setSaleId(Integer.valueOf(keyWord));
                isNotBlank=true;
            }
        }
        if(AppUtil.isNotNull(keyWord2))
        {
            if(AppUtil.isNumeric(keyWord2))
            {
                form.setGoodId(Integer.valueOf(keyWord2));
                isNotBlank=true;
            }
        }

        if(AppUtil.isNotNull(startDateStr))
        {
            if(startDateStr.matches(regex))
            {
                isNotBlank=true;
                form.setSaleDateStr_start(startDateStr+" 00:00:00");
            }
            else
                logger.error("SaleRecord query param:[startDate] is illegal");
        }
        if(AppUtil.isNotNull(endDateStr))
        {
            if(endDateStr.matches(regex))
            {
                isNotBlank=true;
                form.setSaleDateStr_end(endDateStr+" 23:59:59");
            }
            else
                logger.error("SaleRecord query param:[endDate] is illegal");
        }

        if(isNotBlank)
            return form;
        else
            throw new RuntimeException("query form is null or illegal");
    }

}

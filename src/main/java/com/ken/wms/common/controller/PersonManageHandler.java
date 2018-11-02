package com.ken.wms.common.controller;

import com.ken.wms.common.service.Interface.PersonService;
import com.ken.wms.common.util.Response;
import com.ken.wms.common.util.ResponseFactory;
import com.ken.wms.domain.Person;
import com.ken.wms.util.GlobalConst;
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
@RequestMapping(value = "/**/personManage")
@Controller
public class PersonManageHandler {

    private Logger logger= LoggerFactory.getLogger(PersonManageHandler.class);
    @Autowired
    PersonService personService;

    private static final String SEARCH_BY_PID = "searchByPID";//通过员工编号查询
    private static final String SEARCH_BY_NAME = "searchByNAME";//通过员工姓名查询
    private static final String SEARCH_BY_JOB = "searchByJOB";//通过员工职务查询
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
            case SEARCH_BY_PID://通过员工编号查询
                queryResult=personService.selectByPID(Integer.valueOf(keyWord),GlobalConst.SYSFLAG_ALL);
                break;
            case SEARCH_BY_NAME://通过员工姓名查询
                queryResult=personService.selectName(keyWord,offset,limit,GlobalConst.SYSFLAG_ALL);
                break;
            case SEARCH_BY_JOB://通过职务查询
                queryResult=personService.selectByJob(keyWord,offset,limit,GlobalConst.SYSFLAG_ALL);
                break;
            case SEARCH_ALL:
                queryResult = personService.selectAll(offset, limit, GlobalConst.SYSFLAG_ALL);
                break;
            default:
        }
        return queryResult;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "getPersonList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPersonList(@RequestParam("searchType") String searchType,
                                               @RequestParam("offset") int offset, @RequestParam("limit") int limit,
                                               @RequestParam("keyWord") String keyWord)
    {
        Response responseContent = ResponseFactory.newInstance();
        try {
            List<Person> rows=null;
            long total=0;

            Map<String, Object> queryResult = query(searchType, keyWord, offset, limit);
            if (queryResult != null)
            {
                rows = (List<Person>) queryResult.get("data");
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
    @RequestMapping(value = "addPerson", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> addPerson(@RequestBody Person form) {
        Response responseContent = ResponseFactory.newInstance();
        String result = personService.addPerson(form) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "updatePerson", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> updatePerson(@RequestBody Person form) {
        Response responseContent = ResponseFactory.newInstance();
        String result = personService.updatePerson(form) ? Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "deletePerson", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> deletePerson(@RequestParam("person_id") String person_id) {
        Response responseContent = ResponseFactory.newInstance();
        String result = personService.deletePerson(Integer.valueOf(person_id)) ?
                Response.RESPONSE_RESULT_SUCCESS : Response.RESPONSE_RESULT_ERROR;
        responseContent.setResponseResult(result);
        return responseContent.generateResponse();
    }

}

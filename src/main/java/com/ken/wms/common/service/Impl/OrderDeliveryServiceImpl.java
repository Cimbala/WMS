package com.ken.wms.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ken.wms.common.service.Interface.OrderDeliveryService;
import com.ken.wms.dao.OrderDeliveryMapper;
import com.ken.wms.dao.OrderDeliveryOprMapper;
import com.ken.wms.domain.OrderDelivery;
import com.ken.wms.domain.form.OrderDeliveryForm;
import com.ken.wms.domain.vo.OrderDeliveryVo;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Class: OrderInServiceImpl
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
@Service
public class OrderDeliveryServiceImpl implements OrderDeliveryService{

    private Logger logger= LoggerFactory.getLogger(OrderDeliveryServiceImpl.class);
    @Autowired
    OrderDeliveryOprMapper orderDeliveryOprMapper;
    @Autowired
    OrderDeliveryMapper orderDeliveryMapper;

    @Override
    public Map<String, Object> selectAll(int offset, int limit) {
        Map<String, Object> resultSet = new HashMap<>();
        List<OrderDeliveryVo> list;
        long total = 0;
        boolean isPagination = true;

        // validate
        if (offset < 0 || limit < 0)
            isPagination = false;
        if(isPagination)
        {
            PageHelper.offsetPage(offset, limit);
            list=orderDeliveryOprMapper.selectByAll();
            if (list != null)
            {
                PageInfo<OrderDeliveryVo> pageInfo = new PageInfo<>(list);
                total = pageInfo.getTotal();
            }
            else
                list = new ArrayList<>();
        }
        else
        {
            list=orderDeliveryOprMapper.selectByAll();
            if (list != null)
                total=list.size();
            else
                list = new ArrayList<>();
        }
        resultSet.put("data", list);
        resultSet.put("total", total);
        return resultSet;
    }

    @Override
    public Map<String, Object> selectAll() {
        return selectAll(-1,-1);
    }


    //根据form条件查询
    @Override
    public Map<String, Object> selectByForm(OrderDeliveryForm form, int offset, int limit) {
        Map<String, Object> resultSet = new HashMap<>();
        List<OrderDeliveryVo> list;
        long total = 0;
        boolean isPagination = true;

        PageHelper.offsetPage(offset, limit);
        if (offset < 0 || limit < 0)
            isPagination = false;
        if(isPagination)
        {
            PageHelper.offsetPage(offset, limit);
            list=orderDeliveryOprMapper.selectByForm(form);
            if (list != null) {
                PageInfo<OrderDeliveryVo> pageInfo = new PageInfo<>(list);
                total = pageInfo.getTotal();
            } else
                list = new ArrayList<>();
        }
        else
        {
            list=orderDeliveryOprMapper.selectByForm(form);
            if(list!=null)
                total=list.size();
            else
                list=new ArrayList<>();
        }
        resultSet.put("data", list);
        resultSet.put("total", total);
        return resultSet;
    }

    //添加
    @Override
    public boolean addOrderDelivery(OrderDeliveryForm form) {
        boolean isSuccess=false;
        if(form==null)
            return false;
        try {
            OrderDelivery searchRecord=orderDeliveryMapper.selectByPrimaryKey(form.getDeliveryId());
            if(null == searchRecord)//没有重复记录，可放心insert
            {
                OrderDelivery newRecord=new OrderDelivery();
                BeanUtils.copyProperties(newRecord,form);
                newRecord.setDeliveryTime(new Date());
                int result=orderDeliveryMapper.insertSelective(newRecord);
                if(result>0)
                    isSuccess=true;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("["+e.getClass()+"]:"+e.getMessage());
        }
        return isSuccess;
    }

    //修改
    @Override
    public boolean updateOrderDelivery(OrderDeliveryForm form) {
        boolean isSuccess=false;
        if(form==null)
            return false;
        try {
            OrderDelivery record=orderDeliveryMapper.selectByPrimaryKey(form.getDeliveryId());
            if( record!= null )
            {
                record.setCustomerAddr(form.getCustomerAddr());
                record.setCustomerId(form.getCustomerId());
                record.setGoodId(form.getGoodId());
                record.setNum(form.getNum());
                int result=orderDeliveryMapper.updateByPrimaryKey(record);
                if(result>0)
                    isSuccess=true;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("["+e.getClass()+"]:"+e.getMessage());
        }
        return isSuccess;
    }

    //删除
    @Override
    public boolean deleteOrderDelivery(int od_id) {
        boolean isSuccess=false;
        OrderDelivery searchRecord=orderDeliveryMapper.selectByPrimaryKey(od_id);
        if( searchRecord == null )
        {
            logger.error("Cant find record by id in function deleteOrderDelivery()");
            return false;
        }
        int result=orderDeliveryMapper.deleteByPrimaryKey(od_id);
        if(result>0)
            isSuccess=true;
        return isSuccess;
    }

}

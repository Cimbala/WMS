package com.ken.wms.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ken.wms.common.service.Interface.OrderInService;
import com.ken.wms.dao.OrderInMapper;
import com.ken.wms.dao.OrderInOprMapper;
import com.ken.wms.domain.OrderIn;
import com.ken.wms.domain.form.OrderInForm;
import com.ken.wms.domain.vo.OrderInVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Class: OrderInServiceImpl
 * Description: 进货单Service
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
@Service
public class OrderInServiceImpl implements OrderInService{

    private Logger logger= LoggerFactory.getLogger(OrderInServiceImpl.class);
    @Autowired
    private OrderInMapper orderInMapper;
    @Autowired
    private OrderInOprMapper orderInOprMapper;

    @Override
    public Map<String, Object> selectAll(int offset, int limit,Integer sysflag) {
        Map<String, Object> resultSet = new HashMap<>();
        //List<OrderIn> orderIns;
        List<OrderInVo> orderInVos;
        long total = 0;
        boolean isPagination = true;

        // validate
        if (offset < 0 || limit < 0)
            isPagination = false;
        if(isPagination)
        {
            PageHelper.offsetPage(offset, limit);
            orderInVos=orderInOprMapper.selectByAll(sysflag);
            if (orderInVos != null)
            {
                PageInfo<OrderInVo> pageInfo = new PageInfo<>(orderInVos);
                total = pageInfo.getTotal();
            }
            else
                orderInVos = new ArrayList<>();
        }
        else
        {
            orderInVos=orderInOprMapper.selectByAll(sysflag);
            if (orderInVos != null)
                total=orderInVos.size();
            else
                orderInVos = new ArrayList<>();
        }
        resultSet.put("data", orderInVos);
        resultSet.put("total", total);
        return resultSet;
    }

    @Override
    public Map<String, Object> selectAll(Integer sysflag) {
        return selectAll(-1,-1,sysflag);
    }

    //根据进货单号查询（OrderId）
    @Override
    public Map<String, Object> selectByOID(int oid,Integer sysflag) {
        Map<String, Object> resultSet = new HashMap<>();
        List<OrderInVo> orderInVos;
        long total;

        OrderInForm form=new OrderInForm();
        form.setOid(oid);
        form.setSysflag(sysflag);
        orderInVos=orderInOprMapper.selectByIdName(form);
        if(orderInVos==null)
        {
            total=0;
            orderInVos=new ArrayList<>();
            logger.error("orderIn is null!");
        }
        else
            total=orderInVos.size();
        resultSet.put("data", orderInVos);
        resultSet.put("total", total);
        return resultSet;
    }

    //根据供货商ID查询（SupplierId）
    @Override
    public Map<String, Object> selectBySID(int sid,int offset,int limit,Integer sysflag) {
        OrderInForm form=new OrderInForm();
        form.setSid(sid);
        form.setSysflag(sysflag);
        return query(form,offset,limit);
    }

    //根据货物ID查询（GoodId）
    @Override
    public Map<String, Object> selectByGID(int gid,int offset,int limit,Integer sysflag) {
        OrderInForm form=new OrderInForm();
        form.setGid(gid);
        form.setSysflag(sysflag);
        return query(form,offset,limit);
    }

    //根据负责人名称查询
    @Override
    public Map<String, Object> selectName(String name, int offset, int limit,Integer sysflag) {
        OrderInForm form=new OrderInForm();
        form.setName("%"+name+"%");
        form.setSysflag(sysflag);
        return query(form,offset,limit);
    }

    //添加进货单
    @Override
    public boolean addOrderIn(OrderInForm form) {
        boolean isSuccess=false;
        if(form==null)
            return false;
        OrderIn searchRecord=orderInMapper.selectByPrimaryKey(form.getOid());
        if(null == searchRecord)//没有重复记录，可放心insert
        {
            OrderIn newRecord=new OrderIn();
            newRecord.setOrderInId(form.getOid());
            newRecord.setOrderInGoodid(form.getGid());
            newRecord.setOrderInSupplierid(form.getSid());
            newRecord.setOrderInNumber(form.getGnum());
            newRecord.setOrderInPersion(form.getName());
            newRecord.setOrderInTime(new Date());
            newRecord.setSystemFlag(form.getSysflag());
            int result=orderInMapper.insertSelective(newRecord);
            if(result>0)
                isSuccess=true;
        }
        return isSuccess;
    }

    //修改进货单
    @Override
    public boolean updateOrderIn(OrderInForm form) {
        boolean isSuccess=false;
        if(form==null)
            return false;
        OrderIn record=orderInMapper.selectByPrimaryKey(form.getOid());
        if( record!= null )
        {
            record.setOrderInGoodid(form.getGid());
            record.setOrderInSupplierid(form.getSid());
            record.setOrderInNumber(form.getGnum());
            record.setOrderInPersion(form.getName());
            int result=orderInMapper.updateByPrimaryKey(record);
            if(result>0)
                isSuccess=true;
        }
        return isSuccess;
    }

    //删除进货单
    @Override
    public boolean deleteOrderIn(int oid) {
        boolean isSuccess=false;
        OrderIn searchRecord=orderInMapper.selectByPrimaryKey(oid);
        if( searchRecord == null )
            return false;
        int result=orderInMapper.deleteByPrimaryKey(oid);
        if(result>0)
            isSuccess=true;
        return isSuccess;
    }

    //=======================================================
    //根据ID查询(带分页)
    private Map<String, Object> query(OrderInForm form, int offset,int limit)
    {
        Map<String, Object> resultSet = new HashMap<>();
        List<OrderInVo> orderInVos;
        long total = 0;
        boolean isPagination = true;

        PageHelper.offsetPage(offset, limit);
        if (offset < 0 || limit < 0)
            isPagination = false;
        if(isPagination)
        {
            PageHelper.offsetPage(offset, limit);
            orderInVos=orderInOprMapper.selectByIdName(form);
            if (orderInVos != null) {
                PageInfo<OrderInVo> pageInfo = new PageInfo<>(orderInVos);
                total = pageInfo.getTotal();
            } else
                orderInVos = new ArrayList<>();
        }
        else
        {
            orderInVos=orderInOprMapper.selectByIdName(form);
            if(orderInVos!=null)
                total=orderInVos.size();
            else
                orderInVos=new ArrayList<>();
        }
        resultSet.put("data", orderInVos);
        resultSet.put("total", total);
        return resultSet;
    }

}

package com.ken.wms.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ken.wms.common.service.Interface.OrderOutService;
import com.ken.wms.dao.OrderOutMapper;
import com.ken.wms.dao.OrderOutOprMapper;
import com.ken.wms.domain.OrderOut;
import com.ken.wms.domain.form.OrderOutForm;
import com.ken.wms.domain.vo.OrderOutVo;
import org.apache.commons.beanutils.BeanUtils;
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
public class OrderOutServiceImpl implements OrderOutService{

    private Logger logger= LoggerFactory.getLogger(OrderOutServiceImpl.class);
    @Autowired
    private OrderOutMapper orderOutMapper;
    @Autowired
    private OrderOutOprMapper orderOutOprMapper;

    @Override
    public Map<String, Object> selectAll(int offset, int limit,Integer sysflag) {
        Map<String, Object> resultSet = new HashMap<>();
        List<OrderOutVo> list;
        long total = 0;
        boolean isPagination = true;

        // validate
        if (offset < 0 || limit < 0)
            isPagination = false;
        if(isPagination)
        {
            PageHelper.offsetPage(offset, limit);
            list=orderOutOprMapper.selectByAll(sysflag);
            if (list != null)
            {
                PageInfo<OrderOutVo> pageInfo = new PageInfo<>(list);
                total = pageInfo.getTotal();
            }
            else
                list = new ArrayList<>();
        }
        else
        {
            list=orderOutOprMapper.selectByAll(sysflag);
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
    public Map<String, Object> selectAll(Integer sysflag) {
        return selectAll(-1,-1,sysflag);
    }

    //根据进货单号查询（OrderId）
    @Override
    public Map<String, Object> selectByOID(int oid,Integer sysflag) {
        Map<String, Object> resultSet = new HashMap<>();
        List<OrderOutVo> list;
        long total;

        OrderOutForm form=new OrderOutForm();
        form.setOrderOutId(oid);
        form.setSystemFlag(sysflag);
        list=orderOutOprMapper.selectByIdName(form);
        if(list==null)
        {
            total=0;
            list=new ArrayList<>();
            logger.error("orderOut is null!");
        }
        else
            total=list.size();
        resultSet.put("data", list);
        resultSet.put("total", total);
        return resultSet;
    }

    //根据供货商ID查询（SupplierId）
    @Override
    public Map<String, Object> selectByCID(int cid,int offset,int limit,Integer sysflag) {
        OrderOutForm form=new OrderOutForm();
        form.setOrderOutCustomerid(cid);
        form.setSystemFlag(sysflag);
        return query(form,offset,limit);
    }

    //根据货物ID查询（GoodId）
    @Override
    public Map<String, Object> selectByGID(int gid,int offset,int limit,Integer sysflag) {
        OrderOutForm form=new OrderOutForm();
        form.setOrderOutGoodid(gid);
        form.setSystemFlag(sysflag);
        return query(form,offset,limit);
    }

    //根据负责人名称查询
    @Override
    public Map<String, Object> selectName(String name, int offset, int limit,Integer sysflag) {
        OrderOutForm form=new OrderOutForm();
        form.setOrderOutPersion("%"+name+"%");
        form.setSystemFlag(sysflag);
        return query(form,offset,limit);
    }

    //添加进货单
    @Override
    public boolean addOrderOut(OrderOutForm form) {
        boolean isSuccess=false;
        if(form==null)
            return false;
        try {
            OrderOut searchRecord=orderOutMapper.selectByPrimaryKey(form.getOrderOutId());
            if(null == searchRecord)//没有重复记录，可放心insert
            {
                OrderOut newRecord=new OrderOut();
                BeanUtils.copyProperties(newRecord,form);
                newRecord.setOrderOutTime(new Date());
                int result=orderOutMapper.insertSelective(newRecord);
                if(result>0)
                    isSuccess=true;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("["+e.getClass()+"]:"+e.getMessage());
        }
        return isSuccess;
    }

    //修改进货单
    @Override
    public boolean updateOrderOut(OrderOutForm form) {
        boolean isSuccess=false;
        if(form==null)
            return false;
        try {
            OrderOut record=orderOutMapper.selectByPrimaryKey(form.getOrderOutId());
            if( record!= null )
            {
                record.setOrderOutGoodid(form.getOrderOutGoodid());
                record.setOrderOutCustomerid(form.getOrderOutCustomerid());
                record.setOrderOutNumber(form.getOrderOutNumber());
                record.setOrderOutPersion(form.getOrderOutPersion());
                int result=orderOutMapper.updateByPrimaryKey(record);
                if(result>0)
                    isSuccess=true;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("["+e.getClass()+"]:"+e.getMessage());
        }
        return isSuccess;
    }

    //删除进货单
    @Override
    public boolean deleteOrderOut(int oid) {
        boolean isSuccess=false;
        OrderOut searchRecord=orderOutMapper.selectByPrimaryKey(oid);
        if( searchRecord == null )
            return false;
        int result=orderOutMapper.deleteByPrimaryKey(oid);
        if(result>0)
            isSuccess=true;
        return isSuccess;
    }

    //=======================================================
    //根据ID查询(带分页)
    private Map<String, Object> query(OrderOutForm form, int offset,int limit)
    {
        Map<String, Object> resultSet = new HashMap<>();
        List<OrderOutVo> list;
        long total = 0;
        boolean isPagination = true;

        PageHelper.offsetPage(offset, limit);
        if (offset < 0 || limit < 0)
            isPagination = false;
        if(isPagination)
        {
            PageHelper.offsetPage(offset, limit);
            list=orderOutOprMapper.selectByIdName(form);
            if (list != null) {
                PageInfo<OrderOutVo> pageInfo = new PageInfo<>(list);
                total = pageInfo.getTotal();
            } else
                list = new ArrayList<>();
        }
        else
        {
            list=orderOutOprMapper.selectByIdName(form);
            if(list!=null)
                total=list.size();
            else
                list=new ArrayList<>();
        }
        resultSet.put("data", list);
        resultSet.put("total", total);
        return resultSet;
    }

}

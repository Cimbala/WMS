package com.ken.wms.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ken.wms.common.service.Interface.ShopManageService;
import com.ken.wms.dao.ShopMapper;
import com.ken.wms.domain.Shop;
import com.ken.wms.domain.ShopExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class: OrderInServiceImpl
 * Description: 门店管理Service
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
@Service
public class ShopServiceImpl implements ShopManageService{

    private Logger logger= LoggerFactory.getLogger(ShopServiceImpl.class);
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Map<String, Object> selectAll(int offset, int limit) {
        Map<String, Object> resultSet = new HashMap<>();
        List<Shop> list;
        long total = 0;
        boolean isPagination = true;

        // validate
        if (offset < 0 || limit < 0)
            isPagination = false;
        if(isPagination)
        {
            PageHelper.offsetPage(offset, limit);
            list=shopMapper.selectByExample(null);
            if (list != null)
            {
                PageInfo<Shop> pageInfo = new PageInfo<>(list);
                total = pageInfo.getTotal();
            }
            else
                list = new ArrayList<>();
        }
        else
        {
            list=shopMapper.selectByExample(null);
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

    //根据门店ID查询
    @Override
    public Map<String, Object> selectBySID(int sid) {
        Map<String, Object> resultSet = new HashMap<>();
        List<Shop> list;
        long total;

        ShopExample ex=new ShopExample();
        ShopExample.Criteria cr=ex.createCriteria();
        cr.andShopIdEqualTo(sid);
        list=shopMapper.selectByExample(ex);
        if(list==null)
        {
            total=0;
            list=new ArrayList<>();
            logger.error("list is null!");
        }
        else
            total=list.size();
        resultSet.put("data", list);
        resultSet.put("total", total);
        return resultSet;
    }

    //根据负责人姓名查询（
    @Override
    public Map<String, Object> selectByPIC(String job,int offset,int limit) {
        ShopExample ex=new ShopExample();
        ShopExample.Criteria cr=ex.createCriteria();
        cr.andPicNameLike("%"+job+"%");
        return query(ex,offset,limit);
    }

    //根据门店名称查询
    @Override
    public Map<String, Object> selectShopName(String name, int offset, int limit) {
        ShopExample ex=new ShopExample();
        ShopExample.Criteria cr=ex.createCriteria();
        cr.andShopNameLike("%"+name+"%");
        return query(ex,offset,limit);
    }

    //添加
    @Override
    public boolean addShop(Shop form) {
        boolean isSuccess=false;
        if(form==null)
            return false;
        try {
            Shop searchRecord=shopMapper.selectByPrimaryKey(form.getShopId());
            if(null == searchRecord)//没有重复记录，可放心insert
            {
                int result=shopMapper.insertSelective(form);
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
    public boolean updateShop(Shop form) {
        boolean isSuccess=false;
        if(form==null)
            return false;
        try {
            Shop record=shopMapper.selectByPrimaryKey(form.getShopId());
            if( record!= null )
            {
                record.setShopName(form.getShopName());
                record.setShopAddress(form.getShopAddress());
                record.setPicName(form.getPicName());
                record.setPicTel(form.getPicTel());
                record.setShopTel(form.getShopTel());
                int result=shopMapper.updateByPrimaryKey(record);
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
    public boolean deleteShop(int sid) {
        boolean isSuccess=false;
        Shop searchRecord=shopMapper.selectByPrimaryKey(sid);
        if( searchRecord == null )
            return false;
        int result=shopMapper.deleteByPrimaryKey(sid);
        if(result>0)
            isSuccess=true;
        return isSuccess;
    }

    //=======================================================
    //根据ID查询(带分页)
    private Map<String, Object> query(ShopExample ex, int offset,int limit)
    {
        Map<String, Object> resultSet = new HashMap<>();
        List<Shop> list;
        long total = 0;
        boolean isPagination = true;

        list=shopMapper.selectByExample(ex);
        PageHelper.offsetPage(offset, limit);
        if (offset < 0 || limit < 0)
            isPagination = false;
        if(isPagination)
        {
            PageHelper.offsetPage(offset, limit);
            if (list != null) {
                PageInfo<Shop> pageInfo = new PageInfo<>(list);
                total = pageInfo.getTotal();
            } else
                list = new ArrayList<>();
        }
        else
        {
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

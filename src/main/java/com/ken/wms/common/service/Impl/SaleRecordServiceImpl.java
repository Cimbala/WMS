package com.ken.wms.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ken.wms.common.service.Interface.SaleRecordService;
import com.ken.wms.dao.SaleRecordMapper;
import com.ken.wms.dao.SaleRecordOprMapper;
import com.ken.wms.domain.SaleRecord;
import com.ken.wms.domain.SaleRecordKey;
import com.ken.wms.domain.form.SaleRecordForm;
import com.ken.wms.domain.vo.SaleRecordVo;
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
public class SaleRecordServiceImpl implements SaleRecordService{

    private Logger logger= LoggerFactory.getLogger(SaleRecordServiceImpl.class);
    @Autowired
    SaleRecordOprMapper saleRecordOprMapper;
    @Autowired
    SaleRecordMapper saleRecordMapper;

    @Override
    public Map<String, Object> selectAll(int offset, int limit) {
        Map<String, Object> resultSet = new HashMap<>();
        List<SaleRecordVo> list;
        long total = 0;
        boolean isPagination = true;

        // validate
        if (offset < 0 || limit < 0)
            isPagination = false;
        if(isPagination)
        {
            PageHelper.offsetPage(offset, limit);
            list=saleRecordOprMapper.selectByAll();
            if (list != null)
            {
                PageInfo<SaleRecordVo> pageInfo = new PageInfo<>(list);
                total = pageInfo.getTotal();
            }
            else
                list = new ArrayList<>();
        }
        else
        {
            list=saleRecordOprMapper.selectByAll();
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
    public Map<String, Object> selectByForm(SaleRecordForm form,int offset,int limit) {
        Map<String, Object> resultSet = new HashMap<>();
        List<SaleRecordVo> list;
        long total = 0;
        boolean isPagination = true;

        PageHelper.offsetPage(offset, limit);
        if (offset < 0 || limit < 0)
            isPagination = false;
        if(isPagination)
        {
            PageHelper.offsetPage(offset, limit);
            list=saleRecordOprMapper.selectByForm(form);
            if (list != null) {
                PageInfo<SaleRecordVo> pageInfo = new PageInfo<>(list);
                total = pageInfo.getTotal();
            } else
                list = new ArrayList<>();
        }
        else
        {
            list=saleRecordOprMapper.selectByForm(form);
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
    public boolean addSaleRecord(SaleRecordForm form) {
        boolean isSuccess=false;
        if(form==null)
            return false;
        try {
            SaleRecordKey key=new SaleRecordKey();
            key.setGoodId(form.getGoodId());
            key.setSaleId(form.getSaleId());
            SaleRecord searchRecord=saleRecordMapper.selectByPrimaryKey(key);
            if(null == searchRecord)//没有重复记录，可放心insert
            {
                SaleRecord newRecord=new SaleRecord();
                BeanUtils.copyProperties(newRecord,form);
                newRecord.setSaleDate(new Date());
                newRecord.setSaleAmount(calcSaleAmount(form));
                int result=saleRecordMapper.insertSelective(newRecord);
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
    public boolean updateSaleRecord(SaleRecordForm form) {
        boolean isSuccess=false;
        if(form==null)
            return false;
        try {
            SaleRecordKey key=new SaleRecordKey();
            key.setGoodId(form.getGoodId());
            key.setSaleId(form.getSaleId());
            SaleRecord record=saleRecordMapper.selectByPrimaryKey(key);
            if( record!= null )
            {
                record.setPrice(form.getPrice());
                record.setUnit(form.getUnit());
                record.setSaleNum(form.getSaleNum());
                record.setSaleAmount(calcSaleAmount(form));
                int result=saleRecordMapper.updateByPrimaryKey(record);
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
    public boolean deleteSaleRecord(int srid,int gid) {
        boolean isSuccess=false;
        SaleRecordKey key=new SaleRecordKey();
        key.setGoodId(gid);
        key.setSaleId(srid);
        SaleRecord searchRecord=saleRecordMapper.selectByPrimaryKey(key);
        if( searchRecord == null )
            return false;
        int result=saleRecordMapper.deleteByPrimaryKey(key);
        if(result>0)
            isSuccess=true;
        return isSuccess;
    }

    //=============================================================
    //计算总销售额（单价X数量）
    private int calcSaleAmount(SaleRecordForm form) {
        return (form.getPrice()*form.getSaleNum());
    }

}

package com.ken.wms.common.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ken.wms.common.service.Interface.PersonService;
import com.ken.wms.dao.PersonMapper;
import com.ken.wms.domain.Person;
import com.ken.wms.domain.PersonExample;
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
public class PersonServiceImpl implements PersonService{

    private Logger logger= LoggerFactory.getLogger(PersonServiceImpl.class);
    @Autowired
    private PersonMapper personMapper;

    @Override
    public Map<String, Object> selectAll(int offset, int limit,Integer sysflag) {
        Map<String, Object> resultSet = new HashMap<>();
        List<Person> list;
        long total = 0;
        boolean isPagination = true;

        PersonExample ex=new PersonExample();
        PersonExample.Criteria cr=ex.createCriteria();
        if(sysflag!=null)
            cr.andSystemFlagEqualTo(sysflag);
        // validate
        if (offset < 0 || limit < 0)
            isPagination = false;
        if(isPagination)
        {
            PageHelper.offsetPage(offset, limit);
            list=personMapper.selectByExample(ex);
            if (list != null)
            {
                PageInfo<Person> pageInfo = new PageInfo<>(list);
                total = pageInfo.getTotal();
            }
            else
                list = new ArrayList<>();
        }
        else
        {
            list=personMapper.selectByExample(ex);
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

    //根据员工ID查询
    @Override
    public Map<String, Object> selectByPID(int pid,Integer sysflag) {
        Map<String, Object> resultSet = new HashMap<>();
        List<Person> list;
        long total;

        PersonExample ex=new PersonExample();
        PersonExample.Criteria cr=ex.createCriteria();
        cr.andPersonIdEqualTo(pid);
        if(sysflag!=null)
            cr.andSystemFlagEqualTo(sysflag);
        list=personMapper.selectByExample(ex);
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

    //根据职务查询（
    @Override
    public Map<String, Object> selectByJob(String job,int offset,int limit,Integer sysflag) {
        PersonExample ex=new PersonExample();
        PersonExample.Criteria cr=ex.createCriteria();
        cr.andPersonJobLike("%"+job+"%");
        if(sysflag!=null)
            cr.andSystemFlagEqualTo(sysflag);
        return query(ex,offset,limit);
    }

    //根据名称查询
    @Override
    public Map<String, Object> selectName(String name, int offset, int limit,Integer sysflag) {
        PersonExample ex=new PersonExample();
        PersonExample.Criteria cr=ex.createCriteria();
        cr.andPersonNameLike("%"+name+"%");
        if(sysflag!=null)
            cr.andSystemFlagEqualTo(sysflag);
        return query(ex,offset,limit);
    }

    //添加
    @Override
    public boolean addPerson(Person form) {
        boolean isSuccess=false;
        if(form==null)
            return false;
        try {
            Person searchRecord=personMapper.selectByPrimaryKey(form.getPersonId());
            if(null == searchRecord)//没有重复记录，可放心insert
            {
                int result=personMapper.insertSelective(form);
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
    public boolean updatePerson(Person form) {
        boolean isSuccess=false;
        if(form==null)
            return false;
        try {
            Person record=personMapper.selectByPrimaryKey(form.getPersonId());
            if( record!= null )
            {
                record.setPersonAddress(form.getPersonAddress());
                record.setPersonGender(form.getPersonGender());
                record.setPersonJob(form.getPersonJob());
                record.setPersonName(form.getPersonName());
                record.setPersonTel(form.getPersonTel());
                int result=personMapper.updateByPrimaryKey(record);
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
    public boolean deletePerson(int pid) {
        boolean isSuccess=false;
        Person searchRecord=personMapper.selectByPrimaryKey(pid);
        if( searchRecord == null )
            return false;
        int result=personMapper.deleteByPrimaryKey(pid);
        if(result>0)
            isSuccess=true;
        return isSuccess;
    }

    //=======================================================
    //根据ID查询(带分页)
    private Map<String, Object> query(PersonExample ex, int offset,int limit)
    {
        Map<String, Object> resultSet = new HashMap<>();
        List<Person> list;
        long total = 0;
        boolean isPagination = true;

        list=personMapper.selectByExample(ex);
        PageHelper.offsetPage(offset, limit);
        if (offset < 0 || limit < 0)
            isPagination = false;
        if(isPagination)
        {
            PageHelper.offsetPage(offset, limit);
            if (list != null) {
                PageInfo<Person> pageInfo = new PageInfo<>(list);
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

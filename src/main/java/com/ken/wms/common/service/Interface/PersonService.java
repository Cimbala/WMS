package com.ken.wms.common.service.Interface;

import com.ken.wms.domain.Person;

import java.util.Map;

/**
 * Interface: OrderInService
 * Description:
 * Author: Alan Min
 * Createtime: 2018/10/29
 */
public interface PersonService {

    //查询
    Map<String, Object> selectAll(int offset, int limit, Integer sysflag);

    Map<String, Object> selectAll(Integer sysflag);

    Map<String, Object> selectByPID(int pid, Integer sysflag);

    Map<String, Object> selectByJob(String job, int offset, int limit, Integer sysflag);

    Map<String, Object> selectName(String name, int offset, int limit, Integer sysflag);

    //------------------------------------------------------------------------------
    //添加
    boolean addPerson(Person form);
    //修改
    boolean updatePerson(Person form);
    //删除
    boolean deletePerson(int pid);

}

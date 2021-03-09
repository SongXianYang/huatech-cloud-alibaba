package com.huatech.service;

import com.huatech.entity.Person;

import java.util.List;

/**
 * @description: 员工业务层
 * @author: SongXY
 * @create: 2021-03-08 15:40
 **/
public interface IPersonService {
    /**
    * @Description: 删除
    * @Param: [id]
    * @return: java.lang.String
    * @Author: SongXY
    * @Date: 2021/3/8
    */
    String deleteById(Long id);
    /**
    * @Description: 查询员工列表
    * @Param: []
    * @return: java.util.List<com.huatech.entity.Person>
    * @Author: SongXY
    * @Date: 2021/3/8
    */
    List<Person> finds();
    /**
    * @Description: 更新员工
    * @Param: []
    * @return: java.lang.String
    * @Author: SongXY
    * @Date: 2021/3/8
    */
    String updateById(Person person);
    /**
    * @Description: 插入员工
    * @Param: [person]
    * @return: java.lang.String
    * @Author: SongXY
    * @Date: 2021/3/8
    */
    String insertPerson(Person person);
}

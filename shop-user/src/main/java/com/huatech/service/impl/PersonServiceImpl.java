package com.huatech.service.impl;

import com.huatech.entity.Person;
import com.huatech.mapper.IPersonMapper;
import com.huatech.service.IPersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 实现类
 * @author: SongXY
 * @create: 2021-03-08 15:41
 **/
@Service
public class PersonServiceImpl implements IPersonService {
    @Resource
    private IPersonMapper personMapper;
    @Override
    public String deleteById(Long id) {
        int result = personMapper.deleteById(id);
        if (result > 0) {
            return "delete success";
        }
        return "delete fail";
    }

    @Override
    public List<Person> finds() {
        List<Person> people = personMapper.selectList(null);
        return people;
    }

    @Override
    public String updateById(Person person) {
        int result = personMapper.updateById(person);
        if (result > 0) {
            return "update success";
        }
        return "update fail";
    }

    @Override
    public String insertPerson(Person person) {
        int result = personMapper.insert(person);
        if (result > 0) {
            return "insert success";
        }
        return "insert fail";
    }
}

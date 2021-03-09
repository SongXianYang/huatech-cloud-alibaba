package com.huatech.controller;

import com.huatech.entity.Person;
import com.huatech.service.IPersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 员工控制层
 * @author: SongXY
 * @create: 2021-03-08 16:14
 **/
@RestController
@RequestMapping("person")
@Log4j2
@Api(tags = "员工控制层")
public class PersonController {
    @Resource
    private IPersonService personService;

    @DeleteMapping("deleteBy/{id}")
    @ApiOperation("删除员工")
    @ApiImplicitParam(name = "id", value = "员工id", required = true, dataType = "int")
    public String deleteById(@PathVariable("id") Long id){
        try {
            return personService.deleteById(id);
        } catch (Exception e) {
            log.info("deleteById: "+e);
            throw e;
        }
    }
    @GetMapping("find")
    @ApiOperation("查询员工列表")
    public List<Person> finds() {
        try {
            return personService.finds();
        } catch (Exception e) {
            log.info("finds: " + e);
            throw e;
        }
    }
    @PutMapping("updateById")
    @ApiOperation("更新员工")
    public String updateById(@RequestBody Person person) {
        return personService.updateById(person);
    }
    @PutMapping("insertPerson")
    @ApiOperation("插入员工")
    public String insertPerson(Person person) {
        try {
            return personService.insertPerson(person);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("insertPerson: " + e);
            throw e;
        }

    }


}

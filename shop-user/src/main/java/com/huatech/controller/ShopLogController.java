package com.huatech.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.huatech.entity.ShopLog;
import com.huatech.service.ShopLogService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("log")
@Api(tags = "日志")
public class ShopLogController {

    @Resource
    private ShopLogService shopLogService;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @GetMapping("list")
    public List<ShopLog> listAll() {
        return shopLogService.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @GetMapping("getById")
    public ShopLog getById(Integer id) {
        return shopLogService.getById(id);
    }    
     
    /**
     * 新增，忽略null字段
     *
     * @param shopLog 新增的记录
     * @return 返回影响行数
     */
    @PostMapping("insert")
    public int insert(@RequestBody ShopLog shopLog) {
        return shopLogService.insertIgnoreNull(shopLog);
    }    
      
    /**
     * 修改，忽略null字段
     *
     * @param shopLog 修改的记录
     * @return 返回影响行数
     */
    @PostMapping("update")
    public int update(@RequestBody ShopLog shopLog) {
        return shopLogService.updateIgnoreNull(shopLog);
    }
    
    /**
     * 删除记录
     *
     * @param shopLog 待删除的记录
     * @return 返回影响行数
     */
    @DeleteMapping("delete")
    public int delete(@RequestBody ShopLog shopLog) {
        return shopLogService.delete(shopLog);
    }
    
}
package com.huatech.service;

import com.huatech.entity.ShopLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.huatech.mapper.ShopLogMapper;

import java.util.List;

@Service
public class ShopLogService {

    @Resource
    private ShopLogMapper shopLogMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<ShopLog> listAll() {
        return shopLogMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public ShopLog getById(Integer id) {
        return shopLogMapper.getById(id);
    }

    /**
     * 新增，插入所有字段
     *
     * @param shopLog 新增的记录
     * @return 返回影响行数
     */
    public int insert(ShopLog shopLog) {
        return shopLogMapper.insert(shopLog);
    }

    /**
     * 新增，忽略null字段
     *
     * @param shopLog 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(ShopLog shopLog) {
        return shopLogMapper.insertIgnoreNull(shopLog);
    }

    /**
     * 修改，修改所有字段
     *
     * @param shopLog 修改的记录
     * @return 返回影响行数
     */
    public int update(ShopLog shopLog) {
        return shopLogMapper.update(shopLog);
    }

    /**
     * 修改，忽略null字段
     *
     * @param shopLog 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(ShopLog shopLog) {
        return shopLogMapper.updateIgnoreNull(shopLog);
    }

    /**
     * 删除记录
     *
     * @param shopLog 待删除的记录
     * @return 返回影响行数
     */
    public int delete(ShopLog shopLog) {
        return shopLogMapper.delete(shopLog);
    }

}
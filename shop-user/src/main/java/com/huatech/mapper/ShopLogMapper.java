package com.huatech.mapper;

import java.util.List;

import com.huatech.entity.ShopLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopLogMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<ShopLog> listAll();


	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	ShopLog getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param shopLog 新增的记录
     * @return 返回影响行数
     */
	int insert(ShopLog shopLog);
	
	/**
     * 新增，忽略null字段
     *
     * @param shopLog 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(ShopLog shopLog);
	
	/**
     * 修改，修改所有字段
     *
     * @param shopLog 修改的记录
     * @return 返回影响行数
     */
	int update(ShopLog shopLog);
	
	/**
     * 修改，忽略null字段
     *
     * @param shopLog 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(ShopLog shopLog);
	
	/**
     * 删除记录
     *
     * @param shopLog 待删除的记录
     * @return 返回影响行数
     */
	int delete(ShopLog shopLog);
	
}
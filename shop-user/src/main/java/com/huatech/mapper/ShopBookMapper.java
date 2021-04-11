package com.huatech.mapper;


import java.util.List;

import com.huatech.entity.ShopBook;
import com.huatech.entity.ShopBookExample;
import org.apache.ibatis.annotations.Param;

public interface ShopBookMapper {
    long countByExample(ShopBookExample example);

    int deleteByExample(ShopBookExample example);

    int deleteByPrimaryKey(String id);

    int insert(ShopBook record);

    int insertSelective(ShopBook record);

    List<ShopBook> selectByExampleWithBLOBs(ShopBookExample example);

    List<ShopBook> selectByExample(ShopBookExample example);

    ShopBook selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ShopBook record, @Param("example") ShopBookExample example);

    int updateByExampleWithBLOBs(@Param("record") ShopBook record, @Param("example") ShopBookExample example);

    int updateByExample(@Param("record") ShopBook record, @Param("example") ShopBookExample example);

    int updateByPrimaryKeySelective(ShopBook record);

    int updateByPrimaryKeyWithBLOBs(ShopBook record);

    int updateByPrimaryKey(ShopBook record);
}
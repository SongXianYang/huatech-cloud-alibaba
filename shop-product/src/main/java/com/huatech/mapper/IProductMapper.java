package com.huatech.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huatech.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 商品持久层mapper
 * @author: SongXY
 * @create: 2021-02-27 16:24
 **/
@Mapper
public interface IProductMapper extends BaseMapper<Product> {
}

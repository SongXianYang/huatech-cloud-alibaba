package com.huatech.service.impl;

import com.huatech.entity.Product;
import com.huatech.mapper.IProductMapper;
import com.huatech.service.IProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 实现类
 * @author: SongXY
 * @create: 2021-02-27 16:33
 **/
@Service
@Log4j2
public class ProductServiceImpl implements IProductService {
    @Resource
    IProductMapper productMapper;

    @Override
    public Product findById(int id) {
        log.info("调用了商品的id={}",id);
        return productMapper.selectById(id);
    }
}

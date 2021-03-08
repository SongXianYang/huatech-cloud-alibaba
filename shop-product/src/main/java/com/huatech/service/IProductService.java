package com.huatech.service;

import com.huatech.entity.Product;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 服务层
 * @author: SongXY
 * @create: 2021-02-27 16:28
 **/
public interface IProductService {
    /**
     * 查询单个商品
     * @return
     * @param id
     */
    Product findById(int id);

    /**
     * 扣减库存
     * @param pId
     * @param number
     */
    @Transactional
    void insertStock(int pId, Integer number);

}

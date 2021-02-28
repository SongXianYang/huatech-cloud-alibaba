package com.huatech.feign;

import com.huatech.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 提供远程调用 商品微服务
 * @author: SongXY
 * @create: 2021-02-28 10:50
 **/
@FeignClient(value = "shop-product")
public interface ProductFeign {
    @RequestMapping(value = "/product/findById/{pId}")
    /**
     *查一个商品
     * @param pId
     */
    Product findById(@PathVariable("pId") int pId);
}

package com.huatech.feign;


import com.huatech.entity.Product;
import com.huatech.feign.fallback.ProductFeignFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: 提供远程调用 商品微服务
 * @author: SongXY
 * @create: 2021-02-28 10:50
 **/
@FeignClient(value = "shop-product",fallback = ProductFeignFallBack.class)
public interface ProductFeign {
    /**
     *查一个商品
     * @param pId
     */
    @RequestMapping(value = "/product/findById/{pId}",method = RequestMethod.GET)
    Product findById(@PathVariable("pId") int pId);
}

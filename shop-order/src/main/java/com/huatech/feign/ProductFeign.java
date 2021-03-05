package com.huatech.feign;


import com.huatech.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 提供远程调用 商品微服务
 * @author: SongXY
 * @create: 2021-02-28 10:50
 **/
@FeignClient(value = "shop-product")
public interface ProductFeign {
    /**
     *查一个商品
     * @param pId
     */
    @RequestMapping(value = "/product/findById/{pId}",method = RequestMethod.GET)
    Product findById(@PathVariable("pId") int pId);

    /**
     * 扣减库存
     * @param pId
     * @param number
     */
    @RequestMapping(value = "/product/DeductionStock")
    void DeductionStock(@RequestParam("pId") int pId, @RequestParam("number") Integer number);
}

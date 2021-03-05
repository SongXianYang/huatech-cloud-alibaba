//package com.huatech.feign.fallback;
//
//import com.huatech.entity.Product;
//import com.huatech.feign.ProductFeign;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Component;
//
///**
// * @description: feign接口的服务容错
// * @author: SongXY
// * @create: 2021-03-01 11:12
// **/
//@Component
//@Log4j2
//public class ProductFeignFallBack implements ProductFeign {
//    @Override
//    public Product findById(int pId) {
//        //容错逻辑
//        Product product = new Product();
//        product.setId(-1000);
//        product.setName("调用商品出错！！！");
//        product.setPrice(-11.0);
//        return product;
//    }
//
//    @Override
//    public void DeductionStock(int pId, Integer number) {
//
//    }
//}

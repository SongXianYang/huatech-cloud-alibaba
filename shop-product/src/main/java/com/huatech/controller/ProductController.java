package com.huatech.controller;

import com.huatech.entity.Product;
import com.huatech.service.IProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 商品控制层
 * @author: SongXY
 * @create: 2021-02-27 18:31
 **/
@RestController
@RequestMapping("product")
public class ProductController {
    @Resource
    private IProductService productService;

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable("id") int id) {
        return productService.findById(id);
    }
}

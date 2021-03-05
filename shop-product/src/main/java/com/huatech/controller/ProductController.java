package com.huatech.controller;

import com.huatech.entity.Product;
import com.huatech.service.IProductService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "DeductionStock",method = RequestMethod.GET)
    public void DeductionStock(@RequestParam("pId") int pId,@RequestParam("number") Integer number) {
        productService.insertStock(pId, number);
    }
}

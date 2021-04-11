package com.huatech.controller;

import com.huatech.entity.ShopBook;
import com.huatech.entity.ShopBookExample;
import com.huatech.response.Result;
import com.huatech.service.ShopBookService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: web
 * @author: SongXY
 * @create: 2021-04-11 11:53
 **/
@RestController
@RequestMapping("person")
@Log4j2
@Api(tags = "书")
public class ShopBookWeb {
    @Resource
    private ShopBookService bookService;

    @PostMapping("insertBook")
    public String insertBook(@RequestBody ShopBook shopBook) {
        return bookService.insertBook(shopBook);
    }

    /**
     * 通过各种外键id查询书列表
     */
    @PostMapping(value = "findList")
    public List<ShopBook> findList(@RequestBody ShopBook shopBook) {
        return bookService.findList(shopBook);
    }
    @PostMapping(value = "updateBook")
    public String updateBook (@RequestBody ShopBook shopBook) {
        return bookService.updateBook(shopBook);
    }
    @GetMapping("findById/{id}")
    public Result findById(@PathVariable String id) {
        return bookService.findById(id);
    }
}

package com.huatech.service;

import com.huatech.entity.ShopBook;
import com.huatech.entity.ShopBookExample;
import com.huatech.mapper.ShopBookMapper;
import com.huatech.response.Result;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 书  业务层
 * @author: SongXY
 * @create: 2021-04-11 11:54
 **/
@Service
public class ShopBookService {
    @Resource
    private ShopBookMapper bookMapper;
    private final String SERIAL_NUMBER = "SC_XM_";

    public String insertBook(ShopBook shopBook) {
        shopBook.setId(generaterNextNumber(UUID.randomUUID().toString().replace("-","")));
        shopBook.setCreatedTime(new Date());
        shopBook.setUpdatedTime(new Date());
        int result = bookMapper.insertSelective(shopBook);
        if (result > 0) {
            return "success";
        }
        return "error";
    }

    private String generaterNextNumber(String sno) {
        String id = null;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        id = formatter.format(date);
        int count = SERIAL_NUMBER.length();
        int snolength = sno.length();
        for (int i = 0; i < count - snolength; i++) {
            id += "0";
        }
        id += sno;
        return SERIAL_NUMBER+id;
    }

    public List<ShopBook> findList(ShopBook shopBook) {
        ShopBookExample bookExample = new ShopBookExample();
        ShopBookExample.Criteria criteria = bookExample.createCriteria();
        if (!StringUtils.isEmpty(shopBook.getId())) {
            criteria.andIdEqualTo(shopBook.getId());
        }
        Long userId = shopBook.getUserId();
        if (userId!=null) {
            criteria.andUserIdEqualTo(shopBook.getUserId());
        }
        bookExample.setOrderByClause("CREATED_TIME asc");
        bookExample.setDistinct(true);
        criteria.andIsDelEqualTo("0");
        List<ShopBook> list = bookMapper.selectByExampleWithBLOBs(bookExample);
        Map<String, String> map = list.stream().collect(Collectors.toMap(ShopBook::getId, ShopBook::getBookName));
        System.out.println("map = " + map);
        List<ShopBook> shopBooks = Optional.ofNullable(list).orElse(null);
        return shopBooks;
    }


    public String updateBook(ShopBook shopBook) {
        int result = bookMapper.updateByPrimaryKeySelective(shopBook);
        if (result > 0) {
            return "success";
        }
        return "error";
    }

    public Result findById(String id) {
        ShopBook shopBook = bookMapper.selectByPrimaryKey(id);
        Result result = new Result();
        ShopBook book = Optional.ofNullable(shopBook).orElse(null);
        return result.ok(book);
    }
}

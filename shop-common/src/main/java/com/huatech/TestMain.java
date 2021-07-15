package com.huatech;


import com.huatech.webPage.PageResponse;

import java.util.HashMap;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-04-11 20:42
 **/
public class TestMain {
    public static void main(String[] args) {
        PageResponse response = new PageResponse();
        HashMap<String, Integer> map = new HashMap<>(10);
        map.put("待整改", 10);
        map.put("已整改",100);
        map.put("已审核",99);
        response.setMaptotal(map);
        System.out.println(response);

        HashMap<String, Integer> mapT = new HashMap<>(10);
        response.setTtotal(mapT);

        try {
            Object o = response.genericMethod(TestMain.class);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

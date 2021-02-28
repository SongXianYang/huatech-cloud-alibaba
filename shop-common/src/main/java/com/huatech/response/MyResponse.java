package com.huatech.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 请求相应类
 * @author: SongXY
 * @create: 2021-02-28 20:26
 **/
@Data
@AllArgsConstructor//全参构造
@NoArgsConstructor//无参构造
public class MyResponse {
    private int code;
    private String msg;
}

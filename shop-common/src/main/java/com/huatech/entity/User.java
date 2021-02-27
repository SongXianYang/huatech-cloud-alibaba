package com.huatech.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 用户实体
 * @author: SongXY
 * @create: 2021-02-27 14:18
 **/
@TableName(value = "shop_user")
@Data
public class User implements Serializable {
    /**
    * 用户id
    */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户手机号
     */
    private String telephone;
}

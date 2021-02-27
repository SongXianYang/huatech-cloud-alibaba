package com.huatech.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * @description: 订单实体
 * @author: SongXY
 * @create: 2021-02-27 14:18
 **/
@TableName(value = "shop_order")
@Data
public class Order implements Serializable {
    /**
     * 订单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField(value = "u_id")
    private Integer uId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 商品id
     */
    @TableField(value = "p_id")
    private Integer pId;
    /**
     * 商品名称
     */
    @TableField(value = "p_name")
    private String pName;
    /**
     * 商品单价
     */
    @TableField("p_price")
    private Double pPrice;
    /**
     * 购买数量
     */
    private Integer number;

}

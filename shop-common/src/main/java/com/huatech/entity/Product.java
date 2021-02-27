package com.huatech.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 商品实体
 * @author: SongXY
 * @create: 2021-02-27 14:20
 **/

@TableName(value = "shop_product")
@Data
public class Product implements Serializable {

    /**
     * 商品id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 商品库存
     */
    private Integer stock;
}

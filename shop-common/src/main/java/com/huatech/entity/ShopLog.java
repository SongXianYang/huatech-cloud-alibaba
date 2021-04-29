package com.huatech.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author SongXianYang
 * @description: 商城日志表
 */
@ApiModel(value = "订单信息的实体属性")
@TableName(value = "shop_log")
@Data
public class ShopLog {
    /** 主键 */
    private Integer id;
    /** 业务id */
    private String businessId;
    /** 模块名称 */
    private String moduleName;
    /** 操作描述 */
    private String description;
    /** 更新时间 */
    private String createdTime;
}

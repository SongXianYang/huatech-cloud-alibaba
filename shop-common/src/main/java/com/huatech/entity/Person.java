package com.huatech.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 员工实体类
 * @author SongXianYang
 */
@ApiModel(value = "订单信息的实体属性")
@TableName(value = "person")
@Data
public class Person {
    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("邮件")
    private String email;
    @ApiModelProperty("父级id")
    private Long managerId;
    @ApiModelProperty("创建事件")
    private Date createTime;
    @ApiModelProperty("修改事件")
    private Date updateTime;
    @ApiModelProperty("版本")
    private Integer version;
    @ApiModelProperty("逻辑删除标识")
    private Integer deleted;
}
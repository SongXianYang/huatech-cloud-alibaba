package com.huatech.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 员工实体类
 * @author SongXianYang
 */
@ApiModel(value = "员工信息的实体属性")
@TableName(value = "person")
@Data
public class Person {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("邮件")
    private String email;
    @ApiModelProperty("父级id")
    private Long managerId;
    @ApiModelProperty(value = "创建时间",hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @ApiModelProperty(value = "修改时间" ,hidden = true)
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
    @ApiModelProperty(value = "版本",hidden = true)
    @Version
    private Integer version;
    @ApiModelProperty(value = "逻辑删除标识",hidden = true)
    @TableLogic
    @TableField(select = false) //查询时不展示该字段
    private Integer deleted;

}
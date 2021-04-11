package com.huatech.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @description: 书
 * @author: SongXY
 * @create: 2021-04-11 11:49
 **/
@Data
@ApiModel(value = "书")
public class ShopBook {

    /** 主键id */
    private String id ;
    /** 书本名称 */
    private String bookName ;
    /** 作者 */
    private String bookAuthor ;
    /** 金额 */
    private Double bookMoney ;
    /** 用户id */
    private Long userId ;
    /** 删除标识;1删除0未删除 */
    private String isDel ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;

}

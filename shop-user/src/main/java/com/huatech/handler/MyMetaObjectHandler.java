package com.huatech.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: 自定义自动填充
 * @author: SongXY
 * @create: 2021-03-08 22:28
 **/
@Component
@Log4j2
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //如果有createTime这个属性去就更新
        boolean hasGetter = metaObject.hasGetter("createTime");
        if (hasGetter) {
            log.info("insertFill: 插入默认时间");
            this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //是否在写update语句的时候 已经加上了 “更新时间”
        Object fieldValByName = getFieldValByName("updateTime", metaObject);
        //如果等于null我们就自动填充上更新时间
        if (fieldValByName == null) {
            log.info("updateFill: 更新默认时间");
            this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        }
    }
}

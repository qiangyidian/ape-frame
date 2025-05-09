package com.qiangi.user.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mybatis的元数据的处理
 * 这个类的使用需要注意包名,该处理器的包名应该能够被启动类进行扫描到
 * 而且实体类应该进行这样的注解进行注释@TableField(value = "update_time", fill = FieldFill.UPDATE)
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now()); // 使用Java字段名
        this.strictInsertFill(metaObject, "createBy", String.class, "qiangi");
        // 不需要填充 deletedFlag，因为 @TableLogic 会处理
        this.strictInsertFill(metaObject, "version", Integer.class, 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updateBy", String.class, "qiangi");
    }
}
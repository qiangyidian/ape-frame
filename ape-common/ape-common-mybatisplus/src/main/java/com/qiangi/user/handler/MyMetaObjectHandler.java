package com.qiangi.user.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * mybatis的元数据的处理
 *将一些数据库中的数据(例如创建时间,创建人)进行使用mybatis的元数据工具进行插入默认值
 * 这个类的使用需要注意包名,该处理器的包名应该能够被启动类进行扫描到
 * 而且实体类应该进行这样的注解进行注释@TableField(value = "update_time", fill = FieldFill.UPDATE)
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now()); // 使用Java字段名
        this.strictInsertFill(metaObject, "createBy", String.class, "qiangi");
        this.strictInsertFill(metaObject,"deleteFlag", Integer.class, 0);
        this.strictInsertFill(metaObject, "version", Integer.class, 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updateBy", String.class, "qiangi");
    }
}
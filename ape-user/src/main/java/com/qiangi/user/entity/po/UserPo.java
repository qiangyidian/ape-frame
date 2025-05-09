package com.qiangi.user.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class UserPo {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deletedFlag;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
}

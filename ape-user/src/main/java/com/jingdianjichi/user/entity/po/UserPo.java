package com.jingdianjichi.user.entity.po;

import com.baomidou.mybatisplus.annotation.*; // 必须导入
import lombok.Data;
import java.util.Date;

@Data
@TableName("user") // 记得表名问题
public class UserPo {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Integer deleteFlag;

    @TableField(fill = FieldFill.INSERT)
    private Integer version;
}
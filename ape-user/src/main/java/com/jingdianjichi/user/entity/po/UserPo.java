package com.jingdianjichi.user.entity.po;

import com.baomidou.mybatisplus.annotation.*; // 必须导入
import com.jingdianjichi.entity.BaseEntity;
import lombok.Data;
import java.util.Date;

@Data
@TableName("user") // 记得表名问题
public class UserPo extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
}
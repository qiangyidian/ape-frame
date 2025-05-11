package com.qiangi.user.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.qiangi.user.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("user")
public class UserPo extends BaseEntity implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
}

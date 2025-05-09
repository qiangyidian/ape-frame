package com.qiangi.user.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Po就是直接跟数据库进行交互
 */
@TableName("user")
@Data
public class UserPo {
    @TableId(value = "id" ,type = IdType.AUTO)
    private String id;
    private String name;
    private Integer age;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private Integer deletedFlag;
    private Integer version;
}

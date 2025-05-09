package com.qiangi.user.entity.req;


import lombok.Data;

/**
 * Dto就是只进行关注业务相关的内容,数据库的id,数据行的创建时间,创建者,这些属性都是不需要的
 */
@Data
public class UserReq {

    private String name;

    private Integer age;
}


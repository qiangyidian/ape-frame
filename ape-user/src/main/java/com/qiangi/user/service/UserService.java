package com.qiangi.user.service;


import com.qiangi.user.entity.po.UserPo;
import org.apache.catalina.User;

//controller和service进行交互之间的数据结构是dto
//service和mapper进行交互使用的是po
public interface UserService {
    int add(UserPo user);
}

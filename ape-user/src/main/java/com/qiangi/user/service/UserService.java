package com.qiangi.user.service;


import com.qiangi.user.entity.PageResult;
import com.qiangi.user.entity.dto.UserDto;
import com.qiangi.user.entity.po.UserPo;

//controller和service进行交互之间的数据结构是dto
//service和mapper进行交互使用的是po
public interface UserService {
    int add(UserDto userDto);

    Object delect(Integer id);

    PageResult<UserPo> getPage(UserDto userDto);
}

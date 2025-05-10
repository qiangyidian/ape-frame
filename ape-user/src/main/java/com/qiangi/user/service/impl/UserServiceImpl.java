package com.qiangi.user.service.impl;

import com.qiangi.user.entity.dto.UserDto;
import com.qiangi.user.entity.po.UserPo;
import com.qiangi.user.mapper.UserMapper;
import com.qiangi.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;
    @Override
    public int add(UserDto  userDto) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDto,userPo);
        return userMapper.insert(userPo);
    }

    @Override
    public Object delect(Integer id) {
        return userMapper.deleteById(id);
    }
}

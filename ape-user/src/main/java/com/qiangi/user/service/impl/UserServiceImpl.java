package com.qiangi.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiangi.bean.Result;
import com.qiangi.user.entity.PageResult;
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

    @Override
    public PageResult<UserPo> getPage(UserDto userDto) {
        IPage<UserPo> userPoPage= new Page<>(userDto.getPage(), userDto.getPageSize());
        IPage<UserPo> userPage= userMapper.getUserPage(userPoPage);
        PageResult<UserPo> pageResult = new PageResult<>();
        pageResult.loadData(userPage);
        return pageResult;
    }
}

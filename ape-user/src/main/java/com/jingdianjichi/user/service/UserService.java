package com.jingdianjichi.user.service;

import com.jingdianjichi.user.entity.dto.UserDto;
import org.springframework.stereotype.Service;

public interface UserService {

    int addUser(UserDto userDto);

    int delete(Integer id);
}

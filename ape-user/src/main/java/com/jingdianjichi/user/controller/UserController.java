package com.jingdianjichi.user.controller;


import com.jingdianjichi.bean.Result;
import com.jingdianjichi.user.entity.dto.UserDto;
import com.jingdianjichi.user.entity.req.UserReq;
import com.jingdianjichi.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Result addUser(@RequestBody UserReq userReq){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq, userDto);
        Integer i = userService.addUser(userDto);
        return Result.ok(i);
    }
}

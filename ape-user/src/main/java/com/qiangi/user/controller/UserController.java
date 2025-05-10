package com.qiangi.user.controller;


import com.qiangi.bean.Result;
import com.qiangi.user.entity.dto.UserDto;
import com.qiangi.user.entity.req.UserReq;
import com.qiangi.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Result addUser(@RequestBody UserReq userReq){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq,userDto);
        return Result.ok(userService.add(userDto));
    }


    /**
     * 此处的删除是进行的逻辑删除,并不会进行直接将数据库中的数据进行删除,而是将删除flag进行标注为已删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delect(@PathVariable Integer id){
        return Result.ok(userService.delect(id));
    }
}

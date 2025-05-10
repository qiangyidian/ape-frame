package com.qiangi.user.controller;

import com.qiangi.user.convert.UserConverter;
import com.qiangi.user.entity.po.UserPo;
import com.qiangi.user.entity.req.UserReq;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/test02")
    public String testMapStruct(UserReq userReq){
        UserPo userPo = UserConverter.INSTANCE.convertUserReqToPo(userReq);
        System.out.println(userPo);
        return "test";
    }
}

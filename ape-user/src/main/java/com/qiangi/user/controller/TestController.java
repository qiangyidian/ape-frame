package com.qiangi.user.controller;

import com.qiangi.redis.util.RedisUtil;
import com.qiangi.user.convert.UserConverter;
import com.qiangi.user.entity.po.UserPo;
import com.qiangi.user.entity.req.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    RedisUtil redisUtil;


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


    @GetMapping("/testRedis")
    public String testRedis(){
        redisUtil.set("name","qiangi");
        return "testRedis";
    }
}

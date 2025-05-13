package com.qiangi.user.controller;

import com.qiangi.bean.Result;
import com.qiangi.redis.util.RedisShareLockUtil;
import com.qiangi.redis.util.RedisUtil;
import com.qiangi.user.convert.UserConverter;
import com.qiangi.user.entity.po.UserPo;
import com.qiangi.user.entity.req.UserReq;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class TestController {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RedisShareLockUtil redisShareLockUtil;


    @GetMapping("/test")
    public String test(){
        System.out.println("当前运行目录: " + System.getProperty("user.dir"));
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
    @GetMapping("/testRedisLock")
    public Boolean testRedisLock(){
        return redisShareLockUtil.lock("001","001",10000L);
    }


    @GetMapping("/testlog")
    public Result testLog(){
        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            log.info("这是第{}次打印日志",i);
        }
        long end = System.currentTimeMillis();
        return Result.ok(end-start);
    }

    @GetMapping("/testLog1")
    public Result<Long> testLog4j2(){
        long start = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            log.info("这是第{}次打印日志",i);
        }
        long end = System.currentTimeMillis();
        return Result.ok(end-start);
    }
}

package com.qiangi.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;


//resouce中的application.yml就是对于这个启动类进行的配置
@SpringBootApplication
@MapperScan(value = "com.qiangi.*.mapper")//进行扫描mapper的xml文件
@ComponentScan(value ="com.qiangi")
@EnableCaching
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}

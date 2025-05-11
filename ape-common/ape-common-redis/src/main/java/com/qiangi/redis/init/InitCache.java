package com.qiangi.redis.init;

import com.qiangi.redis.util.SpringContextUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * public class InitCache implements CommandLineRunner 是 Spring Boot 中一种常见的写法，
 * 它的作用是：在 Spring Boot 项目启动完成后自动执行一些初始化逻辑代码。
 */
@Component
public class InitCache implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        //我要知道哪些缓存需要进行一个预热,根据继承抽象类的所有的类都需要,根据bean的类型进行获取到注入到bean中的对象
        //在user中进行定义了两个类进行对应类的初始化
        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        Map<String, AbstractCache> beanMap = applicationContext.getBeansOfType(AbstractCache.class);
        //调用init方法
        if(beanMap.isEmpty()){
            return;
        }
        for(Map.Entry<String,AbstractCache> entry : beanMap.entrySet()){
            //拿到的是子类,但是使用父类去接,实际是进行使用的子类的方法
            AbstractCache abstractCache = (AbstractCache) SpringContextUtil.getBean(entry.getValue().getClass());
            abstractCache.initCache();
        }
    }

}

package com.qiangi.redis.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfig {


    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(redisSerializer);//key的序列化都是string类型的值,直接进行使用redis的序列化即可
        redisTemplate.setHashKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer());//value可能是object的类型,需要进行自定义序列化
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer());
        return redisTemplate;
    }

    /**
     * 使得Cacheable注解进行存储到redis中的数据能够是序列化的
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer());
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(pair).entryTtl(Duration.ofSeconds(10));
        return new RedisCacheManager(redisCacheWriter,defaultCacheConfig);
    }

    private Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer(){
        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        //创建 Jackson 的核心对象 ObjectMapper，用于处理对象到 JSON 的转换逻辑。
        ObjectMapper objectMapper = new ObjectMapper();
        /**
         * 设置序列化时对象的可见性规则：
         * PropertyAccessor.ALL：表示作用于所有属性（字段、getter/setter 等）。
         * Visibility.ANY：表示无论字段是 private、protected 还是 public，都可以被序列化。
         */
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        /**
         * 配置反序列化时，如果 JSON 中存在 Java 类中不存在的属性，不要抛出异常，而是忽略这些未知字段。
         */
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);//如果有属性找不到不会进行报错
        /**
         * 因为 Redis 是以 JSON 存的，而 JSON 默认不包含类型信息，反序列化的时候
         * Jackson 无法知道你要还原成 Result，所以它就默认变成了 LinkedHashMap，造成你现在的错误：
         * 默认类型信息（Default Typing） 的方法，它的作用是：
         * 也就是在进行取出缓存中的数据时如果进行反序列化的处理,如果没有默认类型会进行报错,不知道将数据进行反序列化为什么类型的对象
         */
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        jsonRedisSerializer.setObjectMapper(objectMapper);
        return jsonRedisSerializer;
    }
}

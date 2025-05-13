package com.qiangi.redis.util;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Maps;
import com.qiangi.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Guava二级本地缓存
 * @param <K>
 * @param <V>
 */
@Component
@Slf4j
public class GuavaCacheUtil<K, V> {

    @Resource
    public RedisUtil redisUtil;

    @Value("${guava.cache.switch}")
    public Boolean switchCache;

    //初始化本地缓存
    private Cache<String, String> localCache =
            CacheBuilder.newBuilder()
                    .maximumSize(5000)
                    .expireAfterWrite(3, TimeUnit.SECONDS)
                    .build();

    public Map<K, V> getResult(List<K> idList, String cacheKeyPrefix, String cacheSuffix, Class<V> clazz,
                               Function<List<K>, Map<K, V>> function) {
        if (CollectionUtils.isEmpty(idList)) {
            return Collections.emptyMap();
        }
        Map<K, V> resultMap = new HashMap<>(16);
        //进行定义一个开关,可以进行开关本地缓存
        if (!switchCache) {
            resultMap = function.apply(idList);
            return resultMap;
        }
        //获取不到缓存的集合
        List<K> noCacheIdList = new LinkedList<>();
        for (K id : idList) {
            String cacheKey = cacheKeyPrefix + "_" + id + "_" + cacheSuffix;
            String content = localCache.getIfPresent(cacheKey);
            if (StringUtils.isNotBlank(content)) {
                V v = JSON.parseObject(content, clazz);
                resultMap.put(id, v);
            } else {
                noCacheIdList.add(id);
            }
        }
        //如果获取不到缓存的集合的大小是0,那么方法就进行结束了,因为所有的key都已经进行获取到了他的值
        if (CollectionUtils.isEmpty(noCacheIdList)) {
            return resultMap;
        }
        //如果还有key没有进行获取到对应的value的话,那么进行调用数据库方法进行获取
        Map<K, V> noCacheResultMap = function.apply(noCacheIdList);
        //如果进行调用数据库获取数据还是无法进行获取到数据的话,说明该key的数据不存在,那么只能进行返回数据了
        if (noCacheResultMap == null || noCacheResultMap.isEmpty()) {
            return resultMap;
        }
        //将数据库中获取到的缓存进行缓存到localCache
        for (Map.Entry<K, V> entry : noCacheResultMap.entrySet()) {
            K id = entry.getKey();
            V result = entry.getValue();
            resultMap.put(id, result);
            String cacheKey = cacheKeyPrefix + "_" + id + "_" + cacheSuffix;
            localCache.put(cacheKey, JSON.toJSONString(result));
        }
        return resultMap;
    }


}

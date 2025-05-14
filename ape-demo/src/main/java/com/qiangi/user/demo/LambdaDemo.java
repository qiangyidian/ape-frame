package com.qiangi.user.demo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ChickenWing
 * @Description: 提供一些常见的lambda用法demo
 * @DateTime: 2022/12/10 22:01
 */
public class LambdaDemo {

    /**
     * 将一个list实体的某些属性转换为另一个list实体
     */
    public void streamMap() {
        List<SkuInfo> skuInfoList = new LinkedList<>();
        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setSkuId(1L);
        skuInfo.setSkuName("商品1");
        skuInfo.setPrice(new BigDecimal("0.01"));
        skuInfoList.stream().map(sku -> {
            SkuVO skuVO = new SkuVO();
            skuVO.setSkuId(sku.getSkuId());
            skuVO.setSkuName(sku.getSkuName());
            return skuVO;
        });
    }

    @Data
    class SkuInfo {
        private Long skuId;
        private String skuName;
        private BigDecimal price;
    }

    @Data
    class SkuVO {
        private Long skuId;
        private String skuName;
    }

}

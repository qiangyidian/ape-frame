package com.qiangi.user.designPattern.builderPattern.demo;

public interface SkuVOExtFunction<T extends SkuVO> {

    void buildExtInfo(T skuVO,SkuDO skuDO);

}

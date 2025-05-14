package com.qiangi.user.designPattern.builderPattern.demo;

public interface SkuVOFunction<T extends SkuVO> {

    T newInstance();

}

package com.qiangi.user.designPattern.strategyPattern.demo;

public interface PayHandler {

    PayChannelEnum getChannel();

    void dealPay();

}

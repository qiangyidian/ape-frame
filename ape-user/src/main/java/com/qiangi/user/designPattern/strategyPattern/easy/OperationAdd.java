package com.qiangi.user.designPattern.strategyPattern.easy;

public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
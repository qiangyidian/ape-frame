package com.qiangi.user.designPattern.abstractFactoryPattern.easy;

public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
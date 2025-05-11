package com.qiangi.redis.exception;

/**
 * ShareLockException 继承自 RuntimeException，属于非受检异常（Unchecked Exception）。
 */
public class ShareLockException extends RuntimeException{

    public ShareLockException(String message){
        super(message);
    }

}

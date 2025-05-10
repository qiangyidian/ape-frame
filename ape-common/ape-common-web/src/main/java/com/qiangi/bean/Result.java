package com.qiangi.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class Result<T> implements Serializable {
    private Result(){}

    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public static Result ok(){
        Result  result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultMessage.SUCCESS);
        return result;
    }

    public static Result ok(Integer code,String message){
        Result  result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultMessage.SUCCESS);
        return result;
    }
    public static<T> Result ok(Integer code,String message,T data){
        Result  result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    public static<T> Result ok(T data){
        Result  result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultMessage.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result fail(){
        Result  result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCode.ERROR);
        result.setMessage(ResultMessage.ERROR);
        return result;
    }

    public static Result fail(Integer code,String message){
        Result  result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCode.ERROR);
        result.setMessage(ResultMessage.ERROR);
        return result;
    }
    public static<T> Result fail(Integer code,String message,T data){
        Result  result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    public static<T> Result fail(T data){
        Result  result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCode.ERROR);
        result.setMessage(ResultMessage.ERROR);
        result.setData(data);
        return result;
    }
}

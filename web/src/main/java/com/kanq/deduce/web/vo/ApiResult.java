package com.kanq.deduce.web.vo;

import java.io.Serializable;

import com.kanq.deduce.web.enums.CodeEnum;

import lombok.Data;

@Data
public class ApiResult<T> implements Serializable{
    private Integer code;
    private String message;
    private T data;

    public static final ApiResult SUCCESS = new ApiResult(true);

    public ApiResult(T data){
        this.code = CodeEnum.SUCCESS.getCode();
        this.message = CodeEnum.SUCCESS.getMessage();
        this.data = data;
    }

    public ApiResult(boolean success){
        this.code = success ? CodeEnum.SUCCESS.getCode() : CodeEnum.FAILED.getCode();
        this.message = success ? CodeEnum.SUCCESS.getMessage() : CodeEnum.FAILED.getMessage();
    }

    // public static ApiResult success(Object data){
    //     return new ApiResult(data);
    // }

    public ApiResult(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public ApiResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

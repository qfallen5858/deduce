package com.kanq.deduce.common.enums;

import lombok.Getter;

@Getter
public enum CodeEnum {
    
    SUCCESS(200, "操作成功"),
    FAILED(500, "系统异常"),
    NOT_FOUND(404, "找不到指定对象");

    private Integer code;

    private String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
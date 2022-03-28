package com.kanq.deduce.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;

import lombok.Getter;

// @Getter
public enum PlayStateEnum {
    NORMAL(0, "默认"),
    PLAYING(1, "进行中"),
    PAUSE(2, "暂停中"),
    END(3, "已结束");

    PlayStateEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
    @EnumValue
    private int value;
    private String name;

    // @Override
    
    public Integer getValue() {
        return value;
    }

    public String getName(){
        return name;
    }
    
}

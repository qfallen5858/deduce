package com.kanq.deduce.common.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

import lombok.Getter;

@Getter
public enum PlayStateEnum implements IEnum<Integer>{
    NORMAL(0, "默认"),
    PLAYING(1, "进行中"),
    PAUSE(2, "暂停中"),
    END(3, "已结束");

    PlayStateEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private Integer value;
    private String name;

    @Override
    public Integer getValue() {
        return value;
    }
    
}

package com.kanq.deduce.common.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kanq.deduce.common.enums.PlayStateEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@TableName("play")
public class Play {
    private Integer id;

    private String name;

    private PlayStateEnum state;
    // private Integer state;
    
    private Date createTime;

    private Date updateTime;
}

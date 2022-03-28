package com.kanq.deduce.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlayVO {
    @ApiModelProperty("推演ID")
    private Integer id;
    @ApiModelProperty("推演名称")
    private String name;
    @ApiModelProperty("推演状态")
    private Integer state;
}

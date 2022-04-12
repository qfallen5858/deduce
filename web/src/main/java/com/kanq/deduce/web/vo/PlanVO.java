package com.kanq.deduce.web.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PlanVO {
  private Integer type;
  private String name;
  private Date data;
}

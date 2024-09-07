package com.mirror.finance.biz.dto.form;


import lombok.Data;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * 删除菜单
 */
@Data
public class DelMenuForm {
  //  @ApiModelProperty(value = "菜单id")
    @NotNull
    @Min(value = 1)
    private Integer id;
}
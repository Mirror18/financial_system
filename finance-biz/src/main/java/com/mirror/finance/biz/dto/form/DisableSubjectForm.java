package com.mirror.finance.biz.dto.form;


import lombok.Data;

import jakarta.validation.constraints.NotNull;

/**
 * 禁用或启用科目科目
 *
 */
@Data
public class DisableSubjectForm {
 //   @ApiModelProperty(value = "科目id")
    @NotNull
    private Long id;

 //   @ApiModelProperty(value = "禁用或启用科目")
    @NotNull
    private Boolean disable;
}
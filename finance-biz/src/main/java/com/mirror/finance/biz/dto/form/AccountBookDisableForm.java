package com.mirror.finance.biz.dto.form;


import lombok.Data;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * 账套（表：account_book）
 * @author mirror
 */
@Data
public class AccountBookDisableForm {
    /**
     * 公司名称
     */
  //  @ApiModelProperty(value = "账套id")
    @NotNull
    @Min(value = 1)
    private Long id;

  //  @ApiModelProperty(value = "true禁用，false：启用")
    @NotNull
    private Boolean disable;
}
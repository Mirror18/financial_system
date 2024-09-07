package com.mirror.finance.biz.dto.form;


import lombok.Data;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

/**
 * 删除资源
 */
@Data
public class DelSysResourceForm {
 //   @ApiModelProperty(value = "资源id")
    @NotNull
    @Range(min = 1, max = Integer.MAX_VALUE)
    private Integer id;
}

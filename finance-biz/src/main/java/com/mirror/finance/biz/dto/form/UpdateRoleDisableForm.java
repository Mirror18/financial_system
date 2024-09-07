package com.mirror.finance.biz.dto.form;


import lombok.Data;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import java.util.Set;

@Data
public class UpdateRoleDisableForm {
 //   @ApiModelProperty(value = "角色id")
    @NotNull
    @Range(min = 1)
    private Integer id;

  //  @ApiModelProperty(value = "禁用或启用角色，true禁用，false启用")
    @NotNull
    private Boolean disable;
}

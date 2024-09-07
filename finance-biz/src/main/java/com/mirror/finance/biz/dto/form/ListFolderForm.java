package com.mirror.finance.biz.dto.form;


import lombok.Data;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
public class ListFolderForm {
 //   @ApiModelProperty(value = "上级id")
    @NotNull
    @Min(value = 0)
    private Long pid;
}

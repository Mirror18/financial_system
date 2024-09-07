package com.mirror.finance.biz.dto.form;


import lombok.Data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;

/**
 * 辅助核算类别
 *
 */
@Data
public class CreateAssistCalculateCateForm {
  //  @ApiModelProperty(value = "辅助核算类别名称")
    @NotBlank
    @Size(min = 1, max = 50)
    private String name;

    @Valid
    @NotNull
 //   @ApiModelProperty(value = "自定义列配置")
    private List<CustomerColumnConfig> customerColumnConfigList;

    @Data
    public static class CustomerColumnConfig {
        @Pattern(regexp = "^(c[1-9]|c10|code|name|notes|mnemonicCode)$")
        @NotBlank
  //      @ApiModelProperty(value = "字段名称，c1,c2,c3,c4,c5,c6,c7,c8,c9,c10")
        private String columnName;
        @NotBlank
        @Size(max = 50)
        private String columnAlias;
    }
}
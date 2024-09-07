package com.mirror.finance.biz.dto.vo;


import lombok.Data;

@Data
public class ListRoleVo {
 //   @ApiModelProperty(value = "角色id")
    private Integer id;
 //   @ApiModelProperty(value = "角色名称")
    private String roleName;

  //  @ApiModelProperty(value = "是否启用禁用，true禁用，false启用")
    private Boolean disable;
}

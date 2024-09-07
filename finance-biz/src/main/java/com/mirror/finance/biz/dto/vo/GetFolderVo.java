package com.mirror.finance.biz.dto.vo;


import lombok.Data;

@Data
public class GetFolderVo {
  //  @ApiModelProperty(value = "id")
    private Long id;

  //  @ApiModelProperty(value = "pid")
    private Long pid;

  //  @ApiModelProperty(value = "上级文件夹名称")
    private String parentName;

  //  @ApiModelProperty(value = "文件夹名称")
    private String name;

  //  @ApiModelProperty(value = "顺序")
    private Integer sort;
}

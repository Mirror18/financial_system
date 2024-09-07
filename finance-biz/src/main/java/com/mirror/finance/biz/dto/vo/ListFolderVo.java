package com.mirror.finance.biz.dto.vo;


import lombok.Data;

@Data
public class ListFolderVo {
 //   @ApiModelProperty(value = "id")
    private Long id;

 //   @ApiModelProperty(value = "pid")
    private Long pid;

  //  @ApiModelProperty(value = "文件夹名称")
    private String name;

  //  @ApiModelProperty(value = "子节点数量")
    private Long childCount;

  //  @ApiModelProperty(value = "顺序")
    private Integer sort;
}

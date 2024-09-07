package com.mirror.finance.biz.dto.form;

import com.mirror.common.dto.PageHelperRequest;

import lombok.Data;
import jakarta.validation.constraints.Min;
import java.util.Date;

@Data
public class ListFileForm extends PageHelperRequest {
 //   @ApiModelProperty(value = "文件夹id")
    @Min(value = 0)
    private Long folderId;

 //   @ApiModelProperty(value = "上传开始日期")
    private Date beginDate;

 //   @ApiModelProperty(value = "上传结束日期")
    private Date endDate;

  //  @ApiModelProperty(value = "文件名称")
    private String name;
}

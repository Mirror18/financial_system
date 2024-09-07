package com.mirror.finance.biz.dto.form;

import com.mirror.common.dto.PageHelperRequest;

import lombok.Data;

import jakarta.validation.constraints.Size;

@Data
public class ListAssistCalculateSummaryForm extends PageHelperRequest {
  //  @ApiModelProperty(value = "编码或名称")
    @Size(max = 50)
    private String codeOrName;

 //   @ApiModelProperty(value = "辅助核算类别id")
    private Long assistCalculateCateId;
}
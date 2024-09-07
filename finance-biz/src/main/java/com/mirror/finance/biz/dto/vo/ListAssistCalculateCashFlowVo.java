package com.mirror.finance.biz.dto.vo;


import lombok.Data;

/**
 * 辅助核算现金流列表
 */
@Data
public class ListAssistCalculateCashFlowVo extends BaseAssistCalculateVo{
  //  @ApiModelProperty(value = "现金流类别")
    private String cashFlowCate;
}
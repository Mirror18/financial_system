package com.mirror.finance.biz.dto.form;


import lombok.Data;

@Data
public class ListSubjectByCateAndCodeAndNameForm {
  //  @ApiModelProperty(value = "科目类别")
    private Integer subjectCate;

  //  @ApiModelProperty(value = "科目编码或科目名称")
    private String codeAndName;
}

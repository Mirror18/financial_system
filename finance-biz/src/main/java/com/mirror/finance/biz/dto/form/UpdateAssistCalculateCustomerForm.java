package com.mirror.finance.biz.dto.form;


import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 辅助核算（客户）
 *
 */
@Data
public class UpdateAssistCalculateCustomerForm extends UpdateAssistCalculateForm {
 //   @ApiModelProperty(value = "客户类别")
    private String customerCate;

 //   @ApiModelProperty(value = "统一社会信用代码")
    private String unifiedSocialCreditCode;

//    @ApiModelProperty(value = "省份编码")
    private String provinceCode;

 //   @ApiModelProperty(value = "城市编码")
    private String cityCode;

 //   @ApiModelProperty(value = "区县编码")
    private String countyCode;

 //   @ApiModelProperty(value = "详细地址")
    @Size(max = 200)
    private String address;

 //   @ApiModelProperty(value = "联系人")
    @Size(max = 50)
    private String contacts;

 //   @ApiModelProperty(value = "手机")
    @Pattern(regexp = "^(\\d{11})?$", message = "手机格式不正确")
    private String phone;
}
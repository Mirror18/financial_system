package com.mirror.controller;

import com.mirror.common.dto.ApiResponse;
import com.mirror.finance.biz.dto.form.SaveSendSmsCodeTemplateConfigForm;
import com.mirror.finance.biz.service.SysConfigService;
import com.fasterxml.jackson.core.JsonProcessingException;
  
   
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

//@Api(tags = "系统配置")
@RestController
@RequestMapping(value = "/sysConfig")
@RequiredArgsConstructor
@Slf4j
@Validated
public class SysConfigController {
    final SysConfigService sysConfigService;

  //  @ApiOperation(value = "保存短信验证码模板配置")
    @PostMapping(value = "/saveSendSmsCodeTemplateConfig")
    public ApiResponse<Boolean> saveSendSmsCodeTemplateConfig(@Valid @RequestBody SaveSendSmsCodeTemplateConfigForm form) throws JsonProcessingException {
        return ApiResponse.success(sysConfigService.saveSendSmsCodeTemplateConfig(form));
    }
}

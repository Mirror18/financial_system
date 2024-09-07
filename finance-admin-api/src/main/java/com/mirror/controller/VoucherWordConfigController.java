package com.mirror.controller;

import com.mirror.common.dto.ApiResponse;
import com.mirror.finance.biz.dto.form.CreateVoucherWordConfigForm;
import com.mirror.finance.biz.dto.form.DelVoucherWordConfigForm;
import com.mirror.finance.biz.dto.form.UpdateVoucherWordConfigDefaultFlagForm;
import com.mirror.finance.biz.dto.form.UpdateVoucherWordConfigForm;
import com.mirror.finance.biz.dto.vo.GetVoucherWordConfigVo;
import com.mirror.finance.biz.dto.vo.ListVoucherWordConfigVo;
import com.mirror.finance.biz.service.VoucherWordConfigService;
  
   
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

//@Api(tags = "凭证字设置")
@RestController
@RequestMapping(value = "/voucherWordConfig")
@RequiredArgsConstructor
@Slf4j
@Validated
public class VoucherWordConfigController {
    final VoucherWordConfigService voucherWordConfigService;

   // @ApiOperation(value = "添加凭证字")
    @PostMapping(value = "/create")
    public ApiResponse<Boolean> create(@Valid @RequestBody CreateVoucherWordConfigForm form) {
        return ApiResponse.success(voucherWordConfigService.create(form));
    }

  //  @ApiOperation(value = "删除凭证字")
    @PostMapping(value = "/del")
    public ApiResponse<Boolean> del(@Valid @RequestBody DelVoucherWordConfigForm form) {
        return ApiResponse.success(voucherWordConfigService.del(form));
    }

   // @ApiOperation(value = "修改凭证字")
    @PostMapping(value = "/update")
    public ApiResponse<Boolean> update(@Valid @RequestBody UpdateVoucherWordConfigForm form) {
        return ApiResponse.success(voucherWordConfigService.update(form));
    }

  //  @ApiOperation(value = "修改默认凭证字")
    @PostMapping(value = "/updateDefaultFlag")
    public ApiResponse<Boolean> updateDefaultFlag(@Valid @RequestBody UpdateVoucherWordConfigDefaultFlagForm form) {
        return ApiResponse.success(voucherWordConfigService.updateDefaultFlag(form));
    }

  //  @ApiOperation(value = "获取凭证字详情")
    @GetMapping(value = "/get")
    public ApiResponse<GetVoucherWordConfigVo> getCurrencyConfigByCode(@RequestParam
                                                                    @NotNull
                                                                    @Range(min = 1)
                                                                            Long id) {
        return ApiResponse.success(voucherWordConfigService.getById(id));
    }

//    @ApiOperation(value = "查询凭证字列表")
    @GetMapping(value = "/list")
    public ApiResponse<List<ListVoucherWordConfigVo>> list() {
        return ApiResponse.success(voucherWordConfigService.list());
    }
}

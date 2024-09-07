package com.mirror.controller;

import com.mirror.common.dto.ApiResponse;
import com.mirror.finance.biz.dto.form.CreateVoucherForm;
import com.mirror.finance.biz.dto.form.DelVoucherForm;
import com.mirror.finance.biz.dto.form.ListVoucherForm;
import com.mirror.finance.biz.dto.vo.GetVoucherVo;
import com.mirror.finance.biz.dto.vo.ListVoucherVo;
import com.mirror.finance.biz.service.VoucherService;
import com.mirror.mybatis.help.PageInfo;
  
   
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

//@Api(tags = "凭证")
@RestController
@RequestMapping(value = "/voucher")
@RequiredArgsConstructor
@Slf4j
public class VoucherController {
    final VoucherService voucherService;

   // @ApiOperation(value = "创建或修改凭证")
    @PostMapping(value = "/save")
    public ApiResponse<Boolean> save(@Validated @RequestBody CreateVoucherForm form) {
        return ApiResponse.success(voucherService.save(form));
    }

  //  @ApiOperation(value = "分页查询凭证")
    @PostMapping(value = "/list")
    public ApiResponse<PageInfo<ListVoucherVo>> list(@Validated @RequestBody ListVoucherForm form) {
        return ApiResponse.success(voucherService.list(form));
    }

  //  @ApiOperation(value = "获取凭证明细")
    @GetMapping(value = "/get")
    public ApiResponse<GetVoucherVo> get(@RequestParam
                                         @NotNull
                                         @Range(min = 1)
                                                 Long id) {
        return ApiResponse.success(voucherService.get(id));
    }

  //  @ApiOperation(value = "删除凭证")
    @PostMapping(value = "/del")
    public ApiResponse<Boolean> del(@Valid @RequestBody DelVoucherForm form) {
        return ApiResponse.success(voucherService.del(form));
    }
}

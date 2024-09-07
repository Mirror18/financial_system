package com.mirror.controller;

import com.mirror.common.dto.ApiResponse;
import com.mirror.finance.biz.dto.form.CreateSysResourceForm;
import com.mirror.finance.biz.dto.form.DelSysResourceForm;
import com.mirror.finance.biz.dto.form.ListSysResourceForm;
import com.mirror.finance.biz.dto.form.UpdateSysResourceForm;
import com.mirror.finance.biz.dto.vo.GetSysResourceVo;
import com.mirror.finance.biz.dto.vo.ListSysResourceVo;
import com.mirror.finance.biz.service.SysResourceService;
  
   
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

//@Api(tags = "系统资源")
@RestController
@RequestMapping(value = "/sysResource")
@RequiredArgsConstructor
@Slf4j
@Validated
public class SysResourceController {
    final SysResourceService sysResourceService;

  //  @ApiOperation(value = "创建资源")
    @PostMapping(value = "/create")
    public ApiResponse<Boolean> create(@Valid @RequestBody CreateSysResourceForm form) {
        return ApiResponse.success(sysResourceService.create(form));
    }

  //  @ApiOperation(value = "修改资源")
    @PostMapping(value = "/update")
    public ApiResponse<Boolean> update(@Valid @RequestBody UpdateSysResourceForm form) {
        return ApiResponse.success(sysResourceService.update(form));
    }

  //  @ApiOperation(value = "查看资源列表")
    @PostMapping(value = "/list")
    public ApiResponse<List<ListSysResourceVo>> list(@Valid @RequestBody ListSysResourceForm form) {
        return ApiResponse.success(sysResourceService.list(form));
    }

 //   @ApiOperation(value = "删除资源")
    @PostMapping(value = "/del")
    public ApiResponse<Boolean> del(@Valid @RequestBody DelSysResourceForm form) {
        return ApiResponse.success(sysResourceService.del(form));
    }

//    @ApiOperation(value = "查询资源明细")
    @GetMapping(value = "get")
    public ApiResponse<GetSysResourceVo> get(@Valid @NotNull @RequestParam Integer id) {
        return ApiResponse.success(sysResourceService.get(id));
    }
}

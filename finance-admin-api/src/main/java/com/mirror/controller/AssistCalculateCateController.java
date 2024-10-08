package com.mirror.controller;

import com.mirror.common.dto.ApiResponse;
import com.mirror.finance.biz.dto.form.CreateAssistCalculateCateForm;
import com.mirror.finance.biz.dto.form.DelAssistCalculateCateForm;
import com.mirror.finance.biz.dto.form.UpdateAssistCalculateCateForm;
import com.mirror.finance.biz.dto.vo.GetAssistCalculateCateVo;
import com.mirror.finance.biz.dto.vo.ListCalculateCateVo;
import com.mirror.finance.biz.service.AssistCalculateCateService;
import com.fasterxml.jackson.core.JsonProcessingException;
  
   
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * @author mirror
 */ //@Api(tags = "辅助核算类别管理")
@RestController
@RequestMapping(value = "/assistCalculateCate")
@RequiredArgsConstructor
@Slf4j
@Validated
public class AssistCalculateCateController {
    final AssistCalculateCateService assistCalculateCateService;

   // @ApiOperation(value = "创建辅助核算类别")
    @PostMapping(value = "/create")
    public ApiResponse<Boolean> create(@Valid @RequestBody CreateAssistCalculateCateForm form) throws JsonProcessingException {
        return ApiResponse.success(assistCalculateCateService.create(form));
    }

 //   @ApiOperation(value = "删除辅助核算类别")
    @PostMapping(value = "/del")
    public ApiResponse<Boolean> del(@Valid @RequestBody DelAssistCalculateCateForm form) {
        return ApiResponse.success(assistCalculateCateService.del(form));
    }

   // @ApiOperation(value = "修改辅助核算类别")
    @PostMapping(value = "/update")
    public ApiResponse<Boolean> update(@Valid @RequestBody UpdateAssistCalculateCateForm form) throws JsonProcessingException {
        return ApiResponse.success(assistCalculateCateService.update(form));
    }

  //  @ApiOperation(value = "查询辅助核算类别列表")
    @GetMapping(value = "/list")
    public ApiResponse<List<ListCalculateCateVo>> list() {
        return ApiResponse.success(assistCalculateCateService.list());
    }

  //  @ApiOperation(value = "获取辅助核算类别详情")
    @GetMapping(value = "/getById")
    public ApiResponse<GetAssistCalculateCateVo> getById(@RequestParam
                                          @NotNull
                                          @Range(min = 1)
                                                  Long id) throws JsonProcessingException {
        return ApiResponse.success(assistCalculateCateService.getById(id));
    }
}

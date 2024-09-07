package com.mirror.controller;

import com.mirror.common.dto.ApiResponse;
import com.mirror.finance.biz.dto.vo.DataDictionaryVo;
import com.mirror.finance.biz.service.DataDictionaryService;
  
   
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Api(tags = "数据字典")
@RestController
@RequestMapping(value = "/DataDictionary")
@RequiredArgsConstructor
@Slf4j
@Validated
public class DataDictionaryController {
    final DataDictionaryService dataDictionaryService;
  //  @ApiOperation(value = "查询行业数据列表")
    @GetMapping(value = "/listHangYe")
    public ApiResponse<List<DataDictionaryVo>> listHangYe() {
        return ApiResponse.success(dataDictionaryService.listHangYe());
    }

  //  @ApiOperation(value = "查询会计准则数据列表")
    @GetMapping(value = "/listKuaiJiZhunZe")
    public ApiResponse<List<DataDictionaryVo>> listKuaiJiZhunZe() {
        return ApiResponse.success(dataDictionaryService.listKuaiJiZhunZe());
    }
}

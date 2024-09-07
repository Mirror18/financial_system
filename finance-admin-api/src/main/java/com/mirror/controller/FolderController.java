package com.mirror.controller;

import com.mirror.common.dto.ApiResponse;
import com.mirror.finance.biz.dto.form.CreateFolderForm;
import com.mirror.finance.biz.dto.form.DelForm;
import com.mirror.finance.biz.dto.form.ListFolderForm;
import com.mirror.finance.biz.dto.form.UpdateFolderForm;
import com.mirror.finance.biz.dto.vo.GetFolderVo;
import com.mirror.finance.biz.dto.vo.ListFolderVo;
import com.mirror.finance.biz.service.FolderService;
  
   
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

//@Api(tags = "文件夹管理")
@RestController
@RequestMapping(value = "/folder")
@RequiredArgsConstructor
@Slf4j
public class FolderController {
    final FolderService folderService;

  //  @ApiOperation(value = "文件夹列表")
    @GetMapping(value = "/list")
    public ApiResponse<List<ListFolderVo>> list(@Valid @ModelAttribute ListFolderForm form) throws Exception {
        return ApiResponse.success(folderService.list(form));
    }

  //  @ApiOperation(value = "创建文件夹")
    @PostMapping(value = "/create")
    public ApiResponse<Long> list(@Valid @RequestBody CreateFolderForm form) {
        return ApiResponse.success(folderService.create(form));
    }

  //  @ApiOperation(value = "修改文件夹")
    @PostMapping(value = "/update")
    public ApiResponse<Boolean> update(@Valid @RequestBody UpdateFolderForm form) {
        return ApiResponse.success(folderService.update(form));
    }

  //  @ApiOperation(value = "删除文件夹")
    @PostMapping(value = "/del")
    public ApiResponse<Boolean> del(@Valid @RequestBody DelForm form) {
        return ApiResponse.success(folderService.del(form));
    }

 //   @ApiOperation(value = "获取文件夹详情")
    @GetMapping(value = "/get")
    public ApiResponse<GetFolderVo> get(@Valid @RequestParam("id") Long id) {
        return ApiResponse.success(folderService.get(id));
    }
}

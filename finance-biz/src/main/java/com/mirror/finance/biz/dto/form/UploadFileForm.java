package com.mirror.finance.biz.dto.form;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Data
public class UploadFileForm {
  //  @ApiModelProperty(value = "文件夹id")
    @NotNull
    @Min(value = 0)
    private Long folderId;

  //  @ApiModelProperty(value = "当前分片大小")
    @NotNull
    private Integer chunk;

  //  @ApiModelProperty(value = "总分片大小")
    @NotNull
    private Integer totalChunks;

  //  @ApiModelProperty(value = "文件名")
    private String fileName;

  //  @ApiModelProperty(value = "文件唯一编号")
    @Pattern(regexp = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")
    private String uid;

  //  @ApiModelProperty(value = "上传文件")
    private MultipartFile file;
}

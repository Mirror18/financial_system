package com.mirror.finance.biz.service;

import com.mirror.finance.biz.dto.form.*;
import com.mirror.finance.biz.dto.vo.ListFileVo;
import com.mirror.mybatis.help.PageInfo;

import java.util.List;
import java.util.Set;

public interface FileService {
    /**
     * 上传文件
     * @param form
     * @return
     */
    String uploadPart(UploadFileForm form) throws Exception;

    /**
     * 合并上传后的文件
     * @param form
     * @return
     */
    String composeFile(ComposeFileForm form);

    /**
     * 删除分片文件
     * @param form
     * @return
     */
    boolean delSliceFile(DelSliceFileForm form);

    /**
     * 查询文件列表
     * @param form
     * @return
     */
    PageInfo<ListFileVo> list(ListFileForm form) throws Exception;

    /**
     * 查询文件列表
     * @param form
     * @return
     * @throws Exception
     */
    List<ListFileVo> listByIds(ListFileByIdsForm form) throws Exception;

    /**
     * 获取图片url
     * @param id
     * @return
     */
    String getPicUrl(long id) throws Exception;

    /**
     * 删除图片
     *
     * @param form
     * @return
     */
    boolean del(DelForm form);

    /**
     * 检测文件id是否合法
     * @param ids
     * @return
     */
    boolean checkFileIds(Set<Long> ids);

    /**
     * 统计某个文件夹文件的数量
     *
     * @param folderId
     * @return
     */
    int countByFolderId(long folderId);
}

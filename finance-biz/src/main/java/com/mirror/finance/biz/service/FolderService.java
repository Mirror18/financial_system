package com.mirror.finance.biz.service;


import com.mirror.finance.biz.dto.form.CreateFolderForm;
import com.mirror.finance.biz.dto.form.DelForm;
import com.mirror.finance.biz.dto.form.ListFolderForm;
import com.mirror.finance.biz.dto.form.UpdateFolderForm;
import com.mirror.finance.biz.dto.vo.GetFolderVo;
import com.mirror.finance.biz.dto.vo.ListFolderVo;

import java.util.List;

public interface FolderService {
    /**
     * 创建文件夹
     * @param form
     * @return
     */
    long create(CreateFolderForm form);

    /**
     * 修改文件夹
     * @param form
     * @return
     */
    boolean update(UpdateFolderForm form);

    /**
     * 修改文件夹
     *
     * @param form
     * @return
     */
    boolean del(DelForm form);

    /**
     * 查询文件夹列表
     * @param form
     * @return
     */
    List<ListFolderVo> list(ListFolderForm form);

    /**
     * 查询文件夹
     *
     * @param id
     * @return
     */
    GetFolderVo get(long id);
}

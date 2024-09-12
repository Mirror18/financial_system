package com.mirror.finance.biz.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 辅助核算类别（表：assist_calculate_cate）
 *
 * @author mirror
 */
@Setter
@Getter
public class AssistCalculateCate {
    /**
     * 
     */
    private Long id;

    /**
     * 辅助核算类别名称
     */
    private String name;

    /**
     * 自定义列,columnName表示字段名称，column_alias字段别名，["columnName":"c1","columnAlias":"客户编码"]
     */
    private String customerColumn;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 是否禁用
     */
    private Boolean disable;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 用户id
     */
    private Long memberId;

    /**
     * 修改用户id
     */
    private Long updateMemberId;

    /**
     * 是否删除，0：删除，1：未删除
     */
    private Boolean delFlag;

    /**
     * 辅助核算类别[0：系统，不能删除，1：自定义，可自行删除]
     */
    private Integer level;

    /**
     * 类别编码
     */
    private String code;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 使用计数
     */
    private Integer useCount;

    public void initDefault() {
        if (this.getName() == null) {
            this.setName("");
        }
        if (this.getTenantId() == null) {
            this.setTenantId(0L);
        }
        if (this.getDisable() == null) {
            this.setDisable(false);
        }
        if (this.getCreateTime() == null) {
            this.setCreateTime(new Date());
        }
        if (this.getUpdateTime() == null) {
            this.setUpdateTime(new Date());
        }
        if (this.getMemberId() == null) {
            this.setMemberId(0L);
        }
        if (this.getUpdateMemberId() == null) {
            this.setUpdateMemberId(0L);
        }
        if (this.getDelFlag() == null) {
            this.setDelFlag(false);
        }
        if (this.getLevel() == null) {
            this.setLevel(0);
        }
        if (this.getCode() == null) {
            this.setCode("");
        }
        if (this.getSort() == null) {
            this.setSort(0);
        }
        if (this.getUseCount() == null) {
            this.setUseCount(0);
        }
    }

    public void initUpdate() {
    }
}
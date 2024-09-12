package com.mirror.finance.biz.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 辅助核算存货表（表：assist_calculate_inventory）
 *
 * @author mirror
 */
@Setter
@Getter
public class AssistCalculateInventory {
    /**
     * 
     */
    private Long id;

    /**
     * 规格型号
     */
    private String specifications;

    /**
     * 存货类别
     */
    private String inventoryCate;

    /**
     * 计量单位
     */
    private String units;

    /**
     * 启用日期
     */
    private Date startDate;

    /**
     * 停用日期
     */
    private Date endDate;

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
     * 租户id
     */
    private Long tenantId;

    /**
     * 辅助核算id
     */
    private Long assistCalculateSummaryId;

    public void initDefault() {
        if (this.getSpecifications() == null) {
            this.setSpecifications("");
        }
        if (this.getInventoryCate() == null) {
            this.setInventoryCate("");
        }
        if (this.getUnits() == null) {
            this.setUnits("");
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
        if (this.getTenantId() == null) {
            this.setTenantId(0L);
        }
        if (this.getAssistCalculateSummaryId() == null) {
            this.setAssistCalculateSummaryId(0L);
        }
    }

    public void initUpdate() {
    }
}
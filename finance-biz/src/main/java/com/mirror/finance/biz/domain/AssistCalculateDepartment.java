package com.mirror.finance.biz.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 辅助核算部门表（表：assist_calculate_department）
 *
 * @author mirror
 */
@Setter
@Getter
public class AssistCalculateDepartment {
    /**
     * 
     */
    private Long id;

    /**
     * 部门负责人
     */
    private String manager;

    /**
     * 手机
     */
    private String phone;

    /**
     * 入职日期
     */
    private Date startDate;

    /**
     * 撤销日期
     */
    private Date revokeDate;

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
        if (this.getManager() == null) {
            this.setManager("");
        }
        if (this.getPhone() == null) {
            this.setPhone("");
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
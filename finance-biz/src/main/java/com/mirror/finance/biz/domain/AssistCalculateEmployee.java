package com.mirror.finance.biz.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 辅助核算职员表（表：assist_calculate_employee）
 *
 * @author mirror
 */
@Setter
@Getter
public class AssistCalculateEmployee {
    /**
     * 
     */
    private Long id;

    /**
     * 0：未知，1：男，2：女
     */
    private Integer sex;

    /**
     * 部门编码
     */
    private String departmentCode;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 职务
     */
    private String position;

    /**
     * 岗位
     */
    private String job;

    /**
     * 手机
     */
    private String phone;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 入职日期
     */
    private Date startDate;

    /**
     * 离职日期
     */
    private Date departureDate;

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
        if (this.getSex() == null) {
            this.setSex(0);
        }
        if (this.getDepartmentCode() == null) {
            this.setDepartmentCode("");
        }
        if (this.getDepartmentName() == null) {
            this.setDepartmentName("");
        }
        if (this.getPosition() == null) {
            this.setPosition("");
        }
        if (this.getJob() == null) {
            this.setJob("");
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
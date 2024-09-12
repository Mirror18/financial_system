package com.mirror.finance.biz.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 辅助核算（表：assist_calculate_custom）
 *
 * @author mirror
 */
@Setter
@Getter
public class AssistCalculateCustom {
    /**
     * 
     */
    private Long id;

    /**
     * 自定义字段1
     */
    private String c1;

    /**
     * 自定义字段2
     */
    private String c2;

    /**
     * 自定义字段3
     */
    private String c3;

    /**
     * 自定义字段4
     */
    private String c4;

    /**
     * 自定义字段5
     */
    private String c5;

    /**
     * 自定义字段6
     */
    private String c6;

    /**
     * 自定义字段7
     */
    private String c7;

    /**
     * 自定义字段8
     */
    private String c8;

    /**
     * 自定义字段9
     */
    private String c9;

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
     * 自定义字段10
     */
    private String c10;

    /**
     * 辅助核算id
     */
    private Long assistCalculateSummaryId;

    public void initDefault() {
        if (this.getC1() == null) {
            this.setC1("");
        }
        if (this.getC2() == null) {
            this.setC2("");
        }
        if (this.getC3() == null) {
            this.setC3("");
        }
        if (this.getC4() == null) {
            this.setC4("");
        }
        if (this.getC5() == null) {
            this.setC5("");
        }
        if (this.getC6() == null) {
            this.setC6("");
        }
        if (this.getC7() == null) {
            this.setC7("");
        }
        if (this.getC8() == null) {
            this.setC8("");
        }
        if (this.getC9() == null) {
            this.setC9("");
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
        if (this.getC10() == null) {
            this.setC10("");
        }
        if (this.getAssistCalculateSummaryId() == null) {
            this.setAssistCalculateSummaryId(0L);
        }
    }

    public void initUpdate() {
    }
}
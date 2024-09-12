package com.mirror.finance.biz.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 辅助核算客户表（表：assist_calculate_customer）
 *
 * @author mirror
 */
@Setter
@Getter
public class AssistCalculateCustomer {
    /**
     * 
     */
    private Long id;

    /**
     * 客户类别
     */
    private String customerCate;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 手机
     */
    private String phone;

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
     * 统一社会信用代码
     */
    private String unifiedSocialCreditCode;

    /**
     * 省份编码
     */
    private String provinceCode;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 县级编码
     */
    private String countyCode;

    /**
     * 辅助核算id
     */
    private Long assistCalculateSummaryId;

    public void initDefault() {
        if (this.getCustomerCate() == null) {
            this.setCustomerCate("");
        }
        if (this.getAddress() == null) {
            this.setAddress("");
        }
        if (this.getContacts() == null) {
            this.setContacts("");
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
        if (this.getUnifiedSocialCreditCode() == null) {
            this.setUnifiedSocialCreditCode("");
        }
        if (this.getProvinceCode() == null) {
            this.setProvinceCode("");
        }
        if (this.getCityCode() == null) {
            this.setCityCode("");
        }
        if (this.getCountyCode() == null) {
            this.setCountyCode("");
        }
        if (this.getAssistCalculateSummaryId() == null) {
            this.setAssistCalculateSummaryId(0L);
        }
    }

    public void initUpdate() {
    }
}
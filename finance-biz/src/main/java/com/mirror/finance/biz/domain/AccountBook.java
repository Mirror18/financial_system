package com.mirror.finance.biz.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 账套（表：account_book）
 *
 * @author mirror
 */
@Setter
@Getter
public class AccountBook {
    /**
     * 
     */
    private Long id;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 统一社会信用代码
     */
    private String unifiedSocialCreditCode;

    /**
     * 行业代码id（取数据字典）
     */
    private Integer industryId;

    /**
     * 增值税种类[0：小规模纳税人；1：一般纳税人]
     */
    private Byte valueAddedTaxCate;

    /**
     * 凭证是否审核[0：不审核；1：审核]
     */
    private Boolean enableVoucherVerify;

    /**
     * 账套启用年月
     */
    private Date startTime;

    /**
     * 会计准则[0：小企业会计准则；1：企业会计准则；2：民间非盈利组织会计制度；3：农民专业合作社财务会计制度]
     */
    private Byte accountingStandard;

    /**
     * 是否启用固定资产模块[0：不启用；1：启用]
     */
    private Boolean enableFixedAssets;

    /**
     * 是否启用资金模块[0：不启用；1：启用]
     */
    private Boolean enableCapital;

    /**
     * 是否启用进销存[0：不启用；1：启用]
     */
    private Boolean enablePsi;

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

    public void initDefault() {
        if (this.getCompanyName() == null) {
            this.setCompanyName("");
        }
        if (this.getUnifiedSocialCreditCode() == null) {
            this.setUnifiedSocialCreditCode("");
        }
        if (this.getIndustryId() == null) {
            this.setIndustryId(0);
        }
        if (this.getValueAddedTaxCate() == null) {
            this.setValueAddedTaxCate((byte) 0);
        }
        if (this.getEnableVoucherVerify() == null) {
            this.setEnableVoucherVerify(false);
        }
        if (this.getStartTime() == null) {
            this.setStartTime(new Date());
        }
        if (this.getAccountingStandard() == null) {
            this.setAccountingStandard((byte) 0);
        }
        if (this.getEnableFixedAssets() == null) {
            this.setEnableFixedAssets(false);
        }
        if (this.getEnableCapital() == null) {
            this.setEnableCapital(false);
        }
        if (this.getEnablePsi() == null) {
            this.setEnablePsi(false);
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
    }

    public void initUpdate() {
    }
}
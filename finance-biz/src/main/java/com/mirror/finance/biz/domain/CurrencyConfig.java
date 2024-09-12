package com.mirror.finance.biz.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 货币配置（表：currency_config）
 *
 * @author mirror
 */
@Setter
@Getter
public class CurrencyConfig {
    /**
     * 
     */
    private Long id;

    /**
     * 编码[RMB，USD]
     */
    private String code;

    /**
     * 币别名称[人民币，美元]
     */
    private String name;

    /**
     * 汇率
     */
    private BigDecimal exchangeRate;

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
     * 是否是本位币，0：否，1：是
     */
    private Boolean baseCurrencyFlag;

    /**
     * 使用计数
     */
    private Integer useCount;

    public void initDefault() {
        if (this.getCode() == null) {
            this.setCode("");
        }
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
        if (this.getBaseCurrencyFlag() == null) {
            this.setBaseCurrencyFlag(false);
        }
        if (this.getUseCount() == null) {
            this.setUseCount(0);
        }
    }

    public void initUpdate() {
    }
}
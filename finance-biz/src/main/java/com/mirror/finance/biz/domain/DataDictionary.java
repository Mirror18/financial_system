package com.mirror.finance.biz.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 数据字典（表：data_dictionary）
 *
 * @author mirror
 */
@Setter
@Getter
public class DataDictionary {
    /**
     * 
     */
    private Long id;

    /**
     * 数据类型分类编码
     */
    private String dataCodeCate;

    /**
     * 数据编码
     */
    private String dataCode;

    /**
     * 数据值
     */
    private String dataValue;

    /**
     * 数据字典顺序
     */
    private Integer dataSort;

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

    public void initDefault() {
        if (this.getDataCodeCate() == null) {
            this.setDataCodeCate("");
        }
        if (this.getDataCode() == null) {
            this.setDataCode("");
        }
        if (this.getDataValue() == null) {
            this.setDataValue("");
        }
        if (this.getDataSort() == null) {
            this.setDataSort(0);
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
    }

    public void initUpdate() {
    }
}
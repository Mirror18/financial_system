import { PageContainer, ProForm, ProFormText, ProFormSelect, ProFormRadio, ProFormSwitch, ProFormCheckbox } from '@ant-design/pro-components';
import { Card, Form, Row, Col, Button, Input, Select, Radio, Switch, DatePicker, message, Checkbox, Cascader } from 'antd';
import React, { useState, useEffect } from 'react';
import { getCustomer, updateCustomer } from '@/services/ant-design-pro/assistCalculateSummary';
import { listRegion } from '@/services/ant-design-pro/system';
import { history } from 'umi';
import { response } from 'express';

const AssistCalculateCustomerDetail: React.FC = (props) => {
    const [form] = Form.useForm();
    const { p } = props;
    const urlParams = new URL(window.location.href).searchParams;
    const urlParamMap = {};
    for (const [key, value] of urlParams.entries()) {
        urlParamMap[key] = value;
    }

    const [regionData, setRegionData] = useState([]);
    const [selectedRegionValues, setSelectedRegionValues] = useState([]);

    const onFinish = async (values: any) => {
        // let provinceCityCountryCode: string[] = form.getFieldValue("provinceCityCountryCode").split(',');

        let provinceCode = "";
        let cityCode = "";
        let countyCode = "";
        if (selectedRegionValues.length > 0) {
            provinceCode = selectedRegionValues[0];
            cityCode = selectedRegionValues[1];
            countyCode = selectedRegionValues[2];
        }

        let params = {
            ...values,
            id: p.id,
            disable: !form.getFieldValue("disable"),
            provinceCode: provinceCode,
            cityCode: cityCode,
            countyCode: countyCode
        };
        console.log(params);
        await updateCustomer(params).then(response => {
            if (response.data) {
                message.success("修改成功");
                props.updateIsModalOpenState(false);
            }
            else {
                message.error("创建失败");
            }
        }).catch(error => {
            //console.log(error);
        });

    };

    const handleCascaderChange = (values: [], selectedOptions: any) => {
        // values 是选中的值数组
        // selectedOptions 是选中的选项对象数组（包含 label、value、isLeaf 等信息）

        console.log('Selected Values:', values);
        console.log('Selected Options:', selectedOptions);

        // 更新状态
        setSelectedRegionValues(values);
    };
    const refreshData = () => {
        // 执行数据刷新的逻辑
        message.success(p.id)
    };
    // 在组件加载时调用接口
    useEffect(() => {
        //加载省市区数据
        listRegion().then(response => {
            setRegionData(response.data);
        })
    }, []);
    return (
        <ProForm
            form={form}
            onFinish={onFinish}
            layout="vertical"
            request={async (params = {}) => {
                let data = await getCustomer({ id: p.id }).then(response => {
                    const { provinceCode, cityCode, countyCode } = response.data;
                    setSelectedRegionValues([provinceCode, cityCode, countyCode]);
                    return { ...response.data };
                });
                return data;
            }}
        >
            <ProForm.Group>
                <ProFormText
                    width="md"
                    name="code"
                    label="客户编码"
                    placeholder="请输入客户编码"
                    rules={[{ required: true }]}
                />
                <ProFormText
                    width="md"
                    name="name"
                    label="客户名称"
                    placeholder="请输入客户名称"
                    rules={[{ required: true, max: 50 }]}
                />

            </ProForm.Group>
            <ProForm.Group>
                <ProFormText
                    width="md"
                    name="customerCate"
                    label="客户类别"
                    placeholder="请输入客户类别"
                />
                <ProFormText
                    width="md"
                    name="unifiedSocialCreditCode"
                    label="统一社会信用代码"
                    placeholder="请输入统一社会信用代码"
                    rules={[{ max: 50 }]}
                />

            </ProForm.Group>
            <ProForm.Group>
                <ProForm.Item
                    name="provinceCityCountryCode"
                    label="经营地址">
                    <Cascader
                        onChange={handleCascaderChange}
                        options={regionData}
                        placeholder="请选择省市区"
                        value={selectedRegionValues}
                    //defaultValue={selectedRegionValues}
                    ></Cascader>
                </ProForm.Item>

                <ProFormText
                    width="md"
                    name="address"
                    label=" "
                    placeholder="请输入经营地址"
                    rules={[{ max: 50 }]}
                />

            </ProForm.Group>
            <ProForm.Group>
                <ProFormText
                    width="md"
                    name="contacts"
                    label="联系人"
                    placeholder="请输入联系人"
                    rules={[{ max: 50 }]}
                />
                <ProFormText
                    width="md"
                    name="phone"
                    label="手机"
                    placeholder="请输入手机"
                    rules={[{ max: 50 }, {
                        pattern: /^1\d{10}$/,
                        message: '手机号格式错误！',
                    }]}
                />
            </ProForm.Group>

            <ProFormText
                width="md"
                name="notes"
                label="备注"
                placeholder="请输入备注"
                rules={[{ max: 500 }]}
                fieldProps={{ style: { width: '61%' } }}
            />

            <ProForm.Group>
                <ProFormSwitch width="md" name="disable" label="是否启用" rules={[{ required: true }]} checkedChildren="启用" unCheckedChildren="停用" initialValue={true} />
            </ProForm.Group>
        </ProForm>
    );
};

export default AssistCalculateCustomerDetail;
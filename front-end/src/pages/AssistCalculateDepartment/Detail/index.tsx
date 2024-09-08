import { PageContainer, ProForm, ProFormText, ProFormSelect, ProFormRadio, ProFormSwitch, ProFormCheckbox, ProFormDatePicker } from '@ant-design/pro-components';
import { Card, Form, Row, Col, Button, Input, Select, Radio, Switch, DatePicker, message, Checkbox, Cascader } from 'antd';
import React, { useState, useEffect } from 'react';
import { getDepartment, updateDepartment } from '@/services/ant-design-pro/assistCalculateSummary';
import { history } from 'umi';
import { response } from 'express';

const AssistCalculateDepartmentDetail: React.FC = (props) => {
    const [form] = Form.useForm();
    const { p } = props;

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
        await updateDepartment(params).then(response => {
            if (response.data) {
                message.success("修改成功");
                props.updateIsModalOpenState(false);
            }
            else {
                message.error("修改失败");
            }
        }).catch(error => {
            //console.log(error);
        });

    };

    // 在组件加载时调用接口
    useEffect(() => {
    }, []);
    return (
        <ProForm
            form={form}
            onFinish={onFinish}
            layout="vertical"
            request={async (params = {}) => {
                let data = await getDepartment({ id: p.id }).then(response => {
                    return { ...response.data };
                });
                return data;
            }}
        >
            <ProForm.Group>
                <ProFormText
                    width="md"
                    name="code"
                    label="部门编码"
                    placeholder="请输入部门编码"
                    rules={[{ required: true }]}
                />
                <ProFormText
                    width="md"
                    name="name"
                    label="部门名称"
                    placeholder="请输入部门名称"
                    rules={[{ required: true, max: 50 }]}
                />

            </ProForm.Group>
            <ProForm.Group>
                <ProFormText
                    width="md"
                    name="manager"
                    label="负责人"
                    placeholder="请输入部门负责人"
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

            <ProForm.Group>
                <ProFormDatePicker
                    width="md"
                    name="startDate"
                    label="成立日期"
                    placeholder="请输入成立日期"
                />

                <ProFormDatePicker
                    width="md"
                    name="revokeDate"
                    label="撤销日期"
                    placeholder="请输入撤销日期"
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

export default AssistCalculateDepartmentDetail;
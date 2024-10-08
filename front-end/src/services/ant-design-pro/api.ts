// @ts-ignore
/* eslint-disable */
import { request } from '@umijs/max';
import { MenuDataItem } from '@umijs/route-utils';

/** 获取当前的用户 GET /api/currentUser */
export async function currentUser(options?: { [key: string]: any }) {
  return request<{
    data: API.CurrentUser;
  }>('/adminapi/user/currentUser', {
    method: 'GET',
    ...(options || {}),
  });
}

/** 退出登录接口 POST /api/login/outLogin */
export async function outLogin(
  params: {
    clientId?: string;
  }, options?: { [key: string]: any }
) {
  return request<Record<string, any>>('/adminapi/user/loginOut', {
    method: 'POST',
    data: {
      ...params,
    },
    ...(options || {}),
  });
}

/** 登录接口 POST /adminapi/login/phonePasswordLogin */
export async function phonePasswordLogin(body: API.PhonePasswordLoginParams, options?: { [key: string]: any }) {
  return request<API.LoginResult>('/adminapi/login/phonePasswordLogin', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 登录接口 POST /adminapi/login/phoneSmsCodeLogin */
export async function phoneSmsCodeLogin(body: API.PhoneSmsCodeLoginParams, options?: { [key: string]: any }) {
  return request<API.LoginResult>('/adminapi/login/phoneSmsCodeLogin', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 GET /api/notices */
export async function getNotices(options?: { [key: string]: any }) {
  return request<API.NoticeIconList>('/api/notices', {
    method: 'GET',
    ...(options || {}),
  });
}

/** 获取规则列表 GET /api/rule */
export async function rule(
  params: {
    // query
    /** 当前的页码 */
    current?: number;
    /** 页面的容量 */
    pageSize?: number;
  },
  options?: { [key: string]: any },
) {
  return request<API.RuleList>('/api/rule', {
    method: 'GET',
    params: {
      ...params,
    },
    ...(options || {}),
  });
}

/** 新建规则 PUT /api/rule */
export async function updateRule(options?: { [key: string]: any }) {
  return request<API.RuleListItem>('/api/rule', {
    method: 'PUT',
    ...(options || {}),
  });
}

/** 新建规则 POST /api/rule */
export async function addRule(options?: { [key: string]: any }) {
  return request<API.RuleListItem>('/api/rule', {
    method: 'POST',
    ...(options || {}),
  });
}

/** 删除规则 DELETE /api/rule */
export async function removeRule(options?: { [key: string]: any }) {
  return request<Record<string, any>>('/api/rule', {
    method: 'DELETE',
    ...(options || {}),
  });
}

/** 获取当前的用户 GET /api/sysRole/listRoleBindMenu */
export async function listRoleBindMenu(options?: { [key: string]: any }) {
  return request<API.ApiResponse<MenuDataItem[]>>('/adminapi/sysRole/listRoleBindMenu', {
    method: 'GET',
    ...(options || {}),
  });
}
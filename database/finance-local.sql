create table account_book
(
    id                         bigint auto_increment
        primary key,
    company_name               varchar(200) default ''                not null comment '公司名称',
    unified_social_credit_code varchar(50)  default ''                not null comment '统一社会信用代码',
    industry_id                int          default 0                 not null comment '行业代码id（取数据字典）',
    value_added_tax_cate       tinyint      default 0                 not null comment '增值税种类[0：小规模纳税人；1：一般纳税人]',
    enable_voucher_verify      tinyint(1)   default 0                 not null comment '凭证是否审核[0：不审核；1：审核]',
    start_time                 datetime     default CURRENT_TIMESTAMP not null comment '账套启用年月',
    accounting_standard        tinyint      default 0                 not null comment '会计准则[0：小企业会计准则；1：企业会计准则；2：民间非盈利组织会计制度；3：农民专业合作社财务会计制度]',
    enable_fixed_assets        tinyint(1)   default 0                 not null comment '是否启用固定资产模块[0：不启用；1：启用]',
    enable_capital             tinyint(1)   default 0                 not null comment '是否启用资金模块[0：不启用；1：启用]',
    enable_psi                 tinyint(1)   default 0                 not null comment '是否启用进销存[0：不启用；1：启用]',
    disable                    tinyint(1)   default 0                 not null comment '是否禁用',
    create_time                datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time                datetime     default CURRENT_TIMESTAMP not null comment '修改时间',
    member_id                  bigint       default 0                 not null comment '用户id',
    update_member_id           bigint       default 0                 not null comment '修改用户id',
    del_flag                   tinyint(1)   default 0                 not null comment '是否删除，0：删除，1：未删除'
)
    comment '账套';

create table member
(
    id           bigint auto_increment
        primary key,
    nick_name    varchar(50)  default ''                not null comment '用户昵称',
    disable      tinyint(1)   default 0                 not null comment '是否禁用',
    create_time  datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time  datetime     default CURRENT_TIMESTAMP not null comment '修改时间',
    name         varchar(50)  default ''                not null comment '姓名',
    avatar_url   varchar(200) default ''                not null comment '头像',
    sys_role_ids json                                   not null comment '角色id，多个以英文逗号分隔',
    tenant_id    bigint       default 0                 not null comment '租户id',
    email        varchar(50)  default ''                not null comment '邮箱地址'
)
    comment '用户表';

create table member_bind_phone
(
    id          bigint auto_increment
        primary key,
    phone       varchar(20) default ''                not null comment '手机号',
    member_id   bigint      default 0                 not null comment '用户id',
    disable     tinyint(1)  default 0                 not null comment '是否禁用',
    create_time datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime    default CURRENT_TIMESTAMP not null comment '修改时间',
    password    varchar(100)                          null comment '密码',
    constraint member_bind_mobile_member_id_uindex
        unique (member_id),
    constraint member_bind_mobile_mobile_member_id_uindex
        unique (phone, member_id),
    constraint member_bind_mobile_mobile_uindex
        unique (phone)
)
    comment '用户表绑定手机表';

create table member_bind_wx_openid
(
    id          bigint auto_increment
        primary key,
    app_id      varchar(50) default ''                not null comment '小程序或者公众号appid',
    open_id     varchar(50) default ''                not null comment '微信openid',
    member_id   bigint      default 0                 not null comment '用户id',
    disable     tinyint(1)  default 0                 not null comment '是否禁用',
    create_time datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime    default CURRENT_TIMESTAMP not null comment '修改时间',
    constraint member_bind_wx_openid_app_id_open_id_member_id_uindex
        unique (app_id, open_id, member_id),
    constraint member_bind_wx_openid_app_id_open_id_uindex
        unique (app_id, open_id)
)
    comment '用户表绑定微信openid表';

create table sys_config
(
    id               int auto_increment
        primary key,
    config_name      varchar(200) default ''                not null comment '配置名称',
    type             varchar(50)  default ''                not null comment '类型',
    config_key       varchar(50)  default ''                not null comment '配置key',
    config_value     json                                   not null comment '配置内容',
    create_time      datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time      datetime     default CURRENT_TIMESTAMP not null comment '修改时间',
    member_id        bigint       default 0                 not null comment '用户id',
    update_member_id bigint       default 0                 not null comment '修改用户id',
    del_flag         tinyint(1)   default 0                 not null comment '是否删除，0：删除，1：未删除',
    disable          tinyint(1)   default 0                 not null comment '是否禁用',
    constraint sys_config_type_config_key_uindex
        unique (type, config_key)
)
    comment '系统配置';

create table sys_menu
(
    id               int auto_increment
        primary key,
    pid              int          default 0                 not null comment '父级菜单',
    name             varchar(50)  default ''                not null comment '菜单名称',
    path             varchar(200) default ''                not null comment '菜单路由',
    component        varchar(200) default ''                not null comment '菜单组件',
    icon             varchar(20)  default ''                not null comment '图标',
    layout           tinyint(1)   default 1                 not null comment '是否使用布局',
    hide_in_menu     tinyint(1)   default 0                 not null comment '是否隐藏菜单',
    redirect         varchar(200) default ''                not null comment '重定向地址',
    sort             int          default 0                 not null comment '排序',
    create_time      datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time      datetime     default CURRENT_TIMESTAMP not null comment '修改时间',
    member_id        bigint       default 0                 not null comment '用户id',
    update_member_id bigint       default 0                 not null comment '修改用户id',
    del_flag         tinyint(1)   default 0                 not null comment '是否删除，0：删除，1：未删除',
    disable          tinyint(1)   default 0                 not null comment '是否禁用',
    node_path        int          default 0                 not null comment '节点深度，0表示一级节点'
)
    comment '系统菜单';

create table sys_resource
(
    id               int auto_increment
        primary key,
    pid              int          default 0                 not null comment '父id',
    name             varchar(50)  default ''                not null comment '资源名称',
    path             varchar(200) default ''                not null comment '资源路径',
    sort             int          default 0                 not null comment '排序',
    create_time      datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time      datetime     default CURRENT_TIMESTAMP not null comment '修改时间',
    member_id        bigint       default 0                 not null comment '用户id',
    update_member_id bigint       default 0                 not null comment '修改用户id',
    del_flag         tinyint(1)   default 0                 not null comment '是否删除，0：删除，1：未删除',
    disable          tinyint(1)   default 0                 not null comment '是否禁用',
    node_path        int          default 0                 not null comment '节点深度',
    constraint sys_resource_path_uindex
        unique (path)
)
    comment '系统资源';

create table sys_role
(
    id               int auto_increment
        primary key,
    role_name        varchar(200) default ''                not null comment '角色名称',
    create_time      datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time      datetime     default CURRENT_TIMESTAMP not null comment '修改时间',
    member_id        bigint       default 0                 not null comment '用户id',
    update_member_id bigint       default 0                 not null comment '修改用户id',
    del_flag         tinyint(1)   default 0                 not null comment '是否删除，0：删除，1：未删除',
    disable          tinyint(1)   default 0                 not null comment '是否禁用'
)
    comment '系统角色';

create table sys_role_bind_menu
(
    id               int auto_increment
        primary key,
    sys_role_id      int        default 0                 not null comment '角色id',
    sys_menu_id      int        default 0                 not null comment '系统菜单id',
    create_time      datetime   default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time      datetime   default CURRENT_TIMESTAMP not null comment '修改时间',
    member_id        bigint     default 0                 not null comment '用户id',
    update_member_id bigint     default 0                 not null comment '修改用户id',
    del_flag         tinyint(1) default 0                 not null comment '是否删除，0：删除，1：未删除',
    disable          tinyint(1) default 0                 not null comment '是否禁用'
)
    comment '系统角色绑定菜单';

create table tenant
(
    id              bigint auto_increment
        primary key,
    name            varchar(50) default ''                not null comment '租户名称',
    disable         tinyint(1)  default 0                 not null comment '是否禁用',
    create_time     datetime    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time     datetime    default CURRENT_TIMESTAMP not null comment '修改时间',
    admin_id        bigint      default 0                 not null comment '管理员id',
    update_admin_id bigint      default 0                 not null comment '修改管理员id',
    del_flag        tinyint(1)  default 0                 not null comment '是否删除，0：删除，1：未删除'
)
    comment '租户表';


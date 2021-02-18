delete from tsys_role_right where TRANS_CODE = 'disclosureManager';
delete from tsys_user_right  where trans_code = 'disclosureManager';
delete from tsys_subtrans where TRANS_CODE = 'disclosureManager';
delete from tsys_trans where TRANS_CODE = 'disclosureManager';
delete from tsys_menu where MENU_CODE = 'disclosureManager';
insert into tsys_menu (MENU_CODE, KIND_CODE, TRANS_CODE, SUB_TRANS_CODE, MENU_NAME, MENU_ARG, MENU_ICON, MENU_URL, WINDOW_TYPE, WINDOW_MODEL, TIP, HOT_KEY, PARENT_CODE, ORDER_NO, OPEN_FLAG, TREE_IDX, REMARK, MENU_PLUGIN_NAME, MENU_PLUGIN_DLL, MENU_TYPE, HELP_URL, TENANT_ID, MODULE_ID, MENU_NO, MENU_LEVEL, MENU_I18N, EXT_FIELD, EXT_FIELD1, EXT_FIELD2, EXT_FIELD3, EXT_FIELD4, EXT_FIELD5, MENU_IS_LEAF, MODULE_TYPE, PARAM, APP_CODE, IS_KEEP_ALIVEA, IS_HIDDEN)
values ('disclosureManager', 'amop', 'disclosureManager', 'disclosureManager', '信息披露-管理端', '', '', '', '', '', '', '', 'amop', 3, '', '#bizroot#amop#disclosureManager#', '', '', '', 'hui', '', '', 0, '', null, '', '', '', '', '', '', '', '', '', '', 'hsfundIdrInfoDcs', '1', '0');
insert into tsys_trans (TRANS_CODE, TRANS_NAME, KIND_CODE, MODEL_CODE, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, TRANS_ORDER)
values ('disclosureManager', '信息披露-管理端', 'amop', '2', '', '', '', '', '', null);
insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('disclosureManager', 'disclosureManager', '信息披露-管理端', '', '', '', '1', '', '', '', '', '', '', '', null);
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'disclosureManager', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'disclosureManager', 'admin', 'admin', 0, 0, 0, '2', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'disclosureManager', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'disclosureManager', 'admin', 'admin', 0, 0, 0, '2', '', '', '');




------ 产品方案设置权限 begin


delete from tsys_role_right where TRANS_CODE = 'productPlanSet';
delete from tsys_user_right  where trans_code = 'productPlanSet';
delete from tsys_subtrans where TRANS_CODE = 'productPlanSet';
delete from tsys_trans where TRANS_CODE = 'productPlanSet';
delete from tsys_menu where MENU_CODE = 'productPlanSet';

-- 菜单权限
insert into tsys_menu (MENU_CODE, KIND_CODE, TRANS_CODE, SUB_TRANS_CODE, MENU_NAME, MENU_ARG, MENU_ICON, MENU_URL, WINDOW_TYPE, WINDOW_MODEL, TIP, HOT_KEY, PARENT_CODE, ORDER_NO, OPEN_FLAG, TREE_IDX, REMARK, MENU_PLUGIN_NAME, MENU_PLUGIN_DLL, MENU_TYPE, HELP_URL, TENANT_ID, MODULE_ID, MENU_NO, MENU_LEVEL, MENU_I18N, EXT_FIELD, EXT_FIELD1, EXT_FIELD2, EXT_FIELD3, EXT_FIELD4, EXT_FIELD5, MENU_IS_LEAF, MODULE_TYPE, PARAM, APP_CODE, IS_KEEP_ALIVEA, IS_HIDDEN)
values ('productPlanSet', 'amop', 'productPlanSet', 'productPlanSet', '产品方案设置', '', '', '/hsfundIdrInfoDcs/productPlanSet', '', '', '', '', 'disclosureManager', 9, '', '#bizroot#amop#disclosureManager#productPlanSet#', ' ', '', '', 'hui', '', 'BIZ', 0, '', null, '', '', '', '', '', '', '', '', '', '', 'hsfundIdrInfoDcs', '1', '0');
insert into tsys_trans (TRANS_CODE, TRANS_NAME, KIND_CODE, MODEL_CODE, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, TRANS_ORDER)
values ('productPlanSet', '产品方案设置', 'productPlanSet', '2', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', 'productPlanSet', '产品方案设置', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSet', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSet', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSet', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSet', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


-- 后台url权限
insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', '821109001', '查询', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109001', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109001', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109001', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109001', 'admin', 'admin', 0, 0, 0, '2', '', '', '');





insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', '821109002', '详情', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109002', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109002', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109002', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109002', 'admin', 'admin', 0, 0, 0, '2', '', '', '');




insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', '821109003', '删除', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109003', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109003', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109003', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109003', 'admin', 'admin', 0, 0, 0, '2', '', '', '');




insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', '821109004', '编辑', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109004', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109004', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109004', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109004', 'admin', 'admin', 0, 0, 0, '2', '', '', '');



insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', '821109005', '新增', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109005', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109005', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109005', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109005', 'admin', 'admin', 0, 0, 0, '2', '', '', '');




------ 管理人方案设置权限 begin


delete from tsys_role_right where TRANS_CODE = 'managerPlanSet';
delete from tsys_user_right  where trans_code = 'managerPlanSet';
delete from tsys_subtrans where TRANS_CODE = 'managerPlanSet';
delete from tsys_trans where TRANS_CODE = 'managerPlanSet';
delete from tsys_menu where MENU_CODE = 'managerPlanSet';

-- 菜单权限
insert into tsys_menu (MENU_CODE, KIND_CODE, TRANS_CODE, SUB_TRANS_CODE, MENU_NAME, MENU_ARG, MENU_ICON, MENU_URL, WINDOW_TYPE, WINDOW_MODEL, TIP, HOT_KEY, PARENT_CODE, ORDER_NO, OPEN_FLAG, TREE_IDX, REMARK, MENU_PLUGIN_NAME, MENU_PLUGIN_DLL, MENU_TYPE, HELP_URL, TENANT_ID, MODULE_ID, MENU_NO, MENU_LEVEL, MENU_I18N, EXT_FIELD, EXT_FIELD1, EXT_FIELD2, EXT_FIELD3, EXT_FIELD4, EXT_FIELD5, MENU_IS_LEAF, MODULE_TYPE, PARAM, APP_CODE, IS_KEEP_ALIVEA, IS_HIDDEN)
values ('managerPlanSet', 'amop', 'managerPlanSet', 'managerPlanSet', '管理人方案设置', '', '', '/hsfundIdrInfoDcs/managerPlanSet', '', '', '', '', 'disclosureManager', 10, '', '#bizroot#amop#disclosureManager#managerPlanSet#', ' ', '', '', 'hui', '', 'BIZ', 0, '', null, '', '', '', '', '', '', '', '', '', '', 'hsfundIdrInfoDcs', '1', '0');
insert into tsys_trans (TRANS_CODE, TRANS_NAME, KIND_CODE, MODEL_CODE, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, TRANS_ORDER)
values ('managerPlanSet', '管理人方案设置', 'managerPlanSet', '2', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', 'managerPlanSet', '管理人方案设置', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSet', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSet', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSet', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSet', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

-- 后台url权限
insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', '821110001', '查询', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110001', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110001', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110001', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110001', 'admin', 'admin', 0, 0, 0, '2', '', '', '');





insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', '821110002', '详情', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110002', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110002', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110002', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110002', 'admin', 'admin', 0, 0, 0, '2', '', '', '');




insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', '821110003', '删除', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110003', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110003', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110003', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110003', 'admin', 'admin', 0, 0, 0, '2', '', '', '');




insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', '821110004', '编辑', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110004', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110004', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110004', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110004', 'admin', 'admin', 0, 0, 0, '2', '', '', '');



insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', '821110005', '新增', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110005', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110005', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110005', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821110005', 'admin', 'admin', 0, 0, 0, '2', '', '', '');






insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('disclosureManager', 'managerId', '管理人代码', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'managerId', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'managerId', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'managerId', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'managerId', 'admin', 'admin', 0, 0, 0, '2', '', '', '');



insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('disclosureManager', 'dict', '字典', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'dict', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'dict', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'dict', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'dict', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('disclosureManager', 'exceptionPrdCode', '产品代码筛选', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'exceptionPrdCode', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'exceptionPrdCode', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'exceptionPrdCode', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'exceptionPrdCode', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('disclosureManager', 'getIDRTemplate', '获取前端配置模板', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'getIDRTemplate', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'getIDRTemplate', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'getIDRTemplate', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', 'getIDRTemplate', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('disclosureManager', '821104001', '根据管理人代码查询产品系列', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', '821104001', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', '821104001', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', '821104001', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('disclosureManager', '821104001', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


-- 字典


delete from tsys_dict_entry where dict_entry_code = 'IDR_PUB_CPYWSJ_FX';
delete from tsys_dict_item where dict_entry_code = 'IDR_PUB_CPYWSJ_FX';
insert into tsys_dict_entry (dict_entry_code, kind_code, dict_entry_name, ctrl_flag, remark) values ('IDR_PUB_CPYWSJ_FX','0','产品业务事件','0',' ');
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('01','IDR_PUB_CPYWSJ_FX','产品发行',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('02','IDR_PUB_CPYWSJ_FX','产品募集',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('03','IDR_PUB_CPYWSJ_FX','产品成立',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('04','IDR_PUB_CPYWSJ_FX','产品分红',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('05','IDR_PUB_CPYWSJ_FX','产品份额确认',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('06','IDR_PUB_CPYWSJ_FX','产品开放',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('07','IDR_PUB_CPYWSJ_FX','产品到期',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('08','IDR_PUB_CPYWSJ_FX','产品净值披露',10);


delete from tsys_dict_entry where dict_entry_code = 'IDR_PUB_SFBZ';
delete from tsys_dict_item where dict_entry_code = 'IDR_PUB_SFBZ';
insert into tsys_dict_entry (dict_entry_code, kind_code, dict_entry_name, ctrl_flag, remark) values ('IDR_PUB_SFBZ','0','是否标志','0',' ');
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('01','IDR_PUB_SFBZ','是',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('02','IDR_PUB_SFBZ','否',10);


delete from tsys_dict_entry where dict_entry_code = 'IDR_ID_PLFASYDX';
delete from tsys_dict_item where dict_entry_code = 'IDR_ID_PLFASYDX';
insert into tsys_dict_entry (dict_entry_code, kind_code, dict_entry_name, ctrl_flag, remark) values ('IDR_ID_PLFASYDX','0','披露方案适用对象','0',' ');
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('01','IDR_ID_PLFASYDX','产品方案',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('02','IDR_ID_PLFASYDX','管理人方案',10);




delete from tsys_dict_entry where dict_entry_code = 'IDR_ID_WDNBFL';
delete from tsys_dict_item where dict_entry_code = 'IDR_ID_WDNBFL';
insert into tsys_dict_entry (dict_entry_code, kind_code, dict_entry_name, ctrl_flag, remark) values ('IDR_ID_WDNBFL','0','文档内部分类','0',' ');
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('01','IDR_ID_WDNBFL','产品说明书',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('02','IDR_ID_WDNBFL','风险揭示书',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('03','IDR_ID_WDNBFL','产品销售协议',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('04','IDR_ID_WDNBFL','客户权益须知',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('05','IDR_ID_WDNBFL','产品发行公告',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('06','IDR_ID_WDNBFL','产品成立公告',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('07','IDR_ID_WDNBFL','产品净值公告',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('08','IDR_ID_WDNBFL','产品分红公告',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('09','IDR_ID_WDNBFL','产品开放公告',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('10','IDR_ID_WDNBFL','非标变更公告',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('11','IDR_ID_WDNBFL','产品到期公告',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('12','IDR_ID_WDNBFL','产品季度公告',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('13','IDR_ID_WDNBFL','产品半年度公告',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('14','IDR_ID_WDNBFL','产品年度公告',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('15','IDR_ID_WDNBFL','理财产品对账单',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('16','IDR_ID_WDNBFL','理财业务半年度公告',10);
insert into tsys_dict_item (dict_item_code, dict_entry_code, dict_item_name, dict_item_order) values ('17','IDR_ID_WDNBFL','理财业务年度公告',10);


delete from tsys_dict_entry where dict_entry_code = 'BFAM_MJFS';
delete from tsys_dict_item where dict_entry_code = 'BFAM_MJFS';
insert into tsys_dict_entry (DICT_ENTRY_CODE, KIND_CODE, DICT_ENTRY_NAME, CTRL_FLAG, REMARK) values ('BFAM_MJFS', '0', '募集方式', '0',' ');

insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, DICT_ITEM_ORDER) values ('01', 'BFAM_MJFS', '公募',  1);
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, DICT_ITEM_ORDER) values ('02', 'BFAM_MJFS', '私募',  2);

delete from tsys_dict_entry where dict_entry_code = 'BFAM_CPYZMS';
delete from tsys_dict_item where dict_entry_code = 'BFAM_CPYZMS';
insert into tsys_dict_entry (DICT_ENTRY_CODE, KIND_CODE, DICT_ENTRY_NAME, CTRL_FLAG, LIFECYCLE, PLATFORM, REMARK) values ('BFAM_CPYZMS', '0', '产品运作模式', '0', '', '1', ' ');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('01', 'BFAM_CPYZMS', '封闭式净值型', '', '', 1, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('02', 'BFAM_CPYZMS', '封闭式非净值型', '', '', 2, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('03', 'BFAM_CPYZMS', '开放式净值型', '', '', 3, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('04', 'BFAM_CPYZMS', '开放式非净值型', '', '', 4, '');


delete from tsys_dict_entry where dict_entry_code = 'BFAM_CPXSMBLX';
delete from tsys_dict_item where dict_entry_code = 'BFAM_CPXSMBLX';

insert into tsys_dict_entry (DICT_ENTRY_CODE, KIND_CODE, DICT_ENTRY_NAME, CTRL_FLAG, LIFECYCLE, PLATFORM, REMARK) values ('BFAM_CPXSMBLX', '0', '产品销售模板类型', '0', '', '1', ' ');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('1405', 'BFAM_CPXSMBLX', '开放式收益类产品', '', '', 1, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('1102', 'BFAM_CPXSMBLX', '封闭式收益类产品', '', '', 2, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('1303', 'BFAM_CPXSMBLX', '封闭式净值类产品', '', '', 3, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('1300', 'BFAM_CPXSMBLX', '开放式净值类产品', '', '', 4, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('1200', 'BFAM_CPXSMBLX', '现金管理类产品', '', '', 5, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('B102', 'BFAM_CPXSMBLX', '代销产品', '', '', 6, '');


insert into tsys_dict_entry (DICT_ENTRY_CODE, KIND_CODE, DICT_ENTRY_NAME, CTRL_FLAG, LIFECYCLE, PLATFORM, REMARK) values ('BFAM_CPTZXZ', '0', '产品投资性质', '0', '', '1', ' ');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('01', 'BFAM_CPTZXZ', '固定收益类', '', '', 1, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('02', 'BFAM_CPTZXZ', '权益类', '', '', 2, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('03', 'BFAM_CPTZXZ', '商品及金融衍生品类', '', '', 3, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('04', 'BFAM_CPTZXZ', '混合类', '', '', 4, '');


insert into tsys_dict_entry (DICT_ENTRY_CODE, KIND_CODE, DICT_ENTRY_NAME, CTRL_FLAG, LIFECYCLE, PLATFORM, REMARK) values ('BFAM_CPZT', '0', '产品状态', '0', '', '1', ' ');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('A0', 'BFAM_CPZT', '申报期', '', '', 1, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('A1', 'BFAM_CPZT', '申报失败', '', '', 2, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('A2', 'BFAM_CPZT', '申报成功', '', '', 3, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('B0', 'BFAM_CPZT', '发行募集期', '', '', 4, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('B1', 'BFAM_CPZT', '发行失败', '', '', 5, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('C0', 'BFAM_CPZT', '存续期 ', '', '', 6, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('D1', 'BFAM_CPZT', '提前到期', '', '', 7, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('D2', 'BFAM_CPZT', '正常到期', '', '', 8, '');
insert into tsys_dict_item (DICT_ITEM_CODE, DICT_ENTRY_CODE, DICT_ITEM_NAME, LIFECYCLE, PLATFORM, DICT_ITEM_ORDER, REL_CODE) values ('D3', 'BFAM_CPZT', '延迟到期 ', '', '', 9, '');



BFAM_MJFS

BFAM_CPYZMS

BFAM_CPXSMBLX

BFAM_CPTZXZ

BFAM_CPZT

PRDIssueElement_A  886696248424268842
--
topic:
1067453626907100160

auth:prddimAdapt_A 
template：1067453007592948736

configId:1067453334924821504 | 1067912830960796672 | 1068724871711687680 | 1068731127901979648 | 1068736782276756480 | 1068736833254327296

-- 配置

权限
INSERT INTO amop_base_formauthconf ( AUTHCONF_ID ,  TEMPCONF_ID ,  TEMPLATE_ID ,  REQUIRED ,  SHOW_FLAG ,  READONLY ,  NEED_BGPROCESS ,  ORDER_NO ) VALUES ('prddimAdapt_A', '###{input}##', '886696248424268842', '0', '1', '0', '1', 10);


INSERT INTO amop_base_formauthconf(AUTHCONF_ID, TEMPCONF_ID, TEMPLATE_ID, REQUIRED, SHOW_FLAG, READONLY, NEED_BGPROCESS, ORDER_NO) VALUES ('prddimAdapt_A', '1067453334924821504', '1067453007592948736', '0', '1', '0', '1', 10);
INSERT INTO amop_base_formauthconf(AUTHCONF_ID, TEMPCONF_ID, TEMPLATE_ID, REQUIRED, SHOW_FLAG, READONLY, NEED_BGPROCESS, ORDER_NO) VALUES ('prddimAdapt_A', '1067912830960796672', '1067453007592948736', '0', '1', '0', '1', 20);
INSERT INTO amop_base_formauthconf(AUTHCONF_ID, TEMPCONF_ID, TEMPLATE_ID, REQUIRED, SHOW_FLAG, READONLY, NEED_BGPROCESS, ORDER_NO) VALUES ('prddimAdapt_A', '1068724871711687680', '1067453007592948736', '0', '1', '0', '1', 30);
INSERT INTO amop_base_formauthconf(AUTHCONF_ID, TEMPCONF_ID, TEMPLATE_ID, REQUIRED, SHOW_FLAG, READONLY, NEED_BGPROCESS, ORDER_NO) VALUES ('prddimAdapt_A', '1068731127901979648', '1067453007592948736', '0', '1', '0', '1', 40);
INSERT INTO amop_base_formauthconf(AUTHCONF_ID, TEMPCONF_ID, TEMPLATE_ID, REQUIRED, SHOW_FLAG, READONLY, NEED_BGPROCESS, ORDER_NO) VALUES ('prddimAdapt_A', '1068736782276756480', '1067453007592948736', '0', '1', '0', '1', 50);
INSERT INTO amop_base_formauthconf(AUTHCONF_ID, TEMPCONF_ID, TEMPLATE_ID, REQUIRED, SHOW_FLAG, READONLY, NEED_BGPROCESS, ORDER_NO) VALUES ('prddimAdapt_A', '1068736833254327296', '1067453007592948736', '0', '1', '0', '1', 60);


INSERT INTO amop_base_formauthconf(AUTHCONF_ID, TEMPCONF_ID, TEMPLATE_ID, REQUIRED, SHOW_FLAG, READONLY, NEED_BGPROCESS, ORDER_NO) VALUES ('prddimAdapt_B', '1067453334924821504', '1069492798752818176', '0', '1', '0', '1', 10);
INSERT INTO amop_base_formauthconf(AUTHCONF_ID, TEMPCONF_ID, TEMPLATE_ID, REQUIRED, SHOW_FLAG, READONLY, NEED_BGPROCESS, ORDER_NO) VALUES ('prddimAdapt_B', '1067912830960796672', '1069492798752818176', '0', '1', '0', '1', 20);


-- 
ele_id :
1067455461395006464  | 1067913701891245056 | 1068725422692238336 | 1068731561324577792 | 1068736984777753600 | 1068737021159146496
元素


INSERT INTO amop_base_tempconf(tempconf_id, topic_id, element_id, caption, element_hint, display_property, attribute_length, order_no, required, default_value, dict_no, show_flag, regexp_rule, desc_unit, readonly, max_length, int_digit, decimal_digit, nonegative, max_value, min_value, element_tips, format_type, format_method) VALUES ('1067453334924821504', '1067453626907100160', '1067455461395006464', '产品系列', '请选择', 'multiSelect', 12, 10, '1', NULL, 'IDR_PUB_CPYWSJ', '1', NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '');
INSERT INTO amop_base_tempconf(tempconf_id, topic_id, element_id, caption, element_hint, display_property, attribute_length, order_no, required, default_value, dict_no, show_flag, regexp_rule, desc_unit, readonly, max_length, int_digit, decimal_digit, nonegative, max_value, min_value, element_tips, format_type, format_method) VALUES ('1067912830960796672', '1067453626907100160', '1067913701891245056', '募集方式', NULL, 'radio', 12, 20, '1', NULL, 'IDR_PUB_SFBZ', '1', NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '');
INSERT INTO amop_base_tempconf(tempconf_id, topic_id, element_id, caption, element_hint, display_property, attribute_length, order_no, required, default_value, dict_no, show_flag, regexp_rule, desc_unit, readonly, max_length, int_digit, decimal_digit, nonegative, max_value, min_value, element_tips, format_type, format_method) VALUES ('1068724871711687680', '1067453626907100160', '1068725422692238336', '产品运作模式', '请选择', 'select', 12, 30, '1', NULL, 'IDR_PUB_CPYWSJ', '1', NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '');
INSERT INTO amop_base_tempconf(tempconf_id, topic_id, element_id, caption, element_hint, display_property, attribute_length, order_no, required, default_value, dict_no, show_flag, regexp_rule, desc_unit, readonly, max_length, int_digit, decimal_digit, nonegative, max_value, min_value, element_tips, format_type, format_method) VALUES ('1068731127901979648', '1067453626907100160', '1068731561324577792', '产品销售模板类型', '请选择', 'select', 12, 40, '1', NULL, 'IDR_PUB_CPYWSJ', '1', NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '');
INSERT INTO amop_base_tempconf(tempconf_id, topic_id, element_id, caption, element_hint, display_property, attribute_length, order_no, required, default_value, dict_no, show_flag, regexp_rule, desc_unit, readonly, max_length, int_digit, decimal_digit, nonegative, max_value, min_value, element_tips, format_type, format_method) VALUES ('1068736782276756480', '1067453626907100160', '1068736984777753600', '投资性质', '请选择', 'multiSelect', 12, 50, '1', NULL, 'IDR_PUB_CPYWSJ', '1', NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '');
INSERT INTO amop_base_tempconf(tempconf_id, topic_id, element_id, caption, element_hint, display_property, attribute_length, order_no, required, default_value, dict_no, show_flag, regexp_rule, desc_unit, readonly, max_length, int_digit, decimal_digit, nonegative, max_value, min_value, element_tips, format_type, format_method) VALUES ('1068736833254327296', '1067453626907100160', '1068737021159146496', '产品状态', '请选择', 'multiSelect', 12, 60, '1', NULL, 'IDR_PUB_CPYWSJ', '1', NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '');


-- pool


INSERT INTO amop_base_elementpool(ELEMENT_ID, COL_CODE, COL_NAME, TABLE_NAME, COL_DESC, BELONG_SERVICE) VALUES ('1067455461395006464', 'prd_series', '产品系列', 'idr_id_prddim_adapt_data', NULL, 'IDR_INFOCS');
INSERT INTO amop_base_elementpool(ELEMENT_ID, COL_CODE, COL_NAME, TABLE_NAME, COL_DESC, BELONG_SERVICE) VALUES ('1067913701891245056', 'ipo_way', '募集方式', 'idr_id_prddim_adapt_data', NULL, 'IDR_INFOCS');
INSERT INTO amop_base_elementpool(ELEMENT_ID, COL_CODE, COL_NAME, TABLE_NAME, COL_DESC, BELONG_SERVICE) VALUES ('1068725422692238336', 'prd_operate_mode', '产品运作模式', 'idr_id_prddim_adapt_data', NULL, 'IDR_INFOCS');
INSERT INTO amop_base_elementpool(ELEMENT_ID, COL_CODE, COL_NAME, TABLE_NAME, COL_DESC, BELONG_SERVICE) VALUES ('1068731561324577792', 'prd_sale_template_no', '产品销售模板类型', 'idr_id_prddim_adapt_data', NULL, 'IDR_INFOCS');
INSERT INTO amop_base_elementpool(ELEMENT_ID, COL_CODE, COL_NAME, TABLE_NAME, COL_DESC, BELONG_SERVICE) VALUES ('1068736984777753600', 'invest_property', '投资性质', 'idr_id_prddim_adapt_data', NULL, 'IDR_INFOCS');
INSERT INTO amop_base_elementpool(ELEMENT_ID, COL_CODE, COL_NAME, TABLE_NAME, COL_DESC, BELONG_SERVICE) VALUES ('1068737021159146496', 'status', '产品状态', 'idr_id_prddim_adapt_data', NULL, 'IDR_INFOCS');



-- TOPIC 
INSERT INTO amop_base_temptopic(TOPIC_ID, TEMPLATE_ID, TOPIC_NAME, ORDER_NO, FULL_DESCRIBE) VALUES ('1067453626907100160', '1067453007592948736', '产品维度信息', 10, '产品维度信息');

INSERT INTO amop_base_temptopic(TOPIC_ID, TEMPLATE_ID, TOPIC_NAME, ORDER_NO, FULL_DESCRIBE) VALUES ('1067453626907100160', '1069492798752818176', '产品维度信息', 10, '产品维度信息');


-- 权限
SELECT AUTHCONF_ID,TEMPCONF_ID,TEMPLATE_ID,REQUIRED,SHOW_FLAG,READONLY,NEED_BGPROCESS,ORDER_NO FROM 
amop_base_formauthconf WHERE (authconf_id = 'prddimAdapt_A' AND template_id = '1067453007592948736')





-- 表单元素

SELECT * FROM amop_base_tempconf config where config.tempconf_id
 in (SELECT TEMPCONF_ID FROM amop_base_formauthconf WHERE (authconf_id = 'prddimAdapt_A' AND template_id = '1067453007592948736')
)


 -- 具体字段
SELECT * FROM amop_base_elementpool POOL WHERE POOL.element_id IN (
	SELECT element_id FROM amop_base_tempconf config where config.tempconf_id
	 in (SELECT TEMPCONF_ID FROM amop_base_formauthconf WHERE (authconf_id = 'prddimAdapt_A' AND template_id = '1067453007592948736')
	)
)







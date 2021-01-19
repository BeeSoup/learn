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


delete from tsys_role_right where TRANS_CODE = 'productPlanSet';
delete from tsys_user_right  where trans_code = 'productPlanSet';
delete from tsys_subtrans where TRANS_CODE = 'productPlanSet';
delete from tsys_trans where TRANS_CODE = 'productPlanSet';
delete from tsys_menu where MENU_CODE = 'productPlanSet';
insert into tsys_menu (MENU_CODE, KIND_CODE, TRANS_CODE, SUB_TRANS_CODE, MENU_NAME, MENU_ARG, MENU_ICON, MENU_URL, WINDOW_TYPE, WINDOW_MODEL, TIP, HOT_KEY, PARENT_CODE, ORDER_NO, OPEN_FLAG, TREE_IDX, REMARK, MENU_PLUGIN_NAME, MENU_PLUGIN_DLL, MENU_TYPE, HELP_URL, TENANT_ID, MODULE_ID, MENU_NO, MENU_LEVEL, MENU_I18N, EXT_FIELD, EXT_FIELD1, EXT_FIELD2, EXT_FIELD3, EXT_FIELD4, EXT_FIELD5, MENU_IS_LEAF, MODULE_TYPE, PARAM, APP_CODE, IS_KEEP_ALIVEA, IS_HIDDEN)
values ('productPlanSet', 'amop', 'productPlanSet', 'productPlanSet', '产品方案设置', '', '', '/hsfundIdrInfoDcs/productPlanSet', '', '', '', '', 'disclosureManager', 10, '', '#bizroot#amop#disclosureManager#productPlanSet#', ' ', '', '', 'hui', '', 'BIZ', 0, '', null, '', '', '', '', '', '', '', '', '', '', 'hsfundIdrInfoDcs', '1', '0');
insert into tsys_trans (TRANS_CODE, TRANS_NAME, KIND_CODE, MODEL_CODE, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, TRANS_ORDER)
values ('productPlanSet', '产品方案设置', 'productPlanSet', '2', '', '', '', '', '', null);


insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', 'productPlanSetAdd', '产品方案设置新增', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', 'productPlanSetEdit', '产品方案设置编辑', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', 'productPlanSetDelete', '产品方案设置删除', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', '821109001', '查询', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', '821109002', '详情', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', '821109003', '删除', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', '821109004', '编辑', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', '821109005', '新增', '', '', '', '', '', '', '', '', '', '', '', null);


insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSet', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSet', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSet', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSet', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSetAdd', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSetAdd', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSetAdd', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSetAdd', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSetEdit', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSetEdit', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSetEdit', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSetEdit', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSetDelete', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSetDelete', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSetDelete', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'productPlanSetDelete', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109001', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109001', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109001', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109001', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109002', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109002', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109002', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109002', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109003', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109003', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109003', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109003', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109004', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109004', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109004', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109004', 'admin', 'admin', 0, 0, 0, '2', '', '', '');



insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109005', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109005', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109005', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', '821109005', 'admin', 'admin', 0, 0, 0, '2', '', '', '');




insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', 'myTest1', '测试的请求', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', 'myTest2', '测试的请求', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest1', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest1', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest1', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest1', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest2', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest2', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest2', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest2', 'admin', 'admin', 0, 0, 0, '2', '', '', '');






delete from tsys_role_right where TRANS_CODE = 'managerPlanSet';
delete from tsys_user_right  where trans_code = 'managerPlanSet';
delete from tsys_subtrans where TRANS_CODE = 'managerPlanSet';
delete from tsys_trans where TRANS_CODE = 'managerPlanSet';
delete from tsys_menu where MENU_CODE = 'managerPlanSet';
insert into tsys_menu (MENU_CODE, KIND_CODE, TRANS_CODE, SUB_TRANS_CODE, MENU_NAME, MENU_ARG, MENU_ICON, MENU_URL, WINDOW_TYPE, WINDOW_MODEL, TIP, HOT_KEY, PARENT_CODE, ORDER_NO, OPEN_FLAG, TREE_IDX, REMARK, MENU_PLUGIN_NAME, MENU_PLUGIN_DLL, MENU_TYPE, HELP_URL, TENANT_ID, MODULE_ID, MENU_NO, MENU_LEVEL, MENU_I18N, EXT_FIELD, EXT_FIELD1, EXT_FIELD2, EXT_FIELD3, EXT_FIELD4, EXT_FIELD5, MENU_IS_LEAF, MODULE_TYPE, PARAM, APP_CODE, IS_KEEP_ALIVEA, IS_HIDDEN)
values ('managerPlanSet', 'amop', 'managerPlanSet', 'managerPlanSet', '管理人方案设置', '', '', '/hsfundIdrInfoDcs/managerPlanSet', '', '', '', '', 'disclosureManager', 11, '', '#bizroot#amop#disclosureManager#managerPlanSet#', ' ', '', '', 'hui', '', 'BIZ', 0, '', null, '', '', '', '', '', '', '', '', '', '', 'hsfundIdrInfoDcs', '1', '0');
insert into tsys_trans (TRANS_CODE, TRANS_NAME, KIND_CODE, MODEL_CODE, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, TRANS_ORDER)
values ('managerPlanSet', '管理人方案设置', 'managerPlanSet', '2', '', '', '', '', '', null);


insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', 'managerPlanSetAdd', '产品方案设置新增', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', 'managerPlanSetEdit', '产品方案设置编辑', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', 'managerPlanSetDelete', '产品方案设置编辑', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', '821109001', '查询', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', '821109002', '详情', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', '821109003', '删除', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', '821109004', '编辑', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('managerPlanSet', '821109005', '新增', '', '', '', '', '', '', '', '', '', '', '', null);


insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSet', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSet', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSet', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSet', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSetAdd', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSetAdd', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSetAdd', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSetAdd', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSetEdit', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSetEdit', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSetEdit', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSetEdit', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSetDelete', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSetDelete', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSetDelete', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', 'managerPlanSetDelete', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109001', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109001', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109001', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109001', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109002', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109002', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109002', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109002', 'admin', 'admin', 0, 0, 0, '2', '', '', '');


insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109003', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109003', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109003', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109003', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109004', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109004', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109004', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109004', 'admin', 'admin', 0, 0, 0, '2', '', '', '');



insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109005', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109005', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109005', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('managerPlanSet', '821109005', 'admin', 'admin', 0, 0, 0, '2', '', '', '');




insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', 'myTest1', '测试的请求', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_subtrans (TRANS_CODE, SUB_TRANS_CODE, SUB_TRANS_NAME, REL_SERV, REL_URL, CTRL_FLAG, LOGIN_FLAG, REMARK, EXT_FIELD_1, EXT_FIELD_2, EXT_FIELD_3, TENANT_ID, SUB_TRANS_ARG, MODULE_TYPE, SUBTRANS_ORDER)
values ('productPlanSet', 'myTest2', '测试的请求', '', '', '', '', '', '', '', '', '', '', '', null);

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest1', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest1', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest1', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest1', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest2', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_user_right (TRANS_CODE, SUB_TRANS_CODE, USER_ID, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest2', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest2', 'admin', 'admin', 0, 0, 0, '1', '', '', '');
insert into tsys_role_right (TRANS_CODE, SUB_TRANS_CODE, ROLE_CODE, CREATE_BY, CREATE_DATE, BEGIN_DATE, END_DATE, RIGHT_FLAG, RIGHT_ENABLE, MODULE_TYPE, ACTION_TYPE)
values ('productPlanSet', 'myTest2', 'admin', 'admin', 0, 0, 0, '2', '', '', '');

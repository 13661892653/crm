<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8" />
    <title>信隆行CRM系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <meta name="MobileOptimized" content="320">
    <link rel="icon" type="image/x-icon" href="/favicon.ico">
    <link href="/dist/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/layout.css" rel="stylesheet" type="text/css"/>
    <!-- <link href="/dist/css/default.css" rel="stylesheet" type="text/css" id="style_color" /> -->
    <link href="/dist/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="/dist/css/custom.css" rel="stylesheet" type="text/css"/>

    <link href="/dist/css/crm.css" rel="stylesheet" type="text/css"/>

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
<#assign page=300/>
<#include "top_menu.ftl"/>

<!-- 仪表盘页面中部区域层：BEGIN-->
<div class="page-container">
    <!--引入页面左边菜单tree-->
<#include "left_menu.ftl"/>
    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="#">权限管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">用户信息</a>
                    </li>
                </ul>
            </div>

        <#if msg??><label style="color: #ff0007"> ${msg}</label></#if>

            <!-- BEGIN 订单列表-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="glyphicon glyphicon-road"></i>用户列表
                    </div>
                    <div class="actions">
                        <a href="/crm/user/adduser" class="btn default yellow-stripe">
                            <i class="fa fa-plus"></i>
                            <span class="hidden-480">
								新增 </span>
                        </a>
                    </div>
                </div>
                <div class="portlet-body">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr style="background-color: #9ca7b7;">
                            <th>
                                用户类型
                            </th>
                            <th>
                                用户名
                            </th>
                            <th>
                                所在省份
                            </th>
                            <th>
                                所在分公司
                            </th>
                            <th>
                                手机号（用户登录使用）
                            </th>
                            <th>
                                登录密码
                            </th>
                            <th>
                                邮箱
                            </th>
                            <th>
                                用户状态
                            </th>
                            <th>
                                更新时间
                            </th>
                            <th>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list result.userListContents as userList>
                        <tr>
                            <td>
                                <#if userList.accountRole??>${userList.accountRole}</#if>
                            </td>
                            <td>
                                <#if userList.userName??>${userList.userName}</#if>
                            </td>
                            <td>
                                <#if userList.province??>${userList.province}</#if>
                            </td>
                            <td>
                                <#if userList.company??>${userList.company}</#if>
                            </td>
                            <td>
                                <#if userList.memberPhone??>${userList.memberPhone}</#if>
                            </td>
                            <td>
                                <#if userList.memberPwd??>${userList.memberPwd}</#if>
                            </td>
                            <td>
                                <#if userList.email??>${userList.email}</#if>
                            </td>
                            <td>
                                <#if userList.memberStatus=="1">生效
                                <#elseif userList.memberStatus=="0"><span style="color:#ff0000;font-weight: bold">失效</span>
                                </#if>
                            </td>
                            <td>
                                <#if userList.updateTime??>${userList.updateTime}</#if>
                            </td>
                            <td>
                                <a href="#" id="${userList.memberPhone?if_exists}" onclick="editUser(this)"><span class="glyphicon glyphicon-pencil" title="编辑"></span></a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- END 订单列表-->
        </div>
    </div>

    <!-- 页面中部区域层：END-->
</div>

<!-- BEGIN 框架效果 -->
<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<!-- added by yingsl on 20170523 分页-->
<script src="/dist/js/jquery.pagination.js"></script>
<script src="/dist/js/jquery-ui.min.js"></script>
<script src="/dist/js/crm.js?v=1"></script>

<script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        //Demo.init(); // init demo features
    });
</script>
</body>
</html>


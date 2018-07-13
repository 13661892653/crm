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
    <link href="/dist/css/plugins1.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/layout.css" rel="stylesheet" type="text/css"/>
    <!-- <link href="/dist/css/default.css" rel="stylesheet" type="text/css" id="style_color" /> -->
    <link href="/dist/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="/dist/css/custom.css" rel="stylesheet" type="text/css"/>

    <!-- added by yingsl on 20170523 -->
    <link href="/dist/css/enterprisebank.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/jquery-ui.min.css" rel="stylesheet" >

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
<#assign page=210/>
<#include "../top_menu.ftl"/>

<!-- 仪表盘页面中部区域层：BEGIN-->
<div class="page-container">
    <!--引入页面左边菜单tree-->
<#include "../left_menu.ftl"/>
    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>

                    <#if '${user.memberType}'=='11'>
                        <a href="#">初录</a>
                    </#if>
                    <#if '${user.memberType}'=='12'>
                        <a href="#">复录</a>
                    </#if>
                    </li>
                </ul>
            </div>

            <!-- BEGIN 数据展示区-->
            <div class="portlet">
                <div class="portlet-body">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr style="background-color: #9ca7b7;">
                            <th width="6%">
                                文件名
                            </th>
                            <th width="6%">
                                公司名
                            </th>
                            <th width="6%">
                                备注
                            </th>
                            <th width="7%">
                                下载
                            </th>
                            <th width="20%">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list list as fiFile>
                        <tr>
                            <td>
                            ${fiFile.fileName?if_exists}
                            </td>
                            <td>
                            ${fiFile.enterpriseName?if_exists}
                            </td>
                            <td>
                            ${fiFile.remark?if_exists}
                            </td>
                            <td>
                            <#--<button class="btn" href="/financeinput/tableEdit?id=${fiExcleSheet.id?if_exists}">编辑</button>-->
                                <a href="/financeinput/downloadFile?fileName=${fiFile.fileName}">下载</a>
                            </td>
                            <td>
                            <#--<button class="btn" href="/financeinput/tableEdit?id=${fiExcleSheet.id?if_exists}">编辑</button>-->
                                <a href="/financeinput/filedetail?id=${fiFile.id?c}">编辑</a>
                            </td>

                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- END 数据展示区-->
        </div>
    </div>
</div>

<!-- BEGIN 框架效果 -->
<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<!-- added by yingsl on 20170523 -->
<script src="/dist/js/jquery.pagination.js"></script>
<script src="/dist/js/jquery-ui.min.js"></script>
<script src="/dist/js/filter_entbank.js"></script>
<script src="/dist/js/data_select.js"></script>
<script src="/dist/js/crm.js?v=1"></script>

</body>
</html>

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

            <!-- BEGIN 数据展示区-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-shopping-cart"></i>报表管理
                    </div>
                    <div class="actions">
                        <a target="_blank" href="/dynamicReport/reportCreate" class="btn default yellow-stripe">
                            <i class="fa fa-plus"></i>
                            <span class="hidden-480">
								新增报表 </span>
                        </a>
                    </div>
                </div>
                <div class="portlet-body">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr style="background-color: #9ca7b7;">
                            <th width="6%">
                                报表名称
                            </th>
                            <th width="6%">
                                回调接口
                            </th>
                            <th width="7%">
                                是否需要复录（0不需要 1需要）
                            </th>
                            <th width="20%">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list list as item>
                        <tr>
                            <td>
                            ${item.reportTitle?if_exists}
                            </td>
                            <td>
                            ${item.interfaceUrl?if_exists}
                            </td>
                            <td>
                            ${item.needCheck?if_exists}
                            </td>
                            <td>
                            <#--<button class="btn" href="/financeinput/tableEdit?id=${fiExcleSheet.id?if_exists}">编辑</button>-->
                                <a target="_blank" href="/dynamicReport/reportCreate?id=${item.id?c}">查看</a>
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

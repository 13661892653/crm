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
<#assign page=11/>
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
                        <a href="#">客户关系管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="#">企业信息维护</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">企业信息初始化</a>
                    </li>
                </ul>
            </div>

            <!-- BEGIN 订单列表-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        只支持按企业工商注册号或者统一社会信用代码获取企业基础信息：
                    </div>
                </div>
                <div class="portlet-body">
                    <form id="formSch" action="/crm/enterpriseinit/schregno" method="post">
                    <table class="table table-striped table-bordered" id="table_entinit" width="200">
                        <tbody>
                        <tr>
                            <td>
                                <input id="regNo" name="regNo" type="text" class="form-control input-medium"/>
                            </td>
                            <td>
                                <input type="button" value="按工商注册号获取" class="btn blue" id="btn_regno" onclick="clickbtn(this)"/>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    </form>
                    <form id="formSch" action="/crm/enterpriseinit/schcreditno" method="post">
                        <table class="table table-striped table-bordered" id="table_entinit" width="200">
                            <tbody>
                            <tr>
                                <td>
                                    <input id="creditNo" name="creditNo" type="text" class="form-control input-medium"/>
                                </td>
                                <td>
                                    <input type="button" value="按统一信用代码获取" class="btn blue" id="btn_creditno" onclick="clickbtn(this)"/>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
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
<script src="/dist/js/demo.js" type="text/javascript"></script>
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


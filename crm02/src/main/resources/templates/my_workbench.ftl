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
    <link href="/dist/css/todo.css" rel="stylesheet" type="text/css"/>


</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
<#assign page=151/>
<#include "top_menu.ftl"/>

<!-- 仪表盘页面中部区域层：BEGIN-->
<div class="page-container">
    <!--引入页面左边菜单tree-->
<#include "left_menu.ftl"/>

    <!-------------------页面tree菜单右边展示区域，由开发者自由编写：BEGIN-->
    <div class="page-content-wrapper">
        <div class="page-content">

            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="#">我的工作台</a>
                    </li>
                </ul>
            </div>
            <div class="note note-success">
                <p>
                    <#if dayofweek??>
                        <#if '${dayofweek}'=='1'><span style="color:#ff0000;font-weight: bold">今天最好的表现是明天最低的要求。</span></#if>
                        <#if '${dayofweek}'=='2'><span style="color:#ff0000;font-weight: bold">你感觉不舒服的时候，就是成长的时候。</span></#if>
                        <#if '${dayofweek}'=='3'><span style="color:#ff0000;font-weight: bold">我们必须在改变别人之前先改变自己。</span></#if>
                        <#if '${dayofweek}'=='4'><span style="color:#ff0000;font-weight: bold">当你只需要一根针时，千万不要去磨铁棒。</span></#if>
                        <#if '${dayofweek}'=='5'><span style="color:#ff0000;font-weight: bold">当你的伙伴需要你伸出一只手时，不妨把肩膀也给他。</span></#if>
                        <#if '${dayofweek}'=='6'><span style="color:#ff0000;font-weight: bold">战略就是客户价值，文化就是言行举止。</span></#if>
                        <#if '${dayofweek}'=='7'><span style="color:#ff0000;font-weight: bold">马上做，做精彩！别把沙子当绊脚石。</span></#if>
                    </#if>
                </p>
            </div>

            <!-- BEGIN TODO SIDEBAR -->
            <div class="todo-ui">
                <div class="todo-sidebar">
                    <div class="portlet light">
                        <div class="portlet-title">
                            <div class="caption" data-toggle="collapse" data-target=".todo-project-list-content">
                                <span class="caption-subject font-green-sharp bold uppercase"><span class="icon-tag">&nbsp;</span>便条 </span>
                                <span class="caption-helper visible-sm-inline-block visible-xs-inline-block">click to view project list</span>
                            </div>
                        </div>
                        <div class="portlet-body todo-project-list-content">
                            <div class="todo-project-list">
                                <ul class="nav nav-pills nav-stacked">
                                    <#--<li class="active">
                                        <a href="#">
                                            <span class="badge badge-success badge-active"> 3 </span> 正在跟进中的订单 </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <span class="badge badge-success"> 2 </span> 当日新增任务</a>
                                    </li>-->
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END TODO SIDEBAR -->
                <!-- BEGIN TODO CONTENT -->
                <div class="todo-content">
                    <div class="portlet light">
                        <div class="portlet-body">
                            <div class="row">
                                <div class="col-md-5 col-sm-4">
                                    <div class="scroller" style="max-height: 600px;" data-always-visible="0" data-rail-visible="0" data-handle-color="#dae3e7">
                                        <#--<div class="todo-tasklist">
                                            <div class="todo-tasklist-item todo-tasklist-item-border-green">
                                                <img class="todo-userpic pull-left" src="../../assets/admin/layout/img/avatar4.jpg" width="27px" height="27px">
                                                <div class="todo-tasklist-item-title">
                                                    Slider Redesign
                                                </div>
                                                <div class="todo-tasklist-item-text">
                                                    Lorem dolor sit amet ipsum dolor sit consectetuer dolore.
                                                </div>
                                                <div class="todo-tasklist-controls pull-left">
                                                    <span class="todo-tasklist-date"><i class="fa fa-calendar"></i> 21 Sep 2014 </span>
                                                    <span class="todo-tasklist-badge badge badge-roundless">Urgent</span>
                                                </div>
                                            </div>
                                            <div class="todo-tasklist-item todo-tasklist-item-border-red">
                                                <img class="todo-userpic pull-left" src="../../assets/admin/layout/img/avatar5.jpg" width="27px" height="27px">
                                                <div class="todo-tasklist-item-title">
                                                    Homepage Alignments to adjust
                                                </div>
                                                <div class="todo-tasklist-item-text">
                                                    Lorem ipsum dolor sit amet, consectetuer dolore dolor sit amet.
                                                </div>
                                                <div class="todo-tasklist-controls pull-left">
                                                    <span class="todo-tasklist-date"><i class="fa fa-calendar"></i> 14 Sep 2014 </span>
                                                    <span class="todo-tasklist-badge badge badge-roundless">Important</span>
                                                </div>
                                            </div>
                                            <div class="todo-tasklist-item todo-tasklist-item-border-green">
                                                <img class="todo-userpic pull-left" src="../../assets/admin/layout/img/avatar9.jpg" width="27px" height="27px">
                                                <div class="todo-tasklist-item-title">
                                                    Slider Redesign
                                                </div>
                                                <div class="todo-tasklist-controls pull-left">
                                                    <span class="todo-tasklist-date"><i class="fa fa-calendar"></i> 10 Feb 2015 </span>
                                                    <span class="todo-tasklist-badge badge badge-roundless">Important</span>&nbsp;
                                                </div>
                                            </div>
                                        </div>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END TODO CONTENT -->

        </div>
        <!-------------------页面tree菜单右边展示区域，由开发者自由编写：END-->
    </div>

    <!-- 页面中部区域层：END-->
</div>

<!-- BEGIN 框架效果 -->
<script src="/dist/js/demo.js" type="text/javascript"></script>
<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<script src="/dist/js/todo.js" type="text/javascript"></script>

<script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        Demo.init(); // init demo features
    });
</script>
</body>
</html>


<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js" xmlns="http://www.w3.org/1999/html">
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
                        <a href="#">用户管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">新增用户</a>
                    </li>
                </ul>
            </div>
            <!-- BEGIN 新增订单-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-check"></i>新增用户
                    </div>
                </div>
                <div class="portlet-body form">
                    <form id="addUser" action="/crm/user/addsubmit" method="post" class="form-horizontal form-row-sepe">
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-2">手机号（登录手机号）：<span class="control-label  required">* </span></label>
                                <input id="memberPhone" name="memberPhone" type="text" class="form-control input-small" value="" />
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">初始密码：<span class="control-label  required">* </span></label>
                                <input name="memberPwd" type="text" class="form-control input-small" value="" />
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">真实中文名：<span class="control-label  required">* </span></label>
                                <input name="userName" type="text" class="form-control input-small" value="" />
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">所在省份：<span class="control-label  required">* </span></label>
                                <div class="col-md-2">
                                    <select id="province" name="province" class="form-control input-small">
                                        <option value="北京">北京</option>
                                        <option value="上海">上海</option>
                                        <option value="浙江">浙江</option>
                                        <option value="江苏">江苏</option>
                                        <option value="广东">广东</option>
                                        <option value="山东">山东</option>
                                        <option value="湖北">湖北</option>
                                        <option value="湖南">湖南</option>
                                        <option value="四川">四川</option>
                                        <option value="安徽">安徽</option>
                                        <option value="江西">江西</option>
                                        <option value="美国">美国</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">所在分公司：<span class="control-label  required">* </span></label>
                                <div class="col-md-2">
                                    <select id="company" name="company" class="form-control input-small">
                                        <option value="北京">北京</option>
                                        <option value="上海">上海</option>
                                        <option value="广州">广州</option>
                                        <option value="杭州">杭州</option>
                                        <option value="南京">南京</option>
                                        <option value="武汉">武汉</option>
                                        <option value="成都">成都</option>
                                        <option value="合肥">合肥</option>
                                        <option value="南昌">南昌</option>
                                        <option value="无锡">无锡</option>
                                        <option value="青岛">青岛</option>
                                        <option value="温州">温州</option>
                                        <option value="长沙">长沙</option>
                                        <option value="嘉兴">嘉兴</option>
                                        <option value="台州">台州</option>
                                        <option value="舟山">舟山</option>
                                        <option value="绍兴">绍兴</option>
                                        <option value="常州">常州</option>
                                        <option value="张家港">张家港</option>
                                        <option value="湖州">湖州</option>
                                        <option value="宁波">宁波</option>
                                        <option value="北美">北美</option>
                                        <option value="总部">总部</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">邮箱：</label>
                                <input name="email" type="text" class="form-control input-medium" value="" />
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">用户状态：<span class="control-label  required">* </span></label>
                                <div class="col-md-2">
                                    <select name="memberStatus" readonly="readonly" class="form-control input-small">
                                        <option value="1">有效</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">用户类型：<span class="control-label  required">* </span></label>
                                <div class="col-md-2">
                                    <select name="memberType" class="form-control input-small">
                                        <option value="99">分公司运营经理</option>
                                        <option value="98">分公司企服顾问</option>
                                        <option value="90">分公司经理</option>
                                        <option value="10">一般用户（总部）</option>
                                        <option value="2">高级用户（总部）</option>
                                        <option value="1">管理员</option>
                                        <option value="11">初录</option>
                                        <option value="12">复录</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-md-offset-3 col-md-4">
                                        <input type="button" value="新增" class="btn purple" id="btn_addusr" onclick="clickbtn(this)"/>
                                        <input type="button" value="取消" class="btn default" id="btn_celusr" onclick="clickbtn(this)"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- END FORM-->
                </div>
            </div>
            <!-- END 新增订单-->
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
<script src="/dist/js/crm.js?v=1"></script>
<script src="/dist/js/laydate/laydate.js"></script>

<script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        //Demo.init(); // init demo features
    });
    laydate({
        elem: '#contractDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
    laydate({
        elem: '#incomeExpDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
</script>
</body>
</html>

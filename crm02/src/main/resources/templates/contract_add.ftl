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
<#assign page=52/>
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
                        <a href="#">合同管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">新增合同</a>
                    </li>
                </ul>
            </div>
            <!-- BEGIN 新增订单-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-check"></i>新增合同
                    </div>
                </div>
                <div class="portlet-body form">

                <#if msg??><label style="color: #ff0007"> ${msg}</label></#if>

                    <!-- 隐式请求参数-->
                    <form id="corpChk" action="/crm/contractmanage/entchk" method="post">
                        <input name="corpName" id="corpName" type="hidden" <#if (result.reqParams.corpName)??> value = "${result.reqParams.corpName}"</#if> />
                    </form>

                    <form id="addContract" action="/crm/contractmanage/submit" method="post" class="form-horizontal form-row-sepe">
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-2">合同类型：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="contractType" name="contractType" class="bs-select form-control" data-placeholder="请选择" onchange="showdivctt()">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="CONT01">订单合同</option>
                                        <#--<option value="CONT02">合作伙伴合同</option>-->
                                        <option value="CONT03">政府合同</option>
                                        <#--<option value="CONT04">公司采购合同</option>-->
                                    </select>
                                </div>
                            </div>
                            <div class="form-group" id="ordnodiv" style="display: none">
                                <label class="control-label col-md-2">订单号：<span class="required">* </span></label>
                                <input id="orderNo" name="orderNo" type="text" class="form-control input-medium" placeholder="请正确输入订单号，提交时会验证" value=""/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合同标题：<span class="required">* </span></label>
                                <input id="contractTitle" name="contractTitle" type="text" class="form-control input-large" value=""/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合同主体公司：<span class="required">* </span></label>
                                <input id="contractEnterprise" name="contractEnterprise" type="text" class="form-control input-large" value=""/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合同签订日：<span class="required">* </span></label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="contractDate" name="contractDate" type="text" class="laydate-icon" style="width:200px; margin-right:10px;"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合同金额：<span class="required">* </span></label>
                                <input id="contractAmt" name="contractAmt" type="text" class="control-label col-md-1" value=""/><label class="control-label"><span style="color:#ff0000;font-weight: bold">（万人民币）</span></label>
                            </div>
                            <!--
                            <div class="form-group">
                                <label class="control-label col-md-2">预计到账日期：<span class="required">* </span></label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="incomeExpDate" name="incomeExpDate" type="text" class="laydate-icon" style="width:200px; margin-right:10px;"/>
                                </div>
                            </div>
                            -->
                            <div class="form-group">
                                <label class="control-label col-md-2">当前到账收入：</label>
                                <input id="income" name="income" type="text" class="control-label col-md-1" value=""/><label class="control-label"><span style="color:#ff0000;font-weight: bold">（万人民币）</span></label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">利润：</label>
                                <input id="profit" name="profit" type="text" class="control-label col-md-1" value=""/><label class="control-label"><span style="color:#ff0000;font-weight: bold">（万人民币）</span></label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">业务模块：</label>
                                <div class="col-md-2">
                                    <select id="bizLv1Id" name="bizLv1Id" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="G">G</option>
                                        <option value="T">T</option>
                                        <option value="F">F</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">备注：</label>
                                <textarea id="remark" name="remark" class="control-label col-md-4" rows="5" value=""></textarea>
                            </div>
                            <#--<div class="form-group">
                                <label class="control-label col-md-2">上传合同附件：</label>
                                <input type="button" onclick="openUpload()" value="上传合同附件"/>&nbsp;&nbsp;&nbsp;<span style="color: #ff0000">只能上传rar/zip格式压缩包</span>
                            </div>-->
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-md-offset-3 col-md-4">
                                        <input type="button" value="提交" class="btn purple" id="btn_addctt" onclick="clickbtn(this)"/>
                                        <input type="button" value="取消" class="btn default" id="btn_celctt" onclick="clickbtn(this)"/>
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

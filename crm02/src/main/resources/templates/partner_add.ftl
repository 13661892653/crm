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
<#assign page=62/>
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
                        <a href="#">合作伙伴管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">新增</a>
                    </li>
                </ul>
            </div>
            <!-- BEGIN 新增订单-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-check"></i>新增
                    </div>
                </div>
                <div class="portlet-body form">

                <#if msg??><label style="color: #ff0007"> ${msg}</label></#if>

                    <!-- 隐式请求参数-->
                    <form id="corpChk" action="/crm/partnermanage/entchk" method="post">
                        <input name="corpName" id="corpName" type="hidden" <#if (result.reqParams.corpName)??> value = "${result.reqParams.corpName}"</#if> />
                    </form>

                    <form id="partnerForm" action="/crm/partnermanage/addsubmit" method="post" class="form-horizontal form-row-sepe">
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-2">合作企业名称：<span class="required">* </span></label>
                                <input id="partnerName" name="partnerName" type="text" class="control-label col-md-2" placeholder="请输入企业全名" <#if (result.reqParams.corpName)??> value = "${result.reqParams.corpName}" <#else> value = "" </#if>/>
                                <label class="control-label col-md-1">&nbsp;</label>
                                <div class="search">
                                    <input type="button" value="校验企业" class="btn blue"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">统一社会信用代码：</label>
                                <input id="creditNo" name="creditNo" readonly="readonly" placeholder="此文本框不可输入"  type="text" class="control-label col-md-2" <#if (result.entSglContents.creditNo)??> value = "${result.entSglContents.creditNo?replace("xxxxxxyyyyyyzzzzzz","")}" <#else> value = "" </#if> />
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">工商注册号：</label>
                                <input id="regNo" name="regNo" readonly="readonly" type="text" placeholder="此文本框不可输入"  class="control-label col-md-2" <#if (result.entSglContents.regNo)??> value = "${result.entSglContents.regNo?replace("xxxxxxyyyyyyzzzzzz","")}" <#else> value = "" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">企业注册地址：</label>
                                <input id="entAddress" name="entAddress" readonly="readonly" placeholder="此文本框不可输入"  type="text" class="control-label col-md-2" <#if (result.entSglContents.entAddress)??> value = "${result.entSglContents.entAddress}" <#else> value = "" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">办公地址：<span class="required">* </span></label>
                                <input id="officeAddress" name="officeAddress" type="text" class="form-control input-large" value=""/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">归属：<span class="control-label  required">* </span></label>
                                <div class="col-md-2">
                                    <select id="company" name="company" class="form-control input-small" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
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
                                <label class="control-label col-md-2">合作伙伴等级：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="partnerLvId" name="partnerLvId" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="L1">一级合作伙伴</option>
                                        <option value="L2">二级合作伙伴</option>
                                        <option value="L3">三级合作伙伴</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合作伙伴类型：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="partnerType" name="partnerType" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="1">平台服务商</option>
                                        <option value="2">渠道商</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">服务区域：<span class="required">* </span></label>
                                <textarea id="srvArea" name="srvArea" class="control-label col-md-4" rows="3" value="" placeholder="说明：填写“全国”或者“省份名”或者“城市名”，多个用逗号隔开填写。"></textarea>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合同编号：<span class="required">* </span></label>
                                <input id="contractNo" name="contractNo" type="text" class="form-control input-medium" value=""/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">品类：<span class="required">* </span></label>
                                <input id="category" name="category" type="text" class="form-control input-large" placeholder="创业辅导、法律服务、工商财税、政府扶持等" value=""/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">联系人：<span class="required">* </span></label>
                                <input id="contactPerson" name="contactPerson" type="text" class="form-control input-medium" value=""/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">联系电话：<span class="required">* </span></label>
                                <input id="contactPhone" name="contactPhone" type="text" class="form-control input-medium" value=""/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">邮箱：<span class="required">* </span></label>
                                <input id="email" name="email" type="text" class="form-control input-medium" value=""/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">银行账户：<span class="required">* </span></label>
                                <input id="bankAccount" name="bankAccount" type="text" class="form-control input-large" value=""/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">业务范围：<span class="required">* </span></label>
                                <textarea id="bizScope" name="bizScope" class="control-label col-md-4" rows="5" value=""></textarea>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">服务费：<span class="required">* </span></label>
                                <textarea id="feePoint" name="feePoint" class="control-label col-md-4" rows="3" value=""></textarea>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">入网时间：<span class="required">* </span></label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="joinTime" name="joinTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合同到期日：<span class="required">* </span></label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="rescindTime" name="rescindTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">备注：</label>
                                <textarea id="remark" name="remark" class="control-label col-md-4" rows="5" value=""></textarea>
                            </div>
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-md-offset-3 col-md-4">
                                        <input type="button" value="提交" class="btn purple" id="btn_addptr" onclick="clickbtn(this)"/>
                                        <input type="button" value="取消" class="btn default" id="btn_celptr" onclick="clickbtn(this)"/>
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
        elem: '#joinTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
    laydate({
        elem: '#rescindTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
</script>
</body>
</html>


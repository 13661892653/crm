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
<#assign page=53/>
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
                        <a href="#">修改合同</a>
                    </li>
                </ul>
            </div>
            <!-- BEGIN 新增订单-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        说明：<span style="color:#ff0000">红色为可编辑内容</span>
                    </div>
                </div>
                <div class="portlet-body form">
                    <form id="updateContract" action="/crm/contractmanage/update" method="post" class="form-horizontal form-row-sepe">
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-2">归属：</label>
                                <input name="company" readonly="readonly" type="text" class="form-control input-small" <#if (result.company)??> value="${result.company}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合同类型：</label>
                                <div class="col-md-2">
                                    <select name="contractType" disabled="disabled"  class="form-control input-medium select2me">
                                    <#if (result.contractType)??>
                                        <option <#if (result.contractType) == "CONT01"> selected="selected" </#if>>订单合同</option>
                                        <option <#if (result.contractType) == "CONT02"> selected="selected" </#if>>合作伙伴合同</option>
                                        <option <#if (result.contractType) == "CONT03"> selected="selected" </#if>>政府合同</option>
                                        <option <#if (result.contractType) == "CONT04"> selected="selected" </#if>>公司采购合同</option>
                                    </#if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合同编号：</label>
                                <input name="contractNo" readonly="readonly" type="text" class="form-control input-small" <#if (result.contractNo)??> value="${result.contractNo}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合同标题：</label>
                                <input name="contractTitle" readonly="readonly" type="text" class="form-control input-large" <#if (result.contractTitle)??> value="${result.contractTitle}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合同主体公司：</label>
                                <input name="contractEnterprise" readonly="readonly" type="text" class="form-control input-large" <#if (result.contractEnterprise)??> value="${result.contractEnterprise}"</#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合同签订日：</label>
                                <div class="col-md-4">
                                    <input disabled="disabled" id="contractDate" name="contractDate" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" <#if (result.contractDate)??> value="${result.contractDate}" </#if>/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">合同金额：</label>
                                <input id="contractAmt" name="contractAmt" type="text" class="control-label col-md-2" <#if (result.contractAmt)??> value="${result.contractAmt}" </#if>/><label class="control-label"><span style="color:#ff0000;font-weight: bold">（万人民币）</span></label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">到账收入：</label>
                                <input id="income" name="income" type="text" class="control-label col-md-2" <#if (result.income)??> value="${result.income}" </#if>/><label class="control-label"><span style="color:#ff0000;font-weight: bold">（万人民币）</span></label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">利润：</label>
                                <input id="profit" name="profit" type="text" class="control-label col-md-2" <#if (result.profit)??> value="${result.profit}" </#if>/><label class="control-label"><span style="color:#ff0000;font-weight: bold">（万人民币）</span></label>
                            </div>
                            <!--
                            <div class="form-group">
                                <label class="control-label col-md-2"  style="color: #ff0000">预计到账日期：</label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="incomeExpDate" name="incomeExpDate" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" <#if (result.incomeExpDate)??> value="${result.incomeExpDate}" </#if>/>
                                </div>
                            </div>
                            -->
                            <div class="form-group">
                                <label class="control-label col-md-2">业务模块：</label>
                                <div class="col-md-2">
                                <select name="bizLv1Id" disabled="disabled"  class="form-control input-medium select2me">
                                <#if (result.bizLv1Id)??>
                                    <option <#if (result.bizLv1Id) == "G"> selected="selected" </#if>>G</option>
                                    <option <#if (result.bizLv1Id) == "T"> selected="selected" </#if>>T</option>
                                    <option <#if (result.bizLv1Id) == "F"> selected="selected" </#if>>F</option>
                                </#if>
                                </select>
                                </div>
                            </div>
                        <#if (result.contractType) == "CONT01">   <!--如果是订单合同才显示下面的订单信息-->
                            <div class="form-group">
                                <label class="control-label col-md-2">订单号：</label>
                                <input name="orderNo" readonly="readonly" type="text" class="control-label col-md-2" <#if (result.orderNo)??> value="${result.orderNo}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">产品名称：</label>
                                <input name="orderProdName" readonly="readonly" type="text" class="control-label col-md-2" <#if (result.orderProdName)??> value="${result.orderProdName}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合作伙伴：</label>
                                <input name="partnerName" readonly="readonly" type="text" class="control-label col-md-2" <#if (result.partnerName)??> value="${result.partnerName}" </#if>/>
                            </div>
                        </#if>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">备注：</label>
                                <textarea id="remark" name="remark" class="control-label col-md-4" rows="5" <#if (result.remark)??> value="${result.remark}" </#if>><#if (result.remark)??>${result.remark}</#if></textarea>
                            </div>
                            <#--<div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">上传合同附件：</label>
                                <input type="button" onclick="openUpload()" value="上传合同附件"/>&nbsp;&nbsp;&nbsp;<span style="color: #ff0000">只能上传rar/zip格式压缩包</span>
                            </div>-->
                        </div>
                        <div class="form-actions">
                            <div class="row">
                                <div class="col-md-offset-3 col-md-4">
                                    <input type="button" value="提交编辑" class="btn purple" id="btn_uptctt" onclick="clickbtn(this)"/>
                                    <input type="button" value="取消编辑" class="btn default" id="btn_celctt" onclick="clickbtn(this)"/>
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
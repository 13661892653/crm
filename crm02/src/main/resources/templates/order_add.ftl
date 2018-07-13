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
<#assign page=42/>
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
                        <a href="#">订单管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">新增订单</a>
                    </li>
                </ul>
            </div>
            <!-- BEGIN 新增订单-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-check"></i>新增订单
                    </div>
                </div>
                <div class="portlet-body form">

                <#if msg??><label style="color: #ff0007"> ${msg}</label></#if>

                    <!-- 隐式请求参数-->
                    <form id="corpChk" action="/crm/ordermanage/entchk" method="post">
                        <input name="corpName" id="corpName" type="hidden" <#if (result.reqParams.corpName)??> value = "${result.reqParams.corpName}"</#if> />
                    </form>

                    <form id="addOrder" action="/crm/ordermanage/orderview/add" method="post" class="form-horizontal form-row-sepe">
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-2">订单类型：<span class="required">* </span></label>
                                <label class="control-label col-md-2">
                                    <input id="orderType" type="radio" name="orderType" onclick="radioCheckOrder(this);" value="corpOrder" checked/>
                                    企业订单 </label>
                                <label class="control-label col-md-2">
                                    <input id="orderType" type="radio" name="orderType" onclick="radioCheckOrder(this);" value="unCorpOrder"/>
                                    非企业订单 </label>
                            </div>
                            <div id="corpOrder1" class="form-group">
                                <label class="control-label col-md-2">订单企业名称：<span class="required">* </span></label>
                                <input id="enterpriseName" name="enterpriseName" type="text" class="control-label col-md-2" placeholder="请输入企业全名" <#if (result.reqParams.corpName)??> value = "${result.reqParams.corpName}" <#else> value = "" </#if>/>
                                <label class="control-label col-md-1">&nbsp;</label>
                                <div class="search">
                                <input type="button" value="校验企业" class="btn blue"/>
                                </div>
                            </div>
                            <div id="corpOrder2" class="form-group">
                                <label class="control-label col-md-2">统一社会信用代码：</label>
                                <input id="creditNo" name="creditNo" readonly="readonly" type="text" placeholder="此文本框不可输入"  class="control-label col-md-2" <#if (result.entSglContents.creditNo)??> value = "${result.entSglContents.creditNo?replace("xxxxxxyyyyyyzzzzzz","")}" <#else> value = "" </#if> />
                            </div>
                            <div id="corpOrder3" class="form-group">
                                <label class="control-label col-md-2">工商注册号：</label>
                                <input id="regNo" name="regNo" readonly="readonly" type="text" placeholder="此文本框不可输入"  class="control-label col-md-2" <#if (result.entSglContents.regNo)??> value = "${result.entSglContents.regNo?replace("xxxxxxyyyyyyzzzzzz","")}" <#else> value = "" </#if>/>
                            </div>
                            <div id="unCorpOrder" style="display:none;" class="form-group">
                                <label class="control-label col-md-2">订单客户名：<span class="required">* </span></label>
                                <input id="custName" name="custName" type="text" class="control-label col-md-2" placeholder="请输入订单客户名"/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">下单时间：<span class="required">* </span></label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="orderDate" name="orderDate" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" value=""/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">采购商品：<span class="required">* </span></label>
                                <div class="col-md-2">
                                <select id="orderProdId" name="orderProdId" class="form-control input-medium select2me" data-placeholder="请选择">
                                    <option value="" disabled selected hidden>Please Choose</option>
                                    <#list productList as product>
                                        <option value="${product.productId?if_exists}">${product.bizLv2Name?if_exists}-${product.bizLv3Name?if_exists}-${product.productName?if_exists}</option>
                                    </#list>
                                </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">采购单价：<span class="required">* </span></label>
                                <input id="orderPrice" name="orderPrice" type="text" class="control-label col-md-1" value=""/><label class="control-label"><span style="color:#ff0000;font-weight: bold">（元）</span></label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">采购数量：<span class="required">* </span></label>
                                <input id="orderNum" name="orderNum" type="text" class="control-label col-md-1" value=""/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">支付方式：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="payMode" name="payMode" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option>全款</option>
                                        <option>订金</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">支付状态：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="payStatus" name="payStatus" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option>未支付</option>
                                        <option>已付部分定金</option>
                                        <option>已付全款</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">订单状态：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="orderStatus" name="orderStatus" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option>未开始</option>
                                        <option>进行中</option>
                                        <option>已结束</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">是否自营订单：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="isSelfBiz" name="isSelfBiz" class="bs-select form-control" data-placeholder="请选择" onchange="showdivord()">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="Y" >是</option>
                                        <option value="N" >否</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group" id="srvdiv1" style="display: none">
                                <label class="control-label col-md-2">平台服务商：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="partnerId" name="partnerId" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>若非自营订单请选服务商</option>
                                        <#list srvCoList as srvCo>
                                            <option value="${srvCo.partnerId?if_exists}">${srvCo.partnerName?if_exists}</option>
                                        </#list>
                                    </select>
                                </div>
                                <label class="control-label col-md-2"><a href="/crm/partnermanage/add">新增服务商？</a></label>
                            </div>
                            <div class="form-group" id="srvdiv2" style="display: none">
                                <label class="control-label col-md-2">服务商对接时间：</label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="dockingTime" name="dockingTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">完成进度：</label>
                                <div class="col-md-4">
                                    <input name="progress" type="text" class="control-label col-md-4" placeholder="0%-100%" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">完成时间：</label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="closeTime" name="closeTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">备注：</label>
                                <textarea id="remark" name="remark" class="control-label col-md-4" rows="5" value=""></textarea>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">跟单人：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="merchandiser" name="merchandiser" class="bs-select form-control">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <#list companyUserList as userList>
                                            <option>${userList.userName?if_exists}</option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-md-offset-3 col-md-4">
                                        <input type="button" value="提交订单" class="btn purple" id="btn_addord" onclick="clickbtn(this)"/>
                                        <input type="button" value="取消订单" class="btn default" id="btn_celord" onclick="clickbtn(this)"/>
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

    var start = {
        elem: '#dockingTime',
        format: 'YYYY-MM-DD hh:mm:ss',
        //min: laydate.now(), //设定最小日期为当前日期
        max: '2099-06-16 23:59:59', //最大日期
        istime: true,
        istoday: false,
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#closeTime',
        format: 'YYYY-MM-DD hh:mm:ss',
        //min: laydate.now(),
        max: '2099-06-16 23:59:59',
        istime: true,
        istoday: false,
        choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };

    var orderDate = {
        elem: '#orderDate',
        format: 'YYYY-MM-DD hh:mm:ss',
        //min: laydate.now(), //设定最小日期为当前日期
        max: '2099-06-16 23:59:59', //最大日期
        istime: true,
        istoday: false,
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    laydate(orderDate);

    if($("#dockingTime")[0]){
        laydate(start);
    }
    if($("#closeTime")[0]){
        laydate(end);
    }
</script>
</body>
</html>

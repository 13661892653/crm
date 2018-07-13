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
<#assign page=43/>
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
                        <a href="#">修改订单</a>
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
                    <form id="updateOrder" action="/crm/ordermanage/orderview/update" method="post" class="form-horizontal form-row-sepe">
                        <input name="regNo" id="regNo" type="hidden" <#if (result.regNo)??> value = "${result.regNo}"</#if> />
                        <input name="creditNo" id="creditNo" type="hidden" <#if (result.creditNo)??> value = "${result.creditNo}"</#if> />
                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (result.regCreditNo)??> value = "${result.regCreditNo}"</#if> />
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-2">订单类型：</label>
                            <#if (result.orderType)??>
                                <label class="control-label col-md-1">
                                    <input disabled="disabled" type="radio" name="orderType" value="corpOrder" <#if (result.orderType)=="corpOrder"> checked </#if>/>
                                    企业订单 </label>
                                <label class="control-label col-md-1">
                                    <input disabled="disabled" type="radio" name="orderType" value="unCorpOrder" <#if (result.orderType)=="unCorpOrder"> checked </#if>/>
                                    非企业订单 </label>
                            </#if>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">订单号：</label>
                                <input name="orderNo" readonly="readonly" type="text" class="control-label col-md-2" <#if (result.orderNo)??> value="${result.orderNo}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">下单时间：</label>
                                <div class="col-md-4">
                                    <input id="orderDate" name="orderDate" disabled="disabled" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" <#if (result.orderDate)??> value="${result.orderDate}" </#if>/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">下单人：</label>
                                <input name="orderMemeberName" readonly="readonly" type="text" class="control-label col-md-2" <#if (result.orderMemeberName)??> value="${result.orderMemeberName}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">订单客户：</label>
                                <input name="enterpriseName" readonly="readonly" type="text" class="control-label col-md-2" <#if (result.enterpriseName)??> value="${result.enterpriseName}"</#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">采购订单商品：</label>
                                <input name="orderProdName" readonly="readonly" type="text" class="control-label col-md-2" <#if (result.orderProdName)??> value="${result.bizLv2Name?default('-')}-${result.bizLv3Name?default('-')}-${result.orderProdName}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">采购数量：</label>
                                <input name="orderNum" readonly="readonly" type="text" class="control-label col-md-2" <#if (result.orderNum)??> value="${result.orderNum}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">订单单价（元）：</label>
                                <input name="orderPrice" readonly="readonly" type="text" class="control-label col-md-2" <#if (result.orderPrice)??> value="${result.orderPrice?string('#.##')}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">订单总金额（元）：</label>
                                <input name="orderAmt" readonly="readonly" type="text" class="control-label col-md-2" <#if (result.orderAmt)??> value="${result.orderAmt?string('#.##')}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">支付方式：</label>
                                <div class="col-md-2">
                                <select name="payMode" class="form-control input-medium select2me">
                                <#if (result.payMode)??>
                                    <option <#if (result.payMode) == "全款"> selected="selected" </#if>>全款</option>
                                    <option <#if (result.payMode) == "订金"> selected="selected" </#if>>订金</option>
                                </#if>
                                </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">支付状态：</label>
                                <div class="col-md-2">
                                <select name="payStatus" class="form-control input-medium select2me">
                                <#if (result.payStatus)??>
                                    <option <#if (result.payStatus) == "未支付"> selected="selected" </#if>>未支付</option>
                                    <option <#if (result.payStatus) == "已付部分定金"> selected="selected" </#if>>已付部分定金</option>
                                    <option <#if (result.payStatus) == "已付全款"> selected="selected" </#if>>已付全款</option>
                                </#if>
                                </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">订单状态：</label>
                                <div class="col-md-2">
                                    <select name="orderStatus" class="form-control input-medium select2me">
                                    <#if (result.orderStatus)??>
                                        <option <#if (result.orderStatus) == "未开始"> selected="selected" </#if>>未开始</option>
                                        <option <#if (result.orderStatus) == "进行中"> selected="selected" </#if>>进行中</option>
                                        <option <#if (result.orderStatus) == "已结束"> selected="selected" </#if>>已结束</option>
                                    </#if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">是否自营订单：</label>
                                <input name="isSelfBiz" readonly="readonly" type="text" class="control-label col-md-2" <#if (result.isSelfBiz)??&&(result.isSelfBiz=="Y")> value="是" <#else> value="否" </#if>/>
                            </div>
                            <#if (result.isSelfBiz)??&&(result.isSelfBiz=="N")>
                                <div class="form-group">
                                    <label class="control-label col-md-2">平台服务商：</label>
                                    <input name="partnerName" readonly="readonly" type="text" class="control-label col-md-2" <#if (result.partnerName)??> value="${result.partnerName}" </#if>/>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-2"  style="color: #ff0000">服务商对接时间：</label>
                                    <div class="col-md-4">
                                        <input readonly="readonly" id="dockingTime" name="dockingTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" <#if (result.dockingTime)??> value="${result.dockingTime}" </#if>/>
                                    </div>
                                </div>
                            </#if>
                            <div class="form-group">
                                <label class="control-label col-md-2"  style="color: #ff0000">完成进度：</label>
                                <div class="col-md-4">
                                    <input name="progress" type="text" class="control-label col-md-4" placeholder="0%-100%" <#if (result.progress)??> value="${result.progress}" </#if>/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">完成时间：</label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="closeTime" name="closeTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" <#if (result.closeTime)??> value="${result.closeTime}" </#if>/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">备注：</label>
                                <textarea name="remark" class="control-label col-md-4" rows="5" <#if (result.remark)??> value="${result.remark}" </#if>><#if (result.remark)??>${result.remark}</#if></textarea>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">跟单人：</label>
                                <div class="col-md-2">
                                    <select name="merchandiser" class="bs-select form-control">
                                    <#if result.merchandiser??>
                                        <#list companyUserList as userList>
                                            <option <#if (result.merchandiser) == (userList.userName)> selected="selected" </#if>>${userList.userName}</option>
                                        </#list>
                                        <#else>
                                            <option value="" disabled selected hidden>Please Choose</option>
                                            <#list companyUserList as userList>
                                                <option>${userList.userName?if_exists}</option>
                                            </#list>
                                        </#if>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-actions">
                            <div class="row">
                                <div class="col-md-offset-3 col-md-4">
                                    <input type="button" value="提交编辑" class="btn purple" id="btn_uptord" onclick="clickbtn(this)"/>
                                    <input type="button" value="取消编辑" class="btn default" id="btn_celord" onclick="clickbtn(this)"/>
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
    if($("#dockingTime")[0]){
        laydate(start);
    }
    if($("#closeTime")[0]){
        laydate(end);
    }

</script>
</body>
</html>

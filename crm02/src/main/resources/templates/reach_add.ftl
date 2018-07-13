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
<#assign page=22/>
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
                        <a href="#">营销管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">新增触达</a>
                    </li>
                </ul>
            </div>
            <!-- BEGIN 新增订单-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-check"></i>新增触达
                    </div>
                </div>
                <div class="portlet-body form">

                <#if msg??><label style="color: #ff0007"> ${msg}</label></#if>

                    <!-- 隐式请求参数-->
                    <form id="corpChk" action="/crm/marketing/reachcsr/entchk" method="post">
                        <input name="corpName" id="corpName" type="hidden" <#if (result.reqParams.corpName)??> value = "${result.reqParams.corpName}"</#if> />
                    </form>

                    <form id="addReach" action="/crm/marketing/reachcsr/submit" method="post" class="form-horizontal form-row-sepe">
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-2">客户类型：<span class="required">* </span></label>
                                <label class="control-label col-md-1">
                                    <input id="custType" type="radio" name="custType" onclick="radioCheckRch(this);" value="corpCust" checked/>
                                    企业 </label>
                                <label class="control-label col-md-1">
                                    <input id="custType" type="radio" name="custType" onclick="radioCheckRch(this);" value="unCorpCust"/>
                                    非企业 </label>
                            <#if user??>
                                <#if '${user.memberType}'=='1'||'${user.memberType}'=='2'||'${user.memberType}'=='90'>  <!--如果是一般用户不显示下面菜单-->
                                    <label class="control-label col-md-1">
                                        <input id="custType" type="radio" name="custType" onclick="radioCheckRch(this);" value="govCust"/>
                                        政府 </label>
                                </#if>
                            </#if>
                            </div>
                            <div id="div_enterpriseName" class="form-group">
                                <label class="control-label col-md-2">企业名称：<span class="required">* </span></label>
                                <input id="enterpriseName" name="enterpriseName" type="text" class="control-label col-md-2" placeholder="请输入企业全名" <#if (result.reqParams.corpName)??> value = "${result.reqParams.corpName}" <#else> value = "" </#if>/>
                                <label class="control-label col-md-1">&nbsp;</label>
                                <div class="search">
                                    <input type="button" value="校验企业" class="btn blue"/>
                                </div>
                            </div>
                            <div id="div_creditNo" class="form-group">
                                <label class="control-label col-md-2">统一社会信用代码：</label>
                                <input id="creditNo" name="creditNo" readonly="readonly" placeholder="此文本框不可输入"  type="text" class="control-label col-md-2" <#if (result.entSglContents.creditNo)??> value = "${result.entSglContents.creditNo?replace("xxxxxxyyyyyyzzzzzz","")}" <#else> value = "" </#if> />
                            </div>
                            <div id="div_regNo" class="form-group">
                                <label class="control-label col-md-2">工商注册号：</label>
                                <input id="regNo" name="regNo" readonly="readonly" type="text" placeholder="此文本框不可输入"  class="control-label col-md-2" <#if (result.entSglContents.regNo)??> value = "${result.entSglContents.regNo?replace("xxxxxxyyyyyyzzzzzz","")}" <#else> value = "" </#if>/>
                            </div>
                            <div id="div_custName" style="display:none;" class="form-group">
                                <label class="control-label col-md-2">客户名：<span class="required">* </span></label>
                                <input id="custName" name="custName" type="text" class="control-label col-md-2" placeholder="请输入触达客户名"/>
                            </div>
                            <div id="div_govName" style="display:none;" class="form-group">
                                <label class="control-label col-md-2">拜访部委名称：<span class="required">* </span></label>
                                <input id="govName" name="govName" type="text" class="control-label col-md-2" placeholder="请输入拜访部委名称"/>
                            </div>
                            <div id="div_govLine" style="display:none;" class="form-group">
                                <label class="control-label col-md-2">政府条线：<span class="required">* </span></label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" onclick="radioCheckRchOther(this);" value="人民政府"/>人民政府</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" onclick="radioCheckRchOther(this);" value="科技局"/>科技局</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" onclick="radioCheckRchOther(this);" value="发改委"/>发改委</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" onclick="radioCheckRchOther(this);" value="经信委"/>经信委</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" onclick="radioCheckRchOther(this);" value="金融办"/>金融办</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" onclick="radioCheckRchOther(this);" value="组织部"/>组织部</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" onclick="radioCheckRchOther(this);" value="其他"/>其他</label>
                                <label id="govLineLab" style="display:none;"><input id="govLineIpt" name="govLine" type="text" class="form-control input-medium" value="" placeholder="填写其他政府条线"/></label>
                            </div>
                            <div id="div_govLevel" style="display:none;" class="form-group">
                                <label class="control-label col-md-2">级别：<span class="required">* </span></label>
                                <label class="control-label col-md-1"><input id="govLevel" type="radio" name="govLevel" value="国家级"/>国家级</label>
                                <label class="control-label col-md-1"><input id="govLevel" type="radio" name="govLevel" value="省级"/>省级</label>
                                <label class="control-label col-md-1"><input id="govLevel" type="radio" name="govLevel" value="市级"/>市级</label>
                                <label class="control-label col-md-1"><input id="govLevel" type="radio" name="govLevel" value="区县级"/>区县级</label>
                            </div>
                            <div id="div_govQzr" style="display:none;" class="form-group">
                                <label class="control-label col-md-2">部委等级：<span class="required">* </span></label>
                                <label class="control-label col-md-1"><input id="govQzr" type="radio" name="govQzr" value="强"/>强</label>
                                <label class="control-label col-md-1"><input id="govQzr" type="radio" name="govQzr" value="中"/>中</label>
                                <label class="control-label col-md-1"><input id="govQzr" type="radio" name="govQzr" value="弱"/>弱</label>
                            </div>
                            <div id="div_bizLv1Id" class="form-group">
                                <label class="control-label col-md-2">业务分类：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="bizLv1Id" name="bizLv1Id" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option>G</option>
                                        <option>T</option>
                                        <option>F</option>
                                    </select>
                                </div>
                            </div>

                            <div id="div_bizLv2Id" class="form-group" style="display: none;">
                                <label class="control-label col-md-2">政府业务分类：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="bizLv2Id" name="bizLv2Id" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="Z">政府专项</option>
                                        <option value="G">高企申报</option>
                                        <option value="Q">其他本地化服务</option>
                                    </select>
                                </div>
                            </div>
                            <div id="div_winCustChnl" class="form-group">
                                <label class="control-label col-md-2">获客渠道：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="winCustChnl" name="winCustChnl" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option>活动</option>
                                        <option>园区</option>
                                        <option>政府</option>
                                        <option>机构</option>
                                        <option>自主开发</option>
                                        <option>其他</option>
                                    </select>
                                </div>
                            </div>
                            <div id="div_rchMode" class="form-group">
                                <label class="control-label col-md-2">触达方式：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="rchMode" name="rchMode" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option>电话</option>
                                        <option>拜访</option>
                                    </select>
                                </div>
                            </div>
                            <div id="div_beginTime" class="form-group">
                                <label class="control-label col-md-2">触达时间：<span class="required">* </span></label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="beginTime" name="beginTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;"/>
                                </div>
                            </div>
                            <div id="div_contacts" class="form-group">
                                <label class="control-label col-md-2">接触人：<span class="required">* </span></label>
                                <input id="contacts" name="contacts" type="text" class="form-control input-medium" value=""/>
                            </div>
                            <div id="div_jobTitle" class="form-group">
                                <label class="control-label col-md-2">职位（职务）：<span class="required">* </span></label>
                                <input id="jobTitle" name="jobTitle" type="text" class="form-control input-medium" value=""/>
                            </div>
                            <div id="div_contactsPhone" class="form-group">
                                <label class="control-label col-md-2">联系电话：<span class="required">* </span></label>
                                <input id="contactsPhone" name="contactsPhone" type="text" class="form-control input-medium" value=""/>
                            </div>
                            <div id="div_commTopic" style="display:none;" class="form-group">
                                <label class="control-label col-md-2">沟通主题：<span class="required">* </span></label>
                                <input id="commTopic" name="commTopic" type="text" class="form-control input-large" value=""/>
                            </div>
                            <div id="div_getEffect" style="display:none;" class="form-group">
                                <label class="control-label col-md-2">推进情况及取得的效果：<span class="required">* </span></label>
                                <textarea id="getEffect" name="getEffect" class="control-label col-md-4" rows="3" value="" placeholder="不超过50字"></textarea>
                            </div>
                            <div id="div_resultTime" style="display:none;" class="form-group">
                                <label class="control-label col-md-2">预计形成成果的时间：</label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="resultTime" name="resultTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;"/>
                                </div>
                            </div>
                            <div id="div_cdnThings" style="display:none;" class="form-group">
                                <label class="control-label col-md-2">需要总部协调事项：</label>
                                <input id="cdnThings" name="cdnThings" type="text" class="form-control input-large" value=""/>
                            </div>
                            <div id="div_salesLead" class="form-group">
                                <label class="control-label col-md-2">潜在销售机会：</label>
                                <div class="col-md-4">
                                    <input id="salesLead" name="salesLead" type="text" class="form-control input-large" placeholder="不超过30字"/>
                                </div>
                            </div>
                            <div id="div_remark" class="form-group">
                                <label class="control-label col-md-2">内容纪要：</label>
                                <textarea id="remark" name="remark" class="control-label col-md-4" rows="5" value="" placeholder="不超过100字"></textarea>
                            </div>
                            <div id="div_update_id" class="form-group">
                                <div class="row">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-6">更新ID：</label>
                                        <input type="text" name="updateId" id="updateId" placeholder="企业信息更新记录ID">
                                    </div>
                                    <div class="col-md-8">
                                        <div class="col-md-4">
                                            <input type="button" id="updateEnterpriseInfo" value="前往更新企业信息" class="btn blue"/>

                                        </div>
                                        <div class="col-md-4">
                                            <a href="/crm/enterpriseupt/viewupt" target="_blank">前往查看更新ID</a>
                                        </div>
                                        <div class="col-md-4">
                                            <p style="color: red;"> 丁佳总要求触达必须要有实际的企业信息更新，请先根据触达获得的信息填写企业信息，才能完成触达提交</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-md-offset-3 col-md-4">
                                        <input type="button" value="提交" class="btn purple" id="btn_addrch" onclick="clickbtn(this)"/>
                                        <input type="button" value="取消" class="btn default" id="btn_celrch" onclick="clickbtn(this)"/>
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
        elem: '#beginTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
    laydate({
        elem: '#resultTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
    function showDiz2() {
        if($("#bizLv1Id").val()=="G"){
            $("#div_bizLv2Id").show();
        }else{
            $("#div_bizLv2Id").hide();
            $("#bizLv2Id").val("");
        }
    }
    showDiz2();
    $("#bizLv1Id").change(function () {
        showDiz2();
    });

    $("#updateEnterpriseInfo").click(function () {
        if($("#regNo").val()==""&&$("#creditNo").val()==""){
            alert("请先校验企业");
            return;
        }
        window.open("/crm/enterprisedetail/view?reg_credit_no="+$("#regNo").val()+$("#creditNo").val());
    });
</script>
</body>
</html>
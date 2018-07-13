<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js" xmlns="http://www.w3.org/1999/html">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8"/>
    <title>信隆行CRM系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
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
<#include "../top_menu.ftl"/>

<!-- 仪表盘页面中部区域层：BEGIN-->
<div class="page-container">
    <!--引入页面左边菜单tree-->
<#include "../left_menu.ftl"/>
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

                    <form id="addReach" action="/reachcsr/corpdetail" method="post"
                          class="form-horizontal form-row-sepe">
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-2">客户类型：<span class="required">* </span></label>
                                <label class="control-label col-md-1">
                                    <input class="custType" type="radio" name="custType" value="corpCust" checked/>
                                    企业 </label>
                                <label class="control-label col-md-1">
                                    <input class="custType" type="radio" name="custType" value="unCorpCust"/>
                                    非企业 </label>
                            <#if user??>
                                <#if '${user.memberType}'=='1'||'${user.memberType}'=='2'||'${user.memberType}'=='90'>
                                    <!--如果是一般用户不显示下面菜单-->
                                    <label class="control-label col-md-1">
                                        <input class="custType" type="radio" name="custType" value="govCust"/>
                                        政府 </label>
                                </#if>
                            </#if>
                            </div>
                            <div id="div_enterpriseName" class="form-group">
                                <label class="control-label col-md-2">企业名称：<span class="required">* </span></label>
                                <input id="enterpriseName" name="enterpriseName" type="text" class="control-label col-md-2" placeholder="请输入企业全名" value="${crmReachcsr.enterpriseName!""}"/>
                                <label class="control-label col-md-1">&nbsp;</label>
                                <div class="search">
                                    <input type="button" value="校验企业" class="btn blue" id="checkEntBtn"/>
                                </div>
                            </div>
                            <div id="div_creditNo" class="form-group">
                                <label class="control-label col-md-2">统一社会信用代码：</label>
                                <input id="creditNo" name="creditNo" readonly="readonly" placeholder="此文本框不可输入" type="text" class="control-label col-md-2" value="${crmReachcsr.creditNo!""}"/>
                            </div>
                            <div id="div_regNo" class="form-group">
                                <label class="control-label col-md-2">工商注册号：</label>
                                <input id="regNo" name="regNo" readonly="readonly" type="text" placeholder="此文本框不可输入" class="control-label col-md-2" value="${crmReachcsr.regNo!""}"/>
                            </div>

                            <div id="div_bizLv1Id" class="form-group">
                                <label class="control-label col-md-2">业务分类：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="bizLv1Id" name="bizLv1Id" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option  value="G" <#if (crmReachcsr.bizLv1Id??&&crmReachcsr.bizLv1Id=="G")>selected</#if>>G</option>
                                        <option  value="T" <#if (crmReachcsr.bizLv1Id??&&crmReachcsr.bizLv1Id=="T")>selected</#if>>T</option>
                                        <option value="F" <#if (crmReachcsr.bizLv1Id??&&crmReachcsr.bizLv1Id=="F")>selected</#if>>F</option>
                                    </select>
                                </div>
                            </div>
                            <input type="hidden" name="rchNo" id="rchNo" value="${crmReachcsr.rchNo!""}">

                            <div id="div_bizLv2Id" class="form-group" style="display: none;">
                                <label class="control-label col-md-2">政府业务分类：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="bizLv2Id" name="bizLv2Id" class="bs-select form-control"
                                            data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="Z" <#if (crmReachcsr.bizLv2Id??&&crmReachcsr.bizLv2Id=="Z")>selected</#if> >政府专项</option>
                                        <option value="G" <#if (crmReachcsr.bizLv2Id??&&crmReachcsr.bizLv2Id=="G")>selected</#if>>高企申报</option>
                                        <option value="Q" <#if (crmReachcsr.bizLv2Id??&&crmReachcsr.bizLv2Id=="Q")>selected</#if>>其他本地化服务</option>
                                    </select>
                                </div>
                            </div>
                            <div id="div_winCustChnl" class="form-group">
                                <label class="control-label col-md-2">获客渠道：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="winCustChnl" name="winCustChnl" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="活动" <#if (crmReachcsr.winCustChnl??&&crmReachcsr.winCustChnl=="活动")>selected</#if>>活动</option>
                                        <option value="园区" <#if (crmReachcsr.winCustChnl??&&crmReachcsr.winCustChnl=="园区")>selected</#if>>园区</option>
                                        <option value="政府" <#if (crmReachcsr.winCustChnl??&&crmReachcsr.winCustChnl=="政府")>selected</#if>>政府</option>
                                        <option value="机构" <#if (crmReachcsr.winCustChnl??&&crmReachcsr.winCustChnl=="机构")>selected</#if>>机构</option>
                                        <option value="自主开发" <#if (crmReachcsr.winCustChnl??&&crmReachcsr.winCustChnl=="自主开发")>selected</#if>>自主开发</option>
                                        <option value="其他" <#if (crmReachcsr.winCustChnl??&&crmReachcsr.winCustChnl=="其他")>selected</#if>>其他</option>
                                    </select>
                                </div>
                            </div>
                            <div id="div_rchMode" class="form-group">
                                <label class="control-label col-md-2">触达方式：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="rchMode" name="rchMode" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="电话" <#if (crmReachcsr.rchMode??&&crmReachcsr.rchMode=="电话")>selected</#if>>电话</option>
                                        <option value="拜访" <#if (crmReachcsr.rchMode??&&crmReachcsr.rchMode=="拜访")>selected</#if>>拜访</option>
                                    </select>
                                </div>
                            </div>
                            <div id="div_beginTime" class="form-group">
                                <label class="control-label col-md-2">触达时间：<span class="required">* </span></label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="beginTime" name="beginTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" value="${crmReachcsr.beginTime!""}"/>
                                </div>
                            </div>
                            <div id="div_contacts" class="form-group">
                                <label class="control-label col-md-2">接触人：<span class="required">* </span></label>
                                <input id="contacts" name="contacts" type="text" class="form-control input-medium" value="${crmReachcsr.contacts!""}"/>
                            </div>
                            <div id="div_jobTitle" class="form-group">
                                <label class="control-label col-md-2">职位（职务）：<span class="required">* </span></label>
                                <input id="jobTitle" name="jobTitle" type="text" class="form-control input-medium" value="${crmReachcsr.jobTitle!""}"/>
                            </div>
                            <div id="div_contactsPhone" class="form-group">
                                <label class="control-label col-md-2">联系电话：<span class="required">* </span></label>
                                <input id="contactsPhone" name="contactsPhone" type="text" class="form-control input-medium" value="${crmReachcsr.contactsPhone!""}"/>
                            </div>
                            <div id="div_salesLead" class="form-group">
                                <label class="control-label col-md-2">潜在销售机会：</label>
                                <div class="col-md-4">
                                    <input id="salesLead" name="salesLead" type="text" class="form-control input-large" placeholder="不超过30字" value="${crmReachcsr.salesLead!""}"/>
                                </div>
                            </div>
                            <div id="div_remark" class="form-group">
                                <label class="control-label col-md-2">内容纪要：</label>
                                <textarea id="remark" name="remark" class="control-label col-md-4" rows="5" value="" placeholder="不超过100字">${crmReachcsr.remark!""}</textarea>
                            </div>
                            <div id="div_update_id" class="form-group">
                                <div class="row">
                                    <div class="col-md-4">
                                        <label class="control-label col-md-6">更新ID：</label>
                                        <input type="text" name="updateId" id="updateId" placeholder="企业信息更新记录ID" value="${crmReachcsr.updateId!""}">
                                    </div>
                                    <div class="col-md-8">
                                        <div class="col-md-4">
                                            <input type="button" id="updateEnterpriseInfo" value="前往更新企业信息"
                                                   class="btn blue"/>

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
                                        <input type="button" value="提交" class="btn purple" id="btn_addrch"/>
                                        <input type="button" value="取消" class="btn default" id="btn_celrch"/>
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
<script src="/dist/js/reachcsrDetail.js?v=1"></script>
<script src="/dist/js/laydate/laydate.js"></script>

<script>
    laydate({
        elem: '#beginTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });

    function showDiz2() {
        if ($("#bizLv1Id").val() == "G") {
            $("#div_bizLv2Id").show();
        } else {
            $("#div_bizLv2Id").hide();
            $("#bizLv2Id").val("");
        }
    }

    showDiz2();
    $("#bizLv1Id").change(function () {
        showDiz2();
    });
    //校验企业
    $("#checkEntBtn").click(function () {
        $("#checkEntBtn").prop("disabled",true);
        var enterpriseName = $("#enterpriseName").val();
        if (enterpriseName != "") {
            $.post(
                    "/reachcsr/qxbCheckName",
                    {
                        key: enterpriseName
                    },
                    function (data) {
                        if(data.code==200){
                            data=data.data;
                            $("#creditNo").val(data.creditNo);
                            $("#regNo").val(data.regNo);
                            $("#enterpriseName").prop("readonly",true);
                        }else{
                            alert(data.msg);
                            $("#checkEntBtn").prop("disabled",false);
                        }
                    });
        }
    });
    $("#updateEnterpriseInfo").click(function () {
        if ($("#regNo").val() == "" && $("#creditNo").val() == "") {
            alert("请先校验企业");
            return;
        }
        window.open("/crm/enterprisedetail/view?reg_credit_no=" + $("#regNo").val() + $("#creditNo").val());
    });

    $("#btn_addrch").click(function () {
        var msg="";
        if($("#enterpriseName").val()==""){
            msg+="客户名不能为空\r\n"
        }
        if($("#creditNo").val()==""&&$("#regNo").val()==""){
            msg+="请校验企业\r\n"
        }
        if($("#bizLv1Id").val()==""||$("#bizLv1Id").val()==null){
            msg+="请选择业务分类\r\n";
        }
        if($("#bizLv1Id").val()=="G"){
            if($("#bizLv2Id").val()==""||$("#bizLv2Id").val()==null){
                msg+="请选择政府业务分类\r\n";
            }
        }
        if($("#winCustChnl").val()==""||$("#winCustChnl").val()==null){
            msg+="请选择获客渠道\r\n";
        }
        if($("#rchMode").val()==""||$("#rchMode").val()==null){
            msg+="请选择触达方式\r\n";
        }
        if($("#beginTime").val()==""){
            msg+="请选择触达时间\r\n";
        }
        if($("#contacts").val()==""){
            msg+="请填写接触人\r\n";
        }
        if($("#jobTitle").val()==""){
            msg+="请填写职位（职务）\r\n";
        }
        if($("#contactsPhone").val()==""){
            msg+="请填写联系电话\r\n";
        }
        if(DataLength($("#salesLead").val())>30){
            msg+="潜在销售机会不超过30字\r\n"
        }
        if($("#remark").val()==""){
            msg+="请填写内容纪要\r\n";
        }
        if(DataLength($("#remark").val())>100){
            msg+="内容纪要不超过100字\r\n"
        }
        if($("#updateId").val()==""){
            msg+="请填写更新ID\r\n";
        }
        if(msg!=""){
            alert(msg);
        }else{
            $("#addReach").submit();
        }
    });

</script>
</body>
</html>
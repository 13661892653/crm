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


                    <form id="addReach" action="/reachcsr/govdetail" method="post" class="form-horizontal form-row-sepe">
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-2">客户类型：<span class="required">* </span></label>
                                <label class="control-label col-md-1">
                                    <input class="custType" type="radio" name="custType" value="corpCust" />
                                    企业 </label>
                                <label class="control-label col-md-1">
                                    <input class="custType" type="radio" name="custType" value="unCorpCust"/>
                                    非企业 </label>
                            <#if user??>
                                <#if '${user.memberType}'=='1'||'${user.memberType}'=='2'||'${user.memberType}'=='90'>  <!--如果是一般用户不显示下面菜单-->
                                    <label class="control-label col-md-1">
                                        <input class="custType" type="radio" name="custType" value="govCust" checked/>
                                        政府 </label>
                                </#if>
                            </#if>
                            </div>
                            <div id="div_govName" class="form-group">
                                <label class="control-label col-md-2">拜访部委名称：<span class="required">* </span></label>
                                <input id="enterpriseName" name="enterpriseName" type="text" class="control-label col-md-2" placeholder="请输入拜访部委名称" value="${crmReachcsr.enterpriseName!""}"/>
                            </div>
                            <div id="div_govLine"  class="form-group">
                                <label class="control-label col-md-2">政府条线：<span class="required">* </span></label>
                                <label class="control-label col-md-1"><input class="govLineR" type="radio" name="govLineR" value="人民政府" />人民政府</label>
                                <label class="control-label col-md-1"><input class="govLineR" type="radio" name="govLineR" value="科技局"  />科技局</label>
                                <label class="control-label col-md-1"><input class="govLineR" type="radio" name="govLineR" value="发改委"  />发改委</label>
                                <label class="control-label col-md-1"><input class="govLineR" type="radio" name="govLineR" value="经信委"  />经信委</label>
                                <label class="control-label col-md-1"><input class="govLineR" type="radio" name="govLineR" value="金融办"  />金融办</label>
                                <label class="control-label col-md-1"><input class="govLineR" type="radio" name="govLineR" value="组织部"  />组织部</label>
                                <label class="control-label col-md-1"><input class="govLineR" type="radio" name="govLineR" value="其他"/>其他</label>
                                <label id="govLineLab" style="display:none;"><input id="govLineIpt" name="govLineT" type="text" class="form-control input-medium" value="" placeholder="填写其他政府条线"/></label>
                            </div>
                            <input type="hidden" name="govLine" id="govLine" value="${crmReachcsr.govLine!""}">
                            <input type="hidden" name="rchNo" id="rchNo" value="${crmReachcsr.rchNo!""}">
                            <div id="div_govLevel"  class="form-group">
                                <label class="control-label col-md-2">级别：<span class="required">* </span></label>
                                <label class="control-label col-md-1"><input class="govLevel"  type="radio" name="govLevel" value="国家级" <#if (crmReachcsr.govLevel?? && crmReachcsr.govLevel=="国家级")>checked</#if>/>国家级</label>
                                <label class="control-label col-md-1"><input class="govLevel"  type="radio" name="govLevel" value="省级"<#if (crmReachcsr.govLevel??&&crmReachcsr.govLevel=="省级")>checked</#if>/>省级</label>
                                <label class="control-label col-md-1"><input class="govLevel"  type="radio" name="govLevel" value="市级"<#if (crmReachcsr.govLevel??&&crmReachcsr.govLevel=="市级")>checked</#if>/>市级</label>
                                <label class="control-label col-md-1"><input class="govLevel"  type="radio" name="govLevel" value="区县级"<#if (crmReachcsr.govLevel??&&crmReachcsr.govLevel=="区县级")>checked</#if>/>区县级</label>
                            </div>
                            <div id="div_govQzr" class="form-group">
                                <label class="control-label col-md-2">部委等级：<span class="required">* </span></label>
                                <label class="control-label col-md-1"><input class="govQzr"  type="radio" name="govQzr" value="强"<#if (crmReachcsr.govQzr??&&crmReachcsr.govQzr=="强")>checked</#if>/>强</label>
                                <label class="control-label col-md-1"><input class="govQzr"  type="radio" name="govQzr" value="中"<#if (crmReachcsr.govQzr??&&crmReachcsr.govQzr=="中")>checked</#if>/>中</label>
                                <label class="control-label col-md-1"><input class="govQzr"  type="radio" name="govQzr" value="弱"<#if (crmReachcsr.govQzr??&&crmReachcsr.govQzr=="弱")>checked</#if>/>弱</label>
                            </div>
                            <div id="div_bizLv1Id" class="form-group">
                                <label class="control-label col-md-2">业务分类：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="bizLv1Id" name="bizLv1Id" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="G" <#if (crmReachcsr.bizLv1Id??&&crmReachcsr.bizLv1Id=="G")>selected</#if>>G各类大赛</option>
                                        <option value="G2" <#if (crmReachcsr.bizLv1Id??&&crmReachcsr.bizLv1Id=="G2")>selected</#if>>G政府专项</option>
                                        <option value="T" <#if (crmReachcsr.bizLv1Id??&&crmReachcsr.bizLv1Id=="T")>selected</#if>>T企业上云</option>
                                        <option value="F" <#if (crmReachcsr.bizLv1Id??&&crmReachcsr.bizLv1Id=="F")>selected</#if>>F科技贷款系统</option>
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
                                <input id="contacts" name="contacts" type="text" class="form-control input-medium" value="${crmReachcsr.contacts!""}" />
                            </div>
                            <div id="div_jobTitle" class="form-group">
                                <label class="control-label col-md-2">职位（职务）：<span class="required">* </span></label>
                                <input id="jobTitle" name="jobTitle" type="text" class="form-control input-medium" value="${crmReachcsr.jobTitle!""}"  />
                            </div>
                            <div id="div_contactsPhone" class="form-group">
                                <label class="control-label col-md-2">联系电话：<span class="required">* </span></label>
                                <input id="contactsPhone" name="contactsPhone" type="text" class="form-control input-medium" value="${crmReachcsr.contactsPhone!""}"/>
                            </div>
                            <div id="div_commTopic"  class="form-group">
                                <label class="control-label col-md-2">沟通主题：<span class="required">* </span></label>
                                <input id="commTopic" name="commTopic" type="text" class="form-control input-large" value="${crmReachcsr.commTopic!""}"/>
                            </div>
                            <div id="div_getEffect" class="form-group">
                                <label class="control-label col-md-2">推进情况及取得的效果：<span class="required">* </span></label>
                                <textarea id="getEffect" name="getEffect" class="control-label col-md-4" rows="3"  placeholder="不超过50字">${crmReachcsr.getEffect!""}</textarea>
                            </div>
                            <div id="div_resultTime"  class="form-group">
                                <label class="control-label col-md-2">预计形成成果的时间：</label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="resultTime" name="resultTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" value="${crmReachcsr.resultTime!""}"  />
                                </div>
                            </div>
                            <div id="div_cdnThings"  class="form-group">
                                <label class="control-label col-md-2">需要总部协调事项：</label>
                                <input id="cdnThings" name="cdnThings" type="text" class="form-control input-large" value="${crmReachcsr.cdnThings!""}" />
                            </div>
                            <div id="div_remark" class="form-group">
                                <label class="control-label col-md-2">内容纪要：<span class="required">* </span></label>
                                <textarea id="remark" name="remark" class="control-label col-md-4" rows="5" value="" placeholder="不少于100字">${crmReachcsr.remark!""}</textarea>
                            </div>

                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-md-offset-3 col-md-4">
                                        <input type="button" value="提交" class="btn purple" id="btn_addrch" />
                                        <input type="button" value="取消" class="btn default" id="btn_celrch" />
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
    laydate({
        elem: '#resultTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });

    //初始化radio
    var govLine=$("#govLine").val();
    if(govLine!=""){
        $(".govLineR").removeAttr("checked");
        if(govLine!="人民政府"&&govLine!="科技局"&&govLine!="发改委"&&govLine!="经信委"&&govLine!="金融办"&&govLine!="组织部"){
            $("#govLineIpt").val(govLine);
            govLine="其他";
        }
        $(".govLineR").each(function () {
            if($(this).val()==govLine){
                $(this).prop("checked",true);
            }
        })
    }
    //政府条线选其他时，输入框显示
    function showGovLineOtherDiv() {
        if($(".govLineR:checked").val()=="其他"){
            $("#govLineLab").show();
        }else{
            $("#govLineLab").hide();
        }
    }
    showGovLineOtherDiv();
    $(".govLineR").change(function () {
        showGovLineOtherDiv();
    });
    //提交
    $("#btn_addrch").click(function () {
        var msg="";
        if($("#enterpriseName").val()==""){
            msg+="拜访部委名称不能为空\r\n"
        }
        if($(".govLine:checked").val()==""){
            msg+="请选择政府条线\r\n";
        }
        if($(".govLineR:checked").val()=="其他"&&$("#govLineIpt").val()==""){
            msg+="请填写其他政府条线\r\n";
        }
        if($(".govLevel:checked").val()==""){
            msg+="请选择级别\r\n";
        }
        if($(".govQzr:checked").val()==""){
            msg+="请选择部委等级\r\n";
        }
        if($("#bizLv1Id").val()==""||$("#bizLv1Id").val()==null){
            msg+="请选择业务分类\r\n";
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
        if($("#commTopic").val()==""){
            msg+="请填写沟通主题\r\n";
        }
        if($("#getEffect").val()==""){
            msg+="请填写推进情况及取得的效果\r\n";
        }
        if(DataLength($("#getEffect").val())>50){
            msg+="推进情况及取得的效果不超过50字\r\n"
        }
        if($("#remark").val()==""){
            msg+="请填写内容纪要\r\n";
        }
        if(DataLength($("#remark").val())<100){
            msg+="内容纪要不小于100字\r\n"
        }
        if(msg!=""){
            alert(msg);
        }else{
            if($(".govLineR:checked").val()=="其他"){
                $("#govLine").val($("#govLineIpt").val());
            }else {
                $("#govLine").val($(".govLineR:checked").val());
            }
            $("#addReach").submit();
        }
    });



</script>
</body>
</html>
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
<#assign page=23/>
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
                        <a href="#">修改触达信息</a>
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
                    <form id="updateReach" action="/crm/marketing/reachcsr/update" method="post" class="form-horizontal form-row-sepe">
                        <input name="rchNo" id="rchNo" type="hidden" <#if (result.rchNo)??> value = "${result.rchNo}"</#if> />
                        <div class="form-body">
                    <#if (result.custType)??>
                        <#if '${result.custType}'!='govCust'>
                            <div class="form-group">
                                <label class="control-label col-md-2">触达对象类型：</label>
                                <label class="control-label col-md-1">
                                    <input disabled="disabled" type="radio" name="custType" value="${result.custType}" <#if (result.custType)=="corpCust"> checked </#if>/>
                                    企业 </label>
                                <label class="control-label col-md-1">
                                    <input disabled="disabled" type="radio" name="custType" value="${result.custType}" <#if (result.custType)=="unCorpCust"> checked </#if>/>
                                    非企业 </label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">分公司：</label>
                                <input name="company" readonly="readonly" type="text" class="form-control input-small" <#if (result.company)??> value="${result.company}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">触达人：</label>
                                <input name="rchEmp" readonly="readonly" type="text" class="form-control input-small" <#if (result.rchEmp)??> value="${result.rchEmp}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">业务分类：</label>
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
                            <#if (result.bizLv1Id) == "G">
                            <div id="div_bizLv2Id" class="form-group" >
                                <label class="control-label col-md-2">政府业务分类：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="bizLv2Id" name="bizLv2Id" disabled="disabled" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option <#if (result.bizLv2Id?if_exists) == "Z"> selected="selected" </#if>value="Z">政府专项</option>
                                        <option <#if (result.bizLv2Id?if_exists) == "G"> selected="selected" </#if>value="G">高企申报</option>
                                        <option <#if (result.bizLv2Id?if_exists) == "Q"> selected="selected" </#if>value="Q">其他本地化服务</option>
                                    </select>
                                </div>
                            </div>
                            </#if>
                            <div class="form-group">
                                <label class="control-label col-md-2">触达客户：</label>
                                <input name="enterpriseName" readonly="readonly" type="text" class="form-control input-large" <#if (result.enterpriseName)??> value="${result.enterpriseName}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">获客渠道：</label>
                                <div class="col-md-2">
                                    <select name="winCustChnl" disabled="disabled"  class="form-control input-medium select2me">
                                    <#if (result.winCustChnl)??>
                                        <option <#if (result.winCustChnl) == "活动"> selected="selected" </#if>>活动</option>
                                        <option <#if (result.winCustChnl) == "园区"> selected="selected" </#if>>园区</option>
                                        <option <#if (result.winCustChnl) == "政府"> selected="selected" </#if>>政府</option>
                                        <option <#if (result.winCustChnl) == "机构"> selected="selected" </#if>>机构</option>
                                        <option <#if (result.winCustChnl) == "自主开发"> selected="selected" </#if>>自主开发</option>
                                        <option <#if (result.winCustChnl) == "其他"> selected="selected" </#if>>其他</option>
                                    </#if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">触达方式：</label>
                                <div class="col-md-2">
                                    <select name="rchMode" disabled="disabled"  class="form-control input-medium select2me">
                                    <#if (result.rchMode)??>
                                        <option <#if (result.rchMode) == "电话"> selected="selected" </#if>>电话</option>
                                        <option <#if (result.rchMode) == "拜访"> selected="selected" </#if>>拜访</option>
                                    </#if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">触达时间：</label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="beginTime" name="beginTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" <#if (result.beginTime)??> value="${result.beginTime}" </#if>/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">接触人：</label>
                                <input name="contacts" type="text" class="form-control input-small" <#if (result.contacts)??> value="${result.contacts}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">接触人职位：</label>
                                <input name="jobTitle" type="text" class="form-control input-small" <#if (result.jobTitle)??> value="${result.jobTitle}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">接触人联系电话：</label>
                                <input name="contactsPhone" type="text" class="form-control input-medium" <#if (result.contactsPhone)??> value="${result.contactsPhone}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">潜在销售机会：</label>
                                <input name="salesLead" type="text" class="form-control input-large" <#if (result.salesLead)??> value="${result.salesLead}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">内容纪要：</label>
                                <textarea id="remark" name="remark" class="control-label col-md-4" rows="5" <#if (result.remark)??> value="${result.remark}" </#if>><#if (result.remark)??>${result.remark}</#if></textarea>
                            </div>
                        </div>
                        </#if>
                    </#if>

                    <#if (result.custType)??>
                        <#if '${result.custType}'=='govCust'>
                            <div class="form-group">
                                <label class="control-label col-md-2">触达对象类型：</label>
                                <label class="control-label col-md-1">
                                    <input disabled="disabled" type="radio" name="govCust" value="govCust" <#if (result.custType)=="govCust"> checked </#if>/>
                                    政府 </label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">分公司：</label>
                                <input name="company" readonly="readonly" type="text" class="form-control input-small" <#if (result.company)??> value="${result.company}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">触达人：</label>
                                <input name="rchEmp" readonly="readonly" type="text" class="form-control input-small" <#if (result.rchEmp)??> value="${result.rchEmp}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">业务分类：</label>
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
                            <div class="form-group">
                                <label class="control-label col-md-2">拜访部委名称：</label>
                                <input name="enterpriseName" readonly="readonly" type="text" class="form-control input-large" <#if (result.enterpriseName)??> value="${result.enterpriseName}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">政府条线：</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" disabled="disabled" value="人民政府" <#if (result.govLine)=="人民政府"> checked </#if>/>人民政府</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" disabled="disabled" value="科技局" <#if (result.govLine)=="科技局"> checked </#if>/>科技局</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" disabled="disabled" value="发改委" <#if (result.govLine)=="发改委"> checked </#if>/>发改委</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" disabled="disabled" value="经信委" <#if (result.govLine)=="经信委"> checked </#if>/>经信委</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" disabled="disabled" value="金融办" <#if (result.govLine)=="金融办"> checked </#if>/>金融办</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" disabled="disabled" value="组织部" <#if (result.govLine)=="组织部"> checked </#if>/>组织部</label>
                                <label class="control-label col-md-1"><input id="govLine" type="radio" name="govLine" disabled="disabled" value="其他" <#if (result.govLine)=="其他"> checked </#if>/>其他</label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">级别：</label>
                                <label class="control-label col-md-1"><input id="govLevel" type="radio" name="govLevel" disabled="disabled" value="国家级" <#if (result.govLevel)=="国家级"> checked </#if>/>国家级</label>
                                <label class="control-label col-md-1"><input id="govLevel" type="radio" name="govLevel" disabled="disabled" value="省级" <#if (result.govLevel)=="省级"> checked </#if>/>省级</label>
                                <label class="control-label col-md-1"><input id="govLevel" type="radio" name="govLevel" disabled="disabled" value="市级" <#if (result.govLevel)=="市级"> checked </#if>/>市级</label>
                                <label class="control-label col-md-1"><input id="govLevel" type="radio" name="govLevel" disabled="disabled" value="区县级" <#if (result.govLevel)=="区县级"> checked </#if>/>区县级</label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">部委等级：</label>
                                <label class="control-label col-md-1"><input id="govQzr" type="radio" name="govQzr" disabled="disabled" value="强" <#if (result.govQzr)=="强"> checked </#if>/>强</label>
                                <label class="control-label col-md-1"><input id="govQzr" type="radio" name="govQzr" disabled="disabled" value="中" <#if (result.govQzr)=="中"> checked </#if>/>中</label>
                                <label class="control-label col-md-1"><input id="govQzr" type="radio" name="govQzr" disabled="disabled" value="弱" <#if (result.govQzr)=="弱"> checked </#if>/>弱</label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">业务分类：</label>
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
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">拜访时间：</label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="beginTime" name="beginTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" <#if (result.beginTime)??> value="${result.beginTime}" </#if>/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">拜访领导：</label>
                                <input name="contacts" type="text" class="form-control input-small" <#if (result.contacts)??> value="${result.contacts}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">领导职务：</label>
                                <input name="jobTitle" type="text" class="form-control input-small" <#if (result.jobTitle)??> value="${result.jobTitle}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">联系电话：</label>
                                <input name="contactsPhone" type="text" class="form-control input-medium" <#if (result.contactsPhone)??> value="${result.contactsPhone}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">沟通主题：</label>
                                <input name="commTopic" type="text" class="form-control input-large" <#if (result.commTopic)??> value="${result.commTopic}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">推进情况及取得的效果：</label>
                                <textarea id="getEffect" name="getEffect" class="control-label col-md-4" rows="3" <#if (result.getEffect)??> value="${result.getEffect}" </#if>><#if (result.getEffect)??>${result.getEffect}</#if></textarea>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">预计形成成果的时间：</label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="resultTime" name="resultTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" <#if (result.resultTime)??> value="${result.resultTime}" </#if>/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">需要总部协调事项：</label>
                                <input name="cdnThings" type="text" class="form-control input-large" <#if (result.cdnThings)??> value="${result.cdnThings}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">内容纪要：</label>
                                <textarea id="remark" name="remark" class="control-label col-md-4" rows="5" <#if (result.remark)??> value="${result.remark}" </#if>><#if (result.remark)??>${result.remark}</#if></textarea>
                            </div>
                        </div>
                        </#if>
                    </#if>
                        <div class="form-actions">
                            <div class="row">
                                <div class="col-md-offset-3 col-md-4">
                                    <input type="button" value="修改" class="btn purple" id="btn_uptrch" onclick="clickbtn(this)"/>
                                    <input type="button" value="取消" class="btn default" id="btn_celrch" onclick="clickbtn(this)"/>
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

</script>
</body>
</html>
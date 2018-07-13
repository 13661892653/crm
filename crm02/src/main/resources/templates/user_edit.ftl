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
                        <a href="#">修改用户信息</a>
                    </li>
                </ul>
            </div>
            <!-- BEGIN-->
            <div class="portlet">
                <div class="portlet-body form">
                    <form id="updateUser" action="/crm/user/submit" method="post" class="form-horizontal form-row-sepe">
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-2">用户手机号：</label>
                                <input name="memberPhone" readonly="readonly" type="text" class="form-control input-small" <#if (result.memberPhone)??> value="${result.memberPhone}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">用户名：</label>
                                <input name="userName" readonly="readonly" type="text" class="form-control input-small" <#if (result.userName)??> value="${result.userName}" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">所在省份：</label>
                                <div class="col-md-2">
                                    <select name="province" class="form-control input-medium select2me">
                                    <#if (result.province)??>
                                        <option <#if (result.province) == "北京"> selected="selected" </#if>>北京</option>
                                        <option <#if (result.province) == "上海"> selected="selected" </#if>>上海</option>
                                        <option <#if (result.province) == "浙江"> selected="selected" </#if>>浙江</option>
                                        <option <#if (result.province) == "江苏"> selected="selected" </#if>>江苏</option>
                                        <option <#if (result.province) == "广东"> selected="selected" </#if>>广东</option>
                                        <option <#if (result.province) == "山东"> selected="selected" </#if>>山东</option>
                                        <option <#if (result.province) == "湖北"> selected="selected" </#if>>湖北</option>
                                        <option <#if (result.province) == "湖南"> selected="selected" </#if>>湖南</option>
                                        <option <#if (result.province) == "四川"> selected="selected" </#if>>四川</option>
                                        <option <#if (result.province) == "安徽"> selected="selected" </#if>>安徽</option>
                                        <option <#if (result.province) == "江西"> selected="selected" </#if>>江西</option>
                                        <option <#if (result.province) == "美国"> selected="selected" </#if>>美国</option>
                                    </#if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">所在分公司：</label>
                                <div class="col-md-2">
                                    <select name="company" class="form-control input-medium select2me">
                                    <#if (result.company)??>
                                        <option <#if (result.company) == "北京"> selected="selected" </#if>>北京</option>
                                        <option <#if (result.company) == "上海"> selected="selected" </#if>>上海</option>
                                        <option <#if (result.company) == "广州"> selected="selected" </#if>>广州</option>
                                        <option <#if (result.company) == "杭州"> selected="selected" </#if>>杭州</option>
                                        <option <#if (result.company) == "温州"> selected="selected" </#if>>温州</option>
                                        <option <#if (result.company) == "嘉兴"> selected="selected" </#if>>嘉兴</option>
                                        <option <#if (result.company) == "台州"> selected="selected" </#if>>台州</option>
                                        <option <#if (result.company) == "舟山"> selected="selected" </#if>>舟山</option>
                                        <option <#if (result.company) == "绍兴"> selected="selected" </#if>>绍兴</option>
                                        <option <#if (result.company) == "湖州"> selected="selected" </#if>>湖州</option>
                                        <option <#if (result.company) == "宁波"> selected="selected" </#if>>宁波</option>
                                        <option <#if (result.company) == "南京"> selected="selected" </#if>>南京</option>
                                        <option <#if (result.company) == "无锡"> selected="selected" </#if>>无锡</option>
                                        <option <#if (result.company) == "常州"> selected="selected" </#if>>常州</option>
                                        <option <#if (result.company) == "张家港"> selected="selected" </#if>>张家港</option>
                                        <option <#if (result.company) == "武汉"> selected="selected" </#if>>武汉</option>
                                        <option <#if (result.company) == "成都"> selected="selected" </#if>>成都</option>
                                        <option <#if (result.company) == "合肥"> selected="selected" </#if>>合肥</option>
                                        <option <#if (result.company) == "南昌"> selected="selected" </#if>>南昌</option>
                                        <option <#if (result.company) == "青岛"> selected="selected" </#if>>青岛</option>
                                        <option <#if (result.company) == "长沙"> selected="selected" </#if>>长沙</option>
                                        <option <#if (result.company) == "北美"> selected="selected" </#if>>北美</option>
                                        <option <#if (result.company) == "总部"> selected="selected" </#if>>总部</option>
                                    </#if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">邮箱：</label>
                                <input name="email" type="text" class="form-control input-medium" <#if (result.email)??> value="${result.email}"</#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">用户状态：</label>
                                <div class="col-md-2">
                                    <select name="memberStatus" class="form-control input-medium select2me">
                                    <#if (result.memberStatus)??>
                                        <option <#if (result.memberStatus) == "1"> selected="selected" </#if> value="1">有效</option>
                                        <option <#if (result.memberStatus) == "0"> selected="selected" </#if> value="0">失效</option>
                                    </#if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2" style="color: #ff0000">用户类型：</label>
                                <div class="col-md-2">
                                    <select name="memberType" class="form-control input-medium select2me">
                                    <#if (result.memberType)??>
                                        <option <#if (result.memberType) == "98"> selected="selected" </#if> value="98">分公司企服顾问</option>
                                        <option <#if (result.memberType) == "99"> selected="selected" </#if> value="99">分公司运营经理</option>
                                        <option <#if (result.memberType) == "90"> selected="selected" </#if> value="90">分公司经理</option>
                                        <option <#if (result.memberType) == "10"> selected="selected" </#if> value="10">一般用户（总部）</option>
                                        <option <#if (result.memberType) == "2"> selected="selected" </#if> value="2">高级用户（总部）</option>
                                        <option <#if (result.memberType) == "1"> selected="selected" </#if> value="1">管理员</option>
                                    </#if>
                                    </select>
                                </div>
                            </div>
                            <div class="form-actions">
                                <div class="row">
                                    <div class="col-md-offset-3 col-md-4">
                                        <input type="button" value="提交" class="btn purple" id="btn_uptusr" onclick="clickbtn(this)"/>
                                        <input type="button" value="取消" class="btn default" id="btn_celusr" onclick="clickbtn(this)"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- END FORM-->
                </div>
            </div>
            <!-- END-->
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
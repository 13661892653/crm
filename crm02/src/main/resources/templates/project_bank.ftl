<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
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
    <link href="/dist/css/themes/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="/dist/css/custom.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/filter_area.css" rel="stylesheet" type="text/css"/>


</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
<#include "top_menu.ftl"/>

<!-- 仪表盘页面中部区域层：BEGIN-->
<div class="page-container">
    <!--引入页面左边菜单tree-->
<#include "left_menu.ftl"/>

    <!-------------------页面tree菜单右边展示区域，由开发者自由编写：BEGIN-->
    <div class="page-content-wrapper">
        <div class="page-content">

            <div class="container classification">
                <div class="group regionCode">
                    <div class="head">
                        <h4>地区</h4>
                        <span data-value="all"  <#if result.reqParams.regionCode == "all">class="all" </#if>>全部</span>
                    </div>
                    <div class="body" id="region">
                        <span data-value="北京" <#if result.reqParams.regionCode == "北京">class="cur" </#if> >北京</span>
                        <span data-value="上海" <#if result.reqParams.regionCode == "上海">class="cur" </#if> >上海</span>
                        <span data-value="广州" <#if result.reqParams.regionCode == "广州">class="cur" </#if> >广州</span>
                        <span data-value="杭州" <#if result.reqParams.regionCode == "杭州">class="cur" </#if> >杭州</span>
                        <span data-value="南京" <#if result.reqParams.regionCode == "南京">class="cur" </#if> >南京</span>
                        <span data-value="武汉" <#if result.reqParams.regionCode == "武汉">class="cur" </#if> >武汉</span>
                        <span data-value="成都" <#if result.reqParams.regionCode == "成都">class="cur" </#if> >成都</span>
                        <span data-value="合肥" <#if result.reqParams.regionCode == "合肥">class="cur" </#if> >合肥</span>
                        <span data-value="南昌" <#if result.reqParams.regionCode == "南昌">class="cur" </#if> >南昌</span>
                        <span data-value="无锡" <#if result.reqParams.regionCode == "无锡">class="cur" </#if> >无锡</span>
                        <span data-value="青岛" <#if result.reqParams.regionCode == "青岛">class="cur" </#if> >青岛</span>
                        <span data-value="温州" <#if result.reqParams.regionCode == "温州">class="cur" </#if> >温州</span>
                        <span data-value="长沙" <#if result.reqParams.regionCode == "长沙">class="cur" </#if> >长沙</span>
                        <span data-value="嘉兴" <#if result.reqParams.regionCode == "嘉兴">class="cur" </#if> >嘉兴</span>
                        <span data-value="台州" <#if result.reqParams.regionCode == "台州">class="cur" </#if> >台州</span>
                        <span data-value="舟山" <#if result.reqParams.regionCode == "舟山">class="cur" </#if> >舟山</span>
                        <span data-value="绍兴" <#if result.reqParams.regionCode == "绍兴">class="cur" </#if> >绍兴</span>
                        <span data-value="常州" <#if result.reqParams.regionCode == "常州">class="cur" </#if> >常州</span>
                        <span data-value="张家港" <#if result.reqParams.regionCode == "张家港">class="cur" </#if> >张家港</span>
                        <span data-value="湖州" <#if result.reqParams.regionCode == "湖州">class="cur" </#if> >湖州</span>
                        <span data-value="江阴" <#if result.reqParams.regionCode == "江阴">class="cur" </#if> >江阴</span>
                    </div>
                </div>
                <div class="group">
                    <div class="head">
                        <h4>所属行业</h4>
                        <span id="allIndustry" class="all">全部</span>
                    </div>
                    <div class="body">
                        <div class="industry">
                            <p>请选择行业类别</p>
                            <div class="industry-panel">
                                <ul class="industry-box"></ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="group">
                    <div class="head">
                        <h4>项目标签</h4>
                        <span class="all">全部</span>
                    </div>
                    <div class="body" id="enttag">
                       <#list enterpriseTagList as enttag>
                       <span id="spenttag" value="${enttag.assetsTagCode?if_exists}">${enttag.assetsTagDesc?if_exists}</span>
                       </#list>
                    </div>
                </div>
            </div>
            <!-- 隐式请求参数-->
            <form id="filterCond" action="/market/projectbank" method="post">
                <input name="regionCode" id="regionCode" type="hidden" value = "${result.reqParams.regionCode!''}">
                <input type="hidden" name="pageIndex" id="pageIndex" value="">
            </form>

            <div class="result-count">
                <p>共找到 <span>${result.prjListContents?size}</span>条相关结果 </p>
            </div>

            <!-- BEGIN 数据展示区-->
            <div class="portlet box blue-hoki">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-globe"></i>企业数据库
                    </div>
                    <div class="tools">
                    </div>
                </div>
                <div class="portlet-body">
                    <table class="table table-striped table-bordered table-hover" id="sample_1">
                        <thead>
                        <tr>
                            <th>
                                企业名称
                            </th>
                            <th>
                                工商注册号
                            </th>
                            <th>
                                统一社会信用代码
                            </th>
                            <th>
                                经营状态
                            </th>
                            <th>
                                企业地址
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                    <#list result.prjListContents as projectlist>
                        <tr>
                            <td>
                            ${projectlist.enterpriseName?if_exists}
                            </td>
                            <td>
                            ${projectlist.regNo?if_exists}
                            </td>
                            <td>
                            ${projectlist.creditNo?if_exists}
                            </td>
                            <td>
                            ${projectlist.mgmtStatus?if_exists}
                            </td>
                            <td>
                            ${projectlist.entAddress?if_exists}
                            </td>
                        </tr>
                    </#list>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- END 数据展示区-->

        </div>
        <!-------------------页面tree菜单右边展示区域，由开发者自由编写：END-->
    </div>

    <!-- 页面中部区域层：END-->
</div>

<!-- BEGIN 框架效果 -->
<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<!-- BEGIN 数据展示区表格分页和搜索 -->
<script src="/dist/js/media/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="/dist/js/dataTables.tableTools.min.js" type="text/javascript"></script>
<script src="/dist/js/dataTables.colReorder.min.js" type="text/javascript"></script>
<script src="/dist/js/dataTables.scroller.min.js" type="text/javascript"></script>
<script src="/dist/js/dataTables.bootstrap.js" type="text/javascript"></script>
<script src="/dist/js/demo.js" type="text/javascript"></script>
<script src="/dist/js/table-advanced.js"></script>

<!-- added by yingsl on 20170523 -->
<script src="/dist/js/filter_prjbank.js"></script>
<script src="/dist/js/data_select.js"></script>
<script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        Demo.init(); // init demo features
        TableAdvanced.init();
    });
</script>
</body>
</html>


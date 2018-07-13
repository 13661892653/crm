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
    <!-- <link href="/dist/css/default.css" rel="stylesheet" type="text/css" id="style_color" /> -->
    <link href="/dist/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="/dist/css/custom.css" rel="stylesheet" type="text/css"/>

    <!-- added by yingsl on 20170523 -->
    <link href="/dist/css/invevent.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/jquery-ui.min.css" rel="stylesheet">

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
<#assign page=220/>
<#include "top_menu.ftl"/>

<!-- 仪表盘页面中部区域层：BEGIN-->
<div class="page-container">
    <!--引入页面左边菜单tree-->
<#include "left_menu.ftl"/>

    <!-------------------页面tree菜单右边展示区域，由开发者自由编写：BEGIN-->
    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="#">中国投融资数据</a>
                    </li>
                </ul>
            </div>
            <div class="container classification">
                <div class="group invTime">
                    <div class="head">
                        <h4>融资时间</h4>
                        <span data-value="all" <#if result.reqParams.invTimeBegin == "all"> class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <div class="period">
                            <input name="startDate" id="startDate" type="text" placeholder="开始时间" value = "${result.reqParams.invTimeBegin!''}" readonly="readonly">
                            <em>-</em>
                            <em>-</em>
                            <input name="endDate" id="endDate" type="text" placeholder="结束时间"  value = "${result.reqParams.invTimeEnd!''}" readonly="readonly">
                        </div>
                    </div>
                </div>
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
            </div>
            <!-- 隐式请求参数-->
            <form id="invEventCond" action="/crm/invevent" method="post">
                <input name="regionCode" id="regionCode" type="hidden" value = "${result.reqParams.regionCode!''}">
                <input name="invTimeBegin" id="invTimeBegin" type="hidden" value = "${result.reqParams.invTimeBegin!''}">
                <input name="invTimeEnd" id="invTimeEnd" type="hidden" value = "${result.reqParams.invTimeEnd!''}">
                <input type="hidden" name="pageIndex" id="pageIndex" value="">
            </form>

            <div class="result-count">
                <p>共找到 <span>${result.totalRecCount!''}</span>条相关结果 </p>
            </div>

            <div class="portlet box blue-hoki">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-globe"></i>中国投融资数据库
                    </div>
                    <div class="tools">
                    </div>
                </div>
                <div class="portlet-body">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>
                                融资时间
                            </th>
                            <th>
                                产品
                            </th>
                            <th>
                                公司
                            </th>
                            <th>
                                轮次
                            </th>
                            <th>
                                金额
                            </th>
                            <th>
                                行业
                            </th>
                            <th>
                                投资方
                            </th>
                            <th>
                                所属地域
                            </th>
                            <th>
                                标签
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list result.invListContents as invevent>
                        <tr>
                            <td>
                            ${invevent.trDate?if_exists}
                            </td>
                            <td>
                            ${invevent.productName?if_exists}
                            </td>
                            <td>
                            ${invevent.enterpriseName?if_exists}
                            </td>
                            <td>
                            ${invevent.rounds?if_exists}
                            </td>
                            <td>
                            ${invevent.trAmt?if_exists}
                            </td>
                            <td>
                            ${invevent.industry?if_exists}
                            </td>
                            <td>
                            ${invevent.investment?if_exists}
                            </td>
                            <td>
                            ${invevent.area?if_exists}
                            </td>
                            <td>
                            ${invevent.mark?if_exists}
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="container paging">
                    <div class="pagination"></div>
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

<!-- added by yingsl on 20170523 -->
<script src="/dist/js/jquery.pagination.js"></script>
<script src="/dist/js/jquery-ui.min.js"></script>
<script src="/dist/js/datepicker-zh-CN.js"></script>
<script src="/dist/js/filter_invevent.js"></script>
<script src="/dist/js/data_select.js"></script>
<script>
    // 分页
    $('.pagination').pagination({
                pageCount: ${result.totalPageCount?replace(',','')},
                count: ${result.totalPageCount?replace(',','')} == 4 ? 3 : 2,
            current:  ${result.reqParams.pageIndex?replace(',','')!1},
    coping: true,
            jump: true,
            jumpBtn: '确定'
    });
    var $paging = $('.pagination');
    var $pageIndex = $('#pageIndex');
    $paging.on('click', 'a', function() {
        var cur = 0;
        if ($(this).hasClass('jump-btn')) {
            cur = $(this).siblings('input[type="text"]').val();
        } else {
            cur = $paging.find('.active').text();
        }
        $pageIndex.val(cur);
//        console.log(cur);
        $('#invEventCond').submit();
    });

    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        Demo.init(); // init demo features
    });
</script>
</body>
</html>


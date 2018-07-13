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
    <link href="/dist/css/crm.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/bootstrap-table-expandable.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/jquery-ui.min.css" rel="stylesheet">   <!--时间控件样式-->

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
<#assign page=25/>
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
                        <a href="#">客户关系管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">营销管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="/crm/actmanage/viewall">活动管理</a>
                    </li>
                </ul>
            </div>

            <div class="container classification">

                <div class="group rchTime">
                    <div class="head">
                        <h4>活动开始时间</h4>
                        <span data-value="all" <#if req.timeBegin == "all"> class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <div class="period">
                            <input name="startDate" id="startDate" type="text" placeholder="开始时间"
                                   value="${req.timeBegin!''}" readonly="readonly">
                            <em>-</em>
                            <em>-</em>
                            <input name="endDate" id="endDate" type="text" placeholder="结束时间"
                                   value="${req.timeEnd!''}" readonly="readonly">
                        </div>
                    </div>
                </div>
            </div>
        <#if msg??><label style="color: #ff0007"> ${msg}</label></#if>

            <!-- 隐式请求参数-->
            <form id="actListCond" action="/activity/list" method="get">
                <input type="hidden" name="pageIndex" id="pageIndex" value="">
                <input name="timeBegin" id="timeBegin" type="hidden" value="${req.timeBegin!''}"/>
                <input name="timeEnd" id="timeEnd" type="hidden" value="${req.timeEnd!''}">
            </form>

            <!-- BEGIN 列表-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa icon-docs"></i>活动信息
                    </div>
                    <div class="actions">
                        <a href="/activity/detail" class="btn default yellow-stripe">
                            <i class="fa fa-plus"></i>
                            <span class="hidden-480">
								新增活动 </span>
                        </a>

                        <a href="/activity/listExcel" class="btn default yellow-stripe">
                            <i class="fa fa-plus"></i>
                            <span class="hidden-480">
								导出 </span>
                        </a>
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="result-count">
                        <p>当前共有 <span>${result.totalRecCount!''}</span>条 </p>
                    </div>
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr style="background-color: #9ca7b7;">
                            <th width="10%">
                                发起分公司
                            </th>
                            <th width="4%">
                                活动归类
                            </th>
                            <th width="18%">
                                活动名
                            </th>
                            <th width="17%">
                                活动开展时间
                            </th>
                            <th width="25%">
                                活动举办地点
                            </th>
                            <th width="8%">
                                我司角色
                            </th>
                            <th width="8%">
                                活动类型
                            </th>
                            <th width="4%">
                                参与人数
                            </th>
                            <th width="8%">
                                编辑
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list result.crmActives as actList>
                        <tr>
                            <td>
                            ${actList.company?if_exists}
                            </td>
                            <td>
                            ${actList.bizLv1Id?if_exists}
                            </td>
                            <td>
                            ${actList.actName?if_exists}
                            </td>
                            <td>
                            ${actList.beginTime?if_exists}至${actList.endTime?if_exists}
                            </td>
                            <td>
                            ${actList.actLocation?if_exists}
                            </td>
                            <td>
                            ${actList.usRole?if_exists}
                            </td>
                            <td>
                            ${actList.actType?if_exists}
                            </td>
                            <td>
                            ${actList.joinPersons?if_exists}
                            </td>
                            <td><a target="_blank" href="/activity/detail?recId=${actList.recId?if_exists}">编辑</a> </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="container paging">
                    <div class="pagination"></div>
                </div>
            </div>
            <!-- END 订单列表-->
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
<!-- added by yingsl on 20170523 分页-->
<script src="/dist/js/jquery.pagination.js"></script>
<script src="/dist/js/jquery-ui.min.js"></script>
<script src="/dist/js/crm.js?v=1"></script>
<!--点击表格行向下弹出其他内容-->
<script src="/dist/js/bootstrap-table-expandable.js"></script>

<script>
    // 分页
    $('.pagination').pagination({
                pageCount: ${result.totalPageCount?replace(',','')},
                count: ${result.totalPageCount?replace(',','')} == 4 ? 3 : 2,
            current:  ${req.pageIndex?replace(',','')!1},
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
        $('#actListCond').submit();
    });

    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
    });


    // 时间选择
    $('#startDate').datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'yy-mm-dd',
        onSelect: function(startVal) {
            var endVal = $('#endDate').val();
            if (endVal) {
                var startTime = (new Date(startVal)).getTime();
                var endTime = (new Date(endVal)).getTime();
                var diff = endTime - startTime;
                if (diff < 0) {
                    alert('结束时间必须大于开始时间');
                    $(this).val('');
                } else {
                    // console.log(startVal, endVal);
                    $('#timeBegin').val(startVal);
                    $('#startTime').val(startVal);
                    $('#actListCond').submit();
                }
            } else {
                $('#timeBegin').val(startVal);
                $('#startTime').val(startVal);
            }
        }
    });

    $('#endDate').datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: 'yy-mm-dd',
        onSelect: function(endVal) {
            var startVal = $('#startDate').val();
            if (startVal) {
                var startTime = (new Date(startVal)).getTime();
                var endTime = (new Date(endVal)).getTime();
                var diff = endTime - startTime;
                if (diff < 0) {
                    alert('结束时间必须大于开始时间');
                    $(this).val('');
                } else {
                    //console.log(startVal, endVal);
                    $('#timeEnd').val(endVal);
                    $('#endTime').val(endVal);
                    $('#actListCond').submit();
                }
            } else {
                alert('请选择开始时间');
                $('#timeEnd').val(endVal);
                $('#endTime').val(endVal);
            }
        }
    });
    $('.rchTime span').click(function() {
        $('#timeBegin').val("all");
        $('#timeEnd').val("all");
        $('#actListCond').submit();
    });
</script>
</body>
</html>
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

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo" onload="autoRowSpan(tb,0,0)">
<!-- 引入页面头部主菜单 -->
<#assign page=13/>
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
                        <a href="#">企业信息维护</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">档案更新企业</a>
                    </li>
                </ul>
            </div>

            <!-- 隐式请求参数-->
            <form id="uptentListCond" action="/crm/enterpriseupt/viewupt" method="post">
                <input type="hidden" name="pageIndex" id="pageIndex" value="">
            </form>

            <!-- BEGIN 列表-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <span class="glyphicon glyphicon-star"></span>已更新档案企业
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="result-count">
                        <p>当前共有 <span>${result.totalRecCount!''}</span>条 </p>
                    </div>
                    <table class="table table-bordered table-hover" id="tb">
                        <thead>
                        <tr style="background-color: #9ca7b7;">
                            <th width="5%">
                                更新ID
                            </th>
                            <th width="28%">
                                企业名称
                            </th>
                            <th width="20%">
                                更新模块
                            </th>
                            <th width="20%">
                                最近更新时间
                            </th>
                            <th width="8%">
                                更新人
                            </th>
                            <th width="8%">
                                所属分公司
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list result.entuptListContents as entuptList>
                        <tr>
                            <td>
                            ${entuptList.id?c?if_exists}
                            </td>
                            <td>
                                <a href="/crm/enterprisedetail/view?reg_credit_no=${entuptList.regCreditNo?if_exists}" id="${entuptList.regCreditNo?if_exists}" >${entuptList.enterpriseName?if_exists}</a>
                            </td>
                            <td>
                            ${entuptList.editModule?if_exists}
                            </td>
                            <td>
                            ${entuptList.updateTime?if_exists}
                            </td>
                            <td>
                            ${entuptList.archivesEditor?if_exists}
                            </td>
                            <td>
                            ${entuptList.company?if_exists}
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
<script src="/dist/js/crm.js?v=1"></script>
<!-- added by yingsl on 20170523 分页-->
<script src="/dist/js/jquery.pagination.js"></script>

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
        $('#uptentListCond').submit();
    });

    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        Demo.init(); // init demo features
    });

    //表格相同行合并
    function autoRowSpan(tb,row,col)
    {
        var lastValue="";
        var value="";
        var pos=1;
        for(var i=row;i<tb.rows.length;i++){
            value = tb.rows[i].cells[col].innerText;
            if(lastValue == value){
                tb.rows[i].deleteCell(col);
                tb.rows[i-pos].cells[col].rowSpan = tb.rows[i-pos].cells[col].rowSpan+1;
                pos++;
            }else{
                lastValue = value;
                pos=1;
            }
        }
    }
</script>
</body>
</html>


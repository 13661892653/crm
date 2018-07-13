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

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
<#assign page=51/>
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
                        <a href="/crm/contractmanage/viewall">合同管理</a>
                    </li>
                </ul>
            </div>

        <#if msg??><label style="color: #ff0007"> ${msg}</label></#if>

            <!-- 隐式请求参数-->
            <form id="contractListCond" action="/crm/contractmanage/viewall" method="post">
                <input type="hidden" name="pageIndex" id="pageIndex" value="">
            </form>

            <!-- BEGIN 列表-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa icon-docs"></i>合同信息
                    </div>
                    <div class="actions">
                        <a href="/crm/contractmanage/addcontract" class="btn default yellow-stripe">
                            <i class="fa fa-plus"></i>
                            <span class="hidden-480">
								新增合同 </span>
                        </a>
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="result-count">
                        <p>当前共有 <span>${result.totalRecCount!''}</span>条 </p>
                    </div>
                    <table class="table table-bordered table-hover table-expandable">
                        <thead>
                        <tr style="background-color: #9ca7b7">
                            <th width: 5%>
                                归属
                            </th>
                            <th width: 5%>
                                模块
                            </th>
                            <th width: 5%>
                                合同编号
                            </th>
                            <th width: 12%>
                                合同标题
                            </th>
                            <th width: 20%>
                                合同主体
                            </th>
                            <th width: 5%>
                                签订日期
                            </th>
                            <th width: 6%>
                                金额（万元）
                            </th>
                            <th width: 6%>
                                到账（万元）
                            </th>
                            <th width: 6%>
                                利润（万元）
                            </th>
                            <th width: 5%>
                                利润率
                            </th>
                            <!--
                            <th>
                                预计到账日期
                            </th>
                            -->
                            <th>
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list result.contractListContents as contractList>
                        <tr>
                            <td>
                            ${contractList.company?if_exists}
                            </td>
                            <td>
                            ${contractList.bizLv1Name?if_exists}
                            </td>
                            <td>
                            ${contractList.contractNo?if_exists}
                            </td>
                            <td>
                            ${contractList.contractTitle?if_exists}
                            </td>
                            <td>
                            ${contractList.contractEnterprise?if_exists}
                            </td>
                            <td>
                            ${contractList.contractDate?if_exists}
                            </td>
                            <td>
                            ${contractList.contractAmt?if_exists}
                            </td>
                            <td>
                            ${contractList.income?if_exists}
                            </td>
                            <td>
                            ${contractList.profit?if_exists}
                            </td>
                            <td>
                            ${contractList.profitRate?if_exists}
                            </td>
                            <#--
                            <td>${contractList.incomeExpDate?if_exists}</td>
                            -->
                            <td>
                            <#if (contractList.operator)==(user.userName)>
                                <a href="#" id="${contractList.contractNo?if_exists}" onclick="editcontract(this)"><span class="glyphicon glyphicon-pencil" title="修改合同"></span></a>
                            </#if>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="12" style="color: #0b6694">
                            合同类型：
                            <#if contractList.contractType=="CONT01">订单合同
                            <#elseif contractList.contractType=="CONT02">合作伙伴合同
                            <#elseif contractList.contractType=="CONT03">政府合同
                            <#elseif contractList.contractType=="CONT04">公司采购合同
                            </#if>
                                <br>
                            订单编号：${contractList.orderNo?if_exists}
                                <br>
                            产品名称：${contractList.orderProdName?if_exists}
                                <br>
                            合作伙伴名称：${contractList.partnerName?if_exists}
                                <br>
                            备注：${contractList.remark?if_exists}
                                <br>
                            附近：${contractList.linkAddress?if_exists}
                                <br>
                            操作人：${contractList.operator?if_exists}
                                <br>
                            最近更新日期：${contractList.updateTime?if_exists}
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
        $('#contractListCond').submit();
    });

    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        Demo.init(); // init demo features
    });
</script>
</body>
</html>
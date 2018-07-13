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
<#assign page=41/>
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
                        <a href="/crm/ordermanage/viewall">订单管理</a>
                    </li>
                </ul>
            </div>
            <!-- 隐式请求参数-->
            <form id="orderListCond" action="/crm/ordermanage/viewall" method="post">
                <input name="regCreditNo" id="regCreditNo" type="hidden" value = "${result.reqParams.regCreditNo!''}"/>
                <input type="hidden" name="pageIndex" id="pageIndex" value="">
            </form>

            <!-- BEGIN 订单列表-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-shopping-cart"></i>订单列表
                    </div>
                    <div class="actions">
                        <a href="/crm/ordermanage/addorder" class="btn default yellow-stripe">
                            <i class="fa fa-plus"></i>
                            <span class="hidden-480">
								新增订单 </span>
                        </a>
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="result-count">
                        <p>当前共有 <span>${result.totalRecCount!''}</span>条订单 </p>
                    </div>
                    <table class="table table-bordered table-hover table-expandable" id="tbl">
                        <thead>
                        <tr style="background-color: #9ca7b7;">
                            <th width="8%">
                                订单编号
                            </th>
                            <th width="12%">
                                下单日期
                            </th>
                            <th width="8%">
                                下单人
                            </th>
                            <th width="23%">
                                订单客户
                            </th>
                            <th width="11%">
                                订单商品
                            </th>
                            <th width="8%">
                                订单金额
                            </th>
                            <th width="8%">
                                完成进度
                            </th>
                            <th width="12%">
                                完成时间
                            </th>
                            <th>
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list result.ordListContents as orderList>
                        <tr>
                            <td>
                            ${orderList.orderNo?if_exists}
                            </td>
                            <td>
                            ${orderList.orderDate?if_exists}
                            </td>
                            <td>
                            ${orderList.orderMemeberName?if_exists}
                            </td>
                            <td>
                            ${orderList.enterpriseName?if_exists}
                            </td>
                            <td>
                            ${orderList.bizLv2Name?if_exists}-${orderList.bizLv3Name?if_exists}-${orderList.orderProdName?if_exists}
                            </td>
                            <td>
                            ${orderList.orderAmt?if_exists}
                            </td>
                            <td>
                                <#if orderList.progress??>
                                    <#if orderList.progress?contains("100")>
                                    ${orderList.progress}
                                    <#else>
                                    ${orderList.progress}&nbsp;<span style="color:#ff0000;font-weight: bold">(未100%)</span>
                                    </#if>
                                <#else>
                                    <span style="color:#ff0000;font-weight: bold">未100%</span>
                                </#if>
                            </td>
                            <td>
                                <#if orderList.closeTime??>${orderList.closeTime}<#else><span style="color:#ff0000;font-weight: bold">未完成</span></#if>
                            </td>
                            <td>
                                <#if (orderList.merchandiser)==(user.userName)>
                                    <a href="#" id="${orderList.orderNo?if_exists}" onclick="vieworder(this)"><span class="glyphicon glyphicon-pencil" title="编辑订单"></span></a>
                                <#--
                                <#if (orderList.merchandiser)??><#else>
                                    <a href="#" id="${orderList.orderNo?if_exists}" onclick="assignmdr(this)"><span class="glyphicon glyphicon-compressed" title="分配跟单人"></span> </a>
                                </#if>
                                -->
                                </#if>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="10" style="color: #0b6694">
                                一级业务类目：${orderList.bizLv1Name?if_exists}
                                <br>
                                采购数量：${orderList.orderNum?if_exists}
                                <br>
                                订单单价（元）：${orderList.orderPrice?if_exists}
                                <br>
                                是否自营订单：
                                <#if orderList.isSelfBiz == "Y">是
                                <#else>否
                                </#if>
                                <br>
                                平台服务商：${orderList.partnerName?if_exists}
                                <br>
                                服务商对接时间：${orderList.dockingTime?if_exists}
                                <br>
                                支付方式：${orderList.payMode?if_exists}
                                <br>
                                支付状态：${orderList.payStatus?if_exists}
                                <br>
                                订单状态：${orderList.orderStatus?if_exists}
                                <br>
                                备注：${orderList.remark?if_exists}
                                <br>
                                跟单人：${orderList.merchandiser?if_exists}
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
        $('#orderListCond').submit();
    });

    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        Demo.init(); // init demo features
    });
</script>
</body>
</html>

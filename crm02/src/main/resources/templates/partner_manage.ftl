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
<#assign page=61/>
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
                        <a href="/crm/partnermanage/viewall">合作伙伴管理</a>
                    </li>
                </ul>
            </div>

            <div class="form-body">
                    <div class="form-group">
                        <label class="control-label col-md-2">合作伙伴名称：</label>
                        <input id="searchinput" name="searchinput" type="text" class="control-label col-md-2" placeholder="请输入合作伙伴名称" value = "${result.reqParams.corpName!''}"/>
                        <label class="control-label col-md-1">&nbsp;</label>
                        <div class="search">
                            <input type="button" value="检索" class="btn blue"/>
                        </div>
                    </div>
            </div>

            <hr style=" height:2px;border:none;border-top:2px dotted #185598;" />

        <#if msg??><label style="color: #ff0007"> ${msg}</label></#if>

            <!-- 隐式请求参数-->
            <form id="partnerCond" action="/crm/partnermanage/viewall" method="post">
                <input name="regionCode" id="regionCode" type="hidden" value = "${result.reqParams.regionCode!''}"/>
                <input name="corpName" id="corpName" type="hidden" value = "${result.reqParams.corpName!''}"/>
                <input type="hidden" name="pageIndex" id="pageIndex" value="">
            </form>

            <!-- BEGIN 订单列表-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="actions">
                        <a href="/crm/partnermanage/add" class="btn default yellow-stripe">
                            <i class="fa fa-plus"></i>
                            <span class="hidden-480">
								添加合作伙伴 </span>
                        </a>
                    </div>
                </div>
                <div class="result-count">
                    <p>共找到 <span>${result.totalRecCount!''}</span>条相关结果 </p>
                </div>
                <div class="portlet-body">
                    <table class="table table-bordered table-hover table-expandable">
                        <thead>
                        <tr style="background-color: #9ca7b7;">
                            <th width: 5%>
                                归属
                            </th>
                            <th width: 22%>
                                名称
                            </th>
                            <th width: 15%>
                                服务区域
                            </th>
                            <th width: 13%>
                                品类
                            </th>
                            <th width: 15%>
                                服务费
                            </th>
                            <th width: 10%>
                                入网时间
                            </th>
                            <th width: 10%>
                                合同到期日
                            </th>
                            <th width: 10%>
                                是否有效
                            </th>
                            <#--<th>
                                操作
                            </th>-->
                        </tr>
                        </thead>
                        <tbody>
                        <#if result.partnerListContents??>
                        <#list result.partnerListContents as partner>
                        <tr>
                            <td>
                                <#if partner.company??>${partner.company}</#if>
                            </td>
                            <td>
                                <#if partner.partnerName??>${partner.partnerName}</#if>
                            </td>
                            <td>
                                <#if partner.srvArea??>${partner.srvArea}</#if>
                            </td>
                            <td>
                                <#if partner.category??>${partner.category}</#if>
                            </td>
                            <td>
                                <#if partner.feePoint??>${partner.feePoint}</#if>
                            </td>
                            <td>
                                <#if partner.joinTime??>${partner.joinTime}</#if>
                            </td>
                            <td>
                                <#if partner.rescindTime??>${partner.rescindTime}</#if>
                            </td>
                            <td>
                                <#if partner.validFlag??&&(partner.validFlag='Y')>是<#else>否</#if>
                            </td>
                            <#--<td>
                                <a href="#" id="${partner.partnerId?if_exists}" onclick="editPartner(this)"><span class="glyphicon glyphicon-pencil" title="编辑"></span></a>
                            </td>-->
                        </tr>
                        <tr>
                            <td colspan="13" style="color: #0b6694">
                                合作伙伴编号：<#if partner.partnerId??>${partner.partnerId}</#if>
                                <br>
                                类型：<#if partner.partnerType??&&(partner.partnerType='1')>平台服务商
                                      <#elseif partner.partnerType??&&(partner.partnerType='2')>渠道商
                                      </#if>
                                <br>
                                级别：<#if partner.partnerLvDesc??>${partner.partnerLvDesc}</#if>
                                <br>
                                企业注册地址：<#if partner.entAddress??>${partner.entAddress}</#if>
                                <br>
                                办公地址：<#if partner.officeAddress??>${partner.officeAddress}</#if>
                                <br>
                                联系人：<#if partner.contactPerson??>${partner.contactPerson}</#if>
                                <br>
                                联系电话：<#if partner.contactPhone??>${partner.contactPhone}</#if>
                                <br>
                                邮箱：<#if partner.email??>${partner.email}</#if>
                                <br>
                                银行账户：<#if partner.bankAccount??>${partner.bankAccount}</#if>
                                <br>
                                业务范围：<#if partner.bizScope??>${partner.bizScope}</#if>
                                <br>
                                合同编号：<#if partner.contractNo??>${partner.contractNo}</#if>
                                <br>
                                备注：<#if partner.remark??>${partner.remark}</#if>
                            </td>
                        </tr>
                        </#list>
                        </#if>
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
<script src="/dist/js/filter_partner.js"></script>
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
        $('#partnerCond').submit();
    });

    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
    });
</script>
</body>
</html>


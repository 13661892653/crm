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
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
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
                        <a href="#">企业收藏夹</a>
                    </li>
                </ul>
            </div>

        <#if msg??><label style="color: #ff0007">${msg}</label></#if>

            <!-- 隐式请求参数-->
            <form id="favListCond" action="/crm/enterprisefav/viewfav" method="post">
                <#--<input name="entType" id="entType" type="hidden" value = "${result.reqParams.entType!''}"/>-->
                <input type="hidden" name="pageIndex" id="pageIndex" value="">
            </form>

            <!-- 隐式请求参数-->
            <form id="uptcustMgr" action="/crm/enterprisefav/uptcustMgr" method="post">
                <input name="userName" id="userName" type="hidden" <#if form??> value = "${form.userName}" <#else> value = "" </#if>/>
                <input name="memberId" id="memberId" type="hidden" <#if form??> value = "${form.memberId}" <#else> value = "" </#if>/>
                <input name="regCreditNo" id="regCreditNo" type="hidden" <#if form??> value = "${form.regCreditNo}" <#else> value = "" </#if>/>
            </form>
            <!-- BEGIN 订单列表-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <span class="glyphicon glyphicon-star"></span>企业收藏夹
                    </div>
                    <div class="actions">
                        <a  id="piLiang" class="btn default yellow-stripe">
                            <i class="fa fa-plus"></i>
                            <span class="hidden-480">
                             批量企服</span>
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
                            <th width="3%">
                                <input type="checkbox" id="allSel">
                            </th>
                            <th width="8%">
                                收藏人
                            </th>
                            <th width="8%">
                                收藏公司
                            </th>
                            <th width="28%">
                                企业名称
                            </th>
                            <th width="20%">
                                行业
                            </th>
                            <th width="8%">
                                企服人员
                            </th>
                            <th width="8%">
                                资料完整分
                            </th>
                            <th width="6%">
                                财税数据
                            </th>
                            <th>
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list result.favListContents as favList>
                        <tr>
                            <td>
                                <input type="checkbox"  class="checkbox_sel" reg_credit_no=" ${favList.regCreditNo?if_exists}">
                            </td>
                            <td>
                            ${favList.favUserList?if_exists}
                            </td>
                            <td>
                            ${favList.company?if_exists}
                            </td>
                            <td>
                                 <a href="/crm/enterprisedetail/view?reg_credit_no=${favList.regCreditNo?if_exists}" id="${favList.regCreditNo?if_exists}">${favList.enterpriseName?if_exists}</a>
                            </td>
                            <td>
                            ${favList.industryName?if_exists}
                            </td>
                            <td>
                            ${favList.custManager?if_exists}
                            </td>
                            <td>
                            ${favList.matCompScore?if_exists}
                            </td>
                            <td>
                                <#if (favList.isHaveFinance)??>
                                    <#if (favList.isHaveFinance) == 'Y'>
                                        <span class="badge badge-success">有 </span>
                                    <#else>
                                        <span class="badge badge-danger">无 </span>
                                    </#if>
                                <#else>
                                    <span class="badge badge-danger">无 </span>
                                </#if>
                            </td>
                            <td>
                                <a href="#" class="btn default btn-xs red-pink-stripe" id="${favList.regCreditNo?if_exists}"">企服 </a>&nbsp;
                                <a href="#" class="btn default btn-xs blue-stripe" id="${favList.regCreditNo?if_exists}" onclick="showRchList(this)">触达 </a>&nbsp;
                                <a href="#" class="btn default btn-xs purple-stripe" id="${favList.regCreditNo?if_exists}" onclick="showEntOrder(this)">订单 </a>
                            </td>
                        </tr>
                        </#list>
                        <div class="overlay" id="companyemp">
                            <div class="popup mgr-popup">
                                <i class="close"></i>
                                <div class="popup-title">
                                    <h4>请选择要分配的企服人员</h4>
                                </div>
                                </br>
                                <div>
                                    <select id="userNameSel" name="userName" class="form-control input-medium" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                    <#list companyUserList as userList>
                                        <option value="${userList.userName?if_exists}--${userList.memberId?if_exists?c}">${userList.userName?if_exists}</option>
                                    </#list>
                                        <option value="" style="color: red">取消企服</option>
                                    </select>
                                </div>
                                </br>
                                <div>
                                    <input type="button" class="btn blue" value="修改" id="updatebtn"/>
                                </div>
                            </div>
                        </div>
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
        $('#favListCond').submit();
    });

    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
    });

    $("#piLiang").click(function () {
        var regCreditNoArr=[];
       $(".checkbox_sel:checkbox:checked").each(function () {
            regCreditNoArr.push($(this).attr("reg_credit_no"));
       })
        if(regCreditNoArr.length==0){
           alert("请选择企业");
           return;
        }
        $('.overlay').show();
        $('.mgr-popup').show();
        $('html, body').css('overflow-y', 'hidden');
        $("#companyemp").data('regCreditNo',regCreditNoArr.join(",")); //把收藏regCreditNo赋给层
    });

    /**
     * 全选
     */
    $("#allSel").click(function () {
        if($(this).prop("checked")){
            $(".checkbox_sel").prop("checked",true);
        }else{
            $(".checkbox_sel").prop("checked",false);
        }
    });
</script>
</body>
</html>
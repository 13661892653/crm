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
    <link href="/dist/css/plugins1.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/layout.css" rel="stylesheet" type="text/css"/>
    <!-- <link href="/dist/css/default.css" rel="stylesheet" type="text/css" id="style_color" /> -->
    <link href="/dist/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="/dist/css/custom.css" rel="stylesheet" type="text/css"/>
    <!-- added by yingsl on 20170523 -->
    <link href="/dist/css/enterprisebank.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/jquery-ui.min.css" rel="stylesheet" >

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
<#assign page=210/>
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
                        <a href="#">企业信息库</a>
                    </li>
                </ul>
            </div>
            <div class="container classification">


                <div class="group regionCode">
                    <div class="head">
                        <h4>地区</h4>
                    <#if (result.reqParams.memberType == "1")||result.reqParams.memberType == "2">
                        <span data-value="all"  <#if result.reqParams.regionCode == "all">class="all" </#if>>全部</span>
                    </#if>
                    </div>
                    <div class="body">
                    <#if (result.reqParams.memberType == "1")||result.reqParams.memberType == "2">
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
                        <span data-value="宁波" <#if result.reqParams.regionCode == "宁波">class="cur" </#if> >宁波</span>
                        <span data-value="北美" <#if result.reqParams.regionCode == "北美">class="cur" </#if> >北美</span>
                        <span data-value="未分配" <#if result.reqParams.regionCode == "未分配">class="cur" </#if> >未分配</span>
                    </#if>
                    <#if result.reqParams.memberType == "90">
                        <span data-value="${result.reqParams.company}" <#if result.reqParams.regionCode == result.reqParams.company>class="cur" </#if> >${result.reqParams.company}</span>
                    </#if>
                    </div>
                </div>
                <div class="group industryName">
                    <div class="head">
                        <h4>所属行业</h4>
                        <span data-value="all"  <#if result.reqParams.industryName == "all"> class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <div class="industry">
                            <p><#if result.reqParams.industryName == "all">请选择行业类别<#else>${result.reqParams.industryName?if_exists}</#if></p>
                            <div class="industry-panel">
                                <ul class="industry-box"></ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="group bankGqScore">
                    <div class="head">
                        <h4>高企评分</h4>
                        <span data-value="all" <#if result.reqParams.beginScore == "all" &&  result.reqParams.beginScore == "all"> class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <div class="period">
                            <input name="beginScore" id="beginTmpScore" type="number" placeholder="最小分数"
                                   value="${result.reqParams.beginScore!''}" >
                            <em>-</em>
                            <em>-</em>
                            <input name="endScore" id="endTmpScore" type="number" placeholder="最大分数"
                                   value="${result.reqParams.endScore!''}" >
                        </div>
                    </div>
                </div>
                <div class="group isHaveFinance">
                    <div class="head">
                        <h4>财税数据</h4>
                        <span data-value="all" <#if result.reqParams.isHaveFinance == "all">class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <span data-value="Y" <#if result.reqParams.isHaveFinance == "Y">class="cur" </#if> >有</span>
                        <span data-value="N" <#if result.reqParams.isHaveFinance == "N">class="cur" </#if> >无</span>
                    </div>
                </div>
            <#--<div class="group assetsLevel">
                <div class="head">
                    <h4>资产等级</h4>
                    <span  data-value="all" <#if result.reqParams.assetsLevel == "all">class="all" </#if>>全部</span>
                </div>
                <div class="body">
                    <span data-value="1" <#if result.reqParams.assetsLevel == "1">class="cur" </#if> >高价值企业</span>
                    <span data-value="2" <#if result.reqParams.assetsLevel == "2">class="cur" </#if> >成长之星</span>
                    <span data-value="99999" <#if result.reqParams.assetsLevel == "99999">class="cur" </#if> >未分级</span>
                </div>
            </div>-->
                <div class="group entTag">
                    <div class="head">
                        <h4>企业标签</h4>
                        <span data-value="all"  <#if result.reqParams.assetsTagCode == "all"> class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                    <#list enterpriseTagList as enttag>
                        <span data-value="${enttag.assetsTagCode?if_exists}" <#if result.reqParams.assetsTagCode == enttag.assetsTagCode> class="cur" </#if> >${enttag.assetsTagDesc?if_exists}</span>
                    </#list>
                    </div>
                </div>
                <br>
                <br>
                <div class="group entType">
                    <div class="head">
                        <h4>企业分层</h4>
                        <span data-value="all" <#if result.reqParams.entType == "all">class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <span data-value="basic" <#if result.reqParams.entType == "basic"> class="cur" </#if> >基础企业</span>
                        <span data-value="4002" <#if result.reqParams.entType == "4002"> class="cur" </#if> >目标企业</span>
                        <span data-value="4003" <#if result.reqParams.entType == "4003"> class="cur" </#if> >核心企业</span>
                    </div>
                </div>
                <div class="group isSetEntSrv">
                    <div class="head">
                        <h4>是否分配企服</h4>
                        <span data-value="all" <#if result.reqParams.isSetEntSrv == "all">class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <span data-value="Y" <#if result.reqParams.isSetEntSrv == "Y">class="cur" </#if> >已分配</span>
                        <span data-value="N" <#if result.reqParams.isSetEntSrv == "N">class="cur" </#if> >未分配</span>
                    </div>
                </div>
                <!--
                <div class="group">
                    <div class="head">
                        <h4>信隆行业务场景</h4>
                        <span class="all">全部</span>
                    </div>
                    <div class="body" id="service">
                        <span id="sv1">股权融资需求</span>
                        <span id="sv2">大赛</span>
                        <span id="sv3">商业计划书制作</span>
                        <span id="sv4">导师问诊</span>
                        <span id="sv5">科技贷款</span>
                        <span id="sv5">数据报告</span>
                        <span id="sv5">导师输出</span>
                        <span id="sv5">债权融资需求</span>
                        <span id="sv5">企业上云</span>
                    </div>
                </div>
                -->
                </div>
            <br>
            <div class="form-body">
                <div class="form-group">
                    <label class="control-label col-md-2">企业名称：</label>
                    <input id="searchinput" name="searchinput" type="text" class="control-label col-md-2" placeholder="请输入企业名称" value = "${result.reqParams.corpName!''}"/>
                    <label class="control-label col-md-1">&nbsp;</label>
                    <div class="search">
                        <input type="button" value="检索" class="btn blue"/>
                    </div>
                </div>
            </div>
            <#--<hr style=" height:2px;border:none;border-top:2px dotted #185598;" />
            <div class="group">
                <input type="text" placeholder="输入企业订阅标签名" value = ""> <input type="button" value="添加订阅标签" class="btn blue" id="ent_sub" onclick=""/>
            </div>-->

            <!-- 隐式请求参数-->
            <form id="entBankCond" action="/crm/enterprisebank" method="post">
                <input name="assetsFlag" id="assetsFlag" type="hidden" value = "${result.reqParams.assetsFlag!''}"/>
                <input name="regionCode" id="regionCode" type="hidden" value = "${result.reqParams.regionCode!''}"/>
                <input name="isHaveFinance" id="isHaveFinance" type="hidden" value = "${result.reqParams.isHaveFinance!''}"/>
                <input name="beginScore" id="beginScore" type="hidden" value = "${result.reqParams.beginScore!''}"/>
                <input name="endScore" id="endScore" type="hidden" value = "${result.reqParams.endScore!''}"/>
                <input name="isSetEntSrv" id="isSetEntSrv" type="hidden" value = "${result.reqParams.isSetEntSrv!''}"/>
                <input name="assetsLevel" id="assetsLevel" type="hidden" value = "${result.reqParams.assetsLevel!''}"/>
                <input name="assetsTagCode" id="assetsTagCode" type="hidden" value = "${result.reqParams.assetsTagCode!''}"/>
                <input name="industryName" id="industryName" type="hidden" value = "${result.reqParams.industryName!''}"/>
                <input name="corpName" id="corpName" type="hidden" value = "${result.reqParams.corpName!''}"/>
                <input name="entType" id="entType" type="hidden" value = "${result.reqParams.entType!''}"/>
                <input type="hidden" name="pageIndex" id="pageIndex" value="">
            </form>

            <!-- BEGIN 数据展示区-->
            <div class="portlet">
                <div class="portlet-body">
                    <div class="result-count">
                        <p>共找到 <span>${result.totalRecCount!''}</span>条相关结果 </p>
                    </div>
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr style="background-color: #9ca7b7;">
                            <th width="6%">
                                高企评分
                            </th>
                            <th width="7%">
                                财税数据
                            </th>
                            <th width="20%">
                                行业
                            </th>
                            <th width="26%">
                                企业名称
                            </th>
                            <th width="17%">
                                经营状态
                            </th>
                            <th width="30%">
                                企业地址
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list result.entListContents as enterprise>
                        <tr>
                            <td>
                            ${enterprise.gqScore?if_exists}
                            </td>
                            <td>
                                <#if (enterprise.isHaveFinance)??>
                                    <#if (enterprise.isHaveFinance) == 'Y'>
                                        <span class="badge badge-success">有 </span>
                                    <#else>
                                        <span class="badge badge-danger">无 </span>
                                    </#if>
                                </#if>
                            </td>
                            <td>
                            ${enterprise.industryName?if_exists}
                            </td>
                            <td>
                                <#if (enterprise.tagArray)??>
                                    <#if enterprise.tagArray?contains("4003")><span class="icon-star" style="color: red"></span>&nbsp;<span class="icon-star" style="color: red"></span>&nbsp;<span class="icon-star" style="color: red"></span>
                                    <#elseif enterprise.tagArray?contains("4002")><span class="icon-star" style="color: #aa1ee6"></span>&nbsp;<span class="icon-star" style="color: #aa1ee6"></span>
                                    <#else><span class="icon-star" style="color: #ddb04a"></span></span>
                                    </#if>
                                <#else><span class="icon-star" style="color: #ddb04a"></span></span>
                                </#if>
                                <a href="/crm/enterprisedetail/view?reg_credit_no=${enterprise.regCreditNo?if_exists}" id="${enterprise.regCreditNo?if_exists}" target="_blank" ">${enterprise.enterpriseName?if_exists}</a>
                            </td>
                            <td>
                            ${enterprise.mgmtStatus?if_exists}
                            </td>
                            <td>
                            ${enterprise.entAddress?if_exists}
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
    </div>
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
<script src="/dist/js/filter_entbank.js"></script>
<script src="/dist/js/data_select.js"></script>
<script src="/dist/js/crm.js?v=1"></script>

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
        $('#entBankCond').submit();
    });

    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
    });
</script>
</body>
</html>

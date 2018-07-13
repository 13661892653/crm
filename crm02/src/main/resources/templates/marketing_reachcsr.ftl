<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8"/>
    <title>信隆行CRM系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
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
<#--<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo"-->
<#--onload="autoRowSpan(tb,0,0)">-->
<#--onload="autoRowSpan(tb,0,0)"-->
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo"
      >
<!-- 引入页面头部主菜单 -->
<#assign page=21/>
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
                        <a href="#">营销管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="/crm/marketing/reachcsr/reachlist">客户触达</a>
                    </li>
                </ul>
            </div>
            <div class="container classification">
                <div class="group custType">
                    <div class="head">
                        <h4>触达对象类型</h4>
                    </div>
                    <div class="body">
                        <span data-value="corpCust" <#if result.reqParams.custType == "corpCust">
                              class="cur" </#if>>企业</span>
                        <span data-value="unCorpCust" <#if result.reqParams.custType == "unCorpCust">
                              class="cur" </#if>>非企业</span>
                    <#if user??>
                        <#if '${user.memberType}'=='1'||'${user.memberType}'=='2'||'${user.memberType}'=='10'||'${user.memberType}'=='90'>
                            <!--如果是一般用户不显示下面菜单-->
                            <span data-value="govCust" <#if result.reqParams.custType == "govCust"> class="cur" </#if>>政府</span>
                        </#if>
                    </#if>
                    </div>
                </div>
                <div class="group rchTime">
                    <div class="head">
                        <h4>触达时间</h4>
                        <span data-value="all" <#if result.reqParams.timeBegin == "all"> class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <div class="period">
                            <input name="startDate" id="startDate" type="text" placeholder="开始时间"
                                   value="${result.reqParams.timeBegin!''}" readonly="readonly">
                            <em>-</em>
                            <em>-</em>
                            <input name="endDate" id="endDate" type="text" placeholder="结束时间"
                                   value="${result.reqParams.timeEnd!''}" readonly="readonly">
                        </div>
                    </div>
                </div>
            <#if user??>
                <#if '${user.memberType}'=='1'||'${user.memberType}'=='10'||'${user.memberType}'=='90'>
                    <!--如果是一般用户不显示下面菜单-->
                    <div class="group empName">
                        <div class="head">
                            <h4>触达人</h4>
                            <span data-value="all"  <#if result.reqParams.empName == "all"> class="all" </#if>>全部</span>
                        </div>
                        <div class="body">
                            <#list companyUserList as employee>
                                <span data-value="${employee.userName?if_exists}" <#if result.reqParams.empName == employee.userName>
                                      class="cur" </#if>>${employee.userName?if_exists}</span>
                            </#list>
                        </div>
                    </div>
                </#if>
            </#if>
                <div class="group bizLv1Id">
                    <div class="head">
                        <h4>业务分类</h4>
                        <span data-value="all" <#if result.reqParams.bizLv1Id == "all">class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <#if result.reqParams.custType=="govCust">
                            <span data-value="G" <#if result.reqParams.bizLv1Id == "G">class="cur" </#if>>G各类大赛</span>
                            <span data-value="G2" <#if result.reqParams.bizLv1Id == "G2">class="cur" </#if>>G政府专项</span>
                            <span data-value="T" <#if result.reqParams.bizLv1Id == "T">class="cur" </#if>>T企业上云</span>
                            <span data-value="F" <#if result.reqParams.bizLv1Id == "F">class="cur" </#if>>F科技贷款系统</span>
                        <#else>
                            <span data-value="G" <#if result.reqParams.bizLv1Id == "G">class="cur" </#if>>G</span>
                            <span data-value="T" <#if result.reqParams.bizLv1Id == "T">class="cur" </#if>>T</span>
                            <span data-value="F" <#if result.reqParams.bizLv1Id == "F">class="cur" </#if>>F</span>
                            </#if>
                    </div>
                </div>
                <div class="group bizLv2Id">
                    <div class="head">
                        <h4>政府业务分类</h4>
                        <span data-value="all" <#if result.reqParams.bizLv2Id == "all">class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <span data-value="Z" <#if result.reqParams.bizLv2Id == "Z">class="cur" </#if>>政府专项</span>
                        <span data-value="G" <#if result.reqParams.bizLv2Id == "G">class="cur" </#if>>高企申报</span>
                        <span data-value="Q" <#if result.reqParams.bizLv2Id == "Q">class="cur" </#if>>其他本地化服务</span>
                    </div>
                </div>

                <div class="group hasDemand">
                    <div class="head">
                        <h4>是否有高企需求</h4>
                        <span data-value="all" <#if result.reqParams.hasDemand == "all">class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <span data-value="1" <#if result.reqParams.hasDemand == "1">class="cur" </#if>>是</span>
                        <span data-value="2" <#if result.reqParams.hasDemand == "2">class="cur" </#if>>否</span>
                        <span data-value="" <#if result.reqParams.hasDemand == "">class="cur" </#if>>不确定</span>
                    </div>
                </div>
            <#if result.reqParams.custType != "govCust">
                <div class="group winCustChnl" id="div_winCustChnl">
                    <div class="head">
                        <h4>获客渠道</h4>
                        <span data-value="all"  <#if result.reqParams.winCustChnl == "all"> class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <span data-value="活动" <#if result.reqParams.winCustChnl == "活动">class="cur" </#if>>活动</span>
                        <span data-value="园区" <#if result.reqParams.winCustChnl == "园区">class="cur" </#if>>园区</span>
                        <span data-value="政府" <#if result.reqParams.winCustChnl == "政府">class="cur" </#if>>政府</span>
                        <span data-value="机构" <#if result.reqParams.winCustChnl == "机构">class="cur" </#if>>机构</span>
                        <span data-value="自主开发"
                              <#if result.reqParams.winCustChnl == "自主开发">class="cur" </#if>>自主开发</span>
                        <span data-value="其他" <#if result.reqParams.winCustChnl == "其他">class="cur" </#if>>其他</span>
                    </div>
                </div>
            </#if>
            <#if result.reqParams.custType == "corpCust">
                <div class="group entType" id="div_entType">
                    <div class="head">
                        <h4>企业分层</h4>
                        <span data-value="all" <#if result.reqParams.entType == "all">class="all" </#if>>全部</span>
                    </div>
                    <div class="body">
                        <span data-value="4002" <#if result.reqParams.entType == "4002"> class="cur" </#if>>目标企业</span>
                        <span data-value="4003" <#if result.reqParams.entType == "4003"> class="cur" </#if>>核心企业</span>
                    </div>
                </div>
            </#if>

            <#if result.reqParams.custType == "corpCust">
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
            </#if>
            </div>
            <br>
            <div class="form-body">
                <div class="form-group">
                    <label class="control-label col-md-2">搜索对象：</label>
                    <input id="searchinput" name="searchinput" type="text" class="control-label col-md-2"
                           placeholder="请输入搜索对象名称" value="${result.reqParams.corpName!''}"/>
                    <label class="control-label col-md-1">&nbsp;</label>
                    <div class="search">
                        <input type="button" value="搜索" class="btn blue"/>
                    </div>
                </div>
            </div>

            <hr style=" height:2px;border:none;border-top:2px dotted #185598;"/>
        <#if msg??><label style="color: #ff0007"> ${msg}</label></#if>

            <!-- 隐式请求参数-->
            <form id="reachListCond" action="/crm/marketing/reachcsr/reachlist" method="post">
                <input name="corpName" id="corpName" type="hidden" value="${result.reqParams.corpName!''}"/>
                <input name="bizLv1Id" id="bizLv1Id" type="hidden" value="${result.reqParams.bizLv1Id!''}"/>
                <input name="bizLv2Id" id="bizLv2Id" type="hidden" value="${result.reqParams.bizLv2Id!''}"/>
                <input name="hasDemand" id="hasDemand" type="hidden" value="${result.reqParams.hasDemand!''}"/>
                <input name="winCustChnl" id="winCustChnl" type="hidden" value="${result.reqParams.winCustChnl!''}"/>
                <input name="timeBegin" id="timeBegin" type="hidden" value="${result.reqParams.timeBegin!''}"/>
                <input name="timeEnd" id="timeEnd" type="hidden" value="${result.reqParams.timeEnd!''}">
                <input name="empName" id="empName" type="hidden" value="${result.reqParams.empName!''}"/>
                <input name="custType" id="custType" type="hidden" value="${result.reqParams.custType!''}"/>
                <input name="entType" id="entType" type="hidden" value="${result.reqParams.entType!''}"/>
                <input name="assetsTagCode" id="assetsTagCode" type="hidden" value = "${result.reqParams.assetsTagCode!''}"/>
                <input type="hidden" name="pageIndex" id="pageIndex" value="">
            </form>

            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-phone"></i>历史触达信息
                    </div>
                    <div class="actions">
                        <a href="/reachcsr/corpdetail" class="btn default yellow-stripe">
                            <i class="fa fa-plus"></i>
                            <span class="hidden-480">
								新增触达 </span>
                        </a>
                    </div>
                </div>
                <div class="portlet-body">
                    <div class="result-count">
                        <p>当前共有 <span>${result.totalRecCount!''}</span>条 </p>
                    </div>
                    <!--企业、非企业类触达对象显示内容-->
                <#if result.reqParams.custType!="govCust">
                    <table class="table table-bordered table-hover" id="tb">
                        <thead>
                        <tr style="background-color: #9ca7b7;">
                            <th>
                                触达客户名(高企评分)
                            </th>
                            <th>
                                总触达次数
                            </th>
                            <th>
                                分公司
                            </th>
                            <th>
                                触达人
                            </th>
                            <th>
                                业务分类
                            </th>
                            <th>
                                政府业务分类
                            </th>
                            <th>
                                获客渠道
                            </th>
                            <th>
                                触达时间
                            </th>
                            <th>
                                接触人
                            </th>
                            <th>
                                职位
                            </th>
                            <th>
                                联系电话
                            </th>
                            <th>
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list result.rchListContents as reachList>
                            <tr>
                                <td>
                                    <#if (reachList.entType)??>
                                        <#if reachList.entType=='4002'><span class="icon-star"
                                                                             style="color: #aa1ee6"></span>&nbsp;<span
                                                class="icon-star" style="color: #aa1ee6"></span></#if>
                                        <#if reachList.entType=='4003'><span class="icon-star"
                                                                             style="color: red"></span>&nbsp;<span
                                                class="icon-star" style="color: red"></span>&nbsp;<span
                                                class="icon-star" style="color: red"></span></#if>
                                    </#if>
                                    <a href="/crm/enterprisedetail/view?reg_credit_no=${reachList.regCreditNo?if_exists}" id="${reachList.regCreditNo?if_exists}" target="_blank"
                                       >${reachList.enterpriseName?if_exists}</a>
                                    <span class="badge badge-roundless badge-danger">${reachList.gqScore?if_exists}分</span>
                                </td>
                                <td>
                                ${reachList.reachcsrTimes?if_exists}
                                </td>
                                <td>
                                ${reachList.company?if_exists}
                                </td>
                                <td>
                                ${reachList.rchEmp?if_exists}
                                </td>
                                <td>
                                ${reachList.bizLv1Id?if_exists}
                                </td>
                                <td>
                                ${reachList.bizLv2Id?if_exists}
                                </td>
                                <td>
                                ${reachList.winCustChnl?if_exists}
                                </td>
                                <td>
                                ${reachList.beginTime?if_exists}
                                </td>
                                <td>
                                ${reachList.contacts?if_exists}
                                </td>
                                <td>
                                ${reachList.jobTitle?if_exists}
                                </td>
                                <td>
                                ${reachList.contactsPhone?if_exists}
                                </td>
                                <td>
                                    <a href="#" id="${reachList.rchNo?if_exists}" onclick="editRchInfo(this)"><span
                                            class="icon-note" title="编辑触达信息"></span></a>&nbsp;&nbsp;
                                    <a href="#" id="${reachList.regCreditNo?if_exists}"
                                       onclick="showEntOrder(this)"><span class="icon-basket-loaded"
                                                                          title="查看企业历史订单"></span></a>
                                </td>
                            </tr>
                            </#list>
                        </tbody>
                    </table>
                </#if>
                    <!--政府类触达对象显示内容-->
                <#if result.reqParams.custType=="govCust">
                    <table class="table table-bordered table-hover table-expandable">
                        <thead>
                        <tr style="background-color: #9ca7b7;">
                            <th width="5%">
                                分公司
                            </th>
                            <th width="5%">
                                触达人
                            </th>
                            <th width="20%">
                                拜访部委
                            </th>
                            <th width="5%">
                                总触达次数
                            </th>
                            <th width="8%">
                                政府条线
                            </th>
                            <th width="6%">
                                业务分类
                            </th>
                            <th width="8%">
                                拜访时间
                            </th>
                            <th width="8%">
                                拜访领导
                            </th>
                            <th width="8%">
                                职务
                            </th>
                            <th width="8%">
                                联系电话
                            </th>
                            <th width="18%">
                                沟通主题
                            </th>
                            <th>
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list result.rchListContents as reachList>
                            <tr>
                                <td>
                                ${reachList.company?if_exists}
                                </td>
                                <td>
                                ${reachList.rchEmp?if_exists}
                                </td>
                                <td>
                                ${reachList.enterpriseName?if_exists}
                                </td>
                                <td>
                                ${reachList.reachcsrTimes?if_exists}
                                </td>
                                <td>
                                ${reachList.govLine?if_exists}
                                </td>
                                <td>
                                ${reachList.bizLv1Id?if_exists}
                                </td>
                                <td>
                                ${reachList.beginTime?if_exists}
                                </td>
                                <td>
                                ${reachList.contacts?if_exists}
                                </td>
                                <td>
                                ${reachList.jobTitle?if_exists}
                                </td>
                                <td>
                                ${reachList.contactsPhone?if_exists}
                                </td>
                                <td>
                                ${reachList.commTopic?if_exists}
                                </td>
                                <td>
                                    <a href="#" id="${reachList.rchNo?if_exists}" onclick="editRchInfo(this)"><span
                                            class="icon-note" title="编辑触达信息"></span></a>&nbsp;&nbsp;
                                </td>
                            </tr>
                            <tr>
                                <td colspan="12" style="color: #0b6694">
                                    级别：${reachList.govLevel?if_exists}
                                    <br>
                                    部委等级：${reachList.govQzr?if_exists}
                                    <br>
                                    推进情况及取得的效果：${reachList.getEffect?if_exists}
                                    <br>
                                    预计形成成果的时间：${reachList.resultTime?if_exists}
                                    <br>
                                    需要总部协调事项：${reachList.cdnThings?if_exists}
                                    <br>
                                    内容纪要：${reachList.remark?if_exists}
                                </td>
                            </tr>
                            </#list>
                        </tbody>
                    </table>
                </#if>
                </div>
                <div class="container paging">
                    <div class="pagination"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- BEGIN 框架效果 -->
<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<script src="/dist/js/data_select.js"></script>
<!-- added by yingsl on 20170523 分页-->
<script src="/dist/js/jquery.pagination.js"></script>
<script src="/dist/js/jquery-ui.min.js"></script>
<script src="/dist/js/datepicker-zh-CN.js"></script>
<script src="/dist/js/crm.js?v=1"></script>
<script src="/dist/js/filter_reachcsr.js"></script>
<!--点击表格行向下弹出其他内容-->
<script src="/dist/js/bootstrap-table-expandable.js"></script>

<script>
    // 分页
    $('.pagination').pagination({
                pageCount: ${result.totalPageCount?replace(',','')},
                count: ${result.totalPageCount?replace(',','')} == 4 ? 3 : 2,
            current
    :  ${result.reqParams.pageIndex?replace(',','')!1},
    coping: true,
            jump
    :
    true,
            jumpBtn
    :
    '确定'
    })
    ;
    var $paging = $('.pagination');
    var $pageIndex = $('#pageIndex');
    $paging.on('click', 'a', function () {
        var cur = 0;
        if ($(this).hasClass('jump-btn')) {
            cur = $(this).siblings('input[type="text"]').val();
        } else {
            cur = $paging.find('.active').text();
        }
        $pageIndex.val(cur);
        $('#reachListCond').submit();
    });

    jQuery(document).ready(function () {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        Demo.init(); // init demo features
    });

    //表格相同行合并
    function autoRowSpan(tb, row, col) {
        var lastValue = "";
        var value = "";
        var pos = 1;
        for (var i = row; i < tb.rows.length; i++) {
            value = tb.rows[i].cells[col].innerText;
            if (lastValue == value) {
                tb.rows[i].deleteCell(col);
                tb.rows[i - pos].cells[col].rowSpan = tb.rows[i - pos].cells[col].rowSpan + 1;
                pos++;
            } else {
                lastValue = value;
                pos = 1;
            }
        }
    }



    function editRchInfo(obj) {
        <#if result.reqParams.custType=="govCust">
            var url="/reachcsr/govdetail";
        <#elseif result.reqParams.custType=="corpCust">
            var url="/reachcsr/corpdetail";
        <#else >
            var url="/reachcsr/notcorpdetail";
        </#if>
        var rch_no = null;
        if (obj) {
            rch_no = obj.id;  //获取要编辑的触达信息编号
            window.location.href = url+'?rchNo=' + rch_no; //编辑触达信息
        }
    }
</script>
</body>
</html>
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
    <link href="/dist/css/jquery-ui.min.css" rel="stylesheet">

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
<#assign page=210/>
<#include "../top_menu.ftl"/>

<!-- 仪表盘页面中部区域层：BEGIN-->
<div class="page-container">
    <!--引入页面左边菜单tree-->
<#include "../left_menu.ftl"/>
    <div class="page-content-wrapper">
        <div class="page-content">
            <!-- BEGIN 数据展示区-->
            <div class="portlet">
                <div class="portlet-body">
                        <table class="table table-bordered table-hover" align="center">
                            <tbody>
                            <tr>
                                <td>
                                    <div class="pop" align="center"><b>损　　益　　表
                                        <p></p></b></div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="table table-bordered table-hover" align="center">
                            <tbody>
                            <tr>
                                <td width="350" align="left">编制单位:${tmpTable.enterpriseName}</td>
                                <td width="350" align="middle">
                                    报表日期：${tmpTable.beginTime?if_exists}
                                </td>
                                <td width="350" align="right">单位：${tmpTable.unit?if_exists}</td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="table table-bordered table-hover" align="center">
                            <tbody>
                            <tr>
                                <td rowspan="2" width="250" align="middle">项目</td>
                                <td rowspan="2" width="100" align="middle">行次</td>
                                <td width="150" align="middle">本月数</td>
                                <td width="150" align="middle">本年累计数</td>
                            </tr>
                            <tr>
                                <td>　</td>
                                <td>　</td>
                            </tr>
                            <tr>
                                <td>一、主营业务收入</td>
                                <td>1</td>
                                <td>${tmpTable.businessIncomeMonth?if_exists}</td>
                                <td>${tmpTable.businessIncomeYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>　减：主营业务成本</td>
                                <td>4</td>
                                <td>${tmpTable.businessCostsMonth?if_exists}</td>
                                <td>${tmpTable.businessCostsYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>　　　主营业务税金及附加</td>
                                <td>5</td>
                                <td>${tmpTable.businessAndAdditionTaxMonth?if_exists}</td>
                                <td>${tmpTable.businessAndAdditionTaxYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>二、主营业务利润（1-4-5）</td>
                                <td>10</td>
                                <td>${tmpTable.mainBusinessProfitMonth?if_exists}</td>
                                <td>${tmpTable.mainBusinessProfitYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>　加：其他业务利润</td>
                                <td>11</td>
                                <td>${tmpTable.otherBusinessProfitsMonth?if_exists}</td>
                                <td>${tmpTable.otherBusinessProfitsYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>　减：营业费用</td>
                                <td>14</td>
                                <td>${tmpTable.operatingExpensesMonth?if_exists}</td>
                                <td>${tmpTable.operatingExpensesYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>　　　管理费用</td>
                                <td>15</td>
                                <td>${tmpTable.managementExpensesMonth?if_exists}</td>
                                <td>${tmpTable.managementExpensesYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>　　　财务费用</td>
                                <td>16</td>
                                <td>${tmpTable.financialExpensesMonth?if_exists}</td>
                                <td>${tmpTable.financialExpensesYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>三、营业利润(10+11-14-15-16)</td>
                                <td>18</td>
                                <td>${tmpTable.businessProfitMonth?if_exists}</td>
                                <td>${tmpTable.businessProfitYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>　加：投资收益</td>
                                <td>19</td>
                                <td>${tmpTable.investmentIncomeMonth?if_exists}</td>
                                <td>${tmpTable.investmentIncomeYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>　　　补贴收入</td>
                                <td>22</td>
                                <td>${tmpTable.subsidyIncomeMonth?if_exists}</td>
                                <td>${tmpTable.subsidyIncomeYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>　　　营业外收入</td>
                                <td>23</td>
                                <td>${tmpTable.businessOutIncomeMonth?if_exists}</td>
                                <td>${tmpTable.businessOutIncomeYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>　减：营业外支出</td>
                                <td>25</td>
                                <td>${tmpTable.budinessOutExpendMonth?if_exists}</td>
                                <td>${tmpTable.budinessOutExpendYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>四、利润总额（18+19+22+23-25）</td>
                                <td>27</td>
                                <td>${tmpTable.totalProfitMonth?if_exists}</td>
                                <td>${tmpTable.totalProfitYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>　减：所得税</td>
                                <td>28</td>
                                <td>${tmpTable.incomeTaxMonth?if_exists}</td>
                                <td>${tmpTable.incomeTaxYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>净利润(27-28)</td>
                                <td>30</td>
                                <td>${tmpTable.netProfitMonth?if_exists}</td>
                                <td>${tmpTable.netProfitYear?if_exists}</td>
                            </tr>
                            </tbody>
                        </table>
                        <table class="table table-bordered table-hover" align="center">
                            <tbody>
                            <tr>
                                <td colspan="3">补充资料</td>
                            </tr>
                            <tr>
                            </tr>
                            <tr>
                                <td width="350" align="middle">项目</td>
                                <td width="150" align="middle">本年累计数</td>
                                <td width="150" align="middle">上年实际数</td>
                            </tr>
                            <tr>
                                <td>1．出售、处置部门或被投资单位所得收益</td>
                                <td>${tmpTable.proceedsFromTheDisposalOrDisposalUnitMonth?if_exists}</td>
                                <td>${tmpTable.proceedsFromTheDisposalOrDisposalUnitYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>2．自然灾害发生的损失</td>
                                <td>${tmpTable.naturalDisasterLossMonth?if_exists}</td>
                                <td>${tmpTable.naturalDisasterLossYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>3．会计政策变更增加（或减少）利润总额</td>
                                <td>${tmpTable.increaseTotalProfitOfAccountingPolicyChangeMonth?if_exists}</td>
                                <td>${tmpTable.increaseTotalProfitOfAccountingPolicyChangeYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>4、会计估计变更增加（或减少）利润总额</td>
                                <td>${tmpTable.increaseTotalProfitOfAccountingEstimateChangeMonth?if_exists}</td>
                                <td>${tmpTable.increaseTotalProfitOfAccountingEstimateChangeYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>5、债务重组损失</td>
                                <td>${tmpTable.debtRestructuringLossMonth?if_exists}</td>
                                <td>${tmpTable.debtRestructuringLossYear?if_exists}</td>
                            </tr>
                            <tr>
                                <td>6、其他</td>
                                <td>${tmpTable.otherMonth?if_exists}</td>
                                <td>${tmpTable.otherYear?if_exists}</td>
                            </tr>
                            </tbody>
                        </table>
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
<script src="/dist/js/laydate/laydate.js"></script>
<script>
    jQuery(document).ready(function () {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        //Demo.init(); // init demo features
    });
    laydate({
        elem: '#contractDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
    laydate({
        elem: '#incomeExpDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });

</script>
</body>
</html>

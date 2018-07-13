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
                                <td width="600">
                                    <div class="pop" align="center"><b>利　　润　　表</b></div>
                                </td>
                                <td align="right">会小企02表</td>
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
                                <td class="style_td" width="392" align="middle">项目</td>
                                <td class="style_td" width="59" align="middle">行次</td>
                                <td class="style_td" width="117" align="middle">本年累计金额</td>
                                <td class="style_td" width="120" align="middle">本月金额</td>
                            </tr>
                            <tr>
                                <td class="style_td">一、营业收入</td>
                                <td class="style_td" align="middle">1</td>
                                <td class="style_td" align="right">${tmpTable.businessIncomeYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.businessIncomeMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　减：营业成本</td>
                                <td class="style_td" align="middle">2</td>
                                <td class="style_td" align="right">${tmpTable.businessCostsYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.businessCostsMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　营业税金及附加</td>
                                <td class="style_td" align="middle">3</td>
                                <td class="style_td" align="right">${tmpTable.businessAndAdditionTaxYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.businessAndAdditionTaxMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　其中：消费税</td>
                                <td class="style_td" align="middle">4</td>
                                <td class="style_td" align="right">${tmpTable.exciseTaxYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.exciseTaxMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　营业税</td>
                                <td class="style_td" align="middle">5</td>
                                <td class="style_td" align="right">${tmpTable.businessTaxYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.businessTaxMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　城市维护建设税</td>
                                <td class="style_td" align="middle">6</td>
                                <td class="style_td" align="right">${tmpTable.cityBuildTaxYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.cityBuildTaxMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　资源税</td>
                                <td class="style_td" align="middle">7</td>
                                <td class="style_td" align="right">${tmpTable.resourceTaxYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.resourceTaxMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　土地增值税</td>
                                <td class="style_td" align="middle">8</td>
                                <td class="style_td" align="right">${tmpTable.landValueAddedTaxYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.landValueAddedTaxMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　城镇土地使用税、房产税、车船税、印花税</td>
                                <td class="style_td" align="middle">9</td>
                                <td class="style_td" align="right">${tmpTable.cityHouseCarTaxYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.cityHouseCarTaxMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　教育费附加、矿产资源补偿费、排污费</td>
                                <td class="style_td" align="middle">10</td>
                                <td class="style_td" align="right">${tmpTable.educationMineralSewageTaxYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.educationMineralSewageTaxMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　销售费用</td>
                                <td class="style_td" align="middle">11</td>
                                <td class="style_td" align="right">${tmpTable.sallFeesYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.sallFeesMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　其中：商品维修费</td>
                                <td class="style_td" align="middle">12</td>
                                <td class="style_td" align="right">${tmpTable.productRepairFeeYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.productRepairFeeMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　广告费和业务宣传费</td>
                                <td class="style_td" align="middle">13</td>
                                <td class="style_td" align="right">${tmpTable.publicityFeeYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.publicityFeeMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　管理费用</td>
                                <td class="style_td" align="middle">14</td>
                                <td class="style_td" align="right">${tmpTable.managementFeeYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.managementFeeMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　其中：开办费</td>
                                <td class="style_td" align="middle">15</td>
                                <td class="style_td" align="right">${tmpTable.organizationFeeYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.organizationFeeMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　业务招待费</td>
                                <td class="style_td" align="middle">16</td>
                                <td class="style_td" align="right">${tmpTable.extertainmentFeeYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.extertainmentFeeMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　研究费用</td>
                                <td class="style_td" align="middle">17</td>
                                <td class="style_td" align="right">${tmpTable.researchFeeYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.researchFeeMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　财务费用</td>
                                <td class="style_td" align="middle">18</td>
                                <td class="style_td" align="right">${tmpTable.financialFeeYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.financialFeeMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　其中：利息费用（收入以“-”号填列）</td>
                                <td class="style_td" align="middle">19</td>
                                <td class="style_td" align="right">${tmpTable.interestFeeYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.interestFeeMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　加：投资收益（损失以“-”号填列）</td>
                                <td class="style_td" align="middle">20</td>
                                <td class="style_td" align="right">${tmpTable.investmentIncomeYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.investmentIncomeMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">二、营业利润（亏损以“-”号填列）</td>
                                <td class="style_td" align="middle">21</td>
                                <td class="style_td" align="right">${tmpTable.businessProfitYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.businessProfitMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　加：营业外收入</td>
                                <td class="style_td" align="middle">22</td>
                                <td class="style_td" align="right">${tmpTable.businessOutIncomeYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.businessOutIncomeMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　其中：政府补助</td>
                                <td class="style_td" align="middle">23</td>
                                <td class="style_td" align="right">${tmpTable.governmentSubsidyYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.governmentSubsidyMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　减：营业外支出</td>
                                <td class="style_td" align="middle">24</td>
                                <td class="style_td" align="right">${tmpTable.budinessOutExpendYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.budinessOutExpendMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　其中：坏账损失</td>
                                <td class="style_td" align="middle">25</td>
                                <td class="style_td" align="right">${tmpTable.badDebtLossYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.badDebtLossMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　无法收回的长期债券投资损失</td>
                                <td class="style_td" align="middle">26</td>
                                <td class="style_td" align="right">${tmpTable.canNotReceiveLongTimeBondLossYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.canNotReceiveLongTimeBondLossMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　无法收回的长期股权投资损失</td>
                                <td class="style_td" align="middle">27</td>
                                <td class="style_td" align="right">${tmpTable.canNotReceiveLongTimeStockLossYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.canNotReceiveLongTimeStockLossMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　自然灾害等不可抗力因素造成的损失</td>
                                <td class="style_td" align="middle">28</td>
                                <td class="style_td" align="right">${tmpTable.naturalDisasterLossYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.naturalDisasterLossMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　税收滞纳金</td>
                                <td class="style_td" align="middle">29</td>
                                <td class="style_td" align="right">${tmpTable.taxLatePaymentYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.taxLatePaymentMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">三、利润总额（亏损总额以“-”号填列）</td>
                                <td class="style_td" align="middle">30</td>
                                <td class="style_td" align="right">${tmpTable.totalProfitYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.totalProfitMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">　　减：所得税费用</td>
                                <td class="style_td" align="middle">31</td>
                                <td class="style_td" align="right">${tmpTable.incomeTaxYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.incomeTaxMonth?if_exists}</td>
                            </tr>
                            <tr>
                                <td class="style_td">四、净利润（净亏损以“-”号填列）</td>
                                <td class="style_td" align="middle">32</td>
                                <td class="style_td" align="right">${tmpTable.netProfitYear?if_exists}</td>
                                <td class="style_td" align="right">${tmpTable.netProfitMonth?if_exists}</td>
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

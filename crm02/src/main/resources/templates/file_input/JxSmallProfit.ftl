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
                    <form method="post" action="/financeinput/tableEditDoJXSmallProfitTableDto/${fiExcelSheet.id?c}">
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
                                <td width="350" align="left">编制单位:${fiFileList.enterpriseName}</td>
                                <td width="350" align="middle">
                                    报表日期：${tmpTable.beginTime?if_exists}
                                </td>
                                <td width="350" align="right">单位：<input type="text" name="unit" value="${tmpTable.unit?if_exists}"></td>
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
                                <td class="style_td" align="right"><input type="number" step="0.01" name="businessIncomeYear" value="${tmpTable.businessIncomeYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="businessIncomeMonth" value="${tmpTable.businessIncomeMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　减：营业成本</td>
                                <td class="style_td" align="middle">2</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="businessCostsYear" value="${tmpTable.businessCostsYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="businessCostsMonth" value="${tmpTable.businessCostsMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　营业税金及附加</td>
                                <td class="style_td" align="middle">3</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="businessAndAdditionTaxYear" value="${tmpTable.businessAndAdditionTaxYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="businessAndAdditionTaxMonth" value="${tmpTable.businessAndAdditionTaxMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　其中：消费税</td>
                                <td class="style_td" align="middle">4</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="exciseTaxYear" value="${tmpTable.exciseTaxYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="exciseTaxMonth" value="${tmpTable.exciseTaxMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　营业税</td>
                                <td class="style_td" align="middle">5</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="businessTaxYear" value="${tmpTable.businessTaxYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="businessTaxMonth" value="${tmpTable.businessTaxMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　城市维护建设税</td>
                                <td class="style_td" align="middle">6</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="cityBuildTaxYear" value="${tmpTable.cityBuildTaxYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="cityBuildTaxMonth" value="${tmpTable.cityBuildTaxMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　资源税</td>
                                <td class="style_td" align="middle">7</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="resourceTaxYear" value="${tmpTable.resourceTaxYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="resourceTaxMonth" value="${tmpTable.resourceTaxMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　土地增值税</td>
                                <td class="style_td" align="middle">8</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="landValueAddedTaxYear" value="${tmpTable.landValueAddedTaxYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="landValueAddedTaxMonth" value="${tmpTable.landValueAddedTaxMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　城镇土地使用税、房产税、车船税、印花税</td>
                                <td class="style_td" align="middle">9</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="cityHouseCarTaxYear" value="${tmpTable.cityHouseCarTaxYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="cityHouseCarTaxMonth" value="${tmpTable.cityHouseCarTaxMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　教育费附加、矿产资源补偿费、排污费</td>
                                <td class="style_td" align="middle">10</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="educationMineralSewageTaxYear" value="${tmpTable.educationMineralSewageTaxYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="educationMineralSewageTaxMonth" value="${tmpTable.educationMineralSewageTaxMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　销售费用</td>
                                <td class="style_td" align="middle">11</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="sallFeesYear" value="${tmpTable.sallFeesYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="sallFeesMonth" value="${tmpTable.sallFeesMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　其中：商品维修费</td>
                                <td class="style_td" align="middle">12</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="productRepairFeeYear" value="${tmpTable.productRepairFeeYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="productRepairFeeMonth" value="${tmpTable.productRepairFeeMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　广告费和业务宣传费</td>
                                <td class="style_td" align="middle">13</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="publicityFeeYear" value="${tmpTable.publicityFeeYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="publicityFeeMonth" value="${tmpTable.publicityFeeMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　管理费用</td>
                                <td class="style_td" align="middle">14</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="managementFeeYear" value="${tmpTable.managementFeeYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="managementFeeMonth" value="${tmpTable.managementFeeMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　其中：开办费</td>
                                <td class="style_td" align="middle">15</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="organizationFeeYear" value="${tmpTable.organizationFeeYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="organizationFeeMonth" value="${tmpTable.organizationFeeMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　业务招待费</td>
                                <td class="style_td" align="middle">16</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="extertainmentFeeYear" value="${tmpTable.extertainmentFeeYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="extertainmentFeeMonth" value="${tmpTable.extertainmentFeeMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　研究费用</td>
                                <td class="style_td" align="middle">17</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="researchFeeYear" value="${tmpTable.researchFeeYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="researchFeeMonth" value="${tmpTable.researchFeeMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　财务费用</td>
                                <td class="style_td" align="middle">18</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="financialFeeYear" value="${tmpTable.financialFeeYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="financialFeeMonth" value="${tmpTable.financialFeeMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　其中：利息费用（收入以“-”号填列）</td>
                                <td class="style_td" align="middle">19</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="interestFeeYear" value="${tmpTable.interestFeeYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="interestFeeMonth" value="${tmpTable.interestFeeMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　加：投资收益（损失以“-”号填列）</td>
                                <td class="style_td" align="middle">20</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="investmentIncomeYear" value="${tmpTable.investmentIncomeYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="investmentIncomeMonth" value="${tmpTable.investmentIncomeMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">二、营业利润（亏损以“-”号填列）</td>
                                <td class="style_td" align="middle">21</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="businessProfitYear" value="${tmpTable.businessProfitYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="businessProfitMonth" value="${tmpTable.businessProfitMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　加：营业外收入</td>
                                <td class="style_td" align="middle">22</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="businessOutIncomeYear" value="${tmpTable.businessOutIncomeYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="businessOutIncomeMonth" value="${tmpTable.businessOutIncomeMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　其中：政府补助</td>
                                <td class="style_td" align="middle">23</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="governmentSubsidyYear" value="${tmpTable.governmentSubsidyYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="governmentSubsidyMonth" value="${tmpTable.governmentSubsidyMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　减：营业外支出</td>
                                <td class="style_td" align="middle">24</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="budinessOutExpendYear" value="${tmpTable.budinessOutExpendYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="budinessOutExpendMonth" value="${tmpTable.budinessOutExpendMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　其中：坏账损失</td>
                                <td class="style_td" align="middle">25</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="badDebtLossYear" value="${tmpTable.badDebtLossYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="badDebtLossMonth" value="${tmpTable.badDebtLossMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　无法收回的长期债券投资损失</td>
                                <td class="style_td" align="middle">26</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="canNotReceiveLongTimeBondLossYear" value="${tmpTable.canNotReceiveLongTimeBondLossYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="canNotReceiveLongTimeBondLossMonth" value="${tmpTable.canNotReceiveLongTimeBondLossMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　无法收回的长期股权投资损失</td>
                                <td class="style_td" align="middle">27</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="canNotReceiveLongTimeStockLossYear" value="${tmpTable.canNotReceiveLongTimeStockLossYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="canNotReceiveLongTimeStockLossMonth" value="${tmpTable.canNotReceiveLongTimeStockLossMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　自然灾害等不可抗力因素造成的损失</td>
                                <td class="style_td" align="middle">28</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="naturalDisasterLossYear" value="${tmpTable.naturalDisasterLossYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="naturalDisasterLossMonth" value="${tmpTable.naturalDisasterLossMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　税收滞纳金</td>
                                <td class="style_td" align="middle">29</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="taxLatePaymentYear" value="${tmpTable.taxLatePaymentYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="taxLatePaymentMonth" value="${tmpTable.taxLatePaymentMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">三、利润总额（亏损总额以“-”号填列）</td>
                                <td class="style_td" align="middle">30</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="totalProfitYear" value="${tmpTable.totalProfitYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="totalProfitMonth" value="${tmpTable.totalProfitMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">　　减：所得税费用</td>
                                <td class="style_td" align="middle">31</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="incomeTaxYear" value="${tmpTable.incomeTaxYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="incomeTaxMonth" value="${tmpTable.incomeTaxMonth?if_exists}"></td>
                            </tr>
                            <tr>
                                <td class="style_td">四、净利润（净亏损以“-”号填列）</td>
                                <td class="style_td" align="middle">32</td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="netProfitYear" value="${tmpTable.netProfitYear?if_exists}"></td>
                                <td class="style_td" align="right"><input type="number" step="0.01" name="netProfitMonth" value="${tmpTable.netProfitMonth?if_exists}"></td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="form-actions">
                            <div class="row">
                                <div class="col-md-offset-3 col-md-4">
                                    <input type="submit" value="提交" class="btn purple">
                                </div>
                            </div>
                        </div>
                    </form>
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

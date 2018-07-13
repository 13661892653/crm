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
                    <table class="table table-bordered table-hover">
                        <tbody>
                        <tr>
                            <td width="680">
                                <div class="pop" align="center"><b>小　　企　　业　　资　　产　　负　　债　　表</b></div>
                            </td>
                            <td align="right">会小企01表</td>
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
                    <table class="table table-bordered table-hover"align="center">
                        <tbody>
                        <tr>
                            <td class="style_td" width="158" align="middle">资产</td>
                            <td class="style_td" width="19" align="middle">行次</td>
                            <td class="style_td" height="20" width="84" align="middle">期末余额</td>
                            <td class="style_td" width="84" align="middle">年初余额</td>
                            <td class="style_td" width="226" align="middle">负债及所有者权益</td>
                            <td class="style_td" width="23" align="middle">行次</td>
                            <td class="style_td" width="84" align="middle">期末余额</td>
                            <td class="style_td" width="84" align="middle">年初余额</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">流动资产：</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">　 &nbsp;</td>
                            <td class="style_td">　 &nbsp;</td>
                            <td class="style_td">流动负债：</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;　</td>
                            <td class="style_td">　 &nbsp;</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　货币资金:</td>
                            <td class="style_td">1</td>
                            <td class="style_td" align="right">${tmpTable.monetaryFundEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.monetaryFundBegin?if_exists} </td>
                            <td class="style_td">　　短期借款</td>
                            <td class="style_td">31</td>
                            <td class="style_td" align="right">${tmpTable.shortTermBorrowingEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.shortTermBorrowingBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　短期投资</td>
                            <td class="style_td">2</td>
                            <td class="style_td" align="right">${tmpTable.shortTermInvestmentEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.shortTermInvestmentBegin?if_exists}</td>
                            <td class="style_td">　　应付票据</td>
                            <td class="style_td">32</td>
                            <td class="style_td" align="right">${tmpTable.billsPayableEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.billsPayableBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　应收票据</td>
                            <td class="style_td">3</td>
                            <td class="style_td" align="right">${tmpTable.billsReceivableEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.billsReceivableBegin?if_exists}</td>
                            <td class="style_td">　　应付帐款</td>
                            <td class="style_td">33</td>
                            <td class="style_td" align="right">${tmpTable.accountsPayableEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.accountsPayableBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　应收帐款</td>
                            <td class="style_td">4</td>
                            <td class="style_td" align="right">${tmpTable.accountsReceivableEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.accountsReceivableBegin?if_exists}</td>
                            <td class="style_td">　　预收账款</td>
                            <td class="style_td">34</td>
                            <td class="style_td" align="right">${tmpTable.accountsReceivedEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.accountsReceivedBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　预付款项</td>
                            <td class="style_td">5</td>
                            <td class="style_td" align="right">${tmpTable.accountsPayiedEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.accountsPayiedBegin?if_exists}</td>
                            <td class="style_td">　　应付职工薪酬</td>
                            <td class="style_td">35</td>
                            <td class="style_td" align="right">${tmpTable.payrollPayableEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.payrollPayableBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　应收股利</td>
                            <td class="style_td">6</td>
                            <td class="style_td" align="right">${tmpTable.dividendReceivableEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.dividendReceivableBegin?if_exists}</td>
                            <td class="style_td">　　应交税费</td>
                            <td class="style_td">36</td>
                            <td class="style_td" align="right">${tmpTable.taxPayableEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.taxPayableBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　应收利息</td>
                            <td class="style_td">7</td>
                            <td class="style_td" align="right">${tmpTable.interestReceivableEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.interestReceivableBegin?if_exists}</td>
                            <td class="style_td">　　应付利息</td>
                            <td class="style_td">37</td>
                            <td class="style_td" align="right">${tmpTable.interestPayableEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.interestPayableBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　其他应收款</td>
                            <td class="style_td">8</td>
                            <td class="style_td" align="right">${tmpTable.otherReceivablesEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.otherReceivablesBegin?if_exists}</td>
                            <td class="style_td">　　应付利润</td>
                            <td class="style_td">38</td>
                            <td class="style_td" align="right">${tmpTable.profitPayableEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.profitPayableBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　存货</td>
                            <td class="style_td">9</td>
                            <td class="style_td" align="right">${tmpTable.stockEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.stockBegin?if_exists}</td>
                            <td class="style_td">　　其他应付款</td>
                            <td class="style_td">39</td>
                            <td class="style_td" align="right">${tmpTable.otherPayableEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.otherPayableBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　其中：原材料</td>
                            <td class="style_td">10</td>
                            <td class="style_td" align="right">${tmpTable.rawMaterialEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.rawMaterialBegin?if_exists}</td>
                            <td class="style_td">　　其他流动负债</td>
                            <td class="style_td">40</td>
                            <td class="style_td" align="right">${tmpTable.otherCurrentLiabilitiesEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.otherCurrentLiabilitiesBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　在产品</td>
                            <td class="style_td">11</td>
                            <td class="style_td" align="right">${tmpTable.inProductEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.inProductBegin?if_exists}</td>
                            <td class="style_td">　　流动负债合计</td>
                            <td class="style_td">41</td>
                            <td class="style_td" align="right">${tmpTable.totalCurrentLiabilitiesEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.totalCurrentLiabilitiesBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　库存商品</td>
                            <td class="style_td">12</td>
                            <td class="style_td" align="right">${tmpTable.merchandiseInventoryEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.merchandiseInventoryBegin?if_exists}</td>
                            <td class="style_td">非流动负债:</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　周转材料</td>
                            <td class="style_td">13</td>
                            <td class="style_td" align="right">${tmpTable.workingCapitalConstructionMaterialsEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.workingCapitalConstructionMaterialsBegin?if_exists}</td>
                            <td class="style_td">　　长期借款</td>
                            <td class="style_td">42</td>
                            <td class="style_td" align="right">${tmpTable.longTermBorrowingEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.longTermBorrowingBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　其他流动资产</td>
                            <td class="style_td">14</td>
                            <td class="style_td" align="right">${tmpTable.otherCurrentAssetsEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.otherCurrentAssetsBegin?if_exists}</td>
                            <td class="style_td">　　长期应付款</td>
                            <td class="style_td">43</td>
                            <td class="style_td" align="right">${tmpTable.longTermPayablesEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.longTermPayablesBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　流动资产合计</td>
                            <td class="style_td">15</td>
                            <td class="style_td" align="right">${tmpTable.totalCurrentAssetsEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.totalCurrentAssetsBegin?if_exists}</td>
                            <td class="style_td">　　递延收益</td>
                            <td class="style_td">44</td>
                            <td class="style_td" align="right">${tmpTable.deferredIncomeEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.deferredIncomeBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">非流动资产：</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;　</td>
                            <td class="style_td">　 &nbsp;</td>
                            <td class="style_td">　其他非流动负债</td>
                            <td class="style_td">45</td>
                            <td class="style_td" align="right">${tmpTable.otherNonCurrentLiabilitiesEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.otherNonCurrentLiabilitiesBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　长期债券投资</td>
                            <td class="style_td">16</td>
                            <td class="style_td" align="right">${tmpTable.longTermBondInvestmentEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.longTermBondInvestmentBegin?if_exists}</td>
                            <td class="style_td">非流动负债合计</td>
                            <td class="style_td">46</td>
                            <td class="style_td" align="right">${tmpTable.totalNonCurrentLiabilitiesEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.totalNonCurrentLiabilitiesBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　长期股权投资</td>
                            <td class="style_td">17</td>
                            <td class="style_td" align="right">${tmpTable.longTermEquityInvestmentEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.longTermEquityInvestmentBegin?if_exists}</td>
                            <td class="style_td">　　负债合计</td>
                            <td class="style_td">47</td>
                            <td class="style_td" align="right">${tmpTable.totalLiabilitiesEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.totalLiabilitiesBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　固定资产原价</td>
                            <td class="style_td">18</td>
                            <td class="style_td" align="right">${tmpTable.originalPriceOfFixedAssetsEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.originalPriceOfFixedAssetsBegin?if_exists}</td>
                            <td class="style_td">　　</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　减：累计折旧</td>
                            <td class="style_td">19</td>
                            <td class="style_td" align="right">${tmpTable.accumulatedDepreciationEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.accumulatedDepreciationBegin?if_exists}</td>
                            <td class="style_td">　　</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　固定资产账面价值</td>
                            <td class="style_td">20</td>
                            <td class="style_td" align="right">${tmpTable.bookValueOfFixedAssetsEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.bookValueOfFixedAssetsBegin?if_exists}</td>
                            <td class="style_td">　</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　在建工程</td>
                            <td class="style_td">21</td>
                            <td class="style_td" align="right">${tmpTable.constructionInProgressEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.constructionInProgressBegin?if_exists}</td>
                            <td class="style_td">　　</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　工程物资</td>
                            <td class="style_td">22</td>
                            <td class="style_td" align="right">${tmpTable.engineeringMaterialsEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.engineeringMaterialsBegin?if_exists}</td>
                            <td class="style_td">　　</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　固定资产清理</td>
                            <td class="style_td">23</td>
                            <td class="style_td" align="right">${tmpTable.liquidationOfFixedAssetsEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.liquidationOfFixedAssetsBegin?if_exists}</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　生产性生物资产</td>
                            <td class="style_td">24</td>
                            <td class="style_td" align="right">${tmpTable.viologicalViologicalAssetsEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.viologicalViologicalAssetsBegin?if_exists}</td>
                            <td class="style_td">所有者权益（或股东权益）：</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                            <td class="style_td">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　无形资产</td>
                            <td class="style_td">25</td>
                            <td class="style_td" align="right">${tmpTable.intangibleAssetsEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.intangibleAssetsBegin?if_exists}</td>
                            <td class="style_td">　　实收资本（或股本）</td>
                            <td class="style_td">48</td>
                            <td class="style_td" align="right">${tmpTable.paidInCapitalEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.paidInCapitalBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　开发支出</td>
                            <td class="style_td">26</td>
                            <td class="style_td" align="right">${tmpTable.developmentExpenditureEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.developmentExpenditureBegin?if_exists}</td>
                            <td class="style_td">&nbsp;&nbsp;资本公积</td>
                            <td class="style_td">49</td>
                            <td class="style_td" align="right">${tmpTable.capitalSurplusEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.capitalSurplusBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　长期待摊费用</td>
                            <td class="style_td">27</td>
                            <td class="style_td" align="right">${tmpTable.longTermPrepaidExpensesBegin?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.longTermPrepaidExpensesEnd?if_exists}</td>
                            <td class="style_td">&nbsp;&nbsp;盈余公积</td>
                            <td class="style_td">50</td>
                            <td class="style_td" align="right">${tmpTable.surplusReserveEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.surplusReserveBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　其他非流动资产</td>
                            <td class="style_td">28</td>
                            <td class="style_td" align="right">${tmpTable.otherNonCurrentAssetsEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.otherNonCurrentAssetsBegin?if_exists}</td>
                            <td class="style_td">　　未分配利润</td>
                            <td class="style_td">51</td>
                            <td class="style_td" align="right">${tmpTable.undistributedProfitEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.undistributedProfitBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">　　非流动资产合计</td>
                            <td class="style_td">29</td>
                            <td class="style_td" align="right">${tmpTable.totalNonCurrentAssetsEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.totalNonCurrentAssetsBegin?if_exists}</td>
                            <td class="style_td">所有者权益（或股东权益）合计</td>
                            <td class="style_td">52</td>
                            <td class="style_td" align="right">${tmpTable.totalOwnerEquityEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.totalOwnerEquityBegin?if_exists}</td>
                        </tr>
                        <tr>
                            <td class="style_td" height="20">资产总计</td>
                            <td class="style_td">30</td>
                            <td class="style_td" align="right">${tmpTable.totalAssetsEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.totalAssetsBegin?if_exists}</td>
                            <td class="style_td">负债和所有者权益（或股东权益）总计</td>
                            <td class="style_td">53</td>
                            <td class="style_td" align="right">${tmpTable.totalLiabilitiesAndOwnerEquityEnd?if_exists}</td>
                            <td class="style_td" align="right">${tmpTable.totalLiabilitiesAndOwnerEquityBegin?if_exists}</td>
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
    jQuery(document).ready(function() {
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

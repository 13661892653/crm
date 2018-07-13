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
                                <div class="pop" align="center"><b>资　　产　　负　　债　　表</b></div>
                            </td>
                        </tr>
                        </tbody>
                    </table>

                    <table class="table table-bordered table-hover" align="center">
                        <tbody>
                        <tr>
                            <td width="350" align="left">编制单位:${tmpTable.enterpriseName}</td>
                            <td width="350" align="middle">
                                报表日期：${tmpTable.tableDate?if_exists}
                            </td>
                            <td width="350" align="right">单位：
                            ${tmpTable.unit?if_exists}</td>
                        </tr>
                        </tbody>
                    </table>
                    <table class="table table-bordered table-hover" align="center">
                        <tbody>
                        <tr>
                            <td rowspan="2" width="175" align="middle">资产</td>
                            <td rowspan="2" width="20" align="middle">行次</td>
                            <td height="20" width="70" align="middle">年初数</td>
                            <td width="70" align="middle">期末数</td>
                            <td rowspan="2" width="200" align="middle">负债及所有者权益</td>
                            <td rowspan="2" width="25" align="middle">行次</td>
                            <td width="70" align="middle">年初数</td>
                            <td width="70" align="middle">期末数</td>
                        </tr>
                        <tr>
                            <td height="20" width="70" align="middle">　</td>
                            <td width="70" align="middle">　</td>
                            <td width="70" align="middle">　</td>
                            <td width="70" align="middle">　</td>
                        </tr>
                        <tr>
                            <td height="20">流动资产：</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                            <td>流动负债：</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                        </tr>
                        <tr>
                            <td height="20">　货币资金</td>
                            <td>1</td>
                            <td>${tmpTable.monetaryFundBegin?if_exists}</td>
                            <td>${tmpTable.monetaryFundEnd?if_exists}</td>
                            <td>　短期借款</td>
                            <td>68</td>
                            <td>${tmpTable.shortTermBorrowingBegin?if_exists}</td>
                            <td>${tmpTable.shortTermBorrowingEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　短期投资</td>
                            <td>2</td>
                            <td>${tmpTable.shortTermInvestmentBegin?if_exists}</td>
                            <td>${tmpTable.shortTermInvestmentEnd?if_exists}</td>
                            <td>　应付票据</td>
                            <td>69</td>
                            <td>${tmpTable.billsPayableBegin?if_exists}</td>
                            <td>${tmpTable.billsPayableEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　应收票据</td>
                            <td>3</td>
                            <td>${tmpTable.billsReceivableBegin?if_exists}</td>
                            <td>${tmpTable.billsReceivableEnd?if_exists}</td>
                            <td>　应付账款</td>
                            <td>70</td>
                            <td>${tmpTable.accountsPayableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.accountsPayableEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　应收股利</td>
                            <td>4</td>
                            <td>
                            ${tmpTable.dividendReceivableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.dividendReceivableEnd?if_exists}</td>
                            <td>　预收账款</td>
                            <td>71</td>
                            <td>
                            ${tmpTable.accountsReceivedBegin?if_exists}</td>
                            <td>
                            ${tmpTable.accountsReceivedEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　应收利息</td>
                            <td>5</td>
                            <td>
                            ${tmpTable.interestReceivableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.interestReceivableEnd?if_exists}</td>
                            <td>　应付工资</td>
                            <td>72</td>
                            <td>
                            ${tmpTable.payrollPayableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.payrollPayableEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　应收账款</td>
                            <td>6</td>
                            <td>
                            ${tmpTable.accountsReceivableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.accountsReceivableEnd?if_exists}</td>
                            <td>　应付福利费</td>
                            <td>73</td>
                            <td>
                            ${tmpTable.welfarePayableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.welfarePayableEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　其他应收款</td>
                            <td>7</td>
                            <td>
                            ${tmpTable.otherReceivablesBegin?if_exists}</td>
                            <td>
                            ${tmpTable.otherReceivablesEnd?if_exists}</td>
                            <td>　应付股利</td>
                            <td>74</td>
                            <td>
                            ${tmpTable.dividendsPayableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.dividendsPayableEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　预付账款</td>
                            <td>8</td>
                            <td>
                            ${tmpTable.accountsPayiedBegin?if_exists}</td>
                            <td>
                            ${tmpTable.accountsPayiedEnd?if_exists}</td>
                            <td>　应交税金</td>
                            <td>75</td>
                            <td>
                            ${tmpTable.taxPayableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.taxPayableEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　应收补贴款</td>
                            <td>9</td>
                            <td>
                            ${tmpTable.subsidiesReceivableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.subsidiesReceivableEnd?if_exists}</td>
                            <td>　其他应交款</td>
                            <td>80</td>
                            <td>
                            ${tmpTable.otherPayablesBegin?if_exists}</td>
                            <td>
                            ${tmpTable.otherPayablesEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　存货</td>
                            <td>10</td>
                            <td>
                            ${tmpTable.stockBegin?if_exists}</td>
                            <td>>
                            </td>
                            <td>　其他应付款</td>
                            <td>81</td>
                            <td>
                            ${tmpTable.otherPayableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.otherPayableEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　待摊费用</td>
                            <td>11</td>
                            <td>
                            ${tmpTable.prepaidExpensesBegin?if_exists}</td>
                            <td>
                            ${tmpTable.prepaidExpensesEnd?if_exists}</td>
                            <td>　预提费用</td>
                            <td>82</td>
                            <td>
                            ${tmpTable.accruedExpensesBegin?if_exists}</td>
                            <td>
                            ${tmpTable.accruedExpensesEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　一年内到期的长期债权投资</td>
                            <td>21</td>
                            <td>
                            ${tmpTable.longTermDebtInvestmentDueWithinOneYearBegin?if_exists}</td>
                            <td>
                            ${tmpTable.longTermDebtInvestmentDueWithinOneYearEnd?if_exists}</td>
                            <td>　预计负债</td>
                            <td>83</td>
                            <td>
                            ${tmpTable.projectedLiabilitiesBegin?if_exists}</td>
                            <td>
                            ${tmpTable.projectedLiabilitiesEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　其他流动资产</td>
                            <td>24</td>
                            <td>
                            ${tmpTable.otherCurrentAssetsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.otherCurrentAssetsEnd?if_exists}</td>
                            <td>　一年内到期的长期负债</td>
                            <td>86</td>
                            <td>
                            ${tmpTable.longTermLiabilitiesDueWithinOneYearBegin?if_exists}</td>
                            <td>
                            ${tmpTable.longTermLiabilitiesDueWithinOneYearEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">流动资产合计</td>
                            <td>31</td>
                            <td>
                            ${tmpTable.totalCurrentAssetsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.totalCurrentAssetsEnd?if_exists}</td>
                            <td>　其他流动负债</td>
                            <td>90</td>
                            <td>
                            ${tmpTable.otherCurrentLiabilitiesBegin?if_exists}</td>
                            <td>
                            ${tmpTable.otherCurrentLiabilitiesEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                            <td>流动负债合计</td>
                            <td>100</td>
                            <td>
                            ${tmpTable.totalCurrentLiabilitiesBegin?if_exists}</td>
                            <td>
                            ${tmpTable.totalCurrentLiabilitiesEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">长期投资：</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                        </tr>
                        <tr>
                            <td height="20">　长期股权投资</td>
                            <td>32</td>
                            <td>
                            ${tmpTable.longTermEquityInvestmentBegin?if_exists}</td>
                            <td>
                            ${tmpTable.longTermEquityInvestmentEnd?if_exists}</td>
                            <td>长期负债：</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                        </tr>
                        <tr>
                            <td height="20">　长期债权投资</td>
                            <td>34</td>
                            <td>
                            ${tmpTable.longTermDebtInvestmentDueBegin?if_exists}</td>
                            <td>
                            ${tmpTable.longTermDebtInvestmentDueEnd?if_exists}</td>
                            <td>　长期借款</td>
                            <td>101</td>
                            <td>
                            ${tmpTable.longTermBorrowingBegin?if_exists}</td>
                            <td>
                            ${tmpTable.longTermBorrowingEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　长期投资合计</td>
                            <td>38</td>
                            <td>
                            ${tmpTable.totalLongTermInvestmentBegin?if_exists}</td>
                            <td>
                            ${tmpTable.totalLongTermInvestmentEnd?if_exists}</td>
                            <td>　应付债券</td>
                            <td>102</td>
                            <td>
                            ${tmpTable.bondsPayableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.bondsPayableEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">固定资产：</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　其他应付款</td>
                            <td>103</td>
                            <td>
                            ${tmpTable.fixOtherPayableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.fixOtherPayableEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　固定资产原价</td>
                            <td>39</td>
                            <td>
                            ${tmpTable.originalPriceOfFixedAssetsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.originalPriceOfFixedAssetsEnd?if_exists}</td>
                            <td>　专项应付款</td>
                            <td>106</td>
                            <td>
                            ${tmpTable.specialPayableBegin?if_exists}</td>
                            <td>
                            ${tmpTable.specialPayableEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　减：累计折旧</td>
                            <td>40</td>
                            <td>
                            ${tmpTable.accumulatedDepreciationBegin?if_exists}</td>
                            <td>
                            ${tmpTable.accumulatedDepreciationEnd?if_exists}</td>
                            <td>　其他长期负债</td>
                            <td>108</td>
                            <td>
                            ${tmpTable.otherLongTermLiabilitiesBegin?if_exists}</td>
                            <td>
                            ${tmpTable.otherLongTermLiabilitiesEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　固定资产净值</td>
                            <td>41</td>
                            <td>
                            ${tmpTable.netValueOfFixedAssetsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.netValueOfFixedAssetsEnd?if_exists}</td>
                            <td>长期负债合计</td>
                            <td>110</td>
                            <td>
                            ${tmpTable.totalLongTermLiabilitiesBegin?if_exists}</td>
                            <td>
                            ${tmpTable.totalLongTermLiabilitiesEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　减：固定资产减值准备</td>
                            <td>42</td>
                            <td>
                            ${tmpTable.fixedAssetsDepreciationReservesBegin?if_exists}</td>
                            <td>
                            ${tmpTable.fixedAssetsDepreciationReservesEnd?if_exists}</td>
                            <td>递延税项：</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                        </tr>
                        <tr>
                            <td height="20">　固定资产净额</td>
                            <td>43</td>
                            <td>
                            ${tmpTable.netFixedAssetsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.netFixedAssetsEnd?if_exists}</td>
                            <td>　递延税款贷项</td>
                            <td>111</td>
                            <td>
                            ${tmpTable.deferredTaxCreditsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.deferredTaxCreditsEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　工程物资</td>
                            <td>44</td>
                            <td>
                            ${tmpTable.engineeringMaterialsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.engineeringMaterialsEnd?if_exists}</td>
                            <td>负债合计</td>
                            <td>114</td>
                            <td>
                            ${tmpTable.totalLiabilitiesBegin?if_exists}</td>
                            <td>
                            ${tmpTable.totalLiabilitiesEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　在建工程</td>
                            <td>45</td>
                            <td>
                            ${tmpTable.constructionInProgressBegin?if_exists}</td>
                            <td>
                            ${tmpTable.constructionInProgressEnd?if_exists}</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                        </tr>
                        <tr>
                            <td height="20">　固定资产清理</td>
                            <td>46</td>
                            <td>
                            ${tmpTable.liquidationOfFixedAssetsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.liquidationOfFixedAssetsEnd?if_exists}</td>
                            <td>所有者权益(或股东权益)：</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                        </tr>
                        <tr>
                            <td height="20">固定资产合计</td>
                            <td>50</td>
                            <td>
                            ${tmpTable.totalFixedAssetsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.totalFixedAssetsEnd?if_exists}</td>
                            <td>　实收资本(或股本)</td>
                            <td>115</td>
                            <td>
                            ${tmpTable.paidInCapitalBegin?if_exists}</td>
                            <td>
                            ${tmpTable.paidInCapitalEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">无形资产及其他资产：</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　减：已归还投资</td>
                            <td>116</td>
                            <td>
                            ${tmpTable.investmentReturnedBegin?if_exists}</td>
                            <td>
                            ${tmpTable.investmentReturnedEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　无形资产</td>
                            <td>51</td>
                            <td>
                            ${tmpTable.intangibleAssetsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.intangibleAssetsEnd?if_exists}</td>
                            <td>　实收资本(或股本)净额</td>
                            <td>117</td>
                            <td>
                            ${tmpTable.paidInCapitalNetBegin?if_exists}</td>
                            <td>
                            ${tmpTable.paidInCapitalNetEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　长期待摊费用</td>
                            <td>52</td>
                            <td>
                            ${tmpTable.longTermPrepaidExpensesBegin?if_exists}</td>
                            <td>
                            ${tmpTable.longTermPrepaidExpensesEnd?if_exists}</td>
                            <td>　资本公积</td>
                            <td>118</td>
                            <td>
                            ${tmpTable.capitalSurplusBegin?if_exists}</td>
                            <td>
                            ${tmpTable.capitalSurplusEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　其他长期资产</td>
                            <td>53</td>
                            <td>
                            ${tmpTable.otherLongTermAssetsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.otherLongTermAssetsEnd?if_exists}</td>
                            <td>　盈余公积</td>
                            <td>119</td>
                            <td>
                            ${tmpTable.surplusReserveBegin?if_exists}</td>
                            <td>
                            ${tmpTable.surplusReserveEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">无形资产及其他资产合计</td>
                            <td>60</td>
                            <td>
                            ${tmpTable.totalIntangibleAssetsAndOtherAssetsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.totalIntangibleAssetsAndOtherAssetsEnd?if_exists}</td>
                            <td>　其中：法定公益金</td>
                            <td>120</td>
                            <td>
                            ${tmpTable.statutoryPublicWelfareFundBegin?if_exists}</td>
                            <td>
                            ${tmpTable.statutoryPublicWelfareFundEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">递延税项：</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　</td>
                            <td>　未分配利润</td>
                            <td>121</td>
                            <td>
                            ${tmpTable.undistributedProfitBegin?if_exists}</td>
                            <td>
                            ${tmpTable.undistributedProfitEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">　递延税款借项</td>
                            <td>61</td>
                            <td>
                            ${tmpTable.deferredTaxAssetsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.deferredTaxAssetsEnd?if_exists}</td>
                            <td>所有者权益(或股东权益)合计</td>
                            <td>122</td>
                            <td>
                            ${tmpTable.totalOwnerEquityBegin?if_exists}</td>
                            <td>
                            ${tmpTable.totalOwnerEquityEnd?if_exists}</td>
                        </tr>
                        <tr>
                            <td height="20">资产总计</td>
                            <td>67</td>
                            <td>
                            ${tmpTable.totalAssetsBegin?if_exists}</td>
                            <td>
                            ${tmpTable.totalAssetsEnd?if_exists}</td>
                            <td>负债和所有者权益(或股东权益)合计</td>
                            <td>135</td>
                            <td>
                            ${tmpTable.totalLiabilitiesAndOwnerEquityBegin?if_exists}</td>
                            <td>
                            ${tmpTable.totalLiabilitiesAndOwnerEquityEnd?if_exists}</td>
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

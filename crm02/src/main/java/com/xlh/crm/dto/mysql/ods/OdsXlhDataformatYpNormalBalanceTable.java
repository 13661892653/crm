package com.xlh.crm.dto.mysql.ods;

import javax.persistence.Id;

public class OdsXlhDataformatYpNormalBalanceTable {
    @Id
    private Integer id;
    private String fileName;
    private String createTime;
    private String enterpriseName="";      //纳税人名称
    private String creditNo;        //社会信用代码
    private String beginTime;       //所属期起
    private String endTime;     //所属期止
    private String unit;        //单位
    private String monetaryFundBegin;       //货币资金
    private String monetaryFundEnd;
    private String shortTermBorrowingBegin;     //短期借款
    private String shortTermBorrowingEnd;
    private String financialAssetsValuedAtFairValueBegin;       //以公允价值计量且其变动计入当期损益的金融资产
    private String financialAssetsValuedAtFairValueEnd;
    private String financialLiabilitiesMeasuredAtFairValueBegin;        //以公允价值计量且其变动计入当期损益的金融负债
    private String financialLiabilitiesMeasuredAtFairValueEnd;
    private String billsReceivableBegin;        //应收票据
    private String billsReceivableEnd;
    private String billsPayableBegin;       //应付票据
    private String billsPayableEnd;
    private String accountsReceivableBegin;     //应收账款
    private String accountsReceivableEnd;
    private String accountsPayableBegin;        //应付账款
    private String accountsPayableEnd;
    private String advancePaymentBegin;     //预付款项
    private String advancePaymentEnd;
    private String paymentInAdvanceBegin;       //预收款项
    private String paymentInAdvanceEnd;
    private String interestReceivableBegin;     //应收利息
    private String interestReceivableEnd;
    private String payrollPayableBegin;     //应付职工薪酬
    private String payrollPayableEnd;
    private String dividendReceivableBegin;     //应收股利
    private String dividendReceivableEnd;
    private String taxPayableBegin;     //应交税费
    private String taxPayableEnd;
    private String otherReceivablesBegin;       //其他应收款
    private String otherReceivablesEnd;
    private String interestPayableBegin;        //应付利息
    private String interestPayableEnd;
    private String stockBegin;      //存货
    private String stockEnd;
    private String dividendsPayableBegin;       //应付股利
    private String dividendsPayableEnd;
    private String nonCurrentAssetsExpiringWithinOneYearBegin;      //一年内到期的非流动资产
    private String nonCurrentAssetsExpiringWithinOneYearEnd;
    private String otherPayableBegin;       //其他应付款
    private String otherPayableEnd;
    private String otherCurrentAssetsBegin;     //其他流动资产
    private String otherCurrentAssetsEnd;
    private String nonCurrentLiabilitiesDueWithinOneYearBegin;      //一年内到期的非流动负债
    private String nonCurrentLiabilitiesDueWithinOneYearEnd;
    private String totalCurrentAssetsBegin;     //流动资产合计
    private String totalCurrentAssetsEnd;
    private String otherCurrentLiabilitiesBegin;        //其他流动负债
    private String otherCurrentLiabilitiesEnd;
    private String totalCurrentLiabilitiesBegin;        //流动负债合计
    private String totalCurrentLiabilitiesEnd;
    private String availableForSaleFinancialAssetsBegin;        //可供出售金融资产
    private String availableForSaleFinancialAssetsEnd;
    private String heldToMaturityInvestmentBegin;       //持有至到期投资
    private String heldToMaturityInvestmentEnd;
    private String longTermBorrowingBegin;      //长期借款
    private String longTermBorrowingEnd;
    private String longTermReceivablesBegin;        //长期应收款
    private String longTermReceivablesEnd;
    private String bondsPayableBegin;       //应付债券
    private String bondsPayableEnd;
    private String longTermEquityInvestmentBegin;       //长期股权投资
    private String longTermEquityInvestmentEnd;
    private String longTermPayablesBegin;       //长期应付款
    private String longTermPayablesEnd;
    private String investmentRealEstateBegin;       //投资性房地产
    private String investmentRealEstateEnd;
    private String specialPayableBegin;     //专项应付款
    private String specialPayableEnd;
    private String fixedAssetsBegin;        //固定资产
    private String fixedAssetsEnd;
    private String projectedLiabilitiesBegin;       //预计负债
    private String projectedLiabilitiesEnd;
    private String constructionInProgressBegin;     //在建工程
    private String constructionInProgressEnd;
    private String deferredIncomeBegin;     //递延收益
    private String deferredIncomeEnd;
    private String engineeringMaterialsBegin;       //工程物资
    private String engineeringMaterialsEnd;
    private String deferredTaxLiabilityBegin;       //递延所得税负债
    private String deferredTaxLiabilityEnd;
    private String liquidationOfFixedAssetsBegin;       //固定资产清理
    private String liquidationOfFixedAssetsEnd;
    private String otherNonCurrentLiabilitiesBegin;     //其他非流动负债
    private String otherNonCurrentLiabilitiesEnd;
    private String productiveBiologicalAssetsBegin;     //生产性生物资产
    private String productiveBiologicalAssetsEnd;
    private String totalNonCurrentLiabilitiesBegin;     //非流动负债合计
    private String totalNonCurrentLiabilitiesEnd;
    private String oilAndGasAssetsBegin;        //油气资产
    private String oilAndGasAssetsEnd;
    private String totalLiabilitiesBegin;       //负债合计
    private String totalLiabilitiesEnd;
    private String intangibleAssetsBegin;       //无形资产
    private String intangibleAssetsEnd;
    private String developmentExpenditureBegin;     //开发支出
    private String developmentExpenditureEnd;
    private String paidInCapitalBegin;      //实收资本（或股本）
    private String paidInCapitalEnd;
    private String goodwillBegin;       //商誉
    private String goodwillEnd;
    private String capitalSurplusBegin;     //资本公积
    private String capitalSurplusEnd;
    private String longTermPrepaidExpensesBegin;        //长期待摊费用
    private String longTermPrepaidExpensesEnd;
    private String treasuryStockBegin;      //减：库存股
    private String treasuryStockEnd;
    private String deferredTaxAssetsBegin;      //递延所得税资产
    private String deferredTaxAssetsEnd;
    private String otherComprehensiveIncomeBegin;       //其他综合收益
    private String otherComprehensiveIncomeEnd;
    private String otherNonCurrentAssetsBegin;      //其他非流动资产
    private String otherNonCurrentAssetsEnd;
    private String surplusReserveBegin;     //盈余公积
    private String surplusReserveEnd;
    private String totalNonCurrentAssetsBegin;      //非流动资产合计
    private String totalNonCurrentAssetsEnd;
    private String undistributedProfitBegin;        //未分配利润
    private String undistributedProfitEnd;
    private String totalOwnerEquityBegin;       //所有者权益（或股东权 益）合计
    private String totalOwnerEquityEnd;
    private String totalAssetsBegin;        //资产合计
    private String totalAssetsEnd;
    private String totalLiabilitiesAndOwnerEquityBegin;     //负债和所有者权益（或股东权益）总计
    private String totalLiabilitiesAndOwnerEquityEnd;
    private String declareTime;     //申报日期

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMonetaryFundBegin() {
        return monetaryFundBegin;
    }

    public void setMonetaryFundBegin(String monetaryFundBegin) {
        this.monetaryFundBegin = monetaryFundBegin;
    }

    public String getMonetaryFundEnd() {
        return monetaryFundEnd;
    }

    public void setMonetaryFundEnd(String monetaryFundEnd) {
        this.monetaryFundEnd = monetaryFundEnd;
    }

    public String getShortTermBorrowingBegin() {
        return shortTermBorrowingBegin;
    }

    public void setShortTermBorrowingBegin(String shortTermBorrowingBegin) {
        this.shortTermBorrowingBegin = shortTermBorrowingBegin;
    }

    public String getShortTermBorrowingEnd() {
        return shortTermBorrowingEnd;
    }

    public void setShortTermBorrowingEnd(String shortTermBorrowingEnd) {
        this.shortTermBorrowingEnd = shortTermBorrowingEnd;
    }

    public String getFinancialAssetsValuedAtFairValueBegin() {
        return financialAssetsValuedAtFairValueBegin;
    }

    public void setFinancialAssetsValuedAtFairValueBegin(String financialAssetsValuedAtFairValueBegin) {
        this.financialAssetsValuedAtFairValueBegin = financialAssetsValuedAtFairValueBegin;
    }

    public String getFinancialAssetsValuedAtFairValueEnd() {
        return financialAssetsValuedAtFairValueEnd;
    }

    public void setFinancialAssetsValuedAtFairValueEnd(String financialAssetsValuedAtFairValueEnd) {
        this.financialAssetsValuedAtFairValueEnd = financialAssetsValuedAtFairValueEnd;
    }

    public String getFinancialLiabilitiesMeasuredAtFairValueBegin() {
        return financialLiabilitiesMeasuredAtFairValueBegin;
    }

    public void setFinancialLiabilitiesMeasuredAtFairValueBegin(String financialLiabilitiesMeasuredAtFairValueBegin) {
        this.financialLiabilitiesMeasuredAtFairValueBegin = financialLiabilitiesMeasuredAtFairValueBegin;
    }

    public String getFinancialLiabilitiesMeasuredAtFairValueEnd() {
        return financialLiabilitiesMeasuredAtFairValueEnd;
    }

    public void setFinancialLiabilitiesMeasuredAtFairValueEnd(String financialLiabilitiesMeasuredAtFairValueEnd) {
        this.financialLiabilitiesMeasuredAtFairValueEnd = financialLiabilitiesMeasuredAtFairValueEnd;
    }

    public String getBillsReceivableBegin() {
        return billsReceivableBegin;
    }

    public void setBillsReceivableBegin(String billsReceivableBegin) {
        this.billsReceivableBegin = billsReceivableBegin;
    }

    public String getBillsReceivableEnd() {
        return billsReceivableEnd;
    }

    public void setBillsReceivableEnd(String billsReceivableEnd) {
        this.billsReceivableEnd = billsReceivableEnd;
    }

    public String getBillsPayableBegin() {
        return billsPayableBegin;
    }

    public void setBillsPayableBegin(String billsPayableBegin) {
        this.billsPayableBegin = billsPayableBegin;
    }

    public String getBillsPayableEnd() {
        return billsPayableEnd;
    }

    public void setBillsPayableEnd(String billsPayableEnd) {
        this.billsPayableEnd = billsPayableEnd;
    }

    public String getAccountsReceivableBegin() {
        return accountsReceivableBegin;
    }

    public void setAccountsReceivableBegin(String accountsReceivableBegin) {
        this.accountsReceivableBegin = accountsReceivableBegin;
    }

    public String getAccountsReceivableEnd() {
        return accountsReceivableEnd;
    }

    public void setAccountsReceivableEnd(String accountsReceivableEnd) {
        this.accountsReceivableEnd = accountsReceivableEnd;
    }

    public String getAccountsPayableBegin() {
        return accountsPayableBegin;
    }

    public void setAccountsPayableBegin(String accountsPayableBegin) {
        this.accountsPayableBegin = accountsPayableBegin;
    }

    public String getAccountsPayableEnd() {
        return accountsPayableEnd;
    }

    public void setAccountsPayableEnd(String accountsPayableEnd) {
        this.accountsPayableEnd = accountsPayableEnd;
    }

    public String getAdvancePaymentBegin() {
        return advancePaymentBegin;
    }

    public void setAdvancePaymentBegin(String advancePaymentBegin) {
        this.advancePaymentBegin = advancePaymentBegin;
    }

    public String getAdvancePaymentEnd() {
        return advancePaymentEnd;
    }

    public void setAdvancePaymentEnd(String advancePaymentEnd) {
        this.advancePaymentEnd = advancePaymentEnd;
    }

    public String getPaymentInAdvanceBegin() {
        return paymentInAdvanceBegin;
    }

    public void setPaymentInAdvanceBegin(String paymentInAdvanceBegin) {
        this.paymentInAdvanceBegin = paymentInAdvanceBegin;
    }

    public String getPaymentInAdvanceEnd() {
        return paymentInAdvanceEnd;
    }

    public void setPaymentInAdvanceEnd(String paymentInAdvanceEnd) {
        this.paymentInAdvanceEnd = paymentInAdvanceEnd;
    }

    public String getInterestReceivableBegin() {
        return interestReceivableBegin;
    }

    public void setInterestReceivableBegin(String interestReceivableBegin) {
        this.interestReceivableBegin = interestReceivableBegin;
    }

    public String getInterestReceivableEnd() {
        return interestReceivableEnd;
    }

    public void setInterestReceivableEnd(String interestReceivableEnd) {
        this.interestReceivableEnd = interestReceivableEnd;
    }

    public String getPayrollPayableBegin() {
        return payrollPayableBegin;
    }

    public void setPayrollPayableBegin(String payrollPayableBegin) {
        this.payrollPayableBegin = payrollPayableBegin;
    }

    public String getPayrollPayableEnd() {
        return payrollPayableEnd;
    }

    public void setPayrollPayableEnd(String payrollPayableEnd) {
        this.payrollPayableEnd = payrollPayableEnd;
    }

    public String getDividendReceivableBegin() {
        return dividendReceivableBegin;
    }

    public void setDividendReceivableBegin(String dividendReceivableBegin) {
        this.dividendReceivableBegin = dividendReceivableBegin;
    }

    public String getDividendReceivableEnd() {
        return dividendReceivableEnd;
    }

    public void setDividendReceivableEnd(String dividendReceivableEnd) {
        this.dividendReceivableEnd = dividendReceivableEnd;
    }

    public String getTaxPayableBegin() {
        return taxPayableBegin;
    }

    public void setTaxPayableBegin(String taxPayableBegin) {
        this.taxPayableBegin = taxPayableBegin;
    }

    public String getTaxPayableEnd() {
        return taxPayableEnd;
    }

    public void setTaxPayableEnd(String taxPayableEnd) {
        this.taxPayableEnd = taxPayableEnd;
    }

    public String getOtherReceivablesBegin() {
        return otherReceivablesBegin;
    }

    public void setOtherReceivablesBegin(String otherReceivablesBegin) {
        this.otherReceivablesBegin = otherReceivablesBegin;
    }

    public String getOtherReceivablesEnd() {
        return otherReceivablesEnd;
    }

    public void setOtherReceivablesEnd(String otherReceivablesEnd) {
        this.otherReceivablesEnd = otherReceivablesEnd;
    }

    public String getInterestPayableBegin() {
        return interestPayableBegin;
    }

    public void setInterestPayableBegin(String interestPayableBegin) {
        this.interestPayableBegin = interestPayableBegin;
    }

    public String getInterestPayableEnd() {
        return interestPayableEnd;
    }

    public void setInterestPayableEnd(String interestPayableEnd) {
        this.interestPayableEnd = interestPayableEnd;
    }

    public String getStockBegin() {
        return stockBegin;
    }

    public void setStockBegin(String stockBegin) {
        this.stockBegin = stockBegin;
    }

    public String getStockEnd() {
        return stockEnd;
    }

    public void setStockEnd(String stockEnd) {
        this.stockEnd = stockEnd;
    }

    public String getDividendsPayableBegin() {
        return dividendsPayableBegin;
    }

    public void setDividendsPayableBegin(String dividendsPayableBegin) {
        this.dividendsPayableBegin = dividendsPayableBegin;
    }

    public String getDividendsPayableEnd() {
        return dividendsPayableEnd;
    }

    public void setDividendsPayableEnd(String dividendsPayableEnd) {
        this.dividendsPayableEnd = dividendsPayableEnd;
    }

    public String getNonCurrentAssetsExpiringWithinOneYearBegin() {
        return nonCurrentAssetsExpiringWithinOneYearBegin;
    }

    public void setNonCurrentAssetsExpiringWithinOneYearBegin(String nonCurrentAssetsExpiringWithinOneYearBegin) {
        this.nonCurrentAssetsExpiringWithinOneYearBegin = nonCurrentAssetsExpiringWithinOneYearBegin;
    }

    public String getNonCurrentAssetsExpiringWithinOneYearEnd() {
        return nonCurrentAssetsExpiringWithinOneYearEnd;
    }

    public void setNonCurrentAssetsExpiringWithinOneYearEnd(String nonCurrentAssetsExpiringWithinOneYearEnd) {
        this.nonCurrentAssetsExpiringWithinOneYearEnd = nonCurrentAssetsExpiringWithinOneYearEnd;
    }

    public String getOtherPayableBegin() {
        return otherPayableBegin;
    }

    public void setOtherPayableBegin(String otherPayableBegin) {
        this.otherPayableBegin = otherPayableBegin;
    }

    public String getOtherPayableEnd() {
        return otherPayableEnd;
    }

    public void setOtherPayableEnd(String otherPayableEnd) {
        this.otherPayableEnd = otherPayableEnd;
    }

    public String getOtherCurrentAssetsBegin() {
        return otherCurrentAssetsBegin;
    }

    public void setOtherCurrentAssetsBegin(String otherCurrentAssetsBegin) {
        this.otherCurrentAssetsBegin = otherCurrentAssetsBegin;
    }

    public String getOtherCurrentAssetsEnd() {
        return otherCurrentAssetsEnd;
    }

    public void setOtherCurrentAssetsEnd(String otherCurrentAssetsEnd) {
        this.otherCurrentAssetsEnd = otherCurrentAssetsEnd;
    }

    public String getNonCurrentLiabilitiesDueWithinOneYearBegin() {
        return nonCurrentLiabilitiesDueWithinOneYearBegin;
    }

    public void setNonCurrentLiabilitiesDueWithinOneYearBegin(String nonCurrentLiabilitiesDueWithinOneYearBegin) {
        this.nonCurrentLiabilitiesDueWithinOneYearBegin = nonCurrentLiabilitiesDueWithinOneYearBegin;
    }

    public String getNonCurrentLiabilitiesDueWithinOneYearEnd() {
        return nonCurrentLiabilitiesDueWithinOneYearEnd;
    }

    public void setNonCurrentLiabilitiesDueWithinOneYearEnd(String nonCurrentLiabilitiesDueWithinOneYearEnd) {
        this.nonCurrentLiabilitiesDueWithinOneYearEnd = nonCurrentLiabilitiesDueWithinOneYearEnd;
    }

    public String getTotalCurrentAssetsBegin() {
        return totalCurrentAssetsBegin;
    }

    public void setTotalCurrentAssetsBegin(String totalCurrentAssetsBegin) {
        this.totalCurrentAssetsBegin = totalCurrentAssetsBegin;
    }

    public String getTotalCurrentAssetsEnd() {
        return totalCurrentAssetsEnd;
    }

    public void setTotalCurrentAssetsEnd(String totalCurrentAssetsEnd) {
        this.totalCurrentAssetsEnd = totalCurrentAssetsEnd;
    }

    public String getOtherCurrentLiabilitiesBegin() {
        return otherCurrentLiabilitiesBegin;
    }

    public void setOtherCurrentLiabilitiesBegin(String otherCurrentLiabilitiesBegin) {
        this.otherCurrentLiabilitiesBegin = otherCurrentLiabilitiesBegin;
    }

    public String getOtherCurrentLiabilitiesEnd() {
        return otherCurrentLiabilitiesEnd;
    }

    public void setOtherCurrentLiabilitiesEnd(String otherCurrentLiabilitiesEnd) {
        this.otherCurrentLiabilitiesEnd = otherCurrentLiabilitiesEnd;
    }

    public String getTotalCurrentLiabilitiesBegin() {
        return totalCurrentLiabilitiesBegin;
    }

    public void setTotalCurrentLiabilitiesBegin(String totalCurrentLiabilitiesBegin) {
        this.totalCurrentLiabilitiesBegin = totalCurrentLiabilitiesBegin;
    }

    public String getTotalCurrentLiabilitiesEnd() {
        return totalCurrentLiabilitiesEnd;
    }

    public void setTotalCurrentLiabilitiesEnd(String totalCurrentLiabilitiesEnd) {
        this.totalCurrentLiabilitiesEnd = totalCurrentLiabilitiesEnd;
    }

    public String getAvailableForSaleFinancialAssetsBegin() {
        return availableForSaleFinancialAssetsBegin;
    }

    public void setAvailableForSaleFinancialAssetsBegin(String availableForSaleFinancialAssetsBegin) {
        this.availableForSaleFinancialAssetsBegin = availableForSaleFinancialAssetsBegin;
    }

    public String getAvailableForSaleFinancialAssetsEnd() {
        return availableForSaleFinancialAssetsEnd;
    }

    public void setAvailableForSaleFinancialAssetsEnd(String availableForSaleFinancialAssetsEnd) {
        this.availableForSaleFinancialAssetsEnd = availableForSaleFinancialAssetsEnd;
    }

    public String getHeldToMaturityInvestmentBegin() {
        return heldToMaturityInvestmentBegin;
    }

    public void setHeldToMaturityInvestmentBegin(String heldToMaturityInvestmentBegin) {
        this.heldToMaturityInvestmentBegin = heldToMaturityInvestmentBegin;
    }

    public String getHeldToMaturityInvestmentEnd() {
        return heldToMaturityInvestmentEnd;
    }

    public void setHeldToMaturityInvestmentEnd(String heldToMaturityInvestmentEnd) {
        this.heldToMaturityInvestmentEnd = heldToMaturityInvestmentEnd;
    }

    public String getLongTermBorrowingBegin() {
        return longTermBorrowingBegin;
    }

    public void setLongTermBorrowingBegin(String longTermBorrowingBegin) {
        this.longTermBorrowingBegin = longTermBorrowingBegin;
    }

    public String getLongTermBorrowingEnd() {
        return longTermBorrowingEnd;
    }

    public void setLongTermBorrowingEnd(String longTermBorrowingEnd) {
        this.longTermBorrowingEnd = longTermBorrowingEnd;
    }

    public String getLongTermReceivablesBegin() {
        return longTermReceivablesBegin;
    }

    public void setLongTermReceivablesBegin(String longTermReceivablesBegin) {
        this.longTermReceivablesBegin = longTermReceivablesBegin;
    }

    public String getLongTermReceivablesEnd() {
        return longTermReceivablesEnd;
    }

    public void setLongTermReceivablesEnd(String longTermReceivablesEnd) {
        this.longTermReceivablesEnd = longTermReceivablesEnd;
    }

    public String getBondsPayableBegin() {
        return bondsPayableBegin;
    }

    public void setBondsPayableBegin(String bondsPayableBegin) {
        this.bondsPayableBegin = bondsPayableBegin;
    }

    public String getBondsPayableEnd() {
        return bondsPayableEnd;
    }

    public void setBondsPayableEnd(String bondsPayableEnd) {
        this.bondsPayableEnd = bondsPayableEnd;
    }

    public String getLongTermEquityInvestmentBegin() {
        return longTermEquityInvestmentBegin;
    }

    public void setLongTermEquityInvestmentBegin(String longTermEquityInvestmentBegin) {
        this.longTermEquityInvestmentBegin = longTermEquityInvestmentBegin;
    }

    public String getLongTermEquityInvestmentEnd() {
        return longTermEquityInvestmentEnd;
    }

    public void setLongTermEquityInvestmentEnd(String longTermEquityInvestmentEnd) {
        this.longTermEquityInvestmentEnd = longTermEquityInvestmentEnd;
    }

    public String getLongTermPayablesBegin() {
        return longTermPayablesBegin;
    }

    public void setLongTermPayablesBegin(String longTermPayablesBegin) {
        this.longTermPayablesBegin = longTermPayablesBegin;
    }

    public String getLongTermPayablesEnd() {
        return longTermPayablesEnd;
    }

    public void setLongTermPayablesEnd(String longTermPayablesEnd) {
        this.longTermPayablesEnd = longTermPayablesEnd;
    }

    public String getInvestmentRealEstateBegin() {
        return investmentRealEstateBegin;
    }

    public void setInvestmentRealEstateBegin(String investmentRealEstateBegin) {
        this.investmentRealEstateBegin = investmentRealEstateBegin;
    }

    public String getInvestmentRealEstateEnd() {
        return investmentRealEstateEnd;
    }

    public void setInvestmentRealEstateEnd(String investmentRealEstateEnd) {
        this.investmentRealEstateEnd = investmentRealEstateEnd;
    }

    public String getSpecialPayableBegin() {
        return specialPayableBegin;
    }

    public void setSpecialPayableBegin(String specialPayableBegin) {
        this.specialPayableBegin = specialPayableBegin;
    }

    public String getSpecialPayableEnd() {
        return specialPayableEnd;
    }

    public void setSpecialPayableEnd(String specialPayableEnd) {
        this.specialPayableEnd = specialPayableEnd;
    }

    public String getFixedAssetsBegin() {
        return fixedAssetsBegin;
    }

    public void setFixedAssetsBegin(String fixedAssetsBegin) {
        this.fixedAssetsBegin = fixedAssetsBegin;
    }

    public String getFixedAssetsEnd() {
        return fixedAssetsEnd;
    }

    public void setFixedAssetsEnd(String fixedAssetsEnd) {
        this.fixedAssetsEnd = fixedAssetsEnd;
    }

    public String getProjectedLiabilitiesBegin() {
        return projectedLiabilitiesBegin;
    }

    public void setProjectedLiabilitiesBegin(String projectedLiabilitiesBegin) {
        this.projectedLiabilitiesBegin = projectedLiabilitiesBegin;
    }

    public String getProjectedLiabilitiesEnd() {
        return projectedLiabilitiesEnd;
    }

    public void setProjectedLiabilitiesEnd(String projectedLiabilitiesEnd) {
        this.projectedLiabilitiesEnd = projectedLiabilitiesEnd;
    }

    public String getConstructionInProgressBegin() {
        return constructionInProgressBegin;
    }

    public void setConstructionInProgressBegin(String constructionInProgressBegin) {
        this.constructionInProgressBegin = constructionInProgressBegin;
    }

    public String getConstructionInProgressEnd() {
        return constructionInProgressEnd;
    }

    public void setConstructionInProgressEnd(String constructionInProgressEnd) {
        this.constructionInProgressEnd = constructionInProgressEnd;
    }

    public String getDeferredIncomeBegin() {
        return deferredIncomeBegin;
    }

    public void setDeferredIncomeBegin(String deferredIncomeBegin) {
        this.deferredIncomeBegin = deferredIncomeBegin;
    }

    public String getDeferredIncomeEnd() {
        return deferredIncomeEnd;
    }

    public void setDeferredIncomeEnd(String deferredIncomeEnd) {
        this.deferredIncomeEnd = deferredIncomeEnd;
    }

    public String getEngineeringMaterialsBegin() {
        return engineeringMaterialsBegin;
    }

    public void setEngineeringMaterialsBegin(String engineeringMaterialsBegin) {
        this.engineeringMaterialsBegin = engineeringMaterialsBegin;
    }

    public String getEngineeringMaterialsEnd() {
        return engineeringMaterialsEnd;
    }

    public void setEngineeringMaterialsEnd(String engineeringMaterialsEnd) {
        this.engineeringMaterialsEnd = engineeringMaterialsEnd;
    }

    public String getDeferredTaxLiabilityBegin() {
        return deferredTaxLiabilityBegin;
    }

    public void setDeferredTaxLiabilityBegin(String deferredTaxLiabilityBegin) {
        this.deferredTaxLiabilityBegin = deferredTaxLiabilityBegin;
    }

    public String getDeferredTaxLiabilityEnd() {
        return deferredTaxLiabilityEnd;
    }

    public void setDeferredTaxLiabilityEnd(String deferredTaxLiabilityEnd) {
        this.deferredTaxLiabilityEnd = deferredTaxLiabilityEnd;
    }

    public String getLiquidationOfFixedAssetsBegin() {
        return liquidationOfFixedAssetsBegin;
    }

    public void setLiquidationOfFixedAssetsBegin(String liquidationOfFixedAssetsBegin) {
        this.liquidationOfFixedAssetsBegin = liquidationOfFixedAssetsBegin;
    }

    public String getLiquidationOfFixedAssetsEnd() {
        return liquidationOfFixedAssetsEnd;
    }

    public void setLiquidationOfFixedAssetsEnd(String liquidationOfFixedAssetsEnd) {
        this.liquidationOfFixedAssetsEnd = liquidationOfFixedAssetsEnd;
    }

    public String getOtherNonCurrentLiabilitiesBegin() {
        return otherNonCurrentLiabilitiesBegin;
    }

    public void setOtherNonCurrentLiabilitiesBegin(String otherNonCurrentLiabilitiesBegin) {
        this.otherNonCurrentLiabilitiesBegin = otherNonCurrentLiabilitiesBegin;
    }

    public String getOtherNonCurrentLiabilitiesEnd() {
        return otherNonCurrentLiabilitiesEnd;
    }

    public void setOtherNonCurrentLiabilitiesEnd(String otherNonCurrentLiabilitiesEnd) {
        this.otherNonCurrentLiabilitiesEnd = otherNonCurrentLiabilitiesEnd;
    }

    public String getProductiveBiologicalAssetsBegin() {
        return productiveBiologicalAssetsBegin;
    }

    public void setProductiveBiologicalAssetsBegin(String productiveBiologicalAssetsBegin) {
        this.productiveBiologicalAssetsBegin = productiveBiologicalAssetsBegin;
    }

    public String getProductiveBiologicalAssetsEnd() {
        return productiveBiologicalAssetsEnd;
    }

    public void setProductiveBiologicalAssetsEnd(String productiveBiologicalAssetsEnd) {
        this.productiveBiologicalAssetsEnd = productiveBiologicalAssetsEnd;
    }

    public String getTotalNonCurrentLiabilitiesBegin() {
        return totalNonCurrentLiabilitiesBegin;
    }

    public void setTotalNonCurrentLiabilitiesBegin(String totalNonCurrentLiabilitiesBegin) {
        this.totalNonCurrentLiabilitiesBegin = totalNonCurrentLiabilitiesBegin;
    }

    public String getTotalNonCurrentLiabilitiesEnd() {
        return totalNonCurrentLiabilitiesEnd;
    }

    public void setTotalNonCurrentLiabilitiesEnd(String totalNonCurrentLiabilitiesEnd) {
        this.totalNonCurrentLiabilitiesEnd = totalNonCurrentLiabilitiesEnd;
    }

    public String getOilAndGasAssetsBegin() {
        return oilAndGasAssetsBegin;
    }

    public void setOilAndGasAssetsBegin(String oilAndGasAssetsBegin) {
        this.oilAndGasAssetsBegin = oilAndGasAssetsBegin;
    }

    public String getOilAndGasAssetsEnd() {
        return oilAndGasAssetsEnd;
    }

    public void setOilAndGasAssetsEnd(String oilAndGasAssetsEnd) {
        this.oilAndGasAssetsEnd = oilAndGasAssetsEnd;
    }

    public String getTotalLiabilitiesBegin() {
        return totalLiabilitiesBegin;
    }

    public void setTotalLiabilitiesBegin(String totalLiabilitiesBegin) {
        this.totalLiabilitiesBegin = totalLiabilitiesBegin;
    }

    public String getTotalLiabilitiesEnd() {
        return totalLiabilitiesEnd;
    }

    public void setTotalLiabilitiesEnd(String totalLiabilitiesEnd) {
        this.totalLiabilitiesEnd = totalLiabilitiesEnd;
    }

    public String getIntangibleAssetsBegin() {
        return intangibleAssetsBegin;
    }

    public void setIntangibleAssetsBegin(String intangibleAssetsBegin) {
        this.intangibleAssetsBegin = intangibleAssetsBegin;
    }

    public String getIntangibleAssetsEnd() {
        return intangibleAssetsEnd;
    }

    public void setIntangibleAssetsEnd(String intangibleAssetsEnd) {
        this.intangibleAssetsEnd = intangibleAssetsEnd;
    }

    public String getDevelopmentExpenditureBegin() {
        return developmentExpenditureBegin;
    }

    public void setDevelopmentExpenditureBegin(String developmentExpenditureBegin) {
        this.developmentExpenditureBegin = developmentExpenditureBegin;
    }

    public String getDevelopmentExpenditureEnd() {
        return developmentExpenditureEnd;
    }

    public void setDevelopmentExpenditureEnd(String developmentExpenditureEnd) {
        this.developmentExpenditureEnd = developmentExpenditureEnd;
    }

    public String getPaidInCapitalBegin() {
        return paidInCapitalBegin;
    }

    public void setPaidInCapitalBegin(String paidInCapitalBegin) {
        this.paidInCapitalBegin = paidInCapitalBegin;
    }

    public String getPaidInCapitalEnd() {
        return paidInCapitalEnd;
    }

    public void setPaidInCapitalEnd(String paidInCapitalEnd) {
        this.paidInCapitalEnd = paidInCapitalEnd;
    }

    public String getGoodwillBegin() {
        return goodwillBegin;
    }

    public void setGoodwillBegin(String goodwillBegin) {
        this.goodwillBegin = goodwillBegin;
    }

    public String getGoodwillEnd() {
        return goodwillEnd;
    }

    public void setGoodwillEnd(String goodwillEnd) {
        this.goodwillEnd = goodwillEnd;
    }

    public String getCapitalSurplusBegin() {
        return capitalSurplusBegin;
    }

    public void setCapitalSurplusBegin(String capitalSurplusBegin) {
        this.capitalSurplusBegin = capitalSurplusBegin;
    }

    public String getCapitalSurplusEnd() {
        return capitalSurplusEnd;
    }

    public void setCapitalSurplusEnd(String capitalSurplusEnd) {
        this.capitalSurplusEnd = capitalSurplusEnd;
    }

    public String getLongTermPrepaidExpensesBegin() {
        return longTermPrepaidExpensesBegin;
    }

    public void setLongTermPrepaidExpensesBegin(String longTermPrepaidExpensesBegin) {
        this.longTermPrepaidExpensesBegin = longTermPrepaidExpensesBegin;
    }

    public String getLongTermPrepaidExpensesEnd() {
        return longTermPrepaidExpensesEnd;
    }

    public void setLongTermPrepaidExpensesEnd(String longTermPrepaidExpensesEnd) {
        this.longTermPrepaidExpensesEnd = longTermPrepaidExpensesEnd;
    }

    public String getTreasuryStockBegin() {
        return treasuryStockBegin;
    }

    public void setTreasuryStockBegin(String treasuryStockBegin) {
        this.treasuryStockBegin = treasuryStockBegin;
    }

    public String getTreasuryStockEnd() {
        return treasuryStockEnd;
    }

    public void setTreasuryStockEnd(String treasuryStockEnd) {
        this.treasuryStockEnd = treasuryStockEnd;
    }

    public String getDeferredTaxAssetsBegin() {
        return deferredTaxAssetsBegin;
    }

    public void setDeferredTaxAssetsBegin(String deferredTaxAssetsBegin) {
        this.deferredTaxAssetsBegin = deferredTaxAssetsBegin;
    }

    public String getDeferredTaxAssetsEnd() {
        return deferredTaxAssetsEnd;
    }

    public void setDeferredTaxAssetsEnd(String deferredTaxAssetsEnd) {
        this.deferredTaxAssetsEnd = deferredTaxAssetsEnd;
    }

    public String getOtherComprehensiveIncomeBegin() {
        return otherComprehensiveIncomeBegin;
    }

    public void setOtherComprehensiveIncomeBegin(String otherComprehensiveIncomeBegin) {
        this.otherComprehensiveIncomeBegin = otherComprehensiveIncomeBegin;
    }

    public String getOtherComprehensiveIncomeEnd() {
        return otherComprehensiveIncomeEnd;
    }

    public void setOtherComprehensiveIncomeEnd(String otherComprehensiveIncomeEnd) {
        this.otherComprehensiveIncomeEnd = otherComprehensiveIncomeEnd;
    }

    public String getOtherNonCurrentAssetsBegin() {
        return otherNonCurrentAssetsBegin;
    }

    public void setOtherNonCurrentAssetsBegin(String otherNonCurrentAssetsBegin) {
        this.otherNonCurrentAssetsBegin = otherNonCurrentAssetsBegin;
    }

    public String getOtherNonCurrentAssetsEnd() {
        return otherNonCurrentAssetsEnd;
    }

    public void setOtherNonCurrentAssetsEnd(String otherNonCurrentAssetsEnd) {
        this.otherNonCurrentAssetsEnd = otherNonCurrentAssetsEnd;
    }

    public String getSurplusReserveBegin() {
        return surplusReserveBegin;
    }

    public void setSurplusReserveBegin(String surplusReserveBegin) {
        this.surplusReserveBegin = surplusReserveBegin;
    }

    public String getSurplusReserveEnd() {
        return surplusReserveEnd;
    }

    public void setSurplusReserveEnd(String surplusReserveEnd) {
        this.surplusReserveEnd = surplusReserveEnd;
    }

    public String getTotalNonCurrentAssetsBegin() {
        return totalNonCurrentAssetsBegin;
    }

    public void setTotalNonCurrentAssetsBegin(String totalNonCurrentAssetsBegin) {
        this.totalNonCurrentAssetsBegin = totalNonCurrentAssetsBegin;
    }

    public String getTotalNonCurrentAssetsEnd() {
        return totalNonCurrentAssetsEnd;
    }

    public void setTotalNonCurrentAssetsEnd(String totalNonCurrentAssetsEnd) {
        this.totalNonCurrentAssetsEnd = totalNonCurrentAssetsEnd;
    }

    public String getUndistributedProfitBegin() {
        return undistributedProfitBegin;
    }

    public void setUndistributedProfitBegin(String undistributedProfitBegin) {
        this.undistributedProfitBegin = undistributedProfitBegin;
    }

    public String getUndistributedProfitEnd() {
        return undistributedProfitEnd;
    }

    public void setUndistributedProfitEnd(String undistributedProfitEnd) {
        this.undistributedProfitEnd = undistributedProfitEnd;
    }

    public String getTotalOwnerEquityBegin() {
        return totalOwnerEquityBegin;
    }

    public void setTotalOwnerEquityBegin(String totalOwnerEquityBegin) {
        this.totalOwnerEquityBegin = totalOwnerEquityBegin;
    }

    public String getTotalOwnerEquityEnd() {
        return totalOwnerEquityEnd;
    }

    public void setTotalOwnerEquityEnd(String totalOwnerEquityEnd) {
        this.totalOwnerEquityEnd = totalOwnerEquityEnd;
    }

    public String getTotalAssetsBegin() {
        return totalAssetsBegin;
    }

    public void setTotalAssetsBegin(String totalAssetsBegin) {
        this.totalAssetsBegin = totalAssetsBegin;
    }

    public String getTotalAssetsEnd() {
        return totalAssetsEnd;
    }

    public void setTotalAssetsEnd(String totalAssetsEnd) {
        this.totalAssetsEnd = totalAssetsEnd;
    }

    public String getTotalLiabilitiesAndOwnerEquityBegin() {
        return totalLiabilitiesAndOwnerEquityBegin;
    }

    public void setTotalLiabilitiesAndOwnerEquityBegin(String totalLiabilitiesAndOwnerEquityBegin) {
        this.totalLiabilitiesAndOwnerEquityBegin = totalLiabilitiesAndOwnerEquityBegin;
    }

    public String getTotalLiabilitiesAndOwnerEquityEnd() {
        return totalLiabilitiesAndOwnerEquityEnd;
    }

    public void setTotalLiabilitiesAndOwnerEquityEnd(String totalLiabilitiesAndOwnerEquityEnd) {
        this.totalLiabilitiesAndOwnerEquityEnd = totalLiabilitiesAndOwnerEquityEnd;
    }

    public String getDeclareTime() {
        return declareTime;
    }

    public void setDeclareTime(String declareTime) {
        this.declareTime = declareTime;
    }
}

package com.xlh.crm.dto.mysql.ods;

import javax.persistence.Id;

public class OdsXlhDataformatYpSmallBalanceTable {
    @Id
    private Integer id;
    private String fileName;
    private String createTime;
    private String enterpriseName="";      //纳税人名称
    private String creditNo;        //社会信用代码
    private String beginTime;       //所属期起
    private String endTime;         //所属期止
    private String unit;        //单位
    private String monetaryFundBegin;       //货币资金
    private String monetaryFundEnd;
    private String shortTermBorrowingBegin;     //短期借款
    private String shortTermBorrowingEnd;
    private String shortTermInvestmentBegin;        //短期投资
    private String shortTermInvestmentEnd;
    private String billsPayableBegin;       //应付票据
    private String billsPayableEnd;
    private String billsReceivableBegin;        //应收票据
    private String billsReceivableEnd;
    private String accountsPayableBegin;        //应付账款
    private String accountsPayableEnd;
    private String accountsReceivableBegin;     //应收账款
    private String accountsReceivableEnd;
    private String accountsReceivedBegin;       //预收账款
    private String accountsReceivedEnd;
    private String accountsPayiedBegin;     //预付账款
    private String accountsPayiedEnd;
    private String payrollPayableBegin;     //应付职工薪酬
    private String payrollPayableEnd;
    private String dividendReceivableBegin;     //应收股利
    private String dividendReceivableEnd;
    private String taxPayableBegin;     //应交税费
    private String taxPayableEnd;
    private String interestReceivableBegin;     //应收利息
    private String interestReceivableEnd;
    private String interestPayableBegin;        //应付利息
    private String interestPayableEnd;
    private String otherReceivablesBegin;       //其他应收款
    private String otherReceivablesEnd;
    private String profitPayableBegin;      //应付利润
    private String profitPayableEnd;
    private String stockBegin;      //存货
    private String stockEnd;
    private String otherPayableBegin;       //其他应付款
    private String otherPayableEnd;
    private String rawMaterialBegin;        //原材料
    private String rawMaterialEnd;
    private String otherCurrentLiabilitiesBegin;        //其他流动负债
    private String otherCurrentLiabilitiesEnd;
    private String inProductBegin;      //在产品
    private String inProductEnd;
    private String totalCurrentLiabilitiesBegin;        //流动负债合计
    private String totalCurrentLiabilitiesEnd;
    private String merchandiseInventoryBegin;       //库存商品
    private String merchandiseInventoryEnd;
    private String workingCapitalConstructionMaterialsBegin;        //周转材料
    private String workingCapitalConstructionMaterialsEnd;
    private String longTermBorrowingBegin;      //长期借款
    private String longTermBorrowingEnd;
    private String otherCurrentAssetsBegin;     //其他流动资产
    private String otherCurrentAssetsEnd;
    private String longTermPayablesBegin;       //长期应付款
    private String longTermPayablesEnd;
    private String totalCurrentAssetsBegin;     //流动资产合计
    private String totalCurrentAssetsEnd;
    private String deferredIncomeBegin;     //递延收益
    private String deferredIncomeEnd;
    private String otherNonCurrentLiabilitiesBegin;     //其他非流动负债
    private String otherNonCurrentLiabilitiesEnd;
    private String longTermBondInvestmentBegin;     //长期债券投资
    private String longTermBondInvestmentEnd;
    private String totalNonCurrentLiabilitiesBegin;     //非流动负债合计
    private String totalNonCurrentLiabilitiesEnd;
    private String longTermEquityInvestmentBegin;       //长期股权投资
    private String longTermEquityInvestmentEnd;
    private String totalLiabilitiesBegin;       //负债合计
    private String totalLiabilitiesEnd;
    private String originalPriceOfFixedAssetsBegin;     //固定资产原价
    private String originalPriceOfFixedAssetsEnd;
    private String accumulatedDepreciationBegin;        //累计折旧
    private String accumulatedDepreciationEnd;
    private String bookValueOfFixedAssetsBegin;     //固定资产账面价值
    private String bookValueOfFixedAssetsEnd;
    private String constructionInProgressBegin;     //在建工程
    private String constructionInProgressEnd;
    private String engineeringMaterialsBegin;       //工程物资
    private String engineeringMaterialsEnd;
    private String liquidationOfFixedAssetsBegin;       //固定资产清理
    private String liquidationOfFixedAssetsEnd;
    private String viologicalViologicalAssetsBegin;     //生物性生物资产
    private String viologicalViologicalAssetsEnd;
    private String intangibleAssetsBegin;       //无形资产
    private String intangibleAssetsEnd;
    private String paidInCapitalBegin;      //实收资本
    private String paidInCapitalEnd;
    private String developmentExpenditureBegin;     //开发支出
    private String developmentExpenditureEnd;
    private String capitalSurplusBegin;     //资本公积
    private String capitalSurplusEnd;
    private String longTermPrepaidExpensesBegin;        //长期待摊费用
    private String longTermPrepaidExpensesEnd;
    private String surplusReserveBegin;     //盈余公积
    private String surplusReserveEnd;
    private String otherNonCurrentAssetsBegin;      //其他非流动资产
    private String otherNonCurrentAssetsEnd;
    private String undistributedProfitBegin;        //未分配利润
    private String undistributedProfitEnd;
    private String totalNonCurrentAssetsBegin;      //非流动资产合计
    private String totalNonCurrentAssetsEnd;
    private String TotalOwnerEquityBegin;       //所有者权益（或股东权益）合计
    private String TotalOwnerEquityEnd;
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

    public String getShortTermInvestmentBegin() {
        return shortTermInvestmentBegin;
    }

    public void setShortTermInvestmentBegin(String shortTermInvestmentBegin) {
        this.shortTermInvestmentBegin = shortTermInvestmentBegin;
    }

    public String getShortTermInvestmentEnd() {
        return shortTermInvestmentEnd;
    }

    public void setShortTermInvestmentEnd(String shortTermInvestmentEnd) {
        this.shortTermInvestmentEnd = shortTermInvestmentEnd;
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

    public String getAccountsReceivedBegin() {
        return accountsReceivedBegin;
    }

    public void setAccountsReceivedBegin(String accountsReceivedBegin) {
        this.accountsReceivedBegin = accountsReceivedBegin;
    }

    public String getAccountsReceivedEnd() {
        return accountsReceivedEnd;
    }

    public void setAccountsReceivedEnd(String accountsReceivedEnd) {
        this.accountsReceivedEnd = accountsReceivedEnd;
    }

    public String getAccountsPayiedBegin() {
        return accountsPayiedBegin;
    }

    public void setAccountsPayiedBegin(String accountsPayiedBegin) {
        this.accountsPayiedBegin = accountsPayiedBegin;
    }

    public String getAccountsPayiedEnd() {
        return accountsPayiedEnd;
    }

    public void setAccountsPayiedEnd(String accountsPayiedEnd) {
        this.accountsPayiedEnd = accountsPayiedEnd;
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

    public String getProfitPayableBegin() {
        return profitPayableBegin;
    }

    public void setProfitPayableBegin(String profitPayableBegin) {
        this.profitPayableBegin = profitPayableBegin;
    }

    public String getProfitPayableEnd() {
        return profitPayableEnd;
    }

    public void setProfitPayableEnd(String profitPayableEnd) {
        this.profitPayableEnd = profitPayableEnd;
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

    public String getRawMaterialBegin() {
        return rawMaterialBegin;
    }

    public void setRawMaterialBegin(String rawMaterialBegin) {
        this.rawMaterialBegin = rawMaterialBegin;
    }

    public String getRawMaterialEnd() {
        return rawMaterialEnd;
    }

    public void setRawMaterialEnd(String rawMaterialEnd) {
        this.rawMaterialEnd = rawMaterialEnd;
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

    public String getInProductBegin() {
        return inProductBegin;
    }

    public void setInProductBegin(String inProductBegin) {
        this.inProductBegin = inProductBegin;
    }

    public String getInProductEnd() {
        return inProductEnd;
    }

    public void setInProductEnd(String inProductEnd) {
        this.inProductEnd = inProductEnd;
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

    public String getMerchandiseInventoryBegin() {
        return merchandiseInventoryBegin;
    }

    public void setMerchandiseInventoryBegin(String merchandiseInventoryBegin) {
        this.merchandiseInventoryBegin = merchandiseInventoryBegin;
    }

    public String getMerchandiseInventoryEnd() {
        return merchandiseInventoryEnd;
    }

    public void setMerchandiseInventoryEnd(String merchandiseInventoryEnd) {
        this.merchandiseInventoryEnd = merchandiseInventoryEnd;
    }

    public String getWorkingCapitalConstructionMaterialsBegin() {
        return workingCapitalConstructionMaterialsBegin;
    }

    public void setWorkingCapitalConstructionMaterialsBegin(String workingCapitalConstructionMaterialsBegin) {
        this.workingCapitalConstructionMaterialsBegin = workingCapitalConstructionMaterialsBegin;
    }

    public String getWorkingCapitalConstructionMaterialsEnd() {
        return workingCapitalConstructionMaterialsEnd;
    }

    public void setWorkingCapitalConstructionMaterialsEnd(String workingCapitalConstructionMaterialsEnd) {
        this.workingCapitalConstructionMaterialsEnd = workingCapitalConstructionMaterialsEnd;
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

    public String getLongTermBondInvestmentBegin() {
        return longTermBondInvestmentBegin;
    }

    public void setLongTermBondInvestmentBegin(String longTermBondInvestmentBegin) {
        this.longTermBondInvestmentBegin = longTermBondInvestmentBegin;
    }

    public String getLongTermBondInvestmentEnd() {
        return longTermBondInvestmentEnd;
    }

    public void setLongTermBondInvestmentEnd(String longTermBondInvestmentEnd) {
        this.longTermBondInvestmentEnd = longTermBondInvestmentEnd;
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

    public String getOriginalPriceOfFixedAssetsBegin() {
        return originalPriceOfFixedAssetsBegin;
    }

    public void setOriginalPriceOfFixedAssetsBegin(String originalPriceOfFixedAssetsBegin) {
        this.originalPriceOfFixedAssetsBegin = originalPriceOfFixedAssetsBegin;
    }

    public String getOriginalPriceOfFixedAssetsEnd() {
        return originalPriceOfFixedAssetsEnd;
    }

    public void setOriginalPriceOfFixedAssetsEnd(String originalPriceOfFixedAssetsEnd) {
        this.originalPriceOfFixedAssetsEnd = originalPriceOfFixedAssetsEnd;
    }

    public String getAccumulatedDepreciationBegin() {
        return accumulatedDepreciationBegin;
    }

    public void setAccumulatedDepreciationBegin(String accumulatedDepreciationBegin) {
        this.accumulatedDepreciationBegin = accumulatedDepreciationBegin;
    }

    public String getAccumulatedDepreciationEnd() {
        return accumulatedDepreciationEnd;
    }

    public void setAccumulatedDepreciationEnd(String accumulatedDepreciationEnd) {
        this.accumulatedDepreciationEnd = accumulatedDepreciationEnd;
    }

    public String getBookValueOfFixedAssetsBegin() {
        return bookValueOfFixedAssetsBegin;
    }

    public void setBookValueOfFixedAssetsBegin(String bookValueOfFixedAssetsBegin) {
        this.bookValueOfFixedAssetsBegin = bookValueOfFixedAssetsBegin;
    }

    public String getBookValueOfFixedAssetsEnd() {
        return bookValueOfFixedAssetsEnd;
    }

    public void setBookValueOfFixedAssetsEnd(String bookValueOfFixedAssetsEnd) {
        this.bookValueOfFixedAssetsEnd = bookValueOfFixedAssetsEnd;
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

    public String getViologicalViologicalAssetsBegin() {
        return viologicalViologicalAssetsBegin;
    }

    public void setViologicalViologicalAssetsBegin(String viologicalViologicalAssetsBegin) {
        this.viologicalViologicalAssetsBegin = viologicalViologicalAssetsBegin;
    }

    public String getViologicalViologicalAssetsEnd() {
        return viologicalViologicalAssetsEnd;
    }

    public void setViologicalViologicalAssetsEnd(String viologicalViologicalAssetsEnd) {
        this.viologicalViologicalAssetsEnd = viologicalViologicalAssetsEnd;
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

    public String getTotalOwnerEquityBegin() {
        return TotalOwnerEquityBegin;
    }

    public void setTotalOwnerEquityBegin(String totalOwnerEquityBegin) {
        TotalOwnerEquityBegin = totalOwnerEquityBegin;
    }

    public String getTotalOwnerEquityEnd() {
        return TotalOwnerEquityEnd;
    }

    public void setTotalOwnerEquityEnd(String totalOwnerEquityEnd) {
        TotalOwnerEquityEnd = totalOwnerEquityEnd;
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

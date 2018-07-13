package com.xlh.crm.dto.mysql.ods;

import javax.persistence.Id;

public class OdsXlhDataformatYpNormalProfitTable {
    @Id
    private Integer id;
    private String fileName;
    private String createTime;
    private String enterpriseName="";      //企业名称
    private String creditNo;       //社会信用代码
    private String beginTime;       //所属期起
    private String endTime;     //所属期止
    private String unit;        //单位

    private String businessIncomeThis;       //营业收入
    private String businessIncomeLast;
    private String operatingCostsThis;       //营业成本
    private String operatingCostsLast;
    private String operatingTaxesAndSurchargesThis;      //营业税金及附加
    private String operatingTaxesAndSurchargesLast;
    private String sellingExpensesThis;      //销售费用
    private String sellingExpensesLast;
    private String managementExpensesThis;       //管理费用
    private String managementExpensesLast;
    private String financialExpensesThis;        //财务费用
    private String financialExpensesLast;
    private String assetsImpairmentLossThis;     //资产减值损失
    private String assetsImpairmentLossLast;
    private String incomeFromChangesInFairValueThis;     //公允价值变动收益
    private String incomeFromChangesInFairValueLast;
    private String incomeFromInvestmentThis;     //投资收益
    private String incomeFromInvestmentLast;
    private String investmentIncomeForJointVenturesAndJointVenturesThis;     //对联营企业和合营企业的投资收益
    private String investmentIncomeForJointVenturesAndJointVenturesLast;
    private String operatingProfitThis;      //营业利润
    private String operatingProfitLast;
    private String nonOperatingIncomeThis;       //营业外收入
    private String nonOperatingIncomeLast;
    private String nonCurrentAssetsDisposalGainsThis;        //非流动资产处置利得
    private String nonCurrentAssetsDisposalGainsLast;
    private String nonOperatingExpensesThis;     //营业外支出
    private String nonOperatingExpensesLast;
    private String disposalLossOfNonCurrentAssetsThis;       //非流动资产处置损失
    private String disposalLossOfNonCurrentAssetsLast;
    private String totalProfitThis;      //利润总额
    private String totalProfitLast;
    private String incomeTaxExpenseThis;     //所得税费用
    private String incomeTaxExpenseLast;
    private String netProfitThis;        //净利润
    private String netProfitLast;
    private String netIncomeOfOtherComprehensiveIncomeThis;      //其他综合收益的税后净额
    private String netIncomeOfOtherComprehensiveIncomeLast;
    private String canNotBeReclassifiedIncomeThis;       //以后不能重分类进损益的其他综合收益
    private String canNotBeReclassifiedIncomeLast;
    private String changeInTheYieldPlanThis;     //重新计量设定收益计划净负债或净资产的变动
    private String changeInTheYieldPlanLast;
    private String cannotBeReclassifiedInLawThis;        //权益法下在被投资单位不能重分类进损益的其他综合收益中享有的份额
    private String cannotBeReclassifiedInLawLast;
    private String willBeReclassifiedIncomeThis;     //以后将重分类进损益的其他综合收益
    private String willBeReclassifiedIncomeLast;
    private String willBeReclassifiedInLawThis;     //权益法下在被投资单位以后将重分类进损益的其他综合收益中享有的份额
    private String willBeReclassifiedInLawLast;
    private String availableForSaleFinancialAssetsThis;      //可供出售金融资产公允价值变动损益
    private String availableForSaleFinancialAssetsLast;
    private String subjectToMaturityInvestmentsThis;     //将有至到期投资重分类可供出售金融资产损益
    private String subjectToMaturityInvestmentsLast;
    private String cashFlowsThroughTheEffectivePortionThis;      //现金流经套期损益的有效部分
    private String cashFlowsThroughTheEffectivePortionLast;
    private String translationBalanceOfForeignThis;      //外币财务报表折算差额
    private String translationBalanceOfForeignLast;
    private String totalComprehensiveIncomeThis;     //综合收益总额
    private String totalComprehensiveIncomeLast;
    private String basicEpsThis;     //基本每股收益
    private String basicEpsLast;
    private String dilutedEarningsPerShareThis;      //稀释每股收益
    private String dilutedEarningsPerShareLast;
    private String declareTime;

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

    public String getBusinessIncomeThis() {
        return businessIncomeThis;
    }

    public void setBusinessIncomeThis(String businessIncomeThis) {
        this.businessIncomeThis = businessIncomeThis;
    }

    public String getBusinessIncomeLast() {
        return businessIncomeLast;
    }

    public void setBusinessIncomeLast(String businessIncomeLast) {
        this.businessIncomeLast = businessIncomeLast;
    }

    public String getOperatingCostsThis() {
        return operatingCostsThis;
    }

    public void setOperatingCostsThis(String operatingCostsThis) {
        this.operatingCostsThis = operatingCostsThis;
    }

    public String getOperatingCostsLast() {
        return operatingCostsLast;
    }

    public void setOperatingCostsLast(String operatingCostsLast) {
        this.operatingCostsLast = operatingCostsLast;
    }

    public String getOperatingTaxesAndSurchargesThis() {
        return operatingTaxesAndSurchargesThis;
    }

    public void setOperatingTaxesAndSurchargesThis(String operatingTaxesAndSurchargesThis) {
        this.operatingTaxesAndSurchargesThis = operatingTaxesAndSurchargesThis;
    }

    public String getOperatingTaxesAndSurchargesLast() {
        return operatingTaxesAndSurchargesLast;
    }

    public void setOperatingTaxesAndSurchargesLast(String operatingTaxesAndSurchargesLast) {
        this.operatingTaxesAndSurchargesLast = operatingTaxesAndSurchargesLast;
    }

    public String getSellingExpensesThis() {
        return sellingExpensesThis;
    }

    public void setSellingExpensesThis(String sellingExpensesThis) {
        this.sellingExpensesThis = sellingExpensesThis;
    }

    public String getSellingExpensesLast() {
        return sellingExpensesLast;
    }

    public void setSellingExpensesLast(String sellingExpensesLast) {
        this.sellingExpensesLast = sellingExpensesLast;
    }

    public String getManagementExpensesThis() {
        return managementExpensesThis;
    }

    public void setManagementExpensesThis(String managementExpensesThis) {
        this.managementExpensesThis = managementExpensesThis;
    }

    public String getManagementExpensesLast() {
        return managementExpensesLast;
    }

    public void setManagementExpensesLast(String managementExpensesLast) {
        this.managementExpensesLast = managementExpensesLast;
    }

    public String getFinancialExpensesThis() {
        return financialExpensesThis;
    }

    public void setFinancialExpensesThis(String financialExpensesThis) {
        this.financialExpensesThis = financialExpensesThis;
    }

    public String getFinancialExpensesLast() {
        return financialExpensesLast;
    }

    public void setFinancialExpensesLast(String financialExpensesLast) {
        this.financialExpensesLast = financialExpensesLast;
    }

    public String getAssetsImpairmentLossThis() {
        return assetsImpairmentLossThis;
    }

    public void setAssetsImpairmentLossThis(String assetsImpairmentLossThis) {
        this.assetsImpairmentLossThis = assetsImpairmentLossThis;
    }

    public String getAssetsImpairmentLossLast() {
        return assetsImpairmentLossLast;
    }

    public void setAssetsImpairmentLossLast(String assetsImpairmentLossLast) {
        this.assetsImpairmentLossLast = assetsImpairmentLossLast;
    }

    public String getIncomeFromChangesInFairValueThis() {
        return incomeFromChangesInFairValueThis;
    }

    public void setIncomeFromChangesInFairValueThis(String incomeFromChangesInFairValueThis) {
        this.incomeFromChangesInFairValueThis = incomeFromChangesInFairValueThis;
    }

    public String getIncomeFromChangesInFairValueLast() {
        return incomeFromChangesInFairValueLast;
    }

    public void setIncomeFromChangesInFairValueLast(String incomeFromChangesInFairValueLast) {
        this.incomeFromChangesInFairValueLast = incomeFromChangesInFairValueLast;
    }

    public String getIncomeFromInvestmentThis() {
        return incomeFromInvestmentThis;
    }

    public void setIncomeFromInvestmentThis(String incomeFromInvestmentThis) {
        this.incomeFromInvestmentThis = incomeFromInvestmentThis;
    }

    public String getIncomeFromInvestmentLast() {
        return incomeFromInvestmentLast;
    }

    public void setIncomeFromInvestmentLast(String incomeFromInvestmentLast) {
        this.incomeFromInvestmentLast = incomeFromInvestmentLast;
    }

    public String getInvestmentIncomeForJointVenturesAndJointVenturesThis() {
        return investmentIncomeForJointVenturesAndJointVenturesThis;
    }

    public void setInvestmentIncomeForJointVenturesAndJointVenturesThis(String investmentIncomeForJointVenturesAndJointVenturesThis) {
        this.investmentIncomeForJointVenturesAndJointVenturesThis = investmentIncomeForJointVenturesAndJointVenturesThis;
    }

    public String getInvestmentIncomeForJointVenturesAndJointVenturesLast() {
        return investmentIncomeForJointVenturesAndJointVenturesLast;
    }

    public void setInvestmentIncomeForJointVenturesAndJointVenturesLast(String investmentIncomeForJointVenturesAndJointVenturesLast) {
        this.investmentIncomeForJointVenturesAndJointVenturesLast = investmentIncomeForJointVenturesAndJointVenturesLast;
    }

    public String getOperatingProfitThis() {
        return operatingProfitThis;
    }

    public void setOperatingProfitThis(String operatingProfitThis) {
        this.operatingProfitThis = operatingProfitThis;
    }

    public String getOperatingProfitLast() {
        return operatingProfitLast;
    }

    public void setOperatingProfitLast(String operatingProfitLast) {
        this.operatingProfitLast = operatingProfitLast;
    }

    public String getNonOperatingIncomeThis() {
        return nonOperatingIncomeThis;
    }

    public void setNonOperatingIncomeThis(String nonOperatingIncomeThis) {
        this.nonOperatingIncomeThis = nonOperatingIncomeThis;
    }

    public String getNonOperatingIncomeLast() {
        return nonOperatingIncomeLast;
    }

    public void setNonOperatingIncomeLast(String nonOperatingIncomeLast) {
        this.nonOperatingIncomeLast = nonOperatingIncomeLast;
    }

    public String getNonCurrentAssetsDisposalGainsThis() {
        return nonCurrentAssetsDisposalGainsThis;
    }

    public void setNonCurrentAssetsDisposalGainsThis(String nonCurrentAssetsDisposalGainsThis) {
        this.nonCurrentAssetsDisposalGainsThis = nonCurrentAssetsDisposalGainsThis;
    }

    public String getNonCurrentAssetsDisposalGainsLast() {
        return nonCurrentAssetsDisposalGainsLast;
    }

    public void setNonCurrentAssetsDisposalGainsLast(String nonCurrentAssetsDisposalGainsLast) {
        this.nonCurrentAssetsDisposalGainsLast = nonCurrentAssetsDisposalGainsLast;
    }

    public String getNonOperatingExpensesThis() {
        return nonOperatingExpensesThis;
    }

    public void setNonOperatingExpensesThis(String nonOperatingExpensesThis) {
        this.nonOperatingExpensesThis = nonOperatingExpensesThis;
    }

    public String getNonOperatingExpensesLast() {
        return nonOperatingExpensesLast;
    }

    public void setNonOperatingExpensesLast(String nonOperatingExpensesLast) {
        this.nonOperatingExpensesLast = nonOperatingExpensesLast;
    }

    public String getDisposalLossOfNonCurrentAssetsThis() {
        return disposalLossOfNonCurrentAssetsThis;
    }

    public void setDisposalLossOfNonCurrentAssetsThis(String disposalLossOfNonCurrentAssetsThis) {
        this.disposalLossOfNonCurrentAssetsThis = disposalLossOfNonCurrentAssetsThis;
    }

    public String getDisposalLossOfNonCurrentAssetsLast() {
        return disposalLossOfNonCurrentAssetsLast;
    }

    public void setDisposalLossOfNonCurrentAssetsLast(String disposalLossOfNonCurrentAssetsLast) {
        this.disposalLossOfNonCurrentAssetsLast = disposalLossOfNonCurrentAssetsLast;
    }

    public String getTotalProfitThis() {
        return totalProfitThis;
    }

    public void setTotalProfitThis(String totalProfitThis) {
        this.totalProfitThis = totalProfitThis;
    }

    public String getTotalProfitLast() {
        return totalProfitLast;
    }

    public void setTotalProfitLast(String totalProfitLast) {
        this.totalProfitLast = totalProfitLast;
    }

    public String getIncomeTaxExpenseThis() {
        return incomeTaxExpenseThis;
    }

    public void setIncomeTaxExpenseThis(String incomeTaxExpenseThis) {
        this.incomeTaxExpenseThis = incomeTaxExpenseThis;
    }

    public String getIncomeTaxExpenseLast() {
        return incomeTaxExpenseLast;
    }

    public void setIncomeTaxExpenseLast(String incomeTaxExpenseLast) {
        this.incomeTaxExpenseLast = incomeTaxExpenseLast;
    }

    public String getNetProfitThis() {
        return netProfitThis;
    }

    public void setNetProfitThis(String netProfitThis) {
        this.netProfitThis = netProfitThis;
    }

    public String getNetProfitLast() {
        return netProfitLast;
    }

    public void setNetProfitLast(String netProfitLast) {
        this.netProfitLast = netProfitLast;
    }

    public String getNetIncomeOfOtherComprehensiveIncomeThis() {
        return netIncomeOfOtherComprehensiveIncomeThis;
    }

    public void setNetIncomeOfOtherComprehensiveIncomeThis(String netIncomeOfOtherComprehensiveIncomeThis) {
        this.netIncomeOfOtherComprehensiveIncomeThis = netIncomeOfOtherComprehensiveIncomeThis;
    }

    public String getNetIncomeOfOtherComprehensiveIncomeLast() {
        return netIncomeOfOtherComprehensiveIncomeLast;
    }

    public void setNetIncomeOfOtherComprehensiveIncomeLast(String netIncomeOfOtherComprehensiveIncomeLast) {
        this.netIncomeOfOtherComprehensiveIncomeLast = netIncomeOfOtherComprehensiveIncomeLast;
    }

    public String getCanNotBeReclassifiedIncomeThis() {
        return canNotBeReclassifiedIncomeThis;
    }

    public void setCanNotBeReclassifiedIncomeThis(String canNotBeReclassifiedIncomeThis) {
        this.canNotBeReclassifiedIncomeThis = canNotBeReclassifiedIncomeThis;
    }

    public String getCanNotBeReclassifiedIncomeLast() {
        return canNotBeReclassifiedIncomeLast;
    }

    public void setCanNotBeReclassifiedIncomeLast(String canNotBeReclassifiedIncomeLast) {
        this.canNotBeReclassifiedIncomeLast = canNotBeReclassifiedIncomeLast;
    }

    public String getChangeInTheYieldPlanThis() {
        return changeInTheYieldPlanThis;
    }

    public void setChangeInTheYieldPlanThis(String changeInTheYieldPlanThis) {
        this.changeInTheYieldPlanThis = changeInTheYieldPlanThis;
    }

    public String getChangeInTheYieldPlanLast() {
        return changeInTheYieldPlanLast;
    }

    public void setChangeInTheYieldPlanLast(String changeInTheYieldPlanLast) {
        this.changeInTheYieldPlanLast = changeInTheYieldPlanLast;
    }

    public String getCannotBeReclassifiedInLawThis() {
        return cannotBeReclassifiedInLawThis;
    }

    public void setCannotBeReclassifiedInLawThis(String cannotBeReclassifiedInLawThis) {
        this.cannotBeReclassifiedInLawThis = cannotBeReclassifiedInLawThis;
    }

    public String getCannotBeReclassifiedInLawLast() {
        return cannotBeReclassifiedInLawLast;
    }

    public void setCannotBeReclassifiedInLawLast(String cannotBeReclassifiedInLawLast) {
        this.cannotBeReclassifiedInLawLast = cannotBeReclassifiedInLawLast;
    }

    public String getWillBeReclassifiedIncomeThis() {
        return willBeReclassifiedIncomeThis;
    }

    public void setWillBeReclassifiedIncomeThis(String willBeReclassifiedIncomeThis) {
        this.willBeReclassifiedIncomeThis = willBeReclassifiedIncomeThis;
    }

    public String getWillBeReclassifiedIncomeLast() {
        return willBeReclassifiedIncomeLast;
    }

    public void setWillBeReclassifiedIncomeLast(String willBeReclassifiedIncomeLast) {
        this.willBeReclassifiedIncomeLast = willBeReclassifiedIncomeLast;
    }

    public String getWillBeReclassifiedInLawThis() {
        return willBeReclassifiedInLawThis;
    }

    public void setWillBeReclassifiedInLawThis(String willBeReclassifiedInLawThis) {
        this.willBeReclassifiedInLawThis = willBeReclassifiedInLawThis;
    }

    public String getWillBeReclassifiedInLawLast() {
        return willBeReclassifiedInLawLast;
    }

    public void setWillBeReclassifiedInLawLast(String willBeReclassifiedInLawLast) {
        this.willBeReclassifiedInLawLast = willBeReclassifiedInLawLast;
    }

    public String getAvailableForSaleFinancialAssetsThis() {
        return availableForSaleFinancialAssetsThis;
    }

    public void setAvailableForSaleFinancialAssetsThis(String availableForSaleFinancialAssetsThis) {
        this.availableForSaleFinancialAssetsThis = availableForSaleFinancialAssetsThis;
    }

    public String getAvailableForSaleFinancialAssetsLast() {
        return availableForSaleFinancialAssetsLast;
    }

    public void setAvailableForSaleFinancialAssetsLast(String availableForSaleFinancialAssetsLast) {
        this.availableForSaleFinancialAssetsLast = availableForSaleFinancialAssetsLast;
    }

    public String getSubjectToMaturityInvestmentsThis() {
        return subjectToMaturityInvestmentsThis;
    }

    public void setSubjectToMaturityInvestmentsThis(String subjectToMaturityInvestmentsThis) {
        this.subjectToMaturityInvestmentsThis = subjectToMaturityInvestmentsThis;
    }

    public String getSubjectToMaturityInvestmentsLast() {
        return subjectToMaturityInvestmentsLast;
    }

    public void setSubjectToMaturityInvestmentsLast(String subjectToMaturityInvestmentsLast) {
        this.subjectToMaturityInvestmentsLast = subjectToMaturityInvestmentsLast;
    }

    public String getCashFlowsThroughTheEffectivePortionThis() {
        return cashFlowsThroughTheEffectivePortionThis;
    }

    public void setCashFlowsThroughTheEffectivePortionThis(String cashFlowsThroughTheEffectivePortionThis) {
        this.cashFlowsThroughTheEffectivePortionThis = cashFlowsThroughTheEffectivePortionThis;
    }

    public String getCashFlowsThroughTheEffectivePortionLast() {
        return cashFlowsThroughTheEffectivePortionLast;
    }

    public void setCashFlowsThroughTheEffectivePortionLast(String cashFlowsThroughTheEffectivePortionLast) {
        this.cashFlowsThroughTheEffectivePortionLast = cashFlowsThroughTheEffectivePortionLast;
    }

    public String getTranslationBalanceOfForeignThis() {
        return translationBalanceOfForeignThis;
    }

    public void setTranslationBalanceOfForeignThis(String translationBalanceOfForeignThis) {
        this.translationBalanceOfForeignThis = translationBalanceOfForeignThis;
    }

    public String getTranslationBalanceOfForeignLast() {
        return translationBalanceOfForeignLast;
    }

    public void setTranslationBalanceOfForeignLast(String translationBalanceOfForeignLast) {
        this.translationBalanceOfForeignLast = translationBalanceOfForeignLast;
    }

    public String getTotalComprehensiveIncomeThis() {
        return totalComprehensiveIncomeThis;
    }

    public void setTotalComprehensiveIncomeThis(String totalComprehensiveIncomeThis) {
        this.totalComprehensiveIncomeThis = totalComprehensiveIncomeThis;
    }

    public String getTotalComprehensiveIncomeLast() {
        return totalComprehensiveIncomeLast;
    }

    public void setTotalComprehensiveIncomeLast(String totalComprehensiveIncomeLast) {
        this.totalComprehensiveIncomeLast = totalComprehensiveIncomeLast;
    }

    public String getBasicEpsThis() {
        return basicEpsThis;
    }

    public void setBasicEpsThis(String basicEpsThis) {
        this.basicEpsThis = basicEpsThis;
    }

    public String getBasicEpsLast() {
        return basicEpsLast;
    }

    public void setBasicEpsLast(String basicEpsLast) {
        this.basicEpsLast = basicEpsLast;
    }

    public String getDilutedEarningsPerShareThis() {
        return dilutedEarningsPerShareThis;
    }

    public void setDilutedEarningsPerShareThis(String dilutedEarningsPerShareThis) {
        this.dilutedEarningsPerShareThis = dilutedEarningsPerShareThis;
    }

    public String getDilutedEarningsPerShareLast() {
        return dilutedEarningsPerShareLast;
    }

    public void setDilutedEarningsPerShareLast(String dilutedEarningsPerShareLast) {
        this.dilutedEarningsPerShareLast = dilutedEarningsPerShareLast;
    }

    public String getDeclareTime() {
        return declareTime;
    }

    public void setDeclareTime(String declareTime) {
        this.declareTime = declareTime;
    }
}

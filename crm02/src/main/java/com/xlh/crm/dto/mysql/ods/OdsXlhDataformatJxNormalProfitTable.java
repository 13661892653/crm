package com.xlh.crm.dto.mysql.ods;

import javax.persistence.Id;

public class OdsXlhDataformatJxNormalProfitTable {
    @Id
    private Integer id;
    private String fileName;
    private String createTime;
    private String enterpriseName="";      //纳税人名称
    private String creditNo;        //社会信用代码
    private String beginTime;       //所属期起
    private String endTime;     //所属期止
    private String unit;        //单位
    private String businessIncomeMonth;     //主营业务收入
    private String businessIncomeYear;
    private String businessCostsMonth;      //主营业务成本
    private String businessCostsYear;
    private String businessAndAdditionTaxMonth;     //主营业务税金及附加
    private String businessAndAdditionTaxYear;
    private String mainBusinessProfitMonth;         //主营业务利润
    private String mainBusinessProfitYear;
    private String otherBusinessProfitsMonth;       //其他业务利润
    private String otherBusinessProfitsYear;
    private String operatingExpensesMonth;      //营业费用
    private String operatingExpensesYear;
    private String managementExpensesMonth;     //管理费用
    private String managementExpensesYear;
    private String financialExpensesMonth;      //财务费用
    private String financialExpensesYear;
    private String businessProfitMonth;     //营业利润
    private String businessProfitYear;
    private String investmentIncomeMonth;    //投资收益
    private String investmentIncomeYear;
    private String subsidyIncomeMonth;      //补贴收入
    private String subsidyIncomeYear;
    private String businessOutIncomeMonth;      //营业外收入
    private String businessOutIncomeYear;
    private String budinessOutExpendMonth;      //营业外支出
    private String budinessOutExpendYear;
    private String totalProfitMonth;        //利润总额
    private String totalProfitYear;
    private String incomeTaxMonth;      //所得税费用
    private String incomeTaxYear;
    private String netProfitMonth;      //净利润
    private String netProfitYear;
    private String proceedsFromTheDisposalOrDisposalUnitMonth;        //出售、处置部门或被投资单位所得收益
    private String proceedsFromTheDisposalOrDisposalUnitYear;
    private String naturalDisasterLossMonth;        //自然灾害发生的损失
    private String naturalDisasterLossYear;
    private String increaseTotalProfitOfAccountingPolicyChangeMonth;        //会计政策变更增加（或减少）利润总额
    private String increaseTotalProfitOfAccountingPolicyChangeYear;
    private String increaseTotalProfitOfAccountingEstimateChangeMonth;      //会计估计变更增加（或减少）利润总额
    private String increaseTotalProfitOfAccountingEstimateChangeYear;
    private String debtRestructuringLossMonth;      //债务重组损失
    private String debtRestructuringLossYear;
    private String otherMonth;      //其他
    private String otherYear;

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

    public String getBusinessIncomeMonth() {
        return businessIncomeMonth;
    }

    public void setBusinessIncomeMonth(String businessIncomeMonth) {
        this.businessIncomeMonth = businessIncomeMonth;
    }

    public String getBusinessIncomeYear() {
        return businessIncomeYear;
    }

    public void setBusinessIncomeYear(String businessIncomeYear) {
        this.businessIncomeYear = businessIncomeYear;
    }

    public String getBusinessCostsMonth() {
        return businessCostsMonth;
    }

    public void setBusinessCostsMonth(String businessCostsMonth) {
        this.businessCostsMonth = businessCostsMonth;
    }

    public String getBusinessCostsYear() {
        return businessCostsYear;
    }

    public void setBusinessCostsYear(String businessCostsYear) {
        this.businessCostsYear = businessCostsYear;
    }

    public String getBusinessAndAdditionTaxMonth() {
        return businessAndAdditionTaxMonth;
    }

    public void setBusinessAndAdditionTaxMonth(String businessAndAdditionTaxMonth) {
        this.businessAndAdditionTaxMonth = businessAndAdditionTaxMonth;
    }

    public String getBusinessAndAdditionTaxYear() {
        return businessAndAdditionTaxYear;
    }

    public void setBusinessAndAdditionTaxYear(String businessAndAdditionTaxYear) {
        this.businessAndAdditionTaxYear = businessAndAdditionTaxYear;
    }

    public String getMainBusinessProfitMonth() {
        return mainBusinessProfitMonth;
    }

    public void setMainBusinessProfitMonth(String mainBusinessProfitMonth) {
        this.mainBusinessProfitMonth = mainBusinessProfitMonth;
    }

    public String getMainBusinessProfitYear() {
        return mainBusinessProfitYear;
    }

    public void setMainBusinessProfitYear(String mainBusinessProfitYear) {
        this.mainBusinessProfitYear = mainBusinessProfitYear;
    }

    public String getOtherBusinessProfitsMonth() {
        return otherBusinessProfitsMonth;
    }

    public void setOtherBusinessProfitsMonth(String otherBusinessProfitsMonth) {
        this.otherBusinessProfitsMonth = otherBusinessProfitsMonth;
    }

    public String getOtherBusinessProfitsYear() {
        return otherBusinessProfitsYear;
    }

    public void setOtherBusinessProfitsYear(String otherBusinessProfitsYear) {
        this.otherBusinessProfitsYear = otherBusinessProfitsYear;
    }

    public String getOperatingExpensesMonth() {
        return operatingExpensesMonth;
    }

    public void setOperatingExpensesMonth(String operatingExpensesMonth) {
        this.operatingExpensesMonth = operatingExpensesMonth;
    }

    public String getOperatingExpensesYear() {
        return operatingExpensesYear;
    }

    public void setOperatingExpensesYear(String operatingExpensesYear) {
        this.operatingExpensesYear = operatingExpensesYear;
    }

    public String getManagementExpensesMonth() {
        return managementExpensesMonth;
    }

    public void setManagementExpensesMonth(String managementExpensesMonth) {
        this.managementExpensesMonth = managementExpensesMonth;
    }

    public String getManagementExpensesYear() {
        return managementExpensesYear;
    }

    public void setManagementExpensesYear(String managementExpensesYear) {
        this.managementExpensesYear = managementExpensesYear;
    }

    public String getFinancialExpensesMonth() {
        return financialExpensesMonth;
    }

    public void setFinancialExpensesMonth(String financialExpensesMonth) {
        this.financialExpensesMonth = financialExpensesMonth;
    }

    public String getFinancialExpensesYear() {
        return financialExpensesYear;
    }

    public void setFinancialExpensesYear(String financialExpensesYear) {
        this.financialExpensesYear = financialExpensesYear;
    }

    public String getBusinessProfitMonth() {
        return businessProfitMonth;
    }

    public void setBusinessProfitMonth(String businessProfitMonth) {
        this.businessProfitMonth = businessProfitMonth;
    }

    public String getBusinessProfitYear() {
        return businessProfitYear;
    }

    public void setBusinessProfitYear(String businessProfitYear) {
        this.businessProfitYear = businessProfitYear;
    }

    public String getInvestmentIncomeMonth() {
        return investmentIncomeMonth;
    }

    public void setInvestmentIncomeMonth(String investmentIncomeMonth) {
        this.investmentIncomeMonth = investmentIncomeMonth;
    }

    public String getInvestmentIncomeYear() {
        return investmentIncomeYear;
    }

    public void setInvestmentIncomeYear(String investmentIncomeYear) {
        this.investmentIncomeYear = investmentIncomeYear;
    }

    public String getSubsidyIncomeMonth() {
        return subsidyIncomeMonth;
    }

    public void setSubsidyIncomeMonth(String subsidyIncomeMonth) {
        this.subsidyIncomeMonth = subsidyIncomeMonth;
    }

    public String getSubsidyIncomeYear() {
        return subsidyIncomeYear;
    }

    public void setSubsidyIncomeYear(String subsidyIncomeYear) {
        this.subsidyIncomeYear = subsidyIncomeYear;
    }

    public String getBusinessOutIncomeMonth() {
        return businessOutIncomeMonth;
    }

    public void setBusinessOutIncomeMonth(String businessOutIncomeMonth) {
        this.businessOutIncomeMonth = businessOutIncomeMonth;
    }

    public String getBusinessOutIncomeYear() {
        return businessOutIncomeYear;
    }

    public void setBusinessOutIncomeYear(String businessOutIncomeYear) {
        this.businessOutIncomeYear = businessOutIncomeYear;
    }

    public String getBudinessOutExpendMonth() {
        return budinessOutExpendMonth;
    }

    public void setBudinessOutExpendMonth(String budinessOutExpendMonth) {
        this.budinessOutExpendMonth = budinessOutExpendMonth;
    }

    public String getBudinessOutExpendYear() {
        return budinessOutExpendYear;
    }

    public void setBudinessOutExpendYear(String budinessOutExpendYear) {
        this.budinessOutExpendYear = budinessOutExpendYear;
    }

    public String getTotalProfitMonth() {
        return totalProfitMonth;
    }

    public void setTotalProfitMonth(String totalProfitMonth) {
        this.totalProfitMonth = totalProfitMonth;
    }

    public String getTotalProfitYear() {
        return totalProfitYear;
    }

    public void setTotalProfitYear(String totalProfitYear) {
        this.totalProfitYear = totalProfitYear;
    }

    public String getIncomeTaxMonth() {
        return incomeTaxMonth;
    }

    public void setIncomeTaxMonth(String incomeTaxMonth) {
        this.incomeTaxMonth = incomeTaxMonth;
    }

    public String getIncomeTaxYear() {
        return incomeTaxYear;
    }

    public void setIncomeTaxYear(String incomeTaxYear) {
        this.incomeTaxYear = incomeTaxYear;
    }

    public String getNetProfitMonth() {
        return netProfitMonth;
    }

    public void setNetProfitMonth(String netProfitMonth) {
        this.netProfitMonth = netProfitMonth;
    }

    public String getNetProfitYear() {
        return netProfitYear;
    }

    public void setNetProfitYear(String netProfitYear) {
        this.netProfitYear = netProfitYear;
    }

    public String getProceedsFromTheDisposalOrDisposalUnitMonth() {
        return proceedsFromTheDisposalOrDisposalUnitMonth;
    }

    public void setProceedsFromTheDisposalOrDisposalUnitMonth(String proceedsFromTheDisposalOrDisposalUnitMonth) {
        this.proceedsFromTheDisposalOrDisposalUnitMonth = proceedsFromTheDisposalOrDisposalUnitMonth;
    }

    public String getProceedsFromTheDisposalOrDisposalUnitYear() {
        return proceedsFromTheDisposalOrDisposalUnitYear;
    }

    public void setProceedsFromTheDisposalOrDisposalUnitYear(String proceedsFromTheDisposalOrDisposalUnitYear) {
        this.proceedsFromTheDisposalOrDisposalUnitYear = proceedsFromTheDisposalOrDisposalUnitYear;
    }

    public String getNaturalDisasterLossMonth() {
        return naturalDisasterLossMonth;
    }

    public void setNaturalDisasterLossMonth(String naturalDisasterLossMonth) {
        this.naturalDisasterLossMonth = naturalDisasterLossMonth;
    }

    public String getNaturalDisasterLossYear() {
        return naturalDisasterLossYear;
    }

    public void setNaturalDisasterLossYear(String naturalDisasterLossYear) {
        this.naturalDisasterLossYear = naturalDisasterLossYear;
    }

    public String getIncreaseTotalProfitOfAccountingPolicyChangeMonth() {
        return increaseTotalProfitOfAccountingPolicyChangeMonth;
    }

    public void setIncreaseTotalProfitOfAccountingPolicyChangeMonth(String increaseTotalProfitOfAccountingPolicyChangeMonth) {
        this.increaseTotalProfitOfAccountingPolicyChangeMonth = increaseTotalProfitOfAccountingPolicyChangeMonth;
    }

    public String getIncreaseTotalProfitOfAccountingPolicyChangeYear() {
        return increaseTotalProfitOfAccountingPolicyChangeYear;
    }

    public void setIncreaseTotalProfitOfAccountingPolicyChangeYear(String increaseTotalProfitOfAccountingPolicyChangeYear) {
        this.increaseTotalProfitOfAccountingPolicyChangeYear = increaseTotalProfitOfAccountingPolicyChangeYear;
    }

    public String getIncreaseTotalProfitOfAccountingEstimateChangeMonth() {
        return increaseTotalProfitOfAccountingEstimateChangeMonth;
    }

    public void setIncreaseTotalProfitOfAccountingEstimateChangeMonth(String increaseTotalProfitOfAccountingEstimateChangeMonth) {
        this.increaseTotalProfitOfAccountingEstimateChangeMonth = increaseTotalProfitOfAccountingEstimateChangeMonth;
    }

    public String getIncreaseTotalProfitOfAccountingEstimateChangeYear() {
        return increaseTotalProfitOfAccountingEstimateChangeYear;
    }

    public void setIncreaseTotalProfitOfAccountingEstimateChangeYear(String increaseTotalProfitOfAccountingEstimateChangeYear) {
        this.increaseTotalProfitOfAccountingEstimateChangeYear = increaseTotalProfitOfAccountingEstimateChangeYear;
    }

    public String getDebtRestructuringLossMonth() {
        return debtRestructuringLossMonth;
    }

    public void setDebtRestructuringLossMonth(String debtRestructuringLossMonth) {
        this.debtRestructuringLossMonth = debtRestructuringLossMonth;
    }

    public String getDebtRestructuringLossYear() {
        return debtRestructuringLossYear;
    }

    public void setDebtRestructuringLossYear(String debtRestructuringLossYear) {
        this.debtRestructuringLossYear = debtRestructuringLossYear;
    }

    public String getOtherMonth() {
        return otherMonth;
    }

    public void setOtherMonth(String otherMonth) {
        this.otherMonth = otherMonth;
    }

    public String getOtherYear() {
        return otherYear;
    }

    public void setOtherYear(String otherYear) {
        this.otherYear = otherYear;
    }
}

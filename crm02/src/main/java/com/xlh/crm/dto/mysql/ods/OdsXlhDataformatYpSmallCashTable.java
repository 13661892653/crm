package com.xlh.crm.dto.mysql.ods;

import javax.persistence.Id;

public class OdsXlhDataformatYpSmallCashTable {
    @Id
    private Integer id;
    private String fileName;
    private String createTime;
    private String enterpriseName="";  //纳税人名称
    private String creditNo;    //纳税人识别号/社会信用代码
    private String beginTime;   //所属期起
    private String endTime; //所属期止
    private String unit;    //单位

    private String cashByBusinessSellMonth; //销售产成品、商品、提供劳务收到的现金
    private String cashByBusinessSellYear;
    private String cashByBusinessReceiveOtherMonth; //收到其他与经营活动有关的现金
    private String cashByBusinessReceiveOtherYear;
    private String cashByBusinessBuyMonth;  //购买原材料、商品、接受劳务支付的现金
    private String cashByBusinessBuyYear;
    private String cashByBusinessPayEmployeeMonth;  //支付的职工薪酬
    private String cashByBusinessPayEmployeeYear;
    private String cashByBusinessPayTaxMonth;   //支付的税费
    private String cashByBusinessPayTaxYear;
    private String cashByBusinessOtherMonth;    //支付其他与经营活动有关的现金
    private String cashByBusinessOtherYear;
    private String cashByBusinessNetMonth;  //经营活动产生的现金流量净额
    private String cashByBusinessNetYear;

    private String cashByInvestWithdrawMonth;   //收回短期投资、长期债券投资和长期股权投资收到的现金
    private String cashByInvestWithdrawYear;
    private String cashByInvestBondIncomeMonth; //取得投资收益收到的现金
    private String cashByInvestBondIncomeYear;
    private String cashByInvestDealFixedAssesetsMonth;  //处置固定资产、无形资产和其他非流动资产收回的现金净额
    private String cashByInvestDealFixedAssesetsYear;
    private String cashByInvestBuyBondMonth;    //短期投资、长期债券投资和长期股权投资支付的现金
    private String cashByInvestBuyBondYear;
    private String cashByInvestBuyFixedAssesetsMonth;   //购建固定资产、无形资产和其他非流动资产支付的现金
    private String cashByInvestBuyFixedAssesetsYear;
    private String cashByInvestNetMonth;    //投资活动产生的现金流量净额
    private String cashByInvestNetYear;

    private String cashByFinancingGetLoanMonth;     //取得借款收到的现金
    private String cashByFinancingGetLoanYear;
    private String cashByFinancingGetInvestMonth;   //吸收投资者投资收到的现金
    private String cashByFinancingGetInvestYear;
    private String cashByFinancingRepayLoanPrincipalMonth;  //偿还借款本金支付的现金
    private String cashByFinancingRepayLoanPrincipalYear;
    private String cashByFinancingRepayLoanInterestMonth;   //偿还借款利息支付的现金
    private String cashByFinancingRepayLoanInterestYear;
    private String cashByFinancingDistributionProfitPayMonth;   //分配利润支付的现金
    private String cashByFinancingDistributionProfitPayYear;
    private String cashByFinancingNetMonth;     //分配利润支付的现金
    private String cashByFinancingNetYear;

    private String cashIncressMonth;        //现金净增加额
    private String cashIncressYear;
    private String cashBeginMonth;      //加：期初现金余额
    private String cashBeginYear;
    private String cashEndMonth;        //期末现金余额
    private String cashEndYear;
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

    public String getCashByBusinessSellMonth() {
        return cashByBusinessSellMonth;
    }

    public void setCashByBusinessSellMonth(String cashByBusinessSellMonth) {
        this.cashByBusinessSellMonth = cashByBusinessSellMonth;
    }

    public String getCashByBusinessSellYear() {
        return cashByBusinessSellYear;
    }

    public void setCashByBusinessSellYear(String cashByBusinessSellYear) {
        this.cashByBusinessSellYear = cashByBusinessSellYear;
    }

    public String getCashByBusinessReceiveOtherMonth() {
        return cashByBusinessReceiveOtherMonth;
    }

    public void setCashByBusinessReceiveOtherMonth(String cashByBusinessReceiveOtherMonth) {
        this.cashByBusinessReceiveOtherMonth = cashByBusinessReceiveOtherMonth;
    }

    public String getCashByBusinessReceiveOtherYear() {
        return cashByBusinessReceiveOtherYear;
    }

    public void setCashByBusinessReceiveOtherYear(String cashByBusinessReceiveOtherYear) {
        this.cashByBusinessReceiveOtherYear = cashByBusinessReceiveOtherYear;
    }

    public String getCashByBusinessBuyMonth() {
        return cashByBusinessBuyMonth;
    }

    public void setCashByBusinessBuyMonth(String cashByBusinessBuyMonth) {
        this.cashByBusinessBuyMonth = cashByBusinessBuyMonth;
    }

    public String getCashByBusinessBuyYear() {
        return cashByBusinessBuyYear;
    }

    public void setCashByBusinessBuyYear(String cashByBusinessBuyYear) {
        this.cashByBusinessBuyYear = cashByBusinessBuyYear;
    }

    public String getCashByBusinessPayEmployeeMonth() {
        return cashByBusinessPayEmployeeMonth;
    }

    public void setCashByBusinessPayEmployeeMonth(String cashByBusinessPayEmployeeMonth) {
        this.cashByBusinessPayEmployeeMonth = cashByBusinessPayEmployeeMonth;
    }

    public String getCashByBusinessPayEmployeeYear() {
        return cashByBusinessPayEmployeeYear;
    }

    public void setCashByBusinessPayEmployeeYear(String cashByBusinessPayEmployeeYear) {
        this.cashByBusinessPayEmployeeYear = cashByBusinessPayEmployeeYear;
    }

    public String getCashByBusinessPayTaxMonth() {
        return cashByBusinessPayTaxMonth;
    }

    public void setCashByBusinessPayTaxMonth(String cashByBusinessPayTaxMonth) {
        this.cashByBusinessPayTaxMonth = cashByBusinessPayTaxMonth;
    }

    public String getCashByBusinessPayTaxYear() {
        return cashByBusinessPayTaxYear;
    }

    public void setCashByBusinessPayTaxYear(String cashByBusinessPayTaxYear) {
        this.cashByBusinessPayTaxYear = cashByBusinessPayTaxYear;
    }

    public String getCashByBusinessOtherMonth() {
        return cashByBusinessOtherMonth;
    }

    public void setCashByBusinessOtherMonth(String cashByBusinessOtherMonth) {
        this.cashByBusinessOtherMonth = cashByBusinessOtherMonth;
    }

    public String getCashByBusinessOtherYear() {
        return cashByBusinessOtherYear;
    }

    public void setCashByBusinessOtherYear(String cashByBusinessOtherYear) {
        this.cashByBusinessOtherYear = cashByBusinessOtherYear;
    }

    public String getCashByBusinessNetMonth() {
        return cashByBusinessNetMonth;
    }

    public void setCashByBusinessNetMonth(String cashByBusinessNetMonth) {
        this.cashByBusinessNetMonth = cashByBusinessNetMonth;
    }

    public String getCashByBusinessNetYear() {
        return cashByBusinessNetYear;
    }

    public void setCashByBusinessNetYear(String cashByBusinessNetYear) {
        this.cashByBusinessNetYear = cashByBusinessNetYear;
    }

    public String getCashByInvestWithdrawMonth() {
        return cashByInvestWithdrawMonth;
    }

    public void setCashByInvestWithdrawMonth(String cashByInvestWithdrawMonth) {
        this.cashByInvestWithdrawMonth = cashByInvestWithdrawMonth;
    }

    public String getCashByInvestWithdrawYear() {
        return cashByInvestWithdrawYear;
    }

    public void setCashByInvestWithdrawYear(String cashByInvestWithdrawYear) {
        this.cashByInvestWithdrawYear = cashByInvestWithdrawYear;
    }

    public String getCashByInvestBondIncomeMonth() {
        return cashByInvestBondIncomeMonth;
    }

    public void setCashByInvestBondIncomeMonth(String cashByInvestBondIncomeMonth) {
        this.cashByInvestBondIncomeMonth = cashByInvestBondIncomeMonth;
    }

    public String getCashByInvestBondIncomeYear() {
        return cashByInvestBondIncomeYear;
    }

    public void setCashByInvestBondIncomeYear(String cashByInvestBondIncomeYear) {
        this.cashByInvestBondIncomeYear = cashByInvestBondIncomeYear;
    }

    public String getCashByInvestDealFixedAssesetsMonth() {
        return cashByInvestDealFixedAssesetsMonth;
    }

    public void setCashByInvestDealFixedAssesetsMonth(String cashByInvestDealFixedAssesetsMonth) {
        this.cashByInvestDealFixedAssesetsMonth = cashByInvestDealFixedAssesetsMonth;
    }

    public String getCashByInvestDealFixedAssesetsYear() {
        return cashByInvestDealFixedAssesetsYear;
    }

    public void setCashByInvestDealFixedAssesetsYear(String cashByInvestDealFixedAssesetsYear) {
        this.cashByInvestDealFixedAssesetsYear = cashByInvestDealFixedAssesetsYear;
    }

    public String getCashByInvestBuyBondMonth() {
        return cashByInvestBuyBondMonth;
    }

    public void setCashByInvestBuyBondMonth(String cashByInvestBuyBondMonth) {
        this.cashByInvestBuyBondMonth = cashByInvestBuyBondMonth;
    }

    public String getCashByInvestBuyBondYear() {
        return cashByInvestBuyBondYear;
    }

    public void setCashByInvestBuyBondYear(String cashByInvestBuyBondYear) {
        this.cashByInvestBuyBondYear = cashByInvestBuyBondYear;
    }

    public String getCashByInvestBuyFixedAssesetsMonth() {
        return cashByInvestBuyFixedAssesetsMonth;
    }

    public void setCashByInvestBuyFixedAssesetsMonth(String cashByInvestBuyFixedAssesetsMonth) {
        this.cashByInvestBuyFixedAssesetsMonth = cashByInvestBuyFixedAssesetsMonth;
    }

    public String getCashByInvestBuyFixedAssesetsYear() {
        return cashByInvestBuyFixedAssesetsYear;
    }

    public void setCashByInvestBuyFixedAssesetsYear(String cashByInvestBuyFixedAssesetsYear) {
        this.cashByInvestBuyFixedAssesetsYear = cashByInvestBuyFixedAssesetsYear;
    }

    public String getCashByInvestNetMonth() {
        return cashByInvestNetMonth;
    }

    public void setCashByInvestNetMonth(String cashByInvestNetMonth) {
        this.cashByInvestNetMonth = cashByInvestNetMonth;
    }

    public String getCashByInvestNetYear() {
        return cashByInvestNetYear;
    }

    public void setCashByInvestNetYear(String cashByInvestNetYear) {
        this.cashByInvestNetYear = cashByInvestNetYear;
    }

    public String getCashByFinancingGetLoanMonth() {
        return cashByFinancingGetLoanMonth;
    }

    public void setCashByFinancingGetLoanMonth(String cashByFinancingGetLoanMonth) {
        this.cashByFinancingGetLoanMonth = cashByFinancingGetLoanMonth;
    }

    public String getCashByFinancingGetLoanYear() {
        return cashByFinancingGetLoanYear;
    }

    public void setCashByFinancingGetLoanYear(String cashByFinancingGetLoanYear) {
        this.cashByFinancingGetLoanYear = cashByFinancingGetLoanYear;
    }

    public String getCashByFinancingGetInvestMonth() {
        return cashByFinancingGetInvestMonth;
    }

    public void setCashByFinancingGetInvestMonth(String cashByFinancingGetInvestMonth) {
        this.cashByFinancingGetInvestMonth = cashByFinancingGetInvestMonth;
    }

    public String getCashByFinancingGetInvestYear() {
        return cashByFinancingGetInvestYear;
    }

    public void setCashByFinancingGetInvestYear(String cashByFinancingGetInvestYear) {
        this.cashByFinancingGetInvestYear = cashByFinancingGetInvestYear;
    }

    public String getCashByFinancingRepayLoanPrincipalMonth() {
        return cashByFinancingRepayLoanPrincipalMonth;
    }

    public void setCashByFinancingRepayLoanPrincipalMonth(String cashByFinancingRepayLoanPrincipalMonth) {
        this.cashByFinancingRepayLoanPrincipalMonth = cashByFinancingRepayLoanPrincipalMonth;
    }

    public String getCashByFinancingRepayLoanPrincipalYear() {
        return cashByFinancingRepayLoanPrincipalYear;
    }

    public void setCashByFinancingRepayLoanPrincipalYear(String cashByFinancingRepayLoanPrincipalYear) {
        this.cashByFinancingRepayLoanPrincipalYear = cashByFinancingRepayLoanPrincipalYear;
    }

    public String getCashByFinancingRepayLoanInterestMonth() {
        return cashByFinancingRepayLoanInterestMonth;
    }

    public void setCashByFinancingRepayLoanInterestMonth(String cashByFinancingRepayLoanInterestMonth) {
        this.cashByFinancingRepayLoanInterestMonth = cashByFinancingRepayLoanInterestMonth;
    }

    public String getCashByFinancingRepayLoanInterestYear() {
        return cashByFinancingRepayLoanInterestYear;
    }

    public void setCashByFinancingRepayLoanInterestYear(String cashByFinancingRepayLoanInterestYear) {
        this.cashByFinancingRepayLoanInterestYear = cashByFinancingRepayLoanInterestYear;
    }

    public String getCashByFinancingDistributionProfitPayMonth() {
        return cashByFinancingDistributionProfitPayMonth;
    }

    public void setCashByFinancingDistributionProfitPayMonth(String cashByFinancingDistributionProfitPayMonth) {
        this.cashByFinancingDistributionProfitPayMonth = cashByFinancingDistributionProfitPayMonth;
    }

    public String getCashByFinancingDistributionProfitPayYear() {
        return cashByFinancingDistributionProfitPayYear;
    }

    public void setCashByFinancingDistributionProfitPayYear(String cashByFinancingDistributionProfitPayYear) {
        this.cashByFinancingDistributionProfitPayYear = cashByFinancingDistributionProfitPayYear;
    }

    public String getCashByFinancingNetMonth() {
        return cashByFinancingNetMonth;
    }

    public void setCashByFinancingNetMonth(String cashByFinancingNetMonth) {
        this.cashByFinancingNetMonth = cashByFinancingNetMonth;
    }

    public String getCashByFinancingNetYear() {
        return cashByFinancingNetYear;
    }

    public void setCashByFinancingNetYear(String cashByFinancingNetYear) {
        this.cashByFinancingNetYear = cashByFinancingNetYear;
    }

    public String getCashIncressMonth() {
        return cashIncressMonth;
    }

    public void setCashIncressMonth(String cashIncressMonth) {
        this.cashIncressMonth = cashIncressMonth;
    }

    public String getCashIncressYear() {
        return cashIncressYear;
    }

    public void setCashIncressYear(String cashIncressYear) {
        this.cashIncressYear = cashIncressYear;
    }

    public String getCashBeginMonth() {
        return cashBeginMonth;
    }

    public void setCashBeginMonth(String cashBeginMonth) {
        this.cashBeginMonth = cashBeginMonth;
    }

    public String getCashBeginYear() {
        return cashBeginYear;
    }

    public void setCashBeginYear(String cashBeginYear) {
        this.cashBeginYear = cashBeginYear;
    }

    public String getCashEndMonth() {
        return cashEndMonth;
    }

    public void setCashEndMonth(String cashEndMonth) {
        this.cashEndMonth = cashEndMonth;
    }

    public String getCashEndYear() {
        return cashEndYear;
    }

    public void setCashEndYear(String cashEndYear) {
        this.cashEndYear = cashEndYear;
    }

    public String getDeclareTime() {
        return declareTime;
    }

    public void setDeclareTime(String declareTime) {
        this.declareTime = declareTime;
    }
}

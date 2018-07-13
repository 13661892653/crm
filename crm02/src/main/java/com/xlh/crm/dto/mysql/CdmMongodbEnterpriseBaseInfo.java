package com.xlh.crm.dto.mysql;

public class CdmMongodbEnterpriseBaseInfo {
    private String enterpriseName;
    private String profitDistributionFile;
    private String cashFlowFile;
    private String assetDebtFile;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getProfitDistributionFile() {
        return profitDistributionFile;
    }

    public void setProfitDistributionFile(String profitDistributionFile) {
        this.profitDistributionFile = profitDistributionFile;
    }

    public String getCashFlowFile() {
        return cashFlowFile;
    }

    public void setCashFlowFile(String cashFlowFile) {
        this.cashFlowFile = cashFlowFile;
    }

    public String getAssetDebtFile() {
        return assetDebtFile;
    }

    public void setAssetDebtFile(String assetDebtFile) {
        this.assetDebtFile = assetDebtFile;
    }
}

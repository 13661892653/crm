package com.xlh.crm.service;

import com.xlh.crm.dto.mysql.FiJxNormalBalanceTable;
import com.xlh.crm.dto.mysql.FiJxNormalProfitTable;
import com.xlh.crm.dto.mysql.FiJxSmallBalanceTable;
import com.xlh.crm.dto.mysql.FiJxSmallProfitTable;

public interface EffectDataService {
    public int insertJxNormalBalance(FiJxNormalBalanceTable fiJxNormalBalanceTable) throws Exception;
    public int insertJxNormalProfit(FiJxNormalProfitTable fiJxNormalProfitTable) throws Exception;
    public int insertJxSmallProfit(FiJxSmallProfitTable fiJxSmallProfitTable) throws Exception;
    public int insertJxSmallBalance(FiJxSmallBalanceTable fiJxSmallBalanceTable) throws Exception;
    public FiJxNormalBalanceTable selectJxNormalBalance(Integer id) throws Exception;
    public FiJxNormalProfitTable selectJxNormalProfit(Integer id) throws Exception;
    public FiJxSmallProfitTable selectJxSmallProfit(Integer id) throws Exception;
    public FiJxSmallBalanceTable selectJxSmallBalance(Integer id) throws Exception;
}

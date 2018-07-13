package com.xlh.crm.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xlh.crm.dto.dynamicReport.DynamicReport;
import com.xlh.crm.dto.financeinputshow.*;
import com.xlh.crm.dto.mysql.*;

import java.util.List;

public interface FinanceInputService {
    public List<FiFileList> getList();
    public List<FiFileList> getCopyList();
    public ExcelFileDetail getFileDetail(FiFileList fiFileList);
    public int updateSheet(FiExcelSheet fiExcelSheet) throws Exception;
    public FiFileList updateFile(FiFileList fiFileList) throws Exception;
    public ExcelFileDetail tableEdit(Integer id) throws Exception;
    public int tableEditDoJXNormalBalanceTableDto(Integer sheetId, JXNormalBalanceTableDto jxNormalBalanceTableDto);
    public FiTmpExcelJxNormalBalanceTable tableEditJXNormalBalanceTableDto(Integer sheetId);
    public int tableEditDoJXNormalProfitTableDto(Integer sheetId, JXNormalProfitTableDto jxNormalProfitTableDto);
    public FiTmpExcelJxNormalProfitTable tableEditJXNormalProfitTableDto(Integer sheetId);
    public int tableEditDoJXSmallProfitTableDto(Integer sheetId, JXSmallProfitTableDto jxSmallProfitTableDto);
    public FiTmpExcelJxSmallProfitTable tableEditJXSmallProfitTableDto(Integer sheetId);
    public int tableEditDoJXSmallBalanceTableDto(Integer sheetId, JXSmallBalanceTableDto jxSmallBalanceTableDto);
    public FiTmpExcelJxSmallBalanceTable tableEditJXSmallBalanceTableDto(Integer sheetId);

    public boolean detailCommit(Integer id) throws Exception;
    public boolean detailCopyCommit(Integer id) throws Exception;
    public boolean reject(Integer id,String remark);

    public List<FiDynamicReportApiReq> dynamicReportFirstList();

    public boolean dynamicReportDataApiReq(JSONArray inputArr) throws Exception;
    public DynamicReportReqShow findReqDetailStruct(int reqId) throws Exception;
    public List<FiDynamicReportApiReq> dynamicReportSecondList();
    public void saveDynamicReportData(JSONObject data) throws Exception;
    public JSONObject findDynamicReportData(int reqId) throws Exception;
    public boolean reportDataRevert(int reqId,String remark) throws Exception;
    public void wuxiao(int reqId) throws Exception;


}

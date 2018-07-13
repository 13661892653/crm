package com.xlh.crm.controller;


import com.alibaba.fastjson.JSONObject;
import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.data.OperationLogCode;
import com.xlh.crm.dto.EnterpriseBankListRespDTO;
import com.xlh.crm.dto.OperationLogDTO;
import com.xlh.crm.dto.PageReqDTO;
import com.xlh.crm.dto.RespRestfulDto;
import com.xlh.crm.dto.dynamicReport.DynamicReport;
import com.xlh.crm.dto.financeinputshow.*;
import com.xlh.crm.dto.mysql.FiExcelSheet;
import com.xlh.crm.dto.mysql.FiFileList;
import com.xlh.crm.mapper.CrmMapper;
import com.xlh.crm.service.CrmModService;
import com.xlh.crm.service.FinanceInputService;
import com.xlh.crm.service.impl.SessionServiceImpl;
import com.xlh.crm.utils.RespCommon;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Set;

@RestController
@RequestMapping("/financeinput")
public class FinanceInputController {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(FinanceInputController.class.getName());
    @Autowired
    private FinanceInputService financeInputService;
    @Autowired
    private CrmModService crmModService;
    @Autowired
    CrmMapper crmMapper;

    @Autowired
    private SessionServiceImpl sessionService;

    @Value("${finance.source.path}")
    private String filePath;
    @Value("${file.dynamicReport.path}")
    private String dynamicReportPath;

    @RequestMapping("list")
    public ModelAndView fileList() {
        ModelAndView modelAndView = new ModelAndView("file_input/list");
        modelAndView.addObject("list", financeInputService.getList());
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }

    @RequestMapping("copylist")
    public ModelAndView copylist() {
        ModelAndView modelAndView = new ModelAndView("file_input/list");
        modelAndView.addObject("list", financeInputService.getCopyList());
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }

    @RequestMapping("filedetail")
    public ModelAndView fileDetail(@RequestParam(value = "id", defaultValue = "0") Integer id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        FiFileList condition = new FiFileList();
        condition.setId(id);
        if (id < 1) {
            throw new Exception("id错误");
        }
        modelAndView.setViewName("file_input/fileDetail");
        ExcelFileDetail excelFileDetail = financeInputService.getFileDetail(condition);
        modelAndView.addObject("excelFileDetail", excelFileDetail);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }

    @RequestMapping("updateSheet")
    public RespRestfulDto updateSheet(@RequestParam(value = "id", defaultValue = "0") Integer id,
                                      @RequestParam(value = "sheetStander", defaultValue = "0") String sheetStander,
                                      @RequestParam(value = "reportType", defaultValue = "0") String reportType,
                                      @RequestParam(value = "tableName", defaultValue = "0") String tableName,
                                      @RequestParam(value = "sheetDate", defaultValue = "0") String sheetDate
                                      ) {
        try {
            FiExcelSheet fiExcelSheet = new FiExcelSheet();
            fiExcelSheet.setId(id);
            fiExcelSheet.setSheetStander(sheetStander);
            fiExcelSheet.setReportType(reportType);
            fiExcelSheet.setTableName(tableName);
            fiExcelSheet.setSheetDate(sheetDate);
            return RespCommon.success(financeInputService.updateSheet(fiExcelSheet));
        } catch (Exception e) {
            return RespCommon.fail(e);
        }
    }

    @RequestMapping("checkName")
    public RespRestfulDto checkName(@RequestParam(value = "key") String key,
                                    @RequestParam(value = "id", defaultValue = "0") Integer id) {
        try {
            PageReqDTO req = new PageReqDTO();
            req.setCorpName(key);
            String corpName = null;
            corpName = req.getCorpName();
            EnterpriseBankListRespDTO result = null;
            EnterpriseBankListRespDTO qxbresult = null;
            FiFileList fiFileList = new FiFileList();
            fiFileList.setId(id);
            result = crmModService.enterpriseByFullName(req); //先从本地库检索
            if (result.getEntSglContents().getRecCnt() > 0) { //如果本地库存在
                fiFileList.setCreditNo(result.getEntSglContents().getCreditNo());
                fiFileList.setRegNo(result.getEntSglContents().getRegNo());
                fiFileList.setRegCreditNo(result.getEntSglContents().getRegCreditNo());
                fiFileList.setEnterpriseName(result.getEntSglContents().getEnterpriseName());
            } else  //如果本地库不存在，就调用启信宝接口查询
            {
                qxbresult = crmModService.getEntInitData(key);
                if (qxbresult.getEntSglContents().getRegNo() == "xxxxxxyyyyyyzzzzzz" && qxbresult.getEntSglContents().getCreditNo() == "xxxxxxyyyyyyzzzzzz") {
                    throw new Exception("该企业不存在，请检查输入的企业全名是否正确！");
                } else {
                    //记录操作日志
                    OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                    operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                    operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                    operationLogDTO.setEventType(OperationLogCode.OPERATION_QXBINIT); //设置操作事件
                    operationLogDTO.setModule(OperationLogCode.MODULE_CRM_REACH); //设置业务模块
                    operationLogDTO.setOperationDesc("reg_no:".concat(qxbresult.getEntSglContents().getRegNo()).concat("|credit_no:").concat(qxbresult.getEntSglContents().getCreditNo())); //设置操作内容
                    int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库
                    fiFileList.setCreditNo(qxbresult.getEntSglContents().getCreditNo());
                    fiFileList.setRegNo(qxbresult.getEntSglContents().getRegNo());
                    fiFileList.setRegCreditNo(qxbresult.getEntSglContents().getRegCreditNo());
                    fiFileList.setEnterpriseName(qxbresult.getEntSglContents().getEnterpriseName());
                }
            }
            fiFileList = financeInputService.updateFile(fiFileList);
            return RespCommon.success(fiFileList);
        } catch (Exception e) {
            return RespCommon.fail(e);
        }
    }

    @RequestMapping("tableEdit")
    public ModelAndView tableEdit(@RequestParam(value = "id", defaultValue = "0") Integer id) throws Exception {
        ExcelFileDetail excelFileDetail = financeInputService.tableEdit(id);
        ModelAndView modelAndView = new ModelAndView();
        FiExcelSheet fiExcelSheet = excelFileDetail.getFiExcelSheetList().get(0);
        modelAndView.addObject("fiExcelSheet", fiExcelSheet);
        modelAndView.addObject("fiFileList", excelFileDetail.getFiFileList());
        if ("JxSmallBalance".equals(fiExcelSheet.getSheetType())) {
            modelAndView.addObject("tmpTable", financeInputService.tableEditJXSmallBalanceTableDto(id));
            modelAndView.setViewName("file_input/JxSmallBalance");
        } else if ("JxSmallProfit".equals(fiExcelSheet.getSheetType())) {
            modelAndView.addObject("tmpTable", financeInputService.tableEditJXSmallProfitTableDto(id));
            modelAndView.setViewName("file_input/JxSmallProfit");

        } else if ("JxNormalBalance".equals(fiExcelSheet.getSheetType())) {
            modelAndView.addObject("tmpTable", financeInputService.tableEditJXNormalBalanceTableDto(id));
            modelAndView.setViewName("file_input/JxNormalBalance");
        } else if ("JxNormalProfit".equals(fiExcelSheet.getSheetType())) {
            modelAndView.addObject("tmpTable", financeInputService.tableEditJXNormalProfitTableDto(id));
            modelAndView.setViewName("file_input/JxNormalProfit");
        } else if ("wuxiao".equals(fiExcelSheet.getSheetType())) {
            modelAndView.setViewName("file_input/wuxiao");
        } else {
            throw new Exception("类型错误");
        }
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }

    @RequestMapping("tableEditDoJXSmallBalanceTableDto/{id}")
    public ModelAndView tableEditDoJXSmallBalanceTableDto(@PathVariable("id") Integer id, JXSmallBalanceTableDto jxSmallBalanceTableDto) {
        financeInputService.tableEditDoJXSmallBalanceTableDto(id, jxSmallBalanceTableDto);
        return new ModelAndView("redirect:/financeinput/tableEdit?id=" + String.valueOf(id));
    }


    @RequestMapping("tableEditDoJXSmallProfitTableDto/{id}")
    public ModelAndView tableEditDoJXSmallProfitTableDto(@PathVariable("id") Integer id, JXSmallProfitTableDto jxSmallProfitTableDto) {
        financeInputService.tableEditDoJXSmallProfitTableDto(id, jxSmallProfitTableDto);
        return new ModelAndView("redirect:/financeinput/tableEdit?id=" + String.valueOf(id));
    }


    @RequestMapping("tableEditDoJXNormalProfitTableDto/{id}")
    public ModelAndView tableEditDoJXNormalProfitTableDto(@PathVariable("id") Integer id, JXNormalProfitTableDto jxNormalProfitTableDto) {
        financeInputService.tableEditDoJXNormalProfitTableDto(id, jxNormalProfitTableDto);
        return new ModelAndView("redirect:/financeinput/tableEdit?id=" + String.valueOf(id));
    }

    @RequestMapping("tableEditDoJXNormalBalanceTableDto/{id}")
    public ModelAndView tableEditDoJXNormalBalanceTableDto(@PathVariable("id") Integer id, JXNormalBalanceTableDto jxNormalBalanceTableDto) {
        financeInputService.tableEditDoJXNormalBalanceTableDto(id, jxNormalBalanceTableDto);
        return new ModelAndView("redirect:/financeinput/tableEdit?id=" + String.valueOf(id));
    }

    @RequestMapping("detailCommit")
    public RespRestfulDto detailCommit(@RequestParam(value = "id") Integer id) {
        try {
            return RespCommon.success(financeInputService.detailCommit(id));
        } catch (Exception e) {
            return RespCommon.fail(e);
        }
    }


    @RequestMapping("detailCopyCommit")
    public RespRestfulDto detailCopyCommit(@RequestParam(value = "id") Integer id) {
        try {
            return RespCommon.success(financeInputService.detailCopyCommit(id));
        } catch (Exception e) {
            return RespCommon.fail(e);
        }
    }

    @RequestMapping("reject")
    public RespRestfulDto reject(@RequestParam(value = "id") Integer id, @RequestParam(value = "remark") String remark) {
        try {
            return RespCommon.success(financeInputService.reject(id, remark));
        } catch (Exception e) {
            return RespCommon.fail(e);
        }
    }

    @RequestMapping("downloadFile")
    public void doGet(HttpServletRequest request, HttpServletResponse response, @RequestParam("fileName") String fileName,@RequestParam(value = "type",defaultValue = "0") String type)
            throws Exception {
        //得到要下载的文件名
        String path;
        if("0".equals(type)){
            path=filePath;
        }else if ("1".equals(type)){
            path=dynamicReportPath;
        }else{
            throw new Exception("路径空");
        }
        fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
        //通过文件名找出文件的所在目录
        //得到要下载的文件
        File file = new File(path + fileName);

        //如果文件不存在
        if (!file.exists()) {
            LOGGER.info(path + fileName+"文件不存在");
        }
        //处理文件名
        String realname = fileName.substring(fileName.indexOf("_") + 1);
        //设置响应头，控制浏览器下载该文件
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
        //读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(path + fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while ((len = in.read(buffer)) > 0) {
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();
    }


    /*******动态报表录入*******************/

    /**
     * 初录列表
     * @return
     */
    @RequestMapping("dynamicReportDataFirstList")
    public ModelAndView dynamicReportFirstInput(){
        ModelAndView modelAndView=new ModelAndView("file_input/dynamicReportFirstList");
        modelAndView.addObject("list", financeInputService.dynamicReportFirstList());
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }

    @RequestMapping("dynamicReportDataDetail")
    public ModelAndView dynamicReportDetail(@RequestParam(value = "reqId")int reqId) throws Exception {
        ModelAndView modelAndView=new ModelAndView("file_input/dynamicReportDetail");
        DynamicReportReqShow dynamicReportReqShow=financeInputService.findReqDetailStruct(reqId);
        modelAndView.addObject("fiDynamicReportApiReq", dynamicReportReqShow.getFiDynamicReportApiReq());
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }

    /**
     * 动态数据报表显示
     * @param reqId
     * @return
     * @throws Exception
     */
    @RequestMapping("dynamicReportDetailShow")
    public ModelAndView dynamicReportDetailShow(@RequestParam(value = "reqId")int reqId) throws Exception {
        ModelAndView modelAndView=new ModelAndView("file_input/dynamicReportDetailShow");
        DynamicReportReqShow dynamicReportReqShow=financeInputService.findReqDetailStruct(reqId);
        modelAndView.addObject("fiDynamicReportApiReq", dynamicReportReqShow.getFiDynamicReportApiReq());
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }
    /**
     * 初录列表
     * @return
     */
    @RequestMapping("dynamicReportDataSecondList")
    public ModelAndView dynamicReportDataSecondList(){
        ModelAndView modelAndView=new ModelAndView("file_input/dynamicReportDataSecondList");
        modelAndView.addObject("list", financeInputService.dynamicReportSecondList());
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }
    @RequestMapping("dynamicReportDataDetailFulu")
    public ModelAndView dynamicReportDataDetailFulu(@RequestParam(value = "reqId")int reqId) throws Exception {
        ModelAndView modelAndView=new ModelAndView("file_input/dynamicReportDetailFulu");
        DynamicReportReqShow dynamicReportReqShow=financeInputService.findReqDetailStruct(reqId);
        modelAndView.addObject("fiDynamicReportApiReq", dynamicReportReqShow.getFiDynamicReportApiReq());
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }

    @RequestMapping("dynamicReportDataDetailAjax")
    public RespRestfulDto dynamicReportDataDetailAjax(@RequestParam(value = "reqId")int reqId) throws Exception {
        try{
            return RespCommon.success(financeInputService.findDynamicReportData(reqId));
        }catch (Exception e){
            return RespCommon.fail(e);
        }
    }
    @RequestMapping("dynamicReportDataDetailSave")
    public RespRestfulDto dynamicReportDetailSave(@RequestBody JSONObject input){
        try{
            financeInputService.saveDynamicReportData(input);
            return RespCommon.success(1);
        }catch (Exception e){
            return RespCommon.fail(e);
        }
    }


    @RequestMapping("dynamicReportDataRevert")
    public RespRestfulDto dynamicReportDataRevert(@RequestParam(value = "reqId")int reqId,@RequestParam(value = "remark")String remark){
        try{
            financeInputService.reportDataRevert(reqId,remark);
            return RespCommon.success(1);
        }catch (Exception e){
            return RespCommon.fail(e);
        }
    }
    @RequestMapping("dynamicReportDataWuxiao")
    public void dynamicReportDataWuxiao(@RequestParam(value = "reqId")int reqId,HttpServletResponse response) throws Exception {
        financeInputService.wuxiao(reqId);
        response.sendRedirect("/financeinput/dynamicReportDataFirstList");
    }
}

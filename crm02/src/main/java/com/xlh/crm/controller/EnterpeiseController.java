package com.xlh.crm.controller;


import com.xlh.crm.common.RespCommon;
import com.xlh.crm.dto.JsonRespDto;
import com.xlh.crm.dto.UserInfoDTO;
import com.xlh.crm.dto.mysql.CdmEntDtoHighTech;
import com.xlh.crm.dto.mysql.CdmEntDtoFiles;
import com.xlh.crm.mapper.CdmEntDtoFilesMapper;
import com.xlh.crm.service.EffectDataService;
import com.xlh.crm.service.EnterpriseDetailService;
import com.xlh.crm.service.impl.ScoreServiceImpl;
import com.xlh.crm.service.impl.SessionServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
public class EnterpeiseController {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(EnterpeiseController.class.getName());
    @Autowired
    EnterpriseDetailService enterpriseDetailService;
    @Autowired
    private EffectDataService effectDataService;
    @Autowired
    private SessionServiceImpl sessionService;
    @Autowired
    private ScoreServiceImpl scoreService;
    @Autowired
    private CdmEntDtoFilesMapper cdmEntDtoFilesMapper;
    @RequestMapping("/crm/enterprisedetail/updatehightech")
    public JsonRespDto updateHighTech(@RequestBody CdmEntDtoHighTech cdmEntDtoHighTech){
        enterpriseDetailService.updateHighTech(cdmEntDtoHighTech);
        scoreService.calculatorScore(cdmEntDtoHighTech.getReg_credit_no());
        return RespCommon.success("");
    }

    @RequestMapping("/crm/enterprisedetail/financetable")
    public ModelAndView financeTableDetail(@RequestParam(value = "type")String type,@RequestParam(value = "id")Integer id) throws Exception {
        ModelAndView modelAndView=new ModelAndView();
        if("JxSmallBalance".equals(type)){
            modelAndView.setViewName("finance_table_show/JxSmallBalance");
            modelAndView.addObject("tmpTable",effectDataService.selectJxSmallBalance(id));
        }else if("JxSmallProfit".equals(type)){
            modelAndView.setViewName("finance_table_show/JxSmallProfit");
            modelAndView.addObject("tmpTable",effectDataService.selectJxSmallProfit(id));
        }else if("JxNormalBalance".equals(type)){
            modelAndView.setViewName("finance_table_show/JxNormalBalance");
            modelAndView.addObject("tmpTable",effectDataService.selectJxNormalBalance(id));
        }else if("JxNormalProfit".equals(type)){
            modelAndView.setViewName("finance_table_show/JxNormalProfit");
            modelAndView.addObject("tmpTable",effectDataService.selectJxNormalProfit(id));
        }
        modelAndView.addObject("user", sessionService.getUser());
        return  modelAndView;

    }

    @RequestMapping("/crm/enterprisedetail/saveFile")
    public JsonRespDto saveFile(@RequestBody CdmEntDtoFiles cdmEntDtoFiles){
        try{
            UserInfoDTO userInfoDTO=sessionService.getUser();
            cdmEntDtoFiles.setOperator(userInfoDTO.getUserName()+"-"+userInfoDTO.getCompany());
            cdmEntDtoFiles.setUpdateTime(new Date());
            cdmEntDtoFilesMapper.insert(cdmEntDtoFiles);
            return RespCommon.success(cdmEntDtoFiles);
        }catch (Exception e){
            return RespCommon.fail(e);
        }

    }
}

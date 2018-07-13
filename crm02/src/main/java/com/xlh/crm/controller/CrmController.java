package com.xlh.crm.controller;

import java.io.IOException;
import java.util.List;

import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.data.OperationLogCode;
import com.xlh.crm.domain.MemberBaseInfo;
import com.xlh.crm.dto.EnterpriseBaseInfoRespDTO;
import com.xlh.crm.dto.mysql.CdmEntDtoHighTech;
import com.xlh.crm.dto.mysql.CdmEntDtoFiles;
import com.xlh.crm.dto.mysql.FiDynamicReportApiReq;
import com.xlh.crm.dto.mysql.ods.CdmMongodbEnterpriseBaseInfoD;
import com.xlh.crm.enums.FinanceTableColumnNameEnum;
import com.xlh.crm.mapper.CdmEntDtoFilesMapper;
import com.xlh.crm.mapper.CdmMongodbEnterpriseBaseInfoDMapper;
import com.xlh.crm.mapper.CrmMapper;
import com.xlh.crm.mapper.FiDynamicReportApiReqMapper;
import com.xlh.crm.service.CrmModService;
import com.xlh.crm.domain.EnterpriseTag;
import com.xlh.crm.dto.*;
import com.xlh.crm.service.EnterpriseDetailService;
import com.xlh.crm.service.impl.ScoreServiceImpl;
import com.xlh.crm.service.impl.SessionServiceImpl;
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: ysl
 * @email:
 * @version: 0.1
 * @create time: 2017/03/15
 * @description:
 */
@Controller
@RequestMapping("/crm")
public class CrmController {
    private static Logger logger = LoggerFactory.getLogger(CrmController.class);
    @Autowired
    CrmModService crmModService;

    @Autowired
    EnterpriseDetailService enterpriseDetailService;

    @Autowired
    CrmMapper crmMapper;

    @Autowired
    private SessionServiceImpl sessionService;
    @Autowired
    private ScoreServiceImpl scoreService;
    @Autowired
    private CdmEntDtoFilesMapper cdmEntDtoFilesMapper;
    @Autowired
    private FiDynamicReportApiReqMapper fiDynamicReportApiReqMapper;
    @Autowired
    private CdmMongodbEnterpriseBaseInfoDMapper cdmMongodbEnterpriseBaseInfoDMapper;

    //密码修改
    @RequestMapping(value = "/updatepassword/{pathvar}")
    public ModelAndView getUpdatePassword(@PathVariable("pathvar") String pathvar, MemberInfoDTO form, PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = null;
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        int uptFlag = 0;
        String msg = null;

        if (pathvar.equals("submit")) {
            form.setMemberPhone(sessionService.getUser().getMemberPhone());  //设置登录用户手机号
            uptFlag = crmModService.uptPassword(form);
            if (uptFlag == 1) {
                //记录操作日志
                OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                operationLogDTO.setEventType(OperationLogCode.OPERATION_EDIT); //设置操作事件
                operationLogDTO.setModule(OperationLogCode.MODULE_CRM_RESET_PASSWORD); //设置业务模块
                operationLogDTO.setOperationDesc("success"); //设置操作内容
                int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库

                msg = "设置成功！";
            } else {
                msg = "系统发生错误，设置失败！";
            }
        }

        if (uptFlag != 0 || pathvar.equals("view")) {
            modelAndView = new ModelAndView("update_password");
            modelAndView.addObject("msg", msg);
        }

        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    //用户管理
    @RequestMapping(value = "/user/{pathvar}")
    public ModelAndView getUserManage(@PathVariable("pathvar") String pathvar, MemberInfoDTO form, PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = null;
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        String msg = null;

        //进入新增用户页面
        if (pathvar.equals("adduser")) {
            modelAndView = new ModelAndView("user_add");
        }

        int insertFlag = 0;

        //提交新增用户信息
        if (pathvar.equals("addsubmit")) {
            insertFlag = crmModService.insertUser(form);
            if (insertFlag == 1) {
                //记录操作日志
                OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                operationLogDTO.setEventType(OperationLogCode.OPERATION_INSERT); //设置操作事件
                operationLogDTO.setModule(OperationLogCode.MODULE_CRM_USER); //设置业务模块
                operationLogDTO.setOperationDesc("member_phone:".concat(form.getMemberPhone())); //设置操作内容
                int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库

                msg = "新增用户成功！";
            }
        }

        int uptFlag = 0;

        if (pathvar.equals("submit")) {
            uptFlag = crmModService.updateUser(form);
            if (uptFlag == 1) {
                msg = "用户信息修改成功！";
                //记录操作日志
                OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                operationLogDTO.setEventType(OperationLogCode.OPERATION_EDIT); //设置操作事件
                operationLogDTO.setModule(OperationLogCode.MODULE_CRM_USER); //设置业务模块
                operationLogDTO.setOperationDesc("member_phone:".concat(form.getMemberPhone())); //设置操作内容
                int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库
            } else {
                msg = "系统发生错误，修改失败！";
            }
        }

        //编辑用户
        if (pathvar.equals("edituser")) {
            //从请求URL中获取要编辑用户的memberPhone
            String memberPhone = null;
            memberPhone = request.getParameter("member_phone");
            MemberInfoDTO result = crmModService.userSgl(memberPhone);

            modelAndView = new ModelAndView("user_edit");
            modelAndView.addObject("result", result);
        }

        if (insertFlag != 0 || uptFlag != 0 || pathvar.equals("viewall")) {
            modelAndView = new ModelAndView("user_list");
            UserListRespDTO result = crmModService.getUserList(req);
            modelAndView.addObject("result", result);
            modelAndView.addObject("msg", msg);
        }

        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    //模板导入
    @RequestMapping(value = "/enterpriseimp")
    public ModelAndView getEnterpriseImp(PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("enterprise_imp");
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        //EnterpriseBankListRespDTO result = crmModService.invEventList(req);
        //modelAndView.addObject("result", result);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    //收藏的企业
    @RequestMapping(value = "/enterprisefav/{pathvar}")
    public ModelAndView getEnterpriseFav(@PathVariable("pathvar") String pathvar, EnterpriseBaseInfoRespDTO form, PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = null;
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        int uptFlag = 0;
        String msg = null;

        //设置客户经理
        if (pathvar.equals("uptcustMgr")) {
            uptFlag = crmModService.uptCustManager(form);
            if (uptFlag == 1) {
                //记录操作日志
                OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                operationLogDTO.setEventType(OperationLogCode.OPERATION_EDIT); //设置操作事件
                operationLogDTO.setModule(OperationLogCode.MODULE_CRM_FAV_CUSTMGR); //设置业务模块
                operationLogDTO.setOperationDesc("reg_credit_no:".concat(form.getRegCreditNo())); //设置操作内容
                int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库

                msg = "设置成功！";
            } else {
                msg = "系统发生错误，设置失败！";
            }
        }

        if (uptFlag != 0 || pathvar.equals("viewfav")) {
            modelAndView = new ModelAndView("enterprise_favorite");
            String memberPhone = sessionService.getUser().getMemberPhone();  //获取用户登录时的手机号
            String username = sessionService.getUser().getUserName();  //获取用户名称
            String company = sessionService.getUser().getCompany();  //获取用户所在分公司
            String membertype = sessionService.getUser().getMemberType();  //获取用户类型

            //查询当前用户所在公司下的所有用户
            List<MemberBaseInfo> companyUserList = crmModService.companyUserList(company);

            //获取收藏企业列表
            req.setUserName(username);
            req.setCompany(company);
            req.setMemberType(membertype);
            FavListRespDTO result = crmModService.enterpriseFavList(req);

            modelAndView.addObject("msg", msg);
            modelAndView.addObject("companyUserList", companyUserList);
            modelAndView.addObject("result", result);
        }

        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    //检索档案更新企业
    @RequestMapping(value = "/enterpriseupt/viewupt")
    public ModelAndView getEnterpriseEidt(PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("enterprise_upt");
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        req.setUserName(member.getUserName());
        req.setCompany(member.getCompany());
        req.setMemberType(member.getMemberType());
        EntuptListRespDTO result = crmModService.enterpriseUptList(req);
        modelAndView.addObject("result", result);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    //企业信息库
    @RequestMapping(value = "/enterprisebank")
    public ModelAndView getEnterpriseBank(PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("enterprise_bank");
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        String memberType = null;  //用户类型
        memberType = sessionService.getUser().getMemberType();
        req.setMemberType(memberType);  //赋值用户类型
        req.setCompany(sessionService.getUser().getCompany());  //赋值所在公司
        if (memberType.equals("90"))  //90级为分公司经理
        {
            req.setRegionCode(sessionService.getUser().getCompany()); //分公司经理只能看本区域的
        }

        List<EnterpriseTag> enterpriseTagList = crmModService.queryEntTagFromDB();
        EnterpriseBankListRespDTO result = crmModService.enterpriseBankList(req);

        modelAndView.addObject("enterpriseTagList", enterpriseTagList);
        modelAndView.addObject("result", result);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    @RequestMapping(value = "/enterprisedetail/{pathvar}")
    public ModelAndView getCorpDetail(
            @PathVariable("pathvar") String pathvar
            , PageReqDTO req
            , EnterpriseEmpStrucRespDTO empStrucRespDTO
            , EnterpriseBaseInfoRespDTO baseInfoRespDTO
            , EnterpriseMarketDevRespDTO marketDevRespDTO
            , EnterpriseIpoRespDTO ipoRespDTO
            , EnterpriseCarrierRespDTO carrierRespDTO
            , EnterpriseCoreTeamRespDTO coreTeamRespDTO
            , EnterpriseContactsRespDTO contactsRespDTO
            , EnterpriseHonorRespDTO honorRespDTO
            , EnterpriseFindataRespDTO findataRespDTO
            , HttpServletResponse response
            , HttpServletRequest request
    ) throws IOException {

        ModelAndView modelAndView = new ModelAndView("enterprise_detail");
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        //从请求URL中获取参数要查看企业档案的reg_credit_no
        String regCreditNo = null;
        regCreditNo = request.getParameter("reg_credit_no");
        req.setRegCreditNo(regCreditNo);
        req.setUserName(member.getUserName());
        req.setMemberId(member.getMemberId());

        int addFavFlag = 0;
        int celFavFlag = 0;
        int gsryjgFlag = 0;
        int gsjsFlag = 0;
        int scfzFlag = 0;
        int ssqkFlag = 0;
        int gsztFlag = 0;
        int hxtdFlag = 0;
        int gslxrFlag = 0;
        int zzryFlag = 0;
        int zfcwFlag = 0;

        //添加收藏企业
        if (pathvar.equals("addfav")) {
            req.setRegCreditNo(baseInfoRespDTO.getRegCreditNo());
            addFavFlag = enterpriseDetailService.enterpriseAddFav(req);
            String msg = null;
            if (addFavFlag == 1) {
                msg = "收藏成功！";
            } else {
                msg = "系统发生错误，收藏失败！";
            }
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            modelAndView.addObject("msg", msg);
        }

        //取消收藏企业
        if (pathvar.equals("celfav")) {
            req.setRegCreditNo(baseInfoRespDTO.getRegCreditNo());
            celFavFlag = enterpriseDetailService.enterpriseCelFav(req);
            String msg = null;
            if (celFavFlag > 0) {
                msg = "已取消收藏！";
            } else {
                msg = "系统发生错误，取消收藏失败！";
            }
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            modelAndView.addObject("msg", msg);
        }

        //公司人员结构编辑
        if (pathvar.equals("gsryjgEdit")) {
            gsryjgFlag = enterpriseDetailService.enterpriseEmpStrucUpdate(empStrucRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            scoreService.calculatorScore(regCreditNo);
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        //公司介绍编辑
        if (pathvar.equals("gsjsEdit")) {
            gsjsFlag = enterpriseDetailService.enterpriseBaseInfoUpdate(baseInfoRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            scoreService.calculatorScore(regCreditNo);
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        //市场发展编辑
        if (pathvar.equals("scfzEdit")) {
            scfzFlag = enterpriseDetailService.enterpriseMarketDevUpdate(marketDevRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        //上市情况编辑
        if (pathvar.equals("ssqkEdit")) {
            ssqkFlag = enterpriseDetailService.enterpriseIpoUpdate(ipoRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        //归属载体编辑
        if (pathvar.equals("gsztEdit")) {
            gsztFlag = enterpriseDetailService.enterpriseCarrierUpdate(carrierRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        //核心团队编辑
        if (pathvar.equals("hxtdEdit")) {
            hxtdFlag = enterpriseDetailService.enterpriseCoreTeamInsert(coreTeamRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        //核心团队删除
        if (pathvar.equals("hxtdDelete")) {
            hxtdFlag = enterpriseDetailService.enterpriseCoreTeamDelete(coreTeamRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        //公司联系人编辑
        if (pathvar.equals("gslxrEdit")) {
            gslxrFlag = enterpriseDetailService.enterpriseContactsInsert(contactsRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        //公司联系人删除
        if (pathvar.equals("gslxrDelete")) {
            gslxrFlag = enterpriseDetailService.enterpriseContactsDelete(contactsRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        //资质荣誉编辑
        if (pathvar.equals("zzryEdit")) {
            zzryFlag = enterpriseDetailService.enterpriseHonorInsert(honorRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        //资质荣誉删除
        if (pathvar.equals("zzryDelete")) {
            zzryFlag = enterpriseDetailService.enterpriseHonorDelete(honorRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        //财务数据编辑
        if (pathvar.equals("zfcwEdit")) {
            zfcwFlag = enterpriseDetailService.enterpriseFindataInsert(findataRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            scoreService.calculatorScore(regCreditNo);
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        //财务数据删除
        if (pathvar.equals("zfcwDelete")) {
            zfcwFlag = enterpriseDetailService.enterpriseFindataDelete(findataRespDTO);
            regCreditNo = baseInfoRespDTO.getRegCreditNo();
            response.sendRedirect("/crm/enterprisedetail/view?reg_credit_no="+regCreditNo);
            return null;
        }

        if (addFavFlag != 0 || celFavFlag != 0 || gsryjgFlag != 0 || gsjsFlag != 0 || scfzFlag != 0 || ssqkFlag != 0 || gsztFlag != 0 || hxtdFlag != 0 || gslxrFlag != 0 || zzryFlag != 0 || zfcwFlag != 0 || pathvar.equals("view")) {
            //企业档案-企业基本信息
            EnterpriseBaseInfoRespDTO resultBaseInfo = enterpriseDetailService.enterpriseBaseInfoList(regCreditNo);
            if (resultBaseInfo.getRecCnt() == 0) {
                String msg = null;
                msg = "新增企业，明天早上9点后该企业档案才能查看和操作。";
                modelAndView.addObject("msg", msg);
                CdmEntDtoHighTech resultHighTech = new CdmEntDtoHighTech();
                modelAndView.addObject("resultBaseInfo", resultBaseInfo);
                modelAndView.addObject("resultHighTech", resultHighTech);
            } else {
                //企业标签
                List<EnterpriseTag> enterpriseTagList = crmModService.queryEntTagFromDB();
                modelAndView.addObject("enterpriseTagList", enterpriseTagList);

                String company = sessionService.getUser().getCompany();  //获取用户所在分公司
                resultBaseInfo.setCompany(company);
                modelAndView.addObject("resultBaseInfo", resultBaseInfo);

                //企业档案-客户经理、收藏信息
                req.setCompany(member.getCompany());
                req.setRegCreditNo(resultBaseInfo.getRegCreditNo());
                EnterpriseShowDTO resultFav = enterpriseDetailService.enterpriseFavorite(req);
                modelAndView.addObject("resultFav", resultFav);
                modelAndView.addObject("company", req.getCompany());

                //企业档案-主要人员
                List<EnterpriseEmployeeRespDTO> resultEmployee = enterpriseDetailService.enterpriseEmployeeList(regCreditNo);
                modelAndView.addObject("resultEmployee", resultEmployee);

                //企业档案-服务订单
                List<OrderShowDTO> resultOrder = enterpriseDetailService.enterpriseOrderList(regCreditNo);
                modelAndView.addObject("resultOrder", resultOrder);

                //企业档案-触达信息
                List<EnterpriseReachcsrRespDTO> resultReachcsr = enterpriseDetailService.enterpriseReachcsrList(regCreditNo);
                modelAndView.addObject("resultReachcsr", resultReachcsr);

                //企业档案-营销跟进
                //List<EnterpriseMarketFollowRespDTO> resultMarketFollow = enterpriseDetailService.enterpriseMarketFollowList(regCreditNo);
                //modelAndView.addObject("resultMarketFollow", resultMarketFollow);

                //企业档案-历史融资
                List<EnterpriseFinancingRespDTO> resultFinancing = enterpriseDetailService.enterpriseFinancingList(regCreditNo);
                modelAndView.addObject("resultFinancing", resultFinancing);

                //企业档案-股东信息
                List<EnterprisePartnerRespDTO> resultPartner = enterpriseDetailService.enterprisePartnerList(regCreditNo);
                modelAndView.addObject("resultPartner", resultPartner);

                //企业档案-公司人员构成
                EnterpriseEmpStrucRespDTO resultEmpStruc = enterpriseDetailService.enterpriseEmpStrucList(regCreditNo);
                modelAndView.addObject("resultEmpStruc", resultEmpStruc);

                //企业档案-核心团队
                List<EnterpriseCoreTeamRespDTO> resultCoreTeam = enterpriseDetailService.enterpriseCoreTeamList(regCreditNo);
                modelAndView.addObject("resultCoreTeam", resultCoreTeam);

                //企业档案-公司联系人
                List<EnterpriseContactsRespDTO> resultContacts = enterpriseDetailService.enterpriseContactsList(regCreditNo);
                modelAndView.addObject("resultContacts", resultContacts);

                //企业档案-资质荣誉
                List<EnterpriseHonorRespDTO> resultHonor = enterpriseDetailService.enterpriseHonorList(regCreditNo);
                modelAndView.addObject("resultHonor", resultHonor);

                //企业档案-市场发展情况
                EnterpriseMarketDevRespDTO resultMarketDev = enterpriseDetailService.enterpriseMarketDevList(regCreditNo);
                modelAndView.addObject("resultMarketDev", resultMarketDev);

                //企业档案-上市情况
                EnterpriseIpoRespDTO resultIpo = enterpriseDetailService.enterpriseIpoList(regCreditNo);
                modelAndView.addObject("resultIpo", resultIpo);

                //企业档案-归属载体
                EnterpriseCarrierRespDTO resultCarrier = enterpriseDetailService.enterpriseCarrierList(regCreditNo);
                modelAndView.addObject("resultCarrier", resultCarrier);

                //企业档案-财务数据
                List<EnterpriseFindataRespDTO> resultFindata = enterpriseDetailService.enterpriseFindataList(regCreditNo);
                modelAndView.addObject("resultFindata", resultFindata);

                //企业档案-项目数据
                List<EnterpriseProjRespDTO> resultProj = enterpriseDetailService.enterpriseProjList(regCreditNo);
                modelAndView.addObject("resultProj", resultProj);

                //高新技术核心企业
                CdmEntDtoHighTech resultHighTech = enterpriseDetailService.selectOneHighTech(regCreditNo);
                if (resultHighTech == null) {
                    resultHighTech = new CdmEntDtoHighTech();
                }
                modelAndView.addObject("resultHighTech", resultHighTech);

                //财务报表
                List<EnterpriseFinanceTableShowDto> reulstFinanceTables = enterpriseDetailService.selectFinanceTableInfo(regCreditNo);
                modelAndView.addObject("reulstFinanceTables", reulstFinanceTables);
                modelAndView.addObject("resultFinanceTableMap", FinanceTableColumnNameEnum.getMap());

                //企业附件
                Example example =new Example(CdmEntDtoFiles.class);
                example.createCriteria().andEqualTo("regCreditNo",regCreditNo);
                List<CdmEntDtoFiles> cdmEntDtoFiles=cdmEntDtoFilesMapper.selectByExample(example);
                modelAndView.addObject("cdmEntDtoFiles", cdmEntDtoFiles);

                //科技贷财务数据
                example=new Example(FiDynamicReportApiReq.class);
                example.createCriteria().andEqualTo("regCreditNo",regCreditNo);
                List<FiDynamicReportApiReq> fiDynamicReportApiReqs=fiDynamicReportApiReqMapper.selectByExample(example);
                modelAndView.addObject("fiDynamicReportApiReqs", fiDynamicReportApiReqs);
                //科技贷企业信息
                example=new Example(CdmMongodbEnterpriseBaseInfoD.class);
                example.createCriteria().andEqualTo("regCreditNo",regCreditNo);
                List<CdmMongodbEnterpriseBaseInfoD> tmplist=cdmMongodbEnterpriseBaseInfoDMapper.selectByExample(example);
                CdmMongodbEnterpriseBaseInfoD cdmMongodbEnterpriseBaseInfoD=null;
                if(tmplist.size()>0){
                    cdmMongodbEnterpriseBaseInfoD=tmplist.get(0);
                }
                modelAndView.addObject("cdmMongodbEnterpriseBaseInfoD", cdmMongodbEnterpriseBaseInfoD);





            }
        }

        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }


    @RequestMapping(value = "/workbench")
    public ModelAndView getSubscription(PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("my_workbench");
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        //获取系统当天是星期几
        int dayofweek = 0;
        dayofweek = CurrentTime.getDayOfWeek();

        modelAndView.addObject("user", sessionService.getUser());
        modelAndView.addObject("dayofweek", dayofweek);
        return modelAndView;

    }


    @RequestMapping(value = "/myservice")
    public ModelAndView getMyService(PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("myservice_enterprise");
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        //EnterpriseBankListRespDTO result = crmModService.invEventList(req);
        //modelAndView.addObject("result", result);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    @RequestMapping(value = "/contactsmanage")
    public ModelAndView getContactPerson(PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("contacts_manage");
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        //EnterpriseBankListRespDTO result = crmModService.invEventList(req);
        //modelAndView.addObject("result", result);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    @RequestMapping(value = "/marketing/reachcsr/{pathvar}")
    public ModelAndView getMarketingReachcsr(@PathVariable("pathvar") String pathvar, ReachShowDTO form, PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws Exception {

        ModelAndView modelAndView = null;
        String msg = null;
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        //校验企业
        if (pathvar.equals("entchk")) {
            modelAndView = new ModelAndView("reach_add");
            String corpName = null;
            corpName = req.getCorpName();
            EnterpriseBankListRespDTO result = null;
            EnterpriseBankListRespDTO qxbresult = null;
            if (corpName != null && !corpName.equals("")) {
                result = crmModService.enterpriseByFullName(req); //先从本地库检索
                if (result.getEntSglContents().getRecCnt() > 0) { //如果本地库存在
                    modelAndView.addObject("result", result);
                } else  //如果本地库不存在，就调用启信宝接口查询
                {
                    qxbresult = crmModService.getEntInitData(corpName);
                    if (qxbresult.getEntSglContents().getRegNo() == "xxxxxxyyyyyyzzzzzz" && qxbresult.getEntSglContents().getCreditNo() == "xxxxxxyyyyyyzzzzzz") {
                        msg = "该企业不存在，请检查输入的企业全名是否正确！";
                        modelAndView.addObject("msg", msg);
                        modelAndView.addObject("result", qxbresult);
                    } else {
                        //记录操作日志
                        OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                        operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                        operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                        operationLogDTO.setEventType(OperationLogCode.OPERATION_QXBINIT); //设置操作事件
                        operationLogDTO.setModule(OperationLogCode.MODULE_CRM_REACH); //设置业务模块
                        operationLogDTO.setOperationDesc("reg_no:".concat(qxbresult.getEntSglContents().getRegNo()).concat("|credit_no:").concat(qxbresult.getEntSglContents().getCreditNo())); //设置操作内容
                        int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库

                        modelAndView.addObject("result", qxbresult);
                    }
                }
            }
        }

        //添加触达信息
        if (pathvar.equals("addreach")) {
            modelAndView = new ModelAndView("reach_add");
        }

        //编辑触达信息
        if (pathvar.equals("editreach")) {
            //从请求URL中获取要编辑订单的ID
            String rchNo = null;
            rchNo = request.getParameter("rch_no");
            ReachShowDTO result = crmModService.reachSgl(rchNo);

            modelAndView = new ModelAndView("reach_edit");
            modelAndView.addObject("result", result);
        }

        int insertFlag = 0;
        int updateFlag = 0;

        //提交新增触达信息
        if (pathvar.equals("submit")) {
            msg = crmModService.insertReach(form);
            insertFlag = 1;
            if (msg.equals("新增成功")) {
                //记录操作日志
                OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                operationLogDTO.setEventType(OperationLogCode.OPERATION_INSERT); //设置操作事件
                operationLogDTO.setModule(OperationLogCode.MODULE_CRM_REACH); //设置业务模块
                if (StringUtils.isEmpty(form.getRegNo()) && StringUtils.isEmpty(form.getCreditNo())) {   //如果reg_no和credit_no都为空，可能是拜访的政府部门
                    operationLogDTO.setOperationDesc("object:".concat(form.getGovName())); //设置操作内容
                } else {
                    operationLogDTO.setOperationDesc("reg_no:".concat(form.getRegNo()).concat("|credit_no:").concat(form.getCreditNo())); //设置操作内容
                }
                int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库
            }
        }

        //提交修改触达信息
        if (pathvar.equals("update")) {
            updateFlag = crmModService.updateReach(form);
            if (updateFlag == 1) {
                //记录操作日志
                OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                operationLogDTO.setEventType(OperationLogCode.OPERATION_EDIT); //设置操作事件
                operationLogDTO.setModule(OperationLogCode.MODULE_CRM_REACH); //设置业务模块
                operationLogDTO.setOperationDesc("rch_no:".concat(form.getRchNo())); //设置操作内容
                int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库

                msg = "编辑成功！";
            }
        }

        //如果是查看全部触达信息列表或者某个企业的触达信息列表
        if (insertFlag != 0 || updateFlag != 0 || pathvar.equals("reachlist") || pathvar.equals("viewent")) {
            //从请求URL中获取参数的reg_credit_no（如果是viewent请求查看某家企业的触达信息）
            String regCreditNo = null;
            regCreditNo = request.getParameter("reg_credit_no");
            req.setRegCreditNo(regCreditNo);
            ReachManageListRespDTO result = null;

            String company = sessionService.getUser().getCompany();  //用户所在公司
            req.setUserName(sessionService.getUser().getUserName()); //设置用户名
            req.setCompany(company); //设置用户所在公司
            req.setMemberType(sessionService.getUser().getMemberType()); //设置用户类型

            //查询当前用户所在公司下的所有员工
            List<MemberBaseInfo> companyUserList = crmModService.companyUserList(company);

            result = crmModService.reachManageList(req);

            List<EnterpriseTag> enterpriseTagList = crmModService.queryEntTagFromDB();
            modelAndView = new ModelAndView("marketing_reachcsr");
            modelAndView.addObject("companyUserList", companyUserList);
            modelAndView.addObject("result", result);
            modelAndView.addObject("msg", msg);
            modelAndView.addObject("enterpriseTagList", enterpriseTagList);
        }

        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    @RequestMapping(value = "/marketing/reachcsr/addreach")
    public ModelAndView getReachcsrAdd(PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("reach_add");
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    @RequestMapping(value = "/actmanage/{pathvar}")
    public ModelAndView getActManage(@PathVariable("pathvar") String pathvar, ActShowDTO form, PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = null;
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        //新增活动
        if (pathvar.equals("addact")) {
            modelAndView = new ModelAndView("act_add");
        }

        String msg = null;
        int insertFlag = 0;

        //提交新增信息
        if (pathvar.equals("submit")) {
            insertFlag = crmModService.insertAct(form);
            if (insertFlag == 1) {
                //记录操作日志
                OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                operationLogDTO.setEventType(OperationLogCode.OPERATION_INSERT); //设置操作事件
                operationLogDTO.setModule(OperationLogCode.MODULE_CRM_ACTIVE); //设置业务模块
                operationLogDTO.setOperationDesc("act_no:".concat(form.getActNo())); //设置操作内容
                int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库
                msg = "新增成功！";
            }
            response.sendRedirect("/crm/actmanage/viewall");
            return null;
        }

        //活动信息列表
        if (insertFlag != 0 || pathvar.equals("viewall")) {
            modelAndView = new ModelAndView("marketing_act");
            ActManageListRespDTO result = null;
            req.setUserName(sessionService.getUser().getUserName()); //设置用户名
            req.setCompany(sessionService.getUser().getCompany()); //设置用户所在公司
            req.setMemberType(sessionService.getUser().getMemberType()); //设置用户类型
            result = crmModService.actManageList(req);
            modelAndView.addObject("result", result);
            modelAndView.addObject("msg", msg);
        }

        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    @RequestMapping(value = "/salemanage")
    public ModelAndView getSaleManage(PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("sale_manage");
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        //EnterpriseBankListRespDTO result = crmModService.invEventList(req);
        //modelAndView.addObject("result", result);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    //新增、编辑订单、显示全部或者某个企业的订单列表
    @RequestMapping(value = "/ordermanage/{pathvar}")
    public ModelAndView getOrderManage(@PathVariable("pathvar") String pathvar, PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = null;
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        //如果是查看全部订单信息列表或者某个企业订单信息列表
        if (pathvar.equals("viewall") || pathvar.equals("viewent")) {
            //从请求URL中获取参数的reg_credit_no
            String regCreditNo = null;
            regCreditNo = request.getParameter("reg_credit_no");
            req.setRegCreditNo(regCreditNo);
            OrderManageListRespDTO result = null;

            req.setUserName(sessionService.getUser().getUserName()); //设置用户名
            req.setCompany(sessionService.getUser().getCompany()); //设置用户所在公司
            req.setMemberType(sessionService.getUser().getMemberType()); //设置用户类型
            result = crmModService.orderManageList(req);
            modelAndView = new ModelAndView("order_manage");
            modelAndView.addObject("result", result);
        }

        //获取当前用户所在公司和省份
        String company = sessionService.getUser().getCompany();
        String province = sessionService.getUser().getProvince();

        String msg = null;   //返回消息

        //校验企业后返回新增订单页面
        if (pathvar.equals("entchk")) {
            modelAndView = new ModelAndView("order_add");

            //查询商品列表
            List<ProductShowDTO> productList = crmModService.productList(company);
            //查询当前用户所在公司下的所有用户
            List<MemberBaseInfo> companyUserList = crmModService.companyUserList(company);
            //查询平台服务商
            String partnerType = "1"; //1为平台服务商
            List<PartnerShowDTO> srvCoList = crmModService.partnerList(province, company, partnerType);

            String corpName = null;
            corpName = req.getCorpName();
            EnterpriseBankListRespDTO result = null;
            EnterpriseBankListRespDTO qxbresult = null;
            if (corpName != null && !corpName.equals("")) {
                result = crmModService.enterpriseByFullName(req); //先从本地库检索
                if (result.getEntSglContents().getRecCnt() > 0) { //如果本地库存在
                    modelAndView.addObject("result", result);
                    modelAndView.addObject("productList", productList);
                    modelAndView.addObject("companyUserList", companyUserList);
                    modelAndView.addObject("srvCoList", srvCoList);
                } else  //如果本地库不存在，就调用启信宝接口查询
                {
                    qxbresult = crmModService.getEntInitData(corpName);
                    if (qxbresult.getEntSglContents().getRegNo() == "xxxxxxyyyyyyzzzzzz" && qxbresult.getEntSglContents().getCreditNo() == "xxxxxxyyyyyyzzzzzz") {
                        msg = "该企业不存在，请检查输入的企业全名是否正确！";
                        modelAndView.addObject("msg", msg);
                        modelAndView.addObject("result", qxbresult);
                        modelAndView.addObject("productList", productList);
                        modelAndView.addObject("companyUserList", companyUserList);
                        modelAndView.addObject("srvCoList", srvCoList);
                    } else {
                        //记录操作日志
                        OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                        operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                        operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                        operationLogDTO.setEventType(OperationLogCode.OPERATION_QXBINIT); //设置操作事件
                        operationLogDTO.setModule(OperationLogCode.MODULE_CRM_ORDER); //设置业务模块
                        operationLogDTO.setOperationDesc("reg_no:".concat(qxbresult.getEntSglContents().getRegNo()).concat("|credit_no:").concat(qxbresult.getEntSglContents().getCreditNo())); //设置操作内容
                        int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库

                        modelAndView.addObject("result", qxbresult);
                        modelAndView.addObject("productList", productList);
                        modelAndView.addObject("companyUserList", companyUserList);
                        modelAndView.addObject("srvCoList", srvCoList);
                    }
                }
            }
        }

        //新增订单页面
        if (pathvar.equals("addorder")) {
            //查询商品列表
            List<ProductShowDTO> productList = crmModService.productList(company);
            //查询当前用户所在公司下的所有用户
            List<MemberBaseInfo> companyUserList = crmModService.companyUserList(company);
            //查询平台服务商
            String partnerType = "1"; //1为平台服务商
            List<PartnerShowDTO> srvCoList = crmModService.partnerList(province, company, partnerType);

            modelAndView = new ModelAndView("order_add");
            modelAndView.addObject("productList", productList);
            modelAndView.addObject("companyUserList", companyUserList);
            modelAndView.addObject("srvCoList", srvCoList);
        }

        //编辑订单
        if (pathvar.equals("editorder")) {
            //从请求URL中获取要编辑订单的ID
            String orderNo = null;
            orderNo = request.getParameter("order_no");
            OrderShowDTO result = crmModService.orderSgl(orderNo);

            //查询当前用户所在公司下的所有用户
            List<MemberBaseInfo> companyUserList = crmModService.companyUserList(company);

            modelAndView = new ModelAndView("order_edit");
            modelAndView.addObject("companyUserList", companyUserList);
            modelAndView.addObject("result", result);
        }

        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }

    //新增、编辑订单后预览订单信息
    @RequestMapping(value = "/ordermanage/orderview/{pathvar}")
    public ModelAndView getOrderInfo(@PathVariable("pathvar") String pathvar, OrderShowDTO form, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("order_view");
        String msg = null;
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }

        //新增订单后先入库再显示预览
        int insertFlag = 0;
        if (pathvar.equals("add")) {
            insertFlag = crmModService.insertOrder(form); //新增订单入库
            if (insertFlag >= 1) {
                //记录操作日志
                OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                operationLogDTO.setEventType(OperationLogCode.OPERATION_INSERT); //设置操作事件
                operationLogDTO.setModule(OperationLogCode.MODULE_CRM_ORDER); //设置业务模块
                operationLogDTO.setOperationDesc("reg_no:".concat(form.getRegNo()).concat("|credit_no:").concat(form.getCreditNo())); //设置操作内容
                int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库
            }
        }

        //修改订单
        int updateFlag = 0;
        if (pathvar.equals("update")) {
            updateFlag = crmModService.updateOrder(form);
            if (updateFlag >= 1) {
                //记录操作日志
                OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                operationLogDTO.setEventType(OperationLogCode.OPERATION_EDIT); //设置操作事件
                operationLogDTO.setModule(OperationLogCode.MODULE_CRM_ORDER); //设置业务模块
                operationLogDTO.setOperationDesc("reg_no:".concat(form.getRegNo()).concat("|credit_no:").concat(form.getCreditNo())); //设置操作内容
                int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库
            }
        }

        if (insertFlag == 1) {
            msg = "订单新增成功！";
        }
        if (updateFlag == 1) {
            msg = "订单更新成功！";
        }

        modelAndView.addObject("msg", msg);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }

    @RequestMapping(value = "/contractmanage/{pathvar}")
    public ModelAndView getContractManage(@PathVariable("pathvar") String pathvar, ContractShowDTO form, PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = null;
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        //添加合同信息
        if (pathvar.equals("addcontract")) {
            modelAndView = new ModelAndView("contract_add");
        }

        String msg = null;
        int insertFlag = 0;

        //提交新增信息
        if (pathvar.equals("submit")) {
            insertFlag = crmModService.insertContract(form);
            if (insertFlag == 1) {
                //记录操作日志
                OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                operationLogDTO.setEventType(OperationLogCode.OPERATION_INSERT); //设置操作事件
                operationLogDTO.setModule(OperationLogCode.MODULE_CRM_CONTRACT); //设置业务模块
                operationLogDTO.setOperationDesc("contract_no:".concat(form.getContractNo())); //设置操作内容
                int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库
                msg = "新增成功！";
            } else {
                msg = "订单号不存在！";
                modelAndView = new ModelAndView("contract_add");
                modelAndView.addObject("msg", msg);
            }
        }

        //编辑合同
        if (pathvar.equals("editcontract")) {
            //从请求URL中获取要编辑订单的ID
            String contractNo = null;
            contractNo = request.getParameter("contract_no");
            ContractShowDTO result = crmModService.contractSgl(contractNo);

            modelAndView = new ModelAndView("contract_edit");
            modelAndView.addObject("result", result);
        }

        //提交修改合同
        int updateFlag = 0;
        if (pathvar.equals("update")) {
            updateFlag = crmModService.updateContract(form);
            if (updateFlag >= 1) {
                msg = "合同编辑成功！";

                //记录操作日志
                OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                operationLogDTO.setEventType(OperationLogCode.OPERATION_EDIT); //设置操作事件
                operationLogDTO.setModule(OperationLogCode.MODULE_CRM_CONTRACT); //设置业务模块
                operationLogDTO.setOperationDesc("contract_no:".concat(form.getContractNo())); //设置操作内容
                int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库
            }
        }

        //合同信息列表
        if (insertFlag != 0 || updateFlag != 0 || pathvar.equals("viewall")) {
            modelAndView = new ModelAndView("contract_manage");
            ContractManageListRespDTO result = null;
            result = crmModService.contractManageList(req);
            modelAndView.addObject("result", result);
            modelAndView.addObject("msg", msg);
        }

        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    @RequestMapping(value = "/partnermanage/{pathvar}")
    public ModelAndView getPartnerManage(@PathVariable("pathvar") String pathvar, PartnerShowDTO form, PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = null;
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        String msg = null;   //返回消息

        //校验企业
        if (pathvar.equals("entchk")) {
            modelAndView = new ModelAndView("partner_add");
            String corpName = null;
            corpName = req.getCorpName();
            EnterpriseBankListRespDTO result = null;
            EnterpriseBankListRespDTO qxbresult = null;
            if (corpName != null && !corpName.equals("")) {
                result = crmModService.enterpriseByFullName(req); //先从本地库检索
                if (result.getEntSglContents().getRecCnt() > 0) { //如果本地库存在
                    modelAndView.addObject("result", result);
                } else  //如果本地库不存在，就调用启信宝接口查询
                {
                    qxbresult = crmModService.getEntInitData(corpName);
                    if (qxbresult.getEntSglContents().getRegNo() == "xxxxxxyyyyyyzzzzzz" && qxbresult.getEntSglContents().getCreditNo() == "xxxxxxyyyyyyzzzzzz") {
                        msg = "该企业不存在，请检查输入的企业全名是否正确！";
                        modelAndView.addObject("msg", msg);
                        modelAndView.addObject("result", qxbresult);
                    } else {
                        //记录操作日志
                        OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                        operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                        operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                        operationLogDTO.setEventType(OperationLogCode.OPERATION_QXBINIT); //设置操作事件
                        operationLogDTO.setModule(OperationLogCode.MODULE_CRM_PARTNER); //设置业务模块
                        operationLogDTO.setOperationDesc("reg_no:".concat(qxbresult.getEntSglContents().getRegNo()).concat("|credit_no:").concat(qxbresult.getEntSglContents().getCreditNo())); //设置操作内容
                        int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库

                        modelAndView.addObject("result", qxbresult);
                    }
                }
            }
        }

        int insertFlag = 0;

        //新增页面
        if (pathvar.equals("add")) {
            modelAndView = new ModelAndView("partner_add");
        }

        //提交新增信息
        if (pathvar.equals("addsubmit")) {
            insertFlag = crmModService.insertPartner(form);
            if (insertFlag >= 1) {
                msg = "新增成功！";

                //记录操作日志
                OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
                operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
                operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
                operationLogDTO.setEventType(OperationLogCode.OPERATION_INSERT); //设置操作事件
                operationLogDTO.setModule(OperationLogCode.MODULE_CRM_PARTNER); //设置业务模块
                operationLogDTO.setOperationDesc("reg_no:".concat(form.getRegNo()).concat("|credit_no:").concat(form.getCreditNo())); //设置操作内容
                int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库
            }
        }

        //合作伙伴信息列表
        if (insertFlag != 0 || pathvar.equals("viewall")) {
            String memberType = null;  //用户类型
            memberType = sessionService.getUser().getMemberType();
            req.setMemberType(sessionService.getUser().getMemberType());  //赋值用户类型
            if (Integer.parseInt(memberType) >= 90)  //分公司人员
            {//分公司只能看本区域或者本省的
                //req.setRegionCode(sessionService.getUser().getCompany());
                req.setCompany(sessionService.getUser().getCompany());  //赋值所在公司
                req.setProvince(sessionService.getUser().getProvince());
            }

            PartnerBankListRespDTO result = crmModService.partnerBankList(req);

            modelAndView = new ModelAndView("partner_manage");
            modelAndView.addObject("result", result);
            modelAndView.addObject("msg", msg);
        }

        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

    @RequestMapping(value = "/projectbank")
    public ModelAndView getProjectBank(PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("project_bank");
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        List<EnterpriseTag> enterpriseTagList = crmModService.queryEntTagFromDB();

        modelAndView.addObject("enterpriseTagList", enterpriseTagList);

        EnterpriseBankListRespDTO result = crmModService.projectBankList(req);
        modelAndView.addObject("result", result);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }


    @RequestMapping(value = "/invevent")
    public ModelAndView getInvEvent(PageReqDTO req, HttpServletResponse response, HttpServletRequest request) throws IOException {

        ModelAndView modelAndView = new ModelAndView("inv_event");
        UserInfoDTO member = sessionService.getUser();
        if (null == member) {
            response.sendRedirect("/login");
            return null;
        }
        req.setMemberId(member.getMemberId());
        if (request.getMethod().toLowerCase().equals("post")) {
            req.setCurrentPage(1);
        }

        EnterpriseBankListRespDTO result = crmModService.invEventList(req);
        modelAndView.addObject("result", result);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;

    }

}

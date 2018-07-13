package com.xlh.crm.service;

import com.xlh.crm.dto.*;
import com.xlh.crm.dto.mysql.CdmEntDtoHighTech;

import java.util.List;

/**
 * @author: ysl
 * @version: 0.1
 * @create time: 2017/03/16
 * @description:
 */
public interface EnterpriseDetailService {

    //企业档案-基本信息
    EnterpriseBaseInfoRespDTO enterpriseBaseInfoList(String regCreditNo);

    //企业档案-客户经理、收藏信息
    EnterpriseShowDTO enterpriseFavorite(PageReqDTO req);

    //企业档案-主要人员
    List<EnterpriseEmployeeRespDTO> enterpriseEmployeeList(String regCreditNo);

    //企业档案-服务订单
    List<OrderShowDTO> enterpriseOrderList(String regCreditNo);

    //企业档案-触达信息
    List<EnterpriseReachcsrRespDTO> enterpriseReachcsrList(String regCreditNo);

    //企业档案-历史融资
    List<EnterpriseFinancingRespDTO> enterpriseFinancingList(String regCreditNo);

    //企业档案-股东信息
    List<EnterprisePartnerRespDTO> enterprisePartnerList(String regCreditNo);

    //企业档案-公司人员结构
    EnterpriseEmpStrucRespDTO enterpriseEmpStrucList(String regCreditNo);

    //企业档案-核心团队
    List<EnterpriseCoreTeamRespDTO> enterpriseCoreTeamList(String regCreditNo);

    //企业档案-公司联系人
    List<EnterpriseContactsRespDTO> enterpriseContactsList(String regCreditNo);

    //企业档案-资质荣誉
    List<EnterpriseHonorRespDTO> enterpriseHonorList(String regCreditNo);

    //企业档案-市场发展情况
    EnterpriseMarketDevRespDTO enterpriseMarketDevList(String regCreditNo);

    //企业档案-上市情况
    EnterpriseIpoRespDTO enterpriseIpoList(String regCreditNo);

    //企业档案-归属载体
    EnterpriseCarrierRespDTO enterpriseCarrierList(String regCreditNo);

    //企业档案-财务数据
    List<EnterpriseFindataRespDTO> enterpriseFindataList(String regCreditNo);

    //企业档案-项目数据
    List<EnterpriseProjRespDTO> enterpriseProjList(String regCreditNo);

    //添加收藏企业
    Integer enterpriseAddFav(PageReqDTO reqDTO);

    //取消收藏企业
    Integer enterpriseCelFav(PageReqDTO reqDTO);

    //企业档案-公司人员结构（编辑）
    Integer enterpriseEmpStrucUpdate(EnterpriseEmpStrucRespDTO empStrucRespDTO);

    //企业档案--公司介绍（编辑）
    Integer enterpriseBaseInfoUpdate(EnterpriseBaseInfoRespDTO baseInfoRespDTO);

    //企业档案--市场发展（编辑）
    Integer enterpriseMarketDevUpdate(EnterpriseMarketDevRespDTO marketDevRespDTO);

    //企业档案--上市情况（编辑）
    Integer enterpriseIpoUpdate(EnterpriseIpoRespDTO ipoRespDTO);

    //企业档案--归属载体（编辑）
    Integer enterpriseCarrierUpdate(EnterpriseCarrierRespDTO carrierRespDTO);

    //企业档案--核心团队（新增）
    Integer enterpriseCoreTeamInsert(EnterpriseCoreTeamRespDTO coreTeamRespDTO);

    //企业档案--核心团队（删除）
    Integer enterpriseCoreTeamDelete(EnterpriseCoreTeamRespDTO coreTeamRespDTO);

    //企业档案--公司联系人（新增）
    Integer enterpriseContactsInsert(EnterpriseContactsRespDTO contactsRespDTO);

    //企业档案--公司联系人（删除）
    Integer enterpriseContactsDelete(EnterpriseContactsRespDTO contactsRespDTO);

    //企业档案--资质荣誉（新增）
    Integer enterpriseHonorInsert(EnterpriseHonorRespDTO honorRespDTO);

    //企业档案--资质荣誉（删除）
    Integer enterpriseHonorDelete(EnterpriseHonorRespDTO honorRespDTO);

    //企业档案--财务数据（新增）
    Integer enterpriseFindataInsert(EnterpriseFindataRespDTO findataRespDTO);

    //企业档案--财务数据（删除）
    Integer enterpriseFindataDelete(EnterpriseFindataRespDTO findataRespDTO);

    //高新技术企业更新
    public int updateHighTech(CdmEntDtoHighTech cdmEntDtoHighTech);

    //高新技术企业选择
    public CdmEntDtoHighTech selectOneHighTech(String regCreditNo);

    //企业财务报表
    public List<EnterpriseFinanceTableShowDto> selectFinanceTableInfo(String regCreditNo);
}

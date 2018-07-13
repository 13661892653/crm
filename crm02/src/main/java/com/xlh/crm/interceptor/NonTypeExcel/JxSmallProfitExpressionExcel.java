package com.xlh.crm.interceptor.NonTypeExcel;

import com.xlh.crm.dto.mysql.FiTmpExcelJxSmallProfitTable;
import com.xlh.crm.exception.ColumnNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JxSmallProfitExpressionExcel {
    private static Logger logger = LogManager.getLogger(JxSmallProfitExpressionExcel.class.getName());

    public FiTmpExcelJxSmallProfitTable interpret(String content) throws Exception {
        System.out.println(content);
        FiTmpExcelJxSmallProfitTable smallProfitTableDto = new FiTmpExcelJxSmallProfitTable();
        Matcher m;
        try {
            m = preg(content, "纳税人名称: (\\D*) 纳税人识别号/社会信用代码: (\\d+)");
            smallProfitTableDto.setEnterpriseName(m.group(1));
            smallProfitTableDto.setCreditNo(m.group(2));
        } catch (Exception e) {
//            e.printStackTrace();
        }
        try {
            m = preg(content, "所属期起：(\\d{4}-\\d{1,2}-\\d{1,2})     所属期止：(\\d{4}-\\d{1,2}-\\d{1,2})  单位： (\\D)会小企02表");
            smallProfitTableDto.setBeginTime(m.group(1));
            smallProfitTableDto.setEndTime(m.group(2));
            smallProfitTableDto.setUnit(m.group(3));
        } catch (Exception e) {
//            e.printStackTrace();
        }


//


//        String part_pattern = "\\s*(-{0,1}(\\d{1,3},)*(\\d{3},)*\\d{1,3}\\.\\d{2})\\s*(-{0,1}(\\d{1,3},)*(\\d{3},)*\\d{1,3}\\.\\d{2})\\s*";
//        String part_pattern="\\s*(-{0,1}\\d+\\.\\d{0,2})\\s*(-{0,1}\\d+\\.\\d{0,2}){0,1}\\s*";
//        String part_pattern="\\s*(-{0,1}\\d+(\\.\\d+){0,1})\\s*(-{0,1}\\d+(\\.\\d+){0,1}){0,1}\\s*";
        String part_pattern="\\s*((-{0,1}\\d+(\\.\\d+){0,1})|(-{0,1}(\\d{1,3},)*(\\d{3},)*\\d{1,3}\\.\\d{2}))\\s*((-{0,1}\\d+(\\.\\d+){0,1})|(-{0,1}(\\d{1,3},)*(\\d{3},)*\\d{1,3}\\.\\d{2})){0,1}\\s*";
        try {
            m = pregNum(content, "营业收入\\s*1(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setBusinessIncomeMonth(formatToNum(formatToNum(m.group(2))));
            smallProfitTableDto.setBusinessIncomeYear(formatToNum(formatToNum(m.group(8))));
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            m = pregNum(content, "营业成本\\s*2(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setBusinessCostsMonth(formatToNum(formatToNum(m.group(2))));
            smallProfitTableDto.setBusinessCostsYear(formatToNum(formatToNum(m.group(8))));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "营业税金及附加\\s*3(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setBusinessAndAdditionTaxMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setBusinessAndAdditionTaxYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            m = pregNum(content, "消费税\\s*4(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setExciseTaxMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setExciseTaxYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            m = pregNum(content, "营业税\\s*5(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setBusinessTaxMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setBusinessTaxYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }



        try {
            m = pregNum(content, "城市维护建设税\\s*6(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setCityBuildTaxMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setCityBuildTaxYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "资源税\\s*7(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setResourceTaxMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setResourceTaxYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            m = pregNum(content, "土地增值税\\s*8(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setLandValueAddedTaxMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setLandValueAddedTaxYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            m = pregNum(content, "城镇土地使用税、房产税、车船税、印花税\\s*9(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setCityHouseCarTaxMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setCityHouseCarTaxYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            m = pregNum(content, "教育费附加、矿产资源补偿费、排污费\\s*10(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setEducationMineralSewageTaxMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setEducationMineralSewageTaxYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            m = pregNum(content, "销售费用\\s*11(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setSallFeesMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setSallFeesYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            m = pregNum(content, "其中：商品维修费\\s*12(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setProductRepairFeeMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setProductRepairFeeYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            m = pregNum(content, "广告费和业务宣传费\\s*13(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setPublicityFeeMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setPublicityFeeYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            m = pregNum(content, "管理费用\\s*14(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setManagementFeeMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setManagementFeeYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            m = pregNum(content, "开办费\\s*15(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setOrganizationFeeMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setOrganizationFeeYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "业务招待费\\s*16(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setExtertainmentFeeMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setExtertainmentFeeYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "研究费用\\s*17(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setResearchFeeMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setResearchFeeYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "财务费用\\s*18(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setFinancialFeeMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setFinancialFeeYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "利息费用（收入以“-”号填列）\\s*19(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setInterestFeeMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setInterestFeeYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "投资收益（损失以“-”号填列）\\s*20(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setInvestmentIncomeMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setInvestmentIncomeYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "二、营业利润（亏损以“-”号填列）\\s*21(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setBusinessProfitMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setBusinessProfitYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "营业外收入\\s*22(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setBusinessOutIncomeMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setBusinessOutIncomeYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "政府补助\\s*23(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setGovernmentSubsidyMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setGovernmentSubsidyYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "营业外支出\\s*24(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setBudinessOutExpendMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setBudinessOutExpendYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "坏账损失\\s*25(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setBadDebtLossMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setBadDebtLossYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "无法收回的长期债券投资损失\\s*26(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setCanNotReceiveLongTimeBondLossMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setCanNotReceiveLongTimeBondLossYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "无法收回的长期股权投资损失\\s*27(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setCanNotReceiveLongTimeStockLossMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setCanNotReceiveLongTimeStockLossYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "自然灾害等不可抗力因素造成的损失\\s*28(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setNaturalDisasterLossMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setNaturalDisasterLossYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "税收滞纳金\\s*29(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setTaxLatePaymentMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setTaxLatePaymentYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "三、利润总额.*\\s*30(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setTotalProfitMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setTotalProfitYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "所得税费用\\s*31(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setIncomeTaxMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setIncomeTaxYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }


        try {
            m = pregNum(content, "净利润（净亏损以“-”号填列）\\s*32(\\.00){0,1}" , part_pattern);
            smallProfitTableDto.setNetProfitMonth(formatToNum(m.group(2)));
            smallProfitTableDto.setNetProfitYear(formatToNum(m.group(8)));
        } catch (Exception e) {
//            e.printStackTrace();
        }





        return smallProfitTableDto;
    }


    private String formatToNum(String input) {
        return input.replace(",", "");
    }

    private Matcher preg(String str, String pattern) throws ColumnNotFoundException {
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find()) {
            return m;
        } else {
            throw new ColumnNotFoundException(pattern);
        }
    }
    private Matcher pregNum(String str,String pattern1,String pattern2) throws ColumnNotFoundException {
        Pattern r = Pattern.compile(pattern1+pattern2);
        Matcher m = r.matcher(str);
        if (m.find()) {
            return m;
        } else {
            Pattern r2 = Pattern.compile(pattern1+pattern2);
            Matcher m2 = r.matcher(str);
            if(m2.find()){
                str=str+" 0.00 0.00";
                Matcher m3=r.matcher(str);
                if(m3.find()){
                    return m3;
                }
            }
            throw new ColumnNotFoundException(pattern1+pattern2);
        }
    }
}
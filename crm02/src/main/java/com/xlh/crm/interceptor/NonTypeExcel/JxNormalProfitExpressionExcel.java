package com.xlh.crm.interceptor.NonTypeExcel;

import com.xlh.crm.dto.mysql.FiTmpExcelJxNormalProfitTable;
import com.xlh.crm.exception.ColumnNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JxNormalProfitExpressionExcel {
    private static Logger logger = LogManager.getLogger(JxNormalProfitExpressionExcel.class.getName());
    public FiTmpExcelJxNormalProfitTable interpret(String input) throws Exception {

        System.out.println(input);
        String content=input;
        FiTmpExcelJxNormalProfitTable normalProfitTableDto =new FiTmpExcelJxNormalProfitTable();

        Matcher m;
        try{
            m=preg(content,"纳税人名称: (\\D*) 纳税人识别号/社会信用代码: (\\d+)");
            normalProfitTableDto.setEnterpriseName(m.group(1));
            normalProfitTableDto.setCreditNo(m.group(2));
        }catch(Exception e){
//            e.printStackTrace();
        }

//        String part_pattern="\\s*(-{0,1}\\d+\\.\\d{0,2})\\s*(-{0,1}\\d+\\.\\d{0,2})\\s*";
        String part_pattern="\\s*((-{0,1}\\d+(\\.\\d+){0,1})|(-{0,1}(\\d{1,3},)*(\\d{3},)*\\d{1,3}\\.\\d{2}))\\s*((-{0,1}\\d+(\\.\\d+){0,1})|(-{0,1}(\\d{1,3},)*(\\d{3},)*\\d{1,3}\\.\\d{2})){0,1}\\s*";
        try{
            m=pregNum(content,"主营业务收入\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setBusinessIncomeMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setBusinessIncomeYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }

        try{
            m=pregNum(content,"主营业务成本\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setBusinessCostsMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setBusinessCostsYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }


        try{
            m=pregNum(content,"主营业务税金及附加\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setBusinessAndAdditionTaxMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setBusinessAndAdditionTaxYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }
        try{
            m=pregNum(content,"主营业务利润\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setMainBusinessProfitMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setMainBusinessProfitYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }
        try{
            m=pregNum(content,"其他业务利润\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setOtherBusinessProfitsMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setOtherBusinessProfitsYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }

        try{
            m=pregNum(content,"营业费用\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setOperatingExpensesMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setOperatingExpensesYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }


        try{
            m=pregNum(content,"管理费用\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setManagementExpensesMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setManagementExpensesYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }

        try{
            m=pregNum(content,"财务费用\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setFinancialExpensesMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setFinancialExpensesYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }

        try{
            m=pregNum(content,"营业利润\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setBusinessProfitMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setBusinessProfitYear(formatToNum(m.group(7)));

        }catch(Exception e){
//            e.printStackTrace();
        }
        try{
            m=pregNum(content,"投资收益\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setInvestmentIncomeMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setInvestmentIncomeYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }

        try{
            m=pregNum(content,"补贴收入\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setSubsidyIncomeMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setSubsidyIncomeYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }

        try{
            m=pregNum(content,"营业外收入\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setBusinessOutIncomeMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setBusinessOutIncomeYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }
        try{
            m=pregNum(content,"营业外支出\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setBudinessOutExpendMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setBudinessOutExpendYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }

        try{
            m=pregNum(content,"利润总额\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setTotalProfitMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setTotalProfitYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }
        try{
            m=pregNum(content,"所得税费用\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setIncomeTaxMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setIncomeTaxYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }

        try{
            m=pregNum(content,"净利润\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setNetProfitMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setNetProfitYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }


        try{
            m=pregNum(content,"出售、处置部门或被投资单位所得收益 本年累计\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setProceedsFromTheDisposalOrDisposalUnitMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setProceedsFromTheDisposalOrDisposalUnitYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }


        try{
            m=pregNum(content,"自然灾害发生的损失本年累计\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setNaturalDisasterLossMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setNaturalDisasterLossYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }

        try{
            m=pregNum(content,"会计政策变更增加（或减少）利润总额 本年累计\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setIncreaseTotalProfitOfAccountingPolicyChangeMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setIncreaseTotalProfitOfAccountingPolicyChangeYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }

        try{
            m=pregNum(content,"会计估计变更增加（或减少）利润总额 本年累计\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setIncreaseTotalProfitOfAccountingEstimateChangeMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setIncreaseTotalProfitOfAccountingEstimateChangeYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }
        try{
            m=pregNum(content,"债务重组损失 本年累计\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setDebtRestructuringLossMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setDebtRestructuringLossYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }

        try{
            m=pregNum(content,"其他\\s*\\d*(\\.00){0,1} ",part_pattern);
            normalProfitTableDto.setOtherMonth(formatToNum(m.group(1)));
            normalProfitTableDto.setOtherYear(formatToNum(m.group(7)));
        }catch(Exception e){
//            e.printStackTrace();
        }



        return normalProfitTableDto;
    }
    private Matcher preg(String str,String pattern) throws ColumnNotFoundException {
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
    private String formatToNum(String input){
        return input.replace(",","");
    }
}

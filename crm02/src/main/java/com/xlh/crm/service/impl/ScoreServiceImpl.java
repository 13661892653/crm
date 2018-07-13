package com.xlh.crm.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xlh.crm.dto.EnterpriseBaseInfoRespDTO;
import com.xlh.crm.dto.EnterpriseEmpStrucRespDTO;
import com.xlh.crm.dto.EnterpriseFindataRespDTO;
import com.xlh.crm.dto.EnterpriseShowDTO;
import com.xlh.crm.dto.mysql.CdmEntDtoHighTech;
import com.xlh.crm.dto.score.TopicScore;
import com.xlh.crm.mapper.EnterpriseDetailMapper;
import com.xlh.crm.service.EnterpriseDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ScoreServiceImpl {
    private Logger logger = LoggerFactory.getLogger(ScoreServiceImpl.class);

    @Autowired
    private JedisPool jedisPool;
    @Autowired
    EnterpriseDetailMapper enterpriseDetailMapper;
    @Autowired
    EnterpriseDetailService enterpriseDetailService;

    private SimpleDateFormat simpleDateFormatYMD = new SimpleDateFormat("yyyy-MM-dd");

    public void insertRedis(List<String> regCreditNos) {
        Jedis jedis = jedisPool.getResource();
        try {
            for (String regCreditNo : regCreditNos) {
                jedis.lpush("ScoreServiceImpl.insertRedis.list", regCreditNo);
            }
        } catch (Exception e) {
            logger.info("exception={}", e.getMessage());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void insertRedis(String regCreditNo) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.lpush("ScoreServiceImpl.insertRedis.list", regCreditNo);
        } catch (Exception e) {
            logger.info("exception={}", e.getMessage());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String popRedis() {
        Jedis jedis = jedisPool.getResource();
        try {
            String regCreditNo = jedis.rpop("ScoreServiceImpl.insertRedis.list");
            return regCreditNo;
        } catch (Exception e) {
            logger.info("exception={}", e.getMessage());
            return "";
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public int getScore(TopicScore topicScore) {
        int score = 0;
        //注册资本
        if (topicScore.getRegisterMoney().compareTo(new BigDecimal(30)) != -1) {
            score += 5;
        }
        //成立年限
        if (topicScore.getCreateYears().compareTo(new BigDecimal(3)) != -1) {
            score += 5;
        } else if (topicScore.getCreateYears().compareTo(new BigDecimal(2)) != -1) {
            score += 4;
        } else if (topicScore.getCreateYears().compareTo(new BigDecimal(1)) != -1) {
            score += 3;
        }
        //行业
        if (
                topicScore.getMainIndustry().contains("电子信息") ||
                        topicScore.getMainIndustry().contains("生物与新医药") ||
                        topicScore.getMainIndustry().contains("航空航天") ||
                        topicScore.getMainIndustry().contains("新材料") ||
                        topicScore.getMainIndustry().contains("高技术服务") ||
                        topicScore.getMainIndustry().contains("新能源与节能") ||
                        topicScore.getMainIndustry().contains("资源与环境") ||
                        topicScore.getMainIndustry().contains("先进制造与自动化") ||
                        topicScore.getMainIndustry().contains("其他高科技领域") ||
                        topicScore.getMainIndustry().contains("非高新技术领域")
                ) {
            score += 10;
        }
        //专利
        if (topicScore.getIntellectual_property_num() >= 15) {
            score += 40;
        } else if (topicScore.getIntellectual_property_num() >= 10) {
            score += 30;
        } else if (topicScore.getIntellectual_property_num() >= 5) {
            score += 30;
        } else if (topicScore.getIntellectual_property_num() >= 1) {
            score += 15;
        }
        //收入
        BigDecimal income = topicScore.getIncome2017().add(topicScore.getIncome2016().add(topicScore.getIncome2015()));
        BigDecimal researchFee = topicScore.getResearchFee2017().add(topicScore.getResearchFee2016().add(topicScore.getResearchFee2015()));
        BigDecimal divide;
        if (income.compareTo(new BigDecimal(0)) == 0) {
            divide = new BigDecimal(0);
        } else {
            divide = researchFee.divide(income, 3, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
        }

        if (topicScore.getIncome2017().compareTo(new BigDecimal(5000)) != 1) {
            if (divide.compareTo(new BigDecimal(5)) != -1) {
                score += 10;
            } else if (divide.compareTo(new BigDecimal(3)) != -1) {
                score += 6;
            }
        } else if (topicScore.getIncome2017().compareTo(new BigDecimal(20000)) != 1) {
            if (divide.compareTo(new BigDecimal(4)) != -1) {
                score += 10;
            } else if (divide.compareTo(new BigDecimal(2)) != -1) {
                score += 6;
            }
        } else {
            if (divide.compareTo(new BigDecimal(3)) != -1) {
                score += 10;
            } else if (divide.compareTo(new BigDecimal(1)) != -1) {
                score += 6;
            }
        }

        BigDecimal tmp910, tmp89;
        if (topicScore.getIncome2015().compareTo(new BigDecimal(0)) == 0) {
            tmp910 = new BigDecimal(0);
        } else {
            tmp910 = topicScore.getIncome2016().divide(topicScore.getIncome2015(), 3, BigDecimal.ROUND_HALF_UP);
        }
        if (topicScore.getIncome2016().compareTo(new BigDecimal(0)) == 0) {
            tmp89 = new BigDecimal(0);
        } else {
            tmp89 = topicScore.getIncome2017().divide(topicScore.getIncome2016(), 3, BigDecimal.ROUND_HALF_UP);
        }
        tmp89 = new BigDecimal(0.5).multiply(tmp89.add(tmp910)).subtract(new BigDecimal(1));
        tmp89 = tmp89.multiply(new BigDecimal(100));
        if (tmp89.compareTo(new BigDecimal(35)) != -1) {
            score += 9;
        } else if (tmp89.compareTo(new BigDecimal(25)) != -1) {
            score += 7;
        } else if (tmp89.compareTo(new BigDecimal(15)) != -1) {
            score += 5;
        } else if (tmp89.compareTo(new BigDecimal(5)) != -1) {
            score += 3;
        } else if (tmp89.compareTo(new BigDecimal(0)) != -1) {
            score += 1;
        }


        BigDecimal tmp1213, tmp1112;
        if (topicScore.getNetAssets2015().compareTo(new BigDecimal(0)) == 0) {
            tmp1112 = new BigDecimal(0);
        } else {
            tmp1112 = topicScore.getNetAssets2016().divide(topicScore.getNetAssets2015(), 3, BigDecimal.ROUND_HALF_UP);
        }
        if (topicScore.getNetAssets2016().compareTo(new BigDecimal(0)) == 0) {
            tmp1213 = new BigDecimal(0);
        } else {
            tmp1213 = topicScore.getNetAssets2017().divide(topicScore.getNetAssets2016(), 3, BigDecimal.ROUND_HALF_UP);
        }
        tmp1213 = new BigDecimal(0.5).multiply(tmp1213.add(tmp1112)).subtract(new BigDecimal(1));
        tmp1213 = tmp1213.multiply(new BigDecimal(100));
        if (tmp1213.compareTo(new BigDecimal(35)) != -1) {
            score += 9;
        } else if (tmp1213.compareTo(new BigDecimal(25)) != -1) {
            score += 7;
        } else if (tmp1213.compareTo(new BigDecimal(15)) != -1) {
            score += 5;
        } else if (tmp1213.compareTo(new BigDecimal(5)) != -1) {
            score += 3;
        } else if (tmp1213.compareTo(new BigDecimal(0)) != -1) {
            score += 1;
        }


        if (topicScore.getTotalEmployeeNum() >= 3 && topicScore.getResearchEmployeeNum() >= 3) {
            double tmp = topicScore.getResearchEmployeeNum() / topicScore.getTotalEmployeeNum() * 100;
            if (tmp >= 10) {
                score += 10;
            } else if (tmp >= 5) {
                score += 6;
            }
        }

        return score;
    }

    public TopicScore getScoreObj(String regCreditNo) {
        EnterpriseBaseInfoRespDTO respDTO = enterpriseDetailMapper.getEnterpriseBaseInfoList(regCreditNo);
        CdmEntDtoHighTech record = new CdmEntDtoHighTech();
        record.setReg_credit_no(regCreditNo);
        CdmEntDtoHighTech cdmEntDtoHighTech = enterpriseDetailMapper.enterpriseSelectHighTech(record);
        List<EnterpriseFindataRespDTO> incomes = enterpriseDetailMapper.getEnterpriseFindataList(regCreditNo);
        EnterpriseEmpStrucRespDTO resultEmpStruc = enterpriseDetailService.enterpriseEmpStrucList(regCreditNo);

        TopicScore topicScore = new TopicScore();
        try {
            topicScore.setEnterpriseName(respDTO.getEnterpriseName());
            topicScore.setRegisterMoney(new BigDecimal(respDTO.getRegisterMoney().replace("万人民币", "").trim()));
        } catch (Exception e) {
            logger.info("Exception={}", e.getMessage());
        }

        //注册年限
        try {
            Date create = simpleDateFormatYMD.parse(respDTO.getCreateDate());
            Date now = new Date();
            long cut = now.getTime() - create.getTime();
            topicScore.setCreateYears(new BigDecimal(cut / (1000 * 3600 * 24 * 365)));
        } catch (Exception e) {
            topicScore.setCreateYears(new BigDecimal(0));
            logger.info(" 注册年限Exception={}", e.getMessage());
        }
        //企业所属行业领域
        try {
            topicScore.setMainIndustry(respDTO.getMainIndustry() != null ? respDTO.getMainIndustry() : "");
        } catch (Exception e) {
            logger.info("企业所属行业领域 Exception={}", e.getMessage());
        }

        //知识产权数量
        try {
            topicScore.setIntellectual_property_num(cdmEntDtoHighTech.getIntellectual_property_num());
        } catch (Exception e) {
            logger.info("知识产权数量 Exception={}", e.getMessage());
        }
        //销售收入 净资产收入

        try {
            for (EnterpriseFindataRespDTO income : incomes) {
                if (income.getFinYear() != null && income.getFinYear().contains("2017")) {
                    topicScore.setIncome2017(new BigDecimal(income.getOperatingIncome()));
                    topicScore.setNetAssets2017(new BigDecimal(income.getNetAssets()));
                }
                if (income.getFinYear() != null && income.getFinYear().contains("2016")) {
                    topicScore.setIncome2016(new BigDecimal(income.getOperatingIncome()));
                    topicScore.setNetAssets2016(new BigDecimal(income.getNetAssets()));
                }
                if (income.getFinYear() != null && income.getFinYear().contains("2015")) {
                    topicScore.setIncome2015(new BigDecimal(income.getOperatingIncome()));
                    topicScore.setNetAssets2015(new BigDecimal(income.getNetAssets()));
                }
            }
        } catch (Exception e) {
            logger.info("销售收入 净资产收入 Exception={}", e.getMessage());
        }

        //研发费用
        try {
            JSONArray fees = JSONArray.parseArray(cdmEntDtoHighTech.getIncome_scale());
            for (int i = 0; i < fees.size(); i++) {
                JSONObject fee = fees.getJSONObject(i);
                if (fee.getString("year").contains("2017")) {
                    topicScore.setResearchFee2017(new BigDecimal(fee.getString("amount")));
                }
                if (fee.getString("year").contains("2016")) {
                    topicScore.setResearchFee2016(new BigDecimal(fee.getString("amount")));
                }
                if (fee.getString("year").contains("2015")) {
                    topicScore.setResearchFee2015(new BigDecimal(fee.getString("amount")));
                }
            }
        } catch (Exception e) {
            logger.info("研发费用 Exception={}", e.getMessage());
        }

        try {
            topicScore.setTotalEmployeeNum(new Integer(resultEmpStruc.getStaffNumber()));
            topicScore.setResearchEmployeeNum(new Integer(resultEmpStruc.getRdNumber()));
        } catch (Exception e) {
            logger.info("Exception={}", e.getMessage());
        }
        return topicScore;
    }

    public int updateScore(String regCreditNo, int score) {
        EnterpriseShowDTO enterpriseShowDTO = new EnterpriseShowDTO();
        enterpriseShowDTO.setRegCreditNo(regCreditNo);
        enterpriseShowDTO.setGqScore(score);
        return enterpriseDetailMapper.updateGqScore(enterpriseShowDTO);
    }


    public void calculatorScore(String regCreditNo){
        logger.info("start calculatorScore regCreditNo={}",regCreditNo);
        TopicScore topicScore=getScoreObj(regCreditNo);
        int score=getScore(topicScore);
        updateScore(regCreditNo,score);
        logger.info("regCreditNo={} score={}  =====topicScore={}",regCreditNo,score, JSON.toJSONString(topicScore));
    }
}

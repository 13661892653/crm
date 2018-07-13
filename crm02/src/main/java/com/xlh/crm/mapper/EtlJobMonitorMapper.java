package com.xlh.crm.mapper;

import com.xlh.crm.dto.EnterpriseBaseInfoRespDTO;
import com.xlh.crm.dto.mysql.ods.EtlJobMonitor;
import com.xlh.crm.utils.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface EtlJobMonitorMapper extends MyMapper<EtlJobMonitor> {
    @Update({
            "update etl_job_monitor "+
                    "set flag = #{flag,jdbcType=VARCHAR} "+
                    " where ds = #{ds,jdbcType=VARCHAR}"
    })
    int updateTodayFlag(@Param("ds")String ds,@Param("flag")String flag);
}

package com.xlh.crm.mapper;

import com.xlh.crm.dto.mysql.CdmMongodbEnterpriseBaseInfo;
import com.xlh.crm.utils.MyMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CdmMongodbEnterpriseBaseInfoMapper extends MyMapper<CdmMongodbEnterpriseBaseInfo> {
    @Results({
            @Result(column = "enterprise_name", property = "enterpriseName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "file_path", property = "profitDistributionFile", jdbcType = JdbcType.VARCHAR),
    })
    @Select("select t1.enterprise_name,t2.file_path from cdm_mongodb_enterprise_base_info t1 LEFT JOIN cdm_mongodb_enterprise_upload_files t2 on  t1._id=t2.enterprise_id")
    public List<CdmMongodbEnterpriseBaseInfo> selectJoin();
}

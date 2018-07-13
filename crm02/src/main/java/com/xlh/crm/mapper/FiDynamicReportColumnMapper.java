package com.xlh.crm.mapper;

import com.xlh.crm.dto.mysql.CrmActive;
import com.xlh.crm.dto.mysql.FiDynamicReportColumn;
import com.xlh.crm.utils.MyMapper;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;

public interface FiDynamicReportColumnMapper extends MyMapper<FiDynamicReportColumn> {
    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn="id")
    int insert(FiDynamicReportColumn record);
}

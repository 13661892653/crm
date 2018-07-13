package com.xlh.crm.mapper;

import com.xlh.crm.dto.mysql.FiFileList;
import com.xlh.crm.utils.MyMapper;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;

public interface FiFileListMapper extends MyMapper<FiFileList> {
    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(FiFileList record);
}

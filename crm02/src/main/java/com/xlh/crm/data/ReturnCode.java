package com.xlh.crm.data;

/**
 * Created by wwz on 2016/11/28.
 */
public class ReturnCode {


    /**
     * 数据协议返回描述信息
     */
    public final static int SUCCESS = 1;
    public final static String MSG_SUCCESS = "Success";

    public final static int FAIL = 0;
    public final static String MSG_FAIL = "Fail";

    /**
     * 内部错误
     */
    public final static int DATABASE_EXCEPTION = 3001;
    public final static String MSG_DATABASE_EXCEPTION = "数据库异常";

    public final static int API_RESPONSE_EXCEPTION = 3003;
    public final static String MSG_API_RESPONSE_EXCEPTION = "接口返回异常数据";

    public final static int NO_CORP_INFO_EXCEPTION= 3004;
    public final static String MSG_NO_CORP_INFO_EXCEPTION = "主表中无相关企业数据";

    public final static int REQUEST_PARAM_EXCEPTION= 3005;
    public final static String MSG_REQUEST_PARAM_EXCEPTION= "请求参数异常";

    public final static int PDF_CREATED_FAIL= 3006;
    public final static String MSG_PDF_CREATED_FAIL= "报告生成错误";

    public final static int API_NO_DATA = 3007;
    public final static String MSG_API_NO_DATA= "查询无结果";

    public final static int UP_TO_USER_SEARCH_LIMIT = 3008;
    public final static String MSG_UP_TO_USER_SEARCH_LIMIT= "该用户今日已达到搜索上限";

    public final static int NO_CORP_INFO = 3010;
    public final static String MSG_NO_CORP_INFO= "该注册号无该企业信息";

    /**
     * 没有财务数据
     * */
    public final static int FN_DATA_EXCEPTION = 3002;
}

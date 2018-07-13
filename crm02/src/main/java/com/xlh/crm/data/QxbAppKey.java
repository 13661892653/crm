package com.xlh.crm.data;

//import com.xlh.crm.utils.PropertiesUtil;

/**
 * Created by wwz on 2016/12/30.
 */
public class QxbAppKey {

//    public static final String environment = PropertiesUtil.getValue("xlh.credit.platform.environment");
    public static final String environment = "pro";

    public static final String CORP_INFO =
            environment.equals("pro") ? "e675abc8da1649adac410c5ab0d6fca2": "";

    //public static final String CORP_INFO =
    //        environment.equals("pro") ? "ada44bd0070711e6b8a865678b483fde": "";

    public static final String JUDGE =
            environment.equals("pro") ? "b7c5f3c037964ab897fca62d2baa3b89" : "";

    public static final String NOTICE =
            environment.equals("pro") ? "d78915692dd948cab6b18444a88966ca" : "";

    public static final String RENEGE =
            environment.equals("pro") ? "df59c00d1e9a4fae8049a40cf047b576" : "";

    public static final String AUCTION =
            environment.equals("pro") ? "9eaa1b3162034439b1e3851241db61f7" : "";

    public static final String OWING_TAX =
            environment.equals("pro") ? "f5fdeaa72b7543caa5cd942b058594c7" : "";

    public static final String MORTGAGE =
            environment.equals("pro") ? "32d33ab78b0a4fbaa6fa550288ff3ea9" : "";

    public static final String EQUITY_PLEDGE =
            environment.equals("pro") ? "38057fbc75d94bd7ae03595949f7dbc5" : "";

    public static final String CORP_CODE=
            environment.equals("pro") ? "475ecdecf6044e9e959ec44169a97573" : "";

    public static final String SESSION=
            environment.equals("pro") ? "2059f7fce9eb41609704f9634371220b" : "";

    public static final String PATENT=
            environment.equals("pro") ? "5ca244a424c64a329ae02710af14e3fd" : "";

    public static final String TRADEMARK=
            environment.equals("pro") ? "88368e99a45841d287ba0103df6e29a5" : "";

    public static final String COPYRIGHT=
            environment.equals("pro") ? "67525ff4cafa4b1f95ab4e1455a3365c" : "";

    public static final String COPYRIGHT_SOFT=
            environment.equals("pro") ? "832e1ff0de1f44ae8b0ce788bd4c2b21" : "";

    public static final String CERT_INFO=
            environment.equals("pro") ? "a4b607d58c5944eab3e17929ae5a4187" : "";

    public static final String BID=
            environment.equals("pro") ? "8b9031522aac47e1838ed123199f01c8" : "";

    public static final String INV_INFO=
            environment.equals("pro") ? "511454923c2b4d0192878a28c59ecfa2" : "";

    public static final String RECRUITMENT=
            environment.equals("pro") ? "f6eeafb05d8241fcb14e29c6633a34a1" : "";

}

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8"/>
    <title>信隆行CRM系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <meta name="MobileOptimized" content="320">
    <link rel="icon" type="image/x-icon" href="/favicon.ico">
    <link href="/dist/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/plugins1.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/layout.css" rel="stylesheet" type="text/css"/>
    <!-- <link href="/dist/css/default.css" rel="stylesheet" type="text/css" id="style_color" /> -->
    <link href="/dist/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="/dist/css/custom.css" rel="stylesheet" type="text/css"/>

    <!-- added by yingsl on 20170523 -->
    <link href="/dist/css/enterprisebank.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/jquery-ui.min.css" rel="stylesheet">

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
<#assign page=210/>
<#include "../top_menu.ftl"/>

<!-- 仪表盘页面中部区域层：BEGIN-->
<div class="page-container">
    <!--引入页面左边菜单tree-->
<#include "../left_menu.ftl"/>
    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="#">初录</a>
                    </li>
                </ul>
            </div>

            <div class="portlet">
                <div class="portlet-body">
                    <form id="partnerForm" action="/crm/partnermanage/addsubmit" method="post"
                          class="form-horizontal form-row-sepe">
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-2">合作企业名称：<span class="required">* </span></label>
                                <input id="partnerName" name="partnerName" type="text"
                                       file_id="${excelFileDetail.fiFileList.id?c}" class="control-label col-md-2"
                                       placeholder="请输入企业全名" <#if (excelFileDetail.fiFileList.enterpriseName)??>
                                       value="${excelFileDetail.fiFileList.enterpriseName}" <#else> value="" </#if>/>
                                <label class="control-label col-md-1">&nbsp;</label>
                                <div class="search">
                                    <input type="button" value="校验企业" class="btn blue" id="jiaoyan"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">统一社会信用代码：</label>
                                <input id="creditNo" name="creditNo" readonly="readonly" placeholder="此文本框不可输入"
                                       type="text"
                                       class="control-label col-md-2" <#if (excelFileDetail.fiFileList.creditNo)??>
                                       value="${excelFileDetail.fiFileList.creditNo?replace("xxxxxxyyyyyyzzzzzz","")}" <#else>
                                       value="" </#if>/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">工商注册号：</label>
                                <input id="regNo" name="regNo" readonly="readonly" type="text" placeholder="此文本框不可输入"
                                       class="control-label col-md-2" <#if (excelFileDetail.fiFileList.regNo)??>
                                       value="${excelFileDetail.fiFileList.regNo?replace("xxxxxxyyyyyyzzzzzz","")}" <#else>
                                       value="" </#if>/>
                            </div>
                            <input type="hidden" id="fiStatus" value="${excelFileDetail.fiFileList.status}">

                        </div>
                    </form>
                </div>
            </div>
            <!-- BEGIN 数据展示区-->
            <div class="portlet" id="table_show_div">
                <div class="portlet-body">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr style="background-color: #9ca7b7;">
                            <th width="6%">
                                sheet名称
                            </th>
                            <th width="7%">
                                会计准则
                            </th>
                            <th width="7%">
                                报表类型
                            </th>
                            <th width="7%">
                                报表名称
                            </th>
                            <th width="7%">
                                报表日期
                            </th>
                            <th width="20%">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list excelFileDetail.fiExcelSheetList as fiExcleSheet>
                        <tr>
                            <td>
                            ${fiExcleSheet.sheetName?if_exists}
                            </td>
                            <td>
                                <select class="sheetStander" sheet_id="${fiExcleSheet.id?c?if_exists}">
                                    <option value=""> 请选择</option>
                                    <option <#if (fiExcleSheet.sheetStander?if_exists) == "Normal">selected="selected" </#if> value="Normal">一般企业</option>
                                    <option <#if (fiExcleSheet.sheetStander?if_exists) == "Small">selected="selected" </#if> value="Small">小企业</option>
                                    <option <#if (fiExcleSheet.sheetStander?if_exists) == "wuxiao">selected="selected" </#if> value="wuxiao">无效</option>
                                </select>
                            </td>
                            <td>
                                <select class="reportType" sheet_id="${fiExcleSheet.id?c?if_exists}">
                                    <option value="">请选择</option>
                                    <option <#if (fiExcleSheet.reportType?if_exists) == "tax">selected="selected" </#if> value="tax">纳税报表</option>
                                    <option <#if (fiExcleSheet.reportType?if_exists) == "in">selected="selected" </#if> value="in">内表</option>
                                    <option <#if (fiExcleSheet.reportType?if_exists) == "audit">selected="selected" </#if> value="audit">审计报表</option>
                                    <option <#if (fiExcleSheet.reportType?if_exists) == "wuxiao">selected="selected" </#if> value="wuxiao">无效</option>
                                </select>
                            </td>
                            <td>
                                <select class="tableName" sheet_id="${fiExcleSheet.id?c?if_exists}">
                                    <option value="">请选择</option>
                                    <option <#if (fiExcleSheet.tableName?if_exists) == "Profit">selected="selected" </#if> value="Profit">利润表</option>
                                    <option <#if (fiExcleSheet.tableName?if_exists) == "Balance">selected="selected" </#if> value="Balance">资产负债表</option>
                                    <option <#if (fiExcleSheet.tableName?if_exists) == "wuxiao">selected="selected" </#if> value="wuxiao">无效</option>
                                </select>
                            </td>
                            <td>
                                <input type="text" class="sheetDate" id="sheetDate_${fiExcleSheet.id?c?if_exists}" value="${fiExcleSheet.sheetDate?if_exists}">
                            </td>
                            <td>
                            <#--<button class="btn" href="/financeinput/tableEdit?id=${fiExcleSheet.id?if_exists}">编辑</button>-->

                                <button class="btn edit_type" sheet_id="${fiExcleSheet.id?c?if_exists}">保存类型</button>

                                <button class="btn edit" sheet_id="${fiExcleSheet.id?c?if_exists}">编辑</button>
                            </td>

                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="form-actions">
                    <div class="row">
                        <div class="col-md-offset-3 col-md-4">
                            <input type="button" value="提交" id="tijiao" class="btn purple">
                        </div>
                    </div>
                    <br>
                <#if '${user.memberType}'=='12'>
                    <div class="row">
                        <div class="form-actions">
                            <div class="col-md-offset-4 col-md-4">
                                <input type="button" value="打回" id="dahui" class="btn purple">
                            </div>
                            <div class="col-md-offset-3 col-md-4">
                                错误备注<textarea id="remark" rows="10" cols="20"></textarea>
                            </div>
                        </div>
                    </div>
                </#if>
                </div>

            </div>
            <!-- END 数据展示区-->
        </div>
    </div>
</div>

<!-- BEGIN 框架效果 -->
<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<!-- added by yingsl on 20170523 -->
<script src="/dist/js/jquery.pagination.js"></script>
<script src="/dist/js/jquery-ui.min.js"></script>
<script src="/dist/js/filter_entbank.js"></script>
<script src="/dist/js/data_select.js"></script>
<script src="/dist/js/crm.js?v=1"></script>
<script src="/dist/js/laydate5.0.7/laydate.js"></script>

<script>

<#list excelFileDetail.fiExcelSheetList as fiExcleSheet>
    laydate.render({
        elem: '#sheetDate_${fiExcleSheet.id?c?if_exists}'
        , type: 'month'
    });
</#list>
    $(".edit_type").click(function () {
        var sheetStander=$(this).parent().parent().find(".sheetStander").val();
        var reportType=$(this).parent().parent().find(".reportType").val();
        var tableName=$(this).parent().parent().find(".tableName").val();
        var sheetDate=$(this).parent().parent().find(".sheetDate").val();
        if(sheetStander==""||reportType==""||tableName==""||sheetDate==""){
            alert("字段为空");
            return;
        }
        $.post(
                "/financeinput/updateSheet",
                {
                    id: $(this).attr("sheet_id"),
                    sheetStander: sheetStander,
                    reportType: reportType,
                    tableName: tableName,
                    sheetDate: sheetDate,
                },
                function (data) {
                    if (data.code != 200) {
                        alert(data.msg);
                    }else{
                        alert("成功");
                    }
                }
        );
    });
    $("#jiaoyan").click(function () {
        if ($("#fiStatus").val() != 0) {
            alert("已经校验过了");
            return;
        }
        $.post(
                "/financeinput/checkName",
                {
                    key: $("#partnerName").val(),
                    id: $("#partnerName").attr("file_id")
                },
                function (data) {
                    if (data.code != 200) {
                        alert(data.msg);
                        return;
                    }
                    $("#regNo").val(data.data.regNo);
                    $("#creditNo").val(data.data.creditNo);
                    $("#fiStatus").val(data.data.status);
                }
        );
    });
    $(".edit").click(function () {
        if ($("#fiStatus").val() == 0) {
            alert("请先校验");
            return;
        }
        window.open("/financeinput/tableEdit?id=" + $(this).attr("sheet_id"));
    })

    $("#tijiao").click(function () {

        $.get(
        <#if '${user.memberType}'=='11'>
                "/financeinput/detailCommit?id=${excelFileDetail.fiFileList.id?c}",
        </#if>
        <#if '${user.memberType}'=='12'>
                "/financeinput/detailCopyCommit?id=${excelFileDetail.fiFileList.id?c}",
        </#if>
                function (data) {
                    if (data.code == 200) {
                    <#if '${user.memberType}'=='11'>
                        alert("提交复核");
                        window.location.href = "/financeinput/list";
                    </#if>
                    <#if '${user.memberType}'=='12'>
                        alert("复核通过");
                        window.location.href = "/financeinput/copylist";
                    </#if>
                    } else {
                        alert(data.msg);
                    }
                }
        );
    });
    $("#dahui").click(function () {
       $.post(
           "/financeinput/reject",
               {id:${excelFileDetail.fiFileList.id?c},
               remark:$("#remark").val()},
               function (data) {
                   if(data.code==200){
                       alert("驳回成功");
                       window.location.href = "/financeinput/copylist";
                   }
               }
       );
    });
</script>
</body>
</html>

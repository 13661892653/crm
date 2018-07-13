<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <meta name="MobileOptimized" content="320">
    <link rel="icon" type="image/x-icon" href="/favicon.ico">
    <link href="/dist/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/custom.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/jquery-ui.min.css" rel="stylesheet">
    <link href="/dist/css/style-meta.css" rel="stylesheet">
</head>
<body id="body">

</br>

<form id="formAddFav" action="/crm/enterprisedetail/addfav" method="post">
    <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??> value="${resultBaseInfo.regNo}" </#if>/>
    <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
           value="${resultBaseInfo.creditNo}" </#if>/>
    <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
           value="${resultBaseInfo.regCreditNo}" </#if>/>
</form>

<form id="formCelFav" action="/crm/enterprisedetail/celfav" method="post">
    <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??> value="${resultBaseInfo.regNo}" </#if>/>
    <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
           value="${resultBaseInfo.creditNo}" </#if>/>
    <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
           value="${resultBaseInfo.regCreditNo}" </#if>/>
</form>

<table style="border:none" class="table">
    <tbody>
    <#if msg??><label style="color: #ff0007">${msg}</label></#if>
    <tr>
        <td align="right">
        <#if resultFav??>
            <#if resultFav.favUserList?contains(user.userName)>
                <input type="button" value="取消收藏" class="btn yellow" id="btn_celfav" onclick="clickbtn(this)"/>
            <#else>
                <input type="button" value="收藏" class="btn red" id="btn_addfav" onclick="clickbtn(this)"/>
            </#if>
        <#else>
            <input type="button" value="收藏" class="btn red" id="btn_addfav" onclick="clickbtn(this)"/>
        </#if>
        </td>
    </tr>
    </tbody>
</table>
<span class="badge badge-danger"><#if (resultBaseInfo.auditStatus)??> <#if resultBaseInfo.auditStatus == 1>已认证<#else>
    未认证</#if><#else>未认证</#if></span>
<span class="badge badge-success icon-user">&nbsp;
<#if (resultBaseInfo.custManager)??>
    <#if resultBaseInfo.custManager!=''>企服人员：${resultBaseInfo.custManager}
    <#else>企服人员：未指派
    </#if>
<#else>企服人员：未指派
</#if>
</span>
</br>
</br>
<div class="row">
    <div class="col-md-12">
        <div class="portlet box purple">
            <div class="portlet-title">
                <div class="caption">
                    不可变更信息
                </div>
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#tab1" data-toggle="tab" aria-expanded="true">基础信息</a>
                    </li>
                    <li class="">
                        <a href="#tab2" data-toggle="tab" aria-expanded="false">主要人员 </a>
                    </li>
                    <li class="">
                        <a href="#tab3" data-toggle="tab" aria-expanded="false">股东信息</a>
                    </li>
                    <li class="">
                        <a href="#tab4" data-toggle="tab" aria-expanded="false">历史融资并购记录</a>
                    </li>
                    <li class="">
                        <a href="#tab5" data-toggle="tab" aria-expanded="false">历史服务订单</a>
                    </li>
                    <li class="">
                        <a href="#tab6" data-toggle="tab" aria-expanded="false">历史触达信息</a>
                    </li>
                    <li class="">
                        <a href="#tab7" data-toggle="tab" aria-expanded="false">财务报表数据</a>
                    </li>
                </ul>
            </div>
            <div class="portlet-body">
                <div class="tab-content">
                    <div class="tab-pane" id="tab7">
                        <div class="portlet box purple">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>财务报表数据
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-bordered">
                                        <thead>
                                        <tr>
                                            <th>
                                                会计准则
                                            </th>
                                            <th>
                                                报表类型
                                            </th>
                                            <th>
                                                报表名称
                                            </th>
                                            <th>
                                                报表日期
                                            </th>
                                            <th>
                                                操作
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#if reulstFinanceTables??>
                                            <#list reulstFinanceTables as reulstFinanceTable>
                                            <tr>
                                                <td width="8%">
                                                ${resultFinanceTableMap[reulstFinanceTable.tableStander?if_exists]!}
                                                </td>
                                                <td width="8%">
                                                ${resultFinanceTableMap[reulstFinanceTable.reportType?if_exists]!}
                                                </td>
                                                <td width="8%">
                                                ${resultFinanceTableMap[reulstFinanceTable.tableName?if_exists]!}
                                                </td>
                                                <td width="8%">
                                                    <#if reulstFinanceTable.tableDate??>${reulstFinanceTable.tableDate}</#if>
                                                </td>
                                                <td width="8%">
                                                    <a target="_blank"
                                                       href="/crm/enterprisedetail/financetable?type=${reulstFinanceTable.tableStander?if_exists}${reulstFinanceTable.tableName?if_exists}&id=${reulstFinanceTable.id?if_exists}">查看</a>
                                                </td>
                                            </tr>
                                            </#list>
                                        </#if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tab6">
                        <div class="portlet box purple">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>历史触达信息（显示最近4条）
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-bordered">
                                        <thead>
                                        <tr>
                                            <th>
                                                触达人
                                            </th>
                                            <th>
                                                触达时间
                                            </th>
                                            <th>
                                                获客渠道
                                            </th>
                                            <th>
                                                触达方式
                                            </th>
                                            <th>
                                                对方联系人
                                            </th>
                                            <th>
                                                对方联系方式
                                            </th>
                                            <th>
                                                潜在销售机会
                                            </th>
                                            <th>
                                                内容纪要
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#if resultReachcsr??>
                                            <#list resultReachcsr as reachcsr>
                                            <tr>
                                                <td width="8%">
                                                    <#if reachcsr.rchEmp??>${reachcsr.rchEmp}</#if>
                                                </td>
                                                <td width="8%">
                                                    <#if reachcsr.beginTime??>${reachcsr.beginTime}</#if>
                                                </td>
                                                <td width="8%">
                                                    <#if reachcsr.winCustChnl??>${reachcsr.winCustChnl}</#if>
                                                </td>
                                                <td width="8%">
                                                    <#if reachcsr.rchMode??>${reachcsr.rchMode}</#if>
                                                </td>
                                                <td width="8%">
                                                    <#if reachcsr.contacts??>${reachcsr.contacts}</#if>
                                                </td>
                                                <td width="10%">
                                                    <#if reachcsr.contactsPhone??>${reachcsr.contactsPhone}</#if>
                                                </td>
                                                <td width="15%">
                                                    <#if reachcsr.salesLead??>${reachcsr.salesLead}</#if>
                                                </td>
                                                <td width="35%">
                                                    <#if reachcsr.remark??>${reachcsr.remark}</#if>
                                                </td>
                                            </tr>
                                            </#list>
                                        </#if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tab5">
                        <div class="portlet box purple">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>历史服务订单
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-bordered">
                                        <thead>
                                        <tr>
                                            <th>
                                                订单号
                                            </th>
                                            <th>
                                                下单时间
                                            </th>
                                            <th>
                                                下单人
                                            </th>
                                            <th>
                                                订单商品名
                                            </th>
                                            <th>
                                                订单总金额
                                            </th>
                                            <th>
                                                订单状态
                                            </th>
                                            <th>
                                                是否自营
                                            </th>
                                            <th>
                                                平台服务商名
                                            </th>
                                            <th>
                                                当前进展
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#if resultOrder??>
                                            <#list resultOrder as order>
                                            <tr>
                                                <td>
                                                ${order.orderNo}
                                                </td>
                                                <td>
                                                ${order.orderDate}
                                                </td>
                                                <td>
                                                    <#if (order.orderMemeberName)??>${order.orderMemeberName}</#if>
                                                </td>
                                                <td>
                                                    <#if (order.orderProdName)??>${order.orderProdName}</#if>
                                                </td>
                                                <td>
                                                    <#if (order.orderAmt)??>${order.orderAmt}</#if>
                                                </td>
                                                <td>
                                                    <#if (order.orderStatus)??>${order.orderStatus}</#if>
                                                </td>
                                                <td>
                                                    <#if (order.isSelfBiz)??&&(order.isSelfBiz) == "Y">是
                                                    <#else>否
                                                    </#if>
                                                </td>
                                                <td>
                                                    <#if (order.partnerName)??>${order.partnerName}</#if>
                                                </td>
                                                <td>
                                                    <#if (order.progress)??>${order.progress}</#if>
                                                </td>
                                            </tr>
                                            </#list>
                                        </#if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tab4">
                        <div class="portlet box purple">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>历史融资并购记录
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-bordered">
                                        <thead>
                                        <tr>
                                            <th>
                                                融资时间
                                            </th>
                                            <th>
                                                融资金额
                                            </th>
                                            <th>
                                                轮次
                                            </th>
                                            <th>
                                                投资机构
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#if resultFinancing??>
                                            <#list resultFinancing as financing>
                                            <tr>
                                                <td>
                                                ${financing.financingDate}
                                                </td>
                                                <td>
                                                ${financing.financingCurrency}
                                                </td>
                                                <td>
                                                ${financing.financingStage}
                                                </td>
                                                <td>
                                                ${financing.investors}
                                                </td>
                                            </tr>
                                            </#list>
                                        </#if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tab3">
                        <div class="portlet box purple">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>股东信息
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-bordered">
                                        <thead>
                                        <tr>
                                            <th>
                                                股东类型
                                            </th>
                                            <th>
                                                股东
                                            </th>
                                            <th>
                                                认缴出资金额
                                            </th>
                                            <th>
                                                认缴出资时间
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#if resultPartner??>
                                            <#list resultPartner as partner>
                                            <tr>
                                                <td>
                                                    <#if (partner.partnerType)??>${partner.partnerType}</#if>
                                                </td>
                                                <td>
                                                    <#if (partner.partnerName)??>${partner.partnerName}</#if>
                                                </td>
                                                <td>
                                                    <#if (partner.shouldCapi)??>${partner.shouldCapi}</#if>
                                                </td>
                                                <td>
                                                    <#if (partner.shouldCapiDate)??>${partner.shouldCapiDate}</#if>
                                                </td>
                                            </tr>
                                            </#list>
                                        </#if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tab2">
                        <div class="portlet box purple">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>主要人员
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-bordered">
                                        <thead>
                                        <tr>
                                            <th>
                                                职位
                                            </th>
                                            <th>
                                                姓名
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#if resultEmployee??>
                                            <#list resultEmployee as employee>
                                            <tr>
                                                <td>
                                                ${employee.jobTitle}
                                                </td>
                                                <td>
                                                ${employee.name}
                                                </td>
                                            </tr>
                                            </#list>
                                        </#if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane active" id="tab1">
                        <div class="portlet box purple">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>基础信息
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-bordered">
                                        <tbody>
                                        <tr>
                                            <td width="150px">
                                                公司名：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.enterpriseName)??>${resultBaseInfo.enterpriseName}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                统一社会信用代码：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.creditNo)??>${resultBaseInfo.creditNo}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                工商注册号：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.regNo)??>${resultBaseInfo.regNo}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                经营状态：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.mgmtStatus)??>${resultBaseInfo.mgmtStatus}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                公司类型：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.econKind)??>${resultBaseInfo.econKind}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                注册资本：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.registerMoney)??>${resultBaseInfo.registerMoney}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                法定代表人：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.legalRepresentative)??>${resultBaseInfo.legalRepresentative}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                营业期限：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.operateDate)??>${resultBaseInfo.operateDate}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                企业地址：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.entAddress)??>${resultBaseInfo.entAddress}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                联系电话：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.contactTelephone)??>${resultBaseInfo.contactTelephone}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                邮箱：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.contactEmail)??>${resultBaseInfo.contactEmail}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                成立日期：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.createDate)??>${resultBaseInfo.createDate}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                行业：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.industryName)??>${resultBaseInfo.industryName}</#if>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                经营范围：
                                            </td>
                                            <td>
                                            <#if (resultBaseInfo.mgmtScope)??>${resultBaseInfo.mgmtScope}</#if>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="row">
    <div class="col-md-12">
        <div class="portlet box blue">
            <div class="portlet-title">
                <div class="caption">
                    企服填写信息
                </div>
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#blue1" data-toggle="tab" aria-expanded="true">公司介绍</a>
                    </li>
                    <li class="">
                        <a href="#blue2" data-toggle="tab" aria-expanded="false">政府专项（高企）业务核心指标概况</a>
                    </li>
                    <li class="">
                        <a href="#blue3" data-toggle="tab" aria-expanded="false">财税数据</a>
                    </li>
                    <li class="">
                        <a href="#blue4" data-toggle="tab" aria-expanded="false">标签</a>
                    </li>
                    <li class="">
                        <a href="#blue5" data-toggle="tab" aria-expanded="false">公司人员结构</a>
                    </li>
                    <li class="">
                        <a href="#blue6" data-toggle="tab" aria-expanded="false">核心团队</a>
                    </li>
                    <li class="">
                        <a href="#blue7" data-toggle="tab" aria-expanded="false">公司联系人</a>
                    </li>
                    <li class="">
                        <a href="#blue8" data-toggle="tab" aria-expanded="false">资质荣誉</a>
                    </li>
                    <li class="">
                        <a href="#blue9" data-toggle="tab" aria-expanded="false">市场发展情况</a>
                    </li>
                    <li class="">
                        <a href="#blue10" data-toggle="tab" aria-expanded="false">上市情况</a>
                    </li>
                    <li class="">
                        <a href="#blue11" data-toggle="tab" aria-expanded="false">归属载体</a>
                    </li>
                    <li class="">
                        <a href="#blue12" data-toggle="tab" aria-expanded="false">大赛项目资料</a>
                    </li>
                    <li class="">
                        <a href="#blue13" data-toggle="tab" aria-expanded="false">企业相关文件</a>
                    </li>
                </ul>
            </div>
            <div class="portlet-body">
                <div class="tab-content">
                    <div class="tab-pane" id="blue13">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>企业相关文件
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <form id="formSsqk" action="/crm/enterprisedetail/ssqkEdit" method="post">
                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                               value="${resultBaseInfo.regNo}" </#if>/>
                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                        <table class="table table-striped table-hover table-bordered">
                                            <thead>
                                            <tr>
                                                <th>
                                                    文件标题
                                                </th>
                                                <th>
                                                    文件名
                                                </th>
                                                <th>
                                                    上传时间
                                                </th>
                                                <th>
                                                    操作人
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody id="fileTbody">
                                            <#list cdmEntDtoFiles as item>
                                            <tr>
                                                <td>${item.fileTitle}</td>
                                                <td><a href='/file/downloadEnterpriseFile?fileName=${item.fileName}'> ${item.fileName}</a>
                                                </td>
                                                <td>${(item.updateTime?string("yyyy-MM-dd HH:mm:ss"))}</td>
                                                <td>${item.operator}</td>
                                            </tr>
                                            </#list>
                                            </tbody>

                                            <tfoot>

                                            <tr>
                                                <td>
                                                    <input type="text" id="fileTitle">
                                                </td>
                                                <td><input type="text" readonly id="showreturnName"></td>
                                                <td>
                                                    <input type="file" name="file" id="uploadfilename"/>
                                                    <input type="button" id="updo" value="上传"/>
                                                </td>
                                                <td><input type="button" value="保存" id="saveEnterpriseFileName"></td>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="blue12">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>大赛项目资料
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-bordered" id="table_mate">
                                        <thead>
                                        <th>
                                            项目名称
                                        </th>
                                        <th>
                                            项目简介
                                        </th>
                                        <th>
                                            项目所属行业
                                        </th>
                                        <th>
                                            点评人
                                        </th>
                                        <th>
                                            点评内容
                                        </th>
                                        <th>
                                            BP年份
                                        </th>
                                        <th>
                                        </th>
                                        </thead>
                                        <tbody>
                                        <#if resultProj??>
                                            <#list resultProj as proj>
                                            <tr>
                                                <td>
                                                    <#if proj.projectName??>${proj.projectName}</#if>
                                                </td>
                                                <td>
                                                    <#if proj.projectDesc??>${proj.projectDesc}</#if>
                                                </td>
                                                <td>
                                                    <#if proj.industry??>${proj.industry}</#if>
                                                </td>
                                                <td>
                                                    <#if proj.commentPerson??>${proj.commentPerson}</#if>
                                                </td>
                                                <td>
                                                    <#if proj.commentRemark??>${proj.commentRemark}</#if>
                                                </td>
                                                <td>
                                                    <#if proj.bpYear??>${proj.bpYear}</#if>
                                                </td>
                                                <td>
                                                    <a href="">下载BP资料</a>&nbsp;&nbsp;
                                                    <input type="hidden" name="bpMeta" id="bpMeta"/>
                                                    <input type="button" onclick="openUpload()" value="上传BP资料"/>
                                                </td>
                                            </#list>
                                        </tr>
                                        </#if>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="blue11">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>归属载体
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <form id="formGszt" action="/crm/enterprisedetail/gsztEdit" method="post">
                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                               value="${resultBaseInfo.regNo}" </#if>/>
                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                        <table class="table table-striped table-hover table-bordered">
                                            <thead>
                                            <tr>
                                                <th>
                                                    载体类型
                                                </th>
                                                <th>
                                                    载体名称
                                                </th>
                                                <th>
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td width="20%">
                                                <#if resultCarrier??>
                                                    <#if (resultCarrier.carrierName)?length gt 0>
                                                        <select id="carrierType" name="carrierType" class="form-control input-medium select2me">
                                                            <option <#if (resultCarrier.carrierType) == "园区"> selected="selected" </#if>>园区
                                                            </option>
                                                            <option <#if (resultCarrier.carrierType) == "孵化器"> selected="selected" </#if>>孵化器
                                                            </option>
                                                            <option <#if (resultCarrier.carrierType) == "众创空间"> selected="selected" </#if>>
                                                                众创空间
                                                            </option>
                                                        </select>
                                                    <#else>
                                                        <select id="carrierType" name="carrierType" class="bs-select form-control"
                                                                data-placeholder="请选择">
                                                            <option value="" disabled selected hidden>Please Choose</option>
                                                            <option>园区</option>
                                                            <option>孵化器</option>
                                                            <option>众创空间</option>
                                                        </select>
                                                    </#if>
                                                <#else>
                                                    <select id="carrierType" name="carrierType" class="bs-select form-control"
                                                            data-placeholder="请选择">
                                                        <option value="" disabled selected hidden>Please Choose</option>
                                                        <option>园区</option>
                                                        <option>孵化器</option>
                                                        <option>众创空间</option>
                                                    </select>
                                                </#if>
                                                </td>
                                                <td width="70%">
                                                    <input id="carrierName" name="carrierName" type="text" placeholder="30字以内"
                                                           class="form-control input-medium" <#if (resultCarrier.carrierName)??>
                                                           value="${resultCarrier.carrierName}" <#else> value="" </#if>/>
                                                </td>
                                                <td width="5%">
                                                    <input type="button" value="保存" id="save_gszt" onclick="clicksave(this)"/>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="blue10">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>上市情况
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <form id="formSsqk" action="/crm/enterprisedetail/ssqkEdit" method="post">
                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                               value="${resultBaseInfo.regNo}" </#if>/>
                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                        <table class="table table-striped table-hover table-bordered">
                                            <thead>
                                            <tr>
                                                <th>
                                                    上市进程
                                                </th>
                                                <th>
                                                    拟上市时间
                                                </th>
                                                <th>
                                                    拟挂牌板块
                                                </th>
                                                <th>
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>
                                                    <input id="ipoStage" name="ipoStage" type="text" placeholder="30字以内"
                                                           class="form-control input-medium" <#if (resultIpo.ipoStage)??>
                                                           value="${resultIpo.ipoStage}" <#else> value="" </#if>/>
                                                </td>
                                                <td>
                                                    <input readonly="readonly" id="ipoDate" name="ipoDate" type="text" class="laydate-icon"
                                                           style="width:200px; margin-right:10px;" <#if (resultIpo.ipoDate)??>
                                                           value="${resultIpo.ipoDate}" <#else> value="" </#if>/>
                                                    <!--<input id="ipoDate" name="ipoDate" type="text" class="form-control input-medium" <#if (resultIpo.ipoDate)??> value = "${resultIpo.ipoDate}" <#else> value = "" </#if> />-->
                                                </td>
                                                <td>
                                                    <input id="ipoSector" name="ipoSector" type="text" placeholder="30字以内"
                                                           class="form-control input-medium" <#if (resultIpo.ipoSector)??>
                                                           value="${resultIpo.ipoSector}" <#else> value="" </#if>/>
                                                </td>
                                                <td width="5%">
                                                    <input type="button" value="保存" id="save_ssqk" onclick="clicksave(this)"/>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="blue9">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>市场发展情况
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <form id="formScfz" action="/crm/enterprisedetail/scfzEdit" method="post">
                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                               value="${resultBaseInfo.regNo}" </#if>/>
                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                        <table class="table table-striped table-hover table-bordered">
                                            <tbody>
                                            <tr>
                                                <td width="20%">
                                                    产品与业务概况
                                                </td>
                                                <td width="80%">
                            <textarea name="prodBizSubmit" id="prodBizSubmit" placeholder="300字以内" class="form-control"
                                      rows="5"
                                      placeholder="主要描述企业主要从事的产品与服务，从创新性、规模化等角度阐述企业商业模式和竞争性。"><#if (resultMarketDev.prodBizSubmit)??>${resultMarketDev.prodBizSubmit}</#if></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="20%">
                                                    信息化现状与需求
                                                </td>
                                                <td width="80%">
                            <textarea name="curReqInfo" id="curReqInfo" placeholder="300字以内" class="form-control"
                                      rows="5"
                                      placeholder="主要描述企业目前基础网络环境，各类信息化工具应用情况；企业信息化及上云需求，尽量详细描述企业的具体需求及目前开展进度。"><#if (resultMarketDev.curReqInfo)??>${resultMarketDev.curReqInfo}</#if></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="20%">
                                                    企业信息化建议
                                                </td>
                                                <td width="80%">
                            <textarea name="infoSuggestions" id="infoSuggestions" placeholder="300字以内"
                                      class="form-control" rows="5"
                                      placeholder="根据企业业务、规模及信息化现状，从上云的高性能、便捷性、低成本角度提出企业上云配置；基于企业信息化需求，对企业应用SAAS服务或采购软件给予建议。"><#if (resultMarketDev.infoSuggestions)??>${resultMarketDev.infoSuggestions}</#if></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="20%">
                                                    发展阶段
                                                </td>
                                                <td width="80%">
                                                    <input id="devStage" name="devStage" type="text" class="form-control input-medium"
                                                           placeholder="初创期；成长期；成熟期" <#if (resultMarketDev.devStage)??>
                                                           value="${resultMarketDev.devStage}" <#else> value="" </#if>/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="20%">
                                                    商业模式
                                                </td>
                                                <td width="80%">
                            <textarea name="businessPattern" id="businessPattern" placeholder="300字以内"
                                      class="form-control"
                                      rows="5"><#if (resultMarketDev.businessPattern)??>${resultMarketDev.businessPattern}</#if></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="20%">
                                                    核心竞争力
                                                </td>
                                                <td width="80%">
                            <textarea name="coreCompetence" id="coreCompetence" placeholder="300字以内"
                                      class="form-control"
                                      rows="5"><#if (resultMarketDev.coreCompetence)??>${resultMarketDev.coreCompetence}</#if></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="20%">
                                                    前五大客户
                                                </td>
                                                <td width="80%">
                            <textarea name="fiveCustomer" id="fiveCustomer" placeholder="200字以内"
                                      class="form-control"><#if (resultMarketDev.fiveCustomer)??>${resultMarketDev.fiveCustomer}</#if></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="20%">
                                                    前五大供应商
                                                </td>
                                                <td width="80%">
                            <textarea name="fiveSupplier" id="fiveSupplier" placeholder="200字以内"
                                      class="form-control"><#if (resultMarketDev.fiveSupplier)??>${resultMarketDev.fiveSupplier}</#if></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="20%">
                                                    主要竞争对手
                                                </td>
                                                <td width="80%">
                            <textarea name="majorCompetitors" id="majorCompetitors" placeholder="200字以内"
                                      class="form-control"><#if (resultMarketDev.majorCompetitors)??>${resultMarketDev.majorCompetitors}</#if></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="20%">
                                                    市场占有率
                                                </td>
                                                <td width="80%">
                                                    <input id="marketRate" name="marketRate" type="text"
                                                           class="form-control input-small" <#if (resultMarketDev.marketRate)??>
                                                           value="${resultMarketDev.marketRate}" <#else> value="" </#if>/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" align="center"><input type="button" value="保存" id="save_scfz"
                                                                                      onclick="clicksave(this)"/></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="blue8">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>资质荣誉
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <form id="formZzry" action="/crm/enterprisedetail/zzryEdit" method="post">
                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                               value="${resultBaseInfo.regNo}" </#if>/>
                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                        <input name="qualification" id="qualification" type="hidden" <#if (honor.qualification)??>
                                               value="${honor.qualification}" </#if>/>
                                        <input name="honor" id="honor" type="hidden" <#if (honor.honor)??> value="${honor.honor}" </#if>/>
                                    </form>
                                    <form id="zzryFormDelete" action="/crm/enterprisedetail/zzryDelete" method="post">
                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                               value="${resultBaseInfo.regNo}" </#if>/>
                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                        <input name="recId" id="recId3" type="hidden" <#if (honor.recId)??> value="${honor.recId}" </#if>/>
                                    </form>
                                    <table class="table table-striped table-hover table-bordered" id="table_zzry">
                                        <thead>
                                        <tr>
                                            <td colspan="6" align="right">
                                                <button id="zzry_new">新增行</i>
                                                </button>
                                            </td>
                                        </tr>
                                        <th>
                                            资质
                                        </th>
                                        <th>
                                            荣誉
                                        </th>
                                        <th>
                                        </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#if resultHonor??>
                                            <#list resultHonor as honor>
                                            <tr>
                                                <td>
                                                ${honor.qualification}
                                                </td>
                                                <td>
                                                ${honor.honor}
                                                </td>
                                                <td>
                                                    <a href="#" id="${honor.recId?if_exists}" onclick="zzryClickDelete(this)"><span
                                                            class="glyphicon glyphicon-remove" title="删除记录"></span></a>
                                                </td>
                                            </tr>
                                            </#list>
                                        </#if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="blue7">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>公司联系人
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <form id="formGslxr" action="/crm/enterprisedetail/gslxrEdit" method="post">
                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                               value="${resultBaseInfo.regNo}" </#if>/>
                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                        <input name="name" id="name2" type="hidden" <#if (contacts.name)??> value="${contacts.name}" </#if>/>
                                        <input name="jobTitle" id="jobTile2" type="hidden" <#if (contacts.jobTitle)??>
                                               value="${contacts.jobTitle}" </#if>/>
                                        <input name="contactMobiPhone" id="contactMobiPhone" type="hidden" <#if (contacts.contactMobiPhone)??>
                                               value="${contacts.contactMobiPhone}" </#if>/>
                                        <input name="contactFixedPhone" id="contactFixedPhone"
                                               type="hidden" <#if (contacts.contactFixedPhone)??> value="${contacts.contactFixedPhone}" </#if>/>
                                        <input name="email" id="email" type="hidden" <#if (contacts.email)??> value="${contacts.email}" </#if>/>
                                    </form>
                                    <form id="gslxrFormDelete" action="/crm/enterprisedetail/gslxrDelete" method="post">
                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                               value="${resultBaseInfo.regNo}" </#if>/>
                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                        <input name="name" id="ctcname" type="hidden" <#if (contacts.name)??> value="${contacts.name}" </#if>/>
                                    </form>
                                    <table class="table table-striped table-hover table-bordered" id="table_gslxr">
                                        <thead>
                                        <tr>
                                            <td colspan="6" align="right">
                                                <button id="gslxr_new">新增行</i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>
                                                姓名
                                            </th>
                                            <th>
                                                职位
                                            </th>
                                            <th>
                                                手机
                                            </th>
                                            <th>
                                                固话
                                            </th>
                                            <th>
                                                Email
                                            </th>
                                            <th>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#if resultContacts??>
                                            <#list resultContacts as contacts>
                                            <tr>
                                                <td>
                                                    <#if (contacts.name)??>${contacts.name}</#if>
                                                </td>
                                                <td>
                                                    <#if (contacts.jobTitle)??>${contacts.jobTitle}</#if>
                                                </td>
                                                <td>
                                                    <#if (contacts.contactMobiPhone)??>${contacts.contactMobiPhone}</#if>
                                                </td>
                                                <td>
                                                    <#if (contacts.contactFixedPhone)??>${contacts.contactFixedPhone}</#if>
                                                </td>
                                                <td>
                                                    <#if (contacts.email)??>${contacts.email}</#if>
                                                </td>
                                                <td>
                                                    <a href="#" id="${contacts.name?if_exists}" onclick="gslxrClickDelete(this)"><span
                                                            class="glyphicon glyphicon-remove" title="删除记录"></span></a>
                                                </td>
                                            </tr>
                                            </#list>
                                        </#if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="blue6">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>核心团队
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <form id="formHxtd" action="/crm/enterprisedetail/hxtdEdit" method="post">
                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                               value="${resultBaseInfo.regNo}" </#if>/>
                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                        <input name="name" id="name" type="hidden" <#if (coreTeam.name)??> value="${coreTeam.name}" </#if>/>
                                        <input name="sex" id="sex" type="hidden" <#if (coreTeam.sex)??> value="${coreTeam.sex}" </#if>/>
                                        <input name="jobTitle" id="jobTitle" type="hidden" <#if (coreTeam.jobTitle)??>
                                               value="${coreTeam.jobTitle}" </#if>/>
                                        <input name="education" id="education" type="hidden" <#if (coreTeam.education)??>
                                               value="${coreTeam.education}" </#if>/>
                                        <input name="resume" id="resume" type="hidden" <#if (coreTeam.resume)??>
                                               value="${coreTeam.resume}" </#if>/>
                                    </form>
                                    <form id="hxtdFormDelete" action="/crm/enterprisedetail/hxtdDelete" method="post">
                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                               value="${resultBaseInfo.regNo}" </#if>/>
                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                        <input name="recId" id="recId" type="hidden" <#if (coreTeam.recId)??> value="${coreTeam.recId}" </#if>/>
                                    </form>
                                    <table class="table table-striped table-hover table-bordered" id="table_hxtd">
                                        <thead>
                                        <tr>
                                            <td colspan="6" align="right">
                                                <button id="hxtd_new">新增行</i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>
                                                姓名
                                            </th>
                                            <th>
                                                性别
                                            </th>
                                            <th>
                                                职务
                                            </th>
                                            <th>
                                                学历
                                            </th>
                                            <th>
                                                工作/创业履历
                                            </th>
                                            <th>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#if resultCoreTeam??>
                                            <#list resultCoreTeam as coreTeam>
                                            <tr>
                                                <td>
                                                ${coreTeam.name}
                                                </td>
                                                <td>
                                                ${coreTeam.sex}
                                                </td>
                                                <td>
                                                ${coreTeam.jobTitle}
                                                </td>
                                                <td>
                                                ${coreTeam.education}
                                                </td>
                                                <td>
                                                ${coreTeam.resume}
                                                </td>
                                                <td>
                                                    <a href="#" id="${coreTeam.recId?if_exists}" onclick="hxtdClickDelete(this)"><span
                                                            class="glyphicon glyphicon-remove" title="删除记录"></span></a>
                                                </td>
                                            </tr>
                                            </#list>
                                        </#if>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="blue5">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>公司人员结构
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <form id="formGsryjg" action="/crm/enterprisedetail/gsryjgEdit" method="post">
                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                               value="${resultBaseInfo.regNo}" </#if>/>
                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                        <table class="table table-striped table-hover table-bordered">
                                            <thead>
                                            <tr>
                                                <th>
                                                    公司总人数（人）
                                                </th>
                                                <th>
                                                    大专以上人员占比（%）
                                                </th>
                                                <th>
                                                    本科以上人员占比（%）
                                                </th>
                                                <th>
                                                    硕士以上人员占比（%）
                                                </th>
                                                <th>
                                                    从事研发人数（人）
                                                </th>
                                                <th>
                                                    操作
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>
                                                    <input id="staffNumber" name="staffNumber" type="text"
                                                           class="form-control input-small" <#if (resultEmpStruc.staffNumber)??>
                                                           value="${resultEmpStruc.staffNumber}" <#else> value="" </#if>/>
                                                </td>
                                                <td>
                                                    <input id="collegeRate" name="collegeRate" type="text"
                                                           class="form-control input-small" <#if (resultEmpStruc.collegeRate)??>
                                                           value="${resultEmpStruc.collegeRate}" <#else> value="" </#if>/>
                                                </td>
                                                <td>
                                                    <input id="undergraduateRate" name="undergraduateRate" type="text"
                                                           class="form-control input-small" <#if (resultEmpStruc.undergraduateRate)??>
                                                           value="${resultEmpStruc.undergraduateRate}" <#else> value="" </#if>/>
                                                </td>
                                                <td>
                                                    <input id="masterRate" name="masterRate" type="text"
                                                           class="form-control input-small" <#if (resultEmpStruc.masterRate)??>
                                                           value="${resultEmpStruc.masterRate}" <#else> value="" </#if>/>
                                                </td>
                                                <td>
                                                    <input id="rdNumber" name="rdNumber" type="text"
                                                           class="form-control input-small" <#if (resultEmpStruc.rdNumber)??>
                                                           value="${resultEmpStruc.rdNumber}" <#else> value="" </#if>/>
                                                </td>
                                                <td width="5%">
                                                    <input type="button" value="保存" id="save_gsryjg" onclick="clicksave(this)"/>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="blue4">
                        <div class="portlet box blue-dark">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>标签
                                </div>
                            </div>
                            <div class="portlet-body">
                            <#if (resultBaseInfo.tagArray)??>
                                <#if enterpriseTagList??>
                                    <#list enterpriseTagList as enttag>
                                        <#if resultBaseInfo.tagArray?contains(enttag.assetsTagCode)> <span
                                                class="icon-tag">&nbsp;${enttag.assetsTagDesc}&nbsp;&nbsp;</span></#if>
                                    </#list>
                                </#if>
                            </#if>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="blue3">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>财税数据
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="tabbable tabbable-custom">
                                    <ul class="nav nav-tabs">
                                        <li class="active">
                                            <a href="#fin_tab_3" data-toggle="tab">
                                                信隆行走访采集（万人民币） </a>
                                        </li>
                                        <li>
                                            <a href="#fin_tab_2" data-toggle="tab">
                                                科技贷款系统（万人民币）</a>
                                        </li>
                                        <li>
                                            <a href="#fin_tab_4" data-toggle="tab">
                                                创赛公司上报（万人民币）</a>
                                        </li>
                                        <li>
                                            <a href="#fin_tab_5" data-toggle="tab">
                                                融资企业上报（万人民币）</a>
                                        </li>
                                        <li>
                                            <a href="#fin_tab_1" data-toggle="tab">
                                                国家税务局（万人民币）</a>
                                        </li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="fin_tab_3">
                                            <div class="portlet-body">
                                                <div class="table-responsive">
                                                    <form id="formZfcw" action="/crm/enterprisedetail/zfcwEdit" method="post">
                                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                                               value="${resultBaseInfo.regNo}" </#if>/>
                                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                                        <input name="regCreditNo" id="regCreditNo"
                                                               type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                                        <input name="enterpriseName" id="enterpriseName"
                                                               type="hidden" <#if (resultBaseInfo.enterpriseName)??>
                                                               value="${resultBaseInfo.enterpriseName}" </#if>/>
                                                        <input name="finYear" id="finYear" type="hidden" <#if (findata.finYear)??>
                                                               value="${findata.finYear}" </#if>/>
                                                        <input name="operatingIncome" id="operatingIncome"
                                                               type="hidden" <#if (findata.operatingIncome)??>
                                                               value="${findata.operatingIncome}" </#if>/>
                                                        <input name="netProfit" id="netProfit" type="hidden" <#if (findata.netProfit)??>
                                                               value="${findata.netProfit}" </#if>/>
                                                        <input name="totalAssets" id="totalAssets" type="hidden" <#if (findata.totalAssets)??>
                                                               value="${findata.totalAssets}" </#if>/>

                                                        <input name="netAssets" id="netAssets" type="hidden" <#if (findata.totalAssets)??>
                                                               value="${findata.totalAssets}" </#if>/>
                                                        <input name="amtUnit" id="amtUnit" type="hidden" value="万人民币"/>
                                                        <input name="finSourceType" id="finSourceType" type="hidden" value="3"/>
                                                    </form>
                                                    <form id="zfcwFormDelete" action="/crm/enterprisedetail/zfcwDelete" method="post">
                                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                                               value="${resultBaseInfo.regNo}" </#if>/>
                                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                                        <input name="regCreditNo" id="regCreditNo"
                                                               type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                                        <input name="recId" id="recId4" type="hidden" <#if (findata.recId)??>
                                                               value="${findata.recId}" </#if>/>
                                                    </form>
                                                    <table class="table table-striped table-hover table-bordered" id="table_zfcw">
                                                        <thead>
                                                        <td colspan="6" align="right">
                                                            <button id="zfcw_new">新增行</i>
                                                            </button>
                                                        </td>
                                                        <tr>
                                                            <th>
                                                                年份（要求YYYY-MM-DD格式）
                                                            </th>
                                                            <th>
                                                                营业收入（万元）
                                                            </th>
                                                            <th>
                                                                净利润（万元）
                                                            </th>
                                                            <th>
                                                                总资产（万元）
                                                            </th>
                                                            <th>
                                                                净资产（万元）
                                                            </th>
                                                            <th>
                                                            </th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <#if resultFindata??>
                                                            <#list resultFindata as findata>
                                                                <#if findata.finSourceType == '3'>
                                                                <tr>
                                                                    <td>
                                                                        <#if findata.finYear??>${findata.finYear}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.operatingIncome??>${findata.operatingIncome}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.netProfit??>${findata.netProfit}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.totalAssets??>${findata.totalAssets}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.netAssets??>${findata.netAssets}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <a href="#" id="${findata.recId?if_exists}"
                                                                           onclick="zfcwClickDelete(this)"><span
                                                                                class="glyphicon glyphicon-remove" title="删除记录"></span></a>
                                                                    </td>
                                                                </tr>
                                                                </#if>
                                                            </#list>
                                                        </#if>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="tab-pane" id="fin_tab_2">
                                            <div class="portlet-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-hover table-bordered">
                                                        <thead>
                                                        <tr>
                                                            <th>
                                                                年份
                                                            </th>
                                                            <th>
                                                                营业收入（万元）
                                                            </th>
                                                            <th>
                                                                净利润（万元）
                                                            </th>
                                                            <th>
                                                                总资产（万元）
                                                            </th>
                                                            <th>
                                                                净资产（万元）
                                                            </th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <#if resultFindata??>
                                                            <#list resultFindata as findata>
                                                                <#if findata.finSourceType == '2'>
                                                                <tr>
                                                                    <td>
                                                                        <#if findata.finYear??>${findata.finYear}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.operatingIncome??>${findata.operatingIncome}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.netProfit??>${findata.netProfit}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.totalAssets??>${findata.totalAssets}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.netAssets??>${findata.netAssets}</#if>
                                                                    </td>
                                                                </tr>
                                                                </#if>
                                                            </#list>
                                                        </#if>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="tab-pane" id="fin_tab_4">
                                            <div class="portlet-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-hover table-bordered">
                                                        <thead>
                                                        <tr>
                                                            <th>
                                                                年份
                                                            </th>
                                                            <th>
                                                                营业收入（万元）
                                                            </th>
                                                            <th>
                                                                净利润（万元）
                                                            </th>
                                                            <th>
                                                                总资产（万元）
                                                            </th>
                                                            <th>
                                                                净资产（万元）
                                                            </th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <#if resultFindata??>
                                                            <#list resultFindata as findata>
                                                                <#if findata.finSourceType == '4'>
                                                                <tr>
                                                                    <td>
                                                                        <#if findata.finYear??>${findata.finYear}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.operatingIncome??>${findata.operatingIncome}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.netProfit??>${findata.netProfit}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.totalAssets??>${findata.totalAssets}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.netAssets??>${findata.netAssets}</#if>
                                                                    </td>
                                                                </tr>
                                                                </#if>
                                                            </#list>
                                                        </#if>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="tab-pane" id="fin_tab_5">
                                            <div class="portlet-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-hover table-bordered">
                                                        <thead>
                                                        <tr>
                                                            <th>
                                                                年份
                                                            </th>
                                                            <th>
                                                                营业收入（万元）
                                                            </th>
                                                            <th>
                                                                净利润（万元）
                                                            </th>
                                                            <th>
                                                                总资产（万元）
                                                            </th>
                                                            <th>
                                                                净资产（万元）
                                                            </th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <#if resultFindata??>
                                                            <#list resultFindata as findata>
                                                                <#if findata.finSourceType == '5'>
                                                                <tr>
                                                                    <td>
                                                                        <#if findata.finYear??>${findata.finYear}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.operatingIncome??>${findata.operatingIncome}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.netProfit??>${findata.netProfit}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.totalAssets??>${findata.totalAssets}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.netAssets??>${findata.netAssets}</#if>
                                                                    </td>
                                                                </tr>
                                                                </#if>
                                                            </#list>
                                                        </#if>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="tab-pane" id="fin_tab_1">
                                            <div class="portlet-body">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-hover table-bordered">
                                                        <thead>
                                                        <tr>
                                                            <th>
                                                                年份
                                                            </th>
                                                            <th>
                                                                营业收入（万元）
                                                            </th>
                                                            <th>
                                                                净利润（万元）
                                                            </th>
                                                            <th>
                                                                总资产（万元）
                                                            </th>
                                                            <th>
                                                                净资产（万元）
                                                            </th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <#if resultFindata??>
                                                            <#list resultFindata as findata>
                                                                <#if findata.finSourceType == '1'>
                                                                <tr>
                                                                    <td>
                                                                        <#if findata.finYear??>${findata.finYear}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.operatingIncome??>${findata.operatingIncome}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.netProfit??>${findata.netProfit}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.totalAssets??>${findata.totalAssets}</#if>
                                                                    </td>
                                                                    <td>
                                                                        <#if findata.netAssets??>${findata.netAssets}</#if>
                                                                    </td>
                                                                </tr>
                                                                </#if>
                                                            </#list>
                                                        </#if>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <!-- 先不展示：为企业评分雷达图准备一个具备大小（宽高）的Dom
                            <#if resultFindata??>
                            <div id="finchat" style="width:400px; height:250px;margin: 10px auto;"></div>
                            </#if>
                            -->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="blue2">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>政府专项（高企）业务核心指标概况
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-bordered" id="high_tech_table">
                                        <tbody>
                                        <tr>
                                            <td>是否高新技术企业</td>
                                            <td>
                                                <select id="is_high_tech">
                                                    <option></option>
                                                    <option value="1">是</option>
                                                    <option value="2">否</option>
                                                </select>
                                            </td>
                                            <td class="identityYear">
                                                认定年份
                                            </td>
                                            <td class="identityYear">
                                                <input readonly="readonly" id="identify_time" name="identify_time" type="text"
                                                       class="laydate-icon" style="width:200px; margin-right:10px;" value=""/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>是否正在申请高新技术企业</td>
                                            <td>
                                                <select id="is_applying">
                                                    <option></option>
                                                    <option value="1">是</option>
                                                    <option value="2">否</option>
                                                </select>
                                            </td>
                                            <td class="apply_y">申报方式</td>
                                            <td class="apply_y">
                                                <select id="apply_type">
                                                    <option></option>
                                                    <option value="1">自行申报</option>
                                                    <option value="2">代理申报</option>
                                                </select>
                                            </td>
                                            <td class="apply_n">是否有申请意向</td>
                                            <td class="apply_n">
                                                <select id="has_apply_will">
                                                    <option></option>
                                                    <option value="1">是</option>
                                                    <option value="2">否</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>近三年是否拥有知识产权</td>
                                            <td>
                                                <select id="has_intellectual_property">
                                                    <option></option>
                                                    <option value="1">是</option>
                                                    <option value="2">否</option>
                                                </select>
                                            </td>
                                            <td class="property">知识产权数量</td>
                                            <td class="property">
                                                <input type="number" id="intellectual_property_num">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>研发人员比例</td>
                                            <td colspan="3">
                                                <input type="text" id="research_rate"><label>%</label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>最近年度或本年度研发费用规模</td>
                                            <td colspan="3">
                                                <table class="table table-striped table-hover table-bordered">
                                                    <thead>
                                                    <tr>
                                                        <th>日期</th>
                                                        <th>金额</th>
                                                        <th>删除</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody id="income_scale_tbody">
                                                    </tbody>
                                                    <tr>
                                                        <td><input type="text" id="income_year_add"></td>
                                                        <td><input type="text" id="income_amount_add"></td>
                                                        <td><input type="button" value="添加" id="income_add_btn">（保存后生效）</td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>研发费用是否独立归集</td>
                                            <td>
                                                <select id="independent_imputation">
                                                    <option></option>
                                                    <option value="1">是</option>
                                                    <option value="2">否</option>
                                                </select>
                                            </td>
                                            <td>研发费用是否申请研发费用加计扣除</td>
                                            <td>
                                                <select id="apply_fee_deduction">
                                                    <option></option>
                                                    <option value="1">是</option>
                                                    <option value="2">否</option>
                                                </select>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>纳税方式</td>
                                            <td>
                                                <select id="tax_type">
                                                    <option></option>
                                                    <option value="1">查账征收</option>
                                                    <option value="2">非查账征收</option>
                                                </select>
                                            </td>
                                            <td>近三年（含今年）销售收入变动情况</td>
                                            <td>
                                                <select id="income_change">
                                                    <option></option>
                                                    <option value="1">逐年递增</option>
                                                    <option value="2">逐年递减</option>
                                                    <option value="3">波动</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>企业历史申报政府专项情况</td>
                                            <td colspan="3">
                                                <table class="table table-striped table-hover table-bordered">
                                                    <thead>
                                                    <tr>
                                                        <th>年份</th>
                                                        <th>专项资金名称</th>
                                                        <th>项目名称</th>
                                                        <th>项目执行开始</th>
                                                        <th>项目执行结束</th>
                                                        <th>是否立项</th>
                                                        <th>是否验收</th>
                                                        <th>删除</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody id="hisdeclare_scale_tbody">
                                                    </tbody>
                                                    <tr>
                                                        <td><input type="text" id="hisdeclare_year_add" style="width: 40px;"></td>
                                                        <td><input type="text" id="hisdeclare_capital_name_add" style="width: 100px;"></td>
                                                        <td><input type="text" id="hisdeclare_project_name_add" style="width: 100px;"></td>
                                                        <td><input type="text" id="hisdeclare_imp_begin_time_add" style="width: 100px;"></td>
                                                        <td><input type="text" id="hisdeclare_imp_end_time_add" style="width: 100px;"></td>
                                                        <td>
                                                            <select id="hisdeclare_is_setup_add" noevent="Y">
                                                                <option value="是">是</option>
                                                                <option value="否">否</option>
                                                            </select>
                                                        </td>
                                                        <td>
                                                            <select id="hisdeclare_is_checkup_add" noevent="Y">
                                                                <option value="是">是</option>
                                                                <option value="否">否</option>
                                                            </select>
                                                        </td>
                                                        <td><input type="button" value="添加" id="hisdeclare_add_btn">（保存后生效）</td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>企业申报政府专项（高企）需求</td>
                                            <td>
                                                <select id="has_demand">
                                                    <option></option>
                                                    <option value="1">是</option>
                                                    <option value="2">否</option>
                                                </select>
                                            </td>
                                        </tr>

                                        <tr id="demand_yes" style="display: none;">
                                            <td>服务类别</td>
                                            <td>
                                                <label>政府专项</label>
                                                <input type="checkbox" id="check_gov_special">
                                                <label>高企</label>
                                                <input type="checkbox" id="check_high_tech">
                                            </td>
                                            <td class="c_policiy_name"><span class="required">* </span>政策名称</td>
                                            <td class="c_policiy_name"><input type="text" id="policy_name"></td>
                                        </tr>
                                        <tr>
                                            <td>其他重要内容（300字）</td>
                                            <td colspan="3">
                                                <textarea id="other_info" cols="50" rows="15"></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="4" align="center"><input type="button" value="保存" id="high_tech_submit"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane active" id="blue1">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>公司介绍
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div>
                                    <form id="formGsjs" action="/crm/enterprisedetail/gsjsEdit" method="post">
                                        <input name="regNo" id="regNo" type="hidden" <#if (resultBaseInfo.regNo)??>
                                               value="${resultBaseInfo.regNo}" </#if>/>
                                        <input name="creditNo" id="creditNo" type="hidden" <#if (resultBaseInfo.creditNo)??>
                                               value="${resultBaseInfo.creditNo}" </#if>/>
                                        <input name="regCreditNo" id="regCreditNo" type="hidden" <#if (resultBaseInfo.regCreditNo)??>
                                               value="${resultBaseInfo.regCreditNo}" </#if>/>
                                        <table class="table table-striped table-hover table-bordered">
                                            <tbody>
                                            <tr>
                                                <td width="15%">
                                                    行业领域
                                                </td>
                                                <td width="85%">
                                                    <select name="mainIndustry" id="mainIndustry">
                                                        <option>请选择</option>
                                                        <option value="电子信息" <#if resultBaseInfo??&&resultBaseInfo.mainIndustry??&&resultBaseInfo.mainIndustry=="电子信息">
                                                                selected </#if>/>
                                                        电子信息</option>
                                                        <option value="生物与新医药" <#if resultBaseInfo??&&resultBaseInfo.mainIndustry??&&resultBaseInfo.mainIndustry=="生物与新医药">
                                                                selected </#if>/>
                                                        生物与新医药</option>
                                                        <option value="航空航天" <#if resultBaseInfo??&&resultBaseInfo.mainIndustry??&&resultBaseInfo.mainIndustry=="航空航天">
                                                                selected </#if>/>
                                                        航空航天</option>
                                                        <option value="新材料" <#if resultBaseInfo??&&resultBaseInfo.mainIndustry??&&resultBaseInfo.mainIndustry=="新材料">
                                                                selected </#if>/>
                                                        新材料</option>
                                                        <option value="高技术服务" <#if resultBaseInfo??&&resultBaseInfo.mainIndustry??&&resultBaseInfo.mainIndustry=="高技术服务">
                                                                selected </#if>/>
                                                        高技术服务</option>
                                                        <option value="新能源与节能" <#if resultBaseInfo??&&resultBaseInfo.mainIndustry??&&resultBaseInfo.mainIndustry=="新能源与节能">
                                                                selected </#if>/>
                                                        新能源与节能</option>
                                                        <option value="资源与环境" <#if resultBaseInfo??&&resultBaseInfo.mainIndustry??&&resultBaseInfo.mainIndustry=="资源与环境">
                                                                selected </#if>/>
                                                        资源与环境</option>
                                                        <option value="先进制造与自动化" <#if resultBaseInfo??&&resultBaseInfo.mainIndustry??&&resultBaseInfo.mainIndustry=="先进制造与自动化">
                                                                selected </#if>/>
                                                        先进制造与自动化</option>
                                                        <option value="其他高科技领域" <#if resultBaseInfo??&&resultBaseInfo.mainIndustry??&&resultBaseInfo.mainIndustry=="其他高科技领域">
                                                                selected </#if>/>
                                                        其他高科技领域</option>
                                                        <option value="非高新技术领域" <#if resultBaseInfo??&&resultBaseInfo.mainIndustry??&&resultBaseInfo.mainIndustry=="非高新技术领域">
                                                                selected </#if>/>
                                                        非高新技术领域</option>
                                                        <option value="其他" <#if resultBaseInfo??&&resultBaseInfo.mainIndustry??&&resultBaseInfo.mainIndustry=="其他">
                                                                selected </#if>/>
                                                        其他</option>
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="15%">
                                                    公司简介
                                                </td>
                                                <td width="85%">
                            <textarea name="corpInfo" id="corpInfo" placeholder="400字以内" class="form-control"
                                      rows="5"><#if (resultBaseInfo.corpInfo)??>${resultBaseInfo.corpInfo}</#if></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td width="15%">
                                                    主要产品（服务）
                                                </td>
                                                <td width="85%">
                            <textarea name="mainProduct" id="mainProduct" placeholder="400字以内" class="form-control"
                                      rows="5"><#if (resultBaseInfo.mainProduct)??>${resultBaseInfo.mainProduct}</#if></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" align="center"><input type="button" value="保存" id="save_gsjs"
                                                                                      onclick="clicksave(this)"/></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>




<div class="row">
    <div class="col-md-12">
        <div class="portlet box yellow">
            <div class="portlet-title">
                <div class="caption">
                    科技贷系统信息
                </div>
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#yellow1" data-toggle="tab" aria-expanded="true">科技贷企业信息</a>
                    </li>
                    <li class="">
                        <a href="#yellow2" data-toggle="tab" aria-expanded="false">科技贷财务数据</a>
                    </li>

                </ul>
            </div>
            <div class="portlet-body">
                <div class="tab-content">
                    <div class="tab-pane" id="yellow2">
                        <div class="portlet box yellow">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>科技贷财务数据
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-bordered">
                                        <thead>
                                        <tr>
                                            <th>
                                                报表类型
                                            </th>
                                            <th>
                                                所属日期
                                            </th>
                                            <th>
                                                导入时间
                                            </th>
                                            <th>
                                                查看
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody id="fileTbody">
                                        <#list fiDynamicReportApiReqs as item>
                                        <tr>
                                            <td>${item.reportTitle!}</td>
                                            <td>${item.reportDate!}
                                            </td>
                                            <td>${item.insertTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                            <td><a href="/financeinput/dynamicReportDetailShow?reqId=${item.id?c}" target="_blank">查看</a> </td>
                                        </tr>
                                        </#list>
                                        </tbody>

                                    </table>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane active" id="yellow1">
                        <div class="portlet box yellow">
                            <div class="portlet-title">
                                <div class="caption">
                                    <i class="fa fa-picture"></i>科技贷企业信息
                                </div>
                            </div>
                            <div class="portlet-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-hover table-bordered">
                                        <tbody id="fileTbody">
                                        <#if cdmMongodbEnterpriseBaseInfoD??>
                                        <tr>
                                            <td>企业名称</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.enterpriseName!}</td>
                                            <td>统一社会信用代码</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.creditNo!}</td>
                                        </tr>
                                        <tr>
                                            <td>工商注册号</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.regNo!}</td>
                                            <td>组织机构代码</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.orgNo!}</td>
                                        </tr>
                                        <tr>
                                            <td>法定代表人</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.legalRepresentative!}</td>
                                            <td>分公司</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.area!}</td>
                                        </tr>
                                        <tr>
                                            <td>注册时间</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.registerdate!}</td>
                                            <td>注册资本（万）</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.registerCapital!}</td>
                                        </tr>
                                        <tr>
                                            <td>法人手机</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.legalPersonPhone!}</td>
                                            <td>联系人</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.contactPerson!}</td>
                                        </tr>
                                        <tr>
                                            <td>联系人手机</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.contactPhone!}</td>
                                            <td>电子邮箱</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.contactMail!}</td>
                                        </tr>
                                        <tr>
                                            <td>所属行业</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.mainIndustry!}</td>
                                            <td>企业类型</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.enterpriseType!}</td>
                                        </tr>
                                        <tr>
                                            <td>拥有知识产权数</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.equityNum!}</td>
                                            <td>企业规模</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.enterpriseScale!}</td>
                                        </tr>
                                        <tr>
                                            <td>员工总数</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.employeesNum!}</td>
                                            <td>大专以上科技人员数</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.aboveCollegeNum!}</td>
                                        </tr>
                                        <tr>
                                            <td>直接从事研发人员数</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.reseachNum!}</td>
                                            <td>高新技术产品销售收入（万）</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.hightecSales!}</td>
                                        </tr>
                                        <tr>
                                            <td>研发经费投入（万）</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.researchInput!}</td>
                                            <td>贷款申请时间</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.loanTime!}</td>
                                        </tr>
                                        <tr>
                                            <td>贷款申请金额（万）</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.loanAmount!}</td>
                                            <td>贷款申请期限（月）</td>
                                            <td>${cdmMongodbEnterpriseBaseInfoD.loanPeriod!}</td>
                                        </tr>
                                        </#if>
                                        </tbody>

                                    </table>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<input type="hidden" id="other_info_tmp" value="<#if resultHighTech??>${resultHighTech.other_info?default('')}</#if>">
<!-- BEGIN 框架效果 -->
<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<script type="text/javascript" src="/dist/js/demo.js"></script>
<script type="text/javascript" src="/dist/js/crm.js?v=1"></script>
<script src="/dist/js/laydate5.0.7/laydate.js"></script>
<!-- added by yingsl on 20170704 表格编辑功能 -->
<script type="text/javascript" src="/dist/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/dist/js/table-editable-hxtd.js"></script>
<script type="text/javascript" src="/dist/js/table-editable-gslxr.js"></script>
<script type="text/javascript" src="/dist/js/table-editable-zzry.js"></script>
<script type="text/javascript" src="/dist/js/table-editable-zfcw.js"></script>
<script>
    jQuery(document).ready(function () {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        Demo.init(); // init demo features
        TableEditableHxtd.init();   //核心团队
        TableEditableGslxr.init();   //公司联系人
        TableEditableZzry.init();    //资质荣誉
        TableEditableZfcw.init();    //分公司走访采集到的财务数据
    });

    laydate.render({
        elem: '#ipoDate', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
    //年选择器
    laydate.render({
        elem: '#identify_time'
        , type: 'year'
    });
    laydate.render({
        elem: '#income_year_add'
        , type: 'year'
    });
    laydate.render({
        elem: '#hisdeclare_year_add'
        , type: 'year'
    });
    laydate.render({
        elem: '#hisdeclare_imp_begin_time_add'
    });
    laydate.render({
        elem: '#hisdeclare_imp_end_time_add'
    });
</script>
<script>
    var compare = function (x, y) {//比较函数
        if (x.year < y.year) {
            return -1;
        } else if (x.year > y.year) {
            return 1;
        } else {
            return 0;
        }
    }
    var high_tech_obj = {
        credit_no: '${resultBaseInfo.creditNo!""}',
        reg_no: '${resultBaseInfo.regNo?default('')}',
        reg_credit_no: '${resultBaseInfo.regCreditNo?default('')}',
        is_high_tech: '${resultHighTech.is_high_tech?default('')}',
        identify_time: '${resultHighTech.identify_time?default('')}',
        is_applying: '${resultHighTech.is_applying?default('')}',
        apply_type: '${resultHighTech.apply_type?default('')}',
        has_apply_will: '${resultHighTech.has_apply_will?default('')}',
        has_intellectual_property: '${resultHighTech.has_intellectual_property?default('')}',
        intellectual_property_num: '${resultHighTech.intellectual_property_num?default('')}',
        research_rate: '${resultHighTech.research_rate?default('')}',
        independent_imputation: '${resultHighTech.independent_imputation?default('')}',
        apply_fee_deduction: '${resultHighTech.apply_fee_deduction?default('')}',
        tax_type: '${resultHighTech.tax_type?default('')}',
        income_change: '${resultHighTech.income_change?default('')}',
        income_scale: '${resultHighTech.income_scale?default('')}',
        income_scale_obj:${resultHighTech.income_scale?default('[]')},
        hisdeclare_scale: '${resultHighTech.hisdeclare_scale?default('')}',
        hisdeclare_scale_obj:${resultHighTech.hisdeclare_scale?default('[]')},
        has_demand: '${resultHighTech.has_demand?default('')}',
        check_gov_special: '${resultHighTech.check_gov_special?default('')}',
        check_high_tech: '${resultHighTech.check_high_tech?default('')}',
        policy_name: '${resultHighTech.policy_name?default('')}',
        other_info: $("#other_info_tmp").val(),
        del_income_scale: function (year) {
            for (var i = 0; i < this.income_scale_obj.length; i++) {
                var item = this.income_scale_obj[i];
                if (year == item.year) {
                    this.income_scale_obj.splice(i, 1);
                }
            }
        },
        add_income_scale: function (year, amount) {
            for (var i = 0; i < this.income_scale_obj.length; i++) {
                var item = this.income_scale_obj[i];
                if (year == item.year) {
                    return;
                }
            }
            var tmp = {};
            tmp.year = year;
            tmp.amount = amount;
            this.income_scale_obj.push(tmp);
        },
        del_hisdeclare_scale: function (year) {
            for (var i = 0; i < this.hisdeclare_scale_obj.length; i++) {
                var item = this.hisdeclare_scale_obj[i];
                if (year == item.year) {
                    this.hisdeclare_scale_obj.splice(i, 1);
                }
            }
        },
        add_hisdecalre_scale: function (year, capital_name, project_name, imp_begin_time, imp_end_time, is_setup, is_checkup) {
            for (var i = 0; i < this.hisdeclare_scale_obj.length; i++) {
                var item = this.hisdeclare_scale_obj[i];
                if (year == item.year) {
                    return;
                }
            }
            var tmp = {};
            tmp.year = year;
            tmp.capital_name = capital_name;
            tmp.project_name = project_name;
            tmp.imp_begin_time = imp_begin_time;
            tmp.imp_end_time = imp_end_time;
            tmp.is_setup = is_setup;
            tmp.is_checkup = is_checkup;
            this.hisdeclare_scale_obj.push(tmp);
        },
        getParam: function () {
            this.is_high_tech = $("#is_high_tech").val();
            this.identify_time = $("#identify_time").val();
            this.is_applying = $("#is_applying").val();
            this.apply_type = $("#apply_type").val();
            this.has_apply_will = $("#has_apply_will").val();
            this.has_intellectual_property = $("#has_intellectual_property").val();
            this.intellectual_property_num = $("#intellectual_property_num").val();
            this.research_rate = $("#research_rate").val();
            this.independent_imputation = $("#independent_imputation").val();
            this.apply_fee_deduction = $("#apply_fee_deduction").val();
            this.tax_type = $("#tax_type").val();
            this.income_change = $("#income_change").val();
            this.has_demand = $("#has_demand").val();
            if ($("#check_gov_special").prop("checked")) {
                this.check_gov_special = 1;
            } else {
                this.check_gov_special = 0;
            }
            if ($("#check_high_tech").prop("checked")) {
                this.check_high_tech = 1;
            } else {
                this.check_high_tech = 0;
            }
            this.policy_name = $("#policy_name").val();
            if (this.has_demand != 1) {
                this.check_gov_special = 0;
                this.check_high_tech = 0;
                this.policy_name = "";
            }
            if (this.check_gov_special != 1) {
                this.policy_name = "";
            }
            this.other_info = $("#other_info").val();
        },
        refresh: function () {
            //是否高新技术企业
            if (this.is_high_tech == 1) {
                $(".identityYear").show();
            } else if (this.is_high_tech == 2) {
                $(".identityYear").hide();
            } else {
                $(".identityYear").hide();
            }
            //是否正在申请高新技术企业
            if (this.is_applying == 1) {
                $(".apply_y").show();
                $(".apply_n").hide();
            } else if (this.is_applying == 2) {
                $(".apply_n").show();
                $(".apply_y").hide();
            } else {
                $(".apply_n").hide();
                $(".apply_y").hide();
            }
            //近三年是否拥有知识产权
            if (this.has_intellectual_property == 1) {
                $(".property").show();
            } else if (this.is_applying == 2) {
                $(".property").hide();
            } else {
                $(".property").hide();
            }
            //企业申报政府专项（高企）需求
            if (this.has_demand == 1) {
                $("#demand_yes").show();
            } else {
                $("#demand_yes").hide();
            }
            $("#has_demand").val(this.has_demand);
            if (this.check_gov_special == 1) {
                $("#check_gov_special").prop("checked", true);
            } else {
                $("#check_gov_special").prop("checked", false);
            }
            if (this.check_high_tech == 1) {
                $("#check_high_tech").prop("checked", true);
            } else {
                $("#check_high_tech").prop("checked", false);
            }
            if (this.check_gov_special == 1) {
                $(".c_policiy_name").show();
                $("#policy_name").val(this.policy_name);
            } else {
                $(".c_policiy_name").hide();
            }
            //刷入数据
            $("#is_high_tech").find("option[value='" + this.is_high_tech + "']").attr("selected", true);
            $("#identify_time").val(this.identify_time);
            $("#is_applying").find("option[value='" + this.is_applying + "']").attr("selected", true);
            $("#apply_type").find("option[value='" + this.apply_type + "']").attr("selected", true);
            $("#has_apply_will").find("option[value='" + this.has_apply_will + "']").attr("selected", true);
            $("#has_intellectual_property").find("option[value='" + this.has_intellectual_property + "']").attr("selected", true);
            $("#intellectual_property_num").val(this.intellectual_property_num);
            $("#research_rate").val(this.research_rate);
            $("#independent_imputation").find("option[value='" + this.independent_imputation + "']").attr("selected", true);
            $("#apply_fee_deduction").find("option[value='" + this.apply_fee_deduction + "']").attr("selected", true);
            $("#tax_type").find("option[value='" + this.tax_type + "']").attr("selected", true);
            $("#income_change").find("option[value='" + this.income_change + "']").attr("selected", true);
            $("#other_info").val(this.other_info);
            //收入规模
            this.income_scale_obj.sort(compare);
            var html = "";
            for (var i = 0; i < this.income_scale_obj.length; i++) {
                var item = this.income_scale_obj[i];
                html += "<tr><td>" + item.year + "</td><td>" + item.amount + "</td><td><span class=\"glyphicon glyphicon-remove income_scale_del\" title=\"删除记录\" year='" + item.year + "'></span></td></tr>"
            }
            $("#income_scale_tbody").html(html);
            //企业历史申报政府专项情况
            var html2 = "";
            for (var i = 0; i < this.hisdeclare_scale_obj.length; i++) {
                var item = this.hisdeclare_scale_obj[i];
                html2 += "<tr><td>" + item.year + "</td><td>" + item.capital_name + "</td><td>" + item.project_name + "</td><td>" + item.imp_begin_time + "</td><td>" + item.imp_end_time + "</td><td>" + item.is_setup + "</td><td>" + item.is_checkup + "</td><td><span class=\"glyphicon glyphicon-remove hisdeclare_scale_del\" title=\"删除记录\" year='" + item.year + "'></span></td></tr>"
            }
            $("#hisdeclare_scale_tbody").html(html2);
        }
    }
    high_tech_obj.refresh();
    //删除收入规模
    $("#income_scale_tbody").on("click", ".income_scale_del", function () {
        high_tech_obj.del_income_scale($(this).attr("year"));
        high_tech_obj.getParam();
        high_tech_obj.refresh();
    });
    //添加收入规模
    $("#income_add_btn").click(function () {
        high_tech_obj.add_income_scale($("#income_year_add").val(), $("#income_amount_add").val());
        high_tech_obj.getParam();
        high_tech_obj.refresh();
        $("#income_year_add").val("");
        $("#income_amount_add").val("");
    });

    //删除历史申报
    $("#hisdeclare_scale_tbody").on("click", ".hisdeclare_scale_del", function () {
        high_tech_obj.del_hisdeclare_scale($(this).attr("year"));
        high_tech_obj.getParam();
        high_tech_obj.refresh();
    });

    //添加历史申报
    $("#hisdeclare_add_btn").click(function () {
        high_tech_obj.add_hisdecalre_scale($("#hisdeclare_year_add").val(), $("#hisdeclare_capital_name_add").val(), $("#hisdeclare_project_name_add").val(), $("#hisdeclare_imp_begin_time_add").val(), $("#hisdeclare_imp_end_time_add").val(), $("#hisdeclare_is_setup_add").val(), $("#hisdeclare_is_checkup_add").val());
        high_tech_obj.getParam();
        high_tech_obj.refresh();
        $("#hisdeclare_year_add").val("");
        $("#hisdeclare_capital_name_add").val("");
        $("#hisdeclare_project_name_add").val("");
        $("#hisdeclare_imp_begin_time_add").val("");
        $("#hisdeclare_imp_end_time_add").val("");
        $("#hisdeclare_is_setup_add").val("");
        $("#hisdeclare_is_checkup_add").val("");
    });
    //select变更事件
    $("#high_tech_table").on("change", "select", function () {
        if ($(this).attr("noevent") == "Y") {
            return;
        }
        high_tech_obj.getParam();
        high_tech_obj.refresh();
    });
    //checkbox变更事件
    $("#high_tech_table").on("change", "input:checkbox", function () {
        if ($(this).attr("noevent") == "Y") {
            return;
        }
        high_tech_obj.getParam();
        high_tech_obj.refresh();
    });
    $("#high_tech_submit").click(function () {
        high_tech_obj.getParam();
        if (high_tech_obj.check_gov_special == 1 && high_tech_obj.policy_name == "") {
            alert("政策名称必填");
            return;
        }
        high_tech_obj.income_scale = JSON.stringify(high_tech_obj.income_scale_obj);
        high_tech_obj.hisdeclare_scale = JSON.stringify(high_tech_obj.hisdeclare_scale_obj);
        $.ajax({
            url: "/crm/enterprisedetail/updatehightech",
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify(high_tech_obj),
            processData: false,
            contentType: "application/json",
            beforeSend: function () {
                console.log("正在进行，请稍候");
            },
            success: function (responseStr) {
                if (responseStr.code == 200) {
                    alert("变更成功");
                } else {
                    alert(responseStr.msg);
                }
            },
            error: function (responseStr) {
                console.log("error");
            }
        });
    });
</script>

<script>
    var uploadedfileName = "";
    $("#updo").click(function () {
        var formData = new FormData();
        var name = $("#uploadfilename").val();
        formData.append("file", $("#uploadfilename")[0].files[0]);
        formData.append("name", name);

        var btn = $(this);
        btn.prop("disabled", true);
        btn.val("上传中...");
        $.ajax({
            url: "/file/uploadEnterpriseFile",
            type: 'POST',
            data: formData,
// 告诉jQuery不要去处理发送的数据
            processData: false,
// 告诉jQuery不要去设置Content-Type请求头
            contentType: false,
            beforeSend: function () {
                console.log("正在进行，请稍候");
            },
            success: function (responseStr) {
                uploadedfileName = responseStr;
                console.log(uploadedfileName);
                $("#showreturnName").val(uploadedfileName);
                btn.prop("disabled", false);
                btn.val("上传");
            },
            error: function (responseStr) {
                console.log("error");
                btn.prop("disabled", false);
                btn.val("上传");
            }
        });
    });

    $("#saveEnterpriseFileName").click(function () {
        if ($("#showreturnName").val() == "" || $("#fileTitle").val() == "") {
            alert("请先上传文件，并填写文件标题");
            return;
        }

        var btn = $(this);
        btn.prop("disabled", true);
        postData = {
            "fileName": $("#showreturnName").val(),
            "fileTitle": $("#fileTitle").val(),
            "regCreditNo": "${resultBaseInfo.regCreditNo}"
        }
        $.ajax({
            url: "/crm/enterprisedetail/saveFile",
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify(postData),
            processData: false,
            contentType: "application/json",
            beforeSend: function () {
                console.log("正在进行，请稍候");
            },
            success: function (responseStr) {
                if (responseStr.code == 200) {
                    resp = responseStr.data;
                    var html = "<tr><td>" + resp.fileTitle + "</td><td><a href='/file/downloadEnterpriseFile?fileName=" + resp.fileName + "'> " + resp.fileName + "</a></td><td>" + timetrans(resp.updateTime) + "</td><td>" + resp.operator + "</td></tr>";
                    $("#fileTbody").append(html);
                    $("#showreturnName").val("");
                    $("#fileTitle").val("");
                    $("#uploadfilename").val("");
                } else {
                    alert(responseStr.msg);
                }
                btn.prop("disabled", false);
            },
            error: function (responseStr) {
                console.log("error");
                btn.prop("disabled", false);
            }
        });
    })

    function timetrans(date) {
        var date = new Date(date);//如果date为13位不需要乘1000
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
        var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
        var m = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
        var s = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
        return Y + M + D + h + m + s;
    }
</script>
</body>
</html>
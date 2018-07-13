<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8" />
    <title>信隆行CRM系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <meta name="MobileOptimized" content="320">
    <link rel="icon" type="image/x-icon" href="/favicon.ico">
    <link href="/dist/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/layout.css" rel="stylesheet" type="text/css"/>
    <!-- <link href="/dist/css/default.css" rel="stylesheet" type="text/css" id="style_color" /> -->
    <link href="/dist/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="/dist/css/custom.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/crm.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/jquery-ui.min.css" rel="stylesheet">   <!--时间控件样式-->

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo" onload="autoRowSpanAll(reportF)">
<!-- 引入页面头部主菜单 -->
<#assign page=103/>
<!--顶部菜单-->
<#include "top_menu.ftl"/>
<div class="page-container">
    <!--左侧菜单-->
<#include "left_menu.ftl"/>
    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="#">业务运营数据</a>
                    </li>
                </ul>
            </div>

            <div class="container classification">
            <div class="group regionCode">
                <div class="head">
                    <h4>分公司</h4>
                    <span data-value="all"  <#if reportA.reqParams.regionCode == "all">class="all" </#if>>全部</span>
                </div>
                <div class="body">
                    <span data-value="北京" <#if reportA.reqParams.regionCode == "北京">class="cur" </#if> >北京</span>
                    <span data-value="上海" <#if reportA.reqParams.regionCode == "上海">class="cur" </#if> >上海</span>
                    <span data-value="广州" <#if reportA.reqParams.regionCode == "广州">class="cur" </#if> >广州</span>
                    <span data-value="杭州" <#if reportA.reqParams.regionCode == "杭州">class="cur" </#if> >杭州</span>
                    <span data-value="南京" <#if reportA.reqParams.regionCode == "南京">class="cur" </#if> >南京</span>
                    <span data-value="武汉" <#if reportA.reqParams.regionCode == "武汉">class="cur" </#if> >武汉</span>
                    <span data-value="成都" <#if reportA.reqParams.regionCode == "成都">class="cur" </#if> >成都</span>
                    <span data-value="合肥" <#if reportA.reqParams.regionCode == "合肥">class="cur" </#if> >合肥</span>
                    <span data-value="南昌" <#if reportA.reqParams.regionCode == "南昌">class="cur" </#if> >南昌</span>
                    <span data-value="无锡" <#if reportA.reqParams.regionCode == "无锡">class="cur" </#if> >无锡</span>
                    <span data-value="青岛" <#if reportA.reqParams.regionCode == "青岛">class="cur" </#if> >青岛</span>
                    <span data-value="温州" <#if reportA.reqParams.regionCode == "温州">class="cur" </#if> >温州</span>
                    <span data-value="长沙" <#if reportA.reqParams.regionCode == "长沙">class="cur" </#if> >长沙</span>
                    <span data-value="嘉兴" <#if reportA.reqParams.regionCode == "嘉兴">class="cur" </#if> >嘉兴</span>
                    <span data-value="台州" <#if reportA.reqParams.regionCode == "台州">class="cur" </#if> >台州</span>
                    <span data-value="舟山" <#if reportA.reqParams.regionCode == "舟山">class="cur" </#if> >舟山</span>
                    <span data-value="绍兴" <#if reportA.reqParams.regionCode == "绍兴">class="cur" </#if> >绍兴</span>
                    <span data-value="常州" <#if reportA.reqParams.regionCode == "常州">class="cur" </#if> >常州</span>
                    <span data-value="张家港" <#if reportA.reqParams.regionCode == "张家港">class="cur" </#if> >张家港</span>
                    <span data-value="湖州" <#if reportA.reqParams.regionCode == "湖州">class="cur" </#if> >湖州</span>
                    <span data-value="宁波" <#if reportA.reqParams.regionCode == "宁波">class="cur" </#if> >宁波</span>
                    <span data-value="北美" <#if reportA.reqParams.regionCode == "北美">class="cur" </#if> >北美</span>
                </div>
            </div>
            <div class="group selectTime">
                <div class="head">
                    <h4>数据日期</h4>
                </div>
                <div class="body">
                    <div class="period">
                        <input name="startDate" id="startDate" type="text" placeholder="开始时间" value = "${reportA.reqParams.timeBegin!''}" readonly="readonly">
                        <em>-</em>
                        <em>-</em>
                        <input name="endDate" id="endDate" type="text" placeholder="结束时间"  value = "${reportA.reqParams.timeEnd!''}" readonly="readonly">
                    </div>
                </div>
            </div>
            </div>
            <br>
            <!-- 隐式请求参数-->
            <form id="dataReportCond" action="/data/report" method="post">
                <input name="regionCode" id="regionCode" type="hidden" value = "${reportA.reqParams.regionCode!''}"/>
                <input name="timeBegin" id="timeBegin" type="hidden" value = "${reportA.reqParams.timeBegin!''}"/>
                <input name="timeEnd" id="timeEnd" type="hidden" value = "${reportA.reqParams.timeEnd!''}">
                <input type="hidden" name="pageIndex" id="pageIndex" value="">
            </form>

            <div class="row">
                <div><span style="font-size: medium;color: #0b6694">一、触达客户数据报表（分公司）</span>&nbsp;&nbsp;<span style="color:#ff0000;font-weight: bold">（${reportA.reqParams.timeBegin!''}至${reportA.reqParams.timeEnd!''}）</span></div>
                <br>
                <div class="col-md-6 col-sm-6">
                    <table class="table table-striped table-bordered table-hover table-condensed " id="report1">
                        <thead>
                        <tr style="background-color: #7ca7cc">
                            <th width="18%">
                                分公司
                            </th>
                            <th width="15%">
                                G客户数
                            </th>
                            <th width="15%">
                                T客户数
                            </th>
                            <th width="15%">
                                F客户数
                            </th>
                            <th width="13%">
                                总客户数
                            </th>
                            <th width="13%">
                                人数
                            </th>
                            <th width="17%">
                                人均 &nbsp; <i class="fa fa-sort-desc" style="color: red"></i>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list reportA.dataReportContents as reportA>
                        <tr>
                            <td>
                            ${reportA.company?if_exists}
                            </td>
                            <td>
                            ${reportA.gCustCnt?if_exists}
                            </td>
                            <td>
                            ${reportA.tCustCnt?if_exists}
                            </td>
                            <td>
                            ${reportA.fCustCnt?if_exists}
                            </td>
                            <td>
                            ${reportA.custCnt?if_exists}
                            </td>
                            <td>
                            ${reportA.empCnt?if_exists}
                            </td>
                            <td>
                            ${reportA.empAvg?if_exists}
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
            统计口径：<br>
            人均 = 总客户数 / 人数<br>
            说明：触达客户数的计算规则是，一天之内，分公司触达（电话、拜访）同一家企业的同一个人，只算一次触达。<br>
            <br>
            <div class="row">
                <div><span style="font-size: medium;color: #0b6694">二、触达客户数据报表（个人）</span>&nbsp;&nbsp;<span style="color:#ff0000;font-weight: bold">（${reportA.reqParams.timeBegin!''}至${reportA.reqParams.timeEnd!''}）</span></div>
                <br>
                <div class="col-md-7 col-sm-7">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr style="background-color: #7ca7cc">
                            <th width="18%">
                                分公司
                            </th>
                            <th width="18%">
                                员工姓名
                            </th>
                            <th width="15%">
                                总客户数 &nbsp; <i class="fa fa-sort-desc" style="color: red"></i>
                            </th>
                            <th width="15%">
                                G客户数
                            </th>
                            <th width="15%">
                                T客户数
                            </th>
                            <th width="15%">
                                F客户数
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#if reportC??>
                        <#list reportC.dataReportContents as reportC>
                        <tr>
                            <td>
                            ${reportC.company?if_exists}
                            </td>
                            <td>
                            ${reportC.employee?if_exists}
                            </td>
                            <td>
                            ${reportC.custCnt?if_exists}
                            </td>
                            <td>
                            ${reportC.gCustCnt?if_exists}
                            </td>
                            <td>
                            ${reportC.tCustCnt?if_exists}
                            </td>
                            <td>
                            ${reportC.fCustCnt?if_exists}
                            </td>
                        </tr>
                        </#list>
                        </#if>
                        </tbody>
                    </table>
                </div>
            </div>
            说明：触达客户数的计算规则是，一天之内，触达（电话、拜访）同一家企业的同一个人，只算一次触达。<br>
            <br>
            <div class="row">
                <div><span style="font-size: medium;color: #0b6694">三、拜访客户数据报表</span>&nbsp;&nbsp;<span style="color:#ff0000;font-weight: bold">（${reportA.reqParams.timeBegin!''}至${reportA.reqParams.timeEnd!''}）</span></div>
                <br>
                <div class="col-md-8 col-sm-8">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr style="background-color: #7ca7cc">
                            <th width="10%">
                                分公司
                            </th>
                            <th width="15%">
                                总上门客户数 &nbsp; <i class="fa fa-sort-desc" style="color: red"></i>
                            </th>
                            <th width="7%">
                                占比
                            </th>
                            <th width="13%">
                                G上门客户数
                            </th>
                            <th width="7%">
                                G占比
                            </th>
                            <th width="13%">
                                T上门客户数
                            </th>
                            <th width="7%">
                                T占比
                            </th>
                            <th width="13%">
                                F上门客户数
                            </th>
                            <th width="7%">
                                F占比
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list reportB.dataReportContents as reportB>
                        <tr>
                            <td>
                            ${reportB.company?if_exists}
                            </td>
                            <td>
                            ${reportB.vstCustCnt?if_exists}
                            </td>
                            <td>
                            ${reportB.vstCustRate*100?if_exists}%
                            </td>
                            <td>
                            ${reportB.gVstCustCnt?if_exists}
                            </td>
                            <td>
                            ${reportB.gVstCustRate*100?if_exists}%
                            </td>
                            <td>
                            ${reportB.tVstCustCnt?if_exists}
                            </td>
                            <td>
                            ${reportB.tVstCustRate*100?if_exists}%
                            </td>
                            <td>
                            ${reportB.fVstCustCnt?if_exists}
                            </td>
                            <td>
                            ${reportB.fVstCustRate*100?if_exists}%
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
            统计口径：<br>
            总的占比 = 总上门客户数 / 总触达客户数</br>
            G占比 = G上门客户数 / G触达客户数</br>
            T占比 = T上门客户数 / T触达客户数</br>
            F占比 = F上门客户数 / F触达客户数</br>
            说明：上门客户数的计算规则是，一天之内，分公司上门拜访同一家企业的同一个人，只算一次上门拜访。<br>
            <br>
            <br>
            <div class="row">
                <div><span style="font-size: medium;color: #0b6694">四、CRM系统使用情况</span>&nbsp;&nbsp;<span style="color:#ff0000;font-weight: bold">（${reportA.reqParams.timeBegin!''}至${reportA.reqParams.timeEnd!''}）</span></div>
                <br>
                <div class="col-md-4 col-sm-4">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr style="background-color: #7ca7cc">
                            <th width="7%">
                                分公司
                            </th>
                            <th width="7%">
                                员工
                            </th>
                            <th width="7%">
                                使用天数 &nbsp; <i class="fa fa-sort-desc" style="color: red"></i>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list reportD.dataReportContents as reportD>
                        <tr>
                            <td>
                            ${reportD.company?if_exists}
                            </td>
                            <td>
                            ${reportD.employee?if_exists}
                            </td>
                            <td>
                            ${reportD.loginDayCnt?if_exists}天
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
            说明：使用日志记录从2017年9月7号开始
            <br>
            <br>

            <div class="row">
                <div><span style="font-size: medium;color: #0b6694">五、实际拜访部委分布情况</span>&nbsp;&nbsp;<span style="color:#ff0000;font-weight: bold">（${reportA.reqParams.timeBegin!''}至${reportA.reqParams.timeEnd!''}）</span></div>
                <br>
                <div class="col-md-8 col-sm-8">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr style="background-color: #7ca7cc">
                            <th width="10%">
                                分公司
                            </th>
                            <th width="7%">
                                科技部（科委）
                            </th>
                            <th width="7%">
                                经信委
                            </th>
                            <th width="7%">
                                金融办
                            </th>
                            <th width="7%">
                                人才办（组织部）
                            </th>
                            <th width="7%">
                                人民政府
                            </th>
                            <th width="7%">
                                发改委
                            </th>
                            <th width="7%">
                                其他
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list reportE.dataReportContents as reportE>
                        <tr>
                            <td>
                            ${reportE.branchName?if_exists}
                            </td>
                            <td>
                            ${reportE.kjbCount?if_exists}
                            </td>
                            <td>
                            ${reportE.jxwCount?if_exists}
                            </td>
                            <td>
                            ${reportE.jrbCount?if_exists}
                            </td>
                            <td>
                            ${reportE.rcbCount?if_exists}
                            </td>
                            <td>
                            ${reportE.rmzfCount?if_exists}
                            </td>
                            <td>
                            ${reportE.fgwCount?if_exists}
                            </td>
                            <td>
                            ${reportE.qtCount?if_exists}
                            </td>
                        </tr>
                        </#list>
                        <tr>
                            <td>
                            合计
                            </td>
                            <td>
                            ${reportE.dataReportShowOrgDto.kjbCount?if_exists}
                            </td>
                            <td>
                            ${reportE.dataReportShowOrgDto.jxwCount?if_exists}
                            </td>
                            <td>
                            ${reportE.dataReportShowOrgDto.jrbCount?if_exists}
                            </td>
                            <td>
                            ${reportE.dataReportShowOrgDto.rcbCount?if_exists}
                            </td>
                            <td>
                            ${reportE.dataReportShowOrgDto.rmzfCount?if_exists}
                            </td>
                            <td>
                            ${reportE.dataReportShowOrgDto.fgwCount?if_exists}
                            </td>
                            <td>
                            ${reportE.dataReportShowOrgDto.qtCount?if_exists}
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <br>

            <div class="row">
                <div><span style="font-size: medium;color: #0b6694">六、个人分配及触达企业数</span>&nbsp;&nbsp;<span style="color:#ff0000;font-weight: bold">（${reportA.reqParams.timeBegin!''}至${reportA.reqParams.timeEnd!''}）</span></div>
                <br>
                <div class="col-md-8 col-sm-8">
                    <table class="table table-bordered table-hover" id="reportF">
                        <thead>
                        <tr style="background-color: #7ca7cc" data-field="company">
                            <th width="10%">
                                分公司
                            </th>
                            <th width="7%" data-field="favUserList">
                                分总
                            </th>
                            <th width="7%" data-field="distNum">
                                已分配项目数
                            </th>
                            <th width="7%" data-field="custManager">
                                被分配人
                            </th>
                            <th width="7%" data-field="weekDist">
                                被分配数
                            </th>
                            <th width="7%" data-field="weekReac">
                                被分配触达数
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list reportF as report>
                            <#list report.branchPersonReachList as branchPerson>
                            <tr>
                                <td>
                                ${report.company?if_exists}
                                </td>
                                <td>
                                ${report.favUserList?if_exists}
                                </td>
                                <td>
                                ${report.distNum?if_exists}
                                </td>
                                <td>
                                ${branchPerson.custManager?if_exists}
                                </td>
                                <td>
                                ${branchPerson.weekDist?default("0")}
                                </td>
                                <td>
                                ${branchPerson.weekReac?default("0")}
                                </td>
                            </tr>
                            </#list>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
            <br>
        </div>
    </div>
</div>

<!-- BEGIN 框架效果 -->
<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<!--时间控件-->
<script src="/dist/js/jquery-ui.min.js"></script>
<script src="/dist/js/datepicker-zh-CN.js"></script>
<script src="/dist/js/crm.js?v=1"></script>
<script src="/dist/js/filter_datareport.js"></script>

<!--table导出excel-->
<#--<script src="/dist/js/table-expbutton.js"></script>
<script src="/dist/tableExport/libs/pdfMake/pdfmake.min.js"></script>
<script src="/dist/tableExport/libs/pdfMake/vfs_fonts.js"></script>
<script type="text/javascript" src="/dist/tableExport/libs/FileSaver/FileSaver.min.js"></script>
<script type="text/javascript" src="/dist/tableExport/libs/js-xlsx/xlsx.core.min.js"></script>
<script type="text/javascript" src="/dist/tableExport/libs/jsPDF/jspdf.min.js"></script>
<script type="text/javascript" src="/dist/tableExport/libs/jsPDF-AutoTable/jspdf.plugin.autotable.js"></script>
<script type="text/javascript" src="/dist/tableExport/libs/html2canvas/html2canvas.min.js"></script>
<script type="text/javascript" src="/dist/tableExport/tableExport.js"></script>
<script src="/dist/js/table-export.js"></script>-->

<script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
//        Demo.init(); // init demo features
        //TableExport.init();s
    });
    //表格相同行合并
    function autoRowSpan(tb,row,col)
    {
        var lastValue="";
        var value="";
        var pos=1;
        for(var i=row;i<tb.rows.length;i++){
            value = tb.rows[i].cells[col].innerText;
            if(lastValue == value){
                tb.rows[i].deleteCell(2);
                tb.rows[i-pos].cells[2].rowSpan = tb.rows[i-pos].cells[col].rowSpan+1;
                tb.rows[i].deleteCell(1);
                tb.rows[i-pos].cells[1].rowSpan = tb.rows[i-pos].cells[col].rowSpan+1;
                tb.rows[i].deleteCell(col);
                tb.rows[i-pos].cells[col].rowSpan = tb.rows[i-pos].cells[col].rowSpan+1;
                pos++;
            }else{
                lastValue = value;
                pos=1;
            }
        }
    }
    function  autoRowSpanAll(tb) {
        var dist=0;
        var reac=0;
        for(var i=1;i<tb.rows.length;i++){
            dist+= parseInt(tb.rows[i].cells[4].innerText);
            reac+= parseInt(tb.rows[i].cells[5].innerText);
        }
        var html='<tr>' +
                '<td>合计</td><td></td><td>'+dist+'</td><td></td><td>'+dist+'</td><td>'+reac+'</td>' +
                '</tr>';
        autoRowSpan(tb,0,0);
        $("#reportF").append(html);
    }
</script>
</body>
</html>


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
    <link href="/dist/css/custom.css" rel="stylesheet" type="text/css"/>
    <!-- <link href="/dist/css/default.css" rel="stylesheet" type="text/css" id="style_color" /> -->
    <link href="/dist/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
    <!--发布日志弹出窗css-->
    <link href="/dist/css/pop-style.css" rel="stylesheet" type="text/css"/>

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
<#assign page=102/>
<#include "top_menu.ftl"/>

<!-- 仪表盘页面中部区域层：BEGIN-->
<div class="page-container">
    <!--引入页面左边菜单tree-->
<#include "left_menu.ftl"/>

    <!-------------------页面tree菜单右边展示区域，由开发者自由编写：BEGIN-->
    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="#">数据大盘</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:#ff0000;font-weight: bold">（当月指：<#if (rangDate)??>${rangDate}</#if>）</span>
                    </li>
                </ul>
            </div>
            <!-- BEGIN DASHBOARD STATS -->
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-5 col-xs-5">
                    <div class="dashboard-stat blue-madison">
                        <div class="visual">
                            <i class="fa fa-comments"></i>
                        </div>
                        <div class="details">
                            <div class="number">
                            <#if (dashboardIndex.monAcContrAmt)??>${dashboardIndex.monAcContrAmt}</#if>万元
                            </div>
                            <div class="desc">
                                当月累计合同金额
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-5 col-xs-5">
                    <div class="dashboard-stat purple-plum">
                        <div class="visual">
                            <i class="fa fa-globe"></i>
                        </div>
                        <div class="details">
                            <div class="number">
                            <#if (dashboardIndex.monAcOrdCnt)??>${dashboardIndex.monAcOrdCnt}</#if>单
                            </div>
                            <div class="desc">
                                当月新增订单数
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-5 col-xs-5">
                    <div class="dashboard-stat purple-plum">
                        <div class="visual">
                            <i class="fa fa-globe"></i>
                        </div>
                        <div class="details">
                            <div class="number">
                            <#if (dashboardIndex.monAcOrdAmt)??>${dashboardIndex.monAcOrdAmt}</#if>万元
                            </div>
                            <div class="desc">
                                当月新增订单金额
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-5 col-xs-5">
                    <div class="dashboard-stat red-intense">
                        <div class="visual">
                            <i class="fa fa-bar-chart-o"></i>
                        </div>
                        <div class="details">
                            <div class="number">
                            <#if (dashboardIndex.monRchEntCnt)??>${dashboardIndex.monRchEntCnt}</#if>家
                            </div>
                            <div class="desc">
                                当月触达企业数
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-5 col-xs-5">
                    <div class="dashboard-stat red-intense">
                        <div class="visual">
                            <i class="fa fa-bar-chart-o"></i>
                        </div>
                        <div class="details">
                            <div class="number">
                            <#if (dashboardIndex.monUptEntCnt)??>${dashboardIndex.monUptEntCnt}</#if>家
                            </div>
                            <div class="desc">
                                当月更新企业数
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-5 col-xs-5">
                    <div class="dashboard-stat green-haze">
                        <div class="visual">
                            <i class="fa fa-shopping-cart"></i>
                        </div>
                        <div class="details">
                            <div class="number">
                            <#if (dashboardIndex.entTotalCnt)??>${dashboardIndex.entTotalCnt}</#if>家
                            </div>
                            <div class="desc">
                                截止目前收录企业数
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END DASHBOARD STATS -->
            <div class="clearfix">
            </div>
            <!--当月触达次数（按分公司）-->
            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <div id="c1007" style="height:700px;width: 900px;"></div>
                </div>
            </div>
            <!--当月触达企业数（按分公司）-->
            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <div id="c1005" style="height:700px;width: 900px;"></div>
                </div>
            </div>
            <!--当月更新企业数（按分公司）-->
            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <div id="c1006" style="height:700px;width: 900px;"></div>
                </div>
            </div>
            <!--当月举办活动数（按分公司）-->
            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <div id="c1008" style="height:700px;width: 900px;"></div>
                </div>
            </div>
            <!--当月订单数（按分公司）-->
            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <div id="c1003" style="height:700px;width: 900px;"></div>
                </div>
            </div>
            <!--当月订单金额（按分公司）-->
            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <div id="c1004" style="height:700px;width: 900px;"></div>
                </div>
            </div>
            <!--当月合同金额（按分公司）-->
            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <div id="c1002" style="height:700px;width: 900px;"></div>
                </div>
            </div>
            <!--本年合同总金额（按分公司）-->
            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <div id="c1001" style="height:700px;width: 900px;"></div>
                </div>
            </div>

        </div>
        <!-------------------页面tree菜单右边展示区域，由开发者自由编写：END-->
    </div>

    <!-- 页面中部区域层：END-->
</div>

<!--CRM系统发布日志公告栏-->
<div id="extbkbox" class="extbkbox" style="display:block;">
    <div class="extbkboxm">
        <strong style="float:left;padding-left:10px;">系統发布内容公告</strong>
        <div class="extmore">
            <span class="extbkboxnar" id="extbkboxnar" onclick="extbkboxnar();"></span>
        </div>
    </div>
    <div class="extbkboxb" id="extbkboxb" style="display:block;">
        1、2017-08-25：企业信息维护：新增查询“档案更新企业”。<br>
        2、2017-08-23：营销管理：触达企业增加“企业分层”。<br>
        3、2017-08-18：营销管理：触达对象新增“政府”。<br>
    </div>
</div>

<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<script src="/dist/js/echarts.min.js" type="text/javascript"></script>
<!--发布日志弹出窗-->
<script src="/dist/js/release-log.js" type="text/javascript"></script>
<!--主题色-->
<script src="/dist/js/macarons.js"></script> <!--macarons主题色-->
<!--<script src="/dist/js/dark.js"></script> <!--dark主题色-->
<!--<script src="/dist/js/roma.js"></script> <!--roma主题色-->
<!--<script src="/dist/js/shine.js"></script> <!--shine主题色-->
<!--<script src="/dist/js/infographic.js"></script> <!--infographic主题色-->

<script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout

        //获取柱状图数据数组
        var option = <#if chartJsonStr??>${chartJsonStr}</#if>;
        //获取堆积柱状图数据数组
        var option2 = <#if chartJsonStr2??>${chartJsonStr2}</#if>;

        // 初始化echarts实例
        var myChart1 = echarts.init(document.getElementById('c1001'),'macarons');
        var myChart2 = echarts.init(document.getElementById('c1002'),'macarons');
        var myChart3 = echarts.init(document.getElementById('c1003'),'macarons');
        var myChart4 = echarts.init(document.getElementById('c1004'),'macarons');
        var myChart5 = echarts.init(document.getElementById('c1005'),'macarons');
        var myChart6 = echarts.init(document.getElementById('c1006'),'macarons');
        var myChart7 = echarts.init(document.getElementById('c1007'),'macarons');
        var myChart8 = echarts.init(document.getElementById('c1008'),'macarons');

        // 赋值所要展示的图表。
        myChart1.setOption(option[0]); //柱状图：本年合同总金额
        myChart2.setOption(option[1]); //柱状图：当月合同金额
        myChart3.setOption(option[2]); //柱状图：当月订单数
        myChart4.setOption(option[3]); //柱状图：当月订单金额
        myChart5.setOption(option[4]); //柱状图：当月触达企业数
        myChart6.setOption(option[5]); //柱状图：当月更新企业数
        //myChart7.setOption(option[6]); //柱状图：当月触达次数
        myChart7.setOption(option2[0]); //堆积柱状图：当月触达次数
        myChart8.setOption(option[6]); //柱状图：当月举办活动数
    });
</script>
</body>
</html>
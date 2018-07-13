<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<html lang="en" class="no-js">
<head>
    <!--<meta charset="utf-8" http-equiv="refresh" content="300">-->
    <title>信隆行CRM系统</title>
    <meta name="MobileOptimized" content="320">
    <link rel="icon" type="image/x-icon" href="/favicon.ico">
    <link href="/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

</head>
<!--<body style="background: rgb(51,51,51)">-->
<body>
<div class="page-container">
    <div class="page-content-wrapper">
        <div class="page-content">
            <div align="center" style="color: red">
                <h2 class="page-title">信隆行业务数据大屏</h2>
            </div>
            <br>
            <div class="row">
                <div class="col-md-6 col-sm-6">
                    <div id="d1002" style="height:700px;width: 700px;"></div>
                </div>
                <div class="col-md-6 col-sm-6">
                    <div id="m1001" style="height:400px;width: 500px;">滚动刷新触达信息</div>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <div id="e1001" style="height:400px;width: 1200px;"></div>
                </div>
            </div>
            <br>
            <div class="portlet-body">
                <!--BEGIN TABS-->
                <div class="tabbable tabbable-custom">
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a href="#tab_1_1" data-toggle="tab">
                                上海 </a>
                        </li>
                        <li>
                            <a href="#tab_1_2" data-toggle="tab">
                                 嘉兴</a>
                        </li>
                        <li>
                            <a href="#tab_1_3" data-toggle="tab">
                                杭州</a>
                        </li>
                        <li>
                            <a href="#tab_1_4" data-toggle="tab">
                                北京</a>
                        </li>
                        <li>
                            <a href="#tab_1_5" data-toggle="tab">
                                南京</a>
                        </li>
                        <li>
                            <a href="#tab_1_6" data-toggle="tab">
                                武汉</a>
                        </li>
                        <li>
                            <a href="#tab_1_7" data-toggle="tab">
                                成都</a>
                        </li>
                        <li>
                            <a href="#tab_1_8" data-toggle="tab">
                                合肥</a>
                        </li>
                        <li>
                            <a href="#tab_1_9" data-toggle="tab">
                                南昌</a>
                        </li>
                        <li>
                            <a href="#tab_1_10" data-toggle="tab">
                                广州</a>
                        </li>
                        <li>
                            <a href="#tab_1_11" data-toggle="tab">
                                无锡</a>
                        </li>
                        <li>
                            <a href="#tab_1_12" data-toggle="tab">
                                青岛</a>
                        </li>
                        <li>
                            <a href="#tab_1_13" data-toggle="tab">
                                温州</a>
                        </li>
                        <li>
                            <a href="#tab_1_14" data-toggle="tab">
                                长沙</a>
                        </li>
                        <li>
                            <a href="#tab_1_15" data-toggle="tab">
                                台州</a>
                        </li>
                        <li>
                            <a href="#tab_1_16" data-toggle="tab">
                                舟山</a>
                        </li>
                        <li>
                            <a href="#tab_1_17" data-toggle="tab">
                                绍兴</a>
                        </li>
                        <li>
                            <a href="#tab_1_18" data-toggle="tab">
                                常州</a>
                        </li>
                        <li>
                            <a href="#tab_1_19" data-toggle="tab">
                                张家港</a>
                        </li>
                        <li>
                            <a href="#tab_1_20" data-toggle="tab">
                                湖州</a>
                        </li>
                        <li>
                            <a href="#tab_1_21" data-toggle="tab">
                                宁波</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="tab_1_1">
                            <div id="f1001" style="height:700px;width: 700px;"></div>
                        </div>
                        <div class="tab-pane" id="tab_1_2">
                            <div id="g1001" style="height:700px;width: 700px;"></div>
                        </div>
                        <div class="tab-pane" id="tab_1_3">
                            <div id="h1001" style="height:700px;width: 700px;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- BEGIN 框架效果 -->
<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<!--<script src="/dist/js/echarts-all.js" type="text/javascript"></script>-->
<script src="/dist/js/echarts.min.js" type="text/javascript"></script>
<!--<script src="/dist/js/macarons.js"></script> <!--macarons主题色-->
<!--<script src="/dist/js/dark.js"></script> <!--dark主题色-->
<!--<script src="/dist/js/roma.js"></script> <!--roma主题色-->
<!--<script src="/dist/js/shine.js"></script> <!--shine主题色-->
<script src="/dist/js/infographic.js"></script> <!--infographic主题色-->

<script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout

        //获取柱状图数据数组
        var option1 = <#if rtJsonStr1??>${rtJsonStr1}</#if>;
        var option2 = <#if rtJsonStr2??>${rtJsonStr2}</#if>;
        var option3 = <#if rtJsonStr3??>${rtJsonStr3}</#if>;

        // 初始化echarts实例
        var myChart1 = echarts.init(document.getElementById('d1002'),'infographic');
        var myChart2 = echarts.init(document.getElementById('e1001'),'infographic');
        var myChart3 = echarts.init(document.getElementById('f1001'),'infographic');
        var myChart4 = echarts.init(document.getElementById('g1001'),'infographic');
        var myChart5 = echarts.init(document.getElementById('h1001'),'infographic');

        // 赋值所要展示的图表。
        myChart1.setOption(option1[0]);
        myChart2.setOption(option2[0]);
        myChart3.setOption(option3[0]);
        myChart4.setOption(option3[1]);
        myChart5.setOption(option3[2]);
    });
</script>
</body>
</html>
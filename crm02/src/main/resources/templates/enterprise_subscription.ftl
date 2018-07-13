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
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <link rel="icon" type="image/x-icon" href="/favicon.ico">
    <link href="/dist/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
    <!--下拉列表多选框的样式-->
    <link rel="stylesheet" type="text/css" href="/dist/css/bootstrap-select.min.css"/>
    <link rel="stylesheet" type="text/css" href="/dist/css/select2.css"/>
    <link rel="stylesheet" type="text/css" href="/dist/css/multi-select.css"/>
    <link href="/dist/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/layout.css" rel="stylesheet" type="text/css"/>
    <!-- <link href="/dist/css/default.css" rel="stylesheet" type="text/css" id="style_color" /> -->
    <link href="/dist/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="/dist/css/custom.css" rel="stylesheet" type="text/css"/>

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-full-width">
<!-- 引入页面头部主菜单 -->
<#assign page=31/>
<#include "top_menu.ftl"/>
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="#">客户关系管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">企业订阅</a>
                    </li>
                </ul>
            </div>
            <div class="row ">
                <div class="col-md-5 col-sm-5">
                    <div class="portlet box blue-steel">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-bell-o"></i>设置订阅条件
                            </div>
                        </div>
                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                            <form action="" class="form-horizontal form-row-seperated">
                                <div class="form-body">
                                    <div class="form-group">
                                        <label class="control-label col-md-2">数据来源渠道</label>
                                        <div class="col-md-2">
                                            <select multiple="multiple" class="multi-select" id="my_multi_select1" name="my_multi_select1[]">
                                                <option>全国创赛</option>
                                                <option>科技贷款系统</option>
                                                <option>一融云销售</option>
                                                <option>高企认证</option>
                                                <option>FA需求</option>
                                                <option>杭高投企调</option>
                                                <option>分公司收集（上市挂牌储备）</option>
                                                <option>分公司收集（政府扶持企业）</option>
                                                <option>海归高精尖项目</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">地区</label>
                                        <div class="col-md-2">
                                            <select multiple="multiple" class="multi-select" id="my_multi_select2" name="my_multi_select2[]">
                                                <option>北京</option>
                                                <option>上海</option>
                                                <option>广州</option>
                                                <option>杭州</option>
                                                <option>南京</option>
                                                <option>武汉</option>
                                                <option>成都</option>
                                                <option>合肥</option>
                                                <option>南昌</option>
                                                <option>无锡</option>
                                                <option>青岛</option>
                                                <option>温州</option>
                                                <option>长沙</option>
                                                <option>嘉兴</option>
                                                <option>台州</option>
                                                <option>舟山</option>
                                                <option>绍兴</option>
                                                <option>常州</option>
                                                <option>张家港</option>
                                                <option>湖州</option>
                                                <option>江阴</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">企业等级</label>
                                        <div class="col-md-2">
                                            <select multiple="multiple" class="multi-select" id="my_multi_select3" name="my_multi_select3[]">
                                                <option>10星</option>
                                                <option>9星</option>
                                                <option>8星</option>
                                                <option>7星</option>
                                                <option>6星</option>
                                                <option>5星</option>
                                                <option>4星</option>
                                                <option>3星</option>
                                                <option>2星</option>
                                                <option>1星</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">企业聚类</label>
                                        <div class="col-md-2">
                                            <select multiple="multiple" class="multi-select" id="my_multi_select4" name="my_multi_select4[]">
                                                <option>高价值企业</option>
                                                <option>成长之星</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-actions">
                                    <div class="row">
                                        <div class="col-md-offset-2 col-md-2">
                                            <button type="submit" class="btn blue"><i class="fa fa-check"></i> 保存</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <!-- END FORM-->
                        </div>
                    </div>
                    <div class="portlet box blue-steel">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-eye"></i>历史订阅
                            </div>
                        </div>
                        <div class="portlet-body">
                            此处展示历史订阅信息
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6">
                    <div class="portlet box green-haze">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-check"></i>当期推送企业
                            </div>
                        </div>
                        <div class="portlet-body">
                            <span>此处展示符合订阅条件的推送企业信息列表</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END CONTENT -->
</div>

<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery-migrate.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.blockui.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.cokie.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.uniform.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- 下面两个JS作用于下拉列表多选框 -->
<script type="text/javascript" src="/dist/js/select2.min.js"></script>
<script type="text/javascript" src="/dist/js/jquery.multi-select.js"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<script src="/dist/js/quick-sidebar.js" type="text/javascript"></script>
<script src="/dist/js/demo.js" type="text/javascript"></script>
<script src="/dist/js/components-dropdowns.js"></script>
<script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        Demo.init(); // init demo features
        ComponentsDropdowns.init(); //初始化多选框，新增时需把新增多选框的ID加进去
    });
</script>
</body>
</html>

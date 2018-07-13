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
    <link href="/dist/css/select2.css" rel="stylesheet" type="text/css" />
    <link href="/dist/css/dataTables.bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/layout.css" rel="stylesheet" type="text/css"/>
    <!-- <link href="/dist/css/default.css" rel="stylesheet" type="text/css" id="style_color" /> -->
    <link href="/dist/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="/dist/css/custom.css" rel="stylesheet" type="text/css"/>
    <!-- added by yingsl on 20170523 -->
    <link href="/dist/css/enterprisebank.css" rel="stylesheet" type="text/css"/>
    <link href="/dist/css/jquery-ui.min.css" rel="stylesheet" >

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
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
                        <a href="#">客户关系管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">企业信息维护</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">企业信息录入</a>
                    </li>
                </ul>
            </div>

            <div class="row ">
                <div class="col-md-8 col-sm-8">
                    <div class="portlet box purple">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-check"></i>基本信息<span class="label label-danger">工商局拉取，更新日期：2017/02/20</span>
                            </div>
                        </div>
                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                            <form action="" class="form-horizontal form-row-seperated">
                                <div class="form-body">
                                    <div class="form-group">
                                        <label class="control-label col-md-4">工商注册号或者统一社会信用代码：</label>
                                        <input id="title" type="text" class="control-label col-md-3" value="" placeholder="请输入企业工商注册号或者统一社会信用代码"/>
                                        <label class="control-label col-md-1">&nbsp;</label>
                                        <button type="submit" class="btn blue"><i class="fa fa-check"></i>校验</button>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">公司名称：</label>
                                        <input id="title" type="text" class="control-label col-md-3" value=""/>
                                        <label class="control-label col-md-2">经营状态：</label>
                                        <input id="title" type="text" class="control-label col-md-3" value=""/>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">统一社会信用代码：</label>
                                        <input id="title" type="text" class="control-label col-md-3" value=""/>
                                        <label class="control-label col-md-2">工商注册号：</label>
                                        <input id="title" type="text" class="control-label col-md-3" value=""/>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">公司类型：</label>
                                        <input id="title" type="text" class="control-label col-md-3" value=""/>
                                        <label class="control-label col-md-2">法定代表人：</label>
                                        <input id="title" type="text" class="control-label col-md-3" value=""/>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">营业期限：</label>
                                        <input id="title" type="text" class="control-label col-md-3" value=""/>
                                        <label class="control-label col-md-2">企业地址：</label>
                                        <input id="title" type="text" class="control-label col-md-3" value=""/>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">成立日期：</label>
                                        <input id="title" type="text" class="control-label col-md-3" value=""/>
                                        <label class="control-label col-md-2">行业：</label>
                                        <input id="title" type="text" class="control-label col-md-3" value=""/>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">经营范围：</label>
                                        <textarea id="message"  class="control-label col-md-8"  rows="5" value=""></textarea>
                                    </div>
                                    <div class="form-group">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-hover table-bordered">
                                                <thead>
                                                <tr>
                                                    <th>
                                                        主要人员姓名
                                                    </th>
                                                    <th>
                                                        主要人员职位
                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>

                                                    </td>
                                                    <td>

                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <table class="table table-striped table-hover table-bordered  col-md-2">
                                            <thead>
                                            <tr>
                                                <th>
                                                    股东类型
                                                </th>
                                                <th>
                                                    股东姓名
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
                                            <tr>
                                                <td>

                                                </td>
                                                <td>

                                                </td>
                                                <td>

                                                </td>
                                                <td>

                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="form-group">
                                        <table class="table table-striped table-hover table-bordered">
                                            <thead>
                                            <tr>
                                                <th>
                                                    变更项目
                                                </th>
                                                <th>
                                                    变更日期
                                                </th>
                                                <th>
                                                    变更前内容
                                                </th>
                                                <th>
                                                    变更后内容
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>

                                                </td>
                                                <td>

                                                </td>
                                                <td>

                                                </td>
                                                <td>

                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </form>
                            <!-- END FORM-->
                        </div>
                    </div>

                    <div class="portlet box blue-steel">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-check"></i>公司人员情况<span class="label label-danger">手工录入，更新日期：2017/03/16</span>
                            </div>
                            <div class="actions btn-set">
                                <button class="btn green"><i class="fa fa-check"></i> 保存</button>
                                <button class="btn green"><i class="fa fa-check"></i> 编辑</button>
                            </div>
                        </div>
                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                            <form action="" class="form-horizontal form-row-seperated">
                                <div class="form-body">
                                    <div class="form-group">
                                        <label class="control-label col-md-2">公司人数：</label>
                                        <input id="title" type="text" class="control-label col-md-1" value=""/>
                                        <label class="control-label col-md-2">本科以上人员占比：</label>
                                        <input id="title" type="text" class="control-label col-md-1" value=""/>
                                        <label class="control-label col-md-2">硕士以上人员占比：</label>
                                        <input id="title" type="text" class="control-label col-md-1" value=""/>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">核心团队：</label>
                                        <div class="portlet-body">
                                            <table class="table table-striped table-hover table-bordered" id="sample_editable_1">
                                                <thead>
                                                <tr>
                                                    <th>
                                                        姓名
                                                    </th>
                                                    <th>
                                                        职位
                                                    </th>
                                                    <th>
                                                        学历
                                                    </th>
                                                    <th>
                                                        工作履历
                                                    </th>
                                                    <th>
                                                        编辑
                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>

                                                    </td>
                                                    <td>

                                                    </td>
                                                    <td>

                                                    </td>
                                                    <td class="center">

                                                    </td>
                                                    <td>
                                                        <a class="edit" href="javascript:;">
                                                            Edit </a>
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
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
                                <i class="fa fa-check"></i>资质荣誉<span class="label label-danger">手工录入，更新日期：2017/03/16</span>
                            </div>
                            <div class="actions btn-set">
                                <button class="btn green"><i class="fa fa-check"></i> 保存</button>
                                <button class="btn green"><i class="fa fa-check"></i> 编辑</button>
                            </div>
                        </div>
                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                            <form action="" class="form-horizontal form-row-seperated">
                                <div class="form-body">
                                    <div class="form-group">
                                        <div class="checkbox-list">
                                            <label for="chkbox">
                                                <input id="chkbox1" type="checkbox" value="checked" class="input-small"/>是否高新企业 </label>
                                            <label for="chkbox">
                                                <input id="chkbox2" type="checkbox" value="checked" class="input-small"/>是否地址重点扶持企业</label>
                                            <label for="chkbox">
                                                <input id="chkbox3" type="checkbox" value="checked" class="input-small"/>是否国家星火计划企业 </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">历史荣誉：</label>
                                        <textarea id="message"  class="control-label col-md-8" rows="5" value=""></textarea>
                                    </div>
                                </div>
                            </form>
                            <!-- END FORM-->
                        </div>
                    </div>
                    <div class="portlet box blue-steel">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-check"></i>市场发展情况<span class="label label-danger">手工录入，更新日期：2017/03/16</span>
                            </div>
                            <div class="actions btn-set">
                                <button class="btn green"><i class="fa fa-check"></i> 保存</button>
                                <button class="btn green"><i class="fa fa-check"></i> 编辑</button>
                            </div>
                        </div>
                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                            <form action="" class="form-horizontal form-row-seperated">
                                <div class="form-body">
                                    <div class="form-group">
                                        <label class="control-label col-md-3">国内市场占有率（百分比）：</label>
                                        <input id="title" type="text" class="control-label col-md-1" value=""/>
                                        <label class="control-label col-md-2">公司发展所属阶段：</label>
                                        <input id="title" type="text" class="control-label col-md-1" value=""/>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">归属载体类型：</label>
                                        <div class="col-md-4">
                                            <select class="form-control input-small select2me" data-placeholder="载体类型">
                                                <option value=""></option>
                                                <option value="yq">园区</option>
                                                <option value="fhq">孵化区</option>
                                                <option value="zckj">众创空间</option>
                                            </select>
                                        </div>
                                        <input id="title" type="text" class="control-label col-md-3" value="" placeholder="选择载体类型后输入载体名称"/>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">商业模式：</label>
                                        <textarea id="message"  class="control-label col-md-8" rows="5" value=""></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">核心竞争力：</label>
                                        <textarea id="message"  class="control-label col-md-8" rows="5" value=""></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">主要客户：</label>
                                        <input id="title" type="text" class="control-label col-md-2" value=""/>
                                        <input id="title" type="text" class="control-label col-md-2" value=""/>
                                        <input id="title" type="text" class="control-label col-md-2" value=""/>
                                        <input id="title" type="text" class="control-label col-md-2" value=""/>
                                        <input id="title" type="text" class="control-label col-md-2" value=""/>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-2">主要竞争对手：</label>
                                        <input id="title" type="text" class="control-label col-md-2" value=""/>
                                        <input id="title" type="text" class="control-label col-md-2" value=""/>
                                        <input id="title" type="text" class="control-label col-md-2" value=""/>
                                    </div>
                                </div>
                            </form>
                            <!-- END FORM-->
                        </div>
                    </div>
                    <div class="portlet box blue-steel">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-check"></i>融资需求<span class="label label-danger">手工录入，更新日期：2017/03/16</span>
                            </div>
                            <div class="actions btn-set">
                                <button class="btn green"><i class="fa fa-check"></i> 保存</button>
                                <button class="btn green"><i class="fa fa-check"></i> 编辑</button>
                            </div>
                        </div>
                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                            <form action="" class="form-horizontal form-row-seperated">
                                <div class="form-body">
                                    <div class="form-group">
                                        <div class="checkbox-list">
                                            <label for="closeButton">
                                                <input id="closeButton" type="checkbox" value="checked" class="input-small"/>是否地市上市储备企业 </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3">融资需求金额（万元）：</label>
                                        <input id="title" type="text" class="control-label col-md-1" value=""/>
                                    </div>
                                </div>
                            </form>
                            <!-- END FORM-->
                        </div>
                    </div>
                    <div class="portlet box blue-steel">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-check"></i>最近三年主要财务数据<span class="label label-danger">手工录入，更新日期：2017/03/16</span>
                            </div>
                            <div class="actions btn-set">
                                <button class="btn green"><i class="fa fa-check"></i> 保存</button>
                                <button class="btn green"><i class="fa fa-check"></i> 编辑</button>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-hover table-bordered">
                                    <thead>
                                    <tr>
                                        <th>
                                            年份
                                        </th>
                                        <th>
                                            营业收入
                                        </th>
                                        <th>
                                            净利润
                                        </th>
                                        <th>
                                            总资产
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>
                                            2014
                                        </td>
                                        <td>
                                            82114897.19
                                        </td>
                                        <td>
                                            1992802.41
                                        </td>
                                        <td>
                                            120915959.71
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            2015
                                        </td>
                                        <td>
                                            85897390.67
                                        </td>
                                        <td>
                                            2425654.94
                                        </td>
                                        <td>
                                            122776804.71
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            2016
                                        </td>
                                        <td>
                                            62211009.31
                                        </td>
                                        <td>
                                            988854.67
                                        </td>
                                        <td>
                                            124327319.54
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="portlet box blue-steel">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-check"></i>预计未来三年财务数据<span class="label label-danger">手工录入，更新日期：2017/03/16</span>
                            </div>
                            <div class="actions btn-set">
                                <button class="btn green"><i class="fa fa-check"></i> 保存</button>
                                <button class="btn green"><i class="fa fa-check"></i> 编辑</button>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-hover table-bordered">
                                    <thead>
                                    <tr>
                                        <th>
                                            年份
                                        </th>
                                        <th>
                                            营业收入
                                        </th>
                                        <th>
                                            净利润
                                        </th>
                                        <th>
                                            总资产
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>
                                            2017
                                        </td>
                                        <td>
                                            82114897.19
                                        </td>
                                        <td>
                                            1992802.41
                                        </td>
                                        <td>
                                            120915959.71
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            2018
                                        </td>
                                        <td>
                                            85897390.67
                                        </td>
                                        <td>
                                            2425654.94
                                        </td>
                                        <td>
                                            122776804.71
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            2019
                                        </td>
                                        <td>
                                            62211009.31
                                        </td>
                                        <td>
                                            988854.67
                                        </td>
                                        <td>
                                            124327319.54
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="portlet box green-haze">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-check"></i>服务数据记录<span class="label label-danger">手工录入，更新日期：2017/04/28</span>
                            </div>
                            <div class="actions btn-set">
                                <button class="btn green"><i class="fa fa-check"></i> 保存</button>
                                <button class="btn green"><i class="fa fa-check"></i> 编辑</button>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="tabbable-custom nav-justified">
                                <ul class="nav nav-tabs nav-justified">
                                    <li class="active">
                                        <a href="#tab_1_1_1" data-toggle="tab">
                                            企业上云 </a>
                                    </li>
                                    <li>
                                        <a href="#tab_1_1_2" data-toggle="tab">
                                            高企认证 </a>
                                    </li>
                                    <li>
                                        <a href="#tab_1_1_3" data-toggle="tab">
                                            FA业务 </a>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tab_1_1_1">
                                        <span>企业上云数据</span>
                                    </div>
                                    <div class="tab-pane" id="tab_1_1_2">
                                        <span>高企认证数据</span>
                                    </div>
                                    <div class="tab-pane" id="tab_1_1_3">
                                        <span>FA业务数据</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!-------------------页面tree菜单右边展示区域，由开发者自由编写：END-->
    </div>

    <!-- 页面中部区域层：END-->
</div>

<!-- BEGIN 框架效果 -->
<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<script type="text/javascript" src="/dist/js/select2.min.js"></script>
<script type="text/javascript" src="/dist/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/dist/js/dataTables.bootstrap.js"></script>
<script src="/dist/js/table-editable.js"></script>
<!-- added by yingsl on 20170523 -->

<script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        Demo.init(); // init demo features
    });

</script>
</body>
</html>

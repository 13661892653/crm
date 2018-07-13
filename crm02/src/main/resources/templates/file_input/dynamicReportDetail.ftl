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
    <link href="/dist/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="/dist/css/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <link href="/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/dist/css/uniform.default.css" rel="stylesheet" type="text/css" />
    <link href="/dist/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
    <link href="/dist/css/components.css" id="style_components" rel="stylesheet" type="text/css" />
    <link href="/dist/css/plugins1.css" rel="stylesheet" type="text/css" />
    <link href="/dist/css/layout.css" rel="stylesheet" type="text/css" />
    <!-- <link href="/dist/css/default.css" rel="stylesheet" type="text/css" id="style_color" /> -->
    <link href="/dist/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color" />
    <link href="/dist/css/custom.css" rel="stylesheet" type="text/css" />
    <!-- added by yingsl on 20170523 -->
    <link href="/dist/css/enterprisebank.css" rel="stylesheet" type="text/css" />
    <link href="/dist/css/jquery-ui.min.css" rel="stylesheet">
    <link href="/css/dynamicReport/style.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .laydate-icon{font-size: inherit;}
    </style>
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
                            <#if '${user.memberType}'=='11'>
                                <a href="#">初录</a>
                            </#if>
                            <#if '${user.memberType}'=='12'>
                                <a href="#">复录</a>
                            </#if>
                        </li>
                    </ul>
                </div>
                <!-- BEGIN 数据展示区-->
                <div class="portlet">
                    <div class="portlet-body">
                        <div class="container">
                            <h3 class="retitle"></h3>
                            <form id="posttable" class="form-inline">
                                <div class="reportTitle"></div>
                                <div class="pure-control-group">
                                    <label for="enterpriseName">企业名称</label>
                                    <input id="enterpriseName" type="text" name="enterpriseName" placeholder="" required>
                                    <p class="msg">必填项</p>
                                </div>
                                <div class="pure-control-group">
                                    <label for="date">报表时间</label>
                                    <input readonly="readonly" id="date" class="laydate-icon" name="date" type="text" required style="font-family: inherit!important;font-size: inherit;">
                                    <p class="msg">必填项</p>
                                </div>
                                <div class="tablebox table_style table-responsive">
                                    <table class="table table-bordered" width="100%" border="1" cellspacing="0" cellpadding="0">
                                        <tbody id="areaTable"></tbody>
                                    </table>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <div class="btn btn-success submit" data-submitId="1">提交</div>
                                    </div>
                                </div>
                            </form>
                        </div>
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
    <script src="/js/dynamicReport/easy.js"></script>
    <script src="/js/dynamicReport/handsontable.full.min.js"></script>
    <script src="/js/dynamicReport/jquery.validate.js"></script>
    <script src="/js/dynamicReport/laydate.js"></script>
    <script>
        laydate.render({
            elem: '#date', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            type: 'month',
            done: function(v, d) {
                $('#date').next('.msg').css('visibility','hidden');
            }
        });
    </script>

    <script>
        var reportId= ${fiDynamicReportApiReq.reportId?c} ;
        var reqId= ${fiDynamicReportApiReq.id?c} ;
    </script>
    <script src="/js/dynamicReport/jsread.js"></script>
    <script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        try {
            Demo.init();
        } catch (err) {}
    });
    </script>

    <script type="text/html" id="areaTable_tmpl">
        <%for ( var i = 0; i < getAreaTable.length; i++ ) { var e=getAreaTable[i];%>
            <%if(i==0){%>
                <tr class="title">
                    <% }else{%>
                        <tr>
                            <% }%>
                                <% for ( var j = 0; j < e.length; j++ ) { var e1=e[j];%>
                                    <th>
                                        <%if(e1.type=="input"){%>
                                            <input type="text" name="<%=e1.content%>" required placeholder="请填写" />
                                            <p class="msg">必填项</p>
                                            <% }else{%>
                                                <%=e1.content%>
                                                    <% }%>
                                    </th>
                                    <% } %>
                        </tr>
                        <% } %>
    </script>
</body>

</html>
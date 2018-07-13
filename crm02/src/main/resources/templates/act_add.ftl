<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js" xmlns="http://www.w3.org/1999/html">
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
    <link rel="stylesheet" type="text/css" href="/dist/plugins/webuploader/dist/webuploader.css">

</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<!-- 引入页面头部主菜单 -->
<#assign page=26/>
<#include "top_menu.ftl"/>

<!-- 仪表盘页面中部区域层：BEGIN-->
<div class="page-container">
    <!--引入页面左边菜单tree-->
<#include "left_menu.ftl"/>
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
                        <a href="#">营销管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">活动管理</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#">新增活动</a>
                    </li>
                </ul>
            </div>
            <!-- BEGIN 新增订单-->
            <div class="portlet">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-check"></i>新增活动
                    </div>
                </div>
                <div class="portlet-body form">

                    <form id="addAct" action="/activity/detail?recId=${crmActive.recId!""}" method="post" class="form-horizontal form-row-sepe">
                        <div class="form-body">
                            <div class="form-group">
                                <label class="control-label col-md-2">活动归类：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="bizLv1Id" name="bizLv1Id" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="G" <#if (crmActive.bizLv1Id?? && crmActive.bizLv1Id=="G")> selected </#if>>G</option>
                                        <option value="T" <#if (crmActive.bizLv1Id?? && crmActive.bizLv1Id=="T")> selected </#if>>T</option>
                                        <option value="F" <#if (crmActive.bizLv1Id?? && crmActive.bizLv1Id=="F")> selected </#if>>F</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">活动名：<span class="required">* </span></label>
                                <input id="actName" name="actName" type="text" class="form-control input-large" value="${crmActive.actName!""}"/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">我司角色：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="usRole" name="usRole" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="JB01" <#if (crmActive.usRole?? && crmActive.usRole=="JB01")> selected </#if>>主办方</option>
                                        <option value="JB02" <#if (crmActive.usRole?? && crmActive.usRole=="JB02")> selected </#if>>承办方</option>
                                        <option value="JB03" <#if (crmActive.usRole?? && crmActive.usRole=="JB03")> selected </#if>>协办方</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">活动类型：<span class="required">* </span></label>
                                <div class="col-md-2">
                                    <select id="actType" name="actType" class="bs-select form-control" data-placeholder="请选择">
                                        <option value="" disabled selected hidden>Please Choose</option>
                                        <option value="AT01" <#if (crmActive.actType?? && crmActive.actType=="AT01")> selected </#if> >培训</option>
                                        <option value="AT02"<#if (crmActive.actType?? && crmActive.actType=="AT02")> selected </#if> >约咖</option>
                                        <option value="AT03"<#if (crmActive.actType?? && crmActive.actType=="AT03")> selected </#if> >会销</option>
                                        <option value="AT04"<#if (crmActive.actType?? && crmActive.actType=="AT04")> selected </#if> >大赛</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">活动开展时间：<span class="required">* </span></label>
                                <div class="col-md-4">
                                    <input readonly="readonly" id="beginTime" name="beginTime" type="text" class="laydate-icon" style="width:200px; margin-right:10px;" value="${crmActive.beginTime!""}"/>
                                    <span>到</span>
                                    <input readonly="readonly" id="endTime" name="endTime" type="text" class="laydate-icon" style="width:200px;" value="${crmActive.endTime!""}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">活动举办地点：<span class="required">* </span></label>
                                    <input id="actLocation" name="actLocation" type="text" class="form-control input-medium" value="${crmActive.actLocation!""}"/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">合作方：</label>
                                <input id="coPartner" name="coPartner" type="text" class="form-control input-large" value="${crmActive.coPartner!""}"/>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">活动费用：<span class="required">* </span></label>
                                <input id="actFee" name="actFee" type="text" class="control-label col-md-1" value="${crmActive.actFee?c!""}"/><label class="control-label"><span style="color:#ff0000;font-weight: bold">（元）</span></label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">参与人数：<span class="required">* </span></label>
                                <input id="joinPersons" name="joinPersons" readonly type="text" class="control-label col-md-1" value="${crmActive.joinPersons!""}"/><label class="control-label"><span style="color:#ff0000;font-weight: bold">（人）</span></label>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">备注：</label>
                                <textarea id="remark" name="remark" class="control-label col-md-4" rows="5" >${crmActive.remark!""}</textarea>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-2">活动照片：</label>

                                <div class="row">
                                    <div class="col-xs-9 col-xs-offset-2">
                                        <div id="uploader-demo">
                                            <div id="filePicker">选择图片</div>
                                            <div id="list" class="row">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="control-label col-md-2">活动名单：</label>
                                <div class="row">
                                    <div class="col-xs-9 col-xs-offset-2">
                                        <div id="uploader-demo">
                                            <div class="col-xs-3">
                                                <div id="filePicker2">选择excel</div>
                                            </div>

                                            <div class="col-xs-3">
                                                <a class="btn btn-default" href="/resource/demo.xlsx">下载模板</a>
                                            </div>
                                            <table class="table table-bordered table-hover" >
                                                <thead>
                                                <tr>
                                                    <th>
                                                        公司名
                                                    </th>
                                                    <th>
                                                        客户姓名
                                                    </th>
                                                    <th>
                                                        手机
                                                    </th>
                                                    <th>
                                                        操作
                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody id="tableExcel">
                                                </tbody>

                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-actions">
                                <div class="row">
                                    <input type="hidden" name="excelJson" id="excelJson">
                                    <input type="hidden" name="imageJson" id="imageJson">
                                    <input type="hidden" name="actNo" value="${crmActive.actNo!""}">
                                    <div class="col-md-offset-3 col-md-4">
                                        <#if (user.company!="总部")>
                                        <input type="button" value="提交" class="btn purple" id="btn_addact" onclick="clickbtn(this)"/>
                                        </#if>
                                        <input type="button" value="取消" class="btn default" id="btn_celact" onclick="clickbtn(this)"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- END FORM-->
                </div>
            </div>
            <!-- END 新增订单-->
        </div>
    </div>

    <!-- 页面中部区域层：END-->
</div>

<!-- BEGIN 框架效果 -->
<script src="/dist/js/jquery.min.js" type="text/javascript"></script>
<script src="/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/dist/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/dist/js/metronic.js" type="text/javascript"></script>
<script src="/dist/js/layout.js" type="text/javascript"></script>
<script src="/dist/js/crm.js?v=1.1"></script>
<script src="/dist/js/laydate/laydate.js"></script>
<script type="text/javascript" src="/dist/plugins/webuploader/dist/webuploader.js"></script>

<script>
    jQuery(document).ready(function() {
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        //Demo.init(); // init demo features
    });
    laydate({
        elem: '#beginTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
    laydate({
        elem: '#endTime', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });


    var imageObj= {
        data:[],
        add:function (fileName) {
            var exist=0;
            for(var i=0; i<this.data.length; i++) {
                if(this.data[i] == fileName) {
                    exist=1;
                    break;
                }
            }
            if(exist==0){
                this.data.push(fileName);
            }
            this.refresh();
        },
        del:function (fileName) {
            for(var i=0; i<this.data.length; i++) {
                if(this.data[i] == fileName) {
                    this.data.splice(i, 1);
                    break;
                }
            }
            this.refresh();
        },
        refresh:function () {
            $("#list").html("");
            for(var i=0; i<this.data.length; i++) {
                $("#list").append("\n" +
                        "                                        <div class=\"col-xs-3\">\n" +
                        "                                            <img src=\"/resource/"+this.data[i]+"\" width=\"100%\">\n" +
                        "                                            <button type=\"button\" class=\"btn btn-default imageDel\" data-fileName=\""+this.data[i]+"\">删除</button>\n" +
                        "                                        </div>");
            }
        }
    };
    $("#list").on("click",".imageDel",function () {
       imageObj.del($(this).attr("data-fileName"));
    });
    //*************上传*****************
    var uploader = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: true,
        // swf文件路径
        swf: '/dist/webuploader/dist/Uploader.swf',
        // 文件接收服务端。
        server: '/file/uploadImage',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#filePicker',
        // 只允许选择图片文件。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        },
        duplicate:true
    });
    uploader.on('uploadSuccess', function (file, response) {
        console.log(response); //这里可以得到后台返回的数据
        file.serverName=response;
        imageObj.add(response._raw);
    });
    uploader.on('error', function (type) {
        console.log(type); //这里可以得到后台返回的数据
    });
    //********************************

    var excelObj={
        data:[],
        add:function (obj) {
            for(var i=0;i<obj.length;i++){
                var exist=0;
                var othObj=obj[i];
                for(var j=0;j<this.data.length;j++){
                    var myobj=this.data[j];
                    if(othObj.company==myobj.company&&othObj.name==myobj.name&&othObj.mobile==myobj.mobile){
                        exist=1;
                    }
                }
                if(exist==0){
                    this.data.push(othObj);
                }
            }
            this.refresh();
        },
        del:function (obj) {
            for(var i=0; i<this.data.length; i++) {
                var myobj=this.data[i];
                if(obj.company==myobj.company&&obj.name==myobj.name&&obj.mobile==myobj.mobile){
                    this.data.splice(i, 1);
                    break;
                }
            }
            this.refresh();
        },
        refresh:function () {
            $("#joinPersons").val(this.data.length);
            $("#tableExcel").html("");
            for(var i=0;i<this.data.length;i++){
                var myobj=this.data[i];
                $("#tableExcel").append("<tr>\n" +
                        "                                            <td>\n" +
                        "                                                "+myobj.company+"\n" +
                        "                                            </td>\n" +
                        "                                            <td>\n" +
                        "                                                "+myobj.name+"\n" +
                        "                                            </td>\n" +
                        "                                            <td>\n" +
                        "                                                "+myobj.mobile+"\n" +
                        "                                            </td>\n" +
                        "                                            <td>\n" +
                        "                                                <button type=\"button\" class=\"delExcel\" company=\""+myobj.company+"\" uname=\""+myobj.name+"\" mobile=\""+myobj.mobile+"\">删除</button>\n" +
                        "                                            </td>\n" +
                        "                                        </tr>");
            }

        }
    };
    $("#tableExcel").on("click",".delExcel",function () {
        var obj={company:$(this).attr("company"),name:$(this).attr("uname"),mobile:$(this).attr("mobile")};
        excelObj.del(obj);
    })
    var uploader2 = WebUploader.create({
        // 选完文件后，是否自动上传。
        auto: true,
        // swf文件路径
        swf: '/dist/webuploader/dist/Uploader.swf',
        // 文件接收服务端。
        server: '/file/uploadActivityExcel',
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#filePicker2',
        // 只允许选择图片文件。
        accept: {
            title: 'excel',
            extensions: 'xls,xlsx',
//            mimeTypes:'application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
            mimeTypes:'application/vnd.sealed-xls',
        },
        threads :1,
        duplicate:true
    });
    uploader2.on('uploadSuccess', function (file, response) {
        if(response.code!=200){
            alert(response.msg);
            return;
        }
        console.log(response); //这里可以得到后台返回的数据
        excelObj.add(response.data);
    });
    uploader2.on('error', function (type) {
        switch (type){
            case "Q_EXCEED_NUM_LIMIT":
                alert("同时只能上传一个文件");
                break;
            case  "Q_EXCEED_SIZE_LIMIT ":
                alert("文件太大");
                break;
            case "Q_TYPE_DENIED":
                alert("支持excel");
                break;
        }
    });

    <#if (crmActive.excelJson?? && crmActive.excelJson!="")>
    excelObj.data=${crmActive.excelJson};
    excelObj.refresh();
    </#if>

    <#if (crmActive.imageJson?? && crmActive.imageJson!="")>
    imageObj.data=${crmActive.imageJson};
    imageObj.refresh();
    </#if>
</script>
</body>
</html>
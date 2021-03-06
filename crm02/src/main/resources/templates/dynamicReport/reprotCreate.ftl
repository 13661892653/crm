<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title></title>
    <link href="/css/dynamicReport/easy.css" rel="stylesheet" type="text/css">
    <link href="/css/dynamicReport/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/css/dynamicReport/form.css">
    <link href="/css/dynamicReport/style.css" rel="stylesheet" type="text/css">
    <link href="/css/dynamicReport/handsontable.full.min.css" rel="stylesheet" type="text/css">
</head>

<body>
<form class="pure-form pure-form-aligned">
    <fieldset>
        <div class="pure-control-group">
            <label for="name">报表名称</label>
            <input id="report_title" type="text" placeholder="报表名称">
        </div>
        <div class="pure-control-group">
            <label for="interfaceUrl">接口连接</label>
            <input id="interfaceUrl" type="text" placeholder="接口连接">
        </div>
        <div class="pure-control-group">
            <label for="interfaceUrl">验签规则</label>
            <select name="signClassName" style="padding: 0;">
                <option value="empty">无规则</option>
                <option value="kejidai">php验签规则</option>
            </select>
        </div>
        <div class="pure-controls">
            <label><input type="checkbox" name="autosave" id="needCheck" checked="false" autocomplete="off">是否需要复核</label>
            </label>
            <!-- <button type="submit" class="pure-button pure-button-primary">Submit</button> -->
        </div>
    </fieldset>
</form>
<div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand">自定义表单</a>
</div>
<div class="collapse navbar-collapse">
    <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
            <input type="text" id="a" class="form-control" placeholder="行" value="">
        </div>
        <div class="form-group">
            <input type="text" id="b" class="form-control" placeholder="列" value="">
        </div>
        <button type="button" class="btn btn-default createTable">生成表格</button>
        <button name="save" id="save" class="intext-btn btn btn-success" type="button">提交</button>
        <label>
            <input type="checkbox" name="autosave" id="autosave" checked="checked" autocomplete="off">Autosave</label>
    </form>
    <!-- <button name="load" id="load" class="intext-btn">Load</button> -->
</div>
<pre id="example1console" class="console"></pre>
<div id="example"></div>
<script src="/js/dynamicReport/jquery.js"></script>
<script src="/js/dynamicReport/easy.js"></script>
<script src="/js/dynamicReport/handsontable.full.min.js"></script>
<script src="/js/dynamicReport/js.js"></script>
</body>

</html>
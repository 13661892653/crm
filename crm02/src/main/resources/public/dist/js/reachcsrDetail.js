// 无效保存按钮
if($("#rchNo").val()!=""){
    $("#btn_addrch").hide();
}
$((".custType")).change(function () {
    switch ($(this).val()){
        case "corpCust":
            window.location.href="/reachcsr/corpdetail";
            break;
        case "unCorpCust":
            window.location.href="/reachcsr/notcorpdetail";
            break;
        case "govCust":
            window.location.href="/reachcsr/govdetail";
            break;
    }

});
//取消按钮
$("#btn_celrch").click(function () {
    window.location.href="/crm/marketing/reachcsr/reachlist"
});
//****************************************************************
//* 名　　称：DataLength
//* 功    能：计算数据的长度
//* 入口参数：fData：需要计算的数据
//* 出口参数：返回fData的长度(Unicode长度为2，非Unicode长度为1)
//*****************************************************************
function DataLength(fData)
{
    var intLength=0
    for (var i=0;i<fData.length;i++)
    {
        if ((fData.charCodeAt(i) < 0) || (fData.charCodeAt(i) > 255))
            intLength=intLength+1
        else
            intLength=intLength+1
    }
    return intLength
}
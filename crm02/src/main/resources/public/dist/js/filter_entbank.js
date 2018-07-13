// 分类选择
var industryname = 'all';

$('.classification').on('click', '.body span', function() {
    $(this).addClass('cur').siblings().removeClass('cur');
    $(this).parent('.body').siblings('.head').children('span').removeClass('all');
});
$('.classification').on('click', '.head span', function() {
    $(this).addClass('all');
    $(this).parent('.head').siblings('.body').children('span').removeClass('cur');
});

$('.industry-box').on('click', '.classB li', function(){
    industryname = $(this).text();
    $('#industryName').val(industryname);
    $('#entBankCond').submit();
});

$('.industryName span').click(function() { //对所属行业来说，实际是点击了"全部"
    industryname = 'all';
    $('#industryName').val(industryname);
    $('#entBankCond').submit();
});

/**
$('.assetsFlag span').click(function() {
    var assetsFlagVal = $(this).attr('data-value');
    $('#assetsFlag').val(assetsFlagVal);
    $('#entBankCond').submit();
});
 */

$('.regionCode span').click(function() {
    var regionCodeVal = $(this).attr('data-value');
    $('#regionCode').val(regionCodeVal);
    $('#entBankCond').submit();
});

$('.isHaveFinance span').click(function() {
    var isHaveFinanceVal = $(this).attr('data-value');
    $('#isHaveFinance').val(isHaveFinanceVal);
    $('#entBankCond').submit();
});

$('.bankGqScore span').click(function() {
    var bankGqScore = $(this).attr('data-value');
    $('#beginScore').val("all");
    $('#endScore').val("all");
    $('#entBankCond').submit();
});
$("#beginTmpScore").blur(function () {
    $('#beginScore').val($("#beginTmpScore").val());
    $('#endScore').val($("#endTmpScore").val());
    $('#entBankCond').submit();
});
$("#endTmpScore").blur(function () {
    $('#beginScore').val($("#beginTmpScore").val());
    $('#endScore').val($("#endTmpScore").val());
    $('#entBankCond').submit();
});


$('.isSetEntSrv span').click(function() {
    var isSetEntSrvVal = $(this).attr('data-value');
    $('#isSetEntSrv').val(isSetEntSrvVal);
    $('#entBankCond').submit();
});

$('.assetsLevel span').click(function() {
    var assetsLevelVal = $(this).attr('data-value');
    $('#assetsLevel').val(assetsLevelVal);
    $('#entBankCond').submit();
});

$('.entTag span').click(function() {
    var tagCodeVal = $(this).attr('data-value');
    $('#assetsTagCode').val(tagCodeVal);
    $('#entBankCond').submit();
});

$('.entType span').click(function() {
    var entType = $(this).attr('data-value');
    $('#entType').val(entType);
    $('#entBankCond').submit();
});

//$('.portlet-body').on('click', '.green-stripe', function() {
//    window.open("/crm/enterprisedetail","_blank","toolbar=no, location=no, titlebar=no,directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=yes, left=1100,width=800, height=800")
//});

$('.form-group').on('click', '.search', function() {
    var corpNameVal = $(this).siblings('input[type="text"]').val().replace(/\s+/g,"");
    $('#corpName').val(corpNameVal);
    $('#entBankCond').submit();
});

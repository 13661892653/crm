// 分类选择
$('.classification').on('click', '.body span', function() {
    $(this).addClass('cur').siblings().removeClass('cur');
});
$('.classification').on('click', '.body span', function() {
    $(this).parent('.head').siblings('.body').children().removeClass('cur');
});

$('.assetsFlag span').click(function() {
    var assetsFlagVal = $(this).attr('data-value');
    $('#assetsFlag').val(assetsFlagVal);
    $('#filterCond').submit();
});
$('.regionCode span').click(function() {
    var regionCodeVal = $(this).attr('data-value');
    $('#regionCode').val(regionCodeVal);
    $('#filterCond').submit();
});

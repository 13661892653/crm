$('.classification').on('click', '.body span', function() {
    $(this).addClass('cur').siblings().removeClass('cur');
    $(this).parent('.body').siblings('.head').children('span').removeClass('all');
});
$('.classification').on('click', '.head span', function() {
    $(this).addClass('all');
    $(this).parent('.head').siblings('.body').children('span').removeClass('cur');
});

$('.regionCode span').click(function() {
    var regionCodeVal = $(this).attr('data-value');
    $('#regionCode').val(regionCodeVal);
    $('#partnerCond').submit();
});

$('.form-group').on('click', '.search', function() {
    var corpNameVal = $(this).siblings('input[type="text"]').val().replace(/\s+/g,"");
    $('#corpName').val(corpNameVal);
    $('#partnerCond').submit();
});
$('.classification').on('click', '.body span', function() {
    $(this).addClass('cur').siblings().removeClass('cur');
    $(this).parent('.body').siblings('.head').children('span').removeClass('all');
});
$('.classification').on('click', '.head span', function() {
    $(this).addClass('all');
    $(this).parent('.head').siblings('.body').children('span').removeClass('cur');
});

$('.entType span').click(function() {
    var entType = $(this).attr('data-value');
    $('#entType').val(entType);
    $('#favListCond').submit();
});


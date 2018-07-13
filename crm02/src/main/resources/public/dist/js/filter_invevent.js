// 分类选择
var invtimebegin = 'all'; //开始时间
var invtimeend = 'all';   //结束时间

$('.classification').on('click', '.body span', function() {
    $(this).addClass('cur').siblings().removeClass('cur');
    $(this).parent('.body').siblings('.head').children('span').removeClass('all');
});
$('.classification').on('click', '.head span', function() {
    $(this).addClass('all');
    $(this).parent('.head').siblings('.body').children('span').removeClass('cur');
});

$('.invTime span').click(function() {
    invtimebegin = 'all';
    invtimeend = 'all';
    $('#invTimeBegin').val(invtimebegin);
    $('#invTimeEnd').val(invtimeend);
    $('#invEventCond').submit();
});

$('.regionCode span').click(function() {
    var regionCodeVal = $(this).attr('data-value');
    $('#regionCode').val(regionCodeVal);
    $('#invEventCond').submit();
});

// 融资时间选择
$('#startDate').datepicker({
    changeMonth: true,
    changeYear: true,
    dateFormat: 'yy-mm-dd',
    onSelect: function(startVal) {
        var endVal = $('#endDate').val();
        if (endVal) {
            var startTime = (new Date(startVal)).getTime();
            var endTime = (new Date(endVal)).getTime();
            var diff = endTime - startTime;
            if (diff < 0) {
                alert('结束时间必须大于开始时间');
                $(this).val('');
            } else {
                // console.log(startVal, endVal);
                $('#invTimeBegin').val(startVal);
                $('#startTime').val(startVal);
                $('#invEventCond').submit();
                $('#selectTime').submit();
            }
        } else {
            $('#invTimeBegin').val(startVal);
            $('#startTime').val(startVal);
        }
    }
});

$('#endDate').datepicker({
    changeMonth: true,
    changeYear: true,
    dateFormat: 'yy-mm-dd',
    onSelect: function(endVal) {
        var startVal = $('#startDate').val();
        if (startVal) {
            var startTime = (new Date(startVal)).getTime();
            var endTime = (new Date(endVal)).getTime();
            var diff = endTime - startTime;
            if (diff < 0) {
                alert('结束时间必须大于开始时间');
                $(this).val('');
            } else {
                //console.log(startVal, endVal);
                $('#invTimeEnd').val(endVal);
                $('#endTime').val(endVal);
                $('#invEventCond').submit();
                $('#selectTime').submit();
            }
        } else {
            alert('请选择开始时间');
            $('#invTimeEnd').val(endVal);
            $('#endTime').val(endVal);
        }
    }
});
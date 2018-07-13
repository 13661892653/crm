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
    $('#dataReportCond').submit();
});

$('.selectTime span').click(function() {
    timebegin = 'all';
    timebegin = 'all';
    $('#timeBegin').val(timebegin);
    $('#timeEnd').val(timebegin);
    $('#dataReportCond').submit();
});

// 时间选择
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
                $('#timeBegin').val(startVal);
                $('#startTime').val(startVal);
                $('#dataReportCond').submit();
                $('#selectTime').submit();
            }
        } else {
            $('#timeBegin').val(startVal);
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
                $('#timeEnd').val(endVal);
                $('#endTime').val(endVal);
                $('#dataReportCond').submit();
                $('#selectTime').submit();
            }
        } else {
            alert('请选择开始时间');
            $('#timeEnd').val(endVal);
            $('#endTime').val(endVal);
        }
    }
});
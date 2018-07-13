$('.classification').on('click', '.body span', function() {
    $(this).addClass('cur').siblings().removeClass('cur');
    $(this).parent('.body').siblings('.head').children('span').removeClass('all');
});

$('.classification').on('click', '.head span', function() {
    $(this).addClass('all');
    $(this).parent('.head').siblings('.body').children('span').removeClass('cur');
});

$('.bizLv1Id span').click(function() {
    var bizLv1Id = $(this).attr('data-value');
    $('#bizLv1Id').val(bizLv1Id);
    $('#reachListCond').submit();
});
$('.bizLv2Id span').click(function() {
    var bizLv2Id = $(this).attr('data-value');
    $('#bizLv2Id').val(bizLv2Id);
    $('#reachListCond').submit();
});

$('.hasDemand span').click(function() {
    var hasDemand = $(this).attr('data-value');
    $('#hasDemand').val(hasDemand);
    $('#reachListCond').submit();
});

$('.winCustChnl span').click(function() {
    var winCustChnl = $(this).attr('data-value');
    $('#winCustChnl').val(winCustChnl);
    $('#reachListCond').submit();
});

$('.rchTime span').click(function() {
    timebegin = 'all';
    timebegin = 'all';
    $('#timeBegin').val(timebegin);
    $('#timeEnd').val(timebegin);
    $('#reachListCond').submit();
});

$('.empName span').click(function() {
    var employee = $(this).attr('data-value');
    $('#empName').val(employee);
    $('#reachListCond').submit();
});

$('.custType span').click(function() {
    var custType = $(this).attr('data-value');
    $('#custType').val(custType);
    $('#reachListCond').submit();
});

$('.entType span').click(function() {
    var entType = $(this).attr('data-value');
    $('#entType').val(entType);
    $('#reachListCond').submit();
});

$('.entTag span').click(function() {
    var entType = $(this).attr('data-value');
    $('#assetsTagCode').val(entType);
    $('#reachListCond').submit();
});

$('.form-group').on('click', '.search', function() {
    var corpNameVal = $(this).siblings('input[type="text"]').val().replace(/\s+/g,"");
    $('#corpName').val(corpNameVal);
    $('#reachListCond').submit();
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
                $('#reachListCond').submit();
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
                $('#reachListCond').submit();
                $('#selectTime').submit();
            }
        } else {
            alert('请选择开始时间');
            $('#timeEnd').val(endVal);
            $('#endTime').val(endVal);
        }
    }
});
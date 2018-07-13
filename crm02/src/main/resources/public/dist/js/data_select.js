// 地区选择
var $area = $('.area');
$.ajax({
    url: "../dist/js/cityData.json",
    type: "get",
    dataType: 'json',
    success: function(data) {
        var province = [];
        var provinceLength = data.length;
        for (var i = 0; i < provinceLength; i++) {
            var p = '<li><div class="province" data-value="' + i + '"><span>' + data[i].n + '</span></div><div class="city-box" style="display: none;"></div></li>';
            province.push(p);
        }
        $area.html(province);
        $area.on('click', '.province', function(e) {
            var idc = $(this).attr('data-value');
            var cityLength = data[idc].s.length;
            var city = [];
            for (var j = 0; j < cityLength; j++) {
                var c = ' <span>' + data[idc].s[j].n + '</span>';
                city.push(c);
            }
            $(this).siblings('.city-box').html(city).show();
            $(this).parent().siblings().find('.city-box').hide();
            e.stopPropagation();
        });
    }
});

$('#area p').click(function(e) {
    $('.area-panel').show();
    e.stopPropagation();
});
$('#area').on('click', '.all em', function() {
    $('#area p').text($(this).text());
    $('.area-panel').hide();
});
$area.on('click', '.city-box span', function() {
    $('#area p').text($(this).text());
    $('.area-panel').hide();
});

$('.wrapper').click(function() {
    $('.area-panel').hide();
});


// 年限
$('#age p').click(function(e) {
    $('.age-panel').show();
    e.stopPropagation();
});
$('#age').on('click', '.all em', function() {
    $('#age p').text($(this).text());
    $('.age-panel').hide();
});
$('#age').on('click', '.age li', function() {
    $('#age p').text($(this).text());
    $('.age-panel').hide();
});
$('.wrapper').click(function() {
    $('.age-panel').hide();
});
// 行业类别
//
var listed = [],
    others = [];
$.ajax({
    url: "../dist/js/industryData.json",
    type: "get",
    dataType: 'json',
    success: function(data) {
        var qt = data[0]; // 其他
        var ss = data[1]; // 上市挂牌储备分类
        var ssLenA = ss.length;
        var qtLenA = qt.length;

        for (var i = 0; i < ssLenA; i++) {
            var ssLenB = ss[i].classB.length;
            var ssClassB = [];
            for (var j = 0; j < ssLenB; j++) {
                var sv = '<li>' + ss[i].classB[j] + '</li>';
                ssClassB.push(sv);
            }
            var st = '<li><div class="classA arrow-right">' + ss[i].classA + '</div><ul class="classB">' + ssClassB.join('') + '</ul></li>';
            listed.push(st);
        }

        /**
        for (var m = 0; m < qtLenA; m++) {
            var qtLenB = qt[m].classB.length;
            var qtClassB = [];
            for (var n = 0; n < qtLenB; n++) {
                var sq = '<li>' + qt[m].classB[n] + '</li>';
                qtClassB.push(sq);
            }
            var sk = '<li><div class="classA arrow-right">' + qt[m].classA + '</div><ul class="classB">' + qtClassB.join('') + '</ul></li>';
            others.push(sk);
        }
         */

        $('.industry-box').html(listed);
        /**
        $('#gategory-ss').click(function() {
            $('.industry-box').html(listed);
            $('#allIndustry').addClass('all');
            $('.industry p').text('请选择行业类别');
        });
        $('#gategory-cs, #gategory-fc, #gategory-fo, #gategory-all').click(function() {
            $('.industry-box').html(others);
            $('#allIndustry').addClass('all');
            $('.industry p').text('请选择行业类别');
        })
         */
    }
});


$('#industry').on('mouseenter', '.industry-box > li', function() {
    $(this).find('.classB').show();
    $(this).find('.classA').removeClass('arrow-right');
}).on('mouseleave', '.industry-box > li', function() {
    $(this).find('.classB').hide();
    $(this).find('.classA').addClass('arrow-right');
});
$('#industry>p').click(function(e) {
    $('.industry-panel').show();
    e.stopPropagation();
});
$('#industry').on('click', '.all em', function() {
    $('#industry p').text($(this).text());
    $('.industry-panel').hide();
});
$('#industry').on('click', '.classB li', function() {
    $('#industry>p').text($(this).text());
    $('.industry-panel').hide();
});

//
$('.screen>p').click(function() {
    $(this).parent().siblings().find('.dropdown-panel').hide();
});

//
//
$('.classification').on('click', '.industry>p', function(e) {
    $(this).siblings().show();
    e.stopPropagation();
});
$('.classification').on('mouseenter', '.industry-box > li', function() {
    $(this).find('.classB').show();
    $(this).find('.classA').removeClass('arrow-right');
}).on('mouseleave', '.industry-box > li', function() {
    $(this).find('.classB').hide();
    $(this).find('.classA').addClass('arrow-right');
});
$('.classification').on('click', '.classA', function(e) {
    e.stopPropagation();
});

$('.classification').on('click', '.classB li', function() {
    var str1 = $(this).text();
    var str2 = $(this).parent().siblings('.classA').text();
    $('.industry>p').text(str1);
    $('.industry-panel').hide();
    $('#allIndustry').removeClass('all');
});

$('.page-container').click(function() {
    $('.industry-panel').hide();
});

$('#allIndustry').click(function() {
    $(this).parent().siblings('.body').find('.industry>p').text('请选择行业类别');
});

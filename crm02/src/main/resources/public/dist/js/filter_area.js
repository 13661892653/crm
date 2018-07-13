var username = '';
var memberid = '';
var industryname = '';
var shownumber = 0;
var filterlist = new Array();
var spanValList = new Array();
$('.portlet-body').each(function (i){
    filterlist[i] = true;
})

function redirecttologin() {
    var xhr = new XMLHttpRequest();
    var url ="/logout";

    xhr.open("GET", url );

    xhr.setRequestHeader('Content-Type','application/json');

    xhr.onload = function(){
        // console.log(xhr.responseText);
        window.location.href = '/login';
    }
    xhr.send(null);

}

$(function() {
    // 发掘高价值客户页/搜索页
    if ($(".result-count span").length==1){
        shownumber = $(".result-count span")[0].innerText.replace(',','');
    }

    //地区查看更多
    $('.show-more').on('click', function() {
        if ($(this).hasClass('down')) {
            $(this).removeClass('down').addClass('up').text('收起');
            $(this).parents('.group').css('height', 'auto');
        } else {
            $(this).removeClass('up').addClass('down').text('更多');
            $(this).parents('.group').css('height', '26');
        }
    });

    //删除数组里的某个值
    Array.prototype.remove = function(b) {
        var a = this.indexOf(b);
        if (a >= 0) {
            this.splice(a, 1);
            return true;
        }
        return false;
    };

    // 分类选择
    $('.classification').on('click', '.body span', function() {
        var value=$(this).attr('value');
        if($(this).is('.cur')){
            $(this).removeClass('cur');
            spanValList.remove(value);
        }else{
            $(this).addClass('cur');
            $(this).parent('.body').siblings('.head').children('span').removeClass('all');
            spanValList.push(value);
        }
        console.log(spanValList);

        if ($('.industry >p').length == 1 && $('.industry >p')[0].innerHTML == '请选择行业类别') {
            industryname = '';
        }

        filterCorps();
    });

    //获取点击的span值（暂时不用）
    $(document).on('click', '.group .body span', function() {

        /*var spanVal = $(this).attr("spenttag");
        spanValList.push(spanVal);
        filterCorps();*/
    })


    $('.classification').on('click', '.head span', function() {
        $(this).addClass('all');
        $(this).parent('.head').siblings('.body').children().removeClass('cur');
        if ($('.industry >p').length == 1 && $('.industry >p')[0].innerHTML == '请选择行业类别') {
            industryname = '';
        }
        filterCorps();
    });

    $('.industry-box').on('click', '.classB li', function(){
        industryname = $(this).text();
        filterCorps();
    });

    $('.back-list').on('click', function() {
        if ($('#back-list-result').text() == '连接失效,请重新登录.') {
            redirecttologin();
        }
    });

    // 北美地区修改/融资及并购
    var defaultRegion = $('#region').html();
    var $year = $('#year').parent();
    var $income = $('#income').parent();
    $('#catetype').on('click', 'span', function() {
        if($(this).attr('id') == 'gategory-fo') {
            $('#region').html('<span>美国</span>').siblings('.head').find('span').addClass('all');
            $year.hide().find('span').removeClass('cur').
            end().children('.head').find('span').addClass('all');
            $income.hide().find('span').removeClass('cur').
            end().children('.head').find('span').addClass('all');
        } else if ($(this).attr('id') == 'gategory-fa') {
            $('#region').html(defaultRegion).siblings('.head').find('span').addClass('all');
            $year.hide().find('span').removeClass('cur').
            end().children('.head').find('span').addClass('all');
            $income.hide().find('span').removeClass('cur').
            end().children('.head').find('span').addClass('all');
        } else {
            $('#region').html(defaultRegion).siblings('.head').find('span').addClass('all');
            $year.show().find('span').removeClass('cur').
            end().children('.head').find('span').addClass('all');
            $income.show().find('span').removeClass('cur').
            end().children('.head').find('span').addClass('all');
        }
    })
    $('#gategory-all').click(function() {
        $('#region').html(defaultRegion).siblings('.head').find('span').addClass('all')
        $year.show();
        $income.show();
    })
});

function filterCorps() {
    //alert(spanValList);
    var region = '', catetype = '', year = '', income = '', name = $('.search input').val();
    shownumber = 0;
    if ($("#region span.cur").length==1) region = $("#region span.cur")[0].textContent;
    if ($("#catetype span.cur").length==1) catetype = $("#catetype span.cur")[0].textContent;
    if ($("#year span.cur").length==1) year = $("#year span.cur")[0].textContent;
    if ($("#income span.cur").length==1) income = $("#income span.cur")[0].textContent;
    $('.portlet-body').each(function (i){
        var hideflag = true;
        if (region == '' || region == $(this).find("#regiondata")[0].textContent) {
            if (catetype == '' || catetype =='政府扶持项目' && ($(this).find("#category_fc").length > 0) ||
                catetype =='上市挂牌储备' && ($(this).find("#category_ss").length > 0) ||
                catetype =='海归高精尖项目' && ($(this).find("#category_na").length > 0) ||
                catetype =='融资及并购' && ($(this).find("#category_fa").length > 0) ||
                catetype =='创业大赛项目' && ($(this).find("#category_cs").length > 0) ) {
                if (industryname == '' || $(this).find("#industrydata")[0].textContent.startsWith(industryname)) {
                    var yearflag = true;
                    if (year != '') {
                        yearflag = false;
                        var date1 = new Date($.trim($(this).find("#yeardata")[0].textContent));
                        var date2 = new Date();
                        var ycount = (date2-date1)/(24*3600*1000*365);
                        if ((ycount <= 1 && '1 年内成立' == year) ||
                            (ycount > 1 && ycount <= 5 && '1 - 5 年成立' == year) ||
                            (ycount > 5 && ycount <= 10 && '5 - 10 年成立' == year) ||
                            (ycount > 10 && ycount <= 15 && '10 - 15 年成立' == year) ||
                            (ycount > 15 && '成立 15 年以上' == year)
                        ) {
                            yearflag = true;
                        }
                    }
                    if (yearflag) {
                        hideflag = true;
                    }
                }
            }
        }
        if (hideflag) {
            $(this).hide();
            filterlist[i] =  false;
        } else {
            shownumber = shownumber + 1;
            if (shownumber > 5) {
                $(this).hide();
            } else {
                $(this).show();
            }
            filterlist[i] =  true;
        }
    });
    if ($(".result-count span").length==1){
        $(".result-count span")[0].innerText = shownumber.toString();
    }
    if (shownumber == 0) {
        //$("#corpsresult").hide();
        $("#corpspaging").hide();
    } else {
        //$("#corpsresult").show();
        $("#corpspaging").show();
    }
}

function setUser1(id, name) {
    memberid = id;
    username = name;
}

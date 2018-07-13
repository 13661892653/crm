var getAreaTable = [];
$(function() {
    $.ajax({
        type: "get",
        url: "/dynamicReport/reportDetailAjax?id=" + reportId,
        success: function(r) {
            if (r.code != 200) {
                alert(r.msg);
                return;
            }
            r = r.data;
            // console.log(r);
            $('.reportTitle').html(r.reportTitle);
            rows = r.reportRow,
                cols = r.reportCol;
            for (var i = 0; i < rows; i++) {
                var a = [];
                for (var j = 0; j < cols; j++) {
                    var m = i * cols + j;
                    var typeValue = r.fiDynamicReportColumnList[m].type,
                        cont = r.fiDynamicReportColumnList[m].content;
                    a.push({ type: typeValue, content: cont });
                };
                getAreaTable.push(a);
            }
            // console.log(getAreaTable);
            $('#areaTable').tmpl('areaTable_tmpl', getAreaTable);
            //financeinput/dynamicReportDataDetailAjax?reqId=1
            $.ajax({
                type: "get",
                url: "/financeinput/dynamicReportDataDetailAjax?reqId=" + reqId,
                success: function(r) {
                    if (r.code != 200) {
                        alert(r.msg);
                        $('textarea[name="remark"]').val(r.msg);
                        return;
                    }
                    var getdata = r.data;
                    // console.log(getdata);                    
                    if(getdata==null) return;
                    $('#posttable input').each(function(i, e) {
                        var ele = $(e),
                            inputName = ele.attr("name");
                        ele.val(getdata[inputName]);
                    })
                }
            });
        }
    });
    /*var areaTable = $('#areaTable').DataTable({
                bPaginate: false,//去掉翻页
                data: getAreaTable,
                columns: [{
                    'data': "null",
                    render: function(data, type, row, meta) {
                        console.log(data);
                        // if(data.type =="input"){
                        //  return '<input type="text" name="'+data.content+'" required/>';
                        // }else{
                        //  return data.content
                        // }
                        
                    }
                }]
            });*/
    //提交
    $(document).on('click', '.submit', function() {
        if (!$("#posttable").valid()) {
            return;
        }
        var formdata = $("#posttable").serializeArray(),
            postData = {},
            submitId = $(this).attr('data-submitId');
        $.each(formdata, function(i, e) {
            postData[e["name"]] = e["value"];
        });
        postData.reqId = reqId;
        // console.log(JSON.stringify(postData));
        $.ajax({
            type: 'POST',
            url: '/financeinput/dynamicReportDataDetailSave',
            data: JSON.stringify(postData),
            contentType: "application/json;  charset=utf-8",
            success: function(r) {
                if (r.code == 200) {
                    alert("提交成功");
                    if(submitId=="1"){
                        window.location.href = '/financeinput/dynamicReportDataFirstList';
                    }else{
                        window.location.href = '/financeinput/dynamicReportDataSecondList';
                    }
                } else {
                    $('textarea[name="remark"]').val(r.msg);
                    alert(r.msg);

                }
            }
        });
    })
    var validator = $("#posttable").validate({
        rules: {
            mobile: {
                isPhone: true
            }
            /*,
                            billBalance:{integer:true}*/
        },
        ignore: "not:hidden",
        onfocusout: function(element) {
            var el = $(element);
            el.valid();
            if (validator.errorList.length == 0) {
                el.next('.msg').css("visibility", "hidden");
            }
        },
        onkeyup: function(element) {
            var el = $(element);
            el.valid();
            if (validator.errorList.length == 0) {
                el.next('.msg').css("visibility", "hidden");
            }
        },
        errorPlacement: function(error, element) {
            var el = $(validator.errorList[0].element);
            /* var li = el.parent('td');*/
            element.removeClass('error');
            el.addClass('error');
            el.next('.msg').css("visibility", "visible");
        },
        invalidHandler: function(form, validator) {
            var errors = validator.numberOfInvalids();
            if (errors) {
                $('.msg').css("visibility", "hidden");
                var el = $(validator.errorList[0].element);
                /*var li = el.parent('td').parent('tr');*/
                $('.mcontent').animate({
                    scrollTop: ((el[0].offsetTop) - 10) + 'px'
                }, 100);
            }
        }

    });
    //驳回
    $(document).on('click', '.rejectbtn', function() {
        if (!$("#reject").valid()) {
            return;
        }
        $.ajax({
            type: 'POST',
            // url: '/financeinput/dynamicReportDataRevert?remark='+remark+'&reqId='+reqId,
            url: '/financeinput/dynamicReportDataRevert',
            data:{'remark':$('textarea[name="remark"]').val(),'reqId':reqId},
            success: function(r) {
                if (r.code == 200) {
                    // alert("提交成功");
                    window.location.href = '/financeinput/dynamicReportDataSecondList';
                } else {
                    alert(r.msg);
                }
            }
        });
    })
    var validatorReject = $("#reject").validate({
        rules: {
            mobile: {
                isPhone: true
            }
            /*,
                            billBalance:{integer:true}*/
        },
        ignore: "not:hidden",
        onfocusout: function(element) {
            var el = $(element);
            el.valid();
            if (validatorReject.errorList.length == 0) {
                el.next('.msg').css("visibility", "hidden");
            }
        },
        onkeyup: function(element) {
            var el = $(element);
            el.valid();
            if (validatorReject.errorList.length == 0) {
                el.next('.msg').css("visibility", "hidden");
            }
        },
        errorPlacement: function(error, element) {
            var el = $(validatorReject.errorList[0].element);
            /* var li = el.parent('td');*/
            element.removeClass('error');
            el.addClass('error');
            el.next('.msg').css("visibility", "visible");
        },
        invalidHandler: function(form, validator) {
            var errors = validator.numberOfInvalids();
            if (errors) {
                $('.msg').css("visibility", "hidden");
                var el = $(validator.errorList[0].element);
                /*var li = el.parent('td').parent('tr');*/
                $('.mcontent').animate({
                    scrollTop: ((el[0].offsetTop) - 10) + 'px'
                }, 100);
            }
        }

    });
})
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
            $('#areaTable').tmpl('areaTable_tmpl', getAreaTable);
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
                    $('.inputArea').each(function(i, e) {
                        var ele = $(e),
                            inputName = ele.attr("id");
                        ele.html(getdata[inputName]);
                    });
                }
            });
        }
    });
});
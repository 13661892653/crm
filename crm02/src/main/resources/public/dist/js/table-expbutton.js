
//为导出功能设置数据源
function setExportDataAttr() {
    $(".export-csv").attr("data-table","#report1");
    $(".export-excel").attr("data-table","#report1");
    $(".export-xlsx").attr("data-table","#report1");

    $(".export-csv").attr("data-filename","导出csv");
    $(".export-excel").attr("data-filename","导出xls");
    $(".export-xlsx").attr("data-filename","导出xlsx");
};

setExportDataAttr();

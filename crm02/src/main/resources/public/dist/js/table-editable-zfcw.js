var TableEditableZfcw = function () {

    var handleTable = function () {

        function restoreRow(oTable, nRow) {
            var aData = oTable.fnGetData(nRow);
            var jqTds = $('>td', nRow);

            for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                oTable.fnUpdate(aData[i], nRow, i, false);
            }

            oTable.fnDraw();
        }

        function editRow(oTable, nRow) {
            var aData = oTable.fnGetData(nRow);
            var jqTds = $('>td', nRow);
            jqTds[0].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[0] + '">';
            jqTds[1].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[1] + '">';
            jqTds[2].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[2] + '">';
            jqTds[3].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[3] + '">';
            jqTds[4].innerHTML = '<input type="text" class="form-control input-small" value="' + aData[4] + '">';
            jqTds[5].innerHTML = '<a class="edit" href="">保存</a> <a class="cancel" href="">取消</a>';
        }

        var judge = false;

        function saveRow(oTable, nRow) {
            var num_exp = /^[0-9]+.?[0-9]*$/i;   //判断是否是数字
            var finyear_exp = /^(\d{4})-(\d{2})-(\d{2})$/i;   //判断输入的年份格式
            var jqInputs = $('input', nRow);
            if(jqInputs[0].value==''&&jqInputs[1].value==''&&jqInputs[2].value==''&&jqInputs[3].value==''){
                alert('输入内容不能全为空！');
                judge = false ;
            }
            else if(jqInputs[0].value==''){
                alert('年份不能为空！');
                judge = false ;
            }
            else if((jqInputs[0].value!='')&&(!finyear_exp.test(jqInputs[0].value))){
                alert('年份格式不正确，要求格式为YYYY-MM-DD');
                judge = false ;
            }
            else if(jqInputs[1].value==''){
                alert('营业收入不能为空！');
                judge = false ;
            }
            else if((jqInputs[1].value!='')&&(isNaN(jqInputs[1].value))){
                alert('营业收入必须是数字！');
                judge = false ;
            }
            else if(jqInputs[2].value==''){
                alert('净利润不能为空！');
                judge = false ;
            }
            else if((jqInputs[2].value!='')&&(isNaN(jqInputs[2].value))){
                alert('净利润必须是数字！');
                judge = false ;
            }
            else if(jqInputs[2].value==''){
                alert('总资产不能为空！');
                judge = false ;
            }
            else if((jqInputs[3].value!='')&&(isNaN(jqInputs[3].value))){
                alert('总资产必须是数字！');
                judge = false ;
            }
            else if((jqInputs[4].value!='')&&(isNaN(jqInputs[4].value))){
                alert('净资产必须是数字！');
                judge = false ;
            }
            else {
                judge = true ;
                $('#finYear').val(jqInputs[0].value);
                $('#operatingIncome').val(jqInputs[1].value);
                $('#netProfit').val(jqInputs[2].value);
                $('#totalAssets').val(jqInputs[3].value);
                $('#netAssets').val(jqInputs[4].value);
            }
        }

        function cancelEditRow(oTable, nRow) {
            var jqInputs = $('input', nRow);
            oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
            oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
            oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
            oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
            oTable.fnUpdate(jqInputs[4].value, nRow, 4, false);
            oTable.fnUpdate('<a class="edit" href="">编辑</a>', nRow, 5, false);
            oTable.fnDraw();
        }

        var table = $('#table_zfcw');

        var oTable = table.dataTable({

            // Uncomment below line("dom" parameter) to fix the dropdown overflow issue in the datatable cells. The default datatable layout
            // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js).
            // So when dropdowns used the scrollable div should be removed.
            //"dom": "<'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r>t<'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>",

            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "All"] // change per page values here
            ],
            // set the initial value
            "pageLength": 10,

            "language": {
                "lengthMenu": " _MENU_ records"
            },
            "columnDefs": [{ // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }],
            "order": [
                [0, "asc"]
            ], // set first column as a default sort by asc
            "searching": false,
            "bPaginate": false, //开关，是否显示分页器
            "bFilter": false,
            "info": false
        });

        //var tableWrapper = $("#sample_editable_1_wrapper");

        //tableWrapper.find(".dataTables_length select").select2({
        //    showSearchInput: false //hide search box with special css class
        //}); // initialize select2 dropdown

        var nEditing = null;
        var nNew = false;

        $('#zfcw_new').click(function (e) {
            e.preventDefault();

            if (nNew && nEditing) {
                if (confirm("Previose row not saved. Do you want to save it ?")) {
                    saveRow(oTable, nEditing); // save
                    $(nEditing).find("td:first").html("Untitled");
                    nEditing = null;
                    nNew = false;
                } else {
                    oTable.fnDeleteRow(nEditing); // cancel
                    nEditing = null;
                    nNew = false;

                    return;
                }
            }

            var aiNew = oTable.fnAddData(['', '', '', '', '','', '']);
            var nRow = oTable.fnGetNodes(aiNew[0]);
            editRow(oTable, nRow);
            nEditing = nRow;
            nNew = true;
        });

        table.on('click', '.cancel', function (e) {
            e.preventDefault();
            if (nNew) {
                oTable.fnDeleteRow(nEditing);
                nEditing = null;
                nNew = false;
            } else {
                restoreRow(oTable, nEditing);
                nEditing = null;
            }
        });

        table.on('click', '.edit', function (e) {
            e.preventDefault();

            /* Get the row as a parent of the link that was clicked on */
            var nRow = $(this).parents('tr')[0];

            if (nEditing !== null && nEditing != nRow) {
                /* Currently editing - but not this row - restore the old before continuing to edit mode */
                restoreRow(oTable, nEditing);
                editRow(oTable, nRow);
                nEditing = nRow;
            } else if (nEditing == nRow && this.innerHTML == "保存") {
                /* Editing this row and want to save it */
                saveRow(oTable, nEditing);

                nEditing = null;
                if(judge) {
                    $('#formZfcw').submit(); //表单提交
                }
            } else {
                /* No edit in progress - let's start one */
                editRow(oTable, nRow);
                nEditing = nRow;
            }
        });
    }

    return {

        //main function to initiate the module
        init: function () {
            handleTable();
        }

    };

}();
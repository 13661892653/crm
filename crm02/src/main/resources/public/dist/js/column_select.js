var username = '';
var memberid = '';
var industryname = '';
var shownumber = 0;
var pagesize = 5;
var filterlist = new Array();
$('.cell').each(function (i){
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

function setUser1(id, name) {
    memberid = id;
    username = name;
}

$('.monitor-item-panel').on('click', '.monitor-item label', function() {
    //var $parent = $(this).parents('.half');
    $(this).parents('.monitor-item').toggleClass('selected');
});

//选择要加入维度域的字段
$('.half').on('click', '.scheme-btn .savetodim', function() {

    var dimcolumnlist = new Array();

    $('.monitor-item.selected').each(function() {
        var columnname = $(this).attr("id");
        if (columnname != '') {
            dimcolumnlist.push(columnname);
        }
    });

    if (dimcolumnlist.length==0) {
        $('.error-tip').text("请至少选择一个字段")
        $('.error-tip').show();
        return;
    }

    var divstr = "";
    divstr += "<tr>";
    //遍历字段，生成维度区div内容
    for(j = 0,len = dimcolumnlist.length;j < len;j++)
    {
      divstr += "<td>";
      divstr += dimcolumnlist[j];
      divstr += " ";
      divstr += "</td>";
    }
    divstr += "</tr>";

    document.getElementById("dimdiv").innerHTML = divstr;
    //document.getElementById("hiddendim").value=dimcolumnlist;
    //$('#addDimForm').submit();
});

//选择要加入指标域的字段
$('.half').on('click', '.scheme-btn .savetoidx', function() {

    var js=document.scripts;
    var jsPath;
    for(var i=0;i<js.length;i++){
        if(js[i].src.indexOf("column_select.js")>-1){
            jsPath=js[i].src.substring(0,js[i].src.lastIndexOf("/")+1);
        }
    }
    alert(jsPath);

    var idxcolumnlist = new Array();

    $('.monitor-item.selected').each(function() {
        var columnname = $(this).attr("id");
        if (columnname != '') {
            idxcolumnlist.push(columnname);
        }
    });

    if (idxcolumnlist.length==0) {
        $('.error-tip').text("请至少选择一个字段")
        $('.error-tip').show();
        return;
    }

    var divstr = "";
    divstr += "<tr>";
    //遍历字段，生成维度区div内容
    for(j = 0,len = idxcolumnlist.length;j < len;j++)
    {
        divstr += "<td>";
        divstr += idxcolumnlist[j];
        divstr += " ";
        divstr += "</td>";
    }
    divstr += "</tr>";

    document.getElementById("idxdiv").innerHTML = divstr;
    //document.getElementById("hiddenidx").value=idxcolumnlist;
    //$('#addIdxForm').submit();
});

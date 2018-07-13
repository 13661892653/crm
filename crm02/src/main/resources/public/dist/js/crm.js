$('.result').on('mouseenter', '.cell-container', function() {
    $(this).find('.cell-mask').fadeIn()
}).on('mouseleave', '.cell-container', function() {
    $(this).find('.cell-mask').fadeOut(100)
});

$('.form-group').on('click', '.search', function() {
    var corpNameVal = $(this).siblings('input[type="text"]').val().replace(/\s+/g,"");
    $('#corpName').val(corpNameVal);
    $('#corpChk').submit(); //校验企业名称
});

//点击分配客户经理
$('.portlet-body').on('click', '.red-pink-stripe', function() {
    var id=$(this).attr("id"); //企业工商注册号、社会统一信用代码
    $('.overlay').show();
    $('.mgr-popup').show();
    $('html, body').css('overflow-y', 'hidden');
    $("#companyemp").data('regCreditNo',id); //把收藏regCreditNo赋给层
})

$('.close').click(function() {
    $(this).parent('.mgr-popup').hide();
    $('.overlay').hide();
    $('html, body').css('overflow-y', 'auto');
});

$(document).on('click','#updatebtn',function(){
    var id=$("#companyemp").data('regCreditNo');
    submitCustManager(id);
})

//点击修改客户经理提交按钮
function submitCustManager(id) {
    var use_member = document.getElementById("userNameSel").value;
    var arr=use_member.split("--");
    $('#userName').val(arr[0]);
    $('#memberId').val(arr[1]);
    $('#regCreditNo').val(id);
    $('#uptcustMgr').submit(); //提交表单
}

//判断下单页面订单类型radio选项
function radioCheckOrder(checkedRadio)
{
    var tempradio= null;
    if(tempradio== checkedRadio){
        tempradio.checked=false;
        tempradio=null;
    }
    else{
        tempradio= checkedRadio;
    }
    var rdoValue = $("input[name='orderType']:checked").val();
    if(rdoValue == 'unCorpOrder'){
        $("#unCorpOrder").show();
        $("#corpOrder1").hide();
        $("#corpOrder2").hide();
        $("#corpOrder3").hide();
    }
    else{
        $("#unCorpOrder").hide();
        $("#corpOrder1").show();
        $("#corpOrder2").show();
        $("#corpOrder3").show();
    }
}

//判断触达页面订单类型radio选项
function radioCheckRch(checkedRadio)
{
    var tempradio= null;
    if(tempradio== checkedRadio){
        tempradio.checked=false;
        tempradio=null;
    }
    else{
        tempradio= checkedRadio;
    }

    var rdoValue = $("input[name='custType']:checked").val();
    if(rdoValue == 'unCorpCust'){
        $("#div_custName").show();
        $("#div_enterpriseName").hide();
        $("#div_govName").hide();
        $("#div_creditNo").hide();
        $("#div_regNo").hide();
        $("#div_bizLv1Id").show();
        $("#div_winCustChnl").show();
        $("#div_rchMode").show();
        $("#div_beginTime").show();
        $("#div_contacts").show();
        $("#div_jobTitle").show();
        $("#div_contactsPhone").show();
        $("#div_salesLead").show();
        $("#div_remark").show();
        $("#div_govLine").hide();
        $("#div_govLevel").hide();
        $("#div_govQzr").hide();
        $("#div_commTopic").hide();
        $("#div_getEffect").hide();
        $("#div_resultTime").hide();
        $("#div_cdnThings").hide();
        $("#div_update_id").hide();
    }
    if(rdoValue == 'corpCust'){
        $("#div_custName").hide();
        $("#div_enterpriseName").show();
        $("#div_govName").hide();
        $("#div_creditNo").show();
        $("#div_regNo").show();
        $("#div_bizLv1Id").show();
        $("#div_winCustChnl").show();
        $("#div_rchMode").show();
        $("#div_beginTime").show();
        $("#div_contacts").show();
        $("#div_jobTitle").show();
        $("#div_contactsPhone").show();
        $("#div_salesLead").show();
        $("#div_remark").show();
        $("#div_govLine").hide();
        $("#div_govLevel").hide();
        $("#div_govQzr").hide();
        $("#div_commTopic").hide();
        $("#div_getEffect").hide();
        $("#div_resultTime").hide();
        $("#div_cdnThings").hide();
        $("#div_update_id").show();
    }
    if(rdoValue == 'govCust'){
        $("#div_custName").hide();
        $("#div_enterpriseName").hide();
        $("#div_govName").show();
        $("#div_creditNo").hide();
        $("#div_regNo").hide();
        $("#div_bizLv1Id").show();
        $("#div_winCustChnl").hide();
        $("#div_rchMode").hide();
        $("#div_beginTime").show();
        $("#div_contacts").show();
        $("#div_jobTitle").show();
        $("#div_contactsPhone").show();
        $("#div_salesLead").hide();
        $("#div_remark").show();
        $("#div_govLine").show();
        $("#div_govLevel").show();
        $("#div_govQzr").show();
        $("#div_commTopic").show();
        $("#div_getEffect").show();
        $("#div_resultTime").show();
        $("#div_cdnThings").show();
        $("#div_update_id").hide();
    }
}

//判断是否点了政府触达页面政府条线的“其他”
function radioCheckRchOther(checkedRadio)
{
    var govLine = $("input[name='govLine']:checked").val();
    if(govLine=='其他'){
        $("#govLineLab").show();
    }
    else{
        $("#govLineLab").hide();
    }
}

function showdivord() {
    var isSelfBiz = document.getElementById("isSelfBiz").value;
    if(isSelfBiz=='Y')
    {
        $("#srvdiv1").hide();  //如果是自营订单，隐藏服务商选项
        $("#srvdiv2").hide();  //如果是自营订单，隐藏服务商选项
    }
    if(isSelfBiz=='N')
    {
        $("#srvdiv1").show();  //如果非自营订单，显示服务商选项
        $("#srvdiv2").show();  //如果非自营订单，显示服务商选项
    }
}

function showdivctt() {
    var contractType = document.getElementById("contractType").value;
    if(contractType=='CONT01')
    {
        $("#ordnodiv").show();  //如果是订单合同，显示订单号输入框
    }
    else{
        $("#ordnodiv").hide();  //如果非订单合同，隐藏订单号输入框
    }
}

function showCorpDetail(obj) {
    var reg_credit_no = null;
    if(obj){
        reg_credit_no=obj.id;  //获取所选企业的reg_credit_no
        if(reg_credit_no.length==0){
            alert("非企业客户，没有企业档案可查。");
        }
        else {
            window.open("/crm/enterprisedetail/view?reg_credit_no=" + reg_credit_no + "", "_blank", "toolbar=no, location=no, titlebar=no,directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=yes, left=1000,width=1200, height=800")
        }
    }
    else {
        alert("非企业客户，没有企业档案可查。");
    }
}

function showRchList(obj) {
    var reg_credit_no = null;
    if(obj){
        reg_credit_no=obj.id;  //获取所选企业的reg_credit_no
        console.log(reg_credit_no);
        window.location.href = '/crm/marketing/reachcsr/viewent?reg_credit_no=' + reg_credit_no; //查看企业触达信息
    }
}

function showEntOrder(obj) {
    var reg_credit_no = null;
    if(obj){
        reg_credit_no=obj.id;  //获取所选企业的reg_credit_no
        window.location.href = '/crm/ordermanage/viewent?reg_credit_no=' + reg_credit_no; //查看企业订单
    }
}

function hxtdClickDelete(obj) {
    var recId = null;
    if(obj){
        recId=obj.id;  //获取记录ID
        $('#recId').val(recId);
        $('#hxtdFormDelete').submit(); //提交删除
    }
}

function gslxrClickDelete(obj) {
    var ctcname = null;
    if(obj){
        ctcname=obj.id;  //获取联系人名
        $('#ctcname').val(ctcname);
        $('#gslxrFormDelete').submit(); //提交删除
    }
}

function zzryClickDelete(obj) {
    var recId = null;
    if(obj){
        recId=obj.id;  //获取记录ID
        $('#recId3').val(recId);
        $('#zzryFormDelete').submit(); //提交删除
    }
}

function zfcwClickDelete(obj) {
    var recId = null;
    if(obj){
        recId=obj.id;  //获取记录ID
        $('#recId4').val(recId);
        $('#zfcwFormDelete').submit(); //提交删除
    }
}

function clickbtn(obj) {
    if(obj.id=='btn_addord') {
        var rdoValue = $("input[name='orderType']:checked").val();
        var subflag = true;
        var int_exp = /^[0-9]*[1-9][0-9]*$/i;  //用于判断输入的是否是正整数
        var len_credit_no = document.getElementById("creditNo").value.length;
        var len_reg_no = document.getElementById("regNo").value.length;
        var orderType = document.getElementById("orderType").value;
        var orderDate = document.getElementById("orderDate").value;
        var orderPrice = document.getElementById("orderPrice").value;
        var orderNum = document.getElementById("orderNum").value;
        var orderProdId = document.getElementById("orderProdId").value;
        var payMode = document.getElementById("payMode").value;
        var payStatus = document.getElementById("payStatus").value;
        var orderStatus = document.getElementById("orderStatus").value;
        var merchandiser = document.getElementById("merchandiser").value;
        var remark = document.getElementById("remark").value;

        if(rdoValue=='corpOrder'&&len_credit_no==0&&len_reg_no==0) {
            alert("请先校验企业名称！");
            subflag = false;
        }
        else if(rdoValue=='unCorpOrder'&&orderType==''){
            alert("未填写订单客户名称！");
            subflag = false;
        }
        else if(rdoValue=='unCorpOrder'&&orderType.length > 60){
            alert("订单客户名称不能超过60字！");
            subflag = false;
        }
        else if(orderDate==''){
            alert("未选择下单时间！");
            subflag = false;
        }
        else if(orderProdId==''){
            alert("未选择下单商品！");
            subflag = false;
        }
        else if(orderPrice==''){
            alert("未输入采购商品单价！");
            subflag = false;
        }
        else if((orderPrice!='')&&(!int_exp.test(orderPrice))){
            alert('采购单价，必须为正整数！');
            subflag = false ;
        }
        else if(orderNum==''){
            alert("未输入采购商品数量！");
            subflag = false;
        }
        else if((orderNum!='')&&(!int_exp.test(orderNum))){
            alert('采购数量，必须为正整数！');
            subflag = false ;
        }
        else if(payMode==''){
            alert("未选择支付方式！");
            subflag = false;
        }
        else if(payStatus==''){
            alert("未选择支付状态！");
            subflag = false;
        }
        else if(orderStatus==''){
            alert("未选择订单状态！");
            subflag = false;
        }
        else if(merchandiser==''){
            alert("未选择跟单人！");
            subflag = false;
        }
        else if(remark.length > 50){
            alert("备注内容不能超过50个字。");
            subflag = false;
        }
        else{
            subflag = true;
        }
        if(subflag){
            $('#addOrder').submit();  //订单提交
        }

    }
    if(obj.id=='btn_uptpsd') {
        var subflag = true;
        var regx = /^[A-Za-z0-9]*$/i;
        var memberPwd = document.getElementById("memberPwd").value;
        var memberPwdSec = document.getElementById("memberPwdSec").value;
        if(memberPwd==''){
            alert("请输入新密码！");
            subflag = false;
        }
        else if(!regx.test(memberPwd))
        {
            alert("密码必须是数字与字母的组合！");
            subflag = false;
        }
        else if(memberPwdSec==''){
            alert("请再次输入新密码！");
            subflag = false;
        }
        else if((memberPwd!='')&&(memberPwdSec!='')&&(memberPwd!=memberPwdSec)){
            alert('两次输入的密码不同！');
            subflag = false ;
        }
        else{
            subflag = true;
        }
        if(subflag) {
            $('#uptpsd').submit();  //密码修改提交
        }
    }

    if(obj.id=='btn_celpsd') {
        window.location.href = '/crm/workbench'; //取消密码修改
    }

    if(obj.id=='btn_celord') {
        window.location.href = '/crm/ordermanage/viewall'; //订单取消，回到订单管理页面
    }

    if(obj.id=='btn_celrch') {
        window.location.href = '/crm/marketing/reachcsr/reachlist'; //取消编辑，回到触达列表页
    }

    if(obj.id=='btn_uptord') {
        $('#updateOrder').submit();  //订单提交
    }

    if(obj.id=='btn_uptrch') {
        $('#updateReach').submit();  //提交编辑触达信息
    }

    if(obj.id=='btn_begininit') {
        $('#initList').submit();  //企业基础信息初始化
    }

    if(obj.id=='btn_addrch') {
        var rdoValue = $("input[name='custType']:checked").val();
        var subflag = true;
        var len_credit_no = document.getElementById("creditNo").value.length;
        var len_reg_no = document.getElementById("regNo").value.length;
        var custType = $("input[name='custType']:checked").val();
        var bizLv1Id = document.getElementById("bizLv1Id").value;
        var rchMode = document.getElementById("rchMode").value;
        var winCustChnl = document.getElementById("winCustChnl").value;
        var govLine = $("input[name='govLine']:checked").val();
        var govLevel = $("input[name='govLevel']:checked").val();
        var govQzr = $("input[name='govQzr']:checked").val();
        var govLineIpt = document.getElementById("govLineIpt").value;
        var beginTime = document.getElementById("beginTime").value;
        var contacts = document.getElementById("contacts").value;
        var len_contacts = document.getElementById("contacts").value.length;
        var jobTitle = document.getElementById("jobTitle").value;
        var len_jobTitle = document.getElementById("jobTitle").value.length;
        var contactsPhone = document.getElementById("contactsPhone").value;
        var len_contactsPhone = document.getElementById("contactsPhone").value.length;
        var len_salesLead = document.getElementById("salesLead").value.length;
        var commTopic = document.getElementById("commTopic").value;
        var len_commTopic = document.getElementById("commTopic").value.length;
        var getEffect = document.getElementById("getEffect").value;
        var len_getEffect = document.getElementById("getEffect").value.length;
        var remark = document.getElementById("remark").value;
        var updateId = document.getElementById("updateId").value;
        if(custType=="corpCust"){
            if(updateId==""){
                alert("请填写属于自己的更新ID");
                return;
            }
        }else{
            $("#updateId").val("");
        }
        if(rdoValue=='corpCust'&&len_credit_no==0&&len_reg_no==0) {
            alert("请先校验企业名称！");
            subflag = false;
        }
        else if(rdoValue=='unCorpCust'&&custType==''){
            alert("未填写触达客户名称！");
            subflag = false;
        }
        else if(rdoValue=='unCorpCust'&&custType.length > 60){
            alert("触达客户名称不能超过60字！");
            subflag = false;
        }
        else if(rdoValue=='govCust'&&custType==''){
            alert("未填写部委名称！");
            subflag = false;
        }
        else if(rdoValue=='govCust'&&custType.length > 60){
            alert("部委名称不能超过60字！");
            subflag = false;
        }
       else if(rdoValue=='govCust'&&typeof(govLine)=="undefined"&&govLineIpt==''){
            alert("未选择政府条线！");
            subflag = false;
        }
        else if(rdoValue=='govCust'&&govLine=="其他"&&govLineIpt==''){
            alert("选择“其他”政府条线时需要填写名称！");
            subflag = false;
        }
        else if(rdoValue=='govCust'&&typeof(govLevel)=="undefined"){
            alert("未选择级别！");
            subflag = false;
        }
        else if(rdoValue=='govCust'&&typeof(govQzr)=="undefined"){
            alert("未选择部委等级！");
            subflag = false;
        }
        else if(bizLv1Id==''){
            alert("未选择业务类别！");
            subflag = false;
        }
        else if(rdoValue!='govCust'&&winCustChnl==''){
            alert("未选择获客渠道！");
            subflag = false;
        }
        else if(rdoValue!='govCust'&&rchMode==''){
            alert("未选择触达方式！");
            subflag = false;
        }
        else if(beginTime==''){
            alert("未选择触达时间！");
            subflag = false;
        }
        else if(contacts==''){
            alert("未填写接触人！");
            subflag = false;
        }
        else if(len_contacts>10){
            alert("接触人姓名不能超过10个字！");
            subflag = false;
        }
        else if(jobTitle==''){
            alert("未填写接触人职位或职务！");
            subflag = false;
        }
        else if(len_jobTitle>10){
            alert("接触人职位或职务不能超过10个字！");
            subflag = false;
        }
        else if(contactsPhone==''){
            alert("未填写联系电话！");
            subflag = false;
        }
        else if(len_contactsPhone>25){
            alert("联系电话不能超过25个字！");
            subflag = false;
        }
        else if(rdoValue=='govCust'&&commTopic==''){
            alert("未填写沟通主题！");
            subflag = false;
        }
        else if(rdoValue=='govCust'&&commTopic!=''&&len_commTopic>30){
            alert("沟通主题不能超过30字！");
            subflag = false;
        }
        else if(rdoValue=='govCust'&&getEffect==''){
            alert("未填写推进情况及取得的效果！");
            subflag = false;
        }
        else if(rdoValue=='govCust'&&getEffect!=''&&len_getEffect>50){
            alert("推进情况及取得的效果不能超过50字！");
            subflag = false;
        }
        else if(rdoValue!='govCust'&&len_salesLead>30){
            alert("潜在销售机会不能超过30个字！");
            subflag = false;
        }
        else if(remark.length > 100){
            alert("内容纪要不能超过100个字。");
            subflag = false;
        }
        else{
            govLine==govLineIpt;
            subflag = true;
        }
        if(subflag){
            $('#addReach').submit();  //提交
        }
    }

    if(obj.id=='btn_celrch') {
        window.location.href = '/crm/marketing/reachcsr/reachlist'; //取消，回到触达信息列表页面
    }
    if(obj.id=='btn_addusr') {
        var subflag = true;
        var int_exp = /^[0-9]*[1-9][0-9]*$/i;  //用于判断输入的是否是正整数
        var memberPhone = document.getElementById("memberPhone").value;
        var province = document.getElementById("province").value;
        var company = document.getElementById("company").value;
        if(winCustChnl==''){
            alert("未输入手机号码！");
            subflag = false;
        }
        else if(province==''){
            alert("未选择所在省份！");
            subflag = false;
        }
        else if(company==''){
            alert("未选择所在分公司！");
            subflag = false;
        }
        else if((memberPhone!='')&&(!int_exp.test(memberPhone))){
            alert('手机号码，必须为数字！');
            subflag = false ;
        }
        if(subflag){
            $('#addUser').submit();  //新增用户
        }
    }

    if(obj.id=='btn_uptusr') {
        $('#updateUser').submit();  //提交修改用户信息
    }

    if(obj.id=='btn_celusr') {
        window.location.href = '/crm/user/viewall'; //取消，回到用户列表页面
    }

    if(obj.id=='btn_addact') {
        var subflag = true;
        var int_exp = /^[0-9]*[1-9][0-9]*$/i;  //用于判断输入的是否是正整数
        var bizLv1Id = document.getElementById("bizLv1Id").value;
        var actName = document.getElementById("actName").value;
        var usRole = document.getElementById("usRole").value;
        var actType = document.getElementById("actType").value;
        var beginTime = document.getElementById("beginTime").value;
        var endTime = document.getElementById("endTime").value;
        var actLocation = document.getElementById("actLocation").value;
        var actFee = document.getElementById("actFee").value;
        var joinPersons = document.getElementById("joinPersons").value;
        var remark = document.getElementById("remark").value;
        if(bizLv1Id==''){
            alert("未选择活动归类！");
            subflag = false;
        }
        else if(actName==''){
            alert("未填写活动名称！");
            subflag = false;
        }
        else if(usRole==''){
            alert("未选择我司角色！");
            subflag = false;
        }
        else if(actType==''){
            alert("未选择活动类型！");
            subflag = false;
        }
        else if(beginTime==''){
            alert("未选择活动开始时间！");
            subflag = false;
        }
        else if(endTime==''){
            alert("未选择活动结束时间！");
            subflag = false;
        }
        else if(actLocation==''){
            alert("未填写活动举办地点！");
            subflag = false;
        }
        else if(actLocation.length > 20){
            alert("活动举办地点不能超过20字！");
            subflag = false;
        }
        else if(actFee==''){
            alert("未填写活动费用！");
            subflag = false;
        }
        else if((actFee!='')&&(isNaN(actFee))){
            alert('活动费用，必须为数字！');
            subflag = false ;
        }
        else if(joinPersons==''){
            alert("未填写参加活动人数！");
            subflag = false;
        }
        else if((joinPersons!='')&&(!int_exp.test(joinPersons))){
            alert('参加活动人数，必须为正整数！');
            subflag = false ;
        }
        else if(remark.length > 50){
            alert("备注内容不能超过50个字。");
            subflag = false;
        }
        else{
            subflag = true;
        }
        if(subflag){
            $("#excelJson").val(JSON.stringify(excelObj.data));
            $("#imageJson").val(JSON.stringify(imageObj.data));
            $('#addAct').submit();  //提交
        }
    }

    if(obj.id=='btn_celact') {
        window.location.href = '/activity/list'; //取消，回到活动信息列表页面
    }

    if(obj.id=='btn_addctt') {
        var subflag = true;
        var contractType = document.getElementById("contractType").value;
        var orderNo = document.getElementById("orderNo").value;
        var contractTitle = document.getElementById("contractTitle").value;
        var contractEnterprise = document.getElementById("contractEnterprise").value;
        var contractDate = document.getElementById("contractDate").value;
        var contractAmt = document.getElementById("contractAmt").value;
        var income = document.getElementById("income").value;
        var profit = document.getElementById("profit").value;
        var remark = document.getElementById("remark").value;
        if(contractType==''){
            alert("未选择合同类型！");
            subflag = false;
        }
        else if((contractType=="CONT01")&&(orderNo=='')){
            alert("未填写订单号！");
            subflag = false;
        }
        else if(contractTitle==''){
            alert("未填写合同标题！");
            subflag = false;
        }
        else if(contractEnterprise==''){
            alert("未填写合同主体公司！");
            subflag = false;
        }
        else if(contractDate==''){
            alert("未选择合同签订日期！");
            subflag = false;
        }
        else if((income!='')&&(isNaN(income))){
            alert('到账收入金额，必须为数字！');
            subflag = false ;
        }
        else if((profit!='')&&(isNaN(profit))){
            alert('利润金额，必须为数字！');
            subflag = false ;
        }
        else if(contractAmt==''){
            alert("未填写合同金额！");
            subflag = false;
        }
        else if(remark.length > 50){
            alert("备注内容不能超过50个字。");
            subflag = false;
        }
        else{
            subflag = true;
        }
        if(subflag){
            $('#addContract').submit();  //提交
        }
    }

    if(obj.id=='btn_celctt') {
        window.location.href = '/crm/contractmanage/viewall'; //取消，回到合同列表页面
    }

    if(obj.id=='btn_uptctt') {
        var subflag = true;
        var income = document.getElementById("income").value;
        var profit = document.getElementById("profit").value;
        var remark = document.getElementById("remark").value;
        if((income!='')&&(isNaN(income))){
            alert('到账收入金额，必须为数字！');
            subflag = false ;
        }
        else if((profit!='')&&(isNaN(profit))){
            alert('利润金额，必须为数字！');
            subflag = false ;
        }
        else if(remark.length > 50){
            alert("备注内容不能超过50个字。");
            subflag = false;
        }
        else{
            subflag = true;
        }
        if(subflag){
            $('#updateContract').submit();  //提交修改合同
        }
    }

    if(obj.id=='btn_addptr') {
        var subflag = true;
        var len_credit_no = document.getElementById("creditNo").value.length;
        var len_reg_no = document.getElementById("regNo").value.length;
        var partnerLvId = document.getElementById("partnerLvId").value;
        var partnerType = document.getElementById("partnerType").value;
        var srvArea = document.getElementById("srvArea").value;
        var contractNo = document.getElementById("contractNo").value;
        var category = document.getElementById("category").value;
        var contactPerson = document.getElementById("contactPerson").value;
        var contactPhone = document.getElementById("contactPhone").value;
        var email = document.getElementById("email").value;
        var bankAccount = document.getElementById("bankAccount").value;
        var bizScope = document.getElementById("bizScope").value;
        var feePoint = document.getElementById("feePoint").value;
        var joinTime = document.getElementById("joinTime").value;
        var remark = document.getElementById("remark").value;
        if(len_credit_no==0&&len_reg_no==0) {
            alert("请先校验企业名称！");
            subflag = false;
        }
        else if(partnerLvId==''){
            alert("未选择合作伙伴等级！");
            subflag = false;
        }
        else if(partnerType==''){
            alert("未选择合作伙伴类型！");
            subflag = false;
        }
        else if(srvArea==''){
            alert("未填写服务区域！");
            subflag = false;
        }
        else if(srvArea.length > 50){
            alert("服务区域内容不能超过50个字。");
            subflag = false;
        }
        else if(contractNo==''){
            alert("未填写合同编号！");
            subflag = false;
        }
        else if(category==''){
            alert("未填写品类！");
            subflag = false;
        }
        else if(contactPerson==''){
            alert("未填写联系人！");
            subflag = false;
        }
        else if(contactPhone==''){
            alert("未填写联系电话！");
            subflag = false;
        }
        else if(email==''){
            alert("未填写邮箱！");
            subflag = false;
        }
        else if(bankAccount==''){
            alert("未填写银行账户！");
            subflag = false;
        }
        else if(bizScope==''){
            alert("未填写业务范围！");
            subflag = false;
        }
        else if(feePoint==''){
            alert("未填写服务费！");
            subflag = false;
        }
        else if(feePoint.length > 100){
            alert("服务费内容不能超过100个字。");
            subflag = false;
        }
        else if(remark.length > 50){
            alert("备注内容不能超过50个字。");
            subflag = false;
        }
        else if(joinTime==''){
            alert("未选择入网时间！");
            subflag = false;
        }
        else{
            subflag = true;
        }
        if(subflag){
            $('#partnerForm').submit();  //新增合作伙伴
        }
    }

    if(obj.id=='btn_celptr') {
        window.location.href = '/crm/partnermanage/viewall'; //取消新增合作伙伴
    }

    if(obj.id=='btn_addfav') {
        $('#formAddFav').submit();  //添加收藏企业
    }

    if(obj.id=='btn_celfav') {
        $('#formCelFav').submit();  //取消收藏企业
    }
}

function vieworder(obj) {
    var order_no = null;
    if (obj) {
        order_no = obj.id;  //获取要编辑订单的ID
        window.location.href = '/crm/ordermanage/editorder?order_no=' + order_no; //显示要编辑订单的信息
    }
}

function editcontract(obj) {
    var contract_no = null;
    if (obj) {
        contract_no = obj.id;  //获取要编辑合同编号
        window.location.href = '/crm/contractmanage/editcontract?contract_no=' + contract_no; //编辑合同
    }
}


function editUser(obj) {
    var member_phone = null;
    if (obj) {
        member_phone = obj.id;  //获取要编辑的用户手机号
        window.location.href = '/crm/user/edituser?member_phone=' + member_phone; //编辑用户信息
    }
}

function clicksave(obj) {
    if (obj.id == 'save_gsryjg') {
        var subflag = true;
        var int_exp = /^[0-9]*[1-9][0-9]*$/i;//用于判断输入的是否是正整数
        var rate_exp = new RegExp(/^(100|[1-9]?\d(\.\d\d?)?)%$/); //用于判断输入内容是否包含%
        var staffNumber = document.getElementById('staffNumber').value;
        var collegeRate = document.getElementById('collegeRate').value;
        var undergraduateRate = document.getElementById('undergraduateRate').value;
        var masterRate = document.getElementById('masterRate').value;
        var rdNumber = document.getElementById('rdNumber').value;
        if((staffNumber!='')&&(!int_exp.test(staffNumber))){
            alert('公司总人数，必须为正整数！');
            subflag = false ;
        }
        else if((collegeRate!='')&&(!rate_exp.test(collegeRate))){
            alert('大专以上人员占比没有%');
            subflag = false ;
        }
        else if((undergraduateRate!='')&&(!rate_exp.test(undergraduateRate))){
            alert('本科以上人员占比没有%');
            subflag = false ;
        }
        else if((masterRate!='')&&(!rate_exp.test(masterRate))){
            alert('硕士以上人员占比没有%');
            subflag = false ;
        }
        else if((rdNumber!='')&&(!int_exp.test(rdNumber))){
            alert('从事研发人数，必须为正整数！');
            subflag = false ;
        }
        else{
            subflag = true;
        }
        if(subflag) {
            $('#formGsryjg').submit();  //提交公司人员结构
        }
    }
    if (obj.id == 'save_gsjs') {
        var subflag = true;
        var corpInfo = document.getElementById('corpInfo').value;
        if(corpInfo.length > 512){
            alert("公司简介，不能超过512个字。");
            subflag = false;
        }
        var mainProduct = document.getElementById('mainProduct').value;
        if(mainProduct.length > 512){
            alert("主要产品，不能超过512个字。");
            subflag = false;
        }
        else{
            subflag = true;
        }
        if(subflag) {
            $('#formGsjs').submit();  //提交公司介绍
        }
    }
    if (obj.id == 'save_scfz') {
        var subflag = true;
        var prodBizSubmit = document.getElementById('prodBizSubmit').value;
        var curReqInfo = document.getElementById('curReqInfo').value;
        var infoSuggestions = document.getElementById('infoSuggestions').value;
        var businessPattern = document.getElementById('businessPattern').value;
        var coreCompetence = document.getElementById('coreCompetence').value;
        if(prodBizSubmit.length > 300){
            alert("产品与业务概况内容，不能超过300个字。");
            subflag = false;
        }
        else if(curReqInfo.length > 300){
            alert("信息化现状与需求内容，不能超过300个字。");
            subflag = false;
        }
        else if(infoSuggestions.length > 300){
            alert("企业信息化建议内容，不能超过300个字。");
            subflag = false;
        }
        else if(businessPattern.length > 200){
            alert("商业模式内容，不能超过200个字。");
            subflag = false;
        }
        else if(coreCompetence.length > 200){
            alert("核心竞争力内容，不能超过200个字。");
            subflag = false;
        }
        else{
            subflag = true;
        }
        if(subflag) {
            $('#formScfz').submit();  //提交市场发展
        }
    }
    if (obj.id == 'save_ssqk') {
        $('#formSsqk').submit();  //提交上市情况
    }
    if (obj.id == 'save_gszt') {
        $('#formGszt').submit();  //提交归属载体
    }
}




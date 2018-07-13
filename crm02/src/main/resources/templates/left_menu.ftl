<!--引入仪表盘页面左边菜单tree-->
<!-- BEGIN SIDEBAR -->
<div class="page-sidebar-wrapper">
    <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
    <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
    <div class="page-sidebar navbar-collapse collapse">
        <!-- BEGIN SIDEBAR MENU1 -->
        <!-- <ul class="page-sidebar-menu page-sidebar-menu-hover-submenu" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200"> 二级菜单样式-->
    <ul class="page-sidebar-menu page-sidebar-menu-hover-submenu" data-keep-expanded="true" data-auto-scroll="true"
        data-slide-speed="200">
        <li class="sidebar-toggler-wrapper">
            <div class="sidebar-toggler">
            </div>
        </li>
        <li <#if ((page >= 1)&&(page <= 10))>class="start active open" </#if>>
            <a href="/crm/contactsmanage">
                <i class="icon-user"></i>
                <span class="title">联系人</span>
                <span class="arrow"></span>
            </a>
        </li>
        <li <#if ((page >= 11)&&(page <= 20))>class="start active open" </#if>>
            <a href="#">
                <i class="icon-puzzle"></i>
                <span class="title">企业信息维护</span>
                <span class="arrow "></span>
                <ul class="sub-menu">
                    <li>
                        <a href="/crm/enterpriseimp"><i class="icon-envelope-open"></i>模板导入</a>
                    </li>
                    <li>
                        <a href="/crm/enterprisefav/viewfav"><i class="icon-envelope-open"></i>企业收藏夹</a>
                    </li>
                    <li>
                        <a href="/crm/enterpriseupt/viewupt"><i class="icon-envelope-open"></i>档案更新企业</a>
                    </li>
                </ul>
            </a>
        </li>
        <li <#if ((page >= 51)&&(page <= 60))>class="start active open" </#if>>
            <a href="/crm/contractmanage/viewall">
                <i class="icon-docs"></i>
                <span class="title">合同管理</span>
                <span class="arrow"></span>
            </a>
        </li>
        <li <#if ((page >= 61)&&(page <= 70))>class="start active open" </#if>>
            <a href="/crm/partnermanage/viewall">
                <i class="icon-paper-plane"></i>
                <span class="title">合作伙伴管理</span>
                <span class="arrow"></span>
            </a>
        </li>
        <li <#if ((page >= 21)&&(page <= 30))>class="start active open" </#if>>
            <a href="#">
                <i class="icon-diamond"></i>
                <span class="title">营销管理</span>
                <span class="arrow"></span>
                <ul class="sub-menu">
                    <li>
                        <a href="/crm/marketing/reachcsr/reachlist"><i class="icon-envelope-open"></i>客户触达 </a>
                    </li>
                    <li>
                        <a href="/activity/list"><i class="icon-handbag"></i>活动管理 </a>
                    </li>
                </ul>
            </a>
        </li>
        <li <#if ((page >= 41)&&(page <= 50))>class="start active open" </#if>>
            <a href="/crm/ordermanage/viewall">
                <i class="icon-basket"></i>
                <span class="title">订单管理</span>
                <span class="arrow"></span>
            </a>
        </li>

    <#if '${user.memberType}'=='1'>
        <li>
            <a href="/dynamicReport/list">
                <i class="icon-basket"></i>
                <span class="title">动态报表管理</span>
                <span class="arrow"></span>
            </a>
        </li>
    </#if>
    <#if '${user.memberType}'=='11'||'${user.memberType}'=='12'|| '${user.memberType}'=='1'>
    <li>
    <a href="#">
        <i class="icon-diamond"></i>
        <span class="title">数据录入</span>
        <span class="arrow"></span>
    <ul class="sub-menu">
        <#if '${user.memberType}'=='11'||'${user.memberType}'=='1'>
            <li>
                <a href="/financeinput/list"><i class="icon-envelope-open"></i>初录 </a>
            </li>

            <li>
                <a href="/financeinput/dynamicReportDataFirstList">
                    <i class="icon-envelope-open"></i>动态报表初录 </a>
        </a>
        </li>
        </#if>
        <#if '${user.memberType}'=='12'||'${user.memberType}'=='1'>
            <li>
                <a href="/financeinput/copylist"><i class="icon-handbag"></i>复录 </a>
            </li>

            <li>
                <a href="/financeinput/dynamicReportDataSecondList">
                    <i class="icon-envelope-open"></i>动态报表复录 </a>
                </a>
            </li>
        </#if>
    </ul>
        </a>
        </li>
    </#if>
        </ul>
        <!-- END SIDEBAR MENU1 -->
    </div>
</div>

<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
    <!-- BEGIN HEADER INNER -->
    <div class="page-header-inner">
        <!-- BEGIN LOGO -->
        <div class="page-logo">
            <a href="#">
                <img src="/img/logo.png" alt="logo" class="logo-default"/>
            </a>
        </div>
        <div class="hor-menu hidden-sm hidden-xs">
            <ul class="nav navbar-nav">
                <#--<li <#if ((page> 150)&&(page<= 200))> class="classic-menu-dropdown active" </#if>>
                    <a href="/crm/workbench">
                        我的工作台<span class="selected">
					</span>
                    </a>
                </li>-->
                <li <#if ((page> 100)&&(page<= 150))> class="classic-menu-dropdown active" </#if>>
                    <a data-toggle="dropdown" href="javascript:;">
                        数据看板 <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu pull-left">
                    <#--<li>
                        <a href="/data/realtime">
                            <i class="fa fa-angle-down"></i> 实时直播间 </a>
                    </li>-->
                        <li>
                            <a href="/data/keyindex">
                                <i class="fa fa-angle-down"></i>数据大盘 </a>
                        </li>
                        <li>
                            <a href="/data/report">
                                <i class="fa fa-angle-down"></i>业务运营 </a>
                        </li>
                    </ul>
                </li>
                <li <#if (page<=100)> class="classic-menu-dropdown active" </#if>>
                    <a href="/crm/contactsmanage">
                        客户关系管理 <span class="selected">
					</span>
                    </a>
                </li>
                <#--
                <li <#if ((page>= 41)&&(page< 50))> class="classic-menu-dropdown active" </#if>>
                    <a href="/crm/myservice">
                        我服务的企业<span class="selected">
					</span>
                    </a>
                </li>
                -->
                <#if user??>
                    <#if '${user.memberType}'=='1'||'${user.memberType}'=='2'||'${user.memberType}'=='90'>  <!--如果是一般用户不显示下面菜单-->
                        <li <#if (page == 210)> class="classic-menu-dropdown active" </#if>>
                            <a href="/crm/enterprisebank">
                                企业信息库<span class="selected">
					            </span>
                            </a>
                        </li>
                    </#if>
                </#if>
                <li <#if (page == 220)> class="classic-menu-dropdown active" </#if>>
                    <a href="/crm/invevent">
                        中国投融资数据<span class="selected">
					</span>
                    </a>
                </li>
                <#--<li class="classic-menu-dropdown">
                    <a data-toggle="dropdown" href="javascript:;">
                        我的资源 <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu pull-left">
                        <li>
                            <a href="#">
                                <i class="fa fa-angle-down"></i> 图形 </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-angle-down"></i> 表格 </a>
                        </li>
                    </ul>
                </li>
                <li class="classic-menu-dropdown">
                    <a data-toggle="dropdown" href="javascript:;">
                        数据源 <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu pull-left">
                        <li>
                            <a href="#">
                                <i class="fa fa-angle-down"></i> 数据库 </a>
                        </li>
                        <li>
                            <a href="/rest/page/sjy_data_set">
                                <i class="fa fa-angle-down"></i> 数据集 </a>
                        </li>
                    </ul>
                </li>
                <li class="classic-menu-dropdown">
                    <a data-toggle="dropdown" href="javascript:;">
                        资源管理 <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu pull-left">
                        <li>
                            <a href="/resmgt/createChart">
                                <i class="fa fa-angle-down"></i> 创建图形 </a>
                        </li>
                        <li>
                            <a href="/resmgt/createTable">
                                <i class="fa fa-angle-down"></i> 创建表格 </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-angle-down"></i> 图形列表 </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-angle-down"></i> 表格列表 </a>
                        </li>
                    </ul>
                </li>-->
            <#if '${(user.memberType)?if_exists}' == '1'>  <!--如果是管理员才显示下面菜单-->
                <li <#if (page == 300)> class="classic-menu-dropdown active" </#if>>
                    <a data-toggle="dropdown" href="javascript:;">
                        权限管理 <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu pull-left">
                        <li>
                            <a href="/crm/user/viewall">
                                <i class="fa fa-angle-down"></i> 用户管理 </a>
                        </li>
                        <#--<li>
                            <a href="#">
                                <i class="fa fa-angle-down"></i> 用户权限设置 </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-angle-down"></i> 用户列表 </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-angle-down"></i> 角色列表 </a>
                        </li>-->
                    </ul>
                </li>
            </#if>
            </ul>
        </div>
        <form class="search-form" action="extra_search.html" method="GET">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search..." name="query">
                <span class="input-group-btn">
				<a href="#" class="btn submit"><i class="icon-magnifier"></i></a>
				</span>
            </div>
        </form>
        <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
        </a>
        <div class="top-menu">
            <ul class="nav navbar-nav pull-right"><#--
                <li class="dropdown dropdown-extended dropdown-notification" id="header_notification_bar">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                        <i class="icon-bell"></i>
                        <span class="badge badge-default">2 </span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="external">
                            <h3><span class="bold">2条告警信息</span> </h3>
                            <a href="#">view all</a>
                        </li>
                        <li>
                            <ul class="dropdown-menu-list scroller" style="height: 250px;" data-handle-color="#637283">
                                <li>
                                    <a href="javascript:;">
                                        <span class="time">just now</span>
                                        <span class="details">
									<span class="label label-sm label-icon label-success">
									<i class="fa fa-plus"></i>
									</span>	告警1 </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:;">
                                        <span class="time">3 mins</span>
                                        <span class="details">
									<span class="label label-sm label-icon label-danger">
									<i class="fa fa-bolt"></i>
									</span>	告警2</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>-->
                <li class="dropdown dropdown-user">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                        <img alt="" class="img-circle" src="/assets/admin/layout/img/avatar3_small.jpg"/>
                        <span class="username username-hide-on-mobile">
                            <#if user??>
                                ${user.userName?if_exists!''}
                            <#else>
                                欢迎您！
                            </#if>
                        </span>
                        <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-default">
                        <li>
                            <a href="#">
                                <i class="icon-user"></i> 用户信息
                            </a>
                        </li>
                        <li>
                            <a href="/crm/updatepassword/view">
                                <i class="icon-lock"></i> 修改密码
                            </a>
                        </li>
                        <li>
                            <a href="/logout">
                                <i class="fa fa-key"></i> 退出
                            </a>
                        </li>
                    </ul>
                </li>
                <!-- END USER LOGIN DROPDOWN -->
            </ul>
        </div>
        <!-- END TOP NAVIGATION MENU -->

    </div>
    <!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
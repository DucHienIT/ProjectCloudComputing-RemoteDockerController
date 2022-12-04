<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="topbar" data-navbarbg="skin5">
	<nav class="navbar top-navbar navbar-expand-md navbar-dark">
		<div class="navbar-header" data-logobg="skin6">
			<!-- ============================================================== -->
			<!-- Logo -->
			<!-- ============================================================== -->
			<a class="navbar-brand" href="<c:url value ="/adminhome"/>"> <!-- Logo icon -->
				<b class="logo-icon"> <!-- Dark Logo icon --> <img
					src="<c:url value= "/templates/home/plugins/images/logo-icon.png" />"
					alt="homepage" />
			</b> <!--End Logo icon --> <!-- Logo text --> <span class="logo-text">
					<!-- dark Logo text --> <img
					src="<c:url value= "/templates/home/plugins/images/logo-text.png"/>"
					alt="homepage" />
			</span>
			</a>
			<!-- ============================================================== -->
			<!-- End Logo -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- toggle and nav items -->
			<!-- ============================================================== -->
			<a
				class="nav-toggler waves-effect waves-light text-dark d-block d-md-none"
				href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
		</div>
		<!-- ============================================================== -->
		<!-- End Logo -->
		<!-- ============================================================== -->
		<div class="navbar-collapse collapse" id="navbarSupportedContent"
			data-navbarbg="skin5">
			<ul class="navbar-nav d-none d-md-block d-lg-none">
				<li class="nav-item"><a
					class="nav-toggler nav-link waves-effect waves-light text-white"
					href="javascript:void(0)"><i class="ti-menu ti-close"></i></a></li>
			</ul>
			<!-- ============================================================== -->
			<!-- Right side toggle and nav items -->
			<!-- ============================================================== -->
			<ul class="navbar-nav ms-auto d-flex align-items-center">
				<!-- ============================================================== -->
				<!-- User profile and search -->
				<!-- ============================================================== -->
			</ul>
		</div>
	</nav>
</header>
<!-- ============================================================== -->
<!-- End Topbar header -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- Left Sidebar - style you can find in sidebar.scss  -->
<!-- ============================================================== -->
<aside class="left-sidebar" data-sidebarbg="skin6">
	<!-- Sidebar scroll-->
	<div class="scroll-sidebar">
		<!-- Sidebar navigation-->
		<nav class="sidebar-nav">
			<ul id="sidebarnav">
				<!-- User Profile-->
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="<c:url value ="/adminhome"/>" aria-expanded="false"> <i
						class="fa fa-user" aria-hidden="true"></i> <span class="hide-menu">Danh sách tài khoản</span>
				</a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="<c:url value ="/views/addserver.jsp"/>" aria-expanded="false"> <i
						class="fa fa-clock" aria-hidden="true"></i> <span class="hide-menu">Thêm server</span>
				</a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="<c:url value ="/views/deleteserver.jsp"/>" aria-expanded="false"> <i
						class="fa fa-clock" aria-hidden="true"></i> <span class="hide-menu">Xóa server</span>
				</a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					 aria-expanded="false"> <i
						class="fa fa-table" aria-hidden="true"></i> <span
						class="hide-menu">Quản lý Container các Server</span>
				</a></li>

                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				<li class="sidebar-item">
				<select
				style="width: 100%;border:0px;outline:0px;" 				
				class="sidebar-link waves-effect waves-dark sidebar-link"
					name="server" onchange="location = this.value;">
					    <option value=""> 
					    	->	Container server ${server}
					    </option>
						<c:forEach items="${listserver}" var="server">
							<option
								value="<c:url value ="/admincontainer?server=${server.id_server}"/>">
								${server.ip_server}( server ${server.id_server} )
								</option>
						</c:forEach>
				</select>
				</li>
				  <li class="sidebar-item pt-2">
                            <a class="sidebar-link waves-effect waves-dark sidebar-link" href="<c:url value ="/history"/>" aria-expanded="false">
                                <i class="far fa-clock" aria-hidden="true"></i>
                                <span class="hide-menu">Lịch sử </span>
                            </a>
                        </li>
			</ul>

		</nav>
		<!-- End Sidebar navigation -->
	</div>
	<!-- End Sidebar scroll-->
</aside>
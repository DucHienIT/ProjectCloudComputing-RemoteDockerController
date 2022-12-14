<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<%@ include file="header.jsp"%>
</head>

<body>
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<%@ include file="homeleftbar.jsp"%>
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb">
				<div class="row align-items-center">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Quản lý container</h4>
						
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
						<div class="d-md-flex">
							<ol class="breadcrumb ms-auto">
								<li><a href="<c:url value = "/logout"/>"
									class="btn btn-danger  d-none d-md-block pull-right ms-3 hidden-xs hidden-sm waves-effect waves-light text-white">Đăng
										xuất</a>
							</ol>
						</div>
					</div> 
				</div>

				<!-- /.col-lg-12 -->
			</div>
			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid" style="background-color: #dedea2">
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<h3 class="box-title">Các Container đã tạo</h3>
							<!--  <a href="<c:url value="/shutdownall?server=1"/>"
															class="btn btn-success text-white ">Stop all</a>--> 
							
							
							<div class="table-responsive">
								<table class="table text-nowrap">
									<thead>
										<tr>
											<th class="border-top-0">CONTAINER ID</th>
											<th class="border-top-0">NAMES</th>
											<th class="border-top-0">CREATED</th>
											<th class="border-top-0">STATUS</th>
											<th class="border-top-0">PORTS</th>
											<th class="border-top-0">IMAGE</th>
											<th class="border-top-0">Chức năng</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach begin="1" items="${listC}" var="o">
											<tr>
												<td>${o.id}</td>
												<td>${o.name}</td>
												<td>${o.created}</td>
												<td>${o.status}</td>
												<td>${o.ports}</td>
												<td>${o.image}</td>
												<td>	
													<div class="btn-group btn-group-justified">
														<a href="<c:url value="/connect?name=${o.name}&&server=${server}"/>" target="_blank"
															class="btn btn-info text-white ">Kết nối</a> 
														<a href="<c:url value="/startC?cid=${o.id}&&name=${o.name}&&server=${server}"/>"
															class="btn btn-success text-white ">Khởi động</a> 
															<a
															href="<c:url value="/stopC?cid=${o.id}&&server=${server}"/>"
															class="btn btn-danger text-white">Tắt</a> <a href="<c:url value="/removeC?cid=${o.name}&&server=${server}"/>"
															 class="btn btn-warning text-white ">Xóa</a>
															 <a href="<c:url value="/createimage?cid=${o.id}&&name=${o.name}&&server=${server}"/>"
															 class="btn btn-primary text-white ">Tạo Image</a>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<h3 class="box-title">Các Volume</h3>
							<div class="table-responsive">
								<table class="table text-nowrap">
									<thead>
										<tr>
											<th class="border-top-0">DRIVER</th>
											<th class="border-top-0">NAME</th>
											<th class="border-top-0">CHỨC NĂNG</th>
											
										</tr>
									</thead>
									<tbody>
										<c:forEach begin="1" items="${listV}" var="o">
											<tr>
												<td>${o.driver}</td>
												<td>${o.name}</td>
												
												<td>	
													<div class="btn-group btn-group-justified">
														 <a href="<c:url value="/removeV?vname=${o.name}&&server=${server}"/>"
															 class="btn btn-warning text-white ">Xóa</a>
															 <a href="<c:url value="/createCinV?name=${o.name}&&server=${server}"/>"
															 class="btn btn-primary text-white ">Tạo Container</a>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- ============================================================== -->
				<!-- End PAge Content -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- Right sidebar -->
				<!-- ============================================================== -->
				<!-- .right-sidebar -->
				<!-- ============================================================== -->
				<!-- End Right sidebar -->
				<!-- ============================================================== -->
			</div>
			<!-- ============================================================== -->
			<!-- End Container fluid  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- footer -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- End footer -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
	<script
		src="<c:url value= "/templates/home/plugins/bower_components/jquery/dist/jquery.min.js"/>"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script
		src="<c:url value= "/templates/home/bootstrap/dist/js/bootstrap.bundle.min.js"/>"></script>
	<script
		src="<c:url value= "/templates/home/js/app-style-switcher.js"/>"></script>
	<!--Wave Effects -->
	<script src="<c:url value= "/templates/home/js/waves.js"/>"></script>
	<!--Menu sidebar -->
	<script src="<c:url value= "/templates/home/js/sidebarmenu.js"/>"></script>
	<!--Custom JavaScript -->
	<script src="<c:url value= "/templates/home/js/custom.js"/>"></script>
</body>

</html>
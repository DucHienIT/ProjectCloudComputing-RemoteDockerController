<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Cloud</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png"
	href="<c:url value= "/templates/images/icons/favicon.ico"/>" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/templates/vendor/bootstrap/css/bootstrap.min.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/templates/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/templates/fonts/Linearicons-Free-v1.0.0/icon-font.min.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/templates/vendor/animate/animate.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/templates/vendor/css-hamburgers/hamburgers.min.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/templates/vendor/animsition/css/animsition.min.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/templates/vendor/select2/select2.min.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/templates/vendor/daterangepicker/daterangepicker.css"/>">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/templates/css/util.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/templates/css/main.css"/>">
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('templates/images/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41"> Đăng nhập Server </span>
				<form class="login100-form validate-form p-b-33 p-t-5"
					action="<c:url value="/login"/>" method="POST">
					<c:if test="${mess == 1}">
					<p class="text-danger text-center">Tên đăng nhập hoặc mật khẩu không chính xác</p>
					</c:if>
					<div class="wrap-input100 validate-input"
						data-validate="Enter username">
						<input class="input100" type="text" name="username"
							placeholder="Nhập username"> <span class="focus-input100"
							data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Enter password">
						<input class="input100" type="password" name="pass"
							placeholder="Nhập mật khẩu"> <span class="focus-input100"
							data-placeholder="&#xe80f;"></span>
					</div>

					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn">Đăng nhập</button>
					</div>
				</form>
				<div class="text-center">
					<a class="txt2" href="<c:url value ="/register"/>"> Tạo tài
						khoản <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
					</a>
				</div>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script
		src="<c:url value= "/templates/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value= "/templates/vendor/animsition/js/animsition.min.js"/>"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value= "/templates/vendor/bootstrap/js/popper.js"/>"></script>
	<script
		src="<c:url value= "/templates/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value= "/templates/vendor/select2/select2.min.js"/>"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value= "/templates/vendor/daterangepicker/moment.min.js"/>"></script>
	<script
		src="<c:url value= "/templates/vendor/daterangepicker/daterangepicker.js"/>"></script>
	<!--===============================================================================================-->
	<script
		src="<c:url value= "/templates/vendor/countdowntime/countdowntime.js"/>"></script>
	<!--===============================================================================================-->
	<script src="<c:url value= "/templates/js/main.js"/>"></script>

</body>
</html>
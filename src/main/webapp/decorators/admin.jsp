<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Dashboard</title>

<!-- Custom fonts for this template-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link
	href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->

<link href=" <c:url value='/template/admin/css/sb-admin-2.min.css' />"
	rel="stylesheet">

</head>
<body id="page-top">

	<div id="wrapper">

		<%@ include file="/common/admin/Menu.jsp"%>
		<!-- footer -->

		<!-- header -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<%@ include file="/common/admin/header.jsp"%>
				<dec:body />
				<!-- header -->
			</div>
			<!-- footer -->
			<%@ include file="/common/admin/footer.jsp"%>
			<!-- footer -->
		</div>



	</div>

	<!-- Bootstrap core JavaScript-->

	<script
		src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js' />"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/template/admin/js/sb-admin-2.min.js' />"></script>

	<script 
		src="<c:url value='/template/js/product.js'/>"></script>
		<script 
		src="<c:url value='/template/js/category.js'/>"></script>
		<script 
		src="<c:url value='/template/js/user.js'/>"></script>
			<script 
		src="<c:url value='/template/js/role.js'/>"></script>
				<script 
		src="<c:url value='/template/js/size.js'/>"></script>
		
</body>
</html>
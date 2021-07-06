<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="stylesheet"
	href="<c:url value='/template/login/signin/assets/css/login.css' />">
<link rel="stylesheet"
	href="<c:url value='/template/login/signin/assets/font/fontawesome-free-5.15.3-web/fontawesome-free-5.15.3-web/css/all.min.css' />">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css">
<link rel="stylesheet"
	href="<c:url value='/template/web/assets2/css/grid.css' />">
<link rel="stylesheet"
	href="<c:url value='/template/web/assets2/css/basee.css' />">
<link rel="stylesheet"
	href="<c:url value='/template/web/assets2/css/style.css' />">
<link rel="stylesheet"
	href="<c:url value='/template/web/assets2/font/fontawesome-free-5.15.3-web/fontawesome-free-5.15.3-web/css/all.min.css' />">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="  https://cdn.jsdelivr.net/npm/pretty-checkbox@3.0/dist/pretty-checkbox.min.css">
	
	
 <link rel="stylesheet"
	href="<c:url value='/template/web/cart/assets/css/main.css' />"> 
<%-- <link rel="stylesheet"
	href="<c:url value='/template/web/cart2/assets/css/grid.css' />">
<link rel="stylesheet"
	href="<c:url value='/template/web/cart2/assets/font/fontawesome-free-5.15.3-web/fontawesome-free-5.15.3-web/css/all.min.css' />">  --%>
	
</head>
<body>

	<div class="app">

		<!-- header -->
		<%@ include file="/common/web/header.jsp"%>
		<!-- header -->

		<dec:body />

		<!-- footer -->
		<%@ include file="/common/web/footer.jsp"%>
		<!-- footer -->


	</div>
	<script
		src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
		<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js">
	
</script>

	<%-- 			<script 
		src="<c:url value='/template/js/addCart.js'/>"></script> --%>
		<script 
		src="<c:url value='/template/js/addCart.js'/>"></script>
	<%-- 	<script 
		src="<c:url value='/template/js/searchProduct.js'/>"></script> --%>
		 <script>
		function searchFunction() {
			event.preventDefault();
			var form = $('#formSearch')[0];

			var data = new FormData(form);
			$.ajax({
				url : "/baitaplon/trang-chu/search",
				type : "post",
				enctype : 'multipart/form-data',
				data : data,
				processData : false,
				contentType : false,
				cache : false,
				success : function(result) {
				alert("oke lunn");
				window.location
				.replace("http://localhost:8080/baitaplon/trang-chu/san-pham-search");


				},
				error : function(e) {
					alert("van nguuu");
				}
				});
			
		}
		
		
	</script>  
</body>
</html>
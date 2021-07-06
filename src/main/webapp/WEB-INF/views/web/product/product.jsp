<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js">
	
</script>
</head>
<body>


	<div class="slider">
		<div>

			<img src="<c:url value='/template/web/assets/img/aman.png' />" alt="">

		</div>

	</div>
	<div class="container">
		<div class="grid ">
			<div class="row">
				<div class="col l-12">
					<div class="product__distance">
						<h1 class="product__distance-name"></h1>
					</div>
				</div>
			</div>
			<!--  for -->
			
				<div class="row">

					<c:forEach var="product" items="${lstProduct}" varStatus="loop">
						<div class="col l-4 m-6 c-12">
							<a href="<c:url value='/trang-chu/san-pham/thong-tin-san-pham/${product.id}' />" class="product__item" id="information"
								onclick="theFunction(${product.id}, ${product.code})"> 
								<img class="product__item-img"
								src="data:image/jpg;base64,<c:out value="${product.image}"/>" />
								<h4 class="product__item-name">${product.name}</h4>
								<div class="product__item-price">
									<div class="product-item__price-current">${product.price}VND</div>
								</div> 
							</a>
						</div>
					</c:forEach>

				</div>
			
			<!-- for -->


			<div class="row">
				<div class="col l-12">
					<div class="product__distance"></div>
				</div>
			</div>

		</div>
	</div>

	<!-- <script>
		function theFunction(index, code) {
			event.preventDefault();
			 get(index,code);
		}
		
		function get(id,code) {
			event.preventDefault();
			var data= {"id": id,"code":code};
			$.ajax({
				url : "/baitaplon/trang-chu/san-pham/thong-tin-san-pham",
				type : "post",
				data : data,
				dataType: "json",
				cache : false,
				success : function(result) {
					window.location
					.replace("http://localhost:8080/baitaplon/trang-chu/san-pham/thong-tin-san-pham");
					
					
				},
				error : function(e) {
					
				}
			});
	    }
	</script>  -->

</body>
</html>
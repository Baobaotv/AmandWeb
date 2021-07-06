<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value='/template/web/information/assets/css/style.css' />">
	
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js">
	
</script>
</head>
<body>
	<div class="row">
		<div class="col l-12">
			<div class="product__distance"></div>
		</div>
	</div>
	<div class="container">
		<div class="grid "></div>
		<div class="row">
			<div class="col l-12">
				<div class="product__distance"></div>
			</div>
		</div>
		<form enctype="multipart/form-data" id="formSubmit">
		
		<div class="row">
				<div class="col l-9 l-o-2">
					<div class="product__item-new">
						<img src="data:image/jpg;base64,<c:out value="${product.image}"/>" alt=""
							class="product__item-new-img" name="image">
						<div class="product__item-info">
							<h3 class="product__item-heading">${product.name}</h3>
							<div class="special__price">
								<span class="product__item-current">${product.price}VND</span>
							</div>



							<div class="DIV">
								<p class="text-quantity">Kích Thước</p>
							</div>
							<div id="radiobut">

								<div class="abc">
							<%-- 	<c:forEach items="${lstSizeDTO}" var="size">
								<div class="pretty p-icon p-curve p-tada">
										<input type="radio" name="radio66" name="sizeId" value="${size.id}">
										<div class="state p-primary-o">
											<i class="icon fa fa-check" aria-hidden="true"></i> <label>${size.name}</label>
										</div>
									</div>
								
													
													<input class="product__color-text" type="hidden" name="sizeName" id="sizeName"
										value="${size.name}"></>
										
												</c:forEach> --%>
													<select name="sizeId" class="custom-select col-md-7"
												id="sizeId">
												<option selected>Chọn Size</option>
												<c:forEach items="${lstSizeDTO}" var="size">
													<option value="${size.id}">${size.name}</option>
													<input class="product__color-text" type="hidden" name="sizeName" id="sizeName"
										value="${size.name}"></>
												</c:forEach>
											</select>

								</div>


							</div>

							<div class="DIV2">
								<p class="text-quantity">Số Lượng</p>
							</div>
							<div class="quantity">
							
									<input class="product__color-text" type="number" step="1" id="number"
												min="1" name="number" value="1"></>
							</div>
							
							<input class="product__color-text" type="hidden" name="code" id="code"
										value="${product.code}"></>
										<input class="product__color-text" type="hidden" name="name" id="name"
										value="${product.name}"></>
										
										
									<input class="product__color-text" type="hidden" name="price" id="price"
										value="${product.price}"></> 
										<input class="product__color-text" type="hidden" name="img" id="img"
										value="${product.image}"></> 


							<!-- <i class="fas  product__color-icon fa-check"></i> -->
							<security:authorize access = "isAnonymous()">
								<div class="button">
									<button class="btn btn--primary" id="btnNotLogin" type="button">Add To
										Cart</button>
									<button class="btn btn--primary" id="btnNotLogin1" type="button">Buy Now</button>
								</div>
								
								</security:authorize>
								
								<security:authorize access = "isAuthenticated()">
								<div class="button">
									<button class="btn btn--primary" id="addCart" type="button">Add To
										Cart</button>
									<button class="btn btn--primary">Buy Now</button>
								</div>
								</security:authorize>
						

							<div class="product__detail">
								<a href="./information/information.html"
									class="product__detail-link">Chi tiết sản phẩm </a>
							</div>
						</div>
					</div>

				</div>
			</div>
				</form>
		
		
		</div>
	<div class="row">
		<div class="col l-12">
			<div class="product__distance"></div>
		</div>
	</div>
		<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script
	src="https://code.jquery.com/jquery-3.6.0.min.js">
	
</script>
</script>
	
	<script type="text/javascript">
	 $("#btnNotLogin").click(function() {
		 alert("Bạn phải đăng nhập đê sử dụng chức năng này");
	 
	 });
	 
	 $("#btnNotLogin1").click(function() {
		 alert("Bạn phải đăng nhập đê sử dụng chức năng này");
	 
	 });
	
	</script>

</body>
</html>
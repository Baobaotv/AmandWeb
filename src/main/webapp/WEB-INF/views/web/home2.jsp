<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="slider">
		<div class="content-slider">
			<img src="<c:url value='/template/web/assets/img/aman.png' />" alt=""
				class="slider__img">
		</div>
	</div>

	<div class="container">
		<div class="grid ">
			<div class="row">
				<div class="col l-12">
					<div class="product__distance">
						<h1 class="product__distance-name">T-SHIRST</h1>
					</div>
				</div>
			</div>

			<div class="row">
				<c:forEach var="product" items="${lstProduct}" varStatus="loop">
					<div class="col l-4 m-6 c-12">
						<a
							href="<c:url value='/trang-chu/san-pham/thong-tin-san-pham/${product.id}' />"
							class="product__item" id="information"
							onclick="theFunction(${product.id})"> <img
							src="data:image/jpg;base64,<c:out value="${product.image}"/>"
							alt="" class="product__item-img">
							<h4 class="product__item-name">${product.name}</h4>
							<div class="product__item-price">
								<div class="product-item__price-current">${product.price}VND</div>
							</div>

						</a>
					</div>
				</c:forEach>


			</div>
			<footer class="footer__btn">
				<a href="" class="footer__btn-xtc"> Xem tất Cả </a>
			</footer>


			<div class="row">
				<div class="col l-12">
					<div class="product__distance">
						<h1 class="product__distance-name">SẢN PHẨM NỔI BẬT</h1>
					</div>
				</div>
			</div>

			<form enctype="multipart/form-data" id="formSubmit">
				<div class="row">
					<div class="col l-9 l-o-2">
						<div class="product__item-new">

							<img
								src="data:image/jpg;base64,<c:out value="${productRandom.image}"/>"
								alt="" class="product__item-new-img" name="image">
							<div class="product__item-info">
								<h3 class="product__item-heading">${productRandom.name}</h3>
								<div class="special__price">
									<span class="product__item-current">${productRandom.price}VND</span>
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

											</c:forEach>
										</select>

									</div>


								</div>

								<div class="DIV2">
									<p class="text-quantity">Số Lượng</p>
								</div>
								<div class="quantity">
									<!-- <input
									onclick="var result = document.getElementById('quantity'); var qty = result.value; if( !isNaN(qty) &amp; qty > 1 ) result.value--;return false;"
									type='button' value='-' /> <input id='quantity' min='1'
									name='quantity' type='text' value='1' /> <input
									onclick="var result = document.getElementById('quantity'); var qty = result.value; if( !isNaN(qty)) result.value++;return false;"
									type='button' value='+' /> -->
									<input class="product__color-text" type="number" step="1"
										id="number" min="1" name="number"  value="1"></>
								</div>
								<input class="product__color-text" type="hidden" name="code"
									id="code" value="${productRandom.code}"></> <input
									class="product__color-text" type="hidden" name="name" id="name"
									value="${productRandom.name}"></> <input
									class="product__color-text" type="hidden" name="price"
									id="price" value="${productRandom.price}"></>
								
									 <input
									class="product__color-text" type="hidden" name="img" id="img"
									value="${productRandom.image}"></>


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


			<div class="row">
				<div class="col l-12">
					<div class="product__distance">
						<h1 class="product__distance-name">JEAMS & SORT</h1>
					</div>
				</div>
			</div>



			<div class="row">


				<c:forEach var="productA" items="${lstProductA}" varStatus="loop">
					<div class="col l-4 m-4 c-12">
						<a
							href="<c:url value='/trang-chu/san-pham/thong-tin-san-pham/${productA.id}' />"
							class="product__item" onclick="theFunction(${productA.id})"
							id="information"> <img
							src="data:image/jpg;base64,<c:out value="${productA.image}"/>"
							alt="" class="product__item-img">
							<h4 class="product__item-name">${productA.name}</h4>
							<div class="product__item-price">
								<div class="product-item__price-current">${productA.price}VND</div>
							</div>

						</a>
					</div>
				</c:forEach>


			</div>

			<footer class="footer__btn">
				<a href="" class="footer__btn-xtc"> Xem tất Cả </a>
			</footer>

			<div class="row">
				<div class="col l-12">
					<div class="product__distance"></div>
				</div>
			</div>

			<div class="row">
				<div class="col l-12">
					<div class="introduce">
						<img
							src="https://bizweb.dktcdn.net/100/358/122/themes/788488/assets/img_tab_1.jpg?1621838958247"
							alt="" class="introduce__img">
						<p class="introduce__text">Ra đời vào những ngày đầu
							năm 2014 mang tên "AMAND" nằm trên con đường 33 Quán
							Thánh, Hà Nội - thương hiệu do người Việt phát triển
							cùng niềm đam mê bất tận với thời trang của "anh
							bạn trẻ" đầy nhiệt huyết</p>

					</div>


				</div>
			</div>

			<div class="row">
				<div class="col l-12">
					<div class="product__distance"></div>
				</div>
			</div>
			<div class="row">
				<div class="col l-12">
					<div class="product__distance">
						<h1 class="product__distance-name">T-SHIRST</h1>
					</div>
				</div>
			</div>

			<div class="row">


				<c:forEach var="productQB" items="${lstProductQB}" varStatus="loop">
					<div class="col l-4 m-4 c-12">
						<a
							href="<c:url value='/trang-chu/san-pham/thong-tin-san-pham/${productQB.id}' />"
							class="product__item" id="information"
							onclick="theFunction(${productQB.id})"> <img
							src="data:image/jpg;base64,<c:out value="${productQB.image}"/>"
							alt="" class="product__item-img">
							<h4 class="product__item-name">${productQB.name}</h4>
							<div class="product__item-price">
								<div class="product-item__price-current">${productQB.price}VND</div>
							</div>

						</a>
					</div>
				</c:forEach>
			</div>


			<footer class="footer__btn">
				<a href="" class="footer__btn-xtc"> Xem tất Cả </a>
			</footer>


			<div class="row">
				<div class="col l-12">
					<div class="product__distance"></div>
				</div>
			</div>

		</div>
	</div>
		   <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js">
	
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
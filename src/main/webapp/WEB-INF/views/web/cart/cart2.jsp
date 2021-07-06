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
		
		 <div class="cart">
            <div class="grid wide">
                <div class="row">
                    <div class="col l-6">
                        <div class="product__cart">
                            <div class="header__cart">
                                <h3>Giỏ Hàng</h3>
                            </div>
                            <c:forEach items="${lstcart}" var="cart" varStatus="loop">
    
                            <div class="cart__infor">
                                <img style="width:100px ;height:150px"
									src="data:image/jpg;base64,<c:out value="${cart.file}"/>"
									name="image" class="cart__img">
    
                                <div class="cart__intro">
                                    <ul class="cart__list cart__list--active ">
                                        <li class="cart__item-icon">
                                            <!-- <div class="cart__bonus"> -->
                                                <span class="icon__heading">${cart.name}</span>
                                                <a href="" class="icon__delete-link" 
                                                onclick="deleteFunction(${loop.index})">
                                                    <!-- icon-delete -->
                                                    <i class="fas icon-delete fa-times"></i>
                                                </a>

                                            <!-- </div> -->
                                        </li>
                                        <li class="cart__item">${cart.price} VNĐ</li>
                                        <li class="cart__item">${cart.sizeName}</li>
                                        <li class="cart__item-price">
                                            <div class="cart__price">
                                                <span class="price__text">Số lượng :${cart.number}</span>
                                                
                                                <span class="price__current">500.000vnd</span>
                                            </div>
                                        </li>
                                         <c:if test = "${cart.number > cart.qty}">
                                         <li class="cart__item">
                                         <span class="price__text" style="color: red">Sản phẩm đã hết hàng, vui lòng chọn lại</span>
                                         </li>
                                         </c:if>
                                    </ul>
                                </div>

                               
                            </div>
                            </c:forEach>
                          
    
                            
                        </div>
                    </div>

                    <div class="col l-6">
                        <div class="infor__pay">
                            <div class="header__cart">
                                <h3>Thông tin thanh toán  </h3>
                            </div>

                            <div class="infor__value">
                                <span class="value__text">Giá Trị</span>
                                <span class="infor__current">${totalPrice} VNĐ</span>
                            </div>

                            <div class="infor__transport">
                                <span class="transport__text">vận chuyển</span>
                                <span class="transport__current">30.000vnd</span>
                            </div>

                            <div class="infor__total">
                                <span class="total__text">Tổng</span>
                                <span class="total__current">0</span>
                            </div>
							
							
							<c:if test = "${check=='true'}">
							 <div class="abc">
                                <label  for ="check-input" class="delivery">THANH TOÁN </label>
                            </div>
							</c:if>
							<c:if test = "${check=='false'}">
							 <div class="abc">
							  <button type="button" class="delivery" value="Cập Nhật" id="btnOutOfStock" style="background: red ; font-size: large"> Đặt hàng </button>
                                
                            </div>
							</c:if>
							
                           
                            <input type="checkbox" hidden  name="" class="nav__input" id="check-input">

                            <label  for ="check-input" class="list__form">
                                <img src="//bizweb.dktcdn.net/100/358/122/themes/788488/assets/logo.png?1623808175701" alt="A M A N D" class="amand__img">
                                <form enctype="multipart/form-data" id="formSubmit">
                                <div class="form__information">
                                    <p class="heading-form">Thông Tin Giao Hàng  </p>
            
                                    <div class="text-box">
                                        <label for="" class="label__name">Họ Tên </label><br/>
                                        <input type="text" placeholder="Họ Tên Của Bạn" name="fullName" id="fullName" style="font-size: initial"  value="${userDTO.fullName}">
                                    </div>

                                    <div class="text-box">
                                        <label for="" class="label__name">Email</label><br/>
                                        <input type="text" placeholder="Địa Chỉ Email" name="userName" id="userName" style="font-size: initial" value="${userDTO.userName}">
                                    </div>  
                                    
                                    <div class="text-box">
                                        <label for="" class="label__name">Số Điện Thoại</label><br/>
                                        <input type="text" placeholder="Số Phone" name="phoneNumber" id="phoneNumber" style="font-size: initial" value="${userDTO.phoneNumber}">
                                    </div>
                                    <div class="text-box">
                                        <label for="" class="label__name">Địa Chỉ</label><br/>
                                        <input type="text" placeholder="Địa chỉ  Cư Trú" name="address" id="address" style="font-size: initial" value="${userDTO.address}">
                                    </div>
                                    </div>
                                   
                                <div class="button">
                                    <button type="button" class="btn " value="Cập Nhật" id="btnPay" style="background: black ; font-size: large"> Đặt hàng </button>
                                </div>
                                 </form>
                            </label>

                            <ul class="infor__list">
                                <li class="infor__item">Giao hàng toàn quốc</li>
                                <li class="infor__item">Giao hàng trong 3-5 ngày</li>
                                <li class="infor__item">Giao hàng tiêu chuẩn đồng giá 30.000</li>
                                <li class="infor__item">Cách thức thanh toán: COD (nhận hàng rồi thanh toán)</li>
                                <li class="infor__item">Miễn phí đổi trả sản phẩm trong 7 ngày ( Không áp dụng với sản phẩm có giá ưu đãi</li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
        </div>
		
		
		
		        <div class="row">
		<div class="col l-12">
			<div class="product__distance"></div>
		</div>
	</div>
	   <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js">
	
</script>
	
	<script type="text/javascript">
	
	 $("#btnOutOfStock").click(function() {
		 alert("Có sản phẩm hết hàng, vui lòng chọn lại");
	 
	 });
	
	function deleteFunction(index) {
		event.preventDefault();
		
		 getIndex(index);
	}
	
	function getIndex(index) {
		event.preventDefault();
		
		$.ajax({
			url : "/baitaplon/trang-chu/deleteCard",
			type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(index),
            success: function (result) {
            	
                window.location.href = "http://localhost:8080/baitaplon/trang-chu/gio-hang";
                alert("Xoas thành công");
                
            },
            error: function (error) {
            	alert("Da loi xay ra thành công");
            }
		});
    }
	
	
	 $("#btnPay").click(function() {
		 event.preventDefault();
			var form = $('#formSubmit')[0];
			var data = new FormData(form);
		 $.ajax({
	            url: '/baitaplon/trang-chu/payCart',
	            type: 'POST',
				data : data,
				enctype : 'multipart/form-data',
				processData : false,
				contentType : false,
				cache : false,
	           
	            success: function (result) {
	            	 window.location.href = "http://localhost:8080/baitaplon/trang-chu/gio-hang";
	                 alert("Áo xấu cụng mua, ngu lắm em ạ!!!");
	              
	                
	            },
	            error: function (error) {
	            	alert("lỗi rùi")
	            }
	        });
		
	}); 
	
	

	
	</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Giỏ đồ</title>
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js">
	
</script>

</head>
<body>
<br>
<br>
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
                               
                                <img class="cart__img" style="width:100px ;height:150px"
									src="data:image/jpg;base64,<c:out value="${cart.file}"/>"
									name="image" />
    
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
                                <span class="infor__current" >${totalPrice} VNĐ</span>
                               
                            </div>

                            <div class="infor__transport">
                                <span class="transport__text">vận chuyển</span>
                                <span class="transport__current" id="totalLast">30.000 VNĐ</span>
                            </div>

                            <div class="infor__total">
                                <span class="total__text">Tổng</span>
                             <!--    <span class="total__current" id="totalLast"></span> -->
                                <input class="total__current" name="totalLast" id="totalLast"></input>
                            </div>

                            <button class="btn btn--primary" id="btnPay" )">THANH TOÁN </button>

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
		
		 $.ajax({
	            url: '/baitaplon/trang-chu/payCart',
	            type: 'POST',
	           
	            success: function (result) {
	            	 
	              
	                
	            },
	            error: function (error) {
	            	
	            }
	        });
		
	}); 
	
	

	
	</script>

</body>
</html>
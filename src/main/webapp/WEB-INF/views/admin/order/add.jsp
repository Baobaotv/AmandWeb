<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:url var="newAPI" value="/quan-tri/san-pham/them-san-pham" />
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
	<div class="container-fluid">
		<div class="card shadow mb-4">
			<div class="card-header py-4 d-flex flex-row-reverse">
				<form enctype="multipart/form-data" id="fileUploadForm">
					





			</div>


			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-striped" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								
								<th><label class="d-flex justify-content-center">Tên
										người dùng</label></th>
								<th><label class="d-flex justify-content-center">Số
										điện thoại </label></th>
								<th><label class="d-flex justify-content-center">Địa
										chỉ</label></th>
								<th><label class="d-flex justify-content-center">Ảnh
										sản phẩm</label></th>

								<th><label class="d-flex justify-content-center">Tên
										sản phẩm</label></th>

								<th><label class="d-flex justify-content-center">Size
										tả</label></th>
								<th><label class="d-flex justify-content-center">Số
										lượng</label></th>
										<th><label class="d-flex justify-content-center">Trạng
										thái</label></th>
										<th><label class="d-flex justify-content-center">Thao
										tác</label></th>


							</tr>
						</thead>

						<tbody>
							<c:forEach items="${lstOder}" var="item">
								<tr>
									
									<td style="text-align: center;">${item.userFullName}</td>



									<td style="text-align: center;">${item.userPhoneNumber}</td>
									<td style="text-align: center;">${item.userAddress}</td>



									<td style="text-align: center; width: 25%;"><img
										style="display: block; margin-left: auto; width: 25%; margin-right: auto;"
										class="product__item-img"
										src="data:image/jpg;base64,<c:out value="${item.productImg}"/>" /></td>

									<td style="text-align: center;">${item.productName}</td>
									<td style="text-align: center;">${item.sizeName}</td>
									<td style="text-align: center;">${item.productQty}</td>
								
									 <c:if test = "${item.status == '0'}">
									 <td style="text-align: center;">Đang xử lý</td>
									 <td style="text-align: center;">
									 <button type="button" id="Achieve" onclick="achieveFunction(${item.id})" class="btn btn-primary">
									 <i class="fa fa-toggle-off" aria-hidden="true"></i>
									 </button>
									 </td>
									 </c:if>
									 <c:if test = "${item.status == '1'}">
									 <td style="text-align: center;">Đã hoàn thành</td>
									 <td style="text-align: center;"><i class="fa fa-toggle-on" aria-hidden="true"></i></td>
									 </c:if>
									 	<td id="hide2" class="d-flex justify-content-center get"
										style="display: none; visibility: hidden; width: 0px !important; height: 0px !important;">${item.status}</td>
									

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
	<div class="modal fade" id="ok" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Thông báo</h4>
				</div>
				<div class="modal-body">
					<p>Thao tác thành công</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js">
		
	</script>
	
	<script>
		function achieveFunction(id) {
			event.preventDefault();
			
			
			$.ajax({
				url : "/baitaplon/quan-tri/don-hang/hoan-thanh-don-hang",
				type : "post",
				
				 contentType: 'application/json',
		            data: JSON.stringify(id),
				success : function(result) {
					window.location
					.replace("http://localhost:8080/baitaplon/quan-tri/don-hang");
					alert("Đã hoàn thành đơn hàng");
				},
				error : function(e) {
					alert("Có lỗi");
				}
			});
			
		}
		
		
	</script>  
</body>
</html>
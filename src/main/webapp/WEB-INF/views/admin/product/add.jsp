<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page contentType="text/html; charset=UTF-8" %>
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
					<button id ="btnAdd" style="width: 60px;" type="button" class="btn btn-primary"
						data-toggle="modal" data-target="#exampleModal">
						<span> <i class="fa fa-plus-circle bigger-110 purple"></i>
						</span>
					</button>

					<button style="width: 60px;" id="btnEdit" type="button"
						class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
						data-toggle="modal" data-target="#exampleModal"
						title='Sửa sản phẩm'>
						<span> <i class="far fa-edit"></i>
						</span>
					</button>
					<button style="width: 60px;" id="btnDelete" type="button"
						class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
						data-toggle="tooltip" title='Xóa sản phẩm'>
						<span> <i class="far fa-trash-alt"></i>
						</span>
					</button>


				
					<!-- Modal -->

					<div class="modal fade " id="exampleModal" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog modal-xl" role="document">
							<div class="modal-content">

								<div class="modal-body">
									<div class="card shadow mb-4">

										<div class="card-header py-3">
											<h6 class="m-0 font-weight-bold text-primary">Thêm sản
												phẩm</h6>
										</div>
										<div class="table">
											<div class="form-row">
												<div class="form-group col-md-6">
													<div class="row" style="padding-top: 20px;">
														<label style="padding-top: 6px; padding-left: 25px;"
															class="col-md-3" for="inputEmail4">Tên sản phẩm</label> 
															<input
															name="nameProduct" type="text" class="col-md-7 form-control"
															id="nameProduct" placeholder="Tên sản phẩm">
													</div>
												</div>

												<div class="form-group col-md-6">
													<div class="row" style="padding-top: 20px;">
														<label style="padding-top: 6px; padding-left: 25px;"
															class="col-md-3" for="inputZip">Mã sản phẩn</label> <input
															type="text" class="col-md-7 form-control" id="codeProduct"
															name="codeProduct">
													</div>
												</div>
											</div>
											<div class="form-row">
												<div class="form-group col-md-6">
													<div class="row" style="padding-top: 20px;">
														<label style="padding-top: 6px; padding-left: 25px;"
															class="col-md-3" for="inputAddress">Ảnh sản phẩm</label>
														<input name="files" type="file"
															class="col-md-7 form-control" id="image"
															placeholder=".jpg">
													</div>
												</div>
												<div class="form-group col-md-6">
													<div class="row" style="padding-top: 20px;">
														<label style="padding-top: 6px; padding-left: 25px;"
															class="col-md-3" for="inputAddress">Thể Loại</label> <select
															name="categoryId" class="custom-select col-md-7"
															id="categoryId">
															<option selected>Chọn Loại Sản Phẩm</option>
															<c:forEach items="${listCates}" var="lst">
																<option value="${lst.id}">${lst.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>

											</div>
											<div class="form-row">
												<div class="form-group col-md-6">
													<div class="row" style="padding-top: 20px;">
														<label style="padding-top: 6px; padding-left: 25px;"
															class="col-md-3" for="inputState">Kích thước</label> <select
															name="sizeId" class="custom-select col-md-7" id="sizeId">
															<option selected>Kích thước</option>
															<c:forEach items="${lstSize}" var="lst">
																<option value="${lst.id}">${lst.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>

												<div class="form-group col-md-6">
													<div class="row" style="padding-top: 20px;">
														<label style="padding-top: 6px; padding-left: 25px;"
															class="col-md-3" for="inputPassword4">Giá sản
															phẩm</label> <input name="price" type="text"
															class="col-md-7 form-control" id="price"
															placeholder="xxx.xxxVNĐ">
													</div>
												</div>
											</div>
										</div>
										<div class="form-row">
											<div class="form-group col-md-6">
												<div class="row" style="padding-top: 20px;">
													<label style="padding-top: 6px; padding-left: 25px;"
														class="col-md-3" for="inputZip">Số lượng</label> <input
														type="number" min=0 step=1 class="col-md-7 form-control"
														id="amount" name="amount">
												</div>
											</div>
											<div class="form-group col-md-6">
												<div class="row" style="padding-top: 20px;">

													<input name="id" type="hidden"
														class="col-md-7 form-control" id="id">
												</div>
											</div>
											<div class="form-group col-md-12">
												<label class="col-md-6" for="inputZip">Mô tả sản
													phẩm</label>
												<textarea name="memo" id="memo" class="col-md-12" rows="12"
													cols="50">  
															  	
															</textarea>
											</div>

										</div>
									</div>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>

									<%-- 	<c:if test="${user.age ge 40}">
									 You are over the hill.
									</c:if> --%>
									<button type="button" id="addProduct" class="btn btn-primary">Thêm
										sản phẩm</button>
									<button type="button" id="editProduct" class="btn btn-primary">Sửa
										sản phẩm</button>
								</div>

							</div>
						</div>
					</div>
				</form>

			</div>


			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-striped" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th class="check-box min-width"
									style="padding-left: 12px; padding-top: 10px; width: 7%">
									<label class="d-flex justify-content-center">Chọn tất
										cả</label>
									<div style="display: flex;">

										<input class="d-flex justify-content-center" type="checkbox"
											style="margin: auto;" name="selectBox" id="checkAll">
									</div>
								</th>
								<th><label class="d-flex justify-content-center">Tên
										sản phẩm</label></th>
								<th><label class="d-flex justify-content-center">Mã
										sản phẩm</label></th>
								<th><label class="d-flex justify-content-center">Hình
										ảnh</label></th>
								<th><label class="d-flex justify-content-center">Giá</label></th>

								<th><label class="d-flex justify-content-center">Số
										lượng</label></th>
								<th><label class="d-flex justify-content-center">Mô
										tả</label></th>
								<th><label class="d-flex justify-content-center">Ngày
										thêm</label></th>

							</tr>
						</thead>

						<tbody>
							<c:forEach items="${lstProduct}" var="item">
								<tr>
									<td class="d-flex justify-content-center get"><input
										id="checkOne" name="checkOne" type="checkbox" value="${item.id}"></td>

									<td id="hide" class="d-flex justify-content-center get"
										style="display: none; visibility: hidden; width: 0px !important; height: 0px !important;">${item.id}</td>

									<td id="hide1" class="d-flex justify-content-center get"
										style="display: none; visibility: hidden; width: 0px !important; height: 0px !important;">${item.categoryId}</td>

									<td id="hide2" class="d-flex justify-content-center get"
										style="display: none; visibility: hidden; width: 0px !important; height: 0px !important;">${item.sizeId}</td>
									<td style="text-align: center;">${item.name}</td>



									<td style="text-align: center;">${item.code}</td>



									<td style="text-align: center; width: 25%;"><img
										style="display: block; margin-left: auto; width: 25%; margin-right: auto;"
										class="product__item-img"
										src="data:image/jpg;base64,<c:out value="${item.image}"/>" /></td>

									<td style="text-align: center;">${item.price}</td>
									<td style="text-align: center;">${item.qty}</td>
									<td style="text-align: center;">${item.memo}</td>
									<td style="text-align: center;">${item.createdDate}</td>

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
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>

	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script
	src="https://code.jquery.com/jquery-3.6.0.min.js">
	
</script>
</body>
</html>
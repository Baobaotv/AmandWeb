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
					<button id ="btnAddUser" style="width: 60px;" type="button" class="btn btn-primary"
						data-toggle="modal" data-target="#exampleModal">
						<span> <i class="fa fa-plus-circle bigger-110 purple"></i>
						</span>
					</button>

					<button style="width: 60px;" id="btnEditUser" type="button"
						class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
						data-toggle="modal" data-target="#exampleModal"
						title='Sửa sản phẩm'>
						<span> <i class="far fa-edit"></i>
						</span>
					</button>
					<button style="width: 60px;" id="btnDeleteUser" type="button"
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
											<h6 class="m-0 font-weight-bold text-primary">Thêm tài 
												khoản</h6>
										</div>
										<div class="table">
											<div class="form-row">
												<div class="form-group col-md-6">
													<div class="row" style="padding-top: 20px;">
														<label style="padding-top: 6px; padding-left: 25px;"
															class="col-md-3" for="inputEmail4">Tên người dùng</label> 
															<input
															name="fullName" type="text" class="col-md-7 form-control"
															id="fullName" placeholder="Tên sản phẩm">
													</div>
												</div>

												<div class="form-group col-md-6">
													<div class="row" style="padding-top: 20px;">
														<label style="padding-top: 6px; padding-left: 25px;"
															class="col-md-3" for="inputZip">Số điện thoại</label> <input
															type="text" class="col-md-7 form-control" id="phoneNumber"
															name="phoneNumber">
													</div>
												</div>
											</div>
											<div class="form-row">
												<div class="form-group col-md-6">
													<div class="row" style="padding-top: 20px;">
														<label style="padding-top: 6px; padding-left: 25px;"
															class="col-md-3" for="inputEmail4">Tài khoản</label> 
															<input
															name="userName" type="text" class="col-md-7 form-control"
															id="userName" placeholder="Tài khoản">
													</div>
												</div>
												<div class="form-group col-md-6">
													<div class="row" style="padding-top: 20px;">
														<label style="padding-top: 6px; padding-left: 25px;"
															class="col-md-3" for="inputEmail4">Mật khẩu</label> 
															<input
															name="password" type="text" class="col-md-7 form-control"
															id="password" placeholder="Mật khẩu">
													</div>
												</div>

											</div>
											<div class="form-row">
												<div class="form-group col-md-6">
													<div class="row" style="padding-top: 20px;">
														<label style="padding-top: 6px; padding-left: 25px;"
															class="col-md-3" for="inputState">Chức năng</label> <select
															name="roleId" class="custom-select col-md-7" id="roleId">
															<option selected>Chức năng</option>
															<c:forEach items="${lstRoleDTO}" var="lst">
																<option value="${lst.id}">${lst.code}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group col-md-6">
													<div class="row" style="padding-top: 20px;">
														<label style="padding-top: 6px; padding-left: 25px;"
															class="col-md-3" for="inputEmail4">Địa chỉ</label> 
															<input
															name="address" type="text" class="col-md-7 form-control"
															id="address" placeholder="Địa chỉ">
													</div>
												</div>
												<input name="userId" type="hidden"
														class="col-md-7 form-control" id="userId">

												
											</div>
										</div>
									
									</div>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>

								
									<button type="button" id="addUser" class="btn btn-primary">Thêm
										tài khoản</button>
									<button type="button" id="editUser" class="btn btn-primary">Sửa
										tài khoản</button>
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
										người dùng</label></th>
								<th><label class="d-flex justify-content-center">Số
										điệnt thoại</label></th>
								<th><label class="d-flex justify-content-center">Chức
										năng</label></th>
								

							</tr>
						</thead>

						<tbody>
							<c:forEach items="${lstDTO}" var="item">
								<tr>
									<td class="d-flex justify-content-center get"><input
										id="checkOne" name="checkOne" type="checkbox" value="${item.id}"></td>

									<td id="hide" class="d-flex justify-content-center get"
										style="display: none; visibility: hidden; width: 0px !important; height: 0px !important;">${item.id}</td>

									<td id="hide1" class="d-flex justify-content-center get"
										style="display: none; visibility: hidden; width: 0px !important; height: 0px !important;">${item.roleId}</td>

								
									<td style="text-align: center;">${item.fullName}</td>



									<td style="text-align: center;">${item.phoneNumber}</td>



			

									<td style="text-align: center;">${item.roleCode}</td>
									
									<td id="hide1" class="d-flex justify-content-center get"
										style="display: none; visibility: hidden; width: 0px !important; height: 0px !important;">${item.password}</td>
										<td id="hide1" class="d-flex justify-content-center get"
										style="display: none; visibility: hidden; width: 0px !important; height: 0px !important;">${item.userName}</td>
										<td id="hide1" class="d-flex justify-content-center get"
										style="display: none; visibility: hidden; width: 0px !important; height: 0px !important;">${item.address}</td>
			

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


	

</body>
</html>
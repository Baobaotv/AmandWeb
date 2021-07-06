$(document)
		.ready(
				function() {
					var count = 0;
					$("#addUser")
							.click(
									function() {
										event.preventDefault();

										// Get form
										var form = $('#fileUploadForm')[0];

										var data = new FormData(form);
										$
												.ajax({
													url : "/baitaplon/quan-tri/tai-khoan/them-tai-khoan", 
													type : "post",
													enctype : 'multipart/form-data',
													data : data,
													processData : false,
													contentType : false,
													cache : false,
													success : function(result) {
														if (result) {
															success:$('#modal')
															.modal('hide');
															
															complete:$('#ok').modal(
															'show');

															setTimeout(
																	function() {
																		window.location
																				.replace("http://localhost:8080/baitaplon/quan-tri/tai-khoan")
																	}, 1500);
														}
													},
													error : function(e) {
														if (e.status) {
															success:$('#modal')
															.modal('hide');
															
															complete:$('#ok').modal(
															'show');

															setTimeout(
																	function() {
																		window.location
																				.replace("http://localhost:8080/baitaplon/quan-tri/tai-khoan")
																	}, 1500);
														} else {
															alert('Đã có lỗi xảy ra !');
														}
													}
												});
									});

					// checkAllCheckBox
					$("#checkAll").change(
							function() {
								$('input:checkbox').not(this).prop('checked',
										this.checked);
							});

					// checkAnyCheckBox
					var countChecked = function() {
						count = $("input:checked").length
						console.log(count);
						if (count < 1) {
							$("#btnDeleteUser").prop("disabled", true);
							$("#btnEditUser").prop("disabled", true);
						} else {
							$("#btnDeleteUser").prop("disabled", false);
							$("#btnAddUser").prop("disabled", true);
							if (count == 1) {
								$("#btnEditUser").prop("disabled", false);
							} else {
								$("#btnEditUser").prop("disabled", true);
							}
						}
					};
					countChecked();

					$("input[type=checkbox]").on("click", countChecked);

					// editUser 
					$("#btnEditUser").click(
							function(event) {
								event.preventDefault();

								var values = new Array();

								$.each($("input[name='checkOne']:checked")
										.closest("td").siblings("td"),
										function() {
											values.push($(this).text());
										});
								console.log(values);
								$('#userId').val(values[0]);
								$('#roleId').val(values[1]).change();
								$('#fullName').val(values[2])
								$('#phoneNumber').val(values[3]);
							
								$('#roleCode').val(values[4]);
								$('#password').val(values[5]);
								$('#userName').val(values[6]);
								$('#address').val(values[7]);
							

								$("#addUser").css("display", "none");
								$("#editUser").css("display", "block");
							});
					
					$("#btnAddUser").click(
							function(event) {
								event.preventDefault();
								$("#addUser").css("display", "block");
								$("#editUser").css("display", "none");
							});
							
							
					 $("#btnDeleteUser").click(
							function(event) {
								event.preventDefault();
								var data = new FormData();
								
								var ids = $('tbody input[name="checkOne"]:checked').map(function () {
		           				return $(this).val();
		        				}).get();
		        				data.append('ids', ids);
			
									$.ajax({
									url : "/baitaplon/quan-tri/tai-khoan/xoa-tai-khoan", 
									type : "post",
									enctype : 'multipart/form-data',
									data : data,
									processData : false,
									contentType : false,
									cache : false,
									success : function(result) {
									alert("oke lunn");
									window.location
									.replace("http://localhost:8080/baitaplon/quan-tri/tai-khoan");
					
					
									},
									error : function(e) {
										alert("van nguuu");
									}
									});
							});
							
							
							

					$("#editUser")
							.click(
									function() {
										event.preventDefault();

										// Get form
										var form = $('#fileUploadForm')[0];

										var data = new FormData(form);
										$
												.ajax({
													url : "/baitaplon/quan-tri/tai-khoan/sua-tai-khoan",
													type : "post",
													enctype : 'multipart/form-data',
													data : data,
													processData : false,
													contentType : false,
													cache : false,
													success : function(result) {
														if (result) {
														
														
															$('#modal').modal('toggle');

															setTimeout(
																	function() {
																		window.location
																				.replace("http://localhost:8080/baitaplon/quan-tri/tai-khoan")
																	}, 1000);
																	$('#ok').modal('show');
															
														}
													},
													error : function(e) {
														if (e.status) {
															success:$('#modal')
															.modal('hide');
															
															complete:$('#ok').modal(
															'show');

															setTimeout(
																	function() {
																		window.location
																				.replace("http://localhost:8080/baitaplon/quan-tri/tai-khoan")
																	}, 1500);
														} else {
															alert('Đã có lỗi xảy ra !');
														}
													}
												});
									});
				});
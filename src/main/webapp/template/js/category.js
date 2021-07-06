$(document)
		.ready(
				function() {
					var count = 0;
					$("#addCategory") 
							.click(
									function() {
										event.preventDefault();

										// Get form
										var form = $('#fileUploadForm')[0];

										var data = new FormData(form);
										$
												.ajax({
													url : "/baitaplon/quan-tri/the-loai/them-the-loai",
													type : "post",
													enctype : 'multipart/form-data',
													data : data,
													processData : false,
													contentType : false,
													cache : false,
													success : function(result) {
														if (result) {
															$('#modal')
															.modal('hide');

															setTimeout(
																	function() {
																		window.location
																				.replace("http://localhost:8080/baitaplon/quan-tri/the-loai")
																	}, 1500);
															
															$('#ok').modal(
															'show');
														}
													},
													error : function(e) {
														if (e.status) {
															$('#modal').modal(
																	'toggle');
															$('#ok').modal(
																	'show');

															setTimeout(
																	function() {
																		window.location
																				.replace("http://localhost:8080/baitaplon/quan-tri/the-loai")
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
							$("#btnDeleteCategry").prop("disabled", true);
							$("#btnEditCategory").prop("disabled", true);
							$("#btnAddCategory").prop("disabled", false);
						} else {
							$("#btnDeleteCategry").prop("disabled", false);
							if (count == 1) {
								$("#btnEditCategory").prop("disabled", false);
								$("#btnAddCategory").prop("disabled", true);
							} else {
								$("#btnEditCategory").prop("disabled", true);
							}
						}
					};
					countChecked();

					$("input[type=checkbox]").on("click", countChecked);

					// editProduct
					$("#btnEditCategory").click(  
							function(event) {
								event.preventDefault();
						
								var values = new Array();

								$.each($("input[name='checkOne']:checked")
										.closest("td").siblings("td"),
										function() {
											values.push($(this).text());
										});
								console.log(values);
								$('#id').val(values[0]);
								$('#nameCategory').val(values[1]).change();
								$('#codeCategory').val(values[2]).change();
								$('#createdDate').val(values[3]);
								$('#createdBy').val(values[4]);
								$('#modifiedDate').val(values[5]);
								$('#modifiedBy').val(values[6]);
								$("#addCategory").css("display", "none");
								$("#editCategory").css("display", "block");
							});
					
					$("#btnAddCategory").click(  
							function(event) {
								event.preventDefault();
								$("#addCategory").css("display", "block");
								$("#editCategory").css("display", "none");
							});
							
						 $("#btnDeleteCategry").click(  
							function(event) {
								event.preventDefault();
								var data = new FormData();
								
								var ids = $('tbody input[name="checkOne"]:checked').map(function () {
		           				return $(this).val();
		        				}).get();
		        				data.append('ids', ids);
			
									$.ajax({
									url : "/baitaplon/quan-tri/the-loai/xoa-the-loai",
									type : "post",
									enctype : 'multipart/form-data',
									data : data,
									processData : false,
									contentType : false,
									cache : false,
									success : function(result) {
									alert("oke lunn");
									window.location
									.replace("http://localhost:8080/baitaplon/quan-tri/the-loai");
					
					
									},
									error : function(e) {
										alert("Bạn không thể xóa do vẫn còn sản phẩm trong kho hàng !!!!");
									}
									});
							});

					$("#editCategory")
							.click(
									function() {
										event.preventDefault();

										// Get form
										var form = $('#fileUploadForm')[0];

										var data = new FormData(form);
										$
												.ajax({
													url : "/baitaplon/quan-tri/the-loai/sua-the-loai",
													type : "post",
													enctype : 'multipart/form-data',
													data : data,
													processData : false,
													contentType : false,
													cache : false,
													success : function(result) {
														if (result) {
															
															$('#modal')
															.modal('hide');

															setTimeout(
																	function() {
																		window.location
																				.replace("http://localhost:8080/baitaplon/quan-tri/the-loai")
																	}, 1500);
															
															setTimeout(
																	function() {
																		$('#ok').modal(
																		'show');
																	}, 2000);
															
														}
													},
													error : function(e) {
														if (e.status) {
															$('#modal').modal(
																	'toggle');
															$('#ok').modal(
																	'show');

															setTimeout(
																	function() {
																		window.location
																				.replace("http://localhost:8080/baitaplon/quan-tri/the-loai")
																	}, 1500);
														} else {
															alert('Đã có lỗi xảy ra !');
														}
													}
												});
									});
				});
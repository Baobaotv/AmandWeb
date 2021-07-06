$(document)
		.ready(
				function() {
					var count = 0;
					$("#addSize") 
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
							$("#btnDeleteSize").prop("disabled", true);
							$("#btnEditSize").prop("disabled", true);
							$("#btnAddSize").prop("disabled", false);
						} else {
							$("#btnDeleteSize").prop("disabled", false);
							if (count == 1) {
								$("#btnEditSize").prop("disabled", false);
								$("#btnAddSize").prop("disabled", true);
							} else {
								$("#btnEditSize").prop("disabled", true);
							}
						}
					};
					countChecked();

					$("input[type=checkbox]").on("click", countChecked);

					// editProduct
					$("#btnEditSize").click(  
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
								$('#nameSize').val(values[1])
								$('#codeSize').val(values[2])
								$('#createdDate').val(values[3]);
								$('#createdBy').val(values[4]);
								$('#modifiedDate').val(values[6]);
								$('#modifiedBy').val(values[5]);
								$("#addSize").css("display", "none");
								$("#editSize").css("display", "block");
							});
					
					$("#btnAddSize").click(  
							function(event) {
								event.preventDefault();
								$("#addSize").css("display", "block");
								$("#editSize").css("display", "none");
							});
							
						 $("#btnDeleteSize").click(  
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

					$("#editSize")
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
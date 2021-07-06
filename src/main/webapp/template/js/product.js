$(document)
		.ready(
				function() {
					var count = 0;
					$("#addProduct")
							.click(
									function() {
										event.preventDefault();

										// Get form
										var form = $('#fileUploadForm')[0];

										var data = new FormData(form);
										$
												.ajax({
													url : "/baitaplon/quan-tri/san-pham/them-san-pham",
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
																				.replace("http://localhost:8080/baitaplon/quan-tri/san-pham")
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
																				.replace("http://localhost:8080/baitaplon/quan-tri/san-pham")
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
							$("#btnDelete").prop("disabled", true);
							$("#btnEdit").prop("disabled", true);
						} else {
							$("#btnDelete").prop("disabled", false);
							if (count == 1) {
								$("#btnEdit").prop("disabled", false);
							} else {
								$("#btnEdit").prop("disabled", true);
							}
						}
					};
					countChecked();

					$("input[type=checkbox]").on("click", countChecked);

					// editProduct
					$("#btnEdit").click(
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
								$('#categoryId').val(values[1]).change();
								$('#sizeId').val(values[2]).change();
								$('#nameProduct').val(values[3]);
							
								$('#codeProduct').val(values[4]);
								$('#image').val(values[5]);
								$('#price').val(values[6]);
								$('#amount').val(values[7]);
								$('#memo').val(values[8]);

								$("#addProduct").css("display", "none");
								$("#editProduct").css("display", "block");
							});
					
					$("#btnAdd").click(
							function(event) {
								event.preventDefault();
								$("#addProduct").css("display", "block");
								$("#editProduct").css("display", "none");
							});
							
							
					 $("#btnDelete").click(
							function(event) {
								event.preventDefault();
								var data = new FormData();
								
								var ids = $('tbody input[name="checkOne"]:checked').map(function () {
		           				return $(this).val();
		        				}).get();
		        				data.append('ids', ids);
			
									$.ajax({
									url : "/baitaplon/quan-tri/san-pham/xoa-san-pham",
									type : "post",
									enctype : 'multipart/form-data',
									data : data,
									processData : false,
									contentType : false,
									cache : false,
									success : function(result) {
									alert("oke lunn");
									window.location
									.replace("http://localhost:8080/baitaplon/quan-tri/san-pham");
					
					
									},
									error : function(e) {
										alert("van nguuu");
									}
									});
							});
							
							
							

					$("#editProduct")
							.click(
									function() {
										event.preventDefault();

										// Get form
										var form = $('#fileUploadForm')[0];

										var data = new FormData(form);
										$
												.ajax({
													url : "/baitaplon/quan-tri/san-pham/sua-san-pham",
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
																				.replace("http://localhost:8080/baitaplon/quan-tri/san-pham")
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
																				.replace("http://localhost:8080/baitaplon/quan-tri/san-pham")
																	}, 1500);
														} else {
															alert('Đã có lỗi xảy ra !');
														}
													}
												});
									});
				});
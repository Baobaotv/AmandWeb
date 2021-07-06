$(document)
		.ready(
				function() {
					var count = 0; 
					$("#addRole") 
							.click(
									function() {
										event.preventDefault();

										// Get form
										var form = $('#fileUploadForm')[0];

										var data = new FormData(form);
										$
												.ajax({
													url : "/baitaplon/quan-tri/chuc-nang/them-chuc-nang",
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
																				.replace("http://localhost:8080/baitaplon/quan-tri/chuc-nang")
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
																				.replace("http://localhost:8080/baitaplon/quan-tri/chuc-nang")
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
							$("#btnDeleteRole").prop("disabled", true);
							$("#btnEditRole").prop("disabled", true);
							$("#btnAddRole").prop("disabled", false);
						} else {
							$("#btnDeleteRole").prop("disabled", false);
							if (count == 1) {
								$("#btnEditRole").prop("disabled", false);
								$("#btnAddRole").prop("disabled", true);
							} else {
								$("#btnEditRole").prop("disabled", true);
							}
						}
					};
					countChecked();

					$("input[type=checkbox]").on("click", countChecked);

					// editProduct
					$("#btnEditRole").click(  
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
								$('#code').val(values[1]);
								$('#createdBy').val(values[2]);
								$('#modifiedBy').val(values[3]);
								$('#createdDate').val(values[4]);
								$('#modifiedDate').val(values[5]);
								$("#addRole").css("display", "none");
								$("#editRole").css("display", "block");
							});
					
					$("#btnAddRole").click(  
							function(event) {
								event.preventDefault();
								$("#addRole").css("display", "block");
								$("#editRole").css("display", "none");
							});
							
					 $("#btnDeleteRole").click(
							function(event) {
								event.preventDefault();
								var data = new FormData();
								
								var ids = $('tbody input[name="checkOne"]:checked').map(function () {
		           				return $(this).val();
		        				}).get();
		        				data.append('ids', ids);
			
									$.ajax({
									url : "/baitaplon/quan-tri/chuc-nang/xoa-chuc-nang",
									type : "post",
									enctype : 'multipart/form-data',
									data : data,
									processData : false,
									contentType : false,
									cache : false,
									success : function(result) {
									alert("oke lunn");
									window.location
									.replace("http://localhost:8080/baitaplon/quan-tri/chuc-nang");
					
					
									},
									error : function(e) {
										alert("van nguuu");
									}
									});
							});
					

					$("#editRole")  
							.click(
									function() {
										event.preventDefault();

										// Get form
										var form = $('#fileUploadForm')[0];

										var data = new FormData(form);
										$
												.ajax({
													url : "/baitaplon/quan-tri/chuc-nang/sua-chuc-nang",
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
																				.replace("http://localhost:8080/baitaplon/quan-tri/chuc-nang")
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
																				.replace("http://localhost:8080/baitaplon/quan-tri/chuc-nang")
																	}, 1500);
														} else {
															alert('Đã có lỗi xảy ra !');
														}
													}
												});
									});
				});
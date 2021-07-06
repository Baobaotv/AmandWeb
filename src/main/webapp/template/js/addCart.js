/*
var total = 0;*/
$(document)
	.ready(
		function() {
			$("#addCart")
				.click(
					function() {
						event.preventDefault();

						// Get form

						var form = $('#formSubmit')[0];

						var data = new FormData(form);



						$.ajax({
							url: '/baitaplon/trang-chu/addcard',
							type: "post",
							enctype: 'multipart/form-data',
							data: data,
							processData: false,
							contentType: false,
							cache: false,
							success: function(result) {
								if (result) {
									
									alert("Thêm thành công");

								}


							},
							error: function(error) {
								alert('Bạn chưa chọn size');
							}
						});
						
					});


		});


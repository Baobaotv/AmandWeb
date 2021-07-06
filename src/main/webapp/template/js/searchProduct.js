
$(document)
	.ready(
		function() {
		
		function searchFunction() {
			
			event.preventDefault();

						// Get form

						var form = $('#formSearch')[0];

						var data = new FormData(form);
							$.ajax({
							url: '/baitaplon/trang-chu/search',
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
		
		
			}
	    

		});


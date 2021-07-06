  function theFunction() {
	$('#formSignup').validate({
		rules: {
			fullName: {
				required: true
				
			},
			userName: {
				required: true
			},
			phoneNumber: {
				required: true
			},
			address: {
				required: true
			},
			password: {
				required: true
			},
			confirmPassword: {
				equalTo: "#password"
			}
		},
		messages: {
			fullName: {
				required: "Ten khong duoc de trong dit me!"
			},
			userName: {
				required: "Mail khong duoc de trong dit me!"
			},
			phoneNumber: {
				required: "SDT khong duoc de trong dit me!"
			},
			address: {
				required: "DC khong duoc de trong dit me!"
			},
			password: {
				required: "PASS khong duoc de trong dit me!"
			},
			confirmPassword: {
				equalTo: "Dien mat khau ngu vcl!"
			},
		},

		submitHandler: function(form) {
			var data = new FormData(form);
			$.ajax({

				url: '/baitaplon/them-tai-khoan',
				type: "post",
				enctype: 'multipart/form-data',
				data: data,
				processData: false,
				contentType: false,
				cache: false,
				success: function(result) {
			
						window.location.replace("http://localhost:8080/baitaplon/trang-chu")
						alert('Đăng kí thành công');
				},
				error: function(error) {
					alert('Đã có lỗi xảy ra !');
				}
			});
		}
	});
}
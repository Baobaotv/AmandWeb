$(document)
		.ready(
				function() {
				function theFunction(index) {
			event.preventDefault();
			var id= index;
			
			 get(id);
		   
		}
		
		function get(id) {
			$.ajax({url: "demo_test.txt", success: function(result){
			   
			  }});
	    }
				
				
				});
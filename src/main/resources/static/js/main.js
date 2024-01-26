$("#btn").click(function(e) {
	
	let params = {
		test : "asdf",
	}
	
	$.ajax({
		type : "POST",
		url : "/member/test",
		data : params,
		sccess: function(res) {
			
		},
		error: function() {
			
		}
	});
		
});

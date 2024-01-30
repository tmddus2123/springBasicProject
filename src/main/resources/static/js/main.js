$("#btn").click(function() {
	
	let params = {
		test : "asdf",
	}
	
	$.ajax({
		method : "POST",
		url : "/member/test",
		data : params,
		success: function(data, status, xhr) {
			
		},
		error: function(e) {
			console.log(e);
		}
	});
	
});

$("#fetchBtn").click(function() {
	
	let params = {
		test : "asdf",
	}
	
	fetch("/member/testFetch", {
		method: "POST",
		body: JSON.stringify(params),
		headers: {
            "content-type": "application/json",
        },
	})
	.then(result => {
		console.log(result.json());
	})
	.catch(error => {
		
	});
});

$("#xhrBtn").click(function() {
	
	let params = {
		test : "asdf",
	}
	const xhr = new XMLHttpRequest();
	
	xhr.open("POST", "/member/testXhr", true); // 비동기여부(true가 비동기)
	xhr.setRequestHeader("Content-Type", "application/json");

	xhr.onreadystatechange = function() { // 요청에 대한 콜백
	  if (xhr.readyState === xhr.DONE) { // 요청이 완료되면
	    if (xhr.status === 200 || xhr.status === 201) {
	      console.log(xhr.responseText);
	    } else {
	      console.error(xhr.responseText);
	    }
	  }
	};


	xhr.send(JSON.stringify(params));
	
});
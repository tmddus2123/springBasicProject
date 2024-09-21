$("#fetchBtn").click(function() {
	
	let params = {
		test : "asdf",
	}
	
	fetch("/api/v1/auth/login", {
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

$("#testBtn").click(function() {
	let params = new URLSearchParams({
		test : "test!!!",
		a : "a",
		b : "b",
		c : "c"
	});
	
	fetch("/api/v1/auth/test", {
		method: "POST",
		body: params,
		headers: {
           "Content-type": "application/x-www-form-urlencoded",
        },
	})
	.then(response => response.json())  // 서버 응답이 JSON 형식일 경우 파싱
    .then(data => {
        console.log(data);
    })
})
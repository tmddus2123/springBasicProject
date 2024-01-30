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

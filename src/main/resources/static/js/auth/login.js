const login = (function() {
	const init = function() {
		
		_initEvent()
	}
	
	const _initEvent = function() {
		$("[data-src=login][data-act]").unbind();
		$("[data-src=login][data-act]").bind("click change", function(ev) {
			_action(ev);
		});
	}
	
	const _action = function(ev) {
		let evo = ev.currentTarget;
		let act_v = evo.getAttribute("data-act");
		let type_v = ev.type;
		let event = _event;
		
		if(type = "click") {
			if(act_v = "login") {
				event.login();
			}
		}
	}
	
	const _event = {
		login: function() {
			
			let data_v = {
				loginId : $("#loginId").val(),
				loginPw : $("#loginPw").val(),
			}
			
			fetch("/auth/login", {
				method: "POST",
				body: JSON.stringify(params),
				header: {
					"content-type": "application/json",
				},
			}).then(result => {
				if(result.header.code == 200) {
					
				} else if(result.header.code == 1001) {
					
				}
			}).then(error => {
				
			});
		},
	}
	
	
	return {
		init,
	}
})();
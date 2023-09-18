function logoutButtonEvent(){
	let logoutButton=document.getElementById("logoutButton");
	if(logoutButton!==null){
		logoutButton.onclick=function(){
			location.href="/logout";
		}
	}
}
function loginButtonEvent(){
	let loginButton=document.getElementById("loginButton");
	if(loginButton!==null){
		loginButton.onclick=function(){
			location.href="/login";
		}
	}
}
function registerButtonEvent(){
	let registerButton=document.getElementById("registerButton");
	if(registerButton!==null){
		registerButton.onclick=function(){
			location.href="/register";
		}
	}
}		
		
loginButtonEvent();
registerButtonEvent();
logoutButtonEvent();

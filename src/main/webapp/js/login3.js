function showAlertAfterRegistrarion(){
	$('div.alert.alert-success').show();
}

$('.message a').click(function(){
	loginRegisterSwitch();
});

function loginRegisterSwitch(){
	$('form').animate({
		height: "toggle", 
		opacity: "toggle"
			}, "slow");
}

/*
 * $('button.login').click(function(){ $('div.alert.alert-success').show; });
 */


$(document).ready(function() {
	$("button.register").click(function() {
		
		
		
	var email = $("form.register-form input.email").val();
	var password = $("form.register-form input.password").val();
	var cpassword = $("form.register-form input.cpassword").val();
	var firstName = $("form.register-form input.firstName").val();
	var lastName = $("form.register-form input.lastName").val();
	
	if (email == '' || password == '' || cpassword == '' || firstName == '' || lastName == "") {
	alert("Please fill all fields...!!!!!!");
	} else if ((password.length) < 8) {
	alert("Password should atleast 8 character in length...!!!!!!");
	} else if (!(password).match(cpassword)) {
	alert("Your passwords don't match. Try again?");
	} else {
		
		var userRegistration = {
				email : email,
				password : password,
				firstName : firstName,
				lastName : lastName
		}
		
	$.post("registration", userRegistration, function(data) {
		if (data == 'Success') {
		$("form")[0].reset();
		$("form")[1].reset();
		loginRegisterSwitch();
		showAlertAfterRegistrarion();
		
		}
		
		if (data == 'Fail') {
			$("form")[0].reset();
			$("form")[1].reset();
			alert('User with what name exists');
						
		}
		
	/* alert(data); */
	});
		
	}
	});
	});

$(document).ready(function() {
	$("button.login").click(function() {
		
	var email = $("form.login-form input.email").val();
	var password = $("form.login-form input.password").val();
	
	
	if (email == '' || password == '') {
		
		alert("Please fill all login form...!!!!!!");	
	} else {
		
		var userLogin = {
				email : email,
				password : password				
		}		
				
	$.post("login", userLogin, function(data) {
				
		var oldUrlContent = window.location.href;		
		
		if(data != ''){
			var customUrl = "";
			var urlContent = window.location.href.split('/');
			for (var i = 0; i < urlContent.length - 1; i++) {
				customUrl += urlContent[i] + "/";
			}	
			
			
			
			customUrl += data.destinationUrl;
			
						
			if(customUrl.includes('undefined')){
				window.location.href = oldUrlContent;
			} else {			
				window.location.href = customUrl;
			}			
			
			$("form")[1].reset();
		}		
		
	});
		
		
		
		
	}
	});
	});



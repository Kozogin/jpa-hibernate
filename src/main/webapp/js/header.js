$(document).ready(function() {
	$('.leftmenutrigger').on('click', function(e) {
		$('.side-nav').toggleClass("open");
		e.preventDefault();
	});
});


$(document).ready(function() {
	$("a.magazine-logout").click(function() {

		$.post("logOut", function(data) {		
			
			if(data != ''){
				var customUrl = "";
				var urlContent = window.location.href.split('/');
				for (var i = 0; i < urlContent.length - 1; i++) {
					customUrl += urlContent[i] + "/";
				}			
				customUrl += data;

					window.location.href = customUrl;
			}
		});

	});
});




$(document).ready(function() {
			
	var userRole = null;
	$.get("user-role", function(data) {	
			
		if(data !== ''){
			userRole = data;
		}
		
	}).done(function(){
		
		if(userRole === 'ADMINISTRATOR'){
			$('li.bucketAdminNot').hide();
		} else{
			$('li.bucketUserNot').hide();
		}
		
	});
	
});


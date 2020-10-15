var magazines = null;

$.get("magazines", function(data) {	
		
	if(data !== ''){
		magazines = data;
	}
}).done(function(){
	
	var cardsContext = '';
	jQuery.each(magazines, function(i, value){
		
		cardsContext +=
			'<div class="col cabinet-col">' +
			'<div class="card cabinet-card">' +
			'<div class="card-body">' + 		
			'<h5 class="card-title">' + value.name + '</h5>' +		
			'<h6 class="card-subtitle mb-2 text-muted">' + value.price +'</h6>'+
			'<p class="card-text">' + value.description + '</p> ' + 
			'<p class="card-text">' + value.isbn + '</p> ' +
			'<p class="card-text">' + value.id + '</p> ' +
			
			
			'<a href="magazineContr?id=' + value.id + '" class="card-link">link  '+ value.id +'</a>' +
			'</div>' +
			'</div>' + 
		    '</div>'
		
		
	});
	
	
	
	for(i = 1;i < 4; i++){
		cardsContext += "<br>"
	}
	
	$('#magazineCards').html(cardsContext);
}).done(function(){
	
})

//user-role
var userRole = null;
$.get("user-role", function(data) {	
		
	if(data !== ''){
		userRole = data;
	}
	
}).done(function(){
	
	if(userRole === 'ADMINISTRATOR'){
		$('a.card-link').hide();
		/*$('li.bucketAdminNot').hide();*/
	} else{
		/*$('li.bucketUserNot').hide();*/
	}
	
});


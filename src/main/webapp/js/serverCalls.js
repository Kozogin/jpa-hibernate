$(document).ready(
		function() {
			$("button.createMagazine").click(
					function() {

						var name = $("form.createMagazineForm textarea.name")
								.val();
						var description = $(
								"form.createMagazineForm textarea.description")
								.val();
						var price = $("form.createMagazineForm input.price")
								.val();
						var isbn = $("form.createMagazineForm input.isbn")
								.val();

						if (name == '' || price == '' || isbn == '') {
							alert("Please fill fields...!!!!!!");
						} else {

							var magazineA = {
								name : name,
								description : description,
								price : price,
								isbn : isbn
							};

							$.post("magazineContr", magazineA, function(data) {

								if (data == 'Success') {
									alert('Success magazine');

								}
							});
						}
					});
		});




$(document).ready(function() {
	$("button.closeButton").click(function() {
		
		var magazineId = jQuery(this).attr('magazine-id');
				
		$.post("bucketContr", {'magazineId' : magazineId}, function(data) {
						
			if (data == 'Success') {
				
				alert('Success');
				
				$("[data-dismiss=modal]").trigger({type: "click"});
				
				/*$('#buyMagazineModal').hide();*/				

			}
		});

	});
});


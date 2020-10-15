
function myFunction() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}


var buckets = null;
var tableContext;

$.get("buckets", function(data) {	
		
	if(data !== ''){
		buckets = data;
	}
		
	
}).done(function(){
		
		tableContext +=
			'<tr class="header">' +
			
				'<th style="width:15%;">Name<th>' +
				'<th style="width:15%;">Description<th>' +
				'<th style="width:15%;">Price<th>' +
				'<th style="width:15%;">ISBN<th>' +
				'<th style="width:15%;">PurchaseDate<th>' +
				'<th style="width:15%;">Options<th>' + 
			
			'<tr>';
		
		jQuery.each(buckets, function(i, value){
			
			tableContext += 
				'<tr>' +
				
				'<td style="width:15%;">' + value.name + '<td>' +
				'<td style="width:15%;">' + value.description + '<td>' +
				'<td style="width:15%;">' + value.price + '<td>' +
				'<td style="width:15%;">' + value.isbn + '<td>' +
				'<td style="width:15%;">' + value.purchaseDate + '<td>' +
				'<td> <button onclick="deleteOrderFromBucket(' + value.bucketId + ')">delete '+ value.bucketId + ' </button> <td>' + 
			
			'<tr>';
				
			
			
		});
	
	
	$('#myTable').html(tableContext);
	
});


function deleteOrderFromBucket(buckedId){
		
	var customUrl = "";
	var urlContent = window.location.href.split('/');
	for (var i = 0; i < urlContent.length - 1; i++) {
		customUrl += urlContent[i] + "/";
	}			
	customUrl += 'bucketContr?bucketId=' + buckedId;
	
	$.ajax({
		url: customUrl,
		type: 'DELETE',
		success: function(data){
			if(data == 'Success'){
				location.reload();
			}
		}
		
	});

		
}



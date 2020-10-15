<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/single.css">

<title>Single Magazine</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">

			<div class="col">
				<div class="card single-card">
					<div class="card-body single-card-body">
						<h5 class="card-title">${magazine.name}</h5>
						<h6 class="card-subtitle mb-2 text-muted">${magazine.price}</h6>
						<p class="card-text">${magazine.description}</p>
						<p class="card-text">${magazine.isbn}</p>
						<p class="card-text">${magazine.id}</p>


						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#buyMagazineModal">Buy magazine</button>

					</div>
				</div>
			</div>

		</div>
	</div>
	
	<br><br><br><br><br>

	<div class="modal fade" id="buyMagazineModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Confirmation</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Are You sure that You want to buy this
					magazine</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cancel</button>
					<button type="button" magazine-id="${magazine.id}"
						class="btn btn-primary closeButton">Buy</button>
				</div>
			</div>
		</div>
	</div>
 

	<jsp:include page="footer.jsp"></jsp:include>

	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

	<script src="js/header.js"></script>
	<script src="js/serverCalls.js"></script>
	<script src="js/cabinet.js"></script>

</body>
</html>
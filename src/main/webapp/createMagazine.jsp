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
<link rel="stylesheet" href="css/createMagazine.css">

<title>creating of Magazine</title>
</head>
<body>
	
	<nav
		class="navbar header-top fixed-top navbar-expand-lg  navbar-dark bg-dark">
		<span class="navbar-toggler-icon leftmenutrigger"></span> <a
			class="navbar-brand" href="#">DailyShop</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav animate side-nav">
				<li class="nav-item"><a class="nav-link" href="cabinet.jsp">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="createMagazine.jsp">Add Periodical</a> <!-- <a class="nav-link" href="$(pageContext.request.contextPath)/createMagazine.jsp">Add Periodical</a>  -->
				</li>
				<li class="nav-item"><a class="nav-link" href="bucket.jsp">Bucket</a>
					<!-- <a class="nav-link" href="$(pageContext.request.contextPath)/bucket.jsp">Bucket</a> -->
				</li>
			</ul>
			<ul class="navbar-nav ml-md-auto d-md-flex">


				<li class="nav-item"><a class="nav-link" href="#">LogOut</a></li>
			</ul>
		</div>
	</nav>


	<h1>creating of Magazine</h1>
	
	<jsp:include page="header.jsp"></jsp:include>

	<div class="contact1">
		<div class="container-contact1">
			<div class="contact1-pic js-tilt" data-tilt>
				<!-- <img src="images/img-01.png" alt="IMG"> -->
			</div>

			<form class="contact1-form validate-form createMagazineForm">
				<span class="contact1-form-title"> Enter Magazine </span>
				
				<div class="wrap-input1 validate-input"
					data-validate="Message is required">
					<textarea class="input1 name" name="name" placeholder="Name"></textarea>
					<span class="shadow-input1"></span>
				</div>

				<div class="wrap-input1 validate-input"
					data-validate="Message is required">
					<textarea class="input1 description" name="description"
						placeholder="Description"></textarea>
					<span class="shadow-input1"></span>
				</div>

				<div class="wrap-input1 validate-input"
					data-validate="Valid email is required: ex@abc.xyz">
					<input class="input1 price" type="text" name="price"
						placeholder="Price"> <span class="shadow-input1"></span>
				</div>

				<div class="wrap-input1 validate-input"
					data-validate="Subject is required">
					<input class="input1 isbn" type="text" name="isbn"
						placeholder="ISBN"> <span class="shadow-input1"></span>
				</div>

				<div class="container-contact1-form-btn">
					<button class="contact1-form-btn createMagazine">
						<span> Save to database <i class="fa fa-long-arrow-right"
							aria-hidden="true"></i>
						</span>
					</button>

				</div>

			</form>

		</div>

	</div>

	<br>
	<br>
	<br>
	<br>
	<br>


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
</body>
</html>
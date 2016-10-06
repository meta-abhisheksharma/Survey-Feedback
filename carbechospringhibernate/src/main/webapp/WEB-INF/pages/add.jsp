
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CarBecho</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="myStyle.css">
</head>


<body>
	<%@include file="header.html"%>

	<header>
		<section id="header">
			<h4>Add New Car!!!</h4>
		</section>
		<section id="contact-form">
	
			<form action="CarController"  method="post" >
				
				<div class="line">
					<div class="lab">
						<label>User Name</label>
					</div>
					<span><i class="fa fa-user" aria-hidden="true"></i></span>
					 <input	type="text" placeholder="User Name" name="createdBy" ng-model="createdBy" value="" pattern="[a-zA-Z]{3,15}" 	required />
				</div>
				

				<div class="line">
					<div class="lab">
						<label>Made By</label>
					</div>
					<span><i class="fa fa-car" aria-hidden="true"></i></span>
					<input type="text" name="make" ng-model="make" placeholder="Made By" value="" pattern="[a-zA-Z]{3,15}" required />
				</div>


				<div class="line">
					<div class="lab">
						<label>Model</label>
					</div>
					<span><i class="fa fa-envelope" aria-hidden="true"></i></span>
					 <input type="text" name="model" ng-model="model" placeholder="Model" value="" pattern="[a-zA-Z]{3,15}" required />
				</div>


				<div class="line">
					<div class="lab">
						<label>Engine (In CC)</label>
					</div>
					<span><i class="fa fa-cc" aria-hidden="true"></i></span>
					 <input	type="text" name="engineInCC" ng-model="engineInCC" value="" placeholder="engine in cc" required />
				</div>


				<div class="line">
					<div class="lab">
						<label>Mileage</label>
					</div>
					<span><i class="fa fa-minus-circle" aria-hidden="true"></i></span> 
					<input type="number" name="mileage"  ng-model="mileage" step="0.01" value="" placeholder="mileage" required />
				</div>

				<div class="line">
					<div class="lab">
						<label>Fuel Capacity</label>
					</div>
					<span><i class="fa fa-road" aria-hidden="true"></i></span> 
					<input 	type="number" name="fuelCapacity" ng-model="fuelCapacity" step="0.01" value="" placeholder="fuel capacity" required />
				</div>


				<div class="line">
					<div class="lab">
						<label>Price</label>
					</div>
					<span><i class="fa fa-credit-card-alt" aria-hidden="true"></i></span> 
					<input type="number" name="price" ng-model="price" step="0.01" value=""  placeholder="price" required />
				</div>



				<div class="line">
					<div class="lab">
						<label>AC</label>
					</div>

					<input class="rb" type="radio" ng-model="acValue" value="1"	 required />Yes<br> 
					<input class="rb" type="radio" ng-model="acValue" value="0" required />No
				</div>

				<div class="line">
					<div class="lab">
						<label>Power Steering</label>
					</div>
					<input class="rb" type="radio" ng-model="powerSteering" value="1" required />Yes<br> 
					<input class="rb" type="radio" ng-model="powerSteering" value="0" required />No
				</div>

			<div class="line">
					<div class="lab">
						<label>Accessory Kit</label>
					</div>
					<input class="rb" type="radio" ng-model="accessoryKit" value="1" required />Yes<br> 
					<input class="rb" type="radio" ng-model="accessoryKit" value="0" required />No
				</div>
				
			
				<center>
					<button type="submit" class="btn btn-primary">
						 <span><i class="fa fa-paper-plane-o" aria-hidden="true"></i>Submit</span>
					</button>
				</center>
			</form>
		</section>

	</header>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
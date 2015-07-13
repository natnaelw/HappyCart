<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>All the available products in our store</p>
				<a href="<spring:url value="/vendor/upload"/>" class="btn btn-primary">Upload</a>
				</div>
			</div>	 
		</div>	
	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class= "caption">
							<img src='<c:url value="/resources/images/${product.name}.png" />' class="single-img" alt="image" style = "width:50%"/>
							<p>${product.name}</p>
							<p>${product.manufacturer}</p>
							<p>${product.description}</p>
							<p>$${product.unitPrice} USD</p>
							<p>Available ${product.unitInStock} units in stock</p>
							<p ng-controller="cartController">
								<a href="<spring:url value="/vendor/delete?id=${product.id}" />"  class="btn btn-danger" >
								<span class="glyphicon-info-sign glyphicon"> </span>  Delete</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
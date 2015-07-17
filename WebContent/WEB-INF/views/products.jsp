<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<html>
<head>
	<link rel="stylesheet" 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script type="text/javascript" src="<spring:url value="/resources/js/cart.js" />" ></script>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>

<body>
	<section class="container">
	    <div class="panel panel-default">
	    	<div class="panel-heading"><h3>Product List</h3></div>
	        <div class="panel-body"> 
				<div class="row">
					<c:forEach items="${products}" var="item">
						<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
							<div class="thumbnail">
								<div class= "caption">
									<!-- <img src='<c:url value="${imagePath}${item.id}.png" />' class="img-rounded" alt="Cinque Terre" width="100" height="100"/> -->
									<a href=" <spring:url value="/products/product/${item.id}" /> "><img src="<spring:url value="${imagePath}${item.id}.png" />" class="img-rounded" alt="Cinque Terre" width="150" height="150"/> </a>
									<h4>${item.name}</h4>
									<p>${item.manufacturer}</p>
									<p>${item.description}</p>
									<p>$${item.unitPrice} USD</p>
									<p>Available ${item.unitInStock} units in stock</p>
									<p ng-controller="cartController">
										<input type="button" class="btn  btn-primary" onclick="addToCart(${item.id},1,'add')" value = "<spring:message code="cart.label.addtocart" />" />
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
	        </div>
        </div>
 	</section>
<div id="dialog" title="Cart Notification" style="display: none;color: blue;">
		<p>
			<spring:message code="cart.dialog.message" />
		</p>
</div>
</body>
</html>
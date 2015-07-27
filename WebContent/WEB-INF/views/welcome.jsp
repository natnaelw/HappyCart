<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<link rel="stylesheet" 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script type="text/javascript" src="<spring:url value="/resources/js/cart.js" />" ></script>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>

<div class="col-sm-12 padding-right">
	<div class="recommended_items">
		<!--recommended_items-->
		<h2 class="title text-center">${greeting}</h2>

		<div id="recommended-item-carousel" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="item active">
					<c:forEach items="${products}" var="item">
						<div class="col-sm-3">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<a
											href=" <spring:url value="/products/product/${item.id}" /> "><img
											src="<spring:url value="/images/product/${item.productImage}" />" />
										</a>
										<h2>${item.unitPrice}</h2>
										<p>${item.name}</p>
<!-- 										<a href="#" class="btn btn-default add-to-cart"><i -->
<!-- 											class="fa fa-shopping-cart"></i>Add to cart</a> -->
											<p ng-controller="cartController">
										<input type="button" class="btn btn-default add-to-cart" class="fa fa-shopping-cart" onclick="addToCart(${item.id},1,'add')" value = "<spring:message code="cart.label.addtocart" />" />
									</p>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2>${item.unitPrice}</h2>
											<p>Easy Polo Black Edition</p>
<!-- 											<a href="#" class="btn btn-default add-to-cart"><i -->
<!-- 												class="fa fa-shopping-cart"></i>Add to cart</a> -->
												<p ng-controller="cartController">
										<input type="button" class="btn btn-default add-to-cart" class="fa fa-shopping-cart" onclick="addToCart(${item.id},1,'add')" value = "<spring:message code="cart.label.addtocart" />" />
									</p>
										</div>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>Add
												to wishlist</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>Add
												to compare</a></li>
									</ul>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<!--/recommended_items-->
	
	<div id="dialog" title="Cart Notification" style="display: none;color: blue;">
		<p>
			<spring:message code="cart.dialog.message" />
		</p>

</div>
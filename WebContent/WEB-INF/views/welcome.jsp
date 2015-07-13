<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<title>Welcome</title>
</head>

<p style="color: red">
	<c:choose>
			<c:when test="${not empty message}">
         Error(s)!
         </c:when>
		</c:choose>
		<c:if test="${message != null}">
			${message}
		</c:if>
</p>
		<br>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h2> ${greeting} </h2>
				<p> <h3>${tagline} </h3>
			</div>	 
		</div>	
		
		<c:forEach items="${products}" var="item">
		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
           <a href=" <spring:url value="/products/product/${item.id}" /> "><img
					src="<spring:url value="/images/product/${item.productImage}" />" /> </a>
				<h4>$${item.unitPrice}</h4>
				<p>${item.name}</p>
				<p>
						<input type="button" class="btn-primary"
						onclick="addToCart(${item.id},1,'add')"
						value = "<spring:message code="cart.label.addtocart" />" />
				</p>
				</div>
				</div>
				</div>
		</c:forEach>
	</section>
	
</body>
</html>

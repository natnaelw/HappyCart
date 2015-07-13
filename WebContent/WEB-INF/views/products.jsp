<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 

<link rel="stylesheet" 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script type="text/javascript" src="<spring:url value="/resources/js/cart.js" />" ></script>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>



<div id="main">
	
	<h2 class="title text-center">Enjoy Our New Products...</h2>
 <div class="panel panel-default">
                <div class="panel-heading">New Items</div>
                <div class="panel-body">
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
		</div>
		</div>
</div>


 <div class="panel panel-default">
                <div class="panel-heading">Summer Sale</div>
                <div class="panel-body">
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
		</div>
		</div>
</div>


<div id="dialog" title="Cart Notification" style="display: none;color: blue;">
		<p>
			<spring:message code="cart.dialog.message" />
		</p>
</div>

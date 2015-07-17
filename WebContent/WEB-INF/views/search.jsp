<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<link rel="stylesheet" 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script type="text/javascript" src="<spring:url value="/resources/js/cart.js" />" ></script>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<html>
<head>
<title>Products</title>
</head>
<body>
	<section>
	</section>
	<section class="container">
		<form:form  modelAttribute="searchDto" method="post" >
			<fieldset style="padding: 20px;color: black" >	
			<label for="searchBy"><spring:message
					code="Search.category.label" />: </label> 
			<form:select  path="category">
				<option value="None">--Select--</option>
					<form:options items="${categories}" itemLabel="name" itemValue="id"/>
			</form:select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<br/>
			<label for="price"><spring:message code="Search.form.price.label"/>:</label>
			<form:input path="price" type="text"/>
						<input type="submit"  value ="Search"/>	
			</fieldset>  
		</form:form>          
	</section> 
	
	
	      	 <div class="panel panel-default">
                <div class="panel-body">
                	<c:if test="${empty items}"> 
					<div class="alert alert-danger"> 
						${messageNoProductFound}<br />
					</div>
				</c:if>
		<c:forEach items="${items}" var="item">
		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
         <img src="<c:url value="/resources/images/${item.name}.png"></c:url>" alt="image"  style = "width:100%"/>
           <a href=" <spring:url value="/products/product/${item.id}" /> "><img
					src="<spring:url value="/resources/images/${item.productImage}" />" /> </a>
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
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
	<section>
	</section>
	<section class="container">
		<form:form  modelAttribute="searchDto" method="post" action="searchCriteria">
			<fieldset style="padding: 20px">	
			<label for="searchBy"><spring:message
					code="Search.category.label" />: </label> 
			<form:select  path="category">
				<option value="None">--Select--</option>
					<form:options items="${categories}" itemLabel="name" itemValue="id"/>
			</form:select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="price"><spring:message code="Search.form.price.label"/>:</label>
			<form:input path="price" type="text"/>
						<input type="submit"  value ="Search"/>	
			</fieldset>  
		</form:form>          
	</section> 
	
		<c:if test="${empty items}">
					<div class="alert alert-danger">
						<spring:message code="Filtered.Items.Donot.Exist"/><br />
					</div>
				</c:if>
	      	<div class="row" >
			<c:forEach items="${items}" var="item">
		<div class="article" style="padding-bottom: 15px">
					<div class="thumbnail">
					<img src="<c:url value="/resources/images/${item.itemName}.png"></c:url>" alt="image"  style = "width:100%"/>
						<div class="caption">
							<h3>${item.itemName}</h3>
							<p>${item.description}</p>
							<p>${item.unitPrice}USD</p>
							<p>Available ${item.unitsInStock} units in stock</p>
							<p>
								<a
									href="<spring:url value="/items/item?id=${item.itemId}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Buy
								</a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
</body>
</html>

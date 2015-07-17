<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<title>Welcome</title>
</head>
<body>
	Welcome Mr. <security:authentication property="principal.username" />
	<section class="container">
	    <div class="panel panel-default">
	    	<div class="panel-heading"><h3>Product List</h3>
	    </div>
        <div class="panel-body"> 
           <table class="table table-striped">
                <thead>
                    <tr>
                    	<th></th>
                        <th>No.</th>
                        <th>Name</th>
                        <th>Manufacturer</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Stock</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach var="product" items="${products}" varStatus="status">
                    <tr>
                    	<!--<c:out value="${imagePath}${product.id}.png"></c:out>-->
                    	<!-- <td><img src='<c:url value="${imagePath}${product.id}.png" />' class="img-rounded" alt="Cinque Terre" width="30" height="30"/></td> -->
                    	<td><a href=" <spring:url value="/products/product/${item.id}" /> "><img src="<spring:url value="${imagePath}${product.id}.png" />" class="img-rounded" alt="Cinque Terre" width="150" height="150"/> </a></td>
                        <td><c:out value="${status.count}"/></td>
                        <td>${product.name}</td>
                        <td>${product.manufacturer}</td>
                        <td>${product.description}</td>
                        <td>${product.unitPrice}</td>
                        <td>${product.unitInStock}</td>
                        <td>
			                <div class="btn-group">
			                	<a href="<spring:url value="/vendor/edit?id=${product.id}" />" class="btn btn-default"><i class="icon icon-white icon-edit"></i> Edit</a>
			                	
			                    <c:if test="${product.post == 'Y'}">
			                    	
			                    </c:if>
			                    <c:choose>
			                    	<c:when test="${product.post == 'Y'}">
			                    		<a href="<spring:url value="/vendor/post?id=${product.id}&isPost=${product.post}" />" class="btn btn-default"><i class="icon icon-white icon-edit"></i> Remove</a>
			                    	</c:when>
			                    	<c:otherwise>
			                    		<a href="<spring:url value="/vendor/post?id=${product.id}&isPost=${product.post}" />" class="btn btn-default"><i class="icon icon-white icon-edit"></i> Post</a>  
			                    	</c:otherwise>
			                    </c:choose>
			                    <a href="<spring:url value="/vendor/delete?id=${product.id}" />" class="btn btn-danger"><i class="icon icon-white icon-trash"></i> Delete</a>
			                </div>
                        </td>
                    </tr>
                </c:forEach>
                <tbody>
           </table>
           <a href="<spring:url value="/vendor/upload"/>" class="btn btn-link">Add new product</a>
    	</div>
    	</div>
	</section>
        <!-- Thumbnail -->
        	<!-- <section class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class= "caption">
							<img src='<c:url value="/resources/images/${product.name}.png" />' class="img-rounded" alt="Cinque Terre" width="100" height="100"/>
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
	</section> -->
</body>
</html>
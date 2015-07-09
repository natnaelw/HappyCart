<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>



<link href="resources/css/template.css" rel="stylesheet">

</head>

<body>

	<div class="container">
		<div class="header">
			<ul class="nav nav-pills pull-right">
				<tiles:insertAttribute name="navigation" />
			</ul>
			<img src="<c:url value="/resource/images/HappyCart.jpg"></c:url>" alt="image"  style = "width:15%"/>
		</div>


<div id="header">
			<form id="searchBy" action="/searchByCategory" method="get" >
		<p >
			<label for="searchBy"><spring:message
					code="Search.product.category.label" text="Category" />: </label> 
			<select id="categoryId" name="categoryId">
				<option value="None">--Select--</option>
<%-- 				<c:forEach var="category" items="${categories}"> --%>
<%-- 					<option value="${category.id}">${category.name}</option> --%>
<%-- 				</c:forEach> --%>
			</select> <input type="submit" id="searchSubmit" value="Search" tabindex="5">

		</p>

	</form>


		</div>

<!-- 		<div class="jumbotron"> -->
<!-- 			<h1> -->
<%-- 				<tiles:insertAttribute name="heading" /> --%>
<!-- 			</h1> -->
<!-- 			<p> -->
<%-- 				<tiles:insertAttribute name="tagline" /> --%>
<!-- 			</p> -->
<!-- 		</div> -->

		<div class="row">
			<tiles:insertAttribute name="body" />
		</div>

		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>
</html>

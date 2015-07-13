<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
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
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>
			</div>	 
		</div>	
	</section>
	
</body>
</html>

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
				<li><a href="<spring:url value="/category/add"/>">Manage Category</a></li>
				<li><a href="<spring:url value="/subcategory/add"/>">Manage  SubCategory</a></li>				
			</div>	 
		</div>	
	</section>
	
</body>
</html>

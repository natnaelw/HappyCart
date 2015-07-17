<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Vendor's Page</title>
</head>
<body>
<section>
<!-- <p align="right"> -->
<%--  <a href="<spring:url  value="/doLogout" />" class="btn btn-danger btn-mini pull-right">Logout</a>	 --%>
<!-- </p> -->
 <p> <security:authorize access="isAuthenticated()">
  					Welcome Mr. <security:authentication property="principal.username" />
				</security:authorize>
	</section>

</body>
</html>
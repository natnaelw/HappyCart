<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Error</title>
</head>
<body>
<p style="color: blue;size: auto;">
	<c:choose>
			<c:when test="${not empty message}">
         Success!
         </c:when>
		</c:choose>
		<c:if test="${message != null}">
			${message}
		</c:if>
		<br/>
		<c:if test="${message1 != null}">
			${message1}
		</c:if>
		<br/>
		<c:if test="${message2 != null}">
			${message2}
		</c:if>
</p>
		<br>
</body>
</html>
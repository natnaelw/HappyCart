<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Ketia -->
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<title>Welcome</title>
	</head>
	<body>
		<section class="container">
		    <div class="panel panel-default">
		    	<div class="panel-heading"><h3>Administrator</h3></div>
		        <div class="panel-body"> 
		        	<div class="caption">
		   	            <div class="form-group">
							<a href="<spring:url value="/admin/category/"/>" class="btn btn-default" role="button"> Create Category</a>
			            </div>
			            <div class="form-group">
							<a href="<spring:url value="/admin/category/assign"/>" class="btn btn-default" role="button"> Assign Category</a>
			            </div>
		            </div>
		    	</div>
	    	</div>
		</section>
	</body>
</html>
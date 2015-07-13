<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
				 <div class="form">
                    <form:form class="cmxform form-horizontal tasi-form" id="signupForm" commandName="category" method="post">
                        <div class="form-group ">
                        <h2> Add Category </h2>
                            <label for=" name" class="control-label col-lg-2">Name</label>
                            <div class="col-lg-10">
                                <form:input required="" class=" form-control" type="text" path="name" id="inputName" placeholder="name"/>
                                <form:errors path="Name" cssClass="error" />
                                
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <button class="btn btn-danger" type="submit">Save</button>
                                <a href="list"><button class="btn btn-default" type="button">Cancel</button></a>
                            </div>
                        </div>
                         </form:form>
                         </div>
			</div>	 
		</div>	
	</section>
	
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
 <div class="panel panel-default">
                <div class="panel-heading"><h3>Add SubCategory</h3></div>
                <div class="panel-body">
					<form:form class="cmxform form-horizontal tasi-form"
						id="signupForm" commandName="subcategory" method="post">

					    <div class= "caption">
                            <div class="form-group">
							 <div class="form-group">
							 
                                <label class="col-sm-2 control-label" for="category">Category</label>
                                <div class="col-xs-4">
                                    <form:select class="form-control" path="category.id" id="category">
										<form:options itemLabel="name" itemValue="id"
											items="${category}"></form:options>
									</form:select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="subcategory">SubCategory</label>
                                <div class="col-xs-4">
                                    <form:input type="text" id ="subcategory" path="name" class="form-control"/>
                                </div>
                            </div>

						<div class="form-group">
							<div class="col-lg-offset-2 col-lg-10">
								<button class="btn btn-danger" type="submit">Save</button>
								<a href="<spring:url value="/admin"/>"><button
										class="btn btn-default" type="button">Cancel</button></a>

							</div>
						</div>
						</div>
						</div>
					</form:form>
				</div>
			</div>
	</section>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
                        	<div class="panel-heading"><h3>Category List</h3>
                        </div>
                        <div class="panel-body"> 
                  <form:form modelAttribute ="category" name="createCategory" class="form-horizontal">
	                    <div class= "caption">
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label" for="categoryName">Category name</label>
	                                <div class="col-xs-4">
	                                    <form:input type="text" id ="categoryName" path="name" class="form-control"/>
	                                </div>
	                                <input type="submit" id ="buttonCreate"  value="Create" class="btn btn-default"/>
	                            </div>
	                  </div>
                  </form:form>
                  
           <table class="table table-striped">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach var="cate" items="${categories}" varStatus="status">
                    <tr>
                        <td><c:out value="${status.count}"/></td>
                        <td>${cate.name}</td>
                        <td>
			                <div class="btn-group">
			                	<a href="<spring:url value="/cat/edit?id=${cate.id}" />" class="btn btn-info"><i class="icon icon-white icon-edit"></i> Edit</a>
			                    <a href="<spring:url value="/cat/delete?id=${cate.id}" />" class="btn btn-danger"><i class="icon icon-white icon-trash"></i> Delete</a>
			                </div>
                        </td>
                    </tr>
                </c:forEach>
                <tbody>
           </table>
           
                        </div>
                                                    </div>
        </section>
</body>
</html>
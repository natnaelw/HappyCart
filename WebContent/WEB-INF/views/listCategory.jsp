<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>List Of Categorys</title>
</head>
<body>
<h2> ${message} </h2>

	<section>
		<table class="table table-striped table-advance table-hover">
                <thead>
                
                    <tr>
                        <th>#</th>
                        <th><i class="fa fa-credit-card"></i> Name</th>
                        
                    </tr>
                </thead>
               
                    <c:set var="count" value="1" scope="page" />
                    <c:forEach var="category" items="${category}" >
                        <tr>
                            <td><a href="#">
                                    ${count}
                                    <c:set var="count" value="${count + 1}" scope="page"/></a></td>
                            <td >${category.name}</td>
                           
                            
                            
                        </tr>
                    </c:forEach>
                
            </table>
            <li><a href="<spring:url value="/admin"/>">BACK TO Admin</a></li>
	</section>
	
</body>
</html>

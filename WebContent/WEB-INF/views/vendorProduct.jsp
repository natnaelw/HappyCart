<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <!--<link href="<%= request.getContextPath() %>/bootstrap.min.css" type="text/css" rel="stylesheet" />-->
        <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Product</title>
    </head>
    <body>
        <section class="container">
            <div class="panel panel-default">
                <div class="panel-heading"><h3>Product</h3></div>
                <div class="panel-body">
                <form:form modelAttribute ="product" name="myForm" class="form-horizontal" enctype="multipart/form-data">
                    <div class= "caption">
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="selectCategory">Category</label>
                                <div class="col-xs-4">
                                	<form:select id="selectCategory" name="subCategoryId" path="" multiple="single" class="form-control">
                                		<c:set var="group" scope="page" value="''"/>
                                		<c:forEach var="subCategory" items="${subCategories}">
                                			<c:choose>
                                				<c:when test="${group != subCategory.category.name}">
             								    	<optgroup label="${subCategory.category.name}">
								    					<option value="${subCategory.id}">${subCategory.name}</option>
										  			</optgroup>
										  			<c:set var="group" scope="page" value="${subCategory.category.name}"/>
                                				</c:when>
                                				<c:otherwise>
							    					<option value="${subCategory.id}">${subCategory.name}</option>
                                				</c:otherwise>
                                			</c:choose>
									  	</c:forEach>
                                	</form:select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="productName">Product name</label>
                                <div class="col-xs-4">
                                    <form:input type="text" id ="productName" path="name" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="price">Product price</label>
                                <div class="col-xs-4">
                                    <form:input type="text" id ="price" path="unitPrice" class="form-control"/>
                                </div>
                            </div>
							
                           	<div class="form-group">
                                <label class="col-sm-2 control-label" for="manufacturer">Manufacturer</label>
                                <div class="col-xs-4">
                                    <form:input type="text" id ="manufacturer" path="manufacturer" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="description">Description</label>
                                <div class="col-xs-4">
                                    <form:input type="text" id ="description" path="description" class="form-control"/>
                                </div>
                            </div>
							
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="availableItem">Units in stock</label>
                                <div class="col-xs-4">
                                    <form:input type="text" id ="availableItem" path="unitInStock" class="form-control"/>
                                </div>
                            </div>
							
							<div class="form-group">
								<label class="control-label col-lg-2" for="productImage">Product image</label>
								<div class="col-lg-10">
									<form:input id="productImage" path="productImage" type="file" class="form:input-large" />
								</div>
							</div>
                 
                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                    <input type="submit" id ="buttonSubmit"  value="Submit" class="btn btn-default"/>
                                </div>
                            </div>
                    </div>
                    </form:form>
                </div>
            </div>
        </section>
    </body>
</html>
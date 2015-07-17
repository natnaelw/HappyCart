<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
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
	        	<div class="panel-heading">
	        		<h3>Category List</h3>
	        			<c:if test="${message != 'N'}">
							<div class="alert alert-danger">${message}</div>
						</c:if>
				</div>
		        <div class="panel-body"> 
			        <form:form modelAttribute ="category" name="createCategory" class="form-horizontal"  enctype="utf8">
			           <div class= "caption">
		                   <div class="form-group">
		                       <label class="col-sm-2 control-label" for="categoryName">Category name</label>
		                       <div class="col-xs-4">
		                           <form:input type="text" id ="categoryName" path="name" class="form-control"/>
		                       </div>
		                       <input type="submit" id ="buttonCreate"  value="Create" class="btn btn-default"/>
		                       <a href="<spring:url value="/admin/"/>" class="btn btn-default" role="button"> Back</a>
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
			                	<a href="<spring:url value="/admin/category/edit?id=${cate.id}" />" class="btn btn-default"><i class="icon icon-white icon-edit"></i> Edit</a>
			                    <a href="<spring:url value="/admin/category/delete?id=${cate.id}" />" class="btn btn-danger"><i class="icon icon-white icon-trash"></i> Delete</a>
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
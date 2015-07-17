<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Ketia -->
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	</head>
	<body>
		<section class="container">
			<div class="panel panel-default">
	       	<div class="panel-heading"><h3>Category List</h3></div>
	        	<div class="panel-body"> 
					<c:choose>
						<c:when test="${not empty errorMessage}">Error(s)!</c:when>
					</c:choose>
					<c:if test="${errorMessage != null}">${errorMessage}</c:if>
					<form:form modelAttribute="creditCard" method="POST" enctype="utf8" class="form-horizontal">
						<div class= "caption">
							<div class="form-group">
								<label class="col-sm-2 control-label" for="name"> <spring:message code="creditCard.form.type.label" /></label>
								<div class="col-xs-4">
									<form:select id="type" path="type" type="text" class="form-control">
										<form:options items="${creditCardTypes}"/>
									</form:select>
								</div>
							</div>
					
							<div class="form-group">
								<label class="col-sm-2 control-label" for="name"> <spring:message
										code="creditCard.form.name.label" /></label>
								<div class="col-xs-4">
									<form:input id="name" path="name" type="text" class="form-control" />
									<form:errors path="name" cssClass="text-danger" />
								</div>
							</div>
					
							<div class="form-group">
								<label class="col-sm-2 control-label" for="number"><spring:message
										code="creditCard.form.number.label" /></label>
								<div class="col-xs-4">
									<form:input id="number" path="number" type="text" class="form-control" />
									<form:errors path="number" cssClass="text-danger" />
								</div>

							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label" for="cvv"><spring:message
										code="creditCard.form.cvv.label" /></label>
								<div class="col-xs-4">
									<form:input id="cvv" path="cvv" type="text" class="form-control" />
									<form:errors path="cvv" cssClass="text-danger" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label" for="expireMonth"><spring:message
										code="creditCard.form.expireMonth.label" /></label>
								<div class="col-xs-4">
									<form:select id="expireMonth" path="expireMonth" type="text" class="form-control">
										<form:options items="${months}"/>
									</form:select>
									<form:errors path="expireMonth" cssClass="text-danger" />
								</div>
							</div>
					
							<div class="form-group">
								<label class="col-sm-2 control-label" for="expireYear"><spring:message
										code="creditCard.form.expireYear.label" /></label>
								<div class="col-xs-4">
									<form:input id="expireYear" path="expireYear" class="form-control"/>
									<form:errors path="expireYear" cssClass="text-danger" />
								</div>
							</div>
					
					        <div class="form-group">
								<label class="col-sm-2 control-label" for="amount"><spring:message
										code="creditCard.form.amount.label" /></label>
								<div class="col-xs-4">
									<form:input id="amount" path="amount"  value="${amountDue}" readonly="true" class="form-control"/>
									<form:errors path="amount" cssClass="text-danger" />
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-lg-offset-2 col-lg-10">
									<input type="submit" id="btnAdd" class="btn btn-default " value="Verify" />
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</section>
	</body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<style type="text/css">

fieldset{
	border-radius: 1px;
	width: 500px;
	height: 500px;
	margin-top: 5px;
	margin-left: 60px;
	border: 1px solid #6E6E6E;
	margin-bottom: 50px;
	padding: 10px;
}

.formlabel{
	display: block;
	margin-left: 900px;
	min-width: 100px;
	float: left;
	margin-top:4px;
	clear: left;
	padding: 10px;
}
.formselect{
display: inline-block;
	float: left;
	margin-top:10px;
	min-width: 300px;
	margin-left: 20px;
}
.forminput{
	display: inline-block;
/* 	float: left; */
/* 	margin-top:10px; */
	min-width: 175px;

}
.formerror{
	display: inline-block;
	color: red;
	border: 1px solid red;
	background-color: #F6CED8;
	border-radius: 3px;
	min-width: 300px;
	clear: right;
	margin-top: 4px;
	margin-left: 4px;
	min-height: 20px;
}
button{
	display:block;
	clear:both;
	margin-left: 20px;
	margin-bottom: 30px;
}

legend{
	background-color: #E6E6E6;
	border-radius: 1px;
	border: 1px solid #6E6E6E;
	padding: 1px;
}

</style>
</head>
<body>
<fieldset>
<legend>Card Information</legend>
<p style="color: red">
	<c:choose>
			<c:when test="${not empty errorMessage}">
         Error(s)!
         </c:when>
		</c:choose>
		<c:if test="${errorMessage != null}">
			${errorMessage}
		</c:if>
</p>
		<br>
	<form:form modelAttribute="creditCard" method="POST" enctype="utf8">

		<div class="">
			<label class="" for="name"> <spring:message
					code="creditCard.form.type.label" /></label>
			<div class="">
				<form:select id="type" path="type" type="text" class="">
					<form:options items="${creditCardTypes}"/>
				</form:select>
			</div>
		</div>

		<div class="">
			<label class="" for="name"> <spring:message
					code="creditCard.form.name.label" /></label>
			<div class="">
				<form:input id="name" path="name" type="text" class="" />
				<form:errors path="name" cssClass="text-danger" />
			</div>
		</div>

		<div class="">
			<label class="" for="number"><spring:message
					code="creditCard.form.number.label" /></label>
			<div class="">
				<form:input id="number" path="number" type="text" class="" />
				<form:errors path="number" cssClass="text-danger" />
			</div>
			<label class="" for="cvv"><spring:message
					code="creditCard.form.cvv.label" /></label>
			<div class="">
				<form:input id="cvv" path="cvv" type="text" class="" />
				<form:errors path="cvv" cssClass="text-danger" />
			</div>
		</div>

		<div class="">
			<label class="" for="expireMonth"><spring:message
					code="creditCard.form.expireMonth.label" /></label>
			<div class="">
				<form:select id="expireMonth" path="expireMonth" type="text" class="">
					<form:options items="${months}"/>
				</form:select>
				<form:errors path="expireMonth" cssClass="text-danger" />
			</div>
		</div>

		<div class="">
			<label class="" for="expireYear"><spring:message
					code="creditCard.form.expireYear.label" /></label>
			<div class="">
				<form:input id="expireYear" path="expireYear" />
				<form:errors path="expireYear" cssClass="text-danger" />
			</div>
		</div>

        <div class="">
			<label class="" for="amount"><spring:message
					code="creditCard.form.amount.label" /></label>
			<div class="">
				<form:input id="amount" path="amount"  value="${amountDue}" readonly="true"/>
				<form:errors path="amount" cssClass="text-danger" />
			</div>
		</div>
<br/>
		<div class="">
			<div class="">
				<input type="submit" id="btnAdd" class="btn " value="Verify" />
			</div>
		</div>

	</form:form>
	</fieldset>
</body>
</html>

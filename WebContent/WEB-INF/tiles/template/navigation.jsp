<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="<spring:url value="/welcome"/>" class="active">Home</a></li>
								<li><a href="<spring:url value="/search/"/>">Search</a></li>
								<li><a href="<spring:url value="/products/"/>">Products</a></li>
								<li><a href="<spring:url value="/cart/"/>">Shopping Cart</a></li>
								
<security:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="<spring:url value="/admin/"/>">Admin</a></li>
<li><a href="<spring:url value="/report/pdf/"/>">Reports</a></li>
</security:authorize>
<security:authorize access="hasAnyRole('ROLE_VENDOR','ROLE_ADMIN')">
<li><a href="<spring:url value="/vendor/"/>">Vendor</a></li>
</security:authorize>

<security:authorize access="!isAuthenticated()">
<li><a href="<spring:url value="/login/"/>">Login</a></li>
</security:authorize>
<security:authorize access="isAuthenticated()">	   
   		<li><a href="<spring:url value='/doLogout'/>"><span>Logout</span></a></li>
   </security:authorize>
<li><a href="<spring:url value="/signup/"/>">SignUp</a></li>

							</ul>
						</div>
					</div>
					<div class="col-sm-3">
					
					
							<ul class="nav nav-pills pull-right">
		<form id="searchBy" action="/happyCart/searchByCategory" method="get"  >
				<select id="categoryId" name="categoryId">
					<option value="None">--Select--</option>
					<c:forEach var="category" items="${categories}">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select> 
				<input type="submit" id="searchSubmit" value="Search" tabindex="5">
		</form>

	</ul>

					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
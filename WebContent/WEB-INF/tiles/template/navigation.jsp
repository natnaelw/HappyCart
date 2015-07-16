<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<li><a href="<spring:url value="/welcome"/>">Home</a></li>
<li><a href="<spring:url value="/search/"/>">Search</a></li>
<li><a href="<spring:url value="/products/"/>">Products</a></li>
<li><a href="<spring:url value="/cart/"/>">Shopping Cart</a></li>
<li><a href="<spring:url value="/report/pdf/"/>">Reports</a></li>
<security:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="<spring:url value="/admin/category/"/>">Admin</a></li>
</security:authorize>
<security:authorize access="hasAnyRole('ROLE_VENDOR','ROLE_ADMIN')">
<li><a href="<spring:url value="/vendor/"/>">Vendor</a></li>
</security:authorize>
<li><spring:url value=""/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</li>
<li><a href="<spring:url value="/login/"/>">Login</a></li>
<li><a href="<spring:url value="/signup/"/>">SignUp</a></li>


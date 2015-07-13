<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 

<link rel="stylesheet" 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script type="text/javascript" src="<spring:url value="/resources/js/cart.js" />" ></script>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<body>
<div >
	<c:set var="cartsize" value="${fn:length(cart.cartItems)}" />

	<c:choose>
		<c:when test="${cartsize == 0 }">
			<div>
				<h4>
					<spring:message code="cart.label.productnotfound"></spring:message>
				</h4>
			</div>
		</c:when>
	<c:otherwise>
			<div id="table">
				<table style="width: 100%; text-align: center;">
					<thead>
						<tr class="cart_menu">
							<td class="image" width="20%"><spring:message	code="cart.table.label.item" /></td>
							
							<td class="description" width="30%"><spring:message	code="cart.table.label.description" /></td>
							
							<td class="price" width="10%"><spring:message code="cart.table.label.price" /></td>
							
							<td class="quantity" width="10%"><spring:message code="cart.table.label.quantity" /></td>
							
							<td class="total" width="20%"><spring:message code="cart.table.label.total" /></td>
							<td></td>
						</tr>
					</thead>
			  		<tbody>
			  			<c:forEach items="${cart.cartItems}" var="cart">
			  				<tr id="product_${cart.value.product.id}">
								<td class="cart_product">
									<a href="<spring:url value="/products/product/${cart.value.product.id}"/>"><img src="<spring:url value="/images/product/${cart.value.product.productImage}" />" alt=""></a>
								</td>
								<td class="cart_description">
									<h4>
										<a href="/product/${cart.value.product.id}"><c:out
												value="${cart.value.product.name}" /></a>
									</h4>
									<p>
										ID:
										<c:out value="${cart.value.product.id}" />
									</p>
								</td>
								<td class="cart_price">
									<p>
										$<c:out value="${cart.value.product.unitPrice}" />
									</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<input id="quantity${cart.value.product.id}"
											class="cart_quantity_input" type="text" name="quantity"
											value="<c:out value="${cart.value.quantity}"/>"
											onkeypress="validate(event);"
											onchange="updateCart(this.id,${cart.value.product.id},'update');"
											autocomplete="off" size="2">
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price">
										$ <c:out value="${cart.value.totalPrice}" />
									</p>
								</td>
								<td class="cart_delete">
									<button type="button" class="btn-primary"
										onclick="removeFromCart('product_'+${cart.value.product.id},${cart.value.product.id});">
										<spring:message code="cart.table.label.remove" />
									</button>
								</td>
							</tr>

						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><spring:message code="cart.table.label.totalPrice" /></td>
							<td>$ ${cart.total}</td>
						</tr>
			  		</tbody>
			 	 </table>  
					<input type="submit"
					value="<spring:message code="cart.table.label.checkout" />"
					onclick="checkOut('<spring:url value="/home" />')"
					class="btn-primary" />
				</div>
	  		</c:otherwise>
	  	</c:choose>
  		<div id="checkoutdialog" title="Cart Checkout" style="display: none;">
		<p>You have checkout your cart. Thank you!</p>
	</div>
</div>
</body>
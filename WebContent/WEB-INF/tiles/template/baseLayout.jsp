<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>
    <script src="<c:url value="/resources/js/jquery.js"></c:url>"></script>
<jsp:include page="CSS.jsp" />

</head>
<body>
	<header id="header">
		<!--header-->
		<div class="header_top">
			<!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> Tel + 240240240</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i>
										happycart@gmail.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook" ></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header_top-->

<hr width=100%>

		<jsp:include page="navigation.jsp" />
		
		<hr width=100%>

	</header>
	<!--/header-->

	<section id="slider">
		<!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0"
								class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>

						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1>
										<span>Happy</span>-CART
									</h1>
									<h2>Now on a BIG Summer Sale!</h2>
									<p></p>
									<button type="button" class="btn btn-default get">Get
										it now</button>
								</div>
								<div class="col-sm-6">
									<img
										src="<c:url value="/resources/images/home/HCLogo1.jpg"></c:url>"
										class="girl img-responsive" alt="" />
									<!-- 										<img -->
									<%-- 										src="<c:url value="/resources/images/home/pricing.png"></c:url>" --%>
									<!-- 										class="pricing" alt="" /> -->
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">
									<h1>
										<span>Happy</span>-CART
									</h1>
									<h2>100% Sutisfaction Guranteed</h2>
									<p></p>
									<button type="button" class="btn btn-default get">Get
										it now</button>
								</div>
								<div class="col-sm-6">
									<img
										src="<c:url value="/resources/images/home/girl2.jpg"></c:url>"
										class="girl img-responsive" alt="" /> <img
										src="<c:url value="/resources/images/home/pricing.png"></c:url>"
										class="pricing" alt="" />
								</div>
							</div>

							<div class="item">
								<div class="col-sm-6">
									<h1>
										<span>Happy</span>-CART
									</h1>
									<h2>Enjoy our NEW products!!!</h2>
									<p></p>
									<button type="button" class="btn btn-default get">Get
										it now</button>
								</div>
								<div class="col-sm-6">
									<img
										src="<c:url value="/resources/images/home/girl3.jpg"></c:url>"
										class="girl img-responsive" alt="" /> <img
										src="<c:url value="/resources/images/home/pricing.png"></c:url>"
										class="pricing" alt="" />
								</div>
							</div>

						</div>

						<a href="#slider-carousel" class="left control-carousel hidden-xs"
							data-slide="prev"> <i class="fa fa-angle-left"></i>
						</a> <a href="#slider-carousel"
							class="right control-carousel hidden-xs" data-slide="next"> <i
							class="fa fa-angle-right"></i>
						</a>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!--/slider-->
	<section>
		<div class="container">
			<div class="row">

				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</section>

	<jsp:include page="footer.jsp" />

	<jsp:include page="JS.jsp" />
</body>
</html>

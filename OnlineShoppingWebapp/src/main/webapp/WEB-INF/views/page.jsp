<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />



<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>
</head>
<body>
	${contextRoot} says - ${greeting}
</body>
</html> --%>



<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Online Shopping - ${title}</title>
	
	
	<!-- For active Menu -->
	<Script>
		window.menu = '${title}';
	</Script>
	
	
	<!-- Bootstrap core CSS -->
	<link href="${css}/bootstrap.css" rel="stylesheet">
	
	<%-- <!-- Add readable bootstrap theme here -->
	<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
	 --%>
	 
	<!-- Add custom CSS here -->
	<link href="${css}/myapp.css" rel="stylesheet">
	
	
</head>

<body>

	<div class="wrapper">

		<!-- Navigator Section -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!--Loading the home content -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load Only when user clicks about -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load Only when user clicks contact -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
		</div>


		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>


		<!-- JQuery -->
		<script src="${js}/jquery-1.10.2.js"></script>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.js"></script>


		<!-- self coded JavaScript -->
		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>


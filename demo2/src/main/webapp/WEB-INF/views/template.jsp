<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title></title>
		<meta charset="utf-8" />
		<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	</head>
	<body>
		<!-- Header -->
		<c:import url="/html/header.html" charEncoding="UTF-8"/>
		<!-- Main -->
		<main id="main">
			<c:forEach items="${____}" var="name" varStatus="status">
				<c:set var="name" value="${____}" scope="request"/>
				<c:import url="includes/_____.jsp" charEncoding="UTF-8"/>
			</c:forEach>
		</main>
		<!-- Footer -->
		<c:import url="/html/footer.html" charEncoding="UTF-8"/>
	</body>
</html>
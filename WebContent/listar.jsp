<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listado general de viajes</title>
		<link rel="stylesheet" type="text/css" href="assets/css/main.css" />
	</head>
	<body>
		<h1>Listado de Viajes</h1>
		<jsp:include page="listado.jsp" />
		<div class="container">
			<a href="Inicio"><button>Volver al inicio.</button></a>
		</div>
	</body>
</html>
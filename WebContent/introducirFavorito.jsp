<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Favoritos</title>
	<link rel="stylesheet" type="text/css" href="assets/css/main.css" />
	</head>
	<body>
		<div class="container">${favmessage}</div>
		<h1>Lista de favoritos existentes</h1>
		<div class="container">
			<table>
				<tr>
					<th>Destino</th>
					<th>Duración</th>
					<th>Precio</th>
				</tr>
				<c:forEach items="${favoritos}" var="viaje">
					<tr>
						<td>${viaje.destino}</td>
						<td>${viaje.duracion} dias</td>
						<td>${viaje.precio} &euro;</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="container">
			<a href="Inicio"><button>Volver al inicio.</button></a>
		</div>
	</body>
</html>
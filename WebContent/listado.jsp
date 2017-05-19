<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class=container>
	<table>
		<tr>
			<th>Destino</th>
			<th>Duración</th>
			<th>Precio</th>
			<th>Fav</th>
		</tr>
		<c:forEach items="${lista}" var="viaje">
			<tr>
				<td>${viaje.destino}</td>
				<td>${viaje.duracion} días</td>
				<td>${viaje.precio} &euro;</td>
				<td class="fav"><a href="Favoritos?id=${viaje.id}" title="Añadir a favoritos: ${viaje.destino}"><button class="fav">&hearts;</button></a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Bienvenido</title>
		<link rel="stylesheet" type="text/css" href="assets/css/main.css" />
	</head>
	<body>
		<h1>Agencia de viajes</h1>
		<div class="container">Numero de usuarios en el sito web:
			${numeroUsuarios}</div>
	
		<div class="container">
			<strong>Viaje en promocion:</strong> <br> 
			<table>
				<tr>
					<th>Destino</th>
					<th>Duración</th>
					<th>Precio</th>
					<th>Fav</th>
				</tr>
				<tr>
					<td>${promocion.destino}</td>
					<td>${promocion.duracion} días</td>
					<td>${promocion.precio} &euro;</td>
					<td class="fav"><a href="Favoritos?id=${promocion.id}" title="Añadir a favoritos: ${promocion.destino}"><button class="fav">&hearts;</button></a></td>
				</tr>
			</table>
		</div>
		<div class="container">
			<a href="Listar"><button>Listado completo de viajes</button></a>
			<a href="formularioBuscar.jsp"><button>Busqueda de viajes</button></a>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE htm>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Busqueda de viajes</title>
		<link rel="stylesheet" type="text/css" href="assets/css/main.css" />
	</head>
	<body>
		<h1>Busqueda de viajes</h1>
		<div class="container">
			<form action="Buscar" method="POST">
				<label for="palabra">Palabra a buscar: </label> 
				<input type="text" name="palabra" placeholder="Palabra aquí" required />
				<button type="submit">Buscar</button>
			</form>
		</div>
	</body>
</html>
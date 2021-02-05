<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle usuario ${usuario.dni}</title>
</head>
<body>
	<%@ include file="../includes/navbar.jsp"%>
	<h2>Detalle usuario ${usuario.dni}</h2>
	<table class="table">
		<thead>
			<tr>
				
				<th scope="col">DNI</th>
				<th scope="col">Nombre</th>
				<th scope="col">Apellido 1</th>
				<th scope="col">Apellido 2</th>
				<th scope="col">Fecha nacimiento</th>
				<th scope="col">Altura</th>
				<th scope="col">Sexo</th>
				<th scope="col">Observaciones</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${usuario.dni}</td>
				<td>${usuario.nombre}</td>
				<td>${usuario.apellido1}</td>
				<td>${usuario.apellido2}</td>
				<td>${usuario.fechaNacimiento}</td>
				<td>${usuario.altura}</td>
				<td>${usuario.sexo}</td>
				<td>${usuario.observaciones}</td>
			</tr>
		</tbody>
	</table>
	<br><br>
	<a href="../listado-usuarios"><button>VOLVER</button></a>
</body>
</html>
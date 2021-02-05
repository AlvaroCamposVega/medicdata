<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listado de Usuarios</title>
		<link rel="stylesheet" href="/css/style.css">
		<script type="text/javascript" src="/js/utils.js"></script>
	</head>
	<body>
		<%@ include file="../includes/navbar.jsp" %>
		
		<table>
			<tr>
				<th>Nombre</th>
				<th>Apellido 1</th>
				<th>Apellido 2</th>
				<th>DNI</th>
				<th>Fecha de Nacimiento</th>
			</tr>
			<c:forEach var="usuario" items="${usuarios}">
				<tr class="linked-row" onclick="goToDetalleUsuario('${usuario.dni}')">
					<td>${usuario.nombre}</td>
					<td>${usuario.apellido1}</td>
					<td>${usuario.apellido2}</td>
					<td>${usuario.dni}</td>
					<td>
						<fmt:formatDate value="${usuario.fechaNacimiento}" pattern="dd-MM-yyyy"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
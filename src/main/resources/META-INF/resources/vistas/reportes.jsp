<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
 <title>Listado de Reportes</title>
</head>
<body>
	<%@ include file="../includes/navbar.jsp"%>
	<h2>Listado de Reportes</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>DNI Usuario</th>
			<th>Fecha Reporte</th>
		</tr>
		<c:forEach var="reporte" items="${reportes}">
			<tr>
				<td><a href="detalle-reporte/${reporte.id}">${reporte.id}</a></td>
				<td><a href="detalle-usuario/${reporte.usuario.dni}">${reporte.usuario.dni}</a></td>
				<td><fmt:formatDate pattern="dd/MM/yyyy"
						value="${reporte.fechaReporte}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
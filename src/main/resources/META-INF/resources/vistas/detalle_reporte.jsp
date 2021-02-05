<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle del Reporte ${reporte.id}</title>
</head>
<body>		
	<%@ include file="../includes/navbar.jsp"%>
	<h2>Detalle del Reporte ${reporte.id}</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>DNI Usuario</th>
			<th>Fecha Reporte</th>
			<th>Geolocalización</th>
			<th>Peso</th>
			<th>Presión Arterial</th>
			<th>Pasos</th>
		</tr>
		<tr>
			<td>${reporte.id}</td>
			<td><a href="detalle-usuario/${reporte.usuario.dni}">${reporte.usuario.dni}</a></td>
			<td><fmt:formatDate pattern="dd/MM/yyyy" value="${reporte.fechaReporte}" /></td>
			<td>Latitud: ${reporte.geolocalizacion.latitud}, Longitud: ${reporte.geolocalizacion.longitud}</td>
			<td>${reporte.peso}</td>
			<td>Máxima: ${reporte.presionArterial.presionMaxima}, Mínima: ${reporte.presionArterial.presionMinima}</td>
			<td>${reporte.pasos}</td>
		</tr>
	</table>
</body>
</html>
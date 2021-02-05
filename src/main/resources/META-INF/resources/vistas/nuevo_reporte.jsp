<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Nuevo Reporte</title>
		<script type="text/javascript" src="/js/utils.js"></script>
	</head>
	<body onload="initInputs()">
		<%@ include file="../includes/navbar.jsp" %>
		
		<h1>Nuevo Reporte</h1>
		
		<form action="../nuevo-reporte" method="POST">
			<input type="text" name="dni" value="${dni}" contenteditable="false" hidden="true">
			<label for="peso">Peso</label>
			<br>
			<input type="text" name="peso" required="required">
			<br>
			<br>
			<label>Presion Arterial</label>
			<br>
			<label for="presionMinima">Mínima</label>
			<br>
			<input type="number" name="presionMinima" required="required">
			<br>
			<label for="presionMaxima">Máxima</label>
			<br>
			<input type="number" name="presionMaxima" required="required">
			<br>
			<input type="hidden" name="fechaReporte">
			<input type="hidden" name="latitud">
			<input type="hidden" name="longitud">
			<input type="hidden" name="pasos">
			<input type="submit" value="Enviar">
		</form>
</html>
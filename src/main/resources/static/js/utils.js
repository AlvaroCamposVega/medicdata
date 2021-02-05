function goToDetalleUsuario(dni) {
	window.location.replace("detalle-usuario/" + dni);
}

function goToNuevoReporte(dni) {
	window.location.replace("nuevo-reporte/" + dni);
}

function initInputs() {
	var fechaReporte = document.getElementsByName("fechaReporte")[0];
	var latitud = document.getElementsByName("latitud")[0];
	var longitud = document.getElementsByName("longitud")[0];
	var pasos = document.getElementsByName("pasos")[0];

	latitud.value = Math.floor(Math.random() * 100) + 1;
	longitud.value = Math.floor(Math.random() * 100) + 1;
	pasos.value = Math.floor(Math.random() * 100) + 1;

	var fecha = new Date();
	var dd = String(fecha.getDate()).padStart(2, '0');
	var mm = String(fecha.getMonth() + 1).padStart(2, '0');
	var yyyy = fecha.getFullYear();

	fechaReporte.value = (yyyy + "-" + mm + "-" + dd);;
}
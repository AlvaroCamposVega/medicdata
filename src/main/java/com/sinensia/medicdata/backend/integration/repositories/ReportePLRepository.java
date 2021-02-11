package com.sinensia.medicdata.backend.integration.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sinensia.medicdata.backend.integration.model.ReportePL;

@Repository
public interface ReportePLRepository extends JpaRepository<ReportePL, Integer> {

	public List<ReportePL> findByUsuarioDni(String dni);
	
	@Query("SELECT AVG(r.presionArterial.presionMinima), AVG(r.presionArterial.presionMaxima) " +
		   "FROM ReportePL r "
		 + "WHERE YEAR(r.fechaReporte) = :anyo AND MONTH(r.fechaReporte) = :mes AND r.usuario.dni = :dni")
	public List<Object[]> getPresionArterialMediaDadoUnMes(String dni, int anyo, int mes);
	
	@Query("SELECT AVG(r.peso) FROM ReportePL r WHERE MONTH(r.fechaReporte) = :mes AND r.usuario.dni = :dni")
	public List<Object> getPesoMedioDadoUnMes(String dni, int mes);
	
	@Query("SELECT AVG(r.peso) "
		 + "FROM ReportePL r "
		 + "WHERE YEAR(r.fechaReporte) = :anyo AND r.usuario.dni = :dni "
		 + "GROUP BY MONTH(r.fechaReporte)")
	public List<Object[]> getPesoMedioCadaMesAnyo(String dni, int anyo);
	
	@Query("SELECT COUNT(*) "
		 + "FROM ReportePL r "
		 + "WHERE (((r.presionArterial.presionMaxima - r.presionArterial.presionMinima) >= :valor) AND "
		 + "(r.fechaReporte BETWEEN :fechaInicio AND :fechaFin) AND "
		 + "(r.usuario.dni = :dni))")
	public List<Object> getCantidadLecturasPresionesAltas(String dni, int valor, Date fechaInicio, Date fechaFin);
	
	@Query("SELECT r.peso - (SELECT r.peso FROM ReportePL r WHERE (r.fechaReporte = :fecha2) AND (r.usuario.dni = :dni)) "
		 + "FROM ReportePL r "
		 + "WHERE (r.fechaReporte = :fecha1) AND (r.usuario.dni = :dni)")
	public List<Object> getDiferenciaPeso(String dni, Date fecha1, Date fecha2);
	
	@Query("SELECT AVG(r.presionArterial.presionMinima), AVG(r.presionArterial.presionMaxima) "
		 + "FROM ReportePL r "
		 + "GROUP BY r.usuario.sexo")
	public List<Object[]> getEstadisticaPresionArterialSexo();
	
	// TODO - CONSULTA 7
	/*@Query("SELECT AVG(r.presionArterial.presionMinima), AVG(r.presionArterial.presionMaxima) "
		 + "FROM ReportePL r, UsuarioPL u"
		 + "WHERE u.fechaNacimiento BETWEEN YEAR(2021-02-08) AND (YEAR(2021-02-08) - 100)"
		 + "GROUP BY ")
	public List<Object[]> getEstadisticaPresionArterialMediaEdad();*/
}

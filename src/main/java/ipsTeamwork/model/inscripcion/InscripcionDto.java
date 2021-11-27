package ipsTeamwork.model.inscripcion;

import java.util.Date;

import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.model.carrera.CarreraDto;

/**
 * Clase que sirve como entidad de Inscripcion
 * 
 * @author Sergio Arroni del Riego
 *
 */
public class InscripcionDto {

	private Date fechaInscripcion;
	private String idAtleta;
	private String idCarrera;
	private String dorsal;
	private String estadoInscripcion;
	private AtletaDto atleta;
	private CarreraDto carrera;
	private String formaDePago;
	private String tiempoCorriendo;

	private String tiempoInicio;
	private String tiempoFin;
	private String categoria;
	
	private String incidenciasPago;
	private String club;
	
	
	private String tiempoPaso1;
	private String tiempoPaso2;
	private String tiempoPaso3;
	private String tiempoPaso4;
	private String tiempoPaso5;
	
	private String ritmo;

	public String getTiempoCorriendo() {
		return tiempoCorriendo;
	}

	public void setTiempoCorriendo(String tiempoCorriendo) {
		this.tiempoCorriendo = tiempoCorriendo;
	}

	/**
	 * @return the fechaInscripcion
	 */
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public String getIdAtleta() {
		return idAtleta;
	}

	public void setIdAtleta(String idAtleta) {
		this.idAtleta = idAtleta;
	}

	public String getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
	}

	/**
	 * @param fechaInscripcion the fechaInscripcion to set
	 */
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	/**
	 * @return the dorsal
	 */
	public String getDorsal() {
		return dorsal;
	}

	/**
	 * @param dorsal the dorsal to set
	 */
	public void setDorsal(String dorsal) {
		this.dorsal = dorsal;
	}

	/**
	 * @return the estadoCarrera
	 */
	public String getEstadoInscripcion() {
		return estadoInscripcion;
	}

	/**
	 * @param estadoCarrera the estadoCarrera to set
	 */
	public void setEstadoInscripcion(String estadoInscripcion) {
		this.estadoInscripcion = estadoInscripcion;
	}

	/**
	 * @return the atleta
	 */
	public AtletaDto getAtleta() {
		return atleta;
	}

	/**
	 * @param atleta the atleta to set
	 */
	public void setAtleta(AtletaDto atleta) {
		this.atleta = atleta;
	}

	/**
	 * @return the carrera
	 */
	public CarreraDto getCarrera() {
		return carrera;
	}

	/**
	 * @param carrera the carrera to set
	 */
	public void setCarrera(CarreraDto carrera) {
		this.carrera = carrera;
	}

	/**
	 * @return the formaDePago
	 */
	public String getFormaDePago() {
		return formaDePago;
	}

	/**
	 * @param formaDePago the formaDePago to set
	 */
	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	@Override
	public String toString() {
		return "Inscripcion [fechaInscripcion=" + fechaInscripcion + ", idAtleta=" + idAtleta + ", idCarrera="
				+ idCarrera + ", dorsal=" + dorsal + ", estadoInscripcion=" + estadoInscripcion + ", atleta=" + atleta
				+ ", carrera=" + carrera + ", formaDePago=" + formaDePago + "]";
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setIncidenciasPago(String incidenciasPago) {
		this.incidenciasPago = incidenciasPago;
		
	}
	
	public void setClub(String club) {
		this.club = club;
		
	}

	public String getClub() {
		return this.club;
	}

	public String getTiempoPaso1() {
		return tiempoPaso1;
	}

	public void setTiempoPaso1(String tiempoPaso1) {
		this.tiempoPaso1 = tiempoPaso1;
	}

	public String getTiempoPaso2() {
		return tiempoPaso2;
	}

	public void setTiempoPaso2(String tiempoPaso2) {
		this.tiempoPaso2 = tiempoPaso2;
	}

	public String getTiempoPaso3() {
		return tiempoPaso3;
	}

	public void setTiempoPaso3(String tiempoPaso3) {
		this.tiempoPaso3 = tiempoPaso3;
	}

	public String getTiempoPaso4() {
		return tiempoPaso4;
	}

	public void setTiempoPaso4(String tiempoPaso4) {
		this.tiempoPaso4 = tiempoPaso4;
	}

	public String getTiempoPaso5() {
		return tiempoPaso5;
	}

	public void setTiempoPaso5(String tiempoPaso5) {
		this.tiempoPaso5 = tiempoPaso5;
	}

	public String getRitmo() {
		return ritmo;
	}

	public void setRitmo(String ritmo) {
		this.ritmo = ritmo;
	}

}
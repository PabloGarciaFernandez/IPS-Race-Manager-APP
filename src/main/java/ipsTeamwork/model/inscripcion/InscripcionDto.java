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

}
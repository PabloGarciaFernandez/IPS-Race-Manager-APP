package ipsTeamwork.model.inscripcion;

import java.sql.Date;

import javax.management.RuntimeErrorException;

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

	/**
	 * @param fechaInscripcion the fechaInscripcion to set
	 */
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	/**
	 * @return the idAtleta
	 */
	public String getIdAtleta() {
		return idAtleta;
	}

	/**
	 * @param idAtleta the idAtleta to set
	 */
	public void setIdAtleta(String idAtleta) {
		this.idAtleta = idAtleta;
	}

	/**
	 * @return the idCarrera
	 */
	public String getIdCarrera() {
		return idCarrera;
	}

	/**
	 * @param idCarrera the idCarrera to set
	 */
	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
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

	public String calculaCategoria(int edad, String sexo) {
		if (edad >= 18 && edad <= 20) {
			return "18-20/" + sexo;
		} else if (edad > 20 && edad <= 30) {
			return "21-30/" + sexo;
		} else if (edad > 30 && edad <= 40) {
			return "31-40/" + sexo;
		} else if (edad > 40 && edad <= 50) {
			return "41-50/" + sexo;
		} else if (edad > 50 && edad <= 60) {
			return "51-60/" + sexo;
		} else if (edad > 50 && edad <= 70) {
			return "61-70/" + sexo;
		} else if (edad > 70 && edad <= 80) {
			return "71-80/" + sexo;
		} else if (edad > 80 && edad <= 90) {
			return "81-90/" + sexo;
		} else if (edad > 90 && edad <= 100) {
			return "91-100/" + sexo;
		} else if (edad > 100) {
			return ">100/" + sexo;
		}
		throw new RuntimeErrorException(new Error(), "Algo malo paso con la categoria");
	}

	@Override
	public String toString() {
		return "Inscripcion [fechaInscripcion=" + fechaInscripcion + ", idAtleta=" + idAtleta + ", idCarrera="
				+ idCarrera + ", dorsal=" + dorsal + ", estadoInscripcion=" + estadoInscripcion + ", atleta=" + atleta
				+ ", carrera=" + carrera + ", formaDePago=" + formaDePago + "]";
	}

	/**
	 * @author Sergio Arroni
	 * 
	 *         DNI, Nombre, Categoría, Fecha de Inscripción y Estado de Inscripción
	 * @return
	 */
	public String toStringVerAtletas() {
		return "DNI: " + atleta.getDNI() + ", nombre: " + atleta.getNombre() + ", categoria: "
				+ calculaCategoria(atleta.getEdad(), atleta.getSexo()) + ", Fecha de inscripción: " + fechaInscripcion
				+ " y Estado inscipcion: " + estadoInscripcion;
	}

}
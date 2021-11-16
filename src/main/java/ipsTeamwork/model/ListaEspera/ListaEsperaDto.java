package ipsTeamwork.model.ListaEspera;

import java.util.Date;

import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.model.carrera.CarreraDto;

/**
 * Clase que sirve como entidad de Inscripcion
 * 
 * @author Sergio Arroni del Riego
 *
 */
public class ListaEsperaDto {

	private Date fechaInscripcion;
	private AtletaDto atleta;
	private String idAtleta;
	private String idCarrera;
	private CarreraDto carrera;
	private String categoria;
	private int posicion;

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
	 * @return the fechaInscripcion
	 */
	public Date getFechaInscripcion() {
		return fechaInscripcion;
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
	 * @param fechaInscripcion the fechaInscripcion to set
	 */
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the posicion
	 */
	public int getPosicion() {
		return posicion;
	}

	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

}
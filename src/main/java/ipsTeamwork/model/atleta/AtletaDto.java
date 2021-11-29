package ipsTeamwork.model.atleta;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * Clase que sirve como entidad de Atleta
 * 
 * @author Sergio Arroni del Riego
 *
 */
public class AtletaDto {

	private String DNI;
	private String idAtleta;
	private int edad;
	private String nombre;
	private String sexo;
	private boolean discapacitado;
	private String email;
	private String fechitaDoNazemento;

	public AtletaDto() {
	}

	public AtletaDto(String dni, String name, int edad, String sexo, int discapacitado, String email) {
		this.DNI = dni;
		this.nombre = name;
		this.edad = edad;
		this.sexo = sexo;
		this.discapacitado = discapacitado == 1;
		this.email = email;
	}

	public AtletaDto(Date fechaNacimiento, String dni, String nombre, String email, boolean discapacitado,
			String sexo) {

		this.DNI = dni;
		this.nombre = nombre;

		Period period = Period.between(LocalDate.ofInstant(fechaNacimiento.toInstant(), ZoneId.systemDefault()),
				LocalDate.now());
		this.edad = period.getYears();

		this.sexo = sexo;
		this.discapacitado = discapacitado;
		this.email = email;
	}

	/**
	 * @return the dNI
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * @param dNI the dNI to set
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
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
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the discapacitado
	 */
	public boolean isDiscapacitado() {
		return discapacitado;
	}

	/**
	 * @param discapacitado the discapacitado to set
	 */
	public void setDiscapacitado(boolean discapacitado) {
		this.discapacitado = discapacitado;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Atleta [DNI=" + DNI + ", idAtleta=" + idAtleta + ", edad=" + edad + ", nombre=" + nombre + ", sexo="
				+ sexo + ", discapacitado=" + discapacitado + ", email=" + email + "]";
	}

	public void setFechitaDoNacimiento(String text) {
		this.fechitaDoNazemento = text;
	}

	public String getFechitaDoNacimiento() {
		return this.fechitaDoNazemento;
	}

}

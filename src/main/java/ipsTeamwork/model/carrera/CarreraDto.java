package ipsTeamwork.model.carrera;

import java.util.Date;

public class CarreraDto {
	private String id;
	private String nombre;
	private String tipo;
	private Date fecha;
	private double distancia;
	private float cuota;
	private Date fechaFin;
  
	// idCarrera varchar2 NOT NULL,tipo varchar2 NOT NULL, maxPlazas integer NOT
	// NULL

	private int plazasDisp;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the distancia
	 */
	public double getDistancia() {
		return distancia;
	}

	/**
	 * @param distancia the distancia to set
	 */
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	/**
	 * @return the cuota
	 */
	public float getCuota() {
		return cuota;
	}

	/**
	 * @param cuota the cuota to set
	 */
	public void setCuota(float cuota) {
		this.cuota = cuota;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the plazasDisp
	 */
	public int getPlazasDisp() {
		return plazasDisp;
	}

	/**
	 * @param plazasDisp the plazasDisp to set
	 */
	public void setPlazasDisp(int plazasDisp) {
		this.plazasDisp = plazasDisp;
	}
  
	@Override
	public String toString() {
		return nombre + " | " + tipo + " | " + fecha.toString() + " | " + distancia + " | " + cuota + " | " + fechaFin.toString() + " | " + plazasDisp;
	}

}

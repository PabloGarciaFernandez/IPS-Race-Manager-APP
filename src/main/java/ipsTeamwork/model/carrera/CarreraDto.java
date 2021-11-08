package ipsTeamwork.model.carrera;

import java.util.Date;

public class CarreraDto {
	private String idCarrera;
	private String nombre;
	private String tipo;
	private Date fecha;
	private Date fechaInicioIns;
	private double distancia;
	private float cuota;
	private Date fechaFin;
	private int maxPlazas;
	private int numInscritos;

	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private int plazasDisp;

	/**
	 * @return the numInscritos
	 */
	public int getNumInscritos() {
		return numInscritos;
	}

	/**
	 * @param numInscritos the numInscritos to set
	 */
	public void setNumInscritos(int numInscritos) {
		this.numInscritos = numInscritos;
	}

	/**
	 * @return the fechaInicioIns
	 */
	public Date getFechaInicioIns() {
		return fechaInicioIns;
	}

	/**
	 * @param fechaInicioIns the fechaInicioIns to set
	 */
	public void setFechaInicioIns(Date fechaInicioIns) {
		this.fechaInicioIns = fechaInicioIns;
	}

	/**
	 * @return the id
	 */
	public String getIdCarrera() {
		return idCarrera;
	}

	/**
	 * @param id the id to set
	 */
	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
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

	/**
	 * @return the maxPlazas
	 */
	public int getMaxPlazas() {
		return maxPlazas;
	}

	/**
	 * @param maxPlazas the maxPlazas to set
	 */
	public void setMaxPlazas(int maxPlazas) {
		this.maxPlazas = maxPlazas;
	}

	@Override
	public String toString() {
		return nombre + " | " + tipo + " | " + fecha.toString() + " | " + distancia + " | " + cuota + " | "
				+ fechaFin.toString() + " | " + plazasDisp;
	}

}

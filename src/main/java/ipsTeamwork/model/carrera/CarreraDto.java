package ipsTeamwork.model.carrera;

import java.util.Date;

public class CarreraDto {

	public String id;
	public String nombre;
	public String tipo; //'Asfalto' o 'Montaña'
	public Date fecha;
	public double distancia;
	public float cuota;
	public Date fechaFin;
	public int plazasDisp;

	@Override
	public String toString() {
		return nombre + " | " + tipo + " | " + fecha.toString() + " | " + distancia + " | " + cuota + " | " + fechaFin.toString() + " | " + plazasDisp;
	}
	
	
}

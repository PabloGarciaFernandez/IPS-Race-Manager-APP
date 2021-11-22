package ipsTeamwork.model.devolucion;

import java.util.Date;

public class DevolucionDto {

	public Date fechaLimite;
	public int porcentaje;
	public String carrera_id;
	@Override
	public String toString() {
		return "DevolucionDto [fechaLimite=" + fechaLimite + ", porcentaje=" + porcentaje + ", carrera_id=" + carrera_id
				+ "]";
	}
	
	
}

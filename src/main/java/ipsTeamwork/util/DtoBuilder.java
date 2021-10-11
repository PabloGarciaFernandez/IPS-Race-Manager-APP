package ipsTeamwork.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ipsTeamwork.model.carrera.CarreraDto;

public class DtoBuilder {

	public static List<CarreraDto> toCarreraDtoList(ResultSet rs) {
		List<CarreraDto> ret = new ArrayList<CarreraDto>();
		CarreraDto dto = null;
		
		try {
			while (rs.next()) {
				dto = new CarreraDto();
				dto.id = rs.getString("idCarrera");
				dto.nombre = rs.getString("nombre");
				dto.fecha = rs.getDate("fecha");
				dto.tipo = rs.getString("tipo");
				dto.distancia = rs.getDouble("distancia");
				dto.cuota = rs.getFloat("cuota");
				dto.fechaFin = rs.getDate("fechaFinInsc");
				dto.plazasDisp = rs.getInt("plazasDisp");
				
				ret.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}

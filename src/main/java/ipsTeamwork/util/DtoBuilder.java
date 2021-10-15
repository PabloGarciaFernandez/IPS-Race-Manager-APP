package ipsTeamwork.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.model.inscripcion.InscripcionDto;

public class DtoBuilder {

	public static List<CarreraDto> toCarreraDtoList(ResultSet rs) {
		List<CarreraDto> ret = new ArrayList<CarreraDto>();
		CarreraDto dto = null;

		try {
			while (rs.next()) {
				dto = new CarreraDto();
				dto.setIdCarrera(rs.getString("idCarrera"));
				dto.setNombre(rs.getString("nombre"));
				dto.setFecha(rs.getDate("fecha"));
				dto.setTipo(rs.getString("tipo"));
				dto.setDistancia(rs.getDouble("distancia"));
				dto.setCuota(rs.getFloat("cuota"));
				dto.setFechaFin(rs.getDate("fechaFinInsc"));
				dto.setPlazasDisp(rs.getInt("plazasDisp"));

				ret.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public static AtletaDto toAtletaDto(ResultSet rs) {
		AtletaDto dto = new AtletaDto();

		try {
			dto.setSexo(rs.getString(5));
			dto.setNombre(rs.getString(3));
			dto.setIdAtleta(rs.getString(1));
			dto.setEmail(rs.getString(7));
			dto.setEdad(Integer.parseInt(rs.getString(4)));
			dto.setDNI(rs.getString(2));
			dto.setDiscapacitado(Integer.parseInt(rs.getString(6)) == 1 ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	public static InscripcionDto ParamsToInscripcionDto(AtletaDto atleta, CarreraDto carrera, String dorsal,
			String estadoInscripcion, LocalDate localDate, String formaDePago) {
		InscripcionDto dto = new InscripcionDto();
		dto.setAtleta(atleta);
		dto.setCarrera(carrera);
		dto.setDorsal(dorsal);
		dto.setEstadoInscripcion(estadoInscripcion);
		dto.setFechaInscripcion(localDate);
		dto.setFormaDePago(formaDePago);

		return dto;
	}

	public static CarreraDto ParamsToCarreraDto(String id, float cuota, double distancia, java.util.Date fecha,
			int maxPlazas, String nombre, int plazasDisp, String tipo) {
		CarreraDto dto = new CarreraDto();
		dto.setIdCarrera(id);
		dto.setCuota(cuota);
		dto.setDistancia(distancia);
		dto.setFecha(fecha);
		dto.setMaxPlazas(maxPlazas);
		dto.setNombre(nombre);
		dto.setPlazasDisp(plazasDisp);
		dto.setTipo(tipo);

		return dto;
	}
}

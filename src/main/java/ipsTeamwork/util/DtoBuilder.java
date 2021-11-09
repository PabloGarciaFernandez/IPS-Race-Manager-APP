package ipsTeamwork.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.model.categoria.CategoriaDto;
import ipsTeamwork.model.inscripcion.InscripcionDto;
import ipsTeamwork.model.pago.PagoDto;

public class DtoBuilder {

	public static AtletaDto toAtletaDto(ResultSet rs) throws SQLException {
		AtletaDto dto = new AtletaDto();
//		if (!rs.next()) return null;
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
	
	public static CategoriaDto toCategoriaDto(ResultSet rs) {
		CategoriaDto dto = new CategoriaDto();

		try {
			dto.carrera_id = rs.getString(1);
			dto.nombre = rs.getString(2);
			dto.edadInic = rs.getInt(3);
			dto.edadFin = rs.getInt(4);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	public static InscripcionDto ParamsToInscripcionDto(AtletaDto atleta, CarreraDto carrera, String dorsal,
			String estadoInscripcion, Date date, String formaDePago) {
		InscripcionDto dto = new InscripcionDto();
		dto.setAtleta(atleta);
		dto.setIdAtleta(atleta.getIdAtleta());
		dto.setCarrera(carrera);
		dto.setIdCarrera(carrera.getIdCarrera());
		dto.setDorsal(dorsal);
		dto.setEstadoInscripcion(estadoInscripcion);
		dto.setFechaInscripcion(new java.sql.Date(date.getTime()));
		dto.setFormaDePago(formaDePago);
		dto.setTiempoCorriendo("0");

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

	public static List<InscripcionDto> toInscripcionDtoList(ResultSet rs) {
		List<InscripcionDto> ret = new ArrayList<InscripcionDto>();
		InscripcionDto dto = null;

		try {
			while (rs.next()) {
				dto = new InscripcionDto();
				dto.setIdAtleta(rs.getString("idAtleta"));
				dto.setIdCarrera(rs.getString("idCarrera"));
				dto.setFechaInscripcion(rs.getDate("fechaInscripcion"));
				dto.setDorsal(rs.getString("dorsal"));
				dto.setEstadoInscripcion(rs.getString("estadoInscripcion"));
				dto.setFormaDePago(rs.getString("formaDePago"));
				ret.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}
	
	public static List<CategoriaDto> toCategoriaDtoList(ResultSet rs) {
		List<CategoriaDto> ret = new ArrayList<CategoriaDto>();
		CategoriaDto dto = null;

		try {
			while (rs.next()) {
				dto = new CategoriaDto();
				dto.carrera_id = rs.getString(1);
				dto.nombre = rs.getString(2);
				dto.edadInic = rs.getInt(3);
				dto.edadFin = rs.getInt(4);
				ret.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public static List<AtletaDto> toAtletaDtoList(ResultSet rs) {
		List<AtletaDto> ret = new ArrayList<AtletaDto>();
		AtletaDto dto = null;

		try {
			while (rs.next()) {
				try {
					dto = new AtletaDto();
					dto.setSexo(rs.getString("sexo"));
					dto.setNombre(rs.getString("nombre"));
					dto.setIdAtleta(rs.getString("idAtleta"));
					dto.setEmail(rs.getString("email"));
					dto.setEdad(rs.getInt("edad"));
					dto.setDNI(rs.getString("dni"));
					dto.setDiscapacitado(rs.getBoolean("discapacitado"));

					ret.add(dto);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public static List<CarreraDto> toCarreraDtoList(ResultSet rs) {
		List<CarreraDto> ret = new ArrayList<CarreraDto>();
		CarreraDto dto = null;

		try {
			while (rs.next()) {
				dto = new CarreraDto();
				dto.setCuota(rs.getFloat("cuota"));
				dto.setDistancia(rs.getDouble("distancia"));
				dto.setFecha(rs.getDate("fecha"));
				dto.setFechaFin(rs.getDate("fechaFinInsc"));
				dto.setIdCarrera(rs.getString("idCarrera"));
				dto.setMaxPlazas(rs.getInt("maxPlazas"));
				dto.setNombre(rs.getString("nombre"));
				dto.setPlazasDisp(rs.getInt("plazasDisp"));
				dto.setTipo(rs.getString("tipo"));
				ret.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public static List<PagoDto> toPagoDtoList(ResultSet rs) {
		List<PagoDto> pagos = new ArrayList<PagoDto>();
		
		try {
			while (rs.next()) {
				PagoDto p = new PagoDto();
				
				p.date = rs.getDate("date");
				p.dni = rs.getString("dni");
				p.id = rs.getString("id");
				p.idCarrera = rs.getString("idCarrera");
				p.importe = rs.getDouble("importe");
				
				pagos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pagos;
	}
}

/**
 * 
 */
package ipsTeamwork.model.ListaEspera.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;
import ipsTeamwork.model.ListaEspera.ListaEsperaDto;
import ipsTeamwork.util.DtoBuilder;

/**
 * @author Sergio Arroni
 *
 */
public class FindListaByIdAtleta_Carrera {
	/**
	 * 
	 * Metodo que devuelve una lista de las listas de espera de x Atleta
	 * 
	 * @param idAtleta
	 * @param idCarrera
	 * @return
	 */
	public static List<ListaEsperaDto> execute(String idCarrera) {
		GestorDB gdb = new GestorDB();
		Connection c = gdb.getConnection();
		ResultSet rs = null;
		List<ListaEsperaDto> lista = new ArrayList<ListaEsperaDto>();

		try {
			PreparedStatement pst = c.prepareStatement(SQLStrings.findListaEsperaByCarrera);
			pst.setString(1, idCarrera);

			rs = pst.executeQuery();

			lista = DtoBuilder.toListaEsperaDtoList(rs);

			rs.close();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
		return lista;
	}

	public static ListaEsperaDto execute(String idAtleta, String idCarrera) {
		GestorDB gdb = new GestorDB();
		Connection c = gdb.getConnection();
		ResultSet rs = null;
		ListaEsperaDto lista = null;

		try {
			PreparedStatement pst = c.prepareStatement(SQLStrings.findListaEspera);
			pst.setString(1, idAtleta);
			pst.setString(2, idCarrera);

			rs = pst.executeQuery();

			lista = DtoBuilder.toListaEsperaDto(rs);

			rs.close();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
		return lista;
	}
}

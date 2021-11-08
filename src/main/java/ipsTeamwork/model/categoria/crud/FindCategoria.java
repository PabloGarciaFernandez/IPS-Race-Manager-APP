package ipsTeamwork.model.categoria.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;
import ipsTeamwork.model.categoria.CategoriaDto;
import ipsTeamwork.util.DtoBuilder;

public class FindCategoria {
	public List<CategoriaDto> execute(String idCarrera) {
		GestorDB gdb = new GestorDB();
		Connection c = gdb.getConnection();
		ResultSet rs = null;
		List<CategoriaDto> res = null;
		
		try {
			PreparedStatement pst = c.prepareStatement(SQLStrings.categoriaParticipante);
			pst.setString(1, idCarrera);
			
			rs = pst.executeQuery();
			res = DtoBuilder.toCategoriaDtoList(rs);			
			rs.close();
			pst.close();
		} catch (Exception e) {

		} finally {
			gdb.cerrarCon();
		}
		return res;
	}
}

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
	private String idCarrera;
	
	public FindCategoria(String id) {
		this.idCarrera = id;
	}
	
	public List<CategoriaDto> execute() {
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
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
		return res;
	}
}

package ipsTeamwork.model.inscripcion.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.model.inscripcion.InscripcionDto;
import ipsTeamwork.util.DtoBuilder;

public class SelectAllInscripcionForAtleta {

	String query = "SELECT * FROM INSCRIPCION WHERE idAtleta = ? order by fechaInscripcion";
	String id = null;
	
	public SelectAllInscripcionForAtleta(String idAtleta) {
		id = idAtleta;
	}
	
	public List<InscripcionDto> execute() {
		List<InscripcionDto> ret = null;
		
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			
			ret = DtoBuilder.toInscripcionDtoList(rs);
			
			rs.close();
			pst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
		
		
		
		return ret;
	}
}

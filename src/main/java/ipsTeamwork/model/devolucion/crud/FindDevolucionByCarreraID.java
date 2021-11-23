package ipsTeamwork.model.devolucion.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;
import ipsTeamwork.model.devolucion.DevolucionDto;
import ipsTeamwork.util.DtoBuilder;

public class FindDevolucionByCarreraID {
	private String idCarrera;
	
	public FindDevolucionByCarreraID(String id) {
		this.idCarrera = id;
	}
	
	public DevolucionDto execute() {
		GestorDB gdb = new GestorDB();
		Connection c = gdb.getConnection();
		ResultSet rs = null;
		DevolucionDto res = null;
		
		try {
			PreparedStatement pst = c.prepareStatement(SQLStrings.devolucionFinder);
			pst.setString(1, idCarrera);
			
			rs = pst.executeQuery();
			res = DtoBuilder.toDevolucionDto(rs);			
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

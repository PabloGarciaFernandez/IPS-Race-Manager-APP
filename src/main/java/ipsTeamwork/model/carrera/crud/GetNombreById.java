package ipsTeamwork.model.carrera.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ipsTeamwork.controller.GestorDB;

public class GetNombreById {
	String id;
	String query = "select nombre from carrera where idCarrera = ?";
	
	public GetNombreById(String id) {
		this.id = id;
	}
	
	public String execute() {
		String ret = null;
		
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			
			ret = rs.getString(1);
			
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

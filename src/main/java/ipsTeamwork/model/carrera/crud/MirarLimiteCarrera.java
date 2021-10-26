package ipsTeamwork.model.carrera.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ipsTeamwork.controller.GestorDB;

public class MirarLimiteCarrera {
	
	String getPlazasDisp = "select plazasDisp from carrera where idCarrera = ?";
	
	public boolean execute(String idCarrera) {
		GestorDB gdb = new GestorDB();
		Connection c = gdb.getConnection();
		ResultSet rs = null;
		boolean res = false;
		
		try {
			PreparedStatement pst = c.prepareStatement(getPlazasDisp);
			pst.setString(1, idCarrera);
			
			rs = pst.executeQuery();
			int numb = rs.getInt(1);
			System.err.println("aaaa" + "  " + numb);
			
			if(numb > 0) {	
				res = true;
			}
			else {
				res = false;
			}
			
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

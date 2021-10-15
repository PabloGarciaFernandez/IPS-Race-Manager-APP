package ipsTeamwork.model.carrera.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;

public class MirarLimiteCarrera {
	
	public boolean execute(String idCarrera, int maxParticipantes) {
		GestorDB gdb = new GestorDB();
		Connection c = gdb.getConnection();
		ResultSet rs = null;
		boolean res = false;
		
		try {
			PreparedStatement pst = c.prepareStatement(SQLStrings.estaLlenaLaLista);
			pst.setString(1, idCarrera);
			
			rs = pst.executeQuery();
			int numb = rs.getInt(1);
			if(maxParticipantes > numb) {
				res = true;
			}
			else {
				res = false;
			}
			
			rs.close();
			pst.close();
		} catch (Exception e) {

		} finally {
			gdb.cerrarCon();
		}
		return res;
	}
}

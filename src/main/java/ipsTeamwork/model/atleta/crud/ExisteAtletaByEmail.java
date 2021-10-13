package ipsTeamwork.model.atleta.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;

public class ExisteAtletaByEmail {
	public boolean execute(String email) {
		GestorDB gdb = new GestorDB();
		Connection c = gdb.getConnection();
		ResultSet rs = null;
		boolean res = false;
		
		try {
			PreparedStatement pst = c.prepareStatement(SQLStrings.existeAtletaByEmail);
			pst.setString(1, email.trim().strip());
			
			rs = pst.executeQuery();
			res = rs.next();
			
			rs.close();
			pst.close();
		} catch (Exception e) {

		} finally {
			gdb.cerrarCon();
		}
		return res;
	}
}

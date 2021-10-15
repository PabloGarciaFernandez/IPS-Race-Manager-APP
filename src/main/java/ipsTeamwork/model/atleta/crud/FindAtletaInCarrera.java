package ipsTeamwork.model.atleta.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;

public class FindAtletaInCarrera {

	public boolean execute(String idAtleta, String idCarrera) {
		GestorDB gdb = new GestorDB();
		Connection c = gdb.getConnection();
		ResultSet rs = null;
		boolean res = false;
		
		try {
			PreparedStatement pst = c.prepareStatement(SQLStrings.atletaParticipanteDeCarrera);
			pst.setString(1, idAtleta);
			pst.setString(2, idCarrera);
			
			rs = pst.executeQuery();
			String str = rs.getString(1);
			if(str.equals(idAtleta)) {
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

package ipsTeamwork.model.inscripcion.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;

public class UpdateInscribirseAtletaDorsal {

	public static void execute(String idCarrera, String idAtleta, String dorsal) {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(SQLStrings.updateDorsales);

			pst.setString(1, dorsal);
			pst.setString(2, idCarrera);
			pst.setString(3, idAtleta);

			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
	}

}

package ipsTeamwork.model.inscripcion.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;
import ipsTeamwork.model.inscripcion.InscripcionDto;

public class UpdateInscribirseAtleta {

	public static void execute(InscripcionDto inscripcion, String estadoInscripcion) {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(SQLStrings.updateInscrpcionValues);

			pst.setString(1, estadoInscripcion);
			pst.setString(2, inscripcion.getAtleta().getIdAtleta());
			pst.setString(3, inscripcion.getCarrera().getIdCarrea());
			pst.setString(4, inscripcion.getDorsal());

			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {

		} finally {
			gdb.cerrarCon();
		}
	}
}

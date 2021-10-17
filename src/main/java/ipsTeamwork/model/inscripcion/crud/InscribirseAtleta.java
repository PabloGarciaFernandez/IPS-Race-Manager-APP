package ipsTeamwork.model.inscripcion.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;
import ipsTeamwork.model.inscripcion.InscripcionDto;

public class InscribirseAtleta {

	public void execute(InscripcionDto inscripcion) {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(SQLStrings.insertInscripcionValues);
			pst.setString(1, inscripcion.getIdAtleta());
			pst.setString(2, inscripcion.getIdCarrera());
			pst.setString(3, inscripcion.getDorsal());
			pst.setDate(4, new java.sql.Date(inscripcion.getFechaInscripcion().getTime()));
			pst.setString(5, inscripcion.getEstadoInscripcion());
			pst.setString(6, inscripcion.getFormaDePago());
			pst.setString(7, null);
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {

		} finally {
			gdb.cerrarCon();
		}
	}
}

package ipsTeamwork.model.inscripcion.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.model.inscripcion.InscripcionDto;

public class UpdateInscribirseAtleta {

	public static String updateInscripcionValues = "UPDATE inscripcion SET estadoInscripcion = ?, fechaInscripcion = ? where idAtleta = ? and idCarrera = ? and dorsal = ?";

	public static String updateInscripcionValuesPago = "UPDATE inscripcion SET formaDePago = ? where idAtleta = ? and idCarrera = ? and dorsal = ?";
	
	public static void execute(InscripcionDto inscripcion, String estadoInscripcion) {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(updateInscripcionValues);

			pst.setString(1, estadoInscripcion);
			pst.setDate(2, new Date(new java.util.Date().getTime()));
			pst.setString(3, inscripcion.getIdAtleta());
			pst.setString(4, inscripcion.getIdCarrera());
			pst.setString(5, inscripcion.getDorsal());

			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
	}

	public static void execute2(InscripcionDto inscripcion, String formaDePago) {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(updateInscripcionValuesPago);

			pst.setString(1, formaDePago);
			pst.setString(2, inscripcion.getIdAtleta());
			pst.setString(3, inscripcion.getIdCarrera());
			pst.setString(4, inscripcion.getDorsal());

			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
	}
}

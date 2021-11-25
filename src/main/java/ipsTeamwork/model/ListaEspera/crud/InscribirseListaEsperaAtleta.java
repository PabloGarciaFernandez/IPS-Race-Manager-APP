package ipsTeamwork.model.ListaEspera.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;
import ipsTeamwork.model.ListaEspera.ListaEsperaDto;

public class InscribirseListaEsperaAtleta {

	public static void execute(ListaEsperaDto lista) {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(SQLStrings.insertListaEsperaValues);
			pst.setString(1, lista.getIdAtleta());
			pst.setString(2, lista.getIdCarrera());
			pst.setDate(3, new java.sql.Date(lista.getFechaInscripcion().getTime()));
			pst.setString(4, lista.getCategoria());
			pst.setInt(5, lista.getPosicion());

			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			System.out.println("Manolo");
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
	}
}

package ipsTeamwork.model.inscripcion.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;

public class AppendIncidencia {
	private String toAppend;
	private String idCarrera;
	private String idAtleta;
	
	private String updateQuery = "update inscripcion set incidenciasPagos = ? where idAtleta = ? and idCarrera = ?";
	
	public AppendIncidencia(String s, String idCarrera, String idAtleta) {
		this.toAppend = s;
		this.idAtleta = idAtleta;
		this.idCarrera = idCarrera;
	}
	
	public void execute() {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(SQLStrings.insertAtletaValues);
			pst.setString(1, toAppend);
			pst.setString(2, idAtleta);
			pst.setString(3, idCarrera);

			pst.executeUpdate();
		} catch (Exception e) {

		} finally {
			gdb.cerrarCon();
		}
	}
}

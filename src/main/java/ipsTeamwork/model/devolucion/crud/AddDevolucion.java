package ipsTeamwork.model.devolucion.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;
import ipsTeamwork.model.devolucion.DevolucionDto;

public class AddDevolucion {

	DevolucionDto dev;
	
	public AddDevolucion(DevolucionDto dto) {
		this.dev = dto;
	}
	
	public void execute() {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(SQLStrings.insertDevolucionValues);
			pst.setString(1, dev.carrera_id);
			pst.setInt(2, dev.porcentaje);
			pst.setDate(3, new java.sql.Date(dev.fechaLimite.getTime()));
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
		
	}
}

package ipsTeamwork.model.carrera.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;
import ipsTeamwork.model.carrera.CarreraDto;

public class UpdateCarrera {

	public static String updateCarrerasValues = "UPDATE carrera SET plazasDisp = ? where idCarrera = ?";

	public void execute(CarreraDto carrera) {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			
			PreparedStatement pst = con.prepareStatement(updateCarrerasValues);

			pst.setInt(1, carrera.getPlazasDisp());
			pst.setString(2, carrera.getIdCarrera());

			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
	}
}

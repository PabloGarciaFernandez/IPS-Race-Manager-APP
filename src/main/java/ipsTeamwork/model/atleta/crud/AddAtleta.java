package ipsTeamwork.model.atleta.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;
import ipsTeamwork.model.atleta.AtletaDto;

public class AddAtleta {
	AtletaDto atleta;

	public AddAtleta(AtletaDto dto) {
		this.atleta = dto;
	}

	public void execute() {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(SQLStrings.insertAtletaValues);
			pst.setString(1, UUID.randomUUID().toString());
			pst.setString(2, atleta.getDNI());
			pst.setString(3, atleta.getNombre());
			pst.setInt(4, atleta.getEdad());
			pst.setString(5, atleta.getSexo());
			pst.setInt(6, (atleta.isDiscapacitado() ? 1 : 0));
			pst.setString(7, atleta.getEmail());
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			gdb.cerrarCon();
		}

	}

	public void execute2() {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(SQLStrings.insertAtletaValues);
			pst.setString(1, atleta.getIdAtleta());
			pst.setString(2, atleta.getDNI());
			pst.setString(3, atleta.getNombre());
			pst.setInt(4, atleta.getEdad());
			pst.setString(5, atleta.getSexo());
			pst.setInt(6, (atleta.isDiscapacitado() ? 1 : 0));
			pst.setString(7, atleta.getEmail());
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			gdb.cerrarCon();
		}

	}
}

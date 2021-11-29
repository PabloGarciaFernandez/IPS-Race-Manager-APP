package ipsTeamwork.model.atleta.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;
import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.util.DtoBuilder;

public class FindAtletaByEmail {

	public AtletaDto execute(String email) {
		GestorDB gdb = new GestorDB();
		Connection c = gdb.getConnection();
		ResultSet rs = null;
		AtletaDto dto = null;

		try {
			PreparedStatement pst = c.prepareStatement(SQLStrings.atletaByEmail);

			pst.setString(1, email);

			rs = pst.executeQuery();
			dto = DtoBuilder.toAtletaDto(rs);

			rs.close();
			pst.close();
		} catch (Exception e) {

		} finally {
			gdb.cerrarCon();
		}
		return dto;
	}
}
package ipsTeamwork.model.atleta.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.util.DtoBuilder;

public class ReadAtletaByEmail {

	private String email;
	public static String QUERY_ATLETA = "select * from atleta a where a.email = ?";
	
	public ReadAtletaByEmail(String email) {
		this.email = email;
	}
	
	public AtletaDto execute() {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		AtletaDto atleta = null;
		
		try {
			PreparedStatement st = con.prepareStatement(QUERY_ATLETA);
			
			st.setString(1, email);
			
			ResultSet rs = st.executeQuery();
			
			rs.next();
			atleta = DtoBuilder.toAtletaDto(rs);
					
			
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
		return atleta;
	}
}

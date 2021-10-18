package ipsTeamwork.model.atleta.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.util.DtoBuilder;

public class ListarAtletasArray {
	
	public static String QUERY_ALL = "select * from atleta";
	
	public List<AtletaDto> execute() {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		List<AtletaDto> atleta = null;
		
		try {
			PreparedStatement st = con.prepareStatement(QUERY_ALL);
						
			ResultSet rs = st.executeQuery();
			
			rs.next();
			atleta = DtoBuilder.toAtletaDtoList(rs);
					
			
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

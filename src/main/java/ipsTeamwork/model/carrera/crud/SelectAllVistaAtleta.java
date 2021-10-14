package ipsTeamwork.model.carrera.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.util.DtoBuilder;

public class SelectAllVistaAtleta {
	
	private String query = "SELECT * FROM CARRERA c WHERE c.fechaFinInsc >= ? ORDER BY c.fechaFinInsc";
	// ? -> '2021-12-31'
	
	public List<CarreraDto> execute() {
		List<CarreraDto> carr = null;
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setDate(1, new Date(new java.util.Date().getTime())); //esto igual va igual no
			ResultSet rs = pst.executeQuery();
			
			carr = DtoBuilder.toCarreraDtoList(rs);
			
			
			rs.close();
			pst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
		
		return carr;
	}
}

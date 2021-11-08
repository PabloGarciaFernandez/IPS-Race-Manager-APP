package ipsTeamwork.model.categoria.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.controller.SQLStrings;
import ipsTeamwork.model.categoria.CategoriaDto;

public class AddCategoria {
	CategoriaDto Categoria;
	
	public AddCategoria(CategoriaDto dto) {
		this.Categoria = dto;
	}
	
	public void execute() {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(SQLStrings.insertCategoriaValues);
			pst.setString(1, Categoria.carrera_id);
			pst.setString(2, Categoria.nombre);
			pst.setInt(3, Categoria.edadInic);
			pst.setInt(4, Categoria.edadFin);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
		
	}
}

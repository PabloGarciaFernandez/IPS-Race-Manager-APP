package ipsTeamwork.model.inscripcion.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Map;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.model.inscripcion.InscripcionDto;

public class UpdateInscribirseAtleta {

	public static String updateInscripcionValues = "UPDATE inscripcion SET estadoInscripcion = ?, fechaInscripcion = ?, tiempoCorriendo = ? where idAtleta = ? and idCarrera = ? and dorsal = ?";

	public static String updateInscripcionValuesPago = "UPDATE inscripcion SET formaDePago = ?, tiempoCorriendo = ? where idAtleta = ? and idCarrera = ? and dorsal = ?";
	
	public static String updateInscripcionTiempoByDorsalAndIdCarrera = "UPDATE inscripcion SET tiempoCorriendo = ? where idCarrera = ? and dorsal = ?";
	
	public static void execute(InscripcionDto inscripcion, String estadoInscripcion) {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(updateInscripcionValues);

			pst.setString(1, estadoInscripcion);
			pst.setDate(2, new Date(new java.util.Date().getTime()));
			pst.setString(3, "NP");
			pst.setString(4, inscripcion.getIdAtleta());
			pst.setString(5, inscripcion.getIdCarrera());
			pst.setString(6, inscripcion.getDorsal());

			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
	}

	public static void execute2(InscripcionDto inscripcion, String formaDePago) {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(updateInscripcionValuesPago);

			pst.setString(1, formaDePago);
			pst.setString(2, "NP");
			pst.setString(3, inscripcion.getIdAtleta());
			pst.setString(4, inscripcion.getIdCarrera());
			pst.setString(5, inscripcion.getDorsal());

			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
	}
	
	public static int updateInscripcionTiempoByDorsalAndIdCarrera(String idCarrera, Map<String, String> dorsalTiempo) {
		GestorDB gdb = new GestorDB();
		Connection con = gdb.getConnection();
		
		int contadorActualizaciones = 0;
		
		try {
			PreparedStatement pst = con.prepareStatement(updateInscripcionTiempoByDorsalAndIdCarrera);

			for (Map.Entry<String, String> entrada : dorsalTiempo.entrySet()) {
			    System.out.println(entrada.getKey() + "/" + entrada.getValue());
			    
				pst.setString(1, entrada.getValue());
				pst.setString(2, idCarrera);
				pst.setString(3, entrada.getKey());

				 int resultado = pst.executeUpdate();
				
				contadorActualizaciones+= resultado;
			}
		
			
		
			pst.close();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gdb.cerrarCon();
		}
		return contadorActualizaciones;
	}
}

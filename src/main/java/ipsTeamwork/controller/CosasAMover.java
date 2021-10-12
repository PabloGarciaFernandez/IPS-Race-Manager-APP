package ipsTeamwork.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CosasAMover {
	
	//QUERY PARA CHECKEAR EN EL INGRESO.
	
	private static String QUERY_DE_INGRESO = "SELECT 1 FROM ATLETA WHERE EMAIL = ?";
	private static String QUERY_DE_INSCRIPCION_A_CARRERA = "insert into inscripcion(idAtleta, idCarrera, dorsal, fechaInscripcion, "
			+ "estadoInscripcion, formaDePago, tiempoCorriendo) values (?, ?, ?, ?, ?, ?, ?)";
	
	//INTRODUCCIÓN DATOS A LA DB		
	private static Connection conn = null;

	private static PreparedStatement pst = null;

	private static ResultSet rs = null;
	
	/**
	 * MÃ©todo que establece una conexion con la base de datos.
	 */
	private static void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:database.db");
		} catch (ClassNotFoundException e) {
			System.out.println("Error en la conexiÃ³n de la base de datos: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error en la conexiÃ³n de la base de datos: " + e.getMessage());
		}
	}
	
	/**
	 * @author Pablo García Fernández
	 * 
	 * Metodo que se usa en la pestaña de registro para almacenarlo en la base de datos.
	 * 
	 * @param List<String> Con todos los datos para ser insertados.
	 */
	public static void registroAtleta(List<String> datos) {
		conectar();
		try {
			PreparedStatement pst = conn.prepareStatement(SQLStrings.insertAtletaValues);
			pst.setString(1, UUID.randomUUID().toString());
			pst.setString(2, datos.get(1));
			pst.setString(3, datos.get(3) + datos.get(4));
			pst.setInt(4, Integer.parseInt(datos.get(2)));
			pst.setString(5, ""+(datos.get(5).charAt(0)));
			pst.setBoolean(6, (datos.get(5).equals("Si") ? true : false));	
			//pst.setString(7, datos.get(0));	//NECESITO QUE SE AÑADA EL PARAMETRO DE EMAIL
			pst.executeUpdate();
			pst.close();
		
		} catch (Exception e) {
			
		} finally {
			cerrar();
		}
	}
	
	private static void cerrar() {
		try {

			if (pst != null)
				pst.close();

			if (rs != null)
				rs.close();

			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			System.out.println("Error al cerrar la base de datos: " + e.getMessage());
		}
	}
	
	public static boolean checkAtleta(String email) {
		conectar();
		boolean res = false;
		try {
			PreparedStatement pst = conn.prepareStatement(SQLStrings.insertAtletaValues);
			pst.setString(1, email);
			res = rs.next();
			pst.executeUpdate();
			pst.close();		
		} catch (Exception e) {
			
		} finally {
			cerrar();
		}
		return res;
	}
	
	public static void printJustificante(String algo) {
		System.out.println("JUSTIFICANTE CARRERA: ");
		System.out.println("Nombre: ");
		System.out.println("Competición: ");
		System.out.println("Categoría: ");
		System.out.println("Fecha inscripción: ");
		System.out.println("Abono: ");
		//ESTADO PRE-INSCRITO modificar tabla inscripcion
	}
	
	public void calculadorDeCategoria() {
		
	}
}

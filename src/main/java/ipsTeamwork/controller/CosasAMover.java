package ipsTeamwork.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

import ipsTeamwork.model.atleta.AtletaDto;

public class CosasAMover {

	// QUERY PARA CHECKEAR EN EL INGRESO.

	private static String QUERY_DE_INGRESO = "select * from atleta where email = ?";


	private static String QUERY_DE_INSCRIPCION_A_CARRERA = "insert into inscripcion(idAtleta, idCarrera, dorsal, fechaInscripcion, "
			+ "estadoInscripcion, formaDePago, tiempoCorriendo) values (?, ?, ?, ?, ?, ?, ?)";
	
	public static String QUERRY_ATLETA_DATOS = "select a.dni, a.nombre, a.edad, a.sexo, a.discapacitado from atleta a where a.email = ";

	// INTRODUCCI�N DATOS A LA DB
	private static Connection conn = null;

	private static PreparedStatement pst = null;

	private static ResultSet rs = null;

	/**
	 * Método que establece una conexion con la base de datos.
	 */
	private static void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:database.db");
		} catch (ClassNotFoundException e) {
			System.out.println("Error en la conexión de la base de datos: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error en la conexión de la base de datos: " + e.getMessage());
		}
	}

	/**
	 * @author Pablo Garcia Fernandez
	 * 
	 *         Metodo que se usa en la pesta�a de registro para almacenarlo en la
	 *         base de datos.
	 * 
	 * @param List<String> Con todos los datos para ser insertados.
	 */
	public static void registroAtleta(AtletaDto atleta) {
		conectar();
		try {
			PreparedStatement pst = conn.prepareStatement(SQLStrings.insertAtletaValues);
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

	public static void printJustificante(String algo) {
		System.out.println("JUSTIFICANTE CARRERA: ");
		System.out.println("Nombre: ");
		System.out.println("Competici�n: ");
		System.out.println("Categor�a: ");
		System.out.println("Fecha inscripci�n: ");
		System.out.println("Abono: ");
		// ESTADO PRE-INSCRITO modificar tabla inscripcion
	}
	
	public static boolean comprobarAtleta(String email) {
		boolean result = false;
		
		conectar();
		try {
			PreparedStatement pst = conn.prepareStatement(QUERY_DE_INGRESO);
			pst.setString(0, email);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
				result = true;
			else
				result = false;
			
			rs.close();
			pst.close();
		} catch (Exception e) {

		} finally {
			cerrar();
		}
		
		return result;
	}

	public static AtletaDto generarAtletaEnBaseADatos(String email) {
		conectar();
		AtletaDto atleta = null;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(QUERRY_ATLETA_DATOS + email);
			while(rs.next()) {
				atleta = new AtletaDto(rs.getString(0),rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			}
			
			
			rs.close();
			st.close();
		} catch (Exception e) {

		} finally {
			cerrar();
		}
		return atleta;
	}
}

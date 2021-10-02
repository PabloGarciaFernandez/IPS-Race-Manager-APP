package gestorDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que accede a la base de datos y tiene métodos para sacar y añadir datos
 * 
 * @author Sergio Arroni del Riego
 *
 */
public class GestorDB {

	private Connection conn = null;

	private PreparedStatement pst = null;

	private ResultSet rs = null;

	/**
	 * Metodo que establece una conexion con la base de datos.
	 */
	private void conectar() {
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
	 * Metodo que cierra la base de datos (Debe de estar abierta) =======CERRAR
	 * SIEMPRE=======
	 */
	private void cerrar() {
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

	// ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇
	// |CREAR TABLAS|
	// ˭˭˭˭˭˭˭˭˭˭˭˭˭˭

	public void crearTablas() {
		conectar();
		try {
			pst = conn.prepareStatement(
					"CREATE TABLE carreas (duracion INT(20) NOT NULL, acronimo CHAR(3), maxParticipantes INT(20))");
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	public void insertarCarrera() {
		conectar();
		try {
			pst = conn.prepareStatement("Insert into carreas values(50,'ACR',15); ");
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}
	
	public void deleteCarrera() {
		conectar();
		try {
			pst = conn.prepareStatement("delete from carreas where duracion = 50 ");
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	public void carrerasCortas() {
		conectar();
		try {
			pst = conn.prepareStatement("select * from carreas ");
			rs = pst.executeQuery();

			while (rs.next()) {
				System.out.println("Esta es la duración:" + rs.getString("duracion"));
			}

		} catch (SQLException e) {
			System.out.println("Error al cerrar la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

}

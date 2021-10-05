package gestorDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
			pst = conn.prepareStatement(SQLStrings.createAtleta);
			pst.execute();
			pst.close();
			
			pst = conn.prepareStatement(SQLStrings.createCarrera);
			pst.execute();
			pst.close();
			
			pst = conn.prepareStatement(SQLStrings.createTipos);
			pst.execute();
			pst.close();
			
		} catch (SQLException e) {
			System.out.println("Error al crear tabla en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	// ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇
	// |BORRAR TABLAS|
	// ˭˭˭˭˭˭˭˭˭˭˭˭˭˭

	public void borrarTablas() {
		conectar();		
		try {
			pst = conn.prepareStatement("drop table atleta");
			pst.execute();
			pst.close();
			
			pst = conn.prepareStatement("drop table carrera");
			pst.execute();
			pst.close();
			
			pst = conn.prepareStatement("drop table tiposCarrera");
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			System.out.println("Error al borrar tabla en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}
	
	
	public void poblarTablas() {
		runScript(SQLStrings.insertCarreraEjemplo);
	}

	// ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇
	// |INSERT CARRERAS|
	// ˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭

	public void insertarCarrera() {
		conectar();
		try {
			pst = conn.prepareStatement("Insert into atleta values(); ");
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	// ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇
	// |BORRAR CARRERAS|
	// ˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭

	public void deleteCarrera() {
		conectar();
		try {
			pst = conn.prepareStatement("delete from carreras where duracion = 50 ");
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}
	
	
	public void runScript(String script) {
		conectar();
		try {
			PreparedStatement ps = conn.prepareStatement(script);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error de script de DB: " + e.getMessage());
		} finally {
			cerrar();
		}
	}
	
	public void selectCarreras() {
		conectar();
		try {
			PreparedStatement ps = conn.prepareStatement(SQLStrings.selectCarrera);
			ResultSet rs = ps.executeQuery();
			
			printResultSet(rs);
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error de script de DB: " + e.getMessage());
		} finally {
			cerrar();
		}
	}
	
	
	/**
	 * utilidad para imprimir resultsets por consola
	 * @param rs
	 * @throws SQLException
	 */
	public static void printResultSet(ResultSet rs) throws SQLException
	{
	    ResultSetMetaData rsmd = rs.getMetaData();
	    int columnsNumber = rsmd.getColumnCount();
	    while (rs.next()) {
	        for (int i = 1; i <= columnsNumber; i++) {
	            if (i > 1) System.out.print(" | ");
	            System.out.print(rs.getString(i));
	        }
	        System.out.println("");
	    }
	}
	
	

	/**
	 * @author Sergio Arroni
	 * 
	 *         Partiendo de la lista de competiciones y seleccionando una, el
	 *         organizador visualizará un listado con los atletas que están
	 *         inscritos hasta el momento actual (DNI, Nombre, Categoría, Fecha de
	 *         Inscripción y Estado de Inscripción). Estarán ordenados por fecha
	 *         inscripción y estado de la inscripción.
	 * 
	 */
	public void estadoInscripcion(String idCarrera) {
		conectar();
		try {
			pst = conn.prepareStatement(
					"select * from atleta where idCarrera = ? order by fechaInscripcion, estadoInscripcion");

			pst.setString(1, idCarrera);

			rs = pst.executeQuery();

			while (rs.next()) {
				System.out.println("Este es el atleta:" + rs.getString("idAtleta"));
			}

		} catch (SQLException e) {
			System.out.println("Error en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

}
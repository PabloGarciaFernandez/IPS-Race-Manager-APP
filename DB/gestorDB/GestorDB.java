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
	 * Metodo que cierra la base de datos
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
					"CREATE TABLE atleta (idAtleta varchar2 NOT NULL, dni varchar2 not null, nombre varchar2 not null, edad integer not null, fechaInscripcion date not null, estadoInscripcion varchar2 not null, sexo varchar not null, idCarrera varchar, discapacidad bit NOT NULL, CONSTRAINT CHK_Atleta CHECK (Edad>18 AND (sexo='M' OR sexo='F' OR sexo='NB') AND (estadoInscripcion='Inscrito' OR estadoInscripcion='No inscrito'))) ");
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	// ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇
	// |BORRAR TABLAS|
	// ˭˭˭˭˭˭˭˭˭˭˭˭˭˭

	public void borrarTablas(boolean all) {
		if (!all) {
			conectar();
			try {
				pst = conn.prepareStatement("drop table atleta");
				pst.execute();
				pst.close();
			} catch (SQLException e) {
				System.out.println("Error en la la base de datos: " + e.getMessage());
			} finally {
				cerrar();
			}
		} else {
			conectar();
			try {
				pst = conn.prepareStatement("drop table *");
				pst.execute();
				pst.close();
			} catch (SQLException e) {
				System.out.println("Error en la la base de datos: " + e.getMessage());
			} finally {
				cerrar();
			}
		}
	}

	// ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇
	// |INSERT CARRERAS|
	// ˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭

	public void insertarAtleta() {
		conectar();
		try {

			pst = conn.prepareStatement(
					"Insert into atleta values('69','11122233A','Usain',25,'2021-10-25', 'Inscrito','M', '5' ,0); ");
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

	public void deleteAtleta() {
		conectar();
		try {
			pst = conn.prepareStatement("delete from atleta where idAtleta = '69' ");
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
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
	 * @return
	 * 
	 */
	public void estadoInscripcion(String idCarrera) {
		conectar();
		try {
			pst = conn.prepareStatement(
					"select * from atleta where idCarrera = ? and estadoInscripcion = 'Inscrito' order by fechaInscripcion, estadoInscripcion");

			pst.setString(1, idCarrera);

			rs = pst.executeQuery();

			while (rs.next()) {
				System.out.println("-----------------------------------------------------");
				System.out.println("Este es el atleta:\n\t DNI: " + rs.getString("dni") + "\n\t nombre: "
						+ rs.getString("nombre"));
				System.out.println("-----------------------------------------------------");
			}

		} catch (SQLException e) {
			System.out.println("Error en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

}

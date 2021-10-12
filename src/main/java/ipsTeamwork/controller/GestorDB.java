package ipsTeamwork.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.model.inscripcion.InscripcionDto;
import ipsTeamwork.util.DateUtil;
import ipsTeamwork.util.DtoBuilder;

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
	 * Método que establece una conexion con la base de datos.
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

			pst = conn.prepareStatement(SQLStrings.createAtleta);
			pst.execute();
			pst = conn.prepareStatement(SQLStrings.createCarrera);
			pst.execute();
			pst = conn.prepareStatement(SQLStrings.createInscripcion);
			pst.execute();

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

			pst = conn.prepareStatement("drop table carrera");
			pst.execute();

			pst = conn.prepareStatement("drop table inscripcion");
			pst.execute();

		} catch (SQLException e) {
			System.out.println("Error al borrar tabla en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	public void borrarTablas(boolean all) {
		if (!all) {
			conectar();
			try {
				pst = conn.prepareStatement("drop table Inscripcion");
				pst.execute();
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
	// |INSERT DATOS |
	// ˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭

	public void insertarAtleta() {
		conectar();
		try {
			pst = conn.prepareStatement(SQLStrings.insertBolt);
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	public void insertarAtleta1() {
		conectar();
		try {
			pst = conn.prepareStatement(SQLStrings.insertUsain);
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	public void insertarCarrera() {
		conectar();
		try {
			pst = conn.prepareStatement(SQLStrings.insertNewYork);
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	public void insertarInscripcion() {
		conectar();
		try {
			pst = conn.prepareStatement(SQLStrings.insertInscripcion);
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	public void insertarInscripcion1() {
		conectar();
		try {
			pst = conn.prepareStatement(SQLStrings.insertInscripcion1);
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

	public void selectAtletas() {
		conectar();
		try {
			PreparedStatement ps = conn.prepareStatement(SQLStrings.AtletaEjemplo);
			ResultSet rs = ps.executeQuery();

			printResultSet(rs);

		} catch (SQLException e) {
			System.out.println("Error de script de DB: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	/**
	 * @author Sergio Arroni
	 * 
	 *         Metodo que devuelve todas las carreras
	 */
	public ArrayList<CarreraDto> selectCarrera() {
		conectar();

		ArrayList<CarreraDto> carreras = new ArrayList<CarreraDto>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQLStrings.listaCarreras);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				CarreraDto carrera = new CarreraDto();

				carrera.setId(rs.getString("idCarrera"));
				carrera.setTipo(rs.getString("tipo"));
				carrera.setPlazasDisp(rs.getInt("maxPlazas"));

				carreras.add(carrera);
			}

//			printResultSet(rs);
		} catch (SQLException e) {
			System.out.println("Error de script de DB: " + e.getMessage());
		} finally {
			cerrar();
		}
		return carreras;
	}

	public void selectInscripcion() {
		conectar();
		try {
			PreparedStatement ps = conn.prepareStatement(SQLStrings.InscripcionEjemplo);
			ResultSet rs = ps.executeQuery();

			printResultSet(rs);

		} catch (SQLException e) {
			System.out.println("Error de script de DB: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	/**
	 * utilidad para imprimir resultsets por consola
	 * 
	 * @param rs
	 * @throws SQLException
	 */
	public static void printResultSet(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				if (i > 1)
					System.out.print(" | ");
				System.out.print(rs.getString(i));
			}
			System.out.println("");
		}
	}

	/**
	 * utilidad para imprimir resultsets por consola
	 * 
	 * @param rs
	 * @throws SQLException
	 */
	public static int printResultSetOrdenadoClasificaciones(ResultSet rs, int valorInicial, boolean tieneTiempo)
			throws SQLException {

		int orden = valorInicial;
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {
			System.out.print(orden + "� | ");
			for (int i = 1; i <= columnsNumber; i++) {
				if (i > 1)
					System.out.print(" | ");
				System.out.print(rs.getString(i));
			}
			if (tieneTiempo == false) {
				System.out.print(" | ---");

			}
			System.out.println();
			orden++;
		}

		return orden;
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
	 */
	public ArrayList<InscripcionDto> estadoInscripcion(String idCarrera) {
		conectar();

		ArrayList<InscripcionDto> atletasInscritos = new ArrayList<InscripcionDto>();

		try {

			PreparedStatement pst2 = conn.prepareStatement(SQLStrings.AtletaEjemplo);
			pst = conn.prepareStatement(SQLStrings.estadoInscipcion);

			pst.setString(1, idCarrera);

			rs = pst.executeQuery();

			while (rs.next()) {
				ResultSet rs2 = null;
				InscripcionDto inscripcion = new InscripcionDto();
//				pst2.setString(1, rs.getString("idAtleta"));
				AtletaDto nuevoAtleta = new AtletaDto();
				rs2 = pst2.executeQuery();

				System.out.println(rs2.next());

				while (rs2.next()) {
					System.out.println("-----------------");
					nuevoAtleta.setDNI(rs2.getString("DNI"));
					nuevoAtleta.setEdad(rs2.getInt("edad"));
					nuevoAtleta.setSexo(rs2.getString("sexo"));
					nuevoAtleta.setNombre(rs2.getString("nombre"));
				}

				System.out.println(nuevoAtleta.getDNI());

				inscripcion.setAtleta(nuevoAtleta);
				// Esto es para que me lea bien la fecha
				inscripcion.setEstadoInscripcion(rs.getString("estadoInscripcion"));
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fechaInscripcion"));
				inscripcion.setFechaInscripcion(new java.sql.Date(date.getTime()));
				atletasInscritos.add(inscripcion);
				rs2.close();
			}
			pst2.close();
		} catch (SQLException e) {
			System.out.println("Error en la base de datos: " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("Error en el date: " + e.getMessage());
		} finally {
			cerrar();
		}
		return atletasInscritos;
	}

	/**
	 * @author Juan Torrente
	 * 
	 *         este metodo solamente llama a los demas poblarXX() de cada tabla
	 */
	public void poblarTablas() {
		poblarCarreras(25);
		poblarAtletas(25);
		poblarInscripciones(25);
	}

	private void poblarInscripciones(int i) {
		conectar();
		Random r = new Random();
		try {

			for (int j = 0; j < i; j++) {
				PreparedStatement pst = conn.prepareStatement(SQLStrings.insertInscrpcionValues);
				pst.setString(1, UUID.randomUUID().toString());
				pst.setString(2, UUID.randomUUID().toString());
				pst.setString(3, (r.nextBoolean() ? "myDorsal" : "myOtherDorsal"));
				pst.setDate(4, java.sql.Date.valueOf(LocalDate.now().getYear() + "-" + LocalDate.now().getMonthValue()
						+ "-" + LocalDate.now().getDayOfMonth()));
				pst.setString(5, (r.nextBoolean() ? "Inscrito" : "Pendiente de pago"));
				pst.setString(6, (r.nextBoolean() ? "Transferencia" : "Tarjeta"));
				pst.setInt(7, r.nextInt(300));

				pst.executeUpdate();
				pst.close();

			}
		} catch (Exception e) {
			System.out.println("hadios");
			System.out.println("hola     " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	public void poblarCarreras(int i) {
		conectar();
		Random r = new Random();
		try {
			for (int j = 0; j < i; j++) {
				System.out.println("metiendo carrera " + j);
				PreparedStatement pst = conn.prepareStatement(SQLStrings.insertCarreraValues); // (idCarrera, nombre,
																								// fecha, tipo,
																								// distancia, cuota,
																								// fechaFinInsc,
																								// plazasDisp)

				pst.setString(1, UUID.randomUUID().toString());
				pst.setString(2, UUID.randomUUID().toString().substring(0, 5));

				java.sql.Date d = new java.sql.Date(DateUtil
						.between(new Date(), new Calendar.Builder().setDate(2023, 12, 31).build().getTime()).getTime());
				pst.setDate(3, d); // fecha origen

				pst.setString(4, (r.nextBoolean() ? "Asfalto" : "Montaña"));
				pst.setInt(5, r.nextInt(24) + 1); // distancia en km
				pst.setInt(6, r.nextInt(50 + 1)); // cuota

				java.sql.Date d2 = new java.sql.Date(
						new Calendar.Builder().setDate(2022, 1, 1).build().getTimeInMillis());
				pst.setDate(7, d2); // fecha origen

				pst.setInt(8, r.nextInt(100 + 1));
				pst.setInt(9, r.nextInt(100 + 1));

				pst.executeUpdate();
				pst.close();

				System.out.println(d2.toString());
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public void poblarAtletas(int i) {
		conectar();
		Random r = new Random();
		try {
			for (int j = 0; j < i; j++) {
				PreparedStatement pst = conn.prepareStatement(SQLStrings.insertAtletaValues);
				pst.setString(1, UUID.randomUUID().toString());
				pst.setString(2, (r.nextBoolean() ? "myDNI" : "myOtherDNI"));
				pst.setString(3, (r.nextBoolean() ? "myName" : "myOtherName"));
				pst.setInt(4, (r.nextBoolean() ? 30 : 60));
				pst.setString(5, (r.nextBoolean() ? "M" : "F"));
				pst.setBoolean(6, (r.nextBoolean() ? true : false));

				pst.executeUpdate();
				pst.close();
			}
		} catch (Exception e) {

		} finally {
			cerrar();
		}
	}

	public void obtenerClasificacionGeneral() {

		conectar();
		try {

			pst = conn.prepareStatement(SQLStrings.clasificacionGeneralPresentados);

			rs = pst.executeQuery();

			int valor = printResultSetOrdenadoClasificaciones(rs, 1, true);

			pst = conn.prepareStatement(SQLStrings.clasificacionGeneralNoFinaliza);

			rs = pst.executeQuery();

			int valor2 = printResultSetOrdenadoClasificaciones(rs, valor, false);

			pst = conn.prepareStatement(SQLStrings.clasificacionGeneralNoPresentados);

			rs = pst.executeQuery();

			printResultSetOrdenadoClasificaciones(rs, valor2, false);

		} catch (Exception e) {

		} finally {
			cerrar();
		}

	}

	public void obtenerClasificacionGeneralHombres() {

		conectar();
		try {

			pst = conn.prepareStatement(SQLStrings.clasificacionGeneralPresentadosHombres);

			rs = pst.executeQuery();

			int valor = printResultSetOrdenadoClasificaciones(rs, 1, true);

			pst = conn.prepareStatement(SQLStrings.clasificacionGeneralNoFinalizaHombres);

			rs = pst.executeQuery();

			int valor2 = printResultSetOrdenadoClasificaciones(rs, valor, false);

			pst = conn.prepareStatement(SQLStrings.clasificacionGeneralNoPresentadosHombres);

			rs = pst.executeQuery();

			printResultSetOrdenadoClasificaciones(rs, valor2, false);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrar();
		}

	}

	public void obtenerClasificacionGeneralMujeres() {
		conectar();
		try {

			pst = conn.prepareStatement(SQLStrings.clasificacionGeneralPresentadosMujeres);

			rs = pst.executeQuery();

			int valor = printResultSetOrdenadoClasificaciones(rs, 1, true);

			pst = conn.prepareStatement(SQLStrings.clasificacionGeneralNoFinalizaMujeres);

			rs = pst.executeQuery();

			int valor2 = printResultSetOrdenadoClasificaciones(rs, valor, false);

			pst = conn.prepareStatement(SQLStrings.clasificacionGeneralNoPresentadosMujeres);

			rs = pst.executeQuery();

			printResultSetOrdenadoClasificaciones(rs, valor2, false);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public List<CarreraDto> listarCarreras() {
		List<CarreraDto> ret = null;
		conectar();

		try {
			pst = conn.prepareStatement(SQLStrings.listaCarreras);
			rs = pst.executeQuery();

			ret = DtoBuilder.toCarreraDtoList(rs);

		} catch (SQLException e) {
			e.printStackTrace();
			;
		}

		return ret;
	}
}
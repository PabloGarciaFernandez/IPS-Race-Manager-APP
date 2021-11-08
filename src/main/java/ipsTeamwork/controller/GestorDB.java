package ipsTeamwork.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.model.atleta.crud.ListarAtletasArray;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.model.categoria.CategoriaDto;
import ipsTeamwork.model.categoria.crud.AddCategoria;
import ipsTeamwork.model.inscripcion.InscripcionDto;
import ipsTeamwork.util.DateUtil;
import ipsTeamwork.util.DtoBuilder;

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
			e.printStackTrace();
			System.out.println("Error en la conexión de la base de datos: " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
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
			e.printStackTrace();
			System.out.println("Error al cerrar la base de datos: " + e.getMessage());
		}
	}

	// ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇
	// |CREAR TABLAS|
	// ˭˭˭˭˭˭˭˭˭˭˭˭˭˭

	public void crearTablas() {
		conectar();
		try {
//			pst = conn.prepareStatement(SQLStrings.dropCategoria);
//			pst.execute();
//			pst = conn.prepareStatement(SQLStrings.dropInscripcion);
//			pst.execute();			
//			pst = conn.prepareStatement(SQLStrings.dropCarrera);
//			pst.execute();
//			pst = conn.prepareStatement(SQLStrings.dropAtleta);
//			pst.execute();
			
			pst = conn.prepareStatement(SQLStrings.createAtleta);
			pst.execute();
			pst = conn.prepareStatement(SQLStrings.createCarrera);
			pst.execute();
			pst = conn.prepareStatement(SQLStrings.createInscripcion);
			pst.execute();
			pst = conn.prepareStatement(SQLStrings.createCategoria);
			pst.execute();
			pst = conn.prepareStatement(SQLStrings.createPago);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
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
			pst = conn.prepareStatement("drop table categoria");
			pst.execute();
			
			pst = conn.prepareStatement("drop table atleta");
			pst.execute();

			pst = conn.prepareStatement("drop table carrera");
			pst.execute();

			pst = conn.prepareStatement("drop table inscripcion");
			pst.execute();
			
			pst = conn.prepareStatement("drop table pago");
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	// ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ ͇ 
	// |INSERT DATOS |
	// ˭˭˭˭˭˭˭˭˭˭˭˭˭˭˭

	public void insertarAtleta() {
		conectar();
		try {
			pst = conn.prepareStatement(SQLStrings.insertBolt);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public void insertarInscripcionParametros(InscripcionDto i1) {
		conectar();
		try {
			pst = conn.prepareStatement(SQLStrings.insertInscripcionValues);
			pst.setString(0, i1.getAtleta().getIdAtleta());
			pst.setString(1, i1.getCarrera().getIdCarrera());
			pst.setString(2, i1.getDorsal());
			pst.setString(3, String.valueOf(i1.getFechaInscripcion()));
			pst.setString(4, i1.getEstadoInscripcion());
			pst.setString(5, i1.getFormaDePago());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public void deleteAtleta() {
		conectar();
		try {
			pst = conn.prepareStatement("delete from atleta where idAtleta = '69' ");
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
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
			PreparedStatement ps = conn.prepareStatement(SQLStrings.selectAllAtleta);
			ResultSet rs = ps.executeQuery();

			printResultSet(rs);

		} catch (SQLException e) {
			System.out.println("Error de script de DB: " + e.getMessage());
		} finally {
			cerrar();
		}
	}

	public void selectCarreras() {
		conectar();
		try {
			PreparedStatement ps = conn.prepareStatement(SQLStrings.selectAllCarrera);
			ResultSet rs = ps.executeQuery();

			printResultSet(rs);

		} catch (SQLException e) {
			System.out.println("Error de script de DB: " + e.getMessage());
		} finally {
			cerrar();
		}
	}
	
	public void selectPagos() {
		conectar();
		try {
			PreparedStatement ps = conn.prepareStatement(SQLStrings.selectAllPago);
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
	 *         Metodo para seleccionar carreras pasando un nombre
	 * @return
	 */
	public CarreraDto selectCarrerasNombre(String nombre) {
		conectar();

		List<CarreraDto> carreras = new ArrayList<CarreraDto>();

		try {
			PreparedStatement ps = conn.prepareStatement(SQLStrings.selectCarreraByNombre);
			ps.setString(1, nombre);
			ResultSet rs = ps.executeQuery();

			carreras = DtoBuilder.toCarreraDtoList(rs);

		} catch (SQLException e) {
			System.out.println("Error de script de DB: " + e.getMessage());
		} finally {
			cerrar();
		}
		if (carreras.size() < 1) return null;
		else return carreras.get(0);
	}
	
	

	/**
	 * @author Sergio Arroni
	 * 
	 *         Metodo que devuelve todas las carreras
	 */
	public ArrayList<CarreraDto> getArrayCarreras() {
		conectar();

		ArrayList<CarreraDto> carreras = new ArrayList<CarreraDto>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQLStrings.selectAllCarrera);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				CarreraDto carrera = new CarreraDto();

				carrera.setIdCarrera(rs.getString("idCarrera"));
				carrera.setTipo(rs.getString("tipo"));
				carrera.setPlazasDisp(rs.getInt("maxPlazas"));

				carreras.add(carrera);
			}

		} catch (SQLException e) {
			System.out.println("Error de script de DB: " + e.getMessage());
		} finally {
			cerrar();
		}
		return carreras;
	}

	public ArrayList<InscripcionDto> getArrayClasificaciones(String idCarrera) {
		conectar();

		ArrayList<InscripcionDto> inscripciones = new ArrayList<InscripcionDto>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQLStrings.selectInscripcionByIDCarrera);// AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
			ps.setString(1, idCarrera);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				InscripcionDto inscripcion = new InscripcionDto();
				inscripcion.setAtleta(new AtletaDto());
				inscripcion.setCarrera(new CarreraDto());


				inscripcion.getAtleta().setIdAtleta(rs.getString(1));
				

				
				PreparedStatement psAtleta = conn.prepareStatement(SQLStrings.selectAtletaById);
				psAtleta.setString(1, rs.getString(1));
				
				ResultSet rsAtleta = psAtleta.executeQuery();
				
				inscripcion.getAtleta().setSexo(rsAtleta.getString(5));
				inscripcion.getAtleta().setNombre(rsAtleta.getString(3));

				
				inscripcion.getCarrera().setIdCarrera(rs.getString(2));
				inscripcion.setDorsal(rs.getString(3));
				inscripcion.setFechaInscripcion(rs.getDate(4));
				inscripcion.setEstadoInscripcion(rs.getString(5));
				inscripcion.setFormaDePago(rs.getString(6));
				inscripcion.setTiempoCorriendo(rs.getString(7));
				inscripcion.setCategoria(rs.getString(8));

				inscripciones.add(inscripcion);
			}
			
//			PreparedStatement ps = conn.prepareStatement(SQLStrings.clasificacionGeneralPresentados);// AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//
//				InscripcionDto inscripcion = new InscripcionDto();
//				inscripcion.setAtleta(new AtletaDto());
//
//				inscripcion.getAtleta().setNombre(rs.getString(2));
//				inscripcion.getAtleta().setSexo(rs.getString(1));
//				
//				inscripcion.setTiempoCorriendo(Integer.toString(rs.getInt(3)));
//				
//
//				inscripciones.add(inscripcion);
//			}
////
//			ps = conn.prepareStatement(SQLStrings.clasificacionGeneralNoFinaliza);// AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//
//				InscripcionDto inscripcion = new InscripcionDto();
//				inscripcion.setAtleta(new AtletaDto());
//
//				inscripcion.getAtleta().setNombre(rs.getString(2));
//				inscripcion.getAtleta().setSexo(rs.getString(1));
//				inscripcion.setTiempoCorriendo("NF");
//
//				inscripciones.add(inscripcion);
//			}
//
//			ps = conn.prepareStatement(SQLStrings.clasificacionGeneralNoPresentados);// AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//
//				InscripcionDto inscripcion = new InscripcionDto();
//
//				inscripcion.setAtleta(new AtletaDto());
//
//				inscripcion.getAtleta().setSexo(rs.getString(1));
//
//				inscripcion.getAtleta().setNombre(rs.getString(2));
//				inscripcion.setTiempoCorriendo("NP");
//
//				inscripciones.add(inscripcion);
//			}

		} catch (SQLException e) {
			System.out.println("Error de script de DB: " + e.getMessage());
		} finally {
			cerrar();
		}
		return inscripciones;
	}

	
	

	public void selectInscripcion() {
		conectar();
		try {
			PreparedStatement ps = conn.prepareStatement(SQLStrings.selectAllInscripcion);
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

	public static int printResultSetOrdenadoClasificaciones(ResultSet rs, int valorInicial, boolean tieneTiempo)
			throws SQLException {

		int orden = valorInicial;
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {
			System.out.print(orden + "º | ");
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

			PreparedStatement pst2 = conn.prepareStatement(SQLStrings.estadoInscripcionAtleta);
			pst = conn.prepareStatement(SQLStrings.estadoInscripcion);

			pst.setString(1, idCarrera);

			rs = pst.executeQuery();

			while (rs.next()) {
				ResultSet rs2 = null;
				InscripcionDto inscripcion = new InscripcionDto();
				pst2.setString(1, rs.getString("idAtleta"));
				AtletaDto nuevoAtleta = new AtletaDto();
				
				CarreraDto cdto = new CarreraDto();
				cdto.setIdCarrera(idCarrera);
				inscripcion.setCarrera(cdto);
				
				rs2 = pst2.executeQuery();

				while (rs2.next()) {
					System.out.println("-----------------");
					nuevoAtleta.setDNI(rs2.getString("dni"));
					System.out.println("Manolo Wacho-----------" + rs2.getString("dni"));
					nuevoAtleta.setEdad(rs2.getInt("edad"));
					nuevoAtleta.setSexo(rs2.getString("sexo"));
					nuevoAtleta.setNombre(rs2.getString("nombre"));
				}

				System.out.println("Manolo-----------" + nuevoAtleta.getDNI());

				inscripcion.setAtleta(nuevoAtleta);
				// Esto es para que me lea bien la fecha
				inscripcion.setEstadoInscripcion(rs.getString("estadoInscripcion"));
				inscripcion.setFechaInscripcion(rs.getDate("fechaInscripcion"));
				atletasInscritos.add(inscripcion);
				rs2.close();
			}
			pst2.close();
		} catch (SQLException e) {
			e.printStackTrace();
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
		poblarCarreras(20);
		poblarAtletas(20);		
		poblarInscripciones(20);
		poblarCategorias();
	}

	private void poblarCategorias() {
		List<CarreraDto> carreras = listarCarreras();
		
		for (int i = 0; i < carreras.size(); i++) {
			CarreraDto c =  carreras.get(i);
			
			CategoriaDto cat = new CategoriaDto();
			
			cat.carrera_id = c.getIdCarrera();
			cat.edadFin = 50;
			cat.edadInic = 18;
			cat.nombre = "cat " + c.getNombre().substring(5) + " | 18 a 50";
			
			System.out.println(cat.nombre);
			new AddCategoria(cat).execute();
		}
	}

	private void poblarInscripciones(int num) {
		conectar();
		Random r = new Random();

		List<AtletaDto> atletas = new ListarAtletasArray().execute();
		List<CarreraDto> carreras = listarCarreras();

		for (AtletaDto atl : atletas) {
			System.out.println("id: " + atl.getIdAtleta());
		}

		try {

			int valor = 1;
			for (int j = 0; j < carreras.size(); j++) {
				PreparedStatement pst = conn.prepareStatement(SQLStrings.insertInscripcionValues);

				pst.setString(1, atletas.get(r.nextInt(Math.max(atletas.size() / 3, 1))).getIdAtleta());
				pst.setString(2, carreras.get(j).getIdCarrera());
				pst.setString(3, Integer.toString(j));
				pst.setDate(4, new java.sql.Date(new Date().getTime()));
				pst.setString(5, (r.nextBoolean() ? "Pre-Inscrito" : "Inscrito"));
				pst.setString(6, (r.nextBoolean() ? "Transferencia" : "Tarjeta"));
				int tiempo = r.nextInt(300);
				if (valor == 1) {
					tiempo = 0;
				}
				valor++;

				System.out.println("tiempo" + tiempo);
				pst.setString(7, Integer.toString(tiempo));

				// System.out.println("[ ] Insertada inscripcion " + j);
				pst.executeUpdate();
				pst.close();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public void poblarCarreras(int i) {
		conectar();
		Random r = new Random();
		try {
			for (int j = 0; j < i; j++) {
				PreparedStatement pst = conn.prepareStatement(SQLStrings.insertCarreraValues);

				java.sql.Date fechaFinInsc = new java.sql.Date(
						DateUtil.between(new Calendar.Builder().setDate(2021, 4, 1).build().getTime(),
								new Calendar.Builder().setDate(2022, 7, 1).build().getTime()).getTime());
				java.sql.Date fechaCarrera = new java.sql.Date(DateUtil.between(new Date(fechaFinInsc.getTime()),
						new Calendar.Builder().setDate(2023, 12, 31).build().getTime()).getTime());

				pst.setString(1, UUID.randomUUID().toString());
				pst.setString(2, "nombre" + UUID.randomUUID().toString().substring(0, 5));

				pst.setDate(3, fechaCarrera); // fecha origen

				pst.setString(4, (r.nextBoolean() ? "Asfalto" : "Montaña"));
				pst.setInt(5, r.nextInt(24) + 1); // distancia en km
				pst.setInt(6, r.nextInt(50) + 1); // cuota;

				pst.setDate(7, fechaFinInsc); // fecha fin insc

				int plazas0 = r.nextInt(6);
				pst.setInt(8, plazas0);
				pst.setInt(9, plazas0);

				pst.executeUpdate();
				pst.close();

				System.out.println("[  ] Insertada carrera " + j);
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
				PreparedStatement pst = conn.prepareStatement(SQLStrings.insertAtletaValues); // "insert into
																								// atleta(idAtleta, dni,
																								// nombre, edad, sexo,
																								// discapacitado, email)
																								// values (?, ?, ?, ?,
																								// ?, ?, ?)";
				pst.setString(1, UUID.randomUUID().toString());
				pst.setString(2, "dni" + UUID.randomUUID().toString().substring(0, 4));
				pst.setString(3, "nombre" + UUID.randomUUID().toString().substring(0, 4));
				pst.setInt(4, (r.nextInt(30) + 20));
				pst.setString(5, (r.nextBoolean() ? "M" : "F"));
				pst.setBoolean(6, r.nextBoolean());
				pst.setString(7, "email" + UUID.randomUUID().toString().substring(0, 4)); // pst.setString(7, "email" +
																							// UUID.randomUUID().toString().substring(0,
				// 4));

				pst.executeUpdate();
				pst.close();

				System.out.println("[  ] Insertado atleta " + j);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
		} finally {
			cerrar();
		}

	}

	

	

	public List<CarreraDto> listarCarreras() {
		List<CarreraDto> ret = null;
		conectar();

		try {
			pst = conn.prepareStatement(SQLStrings.selectAllCarrera);
			rs = pst.executeQuery();

			ret = DtoBuilder.toCarreraDtoList(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public Connection getConnection() {
		try {
			if (conn == null || conn.isClosed())
				conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void cerrarCon() {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void pruebasImportarTiempos() {
		insertarCarreraPredefinida();
		insertarAtletaPredefinido();
		insertarInscripcionPredefinida();
		
	}

	private void insertarInscripcionPredefinida() {
		conectar();
		try {
			pst = conn.prepareStatement(SQLStrings.insertInscripcionPredefinida);
			pst.setDate(1, new java.sql.Date(new Date().getTime()));
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cerrar();
		}
		
	}

	private void insertarAtletaPredefinido() {
		
			conectar();
			try {
				pst = conn.prepareStatement(SQLStrings.insertAtletaPredefinido);
				pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				cerrar();
			}
		
		
	}

	private void insertarCarreraPredefinida() {
		conectar();
		try {
			pst = conn.prepareStatement(SQLStrings.insertCarreraPredefinida);
			
			pst.setDate(1, java.sql.Date.valueOf("2022-03-31"));
			pst.setDate(2, java.sql.Date.valueOf("2023-03-31"));
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cerrar();
		}		
	}
}
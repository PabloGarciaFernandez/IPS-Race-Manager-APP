package gestorDB;

public class SQLStrings {
	
	/**
	 * Aqui ponemos todas las queries y luego las usamos con el nombre sin más, por tenerlas ordenadas
	 */
	
	
	//creates
	public static String createAtleta = ""
			+ "CREATE TABLE atleta "
			+ "(id integer primary key,"
			+ " dni text,"
			+ " nombre text,"
			+ " edad integer,"
			+ " fechaRegistro text,"
			+ " sexo text)";
	
	public static String createCarrera= ""
			+ "CREATE TABLE carrera "
			+ "(id integer primary key,"
			+ " nombre text,"
			+ " fecha text,"
			+ " tipo integer," //tipo tiene que ser foreign key de la tabla de tipos TIPOSCARRERA
			+ " fechaFinInscripcion text,"
			+ " plazas integer)";
	
	public static String createTipos= ""
			+ "CREATE TABLE tiposCarrera "
			+ "(id integer primary key,"
			+ " nombre text)";
	
	
	
	
	
	//inserts
	
	//fecha: text YYYY-MM-DD HH:MM:SS.SSS
	public static String insertCarreraEjemplo = ""
			+ "insert into carrera (nombre, fecha, tipo, fechaFinInscripcion, plazas) values "
			+ " ('Carrera de Ejemplo',"
			+ " '2021-11-03 15:00:00.000',"
			+ " 1,"
			+ " '2021-10-18 23:59:59.000',"
			+ " 32)";

	
	
	//selects
	public static String selectCarrera = "select * from carrera";
}

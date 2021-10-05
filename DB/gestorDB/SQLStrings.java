package gestorDB;

public class SQLStrings {

	/**
	 * Aqui ponemos todas las queries y luego las usamos con el nombre sin más, por
	 * tenerlas ordenadas
	 */

	// creates
	public static String createAtleta = "CREATE TABLE atleta (idAtleta varchar2 NOT NULL, dni varchar2 not null, nombre varchar2 not null, edad integer not null, sexo varchar not null, discapacitado bit NOT NULL, CONSTRAINT CHK_Atleta CHECK (edad >18 AND (sexo='M' OR sexo='F' OR sexo='NB')) , primary key (idAtleta))";

	public static String createInscripcion = "CREATE TABLE inscripcion (idAtleta varchar2 NOT NULL,idCarrera varchar NOT NULL, dorsal varchar2 NOT NULL, fechaInscripcion date not null, estadoInscripcion varchar2 not null, formaDePago varchar2 NOT NULL, CONSTRAINT CHK_Inscripcion CHECK ( (formaDePago='Transferencia' OR formaDePago='Tarjeta') AND (estadoInscripcion='Inscrito' OR estadoInscripcion='No inscrito' OR estadoInscripcion='Pendiente de pago')), primary key (idAtleta, idCarrera, dorsal), CONSTRAINT FK_idAtleta FOREIGN KEY (idAtleta) REFERENCES atleta(idAtleta), CONSTRAINT FK_idCarrera FOREIGN KEY (idCarrera) REFERENCES carrera(idCarrera) )";

	public static String createCarrera = "CREATE TABLE carrera (idCarrera varchar2 NOT NULL,tipo varchar2 NOT NULL, maxPlazas integer NOT NULL, CONSTRAINT CHK_Atleta CHECK (tipo = 'Asfalto' OR tipo = 'Montaña' ) , primary key (idCarrera))";

	// inserts

	public static String insterUsain = "Insert into atleta values('69','11122233A','Usain',25,'M',0); ";

	public static String insterNewYork = "Insert into carrera values('5','Asfalto',25); ";

	public static String insterInscripcion1 = "Insert into inscripcion values('70','5','007','2021-05-01','No inscrito', 'Tarjeta'); ";

	// fecha: text YYYY-MM-DD
	public static String AtletaEjemplo = "select * from atleta";

	public static String CarreaEjemplo = "select * from carrera";

	public static String InscripcionEjemplo = "select * from inscripcion";

	// selects
	public static String selectCarrera = "select * from carrera";
}

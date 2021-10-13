package ipsTeamwork.controller;

public class SQLStrings {

	/**
	 * Aqui ponemos todas las queries y luego las usamos con el nombre sin más, por
	 * tenerlas ordenadas
	 */

	// creates
	public static String createAtleta = "CREATE TABLE atleta (idAtleta varchar2 NOT NULL, dni varchar2 not null, nombre varchar2 not null, edad integer not null, sexo varchar not null, discapacitado bit NOT NULL, email varchar2 not null, CONSTRAINT CHK_Atleta CHECK (edad >18 AND (sexo='M' OR sexo='F' OR sexo='NB')) , primary key (idAtleta))";

	public static String createInscripcion = "CREATE TABLE inscripcion (idAtleta varchar2 NOT NULL, idCarrera varchar NOT NULL, dorsal varchar2, fechaInscripcion date not null, estadoInscripcion varchar2 not null, formaDePago varchar2 NOT NULL, tiempoCorriendo integer, CONSTRAINT CHK_Inscripcion CHECK ( (formaDePago='Transferencia' OR formaDePago='Tarjeta') AND (estadoInscripcion='Inscrito' OR estadoInscripcion='No inscrito' OR estadoInscripcion='Pendiente de pago')), primary key (idAtleta, idCarrera, dorsal), CONSTRAINT FK_idAtleta FOREIGN KEY (idAtleta) REFERENCES atleta(idAtleta), CONSTRAINT FK_idCarrera FOREIGN KEY (idCarrera) REFERENCES carrera(idCarrera) )";

	public static String createCarrera = "CREATE TABLE carrera (idCarrera varchar2, nombre varchar2, fecha date, tipo varchar2, distancia number, cuota number, fechaFinInsc date, plazasDisp number, maxPlazas number not null, CONSTRAINT chk_tipo CHECK (tipo = 'Asfalto' OR tipo = 'Montaña' ) , primary key (idCarrera))";

	// inserts

	public static String insertBolt = "Insert into atleta values('96','11122234A','Bolt',35,'F',0); ";

	public static String insertUsain = "Insert into atleta values('69','11122233A','Usain',25,'M',1); ";

	public static String insertNewYork = "Insert into carrera values('5','Asfalto',25); ";

	public static String insertInscripcion1 = "Insert into inscripcion values('96','5','009','2021-05-01','Inscrito', 'Tarjeta', 10); ";

	public static String insertInscripcion = "Insert into inscripcion values('69','3','008','2021-08-01','Inscrito', 'Transferencia', 320); ";

	public static String insterInscripcion2 = "Insert into inscripcion values('96','a0931d2e-cf27-4965-b395-a086aa0228a5','015','2021-05-01','Inscrito', 'Tarjeta'); ";

	public static String insertCarreraValues = "insert into carrera(idCarrera, nombre, fecha, tipo, distancia, cuota, fechaFinInsc, plazasDisp, maxPlazas) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static String insertAtletaValues = "insert into atleta(idAtleta, dni, nombre, edad, sexo, discapacitado, email) values (?, ?, ?, ?, ?, ?, ?)";

	public static String insertInscrpcionValues = "insert into inscripcion(idAtleta, idCarrera, dorsal, fechaInscripcion, estadoInscripcion, formaDePago, tiempoCorriendo) values (?, ?, ?, ?, ?, ?, ?)";

	// selects

	public static String selectAllAtleta = "select * from atleta";

	public static String selectAllCarrera = "select * from carrera";

	public static String selectAllInscripcion = "select * from inscripcion";

	public static String existeAtletaByEmail = "select * from atleta where email = ?";

	// Consulta para el metodo estadoInscripcion

	protected static String estadoInscipcion = "select * from inscripcion i where idCarrera = ? and estadoInscripcion = 'Inscrito' order by fechaInscripcion, estadoInscripcion";

	protected static String estadoInscipcionAtleta = "select * from atleta where idAtleta = ?";

	// Consultas para sacar las clasificaciones

	public static String clasificacionGeneralPresentados = "select a.sexo, a.nombre, i.tiempoCorriendo from atleta a, inscripcion i where a.idAtleta = i.idAtleta and i.tiempoCorriendo > 0 order by i.tiempoCorriendo";

	public static String clasificacionGeneralNoFinaliza = "select a.sexo, a.nombre, i.tiempoCorriendo from atleta a, inscripcion i where a.idAtleta = i.idAtleta and i.tiempoCorriendo = 0 order by a.nombre";

	public static String clasificacionGeneralNoPresentados = "select a.sexo, a.nombre from atleta a where a.idAtleta NOT IN (select idAtleta from inscripcion)  order by a.nombre";

	public static String clasificacionGeneralPresentadosHombres = "select a.sexo, a.nombre, i.tiempoCorriendo from atleta a, inscripcion i where a.idAtleta = i.idAtleta and i.tiempoCorriendo > 0 and a.sexo='M' order by i.tiempoCorriendo";

	public static String clasificacionGeneralNoFinalizaHombres = "select a.sexo, a.nombre, i.tiempoCorriendo from atleta a, inscripcion i where a.idAtleta = i.idAtleta and i.tiempoCorriendo = 0 and a.sexo='M' order by a.nombre";

	public static String clasificacionGeneralNoPresentadosHombres = "select a.sexo, a.nombre from atleta a where a.idAtleta NOT IN (select idAtleta from inscripcion)  and a.sexo='M' order by a.nombre";

	public static String clasificacionGeneralPresentadosMujeres = "select a.sexo, a.nombre, i.tiempoCorriendo from atleta a, inscripcion i where a.idAtleta = i.idAtleta and i.tiempoCorriendo > 0 and a.sexo='F' order by i.tiempoCorriendo";

	public static String clasificacionGeneralNoFinalizaMujeres = "select a.sexo, a.nombre, i.tiempoCorriendo from atleta a, inscripcion i where a.idAtleta = i.idAtleta and i.tiempoCorriendo = 0 and a.sexo='F' order by a.nombre";

	public static String clasificacionGeneralNoPresentadosMujeres = "select a.sexo, a.nombre from atleta a where a.idAtleta NOT IN (select idAtleta from inscripcion)  and a.sexo='F' order by a.nombre";

}
package ipsTeamwork.controller;

public class SQLStrings {

	public static String dropAtleta = "drop table atleta";
	public static String dropCarrera = "drop table carrera";
	public static String dropInscripcion = "drop table inscripcion";
	public static String dropCategoria = "drop table categoria";


	// creates
	public static String createAtleta = "CREATE TABLE atleta (idAtleta varchar2 NOT NULL, dni varchar2 not null, nombre varchar2 not null, edad integer not null, sexo varchar not null, discapacitado bit NOT NULL, email varchar2 not null, CONSTRAINT CHK_Atleta CHECK (edad >18 AND (sexo='M' OR sexo='F' OR sexo='NB')) , primary key (idAtleta), constraint unique_email UNIQUE (email))";

	public static String createInscripcion = "CREATE TABLE inscripcion (idAtleta varchar2 NOT NULL, idCarrera varchar NOT NULL, dorsal varchar2, fechaInscripcion date not null, estadoInscripcion varchar2 not null, formaDePago varchar2, tiempoCorriendo integer,  categoria varchar2, incidenciasPagos varchar2, CONSTRAINT CHK_Inscripcion CHECK ( (formaDePago='Transferencia' OR formaDePago='Tarjeta') AND (estadoInscripcion='Inscrito' OR estadoInscripcion='Pre-Inscrito' OR estadoInscripcion='Pendiente de Pago')), primary key (idAtleta, idCarrera, dorsal), CONSTRAINT FK_idAtleta FOREIGN KEY (idAtleta) REFERENCES atleta(idAtleta), CONSTRAINT FK_idCarrera FOREIGN KEY (idCarrera) REFERENCES carrera(idCarrera) )";

	public static String createCarrera = "CREATE TABLE carrera (idCarrera varchar2, nombre varchar2, fecha date, tipo varchar2, distancia number, cuota number, fechaFinInsc date, plazasDisp number, maxPlazas number not null, CONSTRAINT chk_tipo CHECK (tipo = 'Asfalto' OR tipo = 'Montaña' ) , primary key (idCarrera))";

	public static String createCategoria = "CREATE TABLE categoria (idCarrera varchar2, nombreCategoria varchar2, edadInicio integer, edadFin integer, primary key (idCarrera, nombreCategoria))";

	public static String createPago = "create table pago (idPago varchar2, idCarrera varchar2, dniAtleta varchar2, fecha date, importe number, primary key (idPago))";
	
	
	// inserts
	public static String insertAtletaPredefinido = "Insert into atleta values ('idMariano', 'dniMariano', 'Mariano Rajoy', 45, 'M', 1, 'mariano@gmail.com');";

	public static String insertCarreraPredefinida = "Insert into carrera values ('idMaratonMadrid', 'MaratonMadrid', ?, 'Asfalto', 100, 20, ?, 120, 120);";
	
	public static String insertInscripcionPredefinida = "Insert into inscripcion values ('idMariano', 'idMaratonMadrid', '1', ?, 'Inscrito', 'Tarjeta', 'NP', 'Veterano', '');";

	
	// inserts
	public static String insertBolt = "Insert into atleta values('69','11122234A','Bolt',35,'F',0, 'manolo@mnaolo'); ";

	public static String insertUsain = "Insert into atleta values('96','11122233A','Usain',25,'M',1); ";

	public static String insertNewYork = "Insert into carrera values('5','New York',?,'Asfalto',25,30,?,30,35); ";

	public static String insertInscripcion1 = "Insert into inscripcion values('96','5','009','2021-05-01','Inscrito', 'Tarjeta', 10); ";

	public static String insertInscripcion = "Insert into inscripcion values('69','5','008','2021-08-01','Inscrito', 'Transferencia', 320); ";

	public static String insterInscripcion2 = "Insert into inscripcion values('96','a0931d2e-cf27-4965-b395-a086aa0228a5','015','2021-05-01','Inscrito', 'Tarjeta'); ";

	public static String insertCarreraValues = "insert into carrera(idCarrera, nombre, fecha, tipo, distancia, cuota, fechaFinInsc, plazasDisp, maxPlazas) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	
	
	public static String insertAtletaValues = "insert into atleta(idAtleta, dni, nombre, edad, sexo, discapacitado, email) values (?, ?, ?, ?, ?, ?, ?)";
	
	public static String insertInscripcionValues = "insert into inscripcion(idAtleta, idCarrera, dorsal, fechaInscripcion, estadoInscripcion, formaDePago, tiempoCorriendo) values (?, ?, ?, ?, ?, ?, ?)";

	public static String insertCategoriaValues = "insert into categoria(idCarrera, nombreCategoria, edadInicio, edadFin) values (?, ?, ?, ?)";
	


	
	public static String selectAtletaById = "select * from atleta where idAtleta = ?";

	public static String selectAllAtleta = "select * from atleta";

	public static String selectAllCarrera = "select * from carrera";
	
	public static String selectAllPago = "select * from pago";

	public static String selectCarreraByNombre = "select * from carrera where nombre = ?";

	public static String selectAllInscripcion = "select * from inscripcion";

	public static String existeAtletaByEmail = "select * from atleta where email = ?";

	public static String estaLlenaLaLista = "select count(*) from inscripcion i where i.idcarrera = ?";
	
	public static String categoriaParticipante = "select * from categoria where idCarrera = ?";

	// Consulta para el metodo estadoInscripcion
	protected static String estadoInscripcion = "select * from inscripcion i where idCarrera = ? and estadoInscripcion = 'Inscrito' order by fechaInscripcion, estadoInscripcion";

	protected static String estadoInscripcionAtleta = "select * from atleta where idAtleta = ?";

	public static String atletaParticipanteDeCarrera = "select count(*) from inscripcion i where i.idAtleta = ? and i.idCarrera = ?";

	// Consultas para sacar las clasificaciones

	public static String clasificacionGeneralPrueba = "select i.idAtleta, i.idCarrera, i.tiempoCorriendo from inscripcion i where  i.tiempoCorriendo > 0 order by i.tiempoCorriendo";

	public static String selectInscripcionByIDCarrera = "select * from inscripcion where idCarrera = ? order by categoria, tiempoCorriendo";
	
	
	public static String clasificacionGeneralPresentados = "select a.sexo, a.nombre, i.tiempoCorriendo from atleta a, inscripcion i where a.idAtleta = i.idAtleta and i.tiempoCorriendo > 0  order by i.tiempoCorriendo";

	public static String clasificacionGeneralNoFinaliza = "select a.sexo, a.nombre, i.tiempoCorriendo from atleta a, inscripcion i where a.idAtleta = i.idAtleta and i.tiempoCorriendo = 0 order by a.nombre";

	public static String clasificacionGeneralNoPresentados = "select a.sexo, a.nombre from atleta a where a.idAtleta NOT IN (select idAtleta from inscripcion)  order by a.nombre";


}
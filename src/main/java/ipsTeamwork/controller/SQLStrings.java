package ipsTeamwork.controller;

public class SQLStrings {

	public static String dropAtleta = "drop table atleta";
	public static String dropCarrera = "drop table carrera";
	public static String dropInscripcion = "drop table inscripcion";
	public static String dropCategoria = "drop table categoria";

	// creates
	public static String createAtleta = "CREATE TABLE atleta (idAtleta varchar2 NOT NULL, dni varchar2 not null, nombre varchar2 not null, edad integer not null, sexo varchar not null, discapacitado bit NOT NULL, email varchar2 not null, CONSTRAINT CHK_Atleta CHECK (edad >18 AND (sexo='M' OR sexo='F' OR sexo='NB')) , primary key (idAtleta), constraint unique_email UNIQUE (email))";

	public static String createInscripcion = "CREATE TABLE inscripcion (idAtleta varchar2 NOT NULL, idCarrera varchar NOT NULL, dorsal varchar2, fechaInscripcion date not null, estadoInscripcion varchar2 not null, formaDePago varchar2, tiempoCorriendo integer,  categoria varchar2, incidenciasPagos varchar2, CONSTRAINT CHK_Inscripcion CHECK ( (formaDePago='Transferencia' OR formaDePago='Tarjeta') AND (estadoInscripcion='Inscrito' OR estadoInscripcion='Pre-Inscrito' OR estadoInscripcion='Pendiente de Pago')), primary key (idAtleta, idCarrera, dorsal), CONSTRAINT FK_idAtleta FOREIGN KEY (idAtleta) REFERENCES atleta(idAtleta), CONSTRAINT FK_idCarrera FOREIGN KEY (idCarrera) REFERENCES carrera(idCarrera) )";

	public static String createCarrera = "CREATE TABLE carrera (idCarrera varchar2, nombre varchar2, fecha date, fechaInicioIns date, tipo varchar2, distancia number, cuota number, fechaFinInsc date, plazasDisp number, maxPlazas number not null, listaDeEspera bit, CONSTRAINT chk_tipo CHECK (tipo = 'Asfalto' OR tipo = 'Montaña' ) , primary key (idCarrera))";

	public static String createCategoria = "CREATE TABLE categoria (idCarrera varchar2, nombreCategoria varchar2, edadInicio integer, edadFin integer, primary key (idCarrera, nombreCategoria))";

	public static String createPago = "create table pago (idPago varchar2, idCarrera varchar2, dniAtleta varchar2, fecha date, importe number, primary key (idPago))";

	public static String createListaEspera = "CREATE TABLE TListaEspera (idAtleta varchar2 NOT NULL, idCarrera varchar NOT NULL, fechaInscripcion date not null, posicion number not null, categoria varchar2, primary key (idAtleta,idCarrera), CONSTRAINT FK_idAtleta FOREIGN KEY (idAtleta) REFERENCES atleta(idAtleta), CONSTRAINT FK_idCarrera FOREIGN KEY (idCarrera) REFERENCES carrera(idCarrera) )";

	// inserts
	public static String insertAtletaPredefinido = "Insert into atleta values ('idMariano', 'dniMariano', 'Mariano Rajoy', 60, 'M', 1, 'mariano@gmail.com');";
	public static String insertAtletaPredefinido2 = "Insert into atleta values ('idPedro', 'dniPedro', 'Pedro Sánchez', 20, 'M', 1, 'pedro@gmail.com');";
	public static String insertAtletaPredefinido3 = "Insert into atleta values ('idSantiago', 'dniSantiago', 'Santiago Abascal', 20, 'M', 1, 'santiago@gmail.com');";
	public static String insertAtletaPredefinido4 = "Insert into atleta values ('idPablo', 'dniPablo', 'Pablo Iglesias', 34, 'M', 1, 'Pablo@gmail.com');";
	public static String insertAtletaPredefinido5 = "Insert into atleta values ('idCasado', 'dniCasado', 'Pablo Casado', 30, 'M', 1, 'Casado@gmail.com');";
	public static String insertAtletaPredefinido6 = "Insert into atleta values ('idAyuso', 'dniAyuso', 'Isabel Diaz Ayuso', 65, 'F', 1, 'Ayuso@gmail.com');";
	public static String insertAtletaPredefinido7 = "Insert into atleta values ('idZapatero', 'dniZapatero', 'Jose Luis Zapatero', 45, 'M', 1, 'Zapatero@gmail.com');";
	public static String insertAtletaPredefinido8 = "Insert into atleta values ('idThrall', 'dniThrall', 'Thrall', 30, 'M', 0, 'Thrall@gmail.com');";

	public static String insertCarreraPredefinida = "Insert into carrera values ('idMaratonMadrid', 'MaratonMadrid', ?,?, 'Asfalto', 100, 20, ?, 0, 6, 1);";

	public static String insertInscripcionPredefinida = "Insert into inscripcion values ('idMariano', 'idMaratonMadrid', '1', ?, 'Inscrito', 'Tarjeta', 'NP', 'Veterano', '');";
	public static String insertInscripcionPredefinida1 = "Insert into inscripcion values ('idPedro', 'idMaratonMadrid', '2', ?, 'Inscrito', 'Tarjeta', 'NP', 'Junior', '');";
	public static String insertInscripcionPredefinida2 = "Insert into inscripcion values ('idSantiago', 'idMaratonMadrid', '3', ?, 'Inscrito', 'Tarjeta', 'NP', 'Junior', '');";
	public static String insertInscripcionPredefinida3 = "Insert into inscripcion values ('idPablo', 'idMaratonMadrid', '4', ?, 'Inscrito', 'Tarjeta', 'NP', 'Junior', '');";
	public static String insertInscripcionPredefinida4 = "Insert into inscripcion values ('idCasado', 'idMaratonMadrid', '5', ?, 'Inscrito', 'Tarjeta', 'NP', 'Junior', '');";
	public static String insertInscripcionPredefinida5 = "Insert into inscripcion values ('idAyuso', 'idMaratonMadrid', '6', ?, 'Inscrito', 'Tarjeta', 'NP', 'Veterano', '');";

	public static String insertListaEsperaPredefinida = "Insert into TListaEspera values ('idZapatero', 'idMaratonMadrid', ?, 1, 'Veterano');";
	public static String insertListaEsperaPredefinida1 = "Insert into TListaEspera values ('idThrall', 'idMaratonMadrid', ?, 2, 'Veterano');";

	public static String insertCategoriaPredefinida1 = "Insert into categoria values ('idMaratonMadrid', 'Junior', 18, 35);";
	public static String insertCategoriaPredefinida2 = "Insert into categoria values ('idMaratonMadrid', 'Veterano', 36, 70);";

	// inserts
	public static String insertBolt = "Insert into atleta values('69','11122234A','Bolt',35,'F',0, 'manolo@mnaolo'); ";

	public static String insertUsain = "Insert into atleta values('96','11122233A','Usain',25,'M',1); ";

	public static String insertNewYork = "Insert into carrera values('5','New York',?,'Asfalto',25,30,?,30,35); ";

	public static String insertInscripcion1 = "Insert into inscripcion values('96','5','009','2021-05-01','Inscrito', 'Tarjeta', 10); ";

	public static String insertInscripcion = "Insert into inscripcion values('69','5','008','2021-08-01','Inscrito', 'Transferencia', 320); ";

	public static String insterInscripcion2 = "Insert into inscripcion values('96','a0931d2e-cf27-4965-b395-a086aa0228a5','015','2021-05-01','Inscrito', 'Tarjeta'); ";

	public static String insertCarreraValues = "insert into carrera(idCarrera, nombre, fecha,fechaInicioIns, tipo, distancia, cuota, fechaFinInsc, plazasDisp, maxPlazas, listaDeEspera) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static String insertCarreraValuesNuevo = "insert into carrera(idCarrera, nombre, fecha,fechaInicioIns , tipo, distancia, cuota, fechaFinInsc, plazasDisp, maxPlazas) values (?, ?, ?, ?,?, ?, ?, ?, ?, ?)";

	public static String insertAtletaValues = "insert into atleta(idAtleta, dni, nombre, edad, sexo, discapacitado, email) values (?, ?, ?, ?, ?, ?, ?)";

	public static String insertInscripcionValues = "insert into inscripcion(idAtleta, idCarrera, dorsal, fechaInscripcion, estadoInscripcion, formaDePago, tiempoCorriendo) values (?, ?, ?, ?, ?, ?, ?)";

	public static String insertListaEsperaValues = "insert into TListaEspera(idAtleta, idCarrera, fechaInscripcion, categoria, posicion) values (?, ?, ?, ?, ?)";

	public static String insertCategoriaValues = "insert into categoria(idCarrera, nombreCategoria, edadInicio, edadFin) values (?, ?, ?, ?)";

	// select

	public static String selectAtletaById = "select * from atleta where idAtleta = ?";

	public static String selectAllAtleta = "select * from atleta";

	public static String selectAllCarrera = "select * from carrera";

	public static String selectAllPago = "select * from pago";

	public static String selectCarreraByNombre = "select * from carrera where nombre = ?";

	public static String selectAllInscripcion = "select * from inscripcion";

	public static String existeAtletaByEmail = "select * from atleta where email = ?";

	public static String estaLlenaLaLista = "select count(*) from inscripcion i where i.idcarrera = ?";

	public static String categoriaParticipante = "select * from categoria where idCarrera = ?";

	public static String selectCarreraById = "select * from carrera where idCarrera = ?";

	// Consulta para el metodo listaEspera
	protected static String estadoListaEspera = "select * from TListaEspera i where idCarrera = ? order by fechaInscripcion";

	public static String findListaEspera = "select * from TListaEspera i where i.idAtleta = ? and i.idCarrera = ?";

	public static String findListaEsperaByCarrera = "select * from TListaEspera i where i.idCarrera = ?";

	// Consulta para el metodo estadoInscripcion
	public static String inscripcionesPorCarrera = "select * from inscripcion i where idCarrera = ?";

	protected static String estadoInscripcion = "select * from inscripcion i where idCarrera = ? and estadoInscripcion = 'Inscrito' order by fechaInscripcion, estadoInscripcion";

	protected static String estadoInscripcionAtleta = "select * from atleta where idAtleta = ?";

	public static String atletaParticipanteDeCarrera = "select count(*) from inscripcion i where i.idAtleta = ? and i.idCarrera = ?";

	// Update Inscripciones

	public static String updateDorsales = "Update inscripcion set dorsal = ? where idCarrera = ? and idAtleta = ?";

	// count atletas inscritos

	protected static String numAtletasInscritosXCarrera = "select count(*) as cont from inscripcion where idCarrera = ? and estadoInscripcion = 'Inscrito'";

	// count atletas inscritos

	protected static String listaAtletasInscritosEnXCarrera = "select a.* from inscripcion i, atleta a where idCarrera = ? and a.idAtleta = i.idAtleta and estadoInscripcion = 'Inscrito' order by fechaInscripcion";

	// Consultas para sacar las clasificaciones

	public static String clasificacionGeneralPrueba = "select i.idAtleta, i.idCarrera, i.tiempoCorriendo from inscripcion i where  i.tiempoCorriendo > 0 order by i.tiempoCorriendo asc";

	public static String selectInscripcionByIDCarrera = "select * from inscripcion where idCarrera = ? order by categoria, tiempoCorriendo";

	public static String clasificacionGeneralPresentados = "select a.sexo, a.nombre, i.tiempoCorriendo from atleta a, inscripcion i where a.idAtleta = i.idAtleta and i.tiempoCorriendo > 0  order by i.tiempoCorriendo";

	public static String clasificacionGeneralNoFinaliza = "select a.sexo, a.nombre, i.tiempoCorriendo from atleta a, inscripcion i where a.idAtleta = i.idAtleta and i.tiempoCorriendo = 0 order by a.nombre";

	public static String clasificacionGeneralNoPresentados = "select a.sexo, a.nombre from atleta a where a.idAtleta NOT IN (select idAtleta from inscripcion)  order by a.nombre";

}
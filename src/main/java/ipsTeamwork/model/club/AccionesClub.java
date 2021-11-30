package ipsTeamwork.model.club;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import ipsTeamwork.controller.GestorDB;
import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.model.atleta.crud.AddAtleta;
import ipsTeamwork.model.atleta.crud.FindAtletaByEmail;
import ipsTeamwork.model.atleta.crud.FindAtletaInCarrera;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.model.carrera.crud.UpdateCarrera;
import ipsTeamwork.model.inscripcion.InscripcionDto;
import ipsTeamwork.model.inscripcion.crud.InscribirseAtleta;
import ipsTeamwork.util.DtoBuilder;
import ipsTeamwork.util.Parser;

public class AccionesClub {
	public static List<AtletaDto> inscribirLote(File f, CarreraDto carrera, String nombreClub) throws Exception {
		List<AtletaDto> atletas = Parser.parseListaAtletas(f, true);
		return inscribirLote(atletas, carrera, nombreClub);
	}

	public static List<AtletaDto> inscribirLote(List<AtletaDto> atletas, CarreraDto carrera, String nombreClub)
			throws Exception {

		System.out.println("\n\n\t\tINSCRIBIENDO CLUB " + nombreClub + " EN LA CARRERA " + carrera.getNombre() + "\n");

		List<AtletaDto> noInscritos = new ArrayList<AtletaDto>();

		for (int i = 0; i < atletas.size(); i++) {
			AtletaDto a = dbIngresoAtleta(atletas.get(i), carrera, nombreClub);
			if (a != null)
				noInscritos.add(a);
		}

		System.out.println("\n\t\tCLUB INSCRITO\n\n");

		new GestorDB().selectAtletas();
		new GestorDB().selectInscripcion();

		return noInscritos;
	}

	private static AtletaDto dbIngresoAtleta(AtletaDto atleta, CarreraDto carreraActual, String nombreClub) {
		if (carreraActual.getPlazasDisp() == 0)
			return atleta;

		AtletaDto encontrado = new FindAtletaByEmail().execute(atleta.getEmail());

		if (encontrado.getIdAtleta() == null) { // si el atleta directamente no existe
			atleta.setIdAtleta(UUID.randomUUID().toString()); // se le da un id y se inscribe

			new AddAtleta(atleta).execute2();

			System.out.println("Inscribiendo en lote: " + atleta.toString());

			InscripcionDto inscripcion = DtoBuilder.ParamsToInscripcionDto(atleta, carreraActual,
					UUID.randomUUID().toString().substring(0, 3), "Inscrito-Club", new Date(), null);
			inscripcion.setClub(nombreClub);

			new InscribirseAtleta().execute(inscripcion);
			carreraActual.setPlazasDisp(carreraActual.getPlazasDisp() - 1);
			new UpdateCarrera().execute(carreraActual);

		} else { // si sí existe en la base de datos
			if (new FindAtletaInCarrera().execute(encontrado.getIdAtleta(), carreraActual.getIdCarrera())) { // y no
																												// está
																												// inscrito
				System.out.println("Inscribiendo en lote: " + atleta.toString()); // se le inscribe

				InscripcionDto inscripcion = DtoBuilder.ParamsToInscripcionDto(atleta, carreraActual,
						UUID.randomUUID().toString().substring(0, 3), "Inscrito-Club", new Date(), null);
				inscripcion.setClub(nombreClub);

				new InscribirseAtleta().execute(inscripcion);
				new GestorDB().bajarPlazasPublic(carreraActual);
				new UpdateCarrera().execute(carreraActual);
			} else {
				cambiarInscripcionAInscritoClub(encontrado, carreraActual);
			}
		}

		return null;
	}

	private static void cambiarInscripcionAInscritoClub(AtletaDto atletaSinId, CarreraDto carreraActual) {
		GestorDB gdb = new GestorDB();

		gdb.updateInscripcionStatusIncidencia(atletaSinId, carreraActual, "Inscrito-Club",
				"Devolver " + Float.toString(carreraActual.getCuota()));
	}
}
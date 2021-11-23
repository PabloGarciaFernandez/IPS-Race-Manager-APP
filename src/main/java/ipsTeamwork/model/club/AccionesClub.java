package ipsTeamwork.model.club;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.model.atleta.crud.FindAtletaInCarrera;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.model.carrera.crud.UpdateCarrera;
import ipsTeamwork.model.inscripcion.InscripcionDto;
import ipsTeamwork.model.inscripcion.crud.InscribirseAtleta;
import ipsTeamwork.util.DtoBuilder;
import ipsTeamwork.util.Parser;

public class AccionesClub {
	public static void inscribirLote(File f, CarreraDto carrera) throws Exception {
		List<AtletaDto> atletas = Parser.parseListaAtletas(f, true);
		
		if (atletas.size() > carrera.getMaxPlazas()) {
			throw new Exception("No caben");
		}
		
		System.out.println("\t\tINSCRIBIENDO CLUB\n");
		
		for (int i = 0; i < atletas.size(); i++) {
			dbIngresoAtleta(atletas.get(i), carrera);
		}
		System.out.println("\t\tCLUB INSCRITO\n");
	}
	
	private static void dbIngresoAtleta(AtletaDto atletaSinId, CarreraDto carreraActual) {
		if (new FindAtletaInCarrera().execute(atletaSinId.getIdAtleta(), carreraActual.getIdCarrera())) {
			
			System.out.println("Inscribiendo en lote: " + atletaSinId.toString());
			
			InscripcionDto inscripcion = DtoBuilder.ParamsToInscripcionDto(atletaSinId, carreraActual,
					UUID.randomUUID().toString().substring(0, 3), "Inscrito-Club", new Date(), null);
			new InscribirseAtleta().execute(inscripcion);
			
			carreraActual.setPlazasDisp(carreraActual.getPlazasDisp() - 1);
			new UpdateCarrera().execute(carreraActual);

		} else {
			throw new RuntimeException("sin implementar");
			//si el atleta ya está metido
		}

	}
}

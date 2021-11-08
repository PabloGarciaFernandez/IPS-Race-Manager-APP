/**
 * 
 */
package ipsTeamwork.model.categoria;

import java.util.List;

import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.model.categoria.crud.FindCategoria;

import ipsTeamwork.model.atleta.AtletaDto;

public class Categoria {

	public static String calculaCategoria(AtletaDto at, CarreraDto ca) {
		List<CategoriaDto> cat = new FindCategoria(ca.getIdCarrera()).execute();
		
		for(CategoriaDto c : cat) {
			
			if(at.getEdad() > c.edadInic && at.getEdad() <= c.edadFin) {
				return c.nombre;
			}
		}

		return "SIN CATEGORIA";

	}

}

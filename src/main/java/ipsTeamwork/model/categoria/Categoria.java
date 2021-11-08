/**
 * 
 */
package ipsTeamwork.model.categoria;

import java.util.List;

import ipsTeamwork.model.atleta.AtletaDto;
import ipsTeamwork.model.carrera.CarreraDto;
import ipsTeamwork.model.categoria.crud.FindCategoria;

/**
 * @author Sergio Arroni
 *
 */
public class Categoria {

	public static String calculaCategoria(AtletaDto at, CarreraDto ca) {
		List<CategoriaDto> cat = new FindCategoria().execute(ca.getIdCarrera());
		
		for(CategoriaDto c : cat) {
			if(at.getEdad() > c.edadInic && at.getEdad() <= c.edadFin) {
				return c.nombre;
			}
		}
		return "SIN CATEGORIA";
	}

}

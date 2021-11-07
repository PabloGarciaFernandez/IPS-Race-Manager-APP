/**
 * 
 */
package ipsTeamwork.model.categoria;

import javax.management.RuntimeErrorException;

import ipsTeamwork.model.atleta.AtletaDto;

/**
 * @author Sergio Arroni
 *
 */
public class Categoria {

	public static String calculaCategoria(int edad, String sexo) {

		if (edad >= 18 && edad <= 20) {
			return "Benjamin - Entre 18 y 20 / " + sexo;
		} else if (edad > 20 && edad <= 30) {
			return "Cadete - Entre 21 y 30 / " + sexo;
		} else if (edad > 30 && edad <= 40) {
			return "Juvenil - Entre 31 y 40 / " + sexo;
		} else if (edad > 40 && edad <= 50) {
			return "Promesa - Entre 41 y 50 / " + sexo;
		} else if (edad > 50 && edad <= 60) {
			return "Senior - Entre 51 y 60 / " + sexo;
		} else if (edad > 50 && edad <= 70) {
			return "Master - Entre 61 y 70 / " + sexo;
		} else if (edad > 70) {
			return "Veteranos - Desde 71 / " + sexo;
		}
		
		//select from categoria where 
		throw new RuntimeErrorException(new Error(), "Algo malo paso con la categoria");
	}

}
